package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Staff {
    private long id;
    private String fullName;
    private String phone;
    private String address;
    private LocalDate timeStart;
    private float salary;
    private ERole eRole;


    public Staff() {
    }

    public Staff(long id, String fullName, String phone, String address, LocalDate timeStart, float salary, ERole eRole) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.timeStart = timeStart;
        this.salary = salary;
        this.eRole = eRole;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullname) {
        this.fullName = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDate timeStart) {
        this.timeStart = timeStart;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public ERole geteRole() {
        return eRole;
    }

    public void seteRole(ERole eRole) {
        this.eRole = eRole;
    }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String start = timeStart.format(formatter);
        return id + "," + fullName + ',' + phone + ',' + address + ',' + start + "," + salary + "," + eRole.getName();

    }
}
