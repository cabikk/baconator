package com.atlasgroup.baconator.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Statistics {
  
  private Map<String, Integer> requestsPerIP = new ConcurrentHashMap<String, Integer>();

  public Map<String, Integer> getRequestsPerIP() {
    return requestsPerIP;
  }

  public void setRequestsPerIP(Map<String, Integer> requestsPerIP) {
    this.requestsPerIP = requestsPerIP;
  }

}
