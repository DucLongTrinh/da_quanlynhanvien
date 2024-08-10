package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
  private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
  private static final String PHONE_REGEX = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";
  private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{8,20}$";

  public static boolean isValidEmail(String email) {
    return isValid(email, EMAIL_REGEX);
  }

  public static boolean isValidPhoneNumber(String phoneNumber) {
    return isValid(phoneNumber, PHONE_REGEX);
  }

  public static boolean isValidPassword(String password) {
    return isValid(password, PASSWORD_REGEX);
  }

  private static boolean isValid(String value, String regex) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(value);
    return matcher.matches();
  }
}
