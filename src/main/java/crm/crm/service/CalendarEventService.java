package crm.crm.service;

import crm.crm.entity.CalenderEvent;

import java.util.List;

public interface CalendarEventService {
    List<CalenderEvent> getAllCalendarEvents();
    CalenderEvent getCalendarEventById(Long id);
    CalenderEvent saveCalendarEvent(CalenderEvent calendarEvent);
    void deleteCalendarEvent(Long id);
    CalenderEvent updateCalendarEvent(Long id, CalenderEvent calendarEventDetails);
}
