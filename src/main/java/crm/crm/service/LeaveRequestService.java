package crm.crm.service;

import crm.crm.DTO.LeaveRequestDTO;

import java.util.List;

public interface LeaveRequestService {
    LeaveRequestDTO createLeaveRequest(LeaveRequestDTO leaveRequestDTO);
    LeaveRequestDTO updateLeaveRequest(Long id, LeaveRequestDTO leaveRequestDTO);
    List<LeaveRequestDTO> getAllLeaveRequests();
    LeaveRequestDTO getLeaveRequestById(Long id);
    void deleteLeaveRequest(Long id);
}
