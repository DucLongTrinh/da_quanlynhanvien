package service;

import entity.Employee;
import entity.SalaryHistory;

import java.util.ArrayList;
import java.util.List;

public class SalaryHistoryLogicHandle {
  private List<SalaryHistory> salaryHistories;

  public SalaryHistoryLogicHandle() {
    this.salaryHistories = new ArrayList<>();
  }

  // Thêm lịch sử lương cho nhân viên
  public void addSalaryHistory(SalaryHistory salaryHistory) {
    salaryHistories.add(salaryHistory);
  }

  // Hiển thị tất cả lịch sử lương
  public void displayAllSalaryHistories() {
    for (SalaryHistory history : salaryHistories) {
      System.out.println(history); // Sử dụng phương thức toString đã có trong SalaryHistory
    }
  }

  // Tìm kiếm lịch sử lương theo nhân viên
  public SalaryHistory getSalaryHistoryByEmployee(Employee employee) {
    for (SalaryHistory history : salaryHistories) {
      if (history.getEmployee().equals(employee)) {
        return history;
      }
    }
    return null; // Trả về null nếu không tìm thấy
  }
}