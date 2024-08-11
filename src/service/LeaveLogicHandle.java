package service;

import entity.Leave;

import java.util.ArrayList;
import java.util.List;

public class LeaveLogicHandle {

  private List<Leave> leaveList;

  public LeaveLogicHandle() {
    this.leaveList = new ArrayList<>();
  }

  // Thêm ngày nghỉ phép
  public void addLeave(Leave leave) {
    leaveList.add(leave);
  }

  // Hiển thị tất cả các ngày nghỉ phép
  public void displayAllLeaves() {
    for (Leave leave : leaveList) {
      displayLeaveInfo(leave);
    }
  }

  // Hiển thị thông tin nghỉ phép
  private void displayLeaveInfo(Leave leave) {
    System.out.println("Ngày nghỉ: " + leave.getStartDate() + " đến " + leave.getEndDate()
        + ", Lý do: " + leave.getReason() + ", Trạng thái: " + leave.getApprovalStatus());
  }

  // Phê duyệt nghỉ phép
  public void approveLeave(Leave leave, String userRole) {
    if (userRole.equals("Manager")) {
      leave.setApprovalStatus("Approved"); // Trưởng phòng phê duyệt
      System.out.println("Trưởng phòng đã phê duyệt yêu cầu nghỉ phép.");
    } else if (userRole.equals("Admin")) {
      leave.setApprovalStatus("Approved"); // Giám đốc phê duyệt
      System.out.println("Giám đốc đã phê duyệt yêu cầu nghỉ phép.");
    } else {
      System.out.println("Chỉ có Trưởng phòng hoặc Giám đốc mới có quyền phê duyệt.");
    }
  }

  // Từ chối nghỉ phép
  public void rejectLeave(Leave leave, String userRole) {
    if (userRole.equals("Manager") || userRole.equals("Admin")) {
      leave.setApprovalStatus("Rejected"); // Phê duyệt từ chối
      System.out.println("Yêu cầu nghỉ phép đã bị từ chối.");
    } else {
      System.out.println("Chỉ có Trưởng phòng hoặc Giám đốc mới có quyền từ chối.");
    }
  }

  // Xóa ngày nghỉ phép
  public void removeLeave(Leave leave) {
    leaveList.remove(leave);
  }

  // Kiểm tra nếu có ngày nghỉ nào trùng với khoảng thời gian cho trước
  public boolean hasConflict(Leave newLeave) {
    for (Leave leave : leaveList) {
      if ((newLeave.getStartDate().isBefore(leave.getEndDate()) || newLeave.getStartDate()
          .isEqual(leave.getEndDate())) &&
          (newLeave.getEndDate().isAfter(leave.getStartDate()) || newLeave.getEndDate()
              .isEqual(leave.getStartDate()))) {
        return true;
      }
    }
    return false;
  }


}