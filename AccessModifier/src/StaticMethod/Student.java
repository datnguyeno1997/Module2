package StaticMethod;

public class Student {
    private int rollno;
    private String name;
    private static String college = "BBDIT";

//    Hàm tạo dể khởi tạo biến
    Student(int r, String n) {
        rollno = r;
        name = n;
    }

//    Phương thức tĩnh để thay đổi giá trị của bến tĩnh
    static void change() {
        college = "CODEGYM";
    }

//    Phương pháp hiển thị giá trị
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }

    public static void main(String[] args) {
        Student.change();

//        Tạo đối tượng
        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "khanh");
        Student s3 = new Student(333, "Nam");

//        Gọi phương thức hiển thị
        s1.display();
        s2.display();
        s3.display();
    }
}

