package com.vivid.partnerships.interview.domain.service;

import com.vivid.partnerships.interview.domain.model.Event;

import java.util.List;

public interface EventService {

    List<Event> getEvents();

    Event save(Event event);

}
