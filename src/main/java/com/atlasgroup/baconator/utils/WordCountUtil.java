package com.atlasgroup.baconator.utils;

import java.text.BreakIterator;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.atlasgroup.baconator.service.StatisticsService;

@Component
public class WordCountUtil {

  @Autowired
  private StatisticsService statisticsService;

  public void processWordsBreak(String data) {

    if (data != null) {
      BreakIterator iterator = BreakIterator.getWordInstance(Locale.ENGLISH);
      iterator.setText(data);

      System.out.println();

      int lastIndex = iterator.first();
      while (lastIndex != BreakIterator.DONE) {
        int firstIndex = lastIndex;
        lastIndex = iterator.next();

        if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(data.charAt(firstIndex))) {
          statisticsService.addWord(data.substring(firstIndex, lastIndex));
        }
      }
    }

  }

}
