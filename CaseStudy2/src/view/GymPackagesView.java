package view;


import model.Customer;
import model.EPt;
import model.GymPackages;
import service.GymPackagesService;
import service.IGymPackagesService;
import utils.ValidateUtils;

import java.util.List;
import java.util.Scanner;

public class GymPackagesView {
    private static final int INPUT_GYMPACKAGES_ADD = 1;
    private static final int INPUT_GYMPACKAGES_EDIT = 2;
    private Scanner scanner = new Scanner(System.in);

    private IGymPackagesService iGymPackagesService;
    private List<GymPackages> gymPackages;

    public GymPackagesView() {
        iGymPackagesService = new GymPackagesService();
    }

    public void GymPackagess(int role) {
        boolean checkActionMenu;
        do {
            checkActionMenu = true;
            System.out.println("==========================================================");
            System.out.println("||                 Menu Quản lý Gói tập                 ||");
            System.out.println("|| ---------------------------------------------------  ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ Gói tập                          ||");
            System.out.println("|| Nhấn 2: Thêm Gói tập                                 ||");
            System.out.println("|| Nhấn 3: Sửa Gói tập                                  ||");
            System.out.println("|| Nhấn 4: Xóa Gói tập                                  ||");
            System.out.println("|| Nhấn 5: Tìm kiếm Gói tập theo Tên                    ||");
            System.out.println("|| Nhấn 6: Quay lại                                     ||");
            System.out.println("==========================================================");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showGymPackages(iGymPackagesService.getAllGymPackages());
                    break;
                case 2:
                    addGymPackagesView();
                    break;
                case 3:
                    editGymPackagesView();
                    break;
                case 4:
                    deleteGymPackagesView();
                    break;
                case 5:
                    searchGymPackagesByNameView();
                    break;
                case 6:
                    ViewAll viewAll = new ViewAll();
                    if(role==1){
                        viewAll.showAdminMenu();
                    }else
                        viewAll.showStaffMenu();
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
    private void searchGymPackagesByNameView() {
        System.out.println("Nhập tên cần tìm: ");
        String key = scanner.nextLine();
        List<GymPackages> gymPackagessSearched = iGymPackagesService.searchGymPackagesByName(key);

        showGymPackages(gymPackagessSearched);
    }
    private void deleteGymPackagesView() {
        showGymPackages(iGymPackagesService.getAllGymPackages());
        System.out.println("Nhập ID cần xóa: ");
        long idGymPackagesDelete = Long.parseLong(scanner.nextLine());
        GymPackages gymPackagesDelete = iGymPackagesService.findGymPackagesById(idGymPackagesDelete);
        if (gymPackagesDelete == null) {
            System.out.println("ID này không tồn tại!");
        } else {
            iGymPackagesService.deleteGymPackagesById(idGymPackagesDelete);
            showGymPackages(iGymPackagesService.getAllGymPackages());
        }
    }
    private void editGymPackagesView() {
        showGymPackages(iGymPackagesService.getAllGymPackages());
        System.out.println("Nhập ID cần sửa: ");
        long idGymPackagesEdit = Long.parseLong(scanner.nextLine());
        GymPackages gymPackagesEdit = iGymPackagesService.findGymPackagesById(idGymPackagesEdit);
        if (gymPackagesEdit != null) {
            inputGymPackages(INPUT_GYMPACKAGES_EDIT, gymPackagesEdit);

        } else {
            System.out.println("ID này không tồn tại!");
        }
        iGymPackagesService.updateGymPackagesById(idGymPackagesEdit, gymPackagesEdit);
        showGymPackages(iGymPackagesService.getAllGymPackages());

    }
    private void addGymPackagesView() {
        GymPackages gymPackages = new GymPackages();
        gymPackages.setId(System.currentTimeMillis() % 1000);
        inputGymPackages(INPUT_GYMPACKAGES_ADD, gymPackages);

        iGymPackagesService.addGymPackages(gymPackages);

        showGymPackages(iGymPackagesService.getAllGymPackages());
    }
    private void inputNameGymPackages(String strACTION, int ACTION, GymPackages gymPackages) {
        if (ACTION == INPUT_GYMPACKAGES_ADD) {
            do {
                System.out.printf("Nhập tên %s (*) gói tập : \n", strACTION);
                String name = scanner.nextLine();
                if (!ValidateUtils.isValidGymPackagesName(name)) {
                    System.out.println("Vui lòng nhập Tên. Tên phải bắt đầu là kí tự và từ 5-20 kí tự");
                } else {
                    gymPackages.setName(name);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập tên %s của gói tập: (Enter để bỏ qua) :\n", strACTION);
                String name = scanner.nextLine();
                if (!ValidateUtils.isValidGymPackagesName(name)) {
                    if (name.equals("")) {
                        break;
                    }
                    System.out.println("Vui lòng nhập Tên. Tên phải bắt đầu là kí tự và từ 5-20 kí tự");
                } else {
                    gymPackages.setName(name);
                    break;
                }
            } while (true);
        }
    }

    private void inputPriceGymPackages(String strACTION, int ACTION, GymPackages gymPackages) {
        if (ACTION == INPUT_GYMPACKAGES_ADD) {
            do {
                System.out.printf("Nhập Giá %s (*) gói tập : \n", strACTION);
                String price = scanner.nextLine();
                if (!ValidateUtils.isValidGymPackagesPrice(price)) {
                    System.out.println("Vui lòng nhập Giá từ 6-20 kí tự");
                } else {
                    gymPackages.setPrice(Float.parseFloat(price));
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập Giá %s của gói tập: (Enter để bỏ qua) :\n", strACTION);
                String price = scanner.nextLine();
                if (!ValidateUtils.isValidGymPackagesPrice(price)) {
                    if (price.equals("")) {
                        break;
                    }
                    System.out.println("Vui lòng nhập Giá từ 6-20 kí tự");
                } else {
                    gymPackages.setPrice(Float.parseFloat(price));
                    break;
                }
            } while (true);
        }
    }
    private void inputMonthGymPackages(String strACTION, int ACTION, GymPackages gymPackages) {
        if (ACTION == INPUT_GYMPACKAGES_ADD) {
            do {
                System.out.printf("Nhập thời gian gói tập(Tháng) %s (*) : \n", strACTION);
                int month = scanner.nextInt();
                scanner.nextLine();
                if (month <0) {
                    System.out.println("Vui lòng nhập số tháng hợp lệ");
                } else {
                    gymPackages.setMonth(month);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập thời gian gói tập(Tháng): %s (Enter để bỏ qua) :\n", strACTION);
                String monthS = scanner.nextLine();
                if (monthS.equals("")) {
                    break;
                }
                int month = Integer.parseInt(monthS);
                if (month <0) {
                    System.out.println("Vui lòng nhập số tháng hợp lệ");
                } else {
                    gymPackages.setMonth(month);
                    break;
                }

            } while (true);
        }
    }
    private void inputGymPackages(int ACTION, GymPackages gymPackages) {
        String strACTION = ACTION == INPUT_GYMPACKAGES_ADD ? "" : "mới";
        inputNameGymPackages(strACTION, ACTION, gymPackages);
        inputPriceGymPackages(strACTION,ACTION,gymPackages);
        System.out.println("Chọn loại Gói : ");
        for (EPt e : EPt.values()) {
            if(e.equals(gymPackages.getePt())){
                continue;
            }
            System.out.println("Nhập " + e.getId() + "." + e.getName());
        }
        int actionMenuPt = Integer.parseInt(scanner.nextLine());
        gymPackages.setePt(EPt.findById(actionMenuPt));
        inputMonthGymPackages(strACTION, ACTION , gymPackages);
    }


    void showGymPackages(List<GymPackages> gymPackagess) {
        System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s \n",
                "ID", "NAME", "PRICE","EPT","TIME(MONTH)");
        for (int i = 0; i < gymPackagess.size(); i++) {
            GymPackages item = gymPackagess.get(i);
            System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s \n",
                    item.getId(), item.getName(),item.getPrice(),item.getePt().getName(), item.getMonth());
        }
    }

}
