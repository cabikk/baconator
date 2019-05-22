package com.atlasgroup.baconator.aspects;

import java.util.List;
import java.util.Optional;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.atlasgroup.baconator.model.BaconExchange;
import com.atlasgroup.baconator.model.BaconItem;
import com.atlasgroup.baconator.service.StatisticsService;
import com.atlasgroup.baconator.utils.WordCountUtil;

@Aspect
@Component
public class WordCountAspect {

  @Autowired
  private StatisticsService statisticsService;

  @AfterReturning(pointcut = "@annotation(WordCount)", returning = "retVal")
  public void countWordHistogram(Object retVal) throws Throwable {

    Optional<List<BaconItem>> baconsListOptional =
        Optional.ofNullable(retVal).filter(BaconExchange.class::isInstance)
            .map(BaconExchange.class::cast).map(BaconExchange::getItems);

    if (baconsListOptional.isPresent())
      baconsListOptional.get()
          .forEach(item -> WordCountUtil.processWordsBreak(item.getData(), statisticsService));

  }

}

