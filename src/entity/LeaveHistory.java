package entity;

import java.time.LocalDate;

public class LeaveHistory { // quản lý lịch sử các lần nghỉ phép mà nhân viên đã trải qua, bao gồm thông tin chi tiết như thời gian, lý do nghỉ, và trạng thái của các yêu cầu nghỉ phép.
  private LocalDate startDate;
  private LocalDate endDate;
  private String reason;
  private boolean approved; // Trạng thái phê duyệt

  public LeaveHistory(LocalDate startDate, LocalDate endDate, String reason, boolean approved) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.reason = reason;
    this.approved = approved;
  }

  // Getter và Setter
  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public boolean isApproved() {
    return approved;
  }

  public void setApproved(boolean approved) {
    this.approved = approved;
  }
}
