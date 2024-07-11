package crm.crm.controller;

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
@RequestMapping("/leaverequests")
@AllArgsConstructor
public class LeaveRequestController {


    private final LeaveRequestService leaveRequestService;

    @PostMapping("/createLeaveRequest")
    public ResponseEntity<LeaveRequest> createLeaveRequest(@RequestBody LeaveRequest leaveRequestDTO) {
        LeaveRequest createdLeaveRequest = leaveRequestService.createLeaveRequest(leaveRequestDTO);
        return new ResponseEntity<>(createdLeaveRequest, HttpStatus.CREATED);
    }

    @PutMapping("/updateLeaveRequest/{id}")
    public ResponseEntity<LeaveRequest> updateLeaveRequest(@PathVariable Long id, @RequestBody LeaveRequest leaveRequestDTO) {
        LeaveRequest updatedLeaveRequest = leaveRequestService.updateLeaveRequest(id, leaveRequestDTO);
        return new ResponseEntity<>(updatedLeaveRequest, HttpStatus.OK);
    }

    @GetMapping("/List")
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestService.getAllLeaveRequests();
    }

    @GetMapping("/getLeaveRequestById/{id}")
    public ResponseEntity<LeaveRequest> getLeaveRequestById(@PathVariable Long id) {
        LeaveRequest leaveRequestDTO = leaveRequestService.getLeaveRequestById(id);
        return new ResponseEntity<>(leaveRequestDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteLeaveRequest/{id}")
    public ResponseEntity<Void> deleteLeaveRequest(@PathVariable Long id) {
        leaveRequestService.deleteLeaveRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

