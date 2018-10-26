package com.vivid.partnerships.interview.controller;

import com.vivid.partnerships.interview.application.service.EventsService;
import com.vivid.partnerships.interview.domain.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/events")
public final class EventController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    private final EventsService service;

    @Autowired
    public EventController(final EventsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Event> getEvents() {
        List<Event> events = service.getAllEvents();
        LOGGER.info("Returning {} events", events.size());
        return events;
    }

    @PostMapping
    public Event createEvent(@Valid @RequestBody Event event) {
        return service.createEvent(event);
    }

}
