package entity;

import java.util.ArrayList;
import java.util.List;

public class SalaryHistory { // lưu trữ lịch sử trả lương của nhân viên

  private Employee employee; // Tham chiếu đến đối tượng Employee
  private List<SalaryChangeHistory> changeHistories;

  // Constructor
  public SalaryHistory(Employee employee) {
    this.employee = employee;
    this.changeHistories = new ArrayList<>();
  }

  // Method thêm lịch sử thay đổi lương
  public void addChangeHistory(SalaryChangeHistory changeHistory) {
    changeHistories.add(changeHistory);
  }

  // Getters and Setters
  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public List<SalaryChangeHistory> getChangeHistories() {
    return changeHistories;
  }

  @Override
  public String toString() {
    return "SalaryHistory [employee=" + employee + ", changeHistories=" + changeHistories + "]";
  }
}
