package view;

import model.Pt;
import model.Staff;
import model.Ticket;
import service.IPtService;
import service.PtService;
import utils.ValidateUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class PtView {
    private static final int INPUT_PT_ADD = 1;
    private static final int INPUT_PT_EDIT = 2;
    private Scanner scanner = new Scanner(System.in);

    private IPtService iPtService;
    List<Pt> ptList;

    public PtView() {
        iPtService = new PtService();
    }


    public void addPtView(Pt pt) {

        pt.setId(System.currentTimeMillis() % 1000);
        inputPt(INPUT_PT_ADD, pt);

    }

    private void inputTimeStartPt(String strACTION, int ACTION, Pt pt) {
        if (ACTION == INPUT_PT_ADD) {
            do {
                try {
                    System.out.printf("Nhập thời gian hẹn trước %s (*) : \n", strACTION);
                    String start = scanner.nextLine();
                    if (!ValidateUtils.isValidPtTimeStartt(start)) {
                        System.out.println("Thời gian không hợp lệ.Vui lòng nhập lại");
                    } else {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                        LocalTime dobTime = LocalTime.parse(start, formatter);
                        pt.setTimeStart(dobTime);
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập thời gian hợp lệ");
                }

            } while (true);
        } else {
            do {
                try {
                    System.out.printf("Nhập thời gian hẹn trước %s (Enter có thể bỏ qua) : \n", strACTION);
                    String start = scanner.nextLine();
                    if (!ValidateUtils.isValidPtTimeStartt(start)) {
                        if (start.equals("")) {
                            break;
                        }
                        System.out.println("Thời gian không hợp lệ.Vui lòng nhập lại");
                    } else {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                        LocalTime dobTime = LocalTime.parse(start, formatter);
                        pt.setTimeStart(dobTime);
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập thời gian hợp lệ");
                }
            } while (true);
        }
    }

    private void inputTIMEPT(String strACTION, int ACTION, Pt pt) {
        if (ACTION == INPUT_PT_ADD) {
            do {
                System.out.printf("Nhập thời gian tập %s (*) : \n", strACTION);
                String time = scanner.nextLine();
                if (!ValidateUtils.isValidTime(time)) {
                    System.out.println("Thời gian không hợp lệ.Vui lòng nhập lại");
                } else {
                    pt.setTime(time);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập thời gian tập %s (Enter có thể bỏ qua) : \n", strACTION);
                String time = scanner.nextLine();
                if (!ValidateUtils.isValidTime(time)) {
                    if (time.equals("")) {
                        break;
                    }
                    System.out.println("Thời gian không hợp lệ.Vui lòng nhập lại");
                } else {
                    pt.setTime(time);
                    break;
                }
            } while (true);
        }
    }

    private void inputPt(int ACTION, Pt pt) {
        String strACTION = ACTION == INPUT_PT_ADD ? "" : "mới";
        inputTimeStartPt(strACTION, ACTION, pt);
        inputTIMEPT(strACTION, ACTION, pt);
    }
//
//    private void showPt(List<Pt> pts) {
//        System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s \n",
//                "ID", "IDSTAFF", "IDCUSTOMER", "TIMESTART", "TIME");
//        for (int i = 0; i < pts.size(); i++) {
//            Pt item = pts.get(i);
//            System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s \n",
//                    item.getId(), item.getIdStaff(), item.getIdCustomer(), item.getTimeStart(), item.getTime());
//        }

}


