package crm.crm.service;

import crm.crm.Exception.ResourceNotFoundException;
import crm.crm.entity.CalenderEvent;
import crm.crm.repository.CalenderEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarEventServiceImpl implements CalendarEventService {
    @Autowired
    private CalenderEventRepository calendarEventRepository;

    @Override
    public List<CalenderEvent> getAllCalendarEvents() {
        return calendarEventRepository.findAll();
    }

    @Override
    public CalenderEvent getCalendarEventById(Long id) {
        return calendarEventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CalendarEvent not found"));
    }

    @Override
    public CalenderEvent saveCalendarEvent(CalenderEvent calendarEvent) {
        return calendarEventRepository.save(calendarEvent);
    }

    @Override
    public void deleteCalendarEvent(Long id) {
        CalenderEvent calendarEvent = calendarEventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CalendarEvent not found"));
        calendarEventRepository.delete(calendarEvent);
    }

    @Override
    public CalenderEvent updateCalendarEvent(Long id, CalenderEvent calendarEventDetails) {
        CalenderEvent calendarEvent = calendarEventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CalendarEvent not found"));
        calendarEvent.setTitle(calendarEventDetails.getTitle());
        calendarEvent.setStartTime(calendarEventDetails.getStartTime());
        calendarEvent.setEndTime(calendarEventDetails.getEndTime());
        // autres champs
        return calendarEventRepository.save(calendarEvent);
    }
}