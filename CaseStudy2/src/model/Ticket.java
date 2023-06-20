package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private long id;
    private long idCustomer;
    private long idGymPackages;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private LocalTime timeStart;
    private int time;
    private long idPt;
    private Float fee;
    private Float discount;

    public Ticket() {
    }

    public Ticket(long id, long idCustomer, long idGymPackages, LocalDate dateStart, LocalDate dateEnd, LocalTime timeStart, Integer time, long idPt, Float fee, Float discount) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.idGymPackages = idGymPackages;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.timeStart = timeStart;
        this.time = time;
        this.idPt = idPt;
        this.fee = fee;
        this.discount = discount;
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

    public long getIdGymPackages() {
        return idGymPackages;
    }

    public void setIdGymPackages(long idGymPackages) {
        this.idGymPackages = idGymPackages;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public long getIdPt() {
        return idPt;
    }

    public void setIdPt(long idPt) {
        this.idPt = idPt;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String startDate = dateStart.format(formatter);
        String endDate = dateEnd.format(formatter);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
        String startTime = timeStart==null ?"0" :  timeStart.format(formatter2);
        return  id +
                "," + idCustomer +
                "," + idGymPackages +
                "," + startDate +
                "," + endDate +
                "," + startTime +
                "," + time +
                "," + idPt +
                "," + fee +
                "," + discount ;
    }
}
