package service;

import constants.UserRole;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenuLogicHandle {

  private final List<User> users = new ArrayList<>(); // Danh sách người dùng

  public MainMenuLogicHandle() {
    initializeUsers();
  }

  public void initializeUsers() {
    // Thêm người dùng mặc định vào danh sách
    users.add(new User("admin@example.com", "adminPass!", UserRole.ADMIN, true, null));
    users.add(
        new User("manager@example.com", "managerPass1!", UserRole.MANAGER, true, "Engineering"));
    users.add(new User("user@example.com", "userPass$", UserRole.NORMAL, true, null));
  }

  public User authenticateUser(String email, String password) {
    for (User user : users) {
      if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.isActive()) {
        return user; // Trả về đối tượng User nếu xác thực thành công
      }
    }
    return null; // Nếu không tìm thấy, trả về null
  }

  public void registerUser(Scanner scanner) {
    System.out.print("Nhập tên người dùng: ");
    String name = scanner.nextLine();

    System.out.print("Nhập email: ");
    String email = scanner.nextLine();

    // Kiểm tra xem email đã tồn tại không
    if (isEmailTaken(email)) {
      System.out.println("Email đã được sử dụng. Vui lòng chọn email khác.");
      return;
    }

    System.out.print("Nhập mật khẩu: ");
    String password = scanner.nextLine();

// Kiểm tra độ mạnh của mật khẩu
    if (!new User("", password, null, "").validatePassword(password)) {
      System.out.println(
          "Mật khẩu không đủ mạnh. Phải có ít nhất 8 ký tự bao gồm chữ hoa, chữ thường, số, và ký tự đặc biệt.");
      return;
    }

    System.out.print("Nhập vai trò (ADMIN, MANAGER, NORMAL): ");
    String roleInput = scanner.nextLine();
    UserRole role;

    try {
      role = UserRole.valueOf(roleInput.toUpperCase()); // Chuyển đổi chuỗi thành Enum
    } catch (IllegalArgumentException e) {
      System.out.println("Vai trò không hợp lệ. Vui lòng thử lại.");
      return;
    }

    // Tạo người dùng mới
    User newUser = new User(email, password, role,
        role == UserRole.MANAGER ? "Engineering" : null);
    users.add(newUser);
    System.out.println("Đăng ký thành công!");
  }

  private boolean isEmailTaken(String email) {
    for (User user : users) {
      if (user.getEmail().equals(email)) {
        return true;
      }
    }
    return false;
  }

  public List<User> getEmployeeList() {
    List<User> normalUsers = new ArrayList<>(); // Trả về danh sách người dùng với vai trò là NORMAL
    for (User user : users) {
      if (user.getRole() == UserRole.NORMAL) {
        normalUsers.add(user);
      }
    }
    return normalUsers; // hoặc trả về toàn bộ users nếu cần thiết
  }

}