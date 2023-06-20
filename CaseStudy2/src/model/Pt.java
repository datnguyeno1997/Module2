package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Pt {
    private long id;
    private long idStaff;
    private long idCustomer;
    private LocalTime timeStart;
    private String time;

    public Pt() {
    }

    public Pt(long id, long idStaff, long idCustomer, LocalTime timeStart, String time) {
        this.id = id;
        this.idStaff = idStaff;
        this.idCustomer = idCustomer;
        this.timeStart = timeStart;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public long getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(long idStaff) {
        this.idStaff = idStaff;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String startTime = timeStart.format(formatter);
        return id + "," + idStaff + "," + idCustomer + "," + startTime + "," + time;
    }
}
