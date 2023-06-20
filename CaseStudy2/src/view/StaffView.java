package view;


import model.*;
import service.IStaffService;
import service.StaffService;
import utils.ValidateUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StaffView {
    private static final int INPUT_STAFF_ADD = 1;
    private static final int INPUT_STAFF_EDIT = 2;
    private Scanner scanner = new Scanner(System.in);

    private IStaffService iStaffService;
    private List<Staff> staff;

    public StaffView() {
        iStaffService = new StaffService();
    }


    public void StafffView() {
        boolean checkActionMenu;
        do {
            checkActionMenu = true;
            System.out.println("==========================================================");
            System.out.println("||               Menu Quản lý Nhân Viên                 ||");
            System.out.println("|| ---------------------------------------------------  ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ thông tin của Nhân viên          ||");
            System.out.println("|| Nhấn 2: Thêm Nhân viên                               ||");
            System.out.println("|| Nhấn 3: Sửa thông tin Nhân viên                      ||");
            System.out.println("|| Nhấn 4: Xóa Nhân viên                                ||");
            System.out.println("|| Nhấn 5: Tìm kiếm Nhân viên theo tên                  ||");
            System.out.println("|| Nhấn 6: Sắp xếp Nhân viên theo tên                   ||");
            System.out.println("|| Nhấn 7: Quay lại                                     ||");
            System.out.println("==========================================================");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showStaff(iStaffService.getAllStaff());
                    break;
                case 2:
                    addStaffView();
                    break;
                case 3:
                    editStaffView();
                    break;
                case 4:
                    deleteStaffView();
                    break;
                case 5:
                    searchStaffByNameView();
                    break;
                case 6:
                    sortStaffByNameView();
                    break;
                case 7:
                    ViewAll viewAll = new ViewAll();
                    viewAll.showAdminMenu();
                    break;
                default:
                    System.out.println("Nhập không đúng, vui lòng nhập lại !!!");
                    continue;
            }
            boolean repeatMenu;
            do {
                repeatMenu = true;
                System.out.println("Ban có muốn tiếp tục hay không: ");
                System.out.println("Nhập 1. Tiếp tục");
                System.out.println("Nhập 2. Kết thúc");
                int actionMenuContinue = Integer.parseInt(scanner.nextLine());
                switch (actionMenuContinue) {
                    case 1:
                        checkActionMenu = true;
                        repeatMenu = false;
                        break;
                    case 2:
                        checkActionMenu = false;
                        repeatMenu = false;
                        break;
                    default:
                        System.out.println("Không đúng lệnh, vui lòng nhập lại:");
                }
            } while (repeatMenu);
        } while (checkActionMenu);
    }

    private void searchStaffByNameView() {
        System.out.println("Nhập tên cần tìm: ");
        String key = scanner.nextLine();
        List<Staff> staffsSearched = iStaffService.searchStaffByName(key);

        showStaff(staffsSearched);
    }

    private void sortStaffByNameView() {
        List<Staff> staff = iStaffService.getAllStaff();
//        staffs.sort(new Comparator<Staff>() {
//            @Override
//            public int compare(Staff o1, Staff o2) {
//                return o1.getFullName().compareTo(o2.getFullName());
//            }
//        });
        staff.sort(Comparator.comparing(Staff::getFullName));
        showStaff(staff);
    }

    private void deleteStaffView() {
        showStaff(iStaffService.getAllStaff());
        System.out.println("Nhập ID cần xóa: ");
        long idStaffDelete = Long.parseLong(scanner.nextLine());
        Staff staffDelete = iStaffService.findStaffById(idStaffDelete);
        if (staffDelete == null) {
            System.out.println("ID này không tồn tại!");
        } else {
            iStaffService.deleteStaffById(idStaffDelete);
            showStaff(iStaffService.getAllStaff());
        }
    }

    private void editStaffView() {
        showStaff(iStaffService.getAllStaff());
        System.out.println("Nhập ID cần sửa: ");
        long idStaffEdit = Long.parseLong(scanner.nextLine());
        Staff staffEdit = iStaffService.findStaffById(idStaffEdit);
        if (staffEdit != null) {
            inputStaff(INPUT_STAFF_EDIT, staffEdit);

        } else {
            System.out.println("ID này không tồn tại!");
        }
        iStaffService.updateStaffById(idStaffEdit, staffEdit);
        showStaff(iStaffService.getAllStaff());

    }

    private void addStaffView() {
        Staff staff = new Staff();
        staff.setId(System.currentTimeMillis() % 1000);
        inputStaff(INPUT_STAFF_ADD, staff);

        iStaffService.addStaff(staff);

        showStaff(iStaffService.getAllStaff());
    }

    private void inputfullNameStaff(String strACTION, int ACTION, Staff staff) {
        if (ACTION == INPUT_STAFF_ADD) {
            do {
                System.out.printf("Nhập tên %s (*) : \n", strACTION);
                String fullname = scanner.nextLine();
                if (!ValidateUtils.isValidStaffName(fullname)) {
                    System.out.println("Vui lòng nhập Tên. Tên phải bắt đầu là kí tự và từ 8-20 kí tự, không chứa số");
                } else {
                    staff.setFullName(fullname);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập tên %s của khách hàng: (Enter để bỏ qua) :\n", strACTION);
                String fullname = scanner.nextLine();
                if (!ValidateUtils.isValidStaffName(fullname)) {
                    if (fullname.equals("")) {
                        break;
                    }
                    System.out.println("Vui lòng nhập Tên. Tên phải bắt đầu là kí tự và từ 8-20 kí tự, không chứa số");
                } else {
                    staff.setFullName(fullname);
                    break;
                }
            } while (true);
        }
    }

    private void inputPhoneStaff(String strACTION, int ACTION, Staff staff) {
        if (ACTION == INPUT_STAFF_ADD) {
            do {
                System.out.printf("Nhập Số điện thoại %s (*) : \n", strACTION);
                String phone = scanner.nextLine();
                if (!ValidateUtils.isValidCustomerPhone(phone)) {
                    System.out.println("Số điện thoại không hợp lệ.Gồm 10 số");
                } else {
                    staff.setPhone(phone);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập Số điện thoại %s (Enter có thể bỏ qua) : \n", strACTION);
                String phone = scanner.nextLine();
                if (!ValidateUtils.isValidStaffPhone(phone)) {
                    if (phone.equals("")) {
                        break;
                    }
                    System.out.println("Số điện thoại không hợp lệ.Gồm 10 số");
                } else {
                    staff.setPhone(phone);
                    break;
                }
            } while (true);
        }
    }

    private void inputAddressStaff(String strACTION, int ACTION, Staff staff) {
        if (ACTION == INPUT_STAFF_ADD) {
            do {
                System.out.printf("Nhập địa chỉ %s (*) : \n", strACTION);
                String address = scanner.nextLine();
                if (!ValidateUtils.isValidStaffAddress(address)) {
                    System.out.println("Địa chỉ không hợp lệ. Ở giữa số nhà và chữ phải có khoảng trống");
                } else {
                    staff.setAddress(address);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập địa chỉ %s (Enter có thể bỏ qua) : \n", strACTION);
                String address = scanner.nextLine();
                if (!ValidateUtils.isValidStaffAddress(address)) {
                    if (address.equals("")) {
                        break;
                    }
                    System.out.println("Địa chỉ không hợp lệ. Phải từ 15-50 kí tự");
                } else {
                    staff.setAddress(address);
                    break;
                }
            } while (true);
        }
    }

    private void inputTimeStartStaff(String strACTION, int ACTION, Staff staff) {

        if (ACTION == INPUT_STAFF_ADD) {
            do {
                try {
                    System.out.printf("Nhập ngày tháng năm bắt đầu làm %s (*) : \n", strACTION);
                    String start = scanner.nextLine();
                    if (!ValidateUtils.isValidStaffTimeStart(start)) {
                        System.out.println("Ngày tháng năm không hợp lệ. ở giữa các số có dấu gạch ngang");
                    } else {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate dobDate = LocalDate.parse(start, formatter);
                        staff.setTimeStart(dobDate);
                        break;
                    }
                }catch (Exception e){
                    System.out.println("Vui lòng nhập ngày hợp lệ");
                }

            } while (true);
        } else {
            do {
               try {
                   System.out.printf("Nhập ngày tháng năm bắt đầu làm %s (Enter có thể bỏ qua) : \n", strACTION);
                   String start = scanner.nextLine();
                   if (!ValidateUtils.isValidStaffTimeStart(start)) {
                       if (start.equals("")) {
                           break;
                       }
                       System.out.println("Ngày tháng năm không hợp lệ. ở giữa các số có dấu gạch ngang");
                   } else {
                       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                       LocalDate dobDate = LocalDate.parse(start, formatter);
                       staff.setTimeStart(dobDate);
                       break;
                   }
               }catch (Exception e){
                   System.out.println("Vui lòng nhập ngày hợp lệ");
               }
            } while (true);
        }
    }

    private void inputSalaryStaff(String strACTION, int ACTION, Staff staff) {
        if (ACTION == INPUT_STAFF_ADD) {
            do {
                System.out.printf("Nhập Lương %s (*) : \n", strACTION);
                String salary = scanner.nextLine();
                if (!ValidateUtils.isValidStaffSalary(salary)) {
                    System.out.println("Nhập Lương không hợp lệ.Vui lòng nhập lại không có chữ");
                } else {
                    staff.setSalary(Float.parseFloat(salary));
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập Lương %s (Enter có thể bỏ qua) : \n", strACTION);
                String salary = scanner.nextLine();
                if (!ValidateUtils.isValidStaffSalary(salary)) {
                    if (salary.equals("")) {
                        break;
                    }
                    System.out.println("Nhập Lương không hợp lệ.Vui lòng nhập lại không có chữ");
                } else {
                    staff.setSalary(Float.parseFloat(salary));
                    break;
                }
            } while (true);
        }
    }

    private void inputStaff(int ACTION, Staff staff) {
        String strACTION = ACTION == INPUT_STAFF_ADD ? "" : "mới";
        inputfullNameStaff(strACTION, ACTION, staff);
        inputPhoneStaff(strACTION, ACTION, staff);
        inputAddressStaff(strACTION, ACTION, staff);
        inputTimeStartStaff(strACTION, ACTION, staff);
        inputSalaryStaff(strACTION, ACTION, staff);

        System.out.println("Chọn loại nhân viên: ");
        for (ERole e : ERole.values()) {
            System.out.println("Nhập " + e.getId() + "." + e.getName());
        }
        int actionMenuStaff = Integer.parseInt(scanner.nextLine());
        staff.seteRole(ERole.findById(actionMenuStaff));

    }

    public void showStaff(List<Staff> staff) {
        System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s \n",
                "ID", "FULLNAME", "PHONE", "ADDRESS","TIMESTART","SALARY","STATUS");
        for (int i = 0; i < staff.size(); i++) {
            Staff item = staff.get(i);
            System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s \n",
                    item.getId(), item.getFullName(),item.getPhone(),item.getAddress(),item.getTimeStart(),
                    item.getSalary(),item.geteRole());
        }
    }

    public void showPt(List<Staff> staff) {
        System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s \n",
                "ID", "FULLNAME", "PHONE", "ADDRESS","TIMESTART","SALARY","STATUS");
        for (int i = 0; i < staff.size(); i++) {
            Staff item = staff.get(i);
            if (item.geteRole() == ERole.PT){
                System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s \n",
                        item.getId(), item.getFullName(),item.getPhone(),item.getAddress(),item.getTimeStart(),
                        item.getSalary(),item.geteRole());
            }
        }
    }
}

