package main;

import entity.Department;
import entity.Employee;
import entity.User;
import java.util.List;
import service.MainMenuLogicHandle;
import view.admin.AdminMenu;
import view.manager.ManagerMenu;
import view.normal.NormalUserMenu;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    MainMenuLogicHandle mainMenuLogicHandle = new MainMenuLogicHandle();

    // Tạo danh sách departments và employees
    List<Department> departments = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();

    // Khởi tạo AdminMenu với danh sách đã tạo
    AdminMenu adminMenu = new AdminMenu(departments, employees);

    // Hiển thị menu Admin
    adminMenu.display();

    while (true) {
      System.out.println("\n--- Ứng dụng Quản lý Nhân viên ---");
      System.out.println("1. Đăng ký người dùng");
      System.out.println("2. Đăng nhập");
      System.out.println("3. Thoát");
      System.out.print("Chọn tùy chọn của bạn: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // Clear buffer

      switch (choice) {
        case 1:
          mainMenuLogicHandle.registerUser(scanner);
          break;
        case 2:
          System.out.print("Nhập email của bạn: ");
          String email = scanner.nextLine();
          System.out.print("Nhập mật khẩu của bạn: ");
          String password = scanner.nextLine();

          User user = mainMenuLogicHandle.authenticateUser(email, password);
          if (user != null) {
            // Kiểm tra quyền của người dùng và hiển thị menu tương ứng
            switch (user.getRole()) {
              case ADMIN:
                new AdminMenu().display(user); // Gọi method hiển thị menu của Admin
                break;
              case MANAGER:
                new ManagerMenu().display(user); // Gọi method hiển thị menu của Manager
                break;
              case NORMAL:
                new NormalUserMenu(mainMenuLogicHandle.getEmployeeList()).display(); // Gọi method hiển thị menu của Normal User
                break;
              default:
                System.out.println("Quyền người dùng không xác định!");
                break;
            }
          } else {
            System.out.println("Đăng nhập thất bại! Vui lòng kiểm tra lại email và mật khẩu.");
          }
          break;
        case 3:
          System.out.println("Cảm ơn bạn đã sử dụng ứng dụng!");
          scanner.close();
          return; // Kết thúc ứng dụng
        default:
          System.out.println("Tùy chọn không hợp lệ! Vui lòng chọn lại.");
          break;
      }
    }
  }
}