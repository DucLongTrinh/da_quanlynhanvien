package service;

import constants.UserRole;
import entity.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserLogicHandle {

  private static Map<String, User> userDatabase = new HashMap<>();

  // Register a new user
  public void registerUser(Scanner scanner) {
    System.out.print("Nhập email: ");
    String email = scanner.nextLine();

    System.out.print("Nhập mật khẩu: ");
    String password = scanner.nextLine();

    // Validate password
    User tempUser = new User(email, password, UserRole.NORMAL, null);
    if (!tempUser.validatePassword(password)) {
      System.out.println("Mật khẩu không đủ mạnh! Phải có ít nhất 8 ký tự bao gồm chữ cái, số và ký tự đặc biệt.");
      return;
    }

    System.out.print("Nhập vai trò (ADMIN, MANAGER, NORMAL): ");
    String roleInput = scanner.nextLine().toUpperCase();

    UserRole role;
    try {
      role = UserRole.valueOf(roleInput);
    } catch (IllegalArgumentException e) {
      System.out.println("Vai trò không hợp lệ! Vui lòng thử lại.");
      return;
    }

    System.out.print("Nhập phòng ban: ");
    String department = scanner.nextLine();  // Nhập thông tin phòng ban

    User newUser = new User(email, password, role, department);
    User.addUser(newUser);
    System.out.println("Người dùng " + email + " đã được đăng ký thành công.");
  }

  // Authenticate a user
  public User authenticateUser(Scanner scanner) {
    System.out.print("Nhập email: ");
    String email = scanner.nextLine();

    System.out.print("Nhập mật khẩu: ");
    String password = scanner.nextLine();

    User user = User.authenticate(email, password);
    if (user != null) {
      System.out.println("Đăng nhập thành công! Chào mừng " + user.getUserInfo());
      return user;
    } else {
      System.out.println("Đăng nhập không thành công! Vui lòng kiểm tra lại email và mật khẩu.");
      return null;
    }
  }

  // Deactivate (lock) a user account
  public void deactivateUserAccount(User user) {
    if (user != null) {
      user.setActive(false);
      System.out.println("Tài khoản của người dùng " + user.getEmail() + " đã bị vô hiệu hóa.");
    } else {
      System.out.println("Người dùng không hợp lệ để vô hiệu hóa.");
    }
  }

  // Display user information
  public void displayUserInfo(User user) {
    if (user != null) {
      System.out.println(user.getUserInfo());
    } else {
      System.out.println("Không có thông tin người dùng để hiển thị.");
    }
  }

  // Menu handling based on user role
  public void showMenu(User user) {
    if (user.getRole() == UserRole.ADMIN) {
      showAdminMenu(user);
    } else if (user.getRole() == UserRole.MANAGER) {
      showManagerMenu(user);
    } else if (user.getRole() == UserRole.NORMAL) {
      showNormalMenu(user);
    }
  }

  // Function for Admin menu
  private void showAdminMenu(User user) {
    // Implement Admin functionalities like adding employees, viewing employee info, etc.
    System.out.println("Đây là menu Admin.");
    // Add your admin menu logic here
  }

  // Function for Manager menu
  private void showManagerMenu(User user) {
    // Implement Manager functionalities like adding employees in department, etc.
    System.out.println("Đây là menu Manager.");
    // Add your manager menu logic here
  }

  // Function for Normal user menu
  private void showNormalMenu(User user) {
    // Implement Normal user functionalities
    System.out.println("Đây là menu Normal.");
    // Add your normal menu logic here
  }
}