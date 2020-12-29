package com.calendarassistant.model;

public class EmployeeCalendar {
    private Employee employee;
    private Meeting meeting;
    Integer conflicStatus;

    public Integer getConflicStatus() {
        return conflicStatus;
    }

    public void setConflicStatus(Integer conflicStatus) {
        this.conflicStatus = conflicStatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }


}
