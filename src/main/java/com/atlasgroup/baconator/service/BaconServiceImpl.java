package com.atlasgroup.baconator.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.atlasgroup.baconator.aspects.WordCount;
import com.atlasgroup.baconator.model.BaconExchange;
import com.atlasgroup.baconator.model.BaconItem;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

@Service
public class BaconServiceImpl implements BaconService {

  private static final String BACON_URI = "https://baconipsum.com/api/?type=all-meat&paras=1";
  private static final Logger logger = LoggerFactory.getLogger(BaconServiceImpl.class);

  @Override
  @WordCount
  public BaconExchange getBacon(int quantity) {

    BaconExchange baconExchange = new BaconExchange();
    baconExchange.setRunId(UUID.randomUUID().toString());
    baconExchange.setStart(new Date().getTime());

    List<Observable<BaconItem>> observableBaconItem = new LinkedList<Observable<BaconItem>>();
    for (int i = 0; i < quantity; i++)
      observableBaconItem
          .add(Observable.just(i).subscribeOn(Schedulers.io()).map(m -> getSingleBacon()));

    if (observableBaconItem.size() > 0) {
      Observable<List<BaconItem>> results = Observable.zip(observableBaconItem, objects -> {
        List<BaconItem> resultList =
            Stream.of(objects).map(BaconItem.class::cast).collect(Collectors.toList());
        return resultList;
      });

      baconExchange.setItems(results.blockingFirst());
    }
    baconExchange.setEnd(new Date().getTime());

    return baconExchange;
  }

  private BaconItem getSingleBacon() {

    BaconItem baconItem = new BaconItem();
    baconItem.setStart(new Date().getTime());

    HttpClient client = HttpClient.newHttpClient();

    try {
      HttpRequest request = HttpRequest.newBuilder().uri(new URI(BACON_URI)).build();

      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      if (response.statusCode() == 200)
        baconItem.setData(response.body());
    } catch (URISyntaxException | IOException | InterruptedException e) {
      logger.error(e.getMessage());
    }

    baconItem.setEnd(new Date().getTime());

    return baconItem;
  }

}
