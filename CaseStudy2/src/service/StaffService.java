package service;

import config.Config;
import model.Staff;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class StaffService implements IStaffService {
    private final String pathStaff = "D:\\moduel2\\CaseStudy2\\src\\data\\staff.txt";

    public List<Staff> getAllStaff() {
        return FileUtils.readFile(pathStaff, Config.TYPE_STAFF);
    }

    public Staff findStaffById(long idStaff) {
        List<Staff> staffs = FileUtils.readFile(pathStaff, Config.TYPE_STAFF);
        for (Staff c : staffs) {
            if (c.getId() == idStaff) {
                return c;
            }
        }
        return null;
    }

    public void updateStaffById(long idStaff, Staff staff) {
        List<Staff> staffs = FileUtils.readFile(pathStaff, Config.TYPE_STAFF);
        for (Staff c : staffs) {
            if (c.getId() == idStaff) {
                c.setFullName(staff.getFullName());
                c.setPhone(staff.getPhone());
                c.setAddress(staff.getAddress());
                c.setTimeStart(staff.getTimeStart());
                c.setSalary(staff.getSalary());
                c.seteRole(staff.geteRole());
            }
        }
        FileUtils.writeFile(pathStaff, staffs);
    }

    public void deleteStaffById(long idStaff) {
        List<Staff> staffs = FileUtils.readFile(pathStaff, Config.TYPE_STAFF);
        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).getId() == idStaff) {
                staffs.remove(i);
                break;
            }
        }
        FileUtils.writeFile(pathStaff, staffs);
    }

    public void addStaff(Staff staff) {
        List<Staff> staffs = FileUtils.readFile(pathStaff, Config.TYPE_STAFF);
        staffs.add(staff);
        FileUtils.writeFile(pathStaff, staffs);
    }

    @Override
    public List<Staff> searchStaffByName(String keyName) {
        List<Staff> staffs = getAllStaff();
        List<Staff> results = new ArrayList<>();

        for (Staff u : staffs) {
            if (u.getFullName().toLowerCase().contains(keyName.toLowerCase())) {
                results.add(u);
            }
        }
        return results;
    }
}

