package service;


import entity.Attendance;
import java.time.Duration;

public class AttendanceLogicHandle {

  // Method để ghi nhận thời gian vào làm
  public void checkIn(Attendance attendance) {
    attendance.checkIn();
  }

  // Method để ghi nhận thời gian ra về
  public void checkOut(Attendance attendance) {
    attendance.checkOut();
  }

  // Method để xuất thông tin chấm công
  public void displayAttendanceInfo(Attendance attendance) {
    attendance.displayAttendanceInfo();
  }

  // Method để lấy tổng số giờ làm việc
  public Duration getTotalHoursWorked(Attendance attendance) {
    return attendance.getTotalHoursWorked();
  }

}
