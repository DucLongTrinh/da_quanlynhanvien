package service;

import entity.Employee;
import entity.SalaryChangeHistory;

import java.util.ArrayList;
import java.util.List;

public class SalaryChangeHistoryLogicHandle {
  private List<SalaryChangeHistory> historyList;

  public SalaryChangeHistoryLogicHandle() {
    this.historyList = new ArrayList<>();
  }

  // Thêm thay đổi lương
  public void addChangeHistory(SalaryChangeHistory changeHistory) {
    historyList.add(changeHistory);
  }

  // Hiển thị tất cả các thay đổi lương
  public void displayAllChangeHistories() {
    for (SalaryChangeHistory history : historyList) {
      System.out.println(history); // Sử dụng phương thức toString đã có trong SalaryChangeHistory
    }
  }

  // Lấy báo cáo về lịch sử thay đổi của một nhân viên cụ thể
  public List<SalaryChangeHistory> getChangeHistoryByEmployee(Employee employee) {
    List<SalaryChangeHistory> employeeHistory = new ArrayList<>();
    for (SalaryChangeHistory history : historyList) {
      if (history.getEmployee().equals(employee)) {
        employeeHistory.add(history);
      }
    }
    return employeeHistory;
  }
}