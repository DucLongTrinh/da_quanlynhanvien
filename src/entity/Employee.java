package entity;

import constants.Contract;
import constants.Gender;
import constants.Literacy;
import constants.Status;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Employee extends Person {

  private String id;
  private String name;
  private Department department;
  private int salary;
  private double salaryScale;
  private Literacy literacy;
  private Contract contract;
  private String areaExpertise;
  private LocalDate hiredDate;
  private String workingStartedDate;
  private Status status; // ACTIVE, INACTIVE, SUSPENDED
  private LastUpdatedTime lastUpdatedTime;
  private List<Attendance> attendances;
  private List<Leave> leaves; // Danh sách ngày nghỉ phép
  private boolean isLocked; // Để xác định trạng thái khóa tài khoản

  // Khai báo lịch sử làm việc và lịch sử nghỉ phép
  private List<WorkHistory> workHistory; // Danh sách lịch sử làm việc
  private List<Leave> leaveHistory; // Danh sách lịch sử nghỉ phép

  // Constructor

  public Employee(Gender gender, LocalDate dateOfBirth, String email, String address,
      String phoneNumber, String id, String name, Department department, int salary,
      double salaryScale, Literacy literacy, Contract contract, String areaExpertise,
      LocalDate hiredDate, String workingStartedDate, Status status,
      LastUpdatedTime lastUpdatedTime,
      List<Attendance> attendances, List<Leave> leaves,
      List<WorkHistory> workHistory, List<Leave> leaveHistory) {
    super(gender, dateOfBirth, email, address, phoneNumber);
    this.id = id;
    this.name = name;
    this.department = department;
    this.salary = salary;
    this.salaryScale = salaryScale;
    this.literacy = literacy;
    this.contract = contract;
    this.areaExpertise = areaExpertise;
    this.hiredDate = hiredDate;
    this.workingStartedDate = workingStartedDate;
    this.status = status;
    this.lastUpdatedTime = lastUpdatedTime;
    this.attendances = attendances != null ? attendances : new ArrayList<>();
    this.leaves = leaves != null ? leaves : new ArrayList<>(); // Khởi tạo danh sách ngày nghỉ
    this.workHistory = workHistory != null ? workHistory : new ArrayList<>();
    this.leaveHistory = leaveHistory != null ? leaveHistory : new ArrayList<>();
    this.isLocked = false; // Mặc định tài khoản chưa bị khóa

  }


  // Getters and Setters cho các thuộc tính cụ thể của Employee

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
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

  ///===============

  @Override
  public String toString() {
    return "Employee{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", salary=" + salary +
        ", department=" + department +
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

// Method bổ sung

  // Thêm nhân viên mới
  public static Employee addEmployee(Scanner scanner) {

    System.out.print("Nhập ID nhân viên: ");
    String id = scanner.nextLine();

    System.out.print("Nhập tên nhân viên: ");
    String name = scanner.nextLine();

    System.out.print("Nhập phòng ban: ");
    Department department = new Department(scanner.nextLine()); // Giả sử bạn có lớp Department

    System.out.print("Nhập lương: ");
    int salary = Integer.parseInt(scanner.nextLine());

    System.out.print("Nhập hệ số lương: ");
    double salaryScale = Double.parseDouble(scanner.nextLine());

    System.out.print("Nhập trình độ học vấn: ");
    Literacy literacy = Literacy.valueOf(scanner.nextLine().toUpperCase()); // Giả sử bạn có enum Literacy

    System.out.print("Nhập loại hợp đồng: ");
    Contract contract = Contract.valueOf(scanner.nextLine().toUpperCase()); // Giả sử bạn có enum Contract

    System.out.print("Nhập lĩnh vực chuyên môn: ");
    String areaExpertise = scanner.nextLine();

    System.out.print("Nhập ngày tuyển dụng (yyyy-mm-dd): ");
    LocalDate hiredDate = LocalDate.parse(scanner.nextLine());

    System.out.print("Nhập ngày bắt đầu làm việc: ");
    String workingStartedDate = scanner.nextLine();

    Status status = Status.ACTIVE; // Mặc định trạng thái là ACTIVE

    LastUpdatedTime lastUpdatedTime = new LastUpdatedTime(); // Giả sử bạn có lớp LastUpdatedTime

    List<Attendance> attendances = new ArrayList<>(); // Khởi tạo danh sách Attendance
    List<Leave> leaves = new ArrayList<>(); // Khởi tạo danh sách Leave

    // Khởi tạo lịch sử làm việc và lịch sử nghỉ phép
    List<WorkHistory> workHistory = new ArrayList<>(); // Khởi tạo danh sách lịch sử làm việc
    List<Leave> leaveHistory = new ArrayList<>(); // Khởi tạo danh sách lịch sử nghỉ phép

    // Trả về đối tượng Employee đã được khởi tạo với tất cả thông tin cần thiết
    return new Employee(
        Gender.MALE, // Giả sử giới tính mặc định là NAM
        LocalDate.now(), // Ngày sinh mặc định
        "test@example.com", // Email mặc định, cần sửa lại nếu cần
        "Address", // Địa chỉ mặc định, cần sửa lại nếu cần
        "123456789", // Số điện thoại mặc định
        id,
        name,
        department,
        salary,
        salaryScale,
        literacy,
        contract,
        areaExpertise,
        hiredDate,
        workingStartedDate,
        status,
        lastUpdatedTime,
        attendances,
        leaves,
        workHistory, // Lịch sử làm việc
        leaveHistory // Lịch sử nghỉ phép
    );
  }


  public void displayInfo() {
    System.out.println("Mã Nhân Viên: " + getId() + ", Tên: " + getName());
    System.out.println("Danh sách ngày nghỉ phép: ");
    for (Leave leave : leaves) {
      leave.displayLeaveInfo(); // Hiển thị thông tin ngày nghỉ
    }
  }

  public void updateInfo(Scanner scanner) {
    System.out.println("Cập nhật thông tin nhân viên (Mã NV: " + getId() + ")");

    System.out.print("Nhập tên mới: ");
    this.setName(scanner.nextLine()); // Cập nhật tên mới

    // Cập nhật thời gian
    lastUpdatedTime.update("admin", "Cập nhật thông tin địa chỉ");
  }

  public LocalDateTime getLastUpdated() {
    return lastUpdatedTime.getLastUpdated();
  }

  // Method tính lương
  public double calculateSalary() {
    // Lương = lương cơ bản * hệ số lương
    return salary * salaryScale;
  }


  // Getter cho trạng thái khóa tài khoản
  public boolean isLocked() {
    return isLocked;
  }


  // Method hiển thị lịch sử làm việc
  public void displayWorkHistory() {
    System.out.println("Lịch sử làm việc của " + name + ":");
    for (WorkHistory history : workHistory) {
      System.out.println(history); // Giả định rằng WorkHistory đã được định nghĩa và có phương thức toString()
    }
  }


  // Method thêm ngày nghỉ vào lịch sử
  public void addLeave(Leave leave) {
    leaveHistory.add(leave);
  }
}






