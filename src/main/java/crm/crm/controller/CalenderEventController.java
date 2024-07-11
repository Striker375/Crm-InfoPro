package crm.crm.controller;

import crm.crm.entity.CalenderEvent;
import crm.crm.service.CalendarEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/calendarevents")
public class CalenderEventController {

     private final CalendarEventService calendarEventService;


    public CalenderEventController(CalendarEventService calendarEventService) {
        this.calendarEventService = calendarEventService;
    }

    @GetMapping("/CalenderEvents/List")
    public List<CalenderEvent> getAllCalenderEvents() {
        return calendarEventService.getAllCalenderEvents();
    }

    @GetMapping("/CalendarEvent/{id}")
    public ResponseEntity<CalenderEvent> getCalendarEventById(@PathVariable Long id) {
        CalenderEvent calenderEvent = calendarEventService.getCalendarEventById(id);
        return ResponseEntity.ok(calenderEvent);
    }

    @PostMapping("/calenderEvent/create")
    public ResponseEntity<CalenderEvent> createCalendarEvent(@RequestBody CalenderEvent calenderEvent) {
        CalenderEvent createdCalenderEvent = calendarEventService.createCalendarEvent(calenderEvent);
        return ResponseEntity.ok(createdCalenderEvent);
    }

    @PutMapping("/calenderEvent/update/{id}")
    public ResponseEntity<CalenderEvent> updateCalendarEvent(@PathVariable Long id, @RequestBody CalenderEvent calenderEvent) {
        CalenderEvent updatedCalenderEvent = calendarEventService.updateCalendarEvent(id, calenderEvent);
        return ResponseEntity.ok(updatedCalenderEvent);
    }

    @DeleteMapping("/calenderEvent/Delete/{id}")
    public ResponseEntity<Void> deleteCalanderEvent(@PathVariable Long id) {
        calendarEventService.deleteCalendarEvent(id);
        return ResponseEntity.noContent().build();
    }
}
