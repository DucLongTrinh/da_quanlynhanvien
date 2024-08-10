package view;

import constants.UserRole;
import entity.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {

  private Scanner scanner = new Scanner(System.in);
  private Map<String, User> users = new HashMap<>(); // For storing users

  public MainMenu() {
    // Thêm người dùng mặc định
    users.put("admin@example.com", new User("admin@example.com", "admin123", UserRole.ADMIN));
    users.put("manager@example.com", new User("manager@example.com", "manager123", UserRole.MANAGER));
    users.put("user@example.com", new User("user@example.com", "user123", UserRole.NORMAL));
  }

  public void display() {
    System.out.println("==== Đăng nhập ====");
    System.out.print("Email: ");
    String email = scanner.nextLine();
    System.out.print("Mật khẩu: ");
    String password = scanner.nextLine();

    User user = users.get(email);

    if (user != null && user.validatePassword(password) && user.isActive()) {
      switch (user.getRole()) {
        case ADMIN:
          new AdminMenu(null, null).display(); // Pass the required parameters
          break;
        case MANAGER:
          new ManagerMenu(user.getDepartment()).display(); // Assuming department is a property of User
          break;
        case NORMAL:
          new NormalUserMenu().display();
          break;
        default:
          System.out.println("Vai trò không hợp lệ!");
      }
    } else {
      System.out.println("Đăng nhập thất bại! Vui lòng kiểm tra lại email hoặc mật khẩu.");
    }
  }
}