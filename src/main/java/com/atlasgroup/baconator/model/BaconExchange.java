package com.atlasgroup.baconator.model;

import java.util.List;

public class BaconExchange {

  private String runId;
  private long start;
  private long end;
  private List<BaconItem> items;

  public String getRunId() {
    return runId;
  }

  public void setRunId(String runId) {
    this.runId = runId;
  }

  public long getStart() {
    return start;
  }

  public void setStart(long start) {
    this.start = start;
  }

  public long getEnd() {
    return end;
  }

  public void setEnd(long end) {
    this.end = end;
  }

  public List<BaconItem> getItems() {
    return items;
  }

  public void setItems(List<BaconItem> items) {
    this.items = items;
  }

}
