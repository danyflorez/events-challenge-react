package com.vivid.partnerships.interview.domain.repository;

import com.vivid.partnerships.interview.domain.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query("select event from Event event left join fetch event.venue")
    List<Event> findAll();

}
