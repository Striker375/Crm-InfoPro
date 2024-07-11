package crm.crm.service;

import crm.crm.entity.LeaveRequest;

import java.util.List;

public interface LeaveRequestService {
    LeaveRequest createLeaveRequest(LeaveRequest leaveRequest);
    LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequest);
    List<LeaveRequest> getAllLeaveRequests();
    LeaveRequest getLeaveRequestById(Long id);
    void deleteLeaveRequest(Long id);
}
