package entity;

import java.time.LocalDate;

public class WorkHistory { // Lưu trữ lịch sử làm việc của nhân viên
  private LocalDate date;
  private String description;

  public WorkHistory(LocalDate date, String description) {
    this.date = date;
    this.description = description;
  }

  @Override
  public String toString() {
    return "Ngày: " + date + ", Mô tả: " + description;
  }
}
