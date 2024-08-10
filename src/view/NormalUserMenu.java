package view;

import entity.Employee;
import java.util.List;
import java.util.Scanner;

public class NormalUserMenu {
  private Scanner scanner;
  private List<Employee> employeeList;

  public NormalUserMenu(List<Employee> employeeList) {
    this.employeeList = employeeList;
    this.scanner = new Scanner(System.in);
  }

  public void display() {
    int choice;
    do {
      System.out.println("===== Menu Nhân Viên Thường =====");
      System.out.println("1. Xem thông tin cá nhân");
      System.out.println("2. Cập nhật thông tin cá nhân");
      System.out.println("3. Xem lịch sử làm việc");
      System.out.println("4. Kiểm tra lương");
      System.out.println("5. Xin nghỉ phép");
      System.out.println("0. Đăng xuất");
      System.out.print("Chọn chức năng: ");

      choice = scanner.nextInt();
      scanner.nextLine(); // Read remaining line

      switch (choice) {
        case 1:
          viewPersonalInfo();
          break;
        case 2:
          updatePersonalInfo();
          break;
        case 3:
          viewWorkHistory();
          break;
        case 4:
          checkSalary();
          break;
        case 5:
          requestLeave();
          break;
        case 0:
          System.out.println("Đăng xuất thành công.");
          break;
        default:
          System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
      }
    } while (choice != 0);
  }

  private void viewPersonalInfo() {
    // Logic to view personal information
    System.out.println("Xem thông tin cá nhân đang được phát triển.");
  }

  private void updatePersonalInfo() {
    // Logic to update personal information
    System.out.println("Cập nhật thông tin cá nhân đang được phát triển.");
  }

  private void viewWorkHistory() {
    // Logic to view work history
    System.out.println("Xem lịch sử làm việc đang được phát triển.");
  }

  private void checkSalary() {
    // Logic to check salary
    System.out.println("Kiểm tra lương đang được phát triển.");
  }

  private void requestLeave() {
    System.out.print("Nhập lý do xin nghỉ phép: ");
    String reason = scanner.nextLine();
    System.out.print("Nhập ngày bắt đầu (dd/MM/yyyy): ");
    String startDate = scanner.nextLine();
    System.out.print("Nhập ngày kết thúc (dd/MM/yyyy): ");
    String endDate = scanner.nextLine();

    // Logic to handle the leave request
    System.out.println("Yêu cầu nghỉ phép đã được gửi với lý do: " + reason +
        " từ " + startDate + " đến " + endDate + ".");
  }
}