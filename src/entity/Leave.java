package entity;

import java.time.LocalDate;

public class Leave { // mô tả thông tin về các ngày nghỉ phép của nhân viên
  private LocalDate startDate;
  private LocalDate endDate;
  private String reason;

  // constructor
  public Leave(LocalDate startDate, LocalDate endDate, String reason) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.reason = reason;
  }

  public void displayLeaveInfo() {
    System.out.println("Ngày nghỉ: " + startDate + " đến " + endDate + ", Lý do: " + reason);
  }

  // Getters and Setters


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
}
