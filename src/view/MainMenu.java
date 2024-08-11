package view;

import constants.UserRole;
import entity.User;
import service.MainMenuLogicHandle;

import java.util.Scanner;

public class MainMenu {
  private final Scanner scanner = new Scanner(System.in);
  private final MainMenuLogicHandle logicHandle;

  public MainMenu() {
    logicHandle = new MainMenuLogicHandle();
    logicHandle.initializeUsers(); // Khởi tạo người dùng mặc định
  }

  public void display() {
    System.out.println("==== Đăng nhập ====");
    System.out.print("Email: ");
    String email = scanner.nextLine();
    System.out.print("Mật khẩu: ");
    String password = scanner.nextLine();

    User user = logicHandle.authenticateUser(scanner);

    if (user != null && user.isActive()) {
      switch (user.getRole()) {
        case ADMIN:
          new AdminMenu().display(); // Giả sử AdminMenu xử lý logic riêng của nó
          break;
        case MANAGER:
          new ManagerMenu(user.getDepartment()).display();
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