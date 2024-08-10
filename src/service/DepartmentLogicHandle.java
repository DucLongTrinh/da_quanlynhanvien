package service;

import entity.Department;
import entity.Employee;
import java.util.List;

public class DepartmentLogicHandle {

  private final Department department;

  public DepartmentLogicHandle(Department department) {
    this.department = department;
  }

  // Thêm nhân viên vào phòng ban
  public void addEmployeeToDepartment(Employee employee) {
    department.addEmployee(employee);
  }

  // Tìm kiếm nhân viên theo tên
  public Employee findEmployeeByName(String name) {
    return department.getEmployees()
        .stream()
        .filter(emp -> emp.getName().equalsIgnoreCase(name))
        .findFirst()
        .orElse(null); // Trả về null nếu không tìm thấy
  }

  // Tính lương cho tất cả nhân viên trong phòng ban
  public void calculateSalaries() {
    List<Employee> employees = department.getEmployees();
    for (Employee emp : employees) {
      double salary = emp.calculateSalary();
      System.out.printf("Nhân viên: %s, Lương: %.2f%n", emp.getName(), salary);
    }
  }

  // Hiển thị thông tin phòng ban
  public void displayDepartmentInfo() {
    department.displayDepartmentInfo();
  }

}
