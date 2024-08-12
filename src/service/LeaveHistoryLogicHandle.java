package service;

import entity.Leave;
import entity.LeaveHistory;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeaveHistoryLogicHandle {
  private List<LeaveHistory> leaveHistories;

  public LeaveHistoryLogicHandle() {
    this.leaveHistories = new ArrayList<>();
  }

  // Thêm mới một bản ghi lịch sử nghỉ phép
  public void addLeaveHistory(LeaveHistory leaveHistory) {
    leaveHistories.add(leaveHistory);
  }

  // Lấy danh sách tất cả các bản ghi lịch sử nghỉ phép
  public List<LeaveHistory> getAllLeaveHistories() {
    return new ArrayList<>(leaveHistories);
  }

  // Lấy danh sách lịch sử nghỉ phép theo trạng thái phê duyệt
  public List<LeaveHistory> getLeaveHistoriesByApproval(boolean approved) {
    return leaveHistories.stream()
        .filter(leaveHistory -> leaveHistory.isApproved() == approved)
        .collect(Collectors.toList());
  }

  // Tìm kiếm lịch sử nghỉ phép theo lý do
  public List<LeaveHistory> searchLeaveHistoriesByReason(String reason) {
    return leaveHistories.stream()
        .filter(leaveHistory -> leaveHistory.getReason().equalsIgnoreCase(reason))
        .collect(Collectors.toList());
  }


  // Các phương thức khác (như cập nhật lịch sử, xóa, v.v.) có thể được thêm vào đây
}
