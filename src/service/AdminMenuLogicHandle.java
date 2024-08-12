package service;

import entity.Department;

import java.util.List;
import java.util.Scanner;

public class AdminMenuLogicHandle {
  private List<Department> departments;

  public AdminMenuLogicHandle(List<Department> departments) {
    this.departments = departments;
  }

  public void manageDepartments(Scanner scanner) {
    int choice;
    do {
      System.out.println("\n=== Quản Lý Phòng Ban ===");
      System.out.println("1. Thêm phòng ban");
      System.out.println("2. Hiển thị phòng ban");
      System.out.println("3. Sửa phòng ban");
      System.out.println("4. Vô hiệu hóa phòng ban");
      System.out.println("5. Quay lại");
      System.out.print("Vui lòng chọn: ");

      choice = Integer.parseInt(scanner.nextLine());

      switch (choice) {
        case 1:
          addDepartment(scanner);
          break;
        case 2:
          displayDepartments();
          break;
        case 3:
          updateDepartment(scanner);
          break;
        case 4:
          deactivateDepartment(scanner);
          break;
        case 5:
          System.out.println("Quay lại menu chính.");
          break;
        default:
          System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
          break;
      }
    } while (choice != 5);
  }

  private void addDepartment(Scanner scanner) {
    System.out.print("Nhập mã phòng ban mới: ");
    int departmentId = scanner.nextInt();
    System.out.print("Nhập tên phòng ban mới: ");
    String departmentName = scanner.nextLine();
    if (departmentName.isEmpty()) {
      System.out.println("Tên phòng ban không được để trống.");
      return;
    }
    departments.add(new Department( departmentId, departmentName));
    System.out.println("Phòng ban \"" + departmentName + "\" đã được thêm.");
  }

  private void displayDepartments() {
    System.out.println("\n=== DANH SÁCH PHÒNG BAN ===");
    if (departments.isEmpty()) {
      System.out.println("Không có phòng ban nào.");
    } else {
      for (Department department : departments) {
        String status = department.isActive() ? " (Hoạt động)" : " (Đã vô hiệu hóa)";
        System.out.println("- " + department.getDepartmentName() + status);
      }
    }
  }

  private void updateDepartment(Scanner scanner) {
    System.out.print("Nhập tên phòng ban cần sửa: ");
    String currentName = scanner.nextLine();

    for (Department department : departments) {
      if (department.getDepartmentName().equals(currentName) && department.isActive()) {
        System.out.print("Nhập tên mới cho phòng ban: ");
        String newName = scanner.nextLine();
        department.setDepartmentName(newName);
        System.out.println("Tên phòng ban đã được cập nhật thành \"" + newName + "\".");
        return;
      }
    }
    System.out.println("Không tìm thấy phòng ban có tên \"" + currentName + "\".");
  }

  private void deactivateDepartment(Scanner scanner) {
    System.out.print("Nhập tên phòng ban cần vô hiệu hóa: ");
    String name = scanner.nextLine();

    for (Department department : departments) {
      if (department.getDepartmentName().equals(name)) {
        department.setActive(false);
        System.out.println("Phòng ban \"" + name + "\" đã được vô hiệu hóa.");
        return;
      }
    }
    System.out.println("Không tìm thấy phòng ban có tên \"" + name + "\".");
  }
}