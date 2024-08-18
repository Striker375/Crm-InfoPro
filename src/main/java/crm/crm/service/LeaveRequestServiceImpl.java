package crm.crm.service;

import crm.crm.Exception.ResourceNotFoundException;
import crm.crm.entity.LeaveRequest;
import crm.crm.repository.LeaveRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class   LeaveRequestServiceImpl implements LeaveRequestService {


    private LeaveRequestRepository leaveRequestRepository;



    @Override
    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        LeaveRequest savedLeaveRequest = leaveRequestRepository.save(leaveRequest);
        return savedLeaveRequest;
    }

    @Override
    public LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequest) {
        LeaveRequest leaveRequest1 = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LeaveRequest not found"));

        leaveRequest1.setStartDate(leaveRequest.getStartDate());
        leaveRequest1.setEndDate(leaveRequest.getEndDate());
        leaveRequest1.setLeaveType(leaveRequest.getLeaveType());

        LeaveRequest updatedLeaveRequest = leaveRequestRepository.save(leaveRequest);
        return updatedLeaveRequest;
    }

    @Override
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    @Override
    public LeaveRequest getLeaveRequestById(Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LeaveRequest not found"));
        return leaveRequest;
    }

    @Override
    public void deleteLeaveRequest(Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LeaveRequest not found"));
        leaveRequestRepository.delete(leaveRequest);
    }
}
