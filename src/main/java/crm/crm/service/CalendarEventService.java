package crm.crm.service;

import crm.crm.DTO.CalenderEventDTO;
import crm.crm.entity.CalenderEvent;

import java.util.List;

public interface CalendarEventService {
    List<CalenderEventDTO> getAllCalenderEvents();
    CalenderEventDTO getCalendarEventById(Long id);
    CalenderEventDTO createCalenderEvent(CalenderEventDTO calendarEventDTO);
    void deleteCalendarEvent(Long id);
    CalenderEventDTO updateCalendarEvent(Long id, CalenderEventDTO calendarEventDTO);
}
