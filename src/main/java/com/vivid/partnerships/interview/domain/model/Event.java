package com.vivid.partnerships.interview.domain.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "events")
public final class Event extends SerialEntity {

    private String name;
    private LocalDate date;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "venueId", nullable = false)
    private Venue venue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

}
