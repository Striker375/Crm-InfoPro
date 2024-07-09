package crm.crm.mapper;

import crm.crm.DTO.LeaveRequestDTO;
import crm.crm.entity.LeaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LeaveRequestMapper {
    LeaveRequestMapper INSTANCE = Mappers.getMapper(LeaveRequestMapper.class);

    LeaveRequestDTO leaveRequestToLeaveRequestDTO(LeaveRequest leaveRequest);
    LeaveRequest leaveRequestDTOToLeaveRequest(LeaveRequestDTO leaveRequestDTO);
}
