package service;

import entity.Employee;
import entity.Leave;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class NormalUserMenuLogicHandle {

  private List<Employee> employeeList;
  private Scanner scanner;
  private Employee currentUser; // Nhân viên hiện tại

  public NormalUserMenuLogicHandle(List<Employee> employeeList, Scanner scanner,
      Employee currentUser) {
    this.employeeList = employeeList;
    this.scanner = scanner;
    this.currentUser = currentUser; // Nhân viên hiện tại
  }

  // Xem thông tin cá nhân
  public void viewPersonalInfo() {
    if (currentUser != null) {
      System.out.println("Thông tin cá nhân:");
      System.out.println(currentUser); // Giả sử toString của Employee sẽ hiển thị thông tin
    } else {
      System.out.println("Không tìm thấy thông tin người dùng hiện tại.");
    }
  }

  // Cập nhật thông tin cá nhân
  public void updatePersonalInfo() {
    if (currentUser != null) {
      System.out.println("Cập nhật thông tin cá nhân:");
      System.out.print("Nhập tên mới: ");
      String newName = scanner.nextLine();
      currentUser.setName(newName);  // Giả sử có method setName trong Employee

      System.out.print("Nhập lương mới: ");
      double newSalary = scanner.nextDouble();
      currentUser.setSalary(newSalary); // giả sử có method setSalary trong Employee
      scanner.nextLine(); // Đọc dấu dòng sau khi nhập số

      System.out.println("Thông tin đã được cập nhật.");
    } else {
      System.out.println("Không tìm thấy thông tin người dùng hiện tại.");
    }
  }

  // Xem lịch sử làm việc
  public void viewWorkHistory() {
    if (currentUser != null) {
      System.out.println("Lịch sử làm việc của " + currentUser.getName() + ":");
      // Giả sử có một method trong Employee để hiển thị lịch sử làm việc
      currentUser.displayWorkHistory(); // Bạn có thể cần định nghĩa phương thức này trong Employee
    } else {
      System.out.println("Không tìm thấy thông tin người dùng hiện tại.");
    }
  }

  // Kiểm tra lương
  public void checkSalary() {
    if (currentUser != null) {
      double salary = currentUser.calculateSalary(); // Giả sử có method calculateSalary trong Employee
      System.out.println("Lương của nhân viên " + currentUser.getName() + " là: " + salary);
    } else {
      System.out.println("Không tìm thấy thông tin người dùng hiện tại.");
    }
  }

  // Xin nghỉ phép
  public void requestLeave() {
    if (currentUser != null) {
      System.out.print("Nhập ngày bắt đầu nghỉ (yyyy-MM-dd): ");
      LocalDate startDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);

      System.out.print("Nhập ngày kết thúc nghỉ (yyyy-MM-dd): ");
      LocalDate endDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);

      System.out.print("Nhập lý do xin nghỉ phép: ");
      String reason = scanner.nextLine();

      Leave leave = new Leave(startDate, endDate, reason);
      currentUser.addLeave(leave); // Giả sử có method addLeave trong Employee
      System.out.println("Yêu cầu nghỉ phép đã được gửi với lý do: " + reason +
          " từ " + startDate + " đến " + endDate + ".");
    } else {
      System.out.println("Không tìm thấy thông tin người dùng hiện tại.");
    }
  }
}