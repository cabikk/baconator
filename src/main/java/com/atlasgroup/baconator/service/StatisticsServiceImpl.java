package com.atlasgroup.baconator.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atlasgroup.baconator.model.Statistics;

@Service
public class StatisticsServiceImpl implements StatisticsService{
  
  private Statistics statistics;
  
  @Autowired
  public StatisticsServiceImpl(Statistics statistics) {
    this.statistics = statistics;
  }

  @Override
  public void addRequestPerIP(String ip) {
    
    Map<String, Integer> requestsPerIP = statistics.getRequestsPerIP();
    
    if(requestsPerIP.containsKey(ip))
      requestsPerIP.put(ip, requestsPerIP.get(ip)+1);
    else
      requestsPerIP.put(ip, 1);
    
  }

  @Override
  public Statistics getStatistics() {
    
    return statistics;
  }

}
