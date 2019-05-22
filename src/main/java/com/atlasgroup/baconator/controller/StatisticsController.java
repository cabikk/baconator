package com.atlasgroup.baconator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.atlasgroup.baconator.model.Statistics;
import com.atlasgroup.baconator.service.StatisticsService;
import com.atlasgroup.baconator.utils.ErrorType;

@RestController
public class StatisticsController {

  @Autowired
  private StatisticsService statisticsService;

  @RequestMapping("/statistics")
  public ResponseEntity<Object> getStatistics() {
    Statistics statistics = statisticsService.getStatistics();
    if (statistics == null) {
      return new ResponseEntity<>(new ErrorType("There is no statistics."), HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(statistics, HttpStatus.OK);

  }

}
