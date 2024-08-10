package constants;

public enum Contract {
  FULL_TIME("Làm việc Full Time"),
  PART_TIME("Làm việc Part Time"),
  CONTRACT("Làm việc theo hợp đồng ngắn hạn");

  private final String value;

  Contract(String value) {
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
