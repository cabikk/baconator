package com.atlasgroup.baconator.service;

import java.util.UUID;
import org.springframework.stereotype.Service;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;



@Service
public class BaconServiceImpl implements BaconService {

  @Override
  public String getBacon(int quantity) {
    
    StringBuffer result = new StringBuffer();
    Observable.just("io", "pip")
    .subscribeOn(Schedulers.io())
    .subscribe(i -> result.append(Thread.currentThread().getName()));
    
    
    return String.valueOf(quantity+": "+UUID.randomUUID().toString()+"\n"+result.toString());
  }


}
