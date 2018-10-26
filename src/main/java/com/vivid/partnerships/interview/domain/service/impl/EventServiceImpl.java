package com.vivid.partnerships.interview.domain.service.impl;

import com.vivid.partnerships.interview.domain.service.EventService;
import com.vivid.partnerships.interview.domain.model.Event;
import com.vivid.partnerships.interview.domain.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Autowired
    public EventServiceImpl(final EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Event> getEvents() {
        return repository.findAll();
    }

    @Override
    public Event save(Event event) {
        return repository.save(event);
    }

}
