package com.calendarassistant.service;

import com.calendarassistant.data.DataStore;
import com.calendarassistant.data.IDataStore;
import com.calendarassistant.model.Employee;
import com.calendarassistant.model.EmployeeCalendar;
import com.calendarassistant.model.Meeting;

public class MeetingOrganiserService {

    IDataStore dataStore = new DataStore();

    public void scheduleMeeting(Meeting meeting){
        dataStore.saveMeeting(meeting);
        Employee organiser = meeting.getOrganiser();
        EmployeeCalendar employeeCalendar = new EmployeeCalendar();
        employeeCalendar.setEmployee(organiser);
        employeeCalendar.setMeeting(meeting);
        dataStore.saveEmployeeMeeting(employeeCalendar);
    }
}
