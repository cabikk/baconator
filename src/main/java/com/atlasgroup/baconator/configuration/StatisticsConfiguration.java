package com.atlasgroup.baconator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.atlasgroup.baconator.model.Statistics;

@Configuration
public class StatisticsConfiguration {

  @Bean
  public Statistics createStatistics() {
    return new Statistics();
  }
}
