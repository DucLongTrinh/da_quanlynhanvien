package entity;

import java.time.LocalDate;

public class SalaryChangeHistory { // lưu trữ lịch sử biến động lương của nhân viên
  private Employee employee; // Tham chiếu đến đối tượng Employee
  private double oldSalary;
  private double newSalary;
  private LocalDate changeDate;
  private String reason;

  // Constructor
  public SalaryChangeHistory(Employee employee, double oldSalary, double newSalary, LocalDate changeDate, String reason) {
    this.employee = employee;
    this.oldSalary = oldSalary;
    this.newSalary = newSalary;
    this.changeDate = changeDate;
    this.reason = reason;
  }

  // Getters and Setters
  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public double getOldSalary() {
    return oldSalary;
  }

  public void setOldSalary(double oldSalary) {
    this.oldSalary = oldSalary;
  }

  public double getNewSalary() {
    return newSalary;
  }

  public void setNewSalary(double newSalary) {
    this.newSalary = newSalary;
  }

  public LocalDate getChangeDate() {
    return changeDate;
  }

  public void setChangeDate(LocalDate changeDate) {
    this.changeDate = changeDate;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  @Override
  public String toString() {
    return "SalaryChangeHistory [employee=" + employee + ", oldSalary=" + oldSalary + ", newSalary="
        + newSalary + ", changeDate=" + changeDate + ", reason=" + reason + "]";
  }
}
