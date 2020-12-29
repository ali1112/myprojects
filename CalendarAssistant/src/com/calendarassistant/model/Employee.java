package com.calendarassistant.model;

import java.util.List;
import java.util.Objects;

public class Employee extends Person{
    private Integer employeeId;
    private Rank rank;
    private String email;
    private Employee reportingTo;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getReportingTo() {
        return reportingTo;
    }

    public void setReportingTo(Employee reportingTo) {
        this.reportingTo = reportingTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}
