package com.atlasgroup.baconator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.atlasgroup.baconator.service.StatisticsService;

@RestController
public class StatisticsController {
  
  @Autowired
  private StatisticsService statisticsService;
  
  @RequestMapping("/statistics")
  public ResponseEntity<Object> getStatistics() {

    return new ResponseEntity<>(statisticsService.getStatistics(), HttpStatus.OK);

  }

}
