package crm.crm.controller;

import crm.crm.DTO.CalenderEventDTO;
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
    public List<CalenderEventDTO> getAllCalenderEvents() {
        return calendarEventService.getAllCalenderEvents();
    }

    @GetMapping("/CalendarEvent/{id}")
    public ResponseEntity<CalenderEventDTO> getCalendarEventById(@PathVariable Long id) {
        CalenderEventDTO calenderEventDTO = calendarEventService.getCalendarEventById(id);
        return ResponseEntity.ok(calenderEventDTO);
    }

    @PostMapping("/calenderEvent/create")
    public ResponseEntity<CalenderEventDTO> createCalendarEvent(@RequestBody CalenderEventDTO calenderEventDTO) {
        CalenderEventDTO createdCalenderEvent = calendarEventService.createCalendarEvent(calenderEventDTO);
        return ResponseEntity.ok(createdCalenderEvent);
    }

    @PutMapping("/calenderEvent/update/{id}")
    public ResponseEntity<CalenderEventDTO> updateCalendarEvent(@PathVariable Long id, @RequestBody CalenderEventDTO calenderEventDTO) {
        CalenderEventDTO updatedCalenderEvent = calendarEventService.updateCalendarEvent(id, calenderEventDTO);
        return ResponseEntity.ok(updatedCalenderEvent);
    }

    @DeleteMapping("/calenderEvent/Delete/{id}")
    public ResponseEntity<Void> deleteCalanderEvent(@PathVariable Long id) {
        calendarEventService.deleteCalendarEvent(id);
        return ResponseEntity.noContent().build();
    }
}
