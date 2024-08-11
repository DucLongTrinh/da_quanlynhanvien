package entity;

import java.util.ArrayList;
import java.util.List;

public class Department { // mô tả thông tin về phòng ban và danh sách nhân viên thuộc phòng ban đó

  private String departmentId; // Mã phòng ban
  private String departmentName; // Tên phòng ban
  private List<Employee> employees; // Danh sách nhân viên thuộc phòng ban
  private boolean active; // Trạng thái hoạt động của phòng ban

  // Constructor
  public Department(String departmentId, String departmentName) {
    this.departmentId = departmentId; // Khởi tạo mã phòng ban
    this.departmentName = departmentName; // Khởi tạo tên phòng ban
    this.employees = new ArrayList<>(); // Khởi tạo danh sách nhân viên
    this.active = true; // Mặc định phòng ban ở trạng thái hoạt động
  }

  // Lấy tên phòng ban
  public String getDepartmentName() {
    return departmentName;
  }

  // Cài đặt tên phòng ban
  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  // Lấy mã phòng ban
  public String getDepartmentId() {
    return departmentId;
  }

  // Thêm nhân viên vào danh sách
  public void addEmployee(Employee employee) {
    employees.add(employee);
  }

  // Lấy danh sách nhân viên
  public List<Employee> getEmployees() {
    return employees;
  }

  // Hiển thị thông tin phòng ban
  public void displayDepartmentInfo() {
    System.out.println("Mã Phòng Ban: " + departmentId);
    System.out.println("Tên Phòng Ban: " + departmentName);
    System.out.println("Trạng thái: " + (active ? "Hoạt động" : "Đã vô hiệu hóa"));
    System.out.println("Danh sách Nhân Viên:");
    for (Employee employee : employees) {
      employee.displayInfo(); // Hiển thị thông tin nhân viên
    }
  }

  // Kiểm tra trạng thái hoạt động của phòng ban
  public boolean isActive() {
    return active;
  }

  // Cài đặt trạng thái hoạt động của phòng ban
  public void setActive(boolean active) {
    this.active = active;
  }

  // Các phương thức khác có thể thêm vào đây (như tìm kiếm nhân viên theo tên, sửa nhân viên...)
}
