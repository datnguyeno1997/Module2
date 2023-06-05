package ArrayAndLinkedList;

import java.util.*;
public class ProductManager {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Nuts Milk", 20000, 1));
        products.add(new Product("Shrimp Snack", 5000, 2));
        products.add(new Product("Huda Beer Pack", 220000, 3));
        products.add(new Product("Oreo Biscuit", 22000, 4));
        products.add(new Product("Coconut Chocolate Bars Pack", 120000, 5));
        products.add(new Product("Cocacola", 130000, 6));
        Set<Integer> productIdSet = createProductIdSet(products);

        boolean flag = true;
        int action;
        while (flag) {
            do {
                showMenu();
                action = Integer.parseInt(scanner.nextLine());
            } while (action < 0 || action > 6);
            switch (action) {
                case 1 :
                    Product product = createProduct(products);
                    products.add(product);
                    System.out.println("Danh sách sản phẩm sau khi thêm");
                    showProducts(products);
                    productIdSet = createProductIdSet(products);

                case 2 :
                    int fixId;
                    do {
                        System.out.println("Nhập ID của sản phẩm muốn sửa");
                        fixId = Integer.parseInt(scanner.nextLine());
                    } while (!productIdSet.contains(fixId));
                    System.out.println(getProductById(products, fixId));
                    fixProductById(products, fixId);
                    productIdSet = createProductIdSet(products);

                case 3 :
                    System.out.println("Nhập ID của sản phẩm muốn xóa");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    products.remove(getProductById(products, deleteId));
                    productIdSet = createProductIdSet(products);

                case 4 : showProducts(products);
                case 5 :
                    System.out.println("Nhập tên sản phẩm muốn tìm");
                    String searchName = scanner.nextLine();
                    System.out.println(getProductByName(products, searchName));

                case 6 : sortProducts(products);
                default : {
                    flag = false;
                }
            }
        }

        showProducts(products);
    }




    public static void showMenu() {
        System.out.println("=======================================================");
        System.out.println("|                      THICK MENU                     |");
        System.out.println("=======================================================");
        System.out.println("| Options:                                            |");
        System.out.println("| 1. Thêm sản phẩm                                    |");
        System.out.println("| 2. Sửa thông tin sản phẩm theo id                   |");
        System.out.println("| 3. Xoá sản phẩm theo id                             |");
        System.out.println("| 4. Hiển thị danh sách sản phẩm                      |");
        System.out.println("| 5. Tìm kiếm sản phẩm theo tên                       |");
        System.out.println("| 6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá     |");
        System.out.println("| 0. Quit                                             |");
        System.out.println("=======================================================");
    }

    public static Product createProduct(ArrayList<Product> products) {
        Set<Integer> productIdSet = createProductIdSet(products);
        int ID;
        System.out.println("Nhap vao ten cua san pham");
        String name = scanner.nextLine();
        System.out.println("Nhap vao gia cua san pham");
        int price = Integer.parseInt(scanner.nextLine());
        do {
            System.out.println("Nhap vao ID cua san pham");
            ID = Integer.parseInt(scanner.nextLine());
        } while (productIdSet.contains(ID));
        return new Product(name, price, ID);
    }

    public static void fixProductById(ArrayList<Product> products, int id) {
        Product product = getProductById(products, id);
        int action;
        boolean flag = true;

        while (flag) {
            do {
                System.out.println("=======================================================");
                System.out.println("|                      THICK MENU                     |");
                System.out.println("=======================================================");
                System.out.println("| Options:                                            |");
                System.out.println("| 1. Sửa tên sản phẩm                                 |");
                System.out.println("| 2. Sửa giá sản phẩm                                 |");
                System.out.println("| 3. Sửa ID sản phẩm                                  |");
                System.out.println("| 0. Quit                                             |");
                System.out.println("=======================================================");

                action = Integer.parseInt(scanner.nextLine());
            } while (action < 0 || action > 3);
            switch (action) {
                case 1:
                    System.out.println("Nhập tên mới cho sản phẩm");
                    String name = scanner.nextLine();
                    product.setName(name);

                case 2:
                    System.out.println("Nhập giá mới cho sản phẩm");
                    int price = Integer.parseInt(scanner.nextLine());
                    product.setPrice(price);

                case 3:
                    int ID;
                    Set<Integer> productIdSet = createProductIdSet(products);
                    do {
                        System.out.println("Nhập ID mới cho sản phẩm");
                        ID = Integer.parseInt(scanner.nextLine());
                    } while (productIdSet.contains(ID));
                    product.setId(ID);
                default: {
                    flag = false;
                }
            }
        }
    }

    public static Product getProductById(ArrayList<Product> products, int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static Set<Integer> createProductIdSet(ArrayList<Product> products) {
        Set<Integer> productIdSet = new HashSet<>();
        for (Product product : products) {
            productIdSet.add(product.getId());
        }
        return productIdSet;
    }

    public static Product getProductByName(ArrayList<Product> products, String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static void sortProducts(ArrayList<Product> products) {
        int action;
        boolean flag = true;

        while (flag) {
            do {
                System.out.println("=======================================================");
                System.out.println("|                      THICK MENU                     |");
                System.out.println("=======================================================");
                System.out.println("| Options:                                            |");
                System.out.println("| 1. Sắp xếp sản phẩm tăng dần theo giá               |");
                System.out.println("| 2. Sắp xếp sản phẩm giảm dần theo giá               |");
                System.out.println("| 0. Quit                                             |");
                System.out.println("=======================================================");

                action = Integer.parseInt(scanner.nextLine());
            } while (action < 0 || action > 2);
            switch (action) {
                case 1 :
                    PriceComparator ascendingComparator = new PriceComparator(true);
                    products.sort(ascendingComparator);
                    System.out.println("Sau khi sắp xếp: ");
                    showProducts(products);

                case 2 :
                    PriceComparator descendingComparator = new PriceComparator(false);
                    products.sort(descendingComparator);
                    System.out.println("Sau khi sắp xếp: ");
                    showProducts(products);

            default : {
                    flag = false;
                }
            }
        }
    }

    public static void showProducts(ArrayList<Product> products) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
