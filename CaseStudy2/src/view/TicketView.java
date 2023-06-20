package view;


import model.*;
import service.*;
import utils.ValidateUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TicketView {
    private static final int INPUT_TICKET_ADD = 1;
    private static final int INPUT_TICKET_EDIT = 2;
    private Scanner scanner = new Scanner(System.in);

    private ITicketService iTicketService;
    private List<Ticket> tickets;

    private ICustomerService icustomerService;
    private CustomerView customerView;
    private GymPackagesView gymPackagesView;
    private IGymPackagesService iGymPackagesService;
    private IStaffService iStaffService;
    private StaffView staffView;
    private PtView ptView;

    public TicketView() {
        iTicketService = new TicketService();
        icustomerService = new CustomerService();
        iGymPackagesService = new GymPackagesService();
        iStaffService = new StaffService();
        staffView = new StaffView();
        customerView = new CustomerView();
        gymPackagesView = new GymPackagesView();
        ptView = new PtView();
    }


    public void TickettView() {
        boolean checkActionMenu;
        do {
            checkActionMenu = true;
            System.out.println("==========================================================");
            System.out.println("||                   Menu Quản lý VÉ                    ||");
            System.out.println("|| ---------------------------------------------------  ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ Vé                               ||");
            System.out.println("|| Nhấn 2: Thêm Vé                                      ||");
            System.out.println("|| Nhấn 3: Xóa Vé                                       ||");
            System.out.println("|| Nhấn 4: Quay lại                                     ||");
            System.out.println("==========================================================");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showTicket(iTicketService.getAllTicket());
                    break;
                case 2:
                    addTicketView();
                    break;
                case 3:
                    deleteTicketView();
                    break;
                case 4:
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

    private void deleteTicketView() {
        showTicket(iTicketService.getAllTicket());
        System.out.println("Nhập ID cần xóa: ");
        long idTicketDelete = Long.parseLong(scanner.nextLine());
        Ticket ticketDelete = iTicketService.findTicketById(idTicketDelete);
        if (ticketDelete == null) {
            System.out.println("ID này không tồn tại!");
        } else {
            iTicketService.deleteTicketById(idTicketDelete);
            showTicket(iTicketService.getAllTicket());
        }
    }

    private void addTicketView() {
        Ticket ticket = new Ticket();
        ticket.setId(System.currentTimeMillis() % 1000);
        inputTicket(INPUT_TICKET_ADD, ticket);

        iTicketService.addTicket(ticket);

        showTicket(iTicketService.getAllTicket());
    }

    private void inputDateStartTicket(String strACTION, int ACTION, Ticket ticket) {
        if (ACTION == INPUT_TICKET_ADD) {
            do {
                try {
                    System.out.printf("Nhập ngày tháng năm bắt đầu tập %s (*) : \n", strACTION);
                    String start = scanner.nextLine();
                    if (!ValidateUtils.isValidStaffTimeStart(start)) {
                        System.out.println("Ngày tháng năm không hợp lệ. ở giữa các số có dấu gạch ngang");
                    } else {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate dobDate = LocalDate.parse(start, formatter);
                        if (dobDate.compareTo(LocalDate.now()) >= 0) {
                            ticket.setDateStart(dobDate);
                            break;
                        } else {
                            System.out.println("Vui lòng nhập ngày >= hiện tại");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập ngày hợp lệ");
                }

            } while (true);
        } else {
            do {
                try {
                    System.out.printf("Nhập ngày tháng năm bắt đầu tập %s (Enter có thể bỏ qua) : \n", strACTION);
                    String start = scanner.nextLine();
                    if (!ValidateUtils.isValidStaffTimeStart(start)) {
                        if (start.equals("")) {
                            break;
                        }
                        System.out.println("Ngày tháng năm không hợp lệ. ở giữa các số có dấu gạch ngang");
                    } else {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate dobDate = LocalDate.parse(start, formatter);
                        if (dobDate.compareTo(LocalDate.now()) >= 0) {
                            ticket.setDateStart(dobDate);
                            break;
                        } else {
                            System.out.println("Vui lòng nhập ngày >= hiện tại");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập ngày hợp lệ");
                }
            } while (true);
        }
    }

    private void inputDiscountTicket(String strACTION, int ACTION, Ticket ticket) {
        if (ACTION == INPUT_TICKET_ADD) {
            do {
                System.out.println("Nhập % giảm giá (*) : " + strACTION);
                String discountS = scanner.nextLine();
                try {
                    Float discount = Float.valueOf(discountS);
                    if (discount < 0 || discount > 100) {
                        System.out.println(" % giảm giá không hợp lệ");
                    } else {
                        ticket.setDiscount(discount);
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập % hợp lệ");
                }

            } while (true);
        } else {
            do {
                try {
                    System.out.printf("Nhập % giảm giá %s (Enter có thể bỏ qua) : \n", strACTION);
                    String discountS = scanner.nextLine();

                    if (discountS.equals("")) {
                        break;
                    }
                    Float discount = Float.valueOf(discountS);
                    if (discount < 0 || discount > 100) {
                        System.out.println(" % giảm giá không hợp lệ");
                    } else {
                        ticket.setDiscount(discount);
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập % hợp lệ");
                }
            } while (true);
        }
    }

    private void inputTicket(int ACTION, Ticket ticket) {
        long idcustomer;
        String strACTION = ACTION == INPUT_TICKET_ADD ? "" : "mới";
        System.out.println("Chọn loại khách hàng: ");
        System.out.println("1.Khách hàng mới.");
        System.out.println("2.Khách hàng đã có thẻ.");
        int actionMenuTicket = Integer.parseInt(scanner.nextLine());

        switch (actionMenuTicket) {
            case 1:
                idcustomer = customerView.addCustomerNew();
                ticket.setIdCustomer(idcustomer);
                break;
            case 2:
                customerView.showCustomer(icustomerService.getAllCustomer());
                System.out.println("Chọn id khách hàng: ");
                idcustomer = Integer.parseInt(scanner.nextLine());
                ticket.setIdCustomer(idcustomer);
                break;
        }

        gymPackagesView.showGymPackages(iGymPackagesService.getAllGymPackages());
        System.out.println("Vui lòng chọn Id gói tập");
        long idGymPackages = Long.parseLong(scanner.nextLine());
        ticket.setIdGymPackages(idGymPackages);

        if (iGymPackagesService.checkHasPtByGymPackagesId(idGymPackages)) {
            //chọn Pt và tạo Pt
            staffView.showPt(iStaffService.getAllStaff());
            System.out.println("Gói này bao gồm tập với Pt. Vui lòng chọn Pt ");
            long idPt = Long.parseLong(scanner.nextLine());

            ticket.setIdPt(idPt);
            System.out.println("Nhập thời gian tập (ví dụ: 07:30): ");
            LocalTime timeStart = LocalTime.parse(scanner.nextLine());
            ticket.setTimeStart(timeStart);
            System.out.println("Thời gian tập từng buổi (Ví dụ: 2):");
            int time = Integer.parseInt(scanner.nextLine());
            ticket.setTime(time);
        }

        GymPackages gymPackages = iGymPackagesService.findGymPackagesById(idGymPackages);
        inputDiscountTicket(strACTION, ACTION, ticket);
        float price = gymPackages.getPrice();
        float fee = price - (price * ticket.getDiscount() / 100);
        ticket.setFee(fee);

        inputDateStartTicket(strACTION, ACTION, ticket);
        int month = gymPackages.getMonth();
        LocalDate dateEnd = ticket.getDateStart().plusMonths(month);
        ticket.setDateEnd(dateEnd);

    }

    private void showTicket(List<Ticket> tickets) {
        System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s \n",
                "ID", "NAME CUSTOMER", "NAME PACKAGES", "DAYSTART", "DAYEND", "TIMESTART", "TIME", "PT", "PRICE", "DISCOUNT");
        for (Ticket item : tickets) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String start = item.getDateStart().format(formatter);
            String end = item.getDateEnd().format(formatter);
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
            String startTime = item.getTimeStart() == null ? "" : item.getTimeStart().format(formatter2);
            String time = item.getTime() == 0 ? "" : item.getTime().toString();
            Customer customer = icustomerService.findCustomerById(item.getIdCustomer());
            GymPackages gymPackages = iGymPackagesService.findGymPackagesById(item.getIdGymPackages());
            Staff pt = iStaffService.findStaffById(item.getIdPt());
            String namePt = "Không có PT";
            if (pt != null) {
                namePt = pt.getFullName();
            }
            System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s \n",
                    item.getId(), customer.getName(), gymPackages.getName(), start
                    , end, startTime, time, namePt, item.getFee(), item.getDiscount());
        }
    }
}