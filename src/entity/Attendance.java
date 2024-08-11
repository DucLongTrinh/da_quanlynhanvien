package entity;

import java.time.LocalDateTime;
import java.time.Duration;

public class Attendance { // lưu trữ thông tin về sự có mặt của nhân viên (chấm công)

  private Employee employee; // Đối tượng nhân viên
  private LocalDateTime checkInTime; // Thời gian vào làm
  private LocalDateTime checkOutTime; // Thời gian ra về
  private Duration totalHoursWorked; // Tổng số giờ làm việc


  // Constructor

  public Attendance(Employee employee) {
    this.employee = employee; // Gán đối tượng nhân viên
    this.checkInTime = null;
    this.checkOutTime = null;
    this.totalHoursWorked = Duration.ZERO; // Khởi tạo tổng số giờ làm việc bằng 0
  }

  // Getter cho các thuộc tính


  public Employee getEmployee() {
    return employee;
  }

  public LocalDateTime getCheckInTime() {
    return checkInTime;
  }

  public LocalDateTime getCheckOutTime() {
    return checkOutTime;
  }

  public Duration getTotalHoursWorked() {
    return totalHoursWorked;
  }

  // Method để ghi lại thời gian vào làm
  public void checkIn() {
    this.checkInTime = LocalDateTime.now(); // Ghi nhận thời gian vào làm
  }


  public void checkOut() {
    if (this.checkInTime == null) {
      throw new IllegalStateException("Chưa ghi nhận thời gian vào làm."); // Kiểm tra thời gian vào làm
    }
    this.checkOutTime = LocalDateTime.now(); // Ghi nhận thời gian ra về
    calculateTotalHoursWorked(); // Tính tổng số giờ làm việc
  }


  // Method tính tổng số giờ làm việc


  private void calculateTotalHoursWorked() {
    if (this.checkOutTime != null && this.checkInTime != null) {
      this.totalHoursWorked = Duration.between(this.checkInTime, this.checkOutTime); // Tính tổng số giờ
    }
  }

  // Method để xuất thông tin chấm công
  public void displayAttendanceInfo() {
    System.out.println("Mã Nhân Viên: " + employee.getId());
    System.out.println("Tên Nhân Viên: " + employee.getName());
    System.out.println("Thời gian vào làm: " + (checkInTime != null ? checkInTime : "Chưa ghi nhận"));
    System.out.println("Thời gian ra về: " + (checkOutTime != null ? checkOutTime : "Chưa ghi nhận"));
    System.out.println("Tổng số giờ làm việc: " + (totalHoursWorked.toHours() + " giờ " +
        totalHoursWorked.toMinutesPart() + " phút"));
  }

}
