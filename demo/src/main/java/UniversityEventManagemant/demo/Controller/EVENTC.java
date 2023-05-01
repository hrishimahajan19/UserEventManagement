package UniversityEventManagemant.demo.Controller;

import UniversityEventManagemant.demo.Service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/event")
public class EVENTC {
    @Autowired
    EventService eventService;

    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.getAllEvent();
    }

    @GetMapping("/date/{date}")
    public List<Event> getEventByDate(@PathVariable String date){
        LocalDate localDate = LocalDate.parse(date);
        return eventService.getEventByDate(localDate);
    }

    @PostMapping
    public String addEvent(@Valid @RequestBody List<Event> events) {
        return eventService.addEvent(events);
    }

    @PutMapping
    public String updateEventByEventId(@RequestBody Event event){
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/{eventId}")
    public String deleteEventByEventId(@PathVariable int eventId){
        return eventService.deleteEventByEventId(eventId);
    }
}


