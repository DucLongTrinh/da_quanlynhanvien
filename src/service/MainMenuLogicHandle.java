package service;

import constants.UserRole;
import entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenuLogicHandle {
  private Map<String, User> users;

  public MainMenuLogicHandle() {
    users = new HashMap<>();
    initializeUsers();  // Gọi method khởi tạo người dùng mặc định
  }

  public void initializeUsers() {
    // Thêm người dùng mặc định
    users.put("admin@example.com", new User("admin@example.com", "admin123", UserRole.ADMIN));
    users.put("manager@example.com", new User("manager@example.com", "manager123", UserRole.MANAGER));
    users.put("user@example.com", new User("user@example.com", "user123", UserRole.NORMAL));
  }

  public void registerUser(Scanner scanner) {
    // Logic để đăng ký người dùng mới
    System.out.print("Nhập email: ");
    String email = scanner.nextLine();
    System.out.print("Nhập mật khẩu: ");
    String password = scanner.nextLine();

    // Kiểm tra tồn tại email
    if (users.containsKey(email)) {
      System.out.println("Email đã tồn tại! Vui lòng sử dụng email khác.");
      return;
    }

    System.out.print("Nhập vai trò (ADMIN/MANAGER/NORMAL): ");
    String roleInput = scanner.nextLine();

    // Chuyển đổi thành UserRole
    UserRole role;
    try {
      role = UserRole.valueOf(roleInput.toUpperCase());
    } catch (IllegalArgumentException e) {
      System.out.println("Vai trò không hợp lệ! Vui lòng nhập ADMIN, MANAGER hoặc NORMAL.");
      return;
    }

    User newUser = new User(email, password, role);
    users.put(email, newUser);
    System.out.println("Đăng ký thành công!");
  }

  public User authenticateUser(Scanner scanner) {
    System.out.print("Email: ");
    String email = scanner.nextLine();
    System.out.print("Mật khẩu: ");
    String password = scanner.nextLine();

    User user = users.get(email);
    if (user != null && user.validatePassword(password)) {
      return user; // Đăng nhập thành công
    }
    return null; // Đăng nhập thất bại
  }
}