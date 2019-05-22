package com.atlasgroup.baconator.utils;

import java.text.BreakIterator;
import java.util.Locale;
import com.atlasgroup.baconator.service.StatisticsService;

public class WordCountUtil {

  public static void processWordsBreak(String data, StatisticsService statisticsService) {

    if (data != null) {
      BreakIterator iterator = BreakIterator.getWordInstance(Locale.ENGLISH);
      iterator.setText(data);

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
