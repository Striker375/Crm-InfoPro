package crm.crm.service;

import crm.crm.DTO.LeaveRequestDTO;
import crm.crm.Exception.ResourceNotFoundException;
import crm.crm.entity.LeaveRequest;
import crm.crm.mapper.LeaveRequestMapper;
import crm.crm.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;


    private LeaveRequestMapper leaveRequestMapper;

    @Override
    public LeaveRequestDTO createLeaveRequest(LeaveRequestDTO leaveRequestDTO) {
        LeaveRequest leaveRequest = leaveRequestMapper.leaveRequestDTOToLeaveRequest(leaveRequestDTO);
        LeaveRequest savedLeaveRequest = leaveRequestRepository.save(leaveRequest);
        return leaveRequestMapper.leaveRequestToLeaveRequestDTO(savedLeaveRequest);
    }

    @Override
    public LeaveRequestDTO updateLeaveRequest(Long id, LeaveRequestDTO leaveRequestDTO) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LeaveRequest not found"));

        leaveRequest.setStartDate(leaveRequestDTO.getStartDate());
        leaveRequest.setEndDate(leaveRequestDTO.getEndDate());
        leaveRequest.setLeaveType(leaveRequestDTO.getLeaveType());

        LeaveRequest updatedLeaveRequest = leaveRequestRepository.save(leaveRequest);
        return leaveRequestMapper.leaveRequestToLeaveRequestDTO(updatedLeaveRequest);
    }

    @Override
    public List<LeaveRequestDTO> getAllLeaveRequests() {
        return leaveRequestRepository.findAll().stream()
                .map(leaveRequestMapper::leaveRequestToLeaveRequestDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LeaveRequestDTO getLeaveRequestById(Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LeaveRequest not found"));
        return leaveRequestMapper.leaveRequestToLeaveRequestDTO(leaveRequest);
    }

    @Override
    public void deleteLeaveRequest(Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LeaveRequest not found"));
        leaveRequestRepository.delete(leaveRequest);
    }
}
