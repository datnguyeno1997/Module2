package view;

import model.Customer;
import service.CustomerService;
import service.ICustomerService;
import utils.ValidateUtils;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private static final int INPUT_CUSTOMER_ADD = 1;
    private static final int INPUT_CUSTOMER_EDIT = 2;
    private Scanner scanner = new Scanner(System.in);

    private ICustomerService icustomerService;
    private List<Customer> customers;

    public CustomerView() {
        icustomerService = new CustomerService();
    }


    public void CustommerView(int role) {
        boolean checkActionMenu;
        do {
            checkActionMenu = true;
            System.out.println("==========================================================");
            System.out.println("||       Menu Quản lý Thông tin khách hàng              ||");
            System.out.println("|| ---------------------------------------------------  ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ thông tin của Khách Hàng         ||");
            System.out.println("|| Nhấn 2: Thêm khách hàng                              ||");
            System.out.println("|| Nhấn 3: Sửa thông tin khách hàng                     ||");
            System.out.println("|| Nhấn 4: Xóa khách hàng                               ||");
            System.out.println("|| Nhấn 5: Tìm kiếm khách hàng theo Tên                 ||");
            System.out.println("|| Nhấn 6: Quay lai                                     ||");
            System.out.println("==========================================================");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showCustomer(icustomerService.getAllCustomer());
                    break;
                case 2:
                    addCustomerView();
                    break;
                case 3:
                    editCustomerView();
                    break;
                case 4:
                    deleteCustomerView();
                    break;
                case 5:
                    searchCustomerByNameView();
                    break;
                case 6:
                    ViewAll viewAll = new ViewAll();
                    if (role == 1) {
                        viewAll.showAdminMenu();
                    } else
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


    private void searchCustomerByNameView() {
        System.out.println("Nhập tên cần tìm: ");
        String key = scanner.nextLine();
        List<Customer> customersSearched = icustomerService.searchCustomerByName(key);

        showCustomer(customersSearched);
    }

    private void deleteCustomerView() {
        showCustomer(icustomerService.getAllCustomer());
        System.out.println("Nhập ID cần xóa: ");
        long idCustomerDelete = Long.parseLong(scanner.nextLine());
        Customer customerDelete = icustomerService.findCustomerById(idCustomerDelete);
        if (customerDelete == null) {
            System.out.println("ID này không tồn tại!");
        } else {
            icustomerService.deleteCustomerById(idCustomerDelete);
            showCustomer(icustomerService.getAllCustomer());
        }
    }

    private void editCustomerView() {
        showCustomer(icustomerService.getAllCustomer());
        System.out.println("Nhập ID cần sửa: ");
        long idCustomerEdit = Long.parseLong(scanner.nextLine());
        Customer customerEdit = icustomerService.findCustomerById(idCustomerEdit);
        if (customerEdit != null) {
            inputCustomer(INPUT_CUSTOMER_EDIT, customerEdit);

        } else {
            System.out.println("ID này không tồn tại!");
        }
        icustomerService.updateCustomerById(idCustomerEdit, customerEdit);
        showCustomer(icustomerService.getAllCustomer());

    }

    void addCustomerView() {
        Customer customer = new Customer();
        customer.setId(System.currentTimeMillis() % 1000);
        inputCustomer(INPUT_CUSTOMER_ADD, customer);

        icustomerService.addCustomer(customer);

        showCustomer(icustomerService.getAllCustomer());
    }

    long addCustomerNew() {
        Customer customer = new Customer();
        customer.setId(System.currentTimeMillis() % 1000);
        inputCustomer(INPUT_CUSTOMER_ADD, customer);

        icustomerService.addCustomer(customer);

        return customer.getId();
    }

    private void inputNameCustomer(String strACTION, int ACTION, Customer customer) {
        if (ACTION == INPUT_CUSTOMER_ADD) {
            do {
                System.out.printf("Nhập tên %s (*) : \n", strACTION);
                String name = scanner.nextLine();
                if (!ValidateUtils.isValidCustomerName(name)) {
                    System.out.println("Vui lòng nhập Tên. Tên phải bắt đầu là kí tự và từ 8-20 kí tự, không chứa số");
                } else {
                    customer.setName(name);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập tên %s của khách hàng: (Enter để bỏ qua) :\n", strACTION);
                String name = scanner.nextLine();
                if (!ValidateUtils.isValidCustomerName(name)) {
                    if (name.equals("")) {
                        break;
                    }
                    System.out.println("Vui lòng nhập Tên. Tên phải bắt đầu là kí tự và từ 8-20 kí tự, không chứa số");
                } else {
                    customer.setName(name);
                    break;
                }
            } while (true);
        }
    }

    private void inputAgeCustomer(String strACTION, int ACTION, Customer customer) {
        if (ACTION == INPUT_CUSTOMER_ADD) {
            do {
                System.out.printf("Nhập Tuổi %s (*) : \n", strACTION);
                String age = scanner.nextLine();
                if (!ValidateUtils.isValidCustomerAge(age)) {
                    System.out.println("Tuổi không hợp lệ. Gồm 2 số");
                } else {
                    customer.setAge(Integer.parseInt(age));

                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập Tuổi %s (Enter có thể bỏ qua) : \n", strACTION);
                String age = scanner.nextLine();
                if (!ValidateUtils.isValidCustomerAge(age)) {
                    if (age.equals("")) {
                        break;
                    }
                    System.out.println("Tuổi không hợp lệ. Gồm 2 số");
                } else {
                    customer.setAge(Integer.parseInt(age));
                    break;
                }
            } while (true);
        }
    }

    private void inputPhoneCustomer(String strACTION, int ACTION, Customer customer) {
        if (ACTION == INPUT_CUSTOMER_ADD) {
            do {
                System.out.printf("Nhập Số điện thoại %s (*) : \n", strACTION);
                String phone = scanner.nextLine();
                if (!ValidateUtils.isValidCustomerPhone(phone)) {
                    System.out.println("Số điện thoại không hợp lệ.Gồm 10 số");
                } else {
                    customer.setPhone(phone);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập Số điện thoại %s (Enter có thể bỏ qua) : \n", strACTION);
                String phone = scanner.nextLine();
                if (!ValidateUtils.isValidCustomerPhone(phone)) {
                    if (phone.equals("")) {
                        break;
                    }
                    System.out.println("Số điện thoại không hợp lệ.Gồm 10 số");
                } else {
                    customer.setPhone(phone);
                    break;
                }
            } while (true);
        }
    }

    private void inputAddressCustomer(String strACTION, int ACTION, Customer customer) {
        if (ACTION == INPUT_CUSTOMER_ADD) {
            do {
                System.out.printf("Nhập địa chỉ %s (*) : \n", strACTION);
                String address = scanner.nextLine();
                if (!ValidateUtils.isValidCustomerAddress(address)) {
                    System.out.println("Địa chỉ không hợp lệ. Ở giữa số nhà và chữ phải có khoảng trống");
                } else {
                    customer.setAddress(address);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập địa chỉ %s (Enter có thể bỏ qua) : \n", strACTION);
                String address = scanner.nextLine();
                if (!ValidateUtils.isValidCustomerAddress(address)) {
                    if (address.equals("")) {
                        break;
                    }
                    System.out.println("Địa chỉ không hợp lệ. Phải từ 15-50 kí tự");
                } else {
                    customer.setAddress(address);
                    break;
                }
            } while (true);
        }
    }

    private void inputCustomer(int ACTION, Customer customer) {
        String strACTION = ACTION == INPUT_CUSTOMER_ADD ? "" : "mới";
        inputNameCustomer(strACTION, ACTION, customer);
        inputAgeCustomer(strACTION, ACTION, customer);
        inputPhoneCustomer(strACTION, ACTION, customer);
        inputAddressCustomer(strACTION, ACTION, customer);
    }

    void showCustomer(List<Customer> customers) {
        System.out.printf("%-10s | %-20s | %-10s | %-20s | %-20s \n",
                "ID", "NAME", "AGE", "PHONE", "ADDRESS");
        for (int i = 0; i < customers.size(); i++) {
            Customer item = customers.get(i);
            System.out.printf("%-10s | %-20s | %-10s | %-20s | %-20s \n",
                    item.getId(), item.getName(), item.getAge(), item.getPhone(), item.getAddress());
        }
    }
}