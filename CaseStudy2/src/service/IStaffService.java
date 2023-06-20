package service;

import model.Staff;

import java.util.List;

public interface IStaffService {
    List<Staff> getAllStaff();
    Staff findStaffById(long idStaff);
    void updateStaffById(long idStaff, Staff staff);
    void deleteStaffById(long idStaff);
    void addStaff(Staff staff);

    List<Staff> searchStaffByName(String keyName);
}

