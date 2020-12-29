package com.calendarassistant.model;

import java.time.LocalDateTime;
import java.util.List;

public class Meeting {
    private Integer id;
    private String title;
    private Employee organiser;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ConfRoom room;
    private List<Employee> attendees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employee getOrganiser() {
        return organiser;
    }

    public void setOrganiser(Employee organiser) {
        this.organiser = organiser;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public ConfRoom getRoom() {
        return room;
    }

    public void setRoom(ConfRoom room) {
        this.room = room;
    }

    public List<Employee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Employee> attendees) {
        this.attendees = attendees;
    }
}
