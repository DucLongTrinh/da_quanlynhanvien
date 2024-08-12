package entity;

import constants.Gender;
import java.time.LocalDate;

public class Person {
  private static int AUTO_ID = 100000; // biến tĩnh ID tự động tăng

  private String id;
  private String name;
  protected Department currentDepartment; // Phòng ban hiện tại
  private Gender gender;
  private LocalDate dateOfBirth;
  private String address;
  private String phoneNumber;

  // Constructor
  public Person(String name, Department currentDepartment, Gender gender, LocalDate dateOfBirth, String address, String phoneNumber) {
    this.id = generateId(); // Tạo ID khi khởi tạo
    this.name = name; // Khởi tạo tên
    this.currentDepartment = currentDepartment; // Khởi tạo phòng ban hiện tại
    this.gender = gender; // Khởi tạo giới tính
    this.dateOfBirth = dateOfBirth; // Khởi tạo ngày sinh
    this.address = address; // Khởi tạo địa chỉ
    this.phoneNumber = phoneNumber; // Khởi tạo số điện thoại
  }

  // Phương thức tạo ID
  private String generateId() {
    return String.valueOf(AUTO_ID++); // Tăng AUTO_ID mỗi khi tạo mới người
  }

  // Constructor chỉ định ID
  public Person(String id, String name, Department currentDepartment) {
    this.id = id;
    this.name = name;
    this.currentDepartment = currentDepartment;
    this.gender = Gender.MALE; // Mặc định không xác định
    this.dateOfBirth = LocalDate.now(); // Ngày sinh mặc định là ngày hiện tại
    this.address = ""; // Địa chỉ mặc định là rỗng
    this.phoneNumber = ""; // Số điện thoại mặc định là rỗng
  }

  // Getters and Setters

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Department getCurrentDepartment() {
    return currentDepartment;
  }

  public void setCurrentDepartment(Department currentDepartment) {
    this.currentDepartment = currentDepartment;
  }

  // Method hiển thị thông tin cá nhân

  public void displayInfo() {
    System.out.println("ID: " + id);
    System.out.println("Tên: " + name);
    System.out.println("Giới tính: " + gender);
    System.out.println("Ngày sinh: " + dateOfBirth);
    System.out.println("Địa chỉ: " + address);
    System.out.println("Số điện thoại: " + phoneNumber);
    System.out.println("Phòng ban hiện tại: " + (currentDepartment != null ? currentDepartment.getName() : "Không xác định"));
  }

}







