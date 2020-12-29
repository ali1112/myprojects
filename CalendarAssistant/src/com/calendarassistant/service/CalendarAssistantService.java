package com.calendarassistant.service;

import com.calendarassistant.data.DataStore;
import com.calendarassistant.data.IDataStore;
import com.calendarassistant.model.Employee;
import com.calendarassistant.model.EmployeeCalendar;
import com.calendarassistant.model.Meeting;

import java.time.LocalDateTime;
import java.util.List;


public class CalendarAssistantService {
    private IDataStore dataStore = new DataStore();

    public List<EmployeeCalendar> assistCalendar(Employee employee, LocalDateTime date){

        List<EmployeeCalendar> employeeMeetings = dataStore.getEmployeeMeetings(employee);

    return null;
    }

    private List<EmployeeCalendar> resolveConflics( List<EmployeeCalendar> employeeMeetings){

        for(EmployeeCalendar employeeCalendar : employeeMeetings){

        }

        return null;
    }

}
