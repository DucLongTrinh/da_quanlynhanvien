package service;

import constants.Gender;
import entity.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonLogicHandle {
  private List<Person> personList;

  // Constructor
  public PersonLogicHandle() {
    this.personList = new ArrayList<>();
  }

  // Thêm người dùng mới
  public void addPerson(Scanner scanner) {
    System.out.print("Nhập tên: ");
    String name = scanner.nextLine();

    System.out.print("Nhập giới tính (MALE/FEMALE): ");
    Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

    System.out.print("Nhập ngày sinh (yyyy-mm-dd): ");
    LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());

    System.out.print("Nhập địa chỉ: ");
    String address = scanner.nextLine();

    System.out.print("Nhập số điện thoại: ");
    String phoneNumber = scanner.nextLine();

    // Tạo đối tượng Person mới và thêm vào danh sách
    Person person = new Person(name, null, gender, dateOfBirth, address, phoneNumber);
    personList.add(person);
    System.out.println("Người dùng đã được thêm thành công.");
  }

  // Cập nhật thông tin người dùng
  public void updatePersonInfo(Scanner scanner) {
    System.out.print("Nhập ID người dùng để cập nhật: ");
    String id = scanner.nextLine();

    // Tìm kiếm người dùng theo ID
    Person person = findPersonById(id);
    if (person == null) {
      System.out.println("Không tìm thấy người dùng với ID: " + id);
      return;
    }

    System.out.print("Nhập giới tính (MALE/FEMALE): ");
    Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
    person.setGender(gender);

    System.out.print("Nhập ngày sinh mới (yyyy-mm-dd): ");
    LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
    person.setDateOfBirth(dateOfBirth);

    System.out.print("Nhập địa chỉ mới: ");
    String address = scanner.nextLine();
    person.setAddress(address);

    System.out.print("Nhập số điện thoại mới: ");
    String phoneNumber = scanner.nextLine();
    person.setPhoneNumber(phoneNumber);

    System.out.println("Thông tin người dùng đã được cập nhật.");
  }

  // Hiển thị thông tin người dùng
  public void displayPersonInfo(Scanner scanner) {
    System.out.print("Nhập ID người dùng để xem thông tin: ");
    String id = scanner.nextLine();

    // Tìm kiếm người dùng theo ID
    Person person = findPersonById(id);
    if (person == null) {
      System.out.println("Không tìm thấy người dùng với ID: " + id);
      return;
    }

    System.out.println("Thông tin người dùng:");
    person.displayInfo();
  }

  // method tìm kiếm người dùng theo ID
  private Person findPersonById(String id) {
    for (Person person : personList) {
      if (person.getId().equals(id)) {
        return person;
      }
    }
    return null; // Không tìm thấy người dùng
  }
}