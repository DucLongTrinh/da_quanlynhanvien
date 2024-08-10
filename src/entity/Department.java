package entity;

import java.util.ArrayList;
import java.util.List;

public class Department { // mô tả thông tin về phòng ban và danh sách nhân viên thuộc phòng ban đó

  private String departmentId;
  private String departmentName;
  private List<Employee> employees; // Danh sách nhân viên thuộc phòng ban

  public Department(String departmentId) {
    this.departmentId = departmentId;
    this.departmentName = departmentName;
    this.employees = new ArrayList<>(); // Khởi tạo danh sách nhân viên
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
    System.out.println("Danh sách Nhân Viên:");
    for (Employee employee : employees) {
      employee.displayInfo(); // Hiển thị thông tin nhân viên
    }
  }

  public String getDepartmentName() {
    return departmentName;
  }

  // Các phương thức khác có thể thêm vào đây (như tìm kiếm nhân viên theo tên, sửa nhân viên...)
}
