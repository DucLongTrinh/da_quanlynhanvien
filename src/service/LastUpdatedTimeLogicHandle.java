package service;

import entity.LastUpdatedTime;

import java.util.ArrayList;
import java.util.List;

public class LastUpdatedTimeLogicHandle {
  private List<LastUpdatedTime> updates;

  public LastUpdatedTimeLogicHandle() {
    this.updates = new ArrayList<>();
  }

  // Thêm cập nhật mới
  public void addUpdate(String updatedBy, String updateReason) {
    LastUpdatedTime lastUpdatedTime = new LastUpdatedTime(updatedBy, updateReason);
    updates.add(lastUpdatedTime);
  }

  // Hiển thị tất cả các lần cập nhật
  public void displayAllUpdates() {
    for (LastUpdatedTime update : updates) {
      System.out.println("Cập nhật bởi: " + update.getUpdatedBy() +
          ", Lý do: " + update.getUpdateReason() +
          ", Thời gian: " + update.getLastUpdated());
    }
  }
}