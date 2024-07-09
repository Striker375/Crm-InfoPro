package crm.crm.service;

import crm.crm.DTO.CalenderEventDTO;
import crm.crm.Exception.ResourceNotFoundException;
import crm.crm.entity.CalenderEvent;
import crm.crm.mapper.CalendarEventMapper;
import crm.crm.repository.CalenderEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalendarEventServiceImpl implements CalendarEventService {
    @Autowired
    private CalenderEventRepository calendarEventRepository;

    private CalendarEventMapper calendarEventMapper ;

    @Override
    public List<CalenderEventDTO> getAllCalenderEvents() {
        return calendarEventRepository.findAll().stream()
                .map(calendarEventMapper::calenderEventToCalenderEventDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CalenderEventDTO getCalendarEventById(Long id) {
        CalenderEvent calendarEvent = calendarEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CalendarEvent not found"));
        return calendarEventMapper.calenderEventToCalenderEventDTO(calendarEvent);
    }


    public CalenderEventDTO createCalendarEvent(CalenderEventDTO calenderEventDTO) {
        // Convert DTO to entity
        CalenderEvent calendarEvent = calendarEventMapper.calenderEventDTOToCalenderEvent(calenderEventDTO);

        // Save the entity
        CalenderEvent savedCalendarEvent = calendarEventRepository.save(calendarEvent);

        // Convert saved entity back to DTO
        return calendarEventMapper.calenderEventToCalenderEventDTO(savedCalendarEvent);
    }
    @Override
    public void deleteCalendarEvent(Long id) {
        CalenderEvent calendarEvent = calendarEventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CalendarEvent not found"));
        calendarEventRepository.delete(calendarEvent);
    }

    @Override
    public CalenderEventDTO updateCalendarEvent(Long id, CalenderEventDTO calenderEventDTO) {
        CalenderEvent calendarEvent = calendarEventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CalendarEvent not found"));
        calendarEvent.setTitle(calenderEventDTO.getTitle());
        calendarEvent.setDescription(calenderEventDTO.getDescription());
        calendarEvent.setStartTime(calenderEventDTO.getStartTime());
        calendarEvent.setEndTime(calenderEventDTO.getEndTime());
        // autres champs
        CalenderEvent updatedCalendarEvent = calendarEventRepository.save(calendarEvent);
        return calendarEventMapper.calenderEventToCalenderEventDTO(updatedCalendarEvent);
    }
}