package entity;

import java.time.LocalDate;

public class Leave {

  private LocalDate startDate;
  private LocalDate endDate;
  private String reason;
  private String approvalStatus;

  public Leave(LocalDate startDate, LocalDate endDate, String reason) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.reason = reason;
    this.approvalStatus = "Pending"; // Trạng thái mặc định khi tạo yêu cầu
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

  public String getApprovalStatus() {
    return approvalStatus;
  }

  public void setApprovalStatus(String approvalStatus) {
    this.approvalStatus = approvalStatus;
  }

  // Phương thức hiển thị thông tin ngày nghỉ
  public void displayLeaveInfo() {
    System.out.println("Từ ngày: " + startDate + " đến ngày: " + endDate +
        ", Lý do: " + reason +
        ", Trạng thái: " + approvalStatus);
  }

}