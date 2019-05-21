package com.atlasgroup.baconator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.atlasgroup.baconator.model.Statistics;

@SpringBootApplication
public class BaconatorApplication {

  @Bean
  public Statistics createStatistics() {
    return new Statistics();
  }

  public static void main(String[] args) {
    SpringApplication.run(BaconatorApplication.class, args);
  }

}
