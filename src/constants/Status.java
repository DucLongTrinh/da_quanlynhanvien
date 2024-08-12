package constants;

public enum Status {
  ACTIVE("Hoạt động"),
  INACTIVE("Không hoạt động");

  private final String value;

  Status(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }


  @Override
  public String toString() {
    return value;
  }
  }
