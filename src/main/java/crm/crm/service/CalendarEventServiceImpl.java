package crm.crm.service;

import crm.crm.Exception.ResourceNotFoundException;
import crm.crm.entity.CalenderEvent;
import crm.crm.repository.CalenderEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service @AllArgsConstructor
public class CalendarEventServiceImpl implements CalendarEventService {
    private CalenderEventRepository calendarEventRepository;

    @Override
    public List<CalenderEvent> getAllCalenderEvents() {
        return calendarEventRepository.findAll();
    }

    @Override
    public CalenderEvent getCalendarEventById(Long id) {
        CalenderEvent calendarEvent = calendarEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CalendarEvent not found"));
        return calendarEvent;
    }


    public CalenderEvent createCalendarEvent(CalenderEvent calenderEvent) {

        // Save the entity
        CalenderEvent savedCalendarEvent = calendarEventRepository.save(calenderEvent);

        // Convert saved entity back to DTO
        return savedCalendarEvent;
    }
    @Override
    public void deleteCalendarEvent(Long id) {
        CalenderEvent calendarEvent = calendarEventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CalendarEvent not found"));
        calendarEventRepository.delete(calendarEvent);
    }

    @Override
    public CalenderEvent updateCalendarEvent(Long id, CalenderEvent calenderEvent) {
        CalenderEvent calendarEvent = calendarEventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CalendarEvent not found"));
        calendarEvent.setTitle(calenderEvent.getTitle());
        calendarEvent.setDescription(calenderEvent.getDescription());
        calendarEvent.setStartTime(calenderEvent.getStartTime());
        calendarEvent.setEndTime(calenderEvent.getEndTime());
        // autres champs
        CalenderEvent updatedCalendarEvent = calendarEventRepository.save(calendarEvent);
        return updatedCalendarEvent;
    }
}