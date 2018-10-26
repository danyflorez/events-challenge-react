package com.vivid.partnerships.interview.domain.service.impl;

import com.vivid.partnerships.interview.domain.service.VenueService;
import com.vivid.partnerships.interview.domain.model.Venue;
import com.vivid.partnerships.interview.domain.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class VenueServiceImpl implements VenueService {

    private final VenueRepository repository;

    @Autowired
    public VenueServiceImpl(final VenueRepository repository) {
        this.repository = repository;
    }

    @Override
    public Venue save(Venue venue) {
        return repository.save(venue);
    }

}
