package crm.crm.service;

import crm.crm.entity.CalenderEvent;

import java.util.List;

public interface CalendarEventService {
    List<CalenderEvent> getAllCalenderEvents();
    CalenderEvent getCalendarEventById(Long id);
    CalenderEvent createCalendarEvent(CalenderEvent calenderEvent);
    void deleteCalendarEvent(Long id);
    CalenderEvent updateCalendarEvent(Long id, CalenderEvent calendarEvent);
}
