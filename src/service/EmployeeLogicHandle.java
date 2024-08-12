package service;

import constants.Contract;
import constants.Literacy;
import constants.Status;
import entity.Attendance;
import entity.Department;
import entity.Employee;
import entity.LastUpdatedTime;
import entity.Leave;
import entity.WorkHistory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeLogicHandle {

  private final List<Employee> employeeList;
  private final LastUpdatedTime lastUpdatedTime; // Khai báo LastUpdatedTime

  public EmployeeLogicHandle(List<Employee> employeeList) {
    this.employeeList = employeeList;
    this.lastUpdatedTime = new LastUpdatedTime();
  }

  // Các Method thêm nhân viên, xem thông tin, sửa thông tin, khóa tài khoản, tìm kiếm, tính lương được định nghĩa tại đây

  // Thêm nhân viên vào danh sách

  public void addEmployee(Employee employee) {
    if (employee != null && !employeeList.contains(employee)) {
      employeeList.add(employee);
      lastUpdatedTime.update();
      System.out.println("Đã thêm nhân viên: " + employee.getName());
    } else {
      System.out.println("Nhân viên đã tồn tại hoặc NULL không thể thêm.");
    }
  }

  // Hiển thị thông tin nhân viên

  public void displayEmployeeInfo(Scanner scanner) {
    System.out.print("Nhập ID nhân viên để xem thông tin: ");
    String id = scanner.nextLine();

    Employee employee = findEmployeeById(id);
    if (employee == null) {
      System.out.println("Không tìm thấy nhân viên với ID: " + id);
      return;
    }

    employee.displayInfo();
  }

  // Cập nhật thông tin nhân viên
  public void updateEmployeeInfo(String id, Scanner scanner) {
    Employee emp = findEmployeeById(id); // Sử dụng phương thức findEmployeeById để tìm nhân viên
    if (emp != null) {
      System.out.print("Nhập tên mới cho nhân viên (hiện tại: " + emp.getName() + "): ");
      String newName = scanner.nextLine();
      emp.setName(newName);

      System.out.print("Nhập lương mới cho nhân viên (hiện tại: " + emp.getSalary() + "): ");
      double newSalary = scanner.nextDouble();
      emp.setSalary(newSalary);
      scanner.nextLine(); // Clear newline

      lastUpdatedTime.update(); // Cập nhật thời gian cuối cùng
      System.out.println("Cập nhật thông tin nhân viên thành công: " + emp);
    } else {
      System.out.println("Không tìm thấy nhân viên với ID " + id);
    }
  }

//  public void updateEmployee(String employeeId, Employee updatedEmployee) {
//    Employee employee = findEmployeeById(employeeId);
//    if (employee != null) {
//      employee.setDepartment(updatedEmployee.getDepartment());
//      employee.setEmail(updatedEmployee.getEmail());
//      employee.setSalary(updatedEmployee.getSalary());
//      employee.setSalaryScale(updatedEmployee.getSalaryScale());
//      employee.setLiteracy(updatedEmployee.getLiteracy());
//      employee.setContract(updatedEmployee.getContract());
//      employee.setAreaExpertise(updatedEmployee.getAreaExpertise());
//      employee.setHiredDate(updatedEmployee.getHiredDate());
//      employee.setWorkingStartedDate(updatedEmployee.getWorkingStartedDate());
//      employee.setStatus(updatedEmployee.getStatus());
//      employee.setLastUpdatedTime(updatedEmployee.getLastUpdatedTime());
//      employee.setAttendances(updatedEmployee.getAttendances());
//      employee.setLeaves(updatedEmployee.getLeaves());
//      employee.setLocked(updatedEmployee.isLocked());
//      employee.setWorkHistory(updatedEmployee.getWorkHistory());
//      employee.setLeaveHistory(updatedEmployee.getLeaveHistory());
//      System.out.println("Thông tin nhân viên đã được cập nhật: " + employee);
//    } else {
//      System.out.println("Không tìm thấy nhân viên với ID: " + employeeId);
//    }
//  }

  // Khóa tài khoản nhân viên
  public void lockEmployeeAccount(Scanner scanner) {
    System.out.print("Nhập ID nhân viên cần khóa: ");
    String id = scanner.nextLine();

    Employee employee = findEmployeeById(id);
    if (employee == null) {
      System.out.println("Không tìm thấy nhân viên với ID: " + id);
      return;
    }

    employee.setLocked(true);
    System.out.println("Tài khoản nhân viên " + employee.getName() + " đã bị khóa.");
  }

  // Tìm nhân viên theo ID

  public Employee findEmployeeById(String id) {
    if (id == null) {
      return null; // Trả về null nếu ID là null
    }
    for (Employee employee : employeeList) {
      if (id.equals(String.valueOf(employee.getId()))) {
        return employee; // Nếu tìm thấy, trả về nhân viên
      }
    }
    return null; // Trả về null nếu không tìm thấy
  }

  // Tìm kiếm nhân viên bằng ID hoặc tên

  public Employee findEmployeeByIdOrName(String query) {
    if (query == null) {
      return null; // Trả về null nếu query là null
    }
    for (Employee employee : employeeList) {
      String employeeId = String.valueOf(employee.getId());
      String employeeName = employee.getName(); // Không cần chuyển đổi, đã là String

      // So sánh với query
      if (query.equalsIgnoreCase(employeeId) || query.equalsIgnoreCase(employeeName)) {
        return employee; // Nếu tìm thấy nhân viên, trả về nhân viên đó
      }
    }
    return null; // Nếu không tìm thấy nhân viên nào
  }

  // Tính lương cho nhân viên

  public void calculateEmployeeSalary(Scanner scanner) {
    System.out.print("Nhập ID nhân viên để tính lương: ");
    String id = scanner.nextLine();
    Employee employee = findEmployeeById(id);
    if (employee != null) {
      double salary = calculateSalary(employee);
      System.out.println("Lương của nhân viên " + employee.getName() + " là: " + salary);
    } else {
      System.out.println("Không tìm thấy nhân viên với ID: " + id);
    }
  }

  // Method tính lương
  public double calculateSalary(Employee employee) {
    return employee.getSalary() * employee.getSalaryScale(); // Lương = lương cơ bản * hệ số lương
  }

  // Lấy danh sách nhân viên

  public List<Employee> getEmployeeList() {
    return new ArrayList<>(employeeList); // Trả về bản sao danh sách để bảo vệ tính toàn vẹn
  }

  // Thêm ngày nghỉ phép cho nhân viên

  public void addLeaveToEmployee(Scanner scanner) {
    System.out.print("Nhập ID nhân viên để thêm ngày nghỉ: ");
    String id = scanner.nextLine();
    Employee employee = findEmployeeById(id);
    if (employee != null) {
      System.out.print("Nhập ngày bắt đầu nghỉ (yyyy-mm-dd): ");
      LocalDate startDate = LocalDate.parse(scanner.nextLine());
      System.out.print("Nhập ngày kết thúc nghỉ (yyyy-mm-dd): ");
      LocalDate endDate = LocalDate.parse(scanner.nextLine());
      System.out.print("Nhập lý do nghỉ: ");
      String reason = scanner.nextLine();
      Leave leave = new Leave(startDate, endDate, reason);
      employee.addLeave(leave);
      System.out.println("Ngày nghỉ đã được thêm cho nhân viên " + employee.getName() + ".");
    } else {
      System.out.println("Không tìm thấy nhân viên với ID: " + id);
    }
  }

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
    Literacy literacy = Literacy.valueOf(scanner.nextLine().toUpperCase());
    System.out.print("Nhập loại hợp đồng: ");
    Contract contract = Contract.valueOf(scanner.nextLine().toUpperCase());
    System.out.print("Nhập lĩnh vực chuyên môn: ");
    String areaExpertise = scanner.nextLine();
    System.out.print("Nhập ngày tuyển dụng (yyyy-mm-dd): ");
    LocalDate hiredDate = LocalDate.parse(scanner.nextLine());
    System.out.print("Nhập ngày bắt đầu làm việc: ");
    String workingStartedDate = scanner.nextLine();

    // Khởi tạo các đối tượng cần thiết
    Status status = Status.ACTIVE; // Mặc định trạng thái là ACTIVE
    LastUpdatedTime lastUpdatedTime = new LastUpdatedTime(); // Giả sử có lớp LastUpdatedTime
    List<Attendance> attendances = new ArrayList<>();
    List<Leave> leaves = new ArrayList<>();
    List<WorkHistory> workHistory = new ArrayList<>();
    List<Leave> leaveHistory = new ArrayList<>(); // Khai báo và khởi tạo leaveHistory

    // Tạo và trả về đối tượng Employee
    return new Employee(id, name, department, salary, salaryScale, literacy, contract,
        areaExpertise, hiredDate, workingStartedDate, status, lastUpdatedTime, attendances, leaves,
        workHistory, leaveHistory);
  }
}

