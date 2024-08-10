package constants;

public enum Gender {
  MALE("Nam"),
  FEMALE("NỮ");

  public final String value;

  Gender(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
