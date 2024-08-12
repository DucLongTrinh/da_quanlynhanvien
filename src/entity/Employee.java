package entity;

import constants.Gender;
import constants.Literacy;
import constants.Contract;
import constants.Status;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Person {

  private Department department;
  private String email;
  private double salary;
  private double salaryScale;
  private Literacy literacy;
  private Contract contract;
  private String areaExpertise;
  private LocalDate hiredDate;
  private String workingStartedDate;
  private Status status; // ACTIVE, INACTIVE
  private LastUpdatedTime lastUpdatedTime;
  private List<Attendance> attendances;
  private List<Leave> leaves; // Danh sách ngày nghỉ phép
  private boolean isLocked; // Để xác định trạng thái khóa tài khoản

  // Khai báo lịch sử làm việc và lịch sử nghỉ phép
  private List<WorkHistory> workHistory; // Danh sách lịch sử làm việc
  private List<Leave> leaveHistory; // Danh sách lịch sử nghỉ phép
  private List<Leave> leaveList; // Danh sách nghỉ phép

  // Constructor
  public Employee(String name, Department currentDepartment, Gender gender, LocalDate dateOfBirth,
      String address, String phoneNumber, String email, double salary, double salaryScale,
      Literacy literacy, Contract contract, String areaExpertise, LocalDate hiredDate,
      String workingStartedDate, Status status) {
    super(name, currentDepartment, gender, dateOfBirth, address, phoneNumber);
    this.email = email;
    this.salary = salary;
    this.salaryScale = salaryScale;
    this.literacy = literacy;
    this.contract = contract;
    this.areaExpertise = areaExpertise;
    this.hiredDate = hiredDate;
    this.workingStartedDate = workingStartedDate;
    this.status = status;
    this.isLocked = false; // Mặc định không bị khóa
    this.leaveList = new ArrayList<>(); // Khởi tạo danh sách nghỉ phép
  }

  public Employee(String id, String name, Department currentDepartment, double salary,
      double salaryScale, Literacy literacy, Contract contract, String areaExpertise,
      LocalDate hiredDate, String workingStartedDate, Status status,
      LastUpdatedTime lastUpdatedTime, List<Attendance> attendances, List<Leave> leaves,
      List<WorkHistory> workHistory, List<Leave> leaveHistory) {
    super(id, name, currentDepartment);
  }

  // Getters and Setters cho các thuộc tính cụ thể của Employee
  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public double getSalaryScale() {
    return salaryScale;
  }

  public void setSalaryScale(double salaryScale) {
    this.salaryScale = salaryScale;
  }

  public Literacy getLiteracy() {
    return literacy;
  }

  public void setLiteracy(Literacy literacy) {
    this.literacy = literacy;
  }

  public Contract getContract() {
    return contract;
  }

  public void setContract(Contract contract) {
    this.contract = contract;
  }

  public String getAreaExpertise() {
    return areaExpertise;
  }

  public void setAreaExpertise(String areaExpertise) {
    this.areaExpertise = areaExpertise;
  }

  public LocalDate getHiredDate() {
    return hiredDate;
  }

  public void setHiredDate(LocalDate hiredDate) {
    this.hiredDate = hiredDate;
  }

  public String getWorkingStartedDate() {
    return workingStartedDate;
  }

  public void setWorkingStartedDate(String workingStartedDate) {
    this.workingStartedDate = workingStartedDate;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public LastUpdatedTime getLastUpdatedTime() {
    return lastUpdatedTime;
  }

  public void setLastUpdatedTime(LastUpdatedTime lastUpdatedTime) {
    this.lastUpdatedTime = lastUpdatedTime;
  }

  public List<Attendance> getAttendances() {
    return attendances;
  }

  public void setAttendances(List<Attendance> attendances) {
    this.attendances = attendances;
  }

  public List<Leave> getLeaves() {
    return leaves;
  }

  public void setLeaves(List<Leave> leaves) {
    this.leaves = leaves;
  }

  public boolean isLocked() {
    return isLocked;
  }

  public void setLocked(boolean locked) {
    isLocked = locked;
  }

  public List<WorkHistory> getWorkHistory() {
    return workHistory;
  }

  public void setWorkHistory(List<WorkHistory> workHistory) {
    this.workHistory = workHistory;
  }

  public List<Leave> getLeaveHistory() {
    return leaveHistory;
  }

  public void setLeaveHistory(List<Leave> leaveHistory) {
    this.leaveHistory = leaveHistory;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "department=" + department +
        ", email='" + email + '\'' +
        ", salary=" + salary +
        ", salaryScale=" + salaryScale +
        ", literacy=" + literacy +
        ", contract=" + contract +
        ", areaExpertise='" + areaExpertise + '\'' +
        ", hiredDate=" + hiredDate +
        ", workingStartedDate='" + workingStartedDate + '\'' +
        ", status=" + status +
        ", lastUpdatedTime=" + lastUpdatedTime +
        ", attendances=" + attendances +
        ", leaves=" + leaves +
        ", isLocked=" + isLocked +
        ", workHistory=" + workHistory +
        ", leaveHistory=" + leaveHistory +
        '}';
  }

  public void addLeave(Leave leave) {
    if (leave != null) {
      leaves.add(leave);
      System.out.println("Ngày nghỉ đã được thêm.");
    } else {
      System.out.println("Ngày nghỉ không hợp lệ.");
    }
  }

  public double calculateSalary() {
    return salary * salaryScale;
  }

  // Method hiển thị lịch sử làm việc
  public void displayWorkHistory() {
    if (leaveList.isEmpty()) {
      System.out.println("Không có lịch sử nghỉ phép nào.");
    } else {
      for (Leave leave : leaveList) {
        System.out.println(leave);
      }
    }
  }
}