package com.atlasgroup.baconator.service;

import com.atlasgroup.baconator.model.Statistics;

public interface StatisticsService {
  void addWord(String word);

  void addRequestPerIP(String ip);

  Statistics getStatistics();
}
