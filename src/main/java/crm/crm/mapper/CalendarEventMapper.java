package crm.crm.mapper;
import crm.crm.DTO.CalenderEventDTO ;
import crm.crm.entity.CalenderEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CalendarEventMapper {

    CalendarEventMapper INSTANCE = Mappers.getMapper(CalendarEventMapper.class);

    CalenderEventDTO calenderEventToCalenderEventDTO(CalenderEvent calenderEvent);

    CalenderEvent calenderEventDTOToCalenderEvent(CalenderEventDTO calenderEventDTO);
}
