package constants;

public enum UserRole {
  ADMIN("Chủ sở hữu quản trị hay giám đốc "),
  MANAGER("Quản lý ban hay trưởng đơn vị"),
  NORMAL("Người dùng bình thường");

  private final String roleName;

  UserRole(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleName() {
    return roleName;
  }

  @Override
  public String toString() {
    return roleName;
  }
}
