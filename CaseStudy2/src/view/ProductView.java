package view;


import model.Product;

import service.IProductService;
import service.ProductService;
import utils.ValidateUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private static final int INPUT_PRODUCT_ADD = 1;
    private static final int INPUT_PRODUCT_EDIT = 2;
    private Scanner scanner = new Scanner(System.in);

    private IProductService iProductService;
    private List<Product> products;

    public ProductView() {
        iProductService = new ProductService();
    }

    public void ProducttView(int role) {
        boolean checkActionMenu;
        do {
            checkActionMenu = true;
            System.out.println("==========================================================");
            System.out.println("||                 Menu Quản lý Dụng Cụ                 ||");
            System.out.println("|| ---------------------------------------------------  ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ thông tin của Dụng Cụ            ||");
            System.out.println("|| Nhấn 2: Thêm Dụng Cụ                                 ||");
            System.out.println("|| Nhấn 3: Sửa thông tin Dụng Cụ                        ||");
            System.out.println("|| Nhấn 4: Xóa Dụng Cụ                                  ||");
            System.out.println("|| Nhấn 5: Tìm kiếm Dụng Cụ theo tên                    ||");
            System.out.println("|| Nhấn 6: Sắp xếp Dụng Cụ theo tên                     ||");
            System.out.println("|| Nhấn 7: Quay lai                                     ||");
            System.out.println("==========================================================");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showProduct(iProductService.getAllProduct());
                    break;
                case 2:
                    addProductView();
                    break;
                case 3:
                    editProductView();
                    break;
                case 4:
                    deleteProductView();
                    break;
                case 5:
                    searchProductByNameView();
                    break;
                case 6:
                    sortProductByNameView();
                    break;
                case 7:
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

    private void searchProductByNameView() {
        System.out.println("Nhập tên cần tìm: ");
        String key = scanner.nextLine();
        List<Product> productsSearched = iProductService.searchProductByName(key);

        showProduct(productsSearched);
    }

    private void sortProductByNameView() {
        List<Product> products = iProductService.getAllProduct();
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        showProduct(products);
    }

    private void deleteProductView() {
        showProduct(iProductService.getAllProduct());
        System.out.println("Nhập ID cần xóa: ");
        long idProductDelete = Long.parseLong(scanner.nextLine());
        Product productDelete = iProductService.findProductById(idProductDelete);
        if (productDelete == null) {
            System.out.println("ID này không tồn tại!");
        } else {
            iProductService.deleteProductById(idProductDelete);
            showProduct(iProductService.getAllProduct());
        }
    }

    private void editProductView() {
        showProduct(iProductService.getAllProduct());
        System.out.println("Nhập ID cần sửa: ");
        long idProductEdit = Long.parseLong(scanner.nextLine());
        Product productEdit = iProductService.findProductById(idProductEdit);
        if (productEdit != null) {
            inputProduct(INPUT_PRODUCT_EDIT, productEdit);

        } else {
            System.out.println("ID này không tồn tại!");
        }
        iProductService.updateProductById(idProductEdit, productEdit);
        showProduct(iProductService.getAllProduct());

    }

    private void addProductView() {
        Product product = new Product();
        product.setId(System.currentTimeMillis() % 1000);
        inputProduct(INPUT_PRODUCT_ADD, product);

        iProductService.addProduct(product);

        showProduct(iProductService.getAllProduct());
    }

    private void inputNameProduct(String strACTION, int ACTION, Product product) {
        if (ACTION == INPUT_PRODUCT_ADD) {
            do {
                System.out.printf("Nhập tên %s (*) : \n", strACTION);
                String name = scanner.nextLine();
                if (!ValidateUtils.isValidProductName(name)) {
                    System.out.println("Vui lòng nhập Tên. Tên phải bắt đầu là kí tự và từ 8-20 kí tự, không chứa số");
                } else {
                    product.setName(name);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập tên %s của khách hàng: (Enter để bỏ qua) :\n", strACTION);
                String name = scanner.nextLine();
                if (!ValidateUtils.isValidProductName(name)) {
                    if (name.equals("")) {
                        break;
                    }
                    System.out.println("Vui lòng nhập Tên. Tên phải bắt đầu là kí tự và từ 8-20 kí tự, không chứa số");
                } else {
                    product.setName(name);
                    break;
                }
            } while (true);
        }
    }

    private void inputQuantilyProduct(String strACTION, int ACTION, Product product) {
        if (ACTION == INPUT_PRODUCT_ADD) {
            do {
                System.out.printf("Nhập số lượng tạ %s (*) : \n", strACTION);
                String quantily = scanner.nextLine();
                if (!ValidateUtils.isValidProductQuantily(quantily)) {
                    System.out.println("Vui lòng nhập lại số lượng tạ");
                } else {
                    product.setQuantity(Integer.parseInt(quantily));
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập Số lượng tạ %s : (Enter để bỏ qua) :\n", strACTION);
                String quantily = scanner.nextLine();
                if (!ValidateUtils.isValidProductQuantily(quantily)) {
                    if (quantily.equals("")) {
                        break;
                    }
                    System.out.println("Vui lòng nhập lại số lượng tạ ");
                } else {
                    product.setQuantity(Integer.parseInt(quantily));
                    break;
                }
            } while (true);
        }
    }

    private void inputDesrcibeProduct(String strACTION, int ACTION, Product product) {
        if (ACTION == INPUT_PRODUCT_ADD) {
            do {
                System.out.printf("Nhập mô tả %s (*) : \n", strACTION);
                String describe = scanner.nextLine();
                if (!ValidateUtils.isValidProductDescribe(describe)) {
                    System.out.println("Vui lòng lại mô tả");
                } else {
                    product.setDescribe(describe);
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.printf("Nhập mô tả %s : (Enter để bỏ qua) :\n", strACTION);
                String describe = scanner.nextLine();
                if (!ValidateUtils.isValidProductDescribe(describe)) {
                    if (describe.equals("")) {
                        break;
                    }
                    System.out.println("Vui lòng nhập lại mô tả ");
                } else {
                    product.setDescribe(describe);
                    break;
                }
            } while (true);
        }
    }

    private void inputProduct(int ACTION, Product product) {
        String strACTION = ACTION == INPUT_PRODUCT_ADD ? "" : "mới";
        inputNameProduct(strACTION, ACTION, product);
        inputQuantilyProduct(strACTION, ACTION, product);
        inputDesrcibeProduct(strACTION, ACTION, product);
    }

    private void showProduct(List<Product> products) {
        System.out.printf("%-10s | %-20s | %-10s | %-20s \n",
                "ID", "NAME", "QUANTITY", "DESCRIBE");
        for (int i = 0; i < products.size(); i++) {
            Product item = products.get(i);
            System.out.printf("%-10s | %-20s | %-10s | %-20s \n",
                    item.getId(), item.getName(), item.getQuantity(), item.getDescribe());
        }
    }
}

