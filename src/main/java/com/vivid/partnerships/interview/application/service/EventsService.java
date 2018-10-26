package com.vivid.partnerships.interview.application.service;

import com.vivid.partnerships.interview.domain.model.Event;

import java.util.List;

public interface EventsService {

    List<Event> getAllEvents();

    Event createEvent(Event event);

}
