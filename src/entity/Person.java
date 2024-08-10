package entity;

import constants.Gender;
import java.time.LocalDate;

public class Person {

  private Gender gender;
  private LocalDate dateOfBirth;
  private String email;
  private String address;
  private String phoneNumber;

  // Constructor
  public Person(Gender gender, LocalDate dateOfBirth, String email, String address, String phoneNumber) {
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.email = email;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }

  // Getters and Setters
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  // Method hiển thị thông tin cá nhân
  public void displayInfo() {
    System.out.println("Giới tính: " + gender);
    System.out.println("Ngày sinh: " + dateOfBirth);
    System.out.println("Email: " + email);
    System.out.println("Địa chỉ: " + address);
    System.out.println("Số điện thoại: " + phoneNumber);
  }

}

