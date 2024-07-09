package crm.crm.controller;

import crm.crm.DTO.LeaveRequestDTO;
import crm.crm.entity.LeaveRequest;
import crm.crm.service.LeaveRequestService;
import crm.crm.service.LeaveRequestServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaverequests")
@AllArgsConstructor
public class LeaveRequestController {


    private final LeaveRequestService leaveRequestService;

    @PostMapping
    public ResponseEntity<LeaveRequestDTO> createLeaveRequest(@RequestBody LeaveRequestDTO leaveRequestDTO) {
        LeaveRequestDTO createdLeaveRequest = leaveRequestService.createLeaveRequest(leaveRequestDTO);
        return new ResponseEntity<>(createdLeaveRequest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveRequestDTO> updateLeaveRequest(@PathVariable Long id, @RequestBody LeaveRequestDTO leaveRequestDTO) {
        LeaveRequestDTO updatedLeaveRequest = leaveRequestService.updateLeaveRequest(id, leaveRequestDTO);
        return new ResponseEntity<>(updatedLeaveRequest, HttpStatus.OK);
    }

    @GetMapping
    public List<LeaveRequestDTO> getAllLeaveRequests() {
        return leaveRequestService.getAllLeaveRequests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequestDTO> getLeaveRequestById(@PathVariable Long id) {
        LeaveRequestDTO leaveRequestDTO = leaveRequestService.getLeaveRequestById(id);
        return new ResponseEntity<>(leaveRequestDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeaveRequest(@PathVariable Long id) {
        leaveRequestService.deleteLeaveRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

