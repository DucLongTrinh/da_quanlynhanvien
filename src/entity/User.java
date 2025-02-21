package entity;

import constants.UserRole;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class User {
  private String email;
  private String password;
  private UserRole role;
  private boolean isActive;
  private String department; // Chỉ dành cho Manager
  private static Map<String, User> userDatabase = new HashMap<>();

  // Constructor
  public User(String email, String password, UserRole role, String department) {
    this.email = email;
    this.password = password;
    this.role = role;
    this.isActive = true; // Mặc định là active
    this.department = department;
  }

  // Getters and Setters
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public static void addUser(User user) {
    userDatabase.put(user.getEmail(), user);
  }

  public static User authenticate(String email, String password) {
    User user = userDatabase.get(email);
    if (user != null && user.login(user.getEmail(), password) && user.isActive) {
      return user;
    }
    return null;
  }

  public boolean login(String email, String password) {
    return this.email.equals(email) && this.password.equals(password);
  }

  public String getUserInfo() {
    return "Email: " + email + ", Role: " + role.getRoleName() + ", Active: " + isActive + ", Department: " + department;
  }

  public boolean validatePassword(String password) {
    // Kiểm tra độ dài mật khẩu
    if (password.length() < 8) {
      return false;
    }
    // Kiểm tra có ít nhất 1 chữ cái viết hoa, 1 chữ cái viết thường, 1 số và 1 ký tự đặc biệt
    boolean hasUpperCase = Pattern.compile("[A-Z]").matcher(password).find();
    boolean hasLowerCase = Pattern.compile("[a-z]").matcher(password).find();
    boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
    boolean hasSpecialChar = Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();

    return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
  }
}