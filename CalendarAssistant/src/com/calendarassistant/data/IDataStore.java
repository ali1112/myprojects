package com.calendarassistant.data;

import com.calendarassistant.model.Employee;
import com.calendarassistant.model.EmployeeCalendar;
import com.calendarassistant.model.Meeting;

import java.util.Calendar;
import java.util.List;

public interface IDataStore {

    public void saveMeeting(Meeting meeting);
    public void saveEmployeeMeeting(EmployeeCalendar employeeCalendar);

    public List<EmployeeCalendar> getEmployeeMeetings(Employee employee);

}
