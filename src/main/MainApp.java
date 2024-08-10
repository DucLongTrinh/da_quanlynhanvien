package main;

import java.util.Scanner;
import entity.User;
import service.UserLogicHandle;
import view.MainMenu;

public class MainApp {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    UserLogicHandle userLogicHandle = new UserLogicHandle();

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
          userLogicHandle.registerUser(scanner);
          break;
        case 2:
          User user = userLogicHandle.authenticateUser(scanner);
          if (user != null) {
            new MainMenu(user).display();
          }
          break;
        case 3:
          System.out.println("Cảm ơn bạn đã sử dụng ứng dụng!");
          scanner.close();
          return; // Exit the application
        default:
          System.out.println("Tùy chọn không hợp lệ! Vui lòng chọn lại.");
          break;
      }
    }
  }
}