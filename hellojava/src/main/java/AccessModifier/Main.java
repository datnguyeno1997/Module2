//package AccessModifier;
//
//import java.awt.*;
//
//public class Main {
//    public static void main(String[] args) {
//
//
////    Reference data types
////    Ví dụ:
//        Rectangle rectangleObj1 = new Rectangle(10, 20);
//        Rectangle rectangleObj2 = rectangleObj1;
//
////    thao tác này sao chép địa chỉ được lưu trong biến rectangleObj1 sang biến rectangleObj2
////    không có ảnh hưởng nào xảy ra đối với đối tượng thực tế trong bộ nhớ
//
//// Ví dụ:
////        class Person{
////            public String name;
////            public Person(String name){
////                this.name = name;
////            }
////        }
////        public static void swap(Person first, Person second){
////            String temp = first.name;
////            first.name = second.name;
////            second.name = temp;
////        }
////        public static void main(String[] args) {
////            Person a = new Person("John");
////            Person b = new Person("Bill");
////            swap(a, b);
////            System.out.println("a.name = " + a.name);
////            System.out.println("b.name = " + b.name);
////        }
//////        Kết quả:
////        a.name = Bill
////        b.name = Joh
//
////Từ khóa static : được sử dụng để khai báo các thuộc tính và phương thức của lớp(Khác với thuộc tính và phương thức của đối tượng)
////Các thành phần static trực thuộc lớp thay vì trực thuộc đối tượng
////biến static còn được gọi là biến của lớp(class variable)
////có thể truy xuất các thành phần = cách sử dụng lớp hoặc đối tượng
////Cú pháp khai báo static propety:
////        modifier static data_type variable_name
////Cú pháp khai báo static method:
////        modifier static data_type method_name(){
////            body
////          }
//
////  Phương thức static chỉ có thể gọi các phương thức static khác
////        chỉ có thể truy xuất các biến static
////        không thể sử dụng từ khóa this hoặc super
////        Có thể khởi tạo biến static thông qua khối khởi tạo static
//
//
////        Biến tham trị (Pass-by-Value):
////        Khi truyền một biến vào một phương thức, giá trị của biến được sao chép và gán cho một tham số mới trong phương thức.
////        Các thay đổi về giá trị của tham số không ảnh hưởng đến giá trị của biến gốc.
//
////    ví dụ
////        public static void modifyValue(int value) {
////            value = 10;
////        }
////
////        public static void main(String[] args) {
////            int number = 5;
////            modifyValue(number);
////            System.out.println(number);
////        }
//
////        Biến tham chiếu (Pass-by-Reference):
////        Khi truyền một biến tham chiếu vào một phương thức, địa chỉ của biến được sao chép và gán cho một tham số mới trong phương thức.
////        Các thay đổi về giá trị của tham số sẽ ảnh hưởng trực tiếp đến biến gốc được tham chiếu
//
////ví dụ
////        class Person {
////            String name;
////
////            Person(String name) {
////                this.name = name;
////            }
////        }
////
////        public static void modifyName(Person person) {
////            person.name = "Alice";
////        }
////
////        public static void main(String[] args) {
////            Person person = new Person("Bob");
////            modifyName(person);
////            System.out.println(person.name); // Output: Alice
////        }
//
////Package(gói)là cách để phân loại các lớp và interface thành các nhóm có liên quan đến nhau và tổ chức chúng thành các đơn vị để quảnlý
//
////Vídụ: Java cung cấp sẵn các gói:
//// java.io:Thực hiện các thao tác nhập xuất dữ liệu
//// java.net: Thực hiện các thao tác qua mạng lưới
//// java.security: Thực hiện các thao tác liên quan đến bảo mật
//// java.util:Cung cấp các lớp và phương thức hỗ trợ
//
////Tính chất của package
////Có thể khai báo các gói con - subpackage (gói ở bên trong gói)
////Không thể có 2 lớp cùng tên trong cùng 1 gói
////tên của gói được viết bằng chữ thường
////Các gói được cung cấp sẵn của Java được bắt đầu bằng từ java hoặc javax
//
////Cú pháp:
////package package_name;
//
////ví dụ
////package codegym;
//
////Access modifier là các từ khóa được sử dụng để quy định mức độ truy cập đến lớp và các thành phần của lớp
////Các mức truy cập:
////public có thể truy cập từ bất cứ đâu
////private các phương thức và thuộc tính chỉ được phép truy xuất trong cùng một lớp
//// protected các phương thức và thuộc tính đuợc phép truy xuất trong cùng 1 lớp và ở các lớp con (kế thừa)
////default nếu không có access modifier thì mức default sẽ được áp dụng.Lớp và các thành phần được truy xuất ở những nơi cũng 1 package
//
//
////Nested class (lớp lồng nhau) là một lớp được khai báo bên trong lớp khác
//
////Cú pháp
//
////Class OuterClass{
////      ...
////      static class StaticNestedClass{
////          ...
////      }
////      class InnerClass{
////           ...
////      }
////}
//
//
////Local class(lớp địa phương) là lớp được khai báo và sử dụng bên trong 1 khối lệnh
////Không thể sử dụng local class bên ngoài khối lệnh được khai báo
