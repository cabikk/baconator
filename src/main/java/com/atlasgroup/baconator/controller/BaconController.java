package com.atlasgroup.baconator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.atlasgroup.baconator.service.BaconService;

@RestController
public class BaconController {

  @Autowired
  private BaconService baconService;

  @RequestMapping("/give-me-bacon/{howmuch:[0-9]+}")
  public ResponseEntity<Object> getBacon(@PathVariable("howmuch") int quantity) {

    return new ResponseEntity<>(baconService.getBacon(quantity), HttpStatus.OK);

  }

}
