package view;


import java.util.Scanner;

public class ViewAll {
    public static Scanner scanner = new Scanner(System.in);
    boolean checkActionMenu = true;
    boolean repeatMenu = true;
    boolean isLogout = false;
    private void login() {
        System.out.println("Đăng nhập");
        System.out.println("Tên đăng nhập: ");
        String userName = scanner.nextLine();
        System.out.println("Mật khẩu: ");
        String password = scanner.nextLine();


        if (userName.equals("admin") && password.equals("admin")) {
            System.out.println("Đăng nhập thành công với tài khoản Admin!");
            showAdminMenu();
        } else if (userName.equals("staff") && password.equals("staff")) {
            System.out.println("Đăng nhập thành công với tài khoản Staff!");
            showStaffMenu();
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
            login();
        }
    }

    private void logout() {
        System.out.println("Logout thành công");
        System.out.println("Ban có muốn tiếp tục hay không: ");
        System.out.println("Nhập 1. Tiếp tục");
        System.out.println("Nhập 2. Kết thúc");
        int actionMenuContinue = Integer.parseInt(scanner.nextLine());
        switch (actionMenuContinue) {
            case 1:
                login();
                break;
            case 2:
                System.out.println("Bạn đã thoát khỏi hệ thống !!!");
                checkActionMenu =false;
                isLogout =true;
                break;
            default:
                System.out.println("Không đúng lệnh, vui lòng nhập lại:");
        }
    }
    public void showAdminMenu() {
        do {
            System.out.println("===========================================================");
            System.out.println("||                 Menu Quản lý (ADMIN)                  ||");
            System.out.println("|| ----------------------------------------------------- ||");
            System.out.println("|| Nhấn 1: Quản lý Thông tin khách hàng                  ||");
            System.out.println("|| Nhấn 2: Quản lý Gói tập                               ||");
            System.out.println("|| Nhấn 3: Quản lý Dụng Cụ                               ||");
            System.out.println("|| Nhấn 4: Quản lý Nhân Viên                             ||");
            System.out.println("|| Nhấn 5: Quản lý VÉ                                    ||");
            System.out.println("|| Nhấn 6: Đăng xuất                                     ||");
            System.out.println("===========================================================");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    CustomerView customerView = new CustomerView();
                    customerView.CustommerView(1);
                    break;
                case 2:
                    GymPackagesView gymPackagesView = new GymPackagesView();
                    gymPackagesView.GymPackagess(1);
                    break;
                case 3:
                    ProductView productView = new ProductView();
                    productView.ProducttView(1);
                    break;
                case 4:
                    StaffView staffView = new StaffView();
                    staffView.StafffView();
                    break;
                case 5:
                    TicketView ticketView = new TicketView();
                    ticketView.TickettView();
                    break;
                case 6:
                    logout();
                    break;

                default:
                    System.out.println("Nhập không đúng, vui lòng nhập lại !!!");
                    continue;
            }
            if (!isLogout){
                do {
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

            }
        } while (checkActionMenu);
    }

    public void showStaffMenu() {
        do {
            checkActionMenu = true;
            System.out.println("===========================================================");
            System.out.println("||                 Menu Quản lý (STAFF)                  ||");
            System.out.println("|| ----------------------------------------------------- ||");
            System.out.println("|| Nhấn 1: Quản lý Thông tin khách hàng                  ||");
            System.out.println("|| Nhấn 2: Quản lý Gói tập                               ||");
            System.out.println("|| Nhấn 3: Quản lý Dụng Cụ                               ||");
            System.out.println("|| Nhấn 4: Đăng xuất                                     ||");
//            System.out.println("|| Nhấn 5: Quản lý VÉ                                    ||");
            System.out.println("===========================================================");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    CustomerView customerView = new CustomerView();
                    customerView.CustommerView(2);
                    break;
                case 2:
                    GymPackagesView gymPackagesView = new GymPackagesView();
                    gymPackagesView.GymPackagess(2);
                    break;
                case 3:
                    ProductView productView = new ProductView();
                    productView.ProducttView(2);
                    break;
                case 4:
                    logout();
                    break;
//                case 5:
//                    TicketView ticketView = new TicketView();
//                    ticketView.TickettView();
//                    break;
                default:
                    System.out.println("Nhập không đúng, vui lòng nhập lại !!!");
                    continue;
            }
         if (!isLogout){
             do {
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
            }
        } while (checkActionMenu);
    }

    public static void main(String[] args) {
        ViewAll viewAll = new ViewAll();
        viewAll.login();
    }

}
