package com.atlasgroup.baconator.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Statistics {

  private Map<String, Integer> wordsCount =
      new ConcurrentSkipListMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
  private Map<String, Integer> requestsPerIP = new ConcurrentHashMap<String, Integer>();

  public Map<String, Integer> getWordsCount() {
    return wordsCount;
  }

  public Map<String, Integer> getRequestsPerIP() {
    return requestsPerIP;
  }

  public void setRequestsPerIP(Map<String, Integer> requestsPerIP) {
    this.requestsPerIP = requestsPerIP;
  }

}
