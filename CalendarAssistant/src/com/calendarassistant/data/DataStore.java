package com.calendarassistant.data;

import com.calendarassistant.model.Employee;
import com.calendarassistant.model.EmployeeCalendar;
import com.calendarassistant.model.Meeting;

import java.util.ArrayList;
import java.util.List;

public class DataStore implements IDataStore{


    private  List<Meeting> meetings;
    private List<EmployeeCalendar> employeeCalendars;

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public List<EmployeeCalendar> getEmployeeCalendar() {
        return employeeCalendar;
    }

    public void setEmployeeCalendar(List<EmployeeCalendar> employeeCalendar) {
        this.employeeCalendar = employeeCalendar;
    }

    private  List<EmployeeCalendar> employeeCalendar;


    @Override
    public void saveMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    @Override
    public void saveEmployeeMeeting(EmployeeCalendar employeeCalendar) {
            employeeCalendars.add(employeeCalendar);
    }

    @Override
    public List<EmployeeCalendar> getEmployeeMeetings(Employee employee) {
        List<EmployeeCalendar> res = new ArrayList<>();
        for(EmployeeCalendar employeeCalendar: employeeCalendars){
            if(employeeCalendar.getEmployee().getEmployeeId().equals(employee.getEmployeeId())){
                res.add(employeeCalendar);
            }
        }
        return res;
    }
}
