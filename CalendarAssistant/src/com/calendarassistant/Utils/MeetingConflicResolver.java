package com.calendarassistant.Utils;

import com.calendarassistant.model.Employee;
import com.calendarassistant.model.EmployeeCalendar;

public class MeetingConflicResolver {

    public EmployeeCalendar resolveConflict(EmployeeCalendar employeeCalendar1, EmployeeCalendar employeeCalendar2){
        Employee employee = employeeCalendar1.getEmployee();
        if(employeeCalendar1.getMeeting().getOrganiser().equals( employeeCalendar1.getEmployee())){
            employeeCalendar2.setConflicStatus(0);
            return employeeCalendar1;
        }
        else if(employeeCalendar2.getMeeting().getOrganiser().equals( employeeCalendar2.getEmployee())){
            employeeCalendar1.setConflicStatus(0);
            return employeeCalendar2;
        }
        if(employee.getRank().getValue() < employeeCalendar1.getMeeting().getOrganiser().getRank().getValue()
                && employee.getRank().getValue() < employeeCalendar2.getMeeting().getOrganiser().getRank().getValue()){

            if(employeeCalendar1.getMeeting().getOrganiser().getRank().getValue() > employeeCalendar2.getMeeting().getOrganiser().getRank().getValue()){
                employeeCalendar2.setConflicStatus(0);
                return employeeCalendar1;
            }
            else {
                employeeCalendar1.setConflicStatus(0);
                return employeeCalendar2;
            }
        }
        else if (employee.getRank().getValue() < employeeCalendar1.getMeeting().getOrganiser().getRank().getValue()) {
            employeeCalendar2.setConflicStatus(0);
            return employeeCalendar1;
        }
        else if (employee.getRank().getValue() < employeeCalendar2.getMeeting().getOrganiser().getRank().getValue()) {
            employeeCalendar1.setConflicStatus(0);
            return employeeCalendar2;
        }
        else if(employeeCalendar1.getMeeting().getAttendees().size() > employeeCalendar2.getMeeting().getAttendees().size()){
            employeeCalendar1.setConflicStatus(0);
            return  employeeCalendar2;
        }

        else {
            employeeCalendar2.setConflicStatus(0);
            return employeeCalendar1;
        }

    }
}
