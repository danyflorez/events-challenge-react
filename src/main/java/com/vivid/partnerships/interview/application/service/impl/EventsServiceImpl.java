package com.vivid.partnerships.interview.application.service.impl;

import com.vivid.partnerships.interview.application.service.EventsService;
import com.vivid.partnerships.interview.domain.model.Event;
import com.vivid.partnerships.interview.domain.service.EventService;
import com.vivid.partnerships.interview.domain.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventsServiceImpl implements EventsService  {

    private final EventService eventService;
    private final VenueService venueService;

    @Autowired
    public EventsServiceImpl(final EventService eventService, final VenueService venueService) {
        this.eventService = eventService;
        this.venueService = venueService;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventService.getEvents();
    }

    @Override
    @Transactional
    public Event createEvent(final Event event) {
        event.setVenue(venueService.save(event.getVenue()));
        return eventService.save(event);
    }

}
