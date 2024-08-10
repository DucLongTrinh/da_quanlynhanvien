package constants;

public enum Literacy {

  HIGHSCHOOL("Phổ thông"),
  COLLEGE("Cao Đẳng"),
  UNIVERSITY("Đại học");

  private final String displayName;

  // Constructor
  Literacy(String displayName) {
    this.displayName = displayName;
  }

  // Getter
  public String getDisplayName() {
    return displayName;
  }


  @Override
  public String toString() {
    return displayName;  // đề dễ hiển thị hơn khi cần in giá trị của enum
  }
}
