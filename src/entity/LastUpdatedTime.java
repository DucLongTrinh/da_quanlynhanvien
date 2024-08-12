package entity;

import java.time.LocalDateTime;

public class LastUpdatedTime { // Theo dõi thời gian cập nhật thông tin của nhân viên

  private LocalDateTime lastUpdated;
  private String updatedBy; // Người thực hiện cập nhật
  private String updateReason; // Lý do cập nhật

  // Constructor mặc định

  public LastUpdatedTime(String updatedBy, String updateReason) {
    this.lastUpdated = LocalDateTime.now(); // Khởi tạo với thời gian hiện tại
    this.updatedBy = updatedBy;
    this.updateReason = updateReason;
  }

  // Method cập nhật thời gian, người thực hiện và lý do
  public void update(String updatedBy, String updateReason) {
    this.lastUpdated = LocalDateTime.now(); // Cập nhật thời gian
    this.updatedBy = updatedBy; // Cập nhật người thực hiện
    this.updateReason = updateReason; // Cập nhật lý do
  }

  // Getter cho lastUpdated
  public LocalDateTime getLastUpdated() {
    return lastUpdated;
  }

  // Getter cho updatedBy
  public String getUpdatedBy() {
    return updatedBy;
  }

  // Getter cho updateReason
  public String getUpdateReason() {
    return updateReason;
  }

}
