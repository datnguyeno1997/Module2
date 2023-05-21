//Abstract class (Lớp trừu tượng) :
//
//        Trong kế thừa, lớp cha định nghĩa các phương thức chung cho các lớp con
//        Lớp con cụ thể hơn lớp cha, lớp cha "chung chung" hơn lớp con
//        Trong hệ kế thừa, càng lên cao thì tính cụ thể càng ít đi, tính trừu tượng càng tăng lên
//
//        Những lớp con có tính trừu tượng rất cao, đến mức không thể tạo được các đối tượng của lớp đó thì được gọi là lớp trừu tượng (abstract class)
//        Ví dụ: Lớp Geometric là một lớp rất trừu tượng , do đó nó phù hợp để trở thành một lớp abstract
//
//
//Abstract method ( phương thức trừu tượng):
//
//        Là những phương thức được khai báo( dedare) nhưng không có phần thân ( không được implement)
//
//        Ví dụ:Lớp Geometric có thể khai báo phương thức getArea() và getPerimeter() nhưng không có phần thân của 2 phương thức này
//
//        Phương thức trừu tượng được bổ sung phần thân ( tức là implement) ở các lớp con
//
//        Từ khóa abstract được sử dụng để khai báo lớp trừu tượng và phương thức trừu tượng
//
//
//        Các ký hiệu UML :
//        Tên lớp Abstract được in nghiên
//        Dấu # xác định access modifier là protected
//Tên các phương thức abstract được in nghiên
//        Lớp Circle và lớp Rectangle sẽ implement các phương thức getArea() và getPerimeter()
//
//
//        Các tính chất của lớp abstract:
//
//        Không thể tạo đối tượng của lớp abstract
//Lớp abstract có thể có các thuộc tính và phương thức bình thườngg
//        Một lớp chứa phương thức abstract thì lớp đó phairi là abstract
//Một lớp không phải là abstract kế thừa từ 1 lớp cha abstract thì phải implement tất cả các phương thức abstract của lớp cha
//        Lớp abstract thì không thể final
//Phương thức abstract thì không thể final
//
//
//Interface (giao diện):
//
//        là một cấu trúc tương tự như lớp , nhưng chỉ chứa các hằng số và abstract method
//        Interface quy định các hành vi chung cho các lớp triển khai nó
//        Sử dụng từ khóa interface để định nghĩa interface
//
//Cú pháp:
//
//        modifier interface interfaceName{
//    /** Constant declarations */
//    /** Abstract method signatures */
//
//    Các tính chất:
//
//    Định nghĩa một interface tạo ra một kiểu dữ liệu mới
//            Không thể tạo đối tượng của interface
//    Interface không thể chứa các phương thức abstract
//    Khi một lớp triển khai interface thì cần triển khai tất cả các phương thức được khai báo trong interface đó
//Interface có thể được thiết kế để khai báo các phương thức chung cho các lớp không liên quan với nhau (khác với abstract class, được kế thừa bởi các lớp có liên quan với nhau)
//    Interface bổ sung cho việc Java không hỗ trợ "đa kế thừa"
//
//
//    Triển khai interface
//
//    Một lớp triển khai interface bằng cách sử dụng từ khóa implements
//
//            Cú pháp :
//    class ClassName implementsIntefaceName {
//
//    }
//
//    Kế thừa interface :
//
//    Một interface có thể kế thừa interface khác
//Interface con thừa hưởng các phương thức và hằng số được khai báo trong interface cha
//Interface con có thể khai báo thêm các thành phần mới
//        Từ khóa extends được sử dụng để kế thừa interface
//
//
//    Access modifier của interface:
//
//    Mặc định, các phương thức abstract của interface đều có access modifier là public
//    Không thể sử dụng private hoặc protected cho các phương thức của interface
//    Không cần thiết phải cỉ rõ access modifier là public cho các phương thức của interface
//
//
//    Khai báo hằng số trong Interface
//
//                    Có thể khai báo các hằng số trong interface
//    Không cần thiết phải cỉ rõ access modifiler cho hằng số, mặc định là public
//    Không cần thiết phải ghi rõ từ khóa final cho hằng số
//
//
//    Anonymous class (Lớp nặc danh):
//
//    Là một lớp đặc biệt, được khai báo và khởi tạo đối tượng tại cùng một thời điểm
//    Anonymous class cần kế thừa một lớp hoặc triển khai một interface
//
//
//    Cohesion (Tính gắng kết) :
//
//    Có nghĩa là mỗi lớp chỉ nên đại diện cho 1 thực thể nhất định
//    Tất cả các phương thức của lớp cần phối hợp cùng nhau hợp lý để hỗ trợ cho tính chất cohesion
//
//    Cohesion Ví dụ:
//
//    Các lớp String, StringBuilder và StringBuffer đều thực hiện các thao tác với chuỗi
//
//    Tác thành 3 lớp khác nhau giúp nhiệm vụ của mỗi lớp rõ ràng hơn
//    String thao tác với chuỗi cố định (inmutable string)
//    StringBuilder thao tác với chuỗi thay đổi được (mutable string)
//    StringBuffer tương tự StringBuilder nhưng có thêm các thao tác làm việc đồng bộ (synchronized)
//
//
//    Consistency (Tính đồng nhất)
//
//    Là tuân thủ các tiêu chuẩn của Java và các quy ước đặt tên
//    Chọn các tên phù hợp cho lớp, thuộc tính và phương thức
//    Cấu trúc của 1 lớp lần lượt là: Các trường dữ liệu, acsc constructor, các phương thức
//    Nên định nghĩa 1 constructor không có tham số cho lớp
//
//
//    Encapsulation (tính đóng gói)
//
//    Nên sử dụng từ khóa private đối với các trường dữ liệu
//    Định nghĩa phương thức getter nếu muốn lấy được giá trị của thuộc tính
//    Định nghĩa phương thức setter nếu muốn thay đổi giá trị của thuộc tính
//
//
//    Clarity (tính rõ ràng):
//
//    Có nghĩa là nhiệm vụ của các lớp, của các phương thức cần phải dễ hiểu, dễ giải thích
//    Các lớp, các phương thức có thể được sử dụng kết hợp với nhau theo nhiều cách khác nhau, do đó sự rõ ràng là cần thiết
//    Các thuộc tính trong 1 lớp nên độc lập với nhau, tránh thừa dữ liệu
//
//
//    Lựa chọn Inheritance(kế thừa) hay Aggregation(tập hợp):
//
//    Trong nhiều trường hợp có thể chuyển đổi qua lại giữa việc sử dụng inheritance và aggregation
//    Inheritance thể hiện mối quan hệ is-a
//    Aggregation thể hiện mối quan hệ has-a
//
//    Nếu có sự gần gũi rõ ràng giữa các lớp về mối quan hệ cha con thì nên sử dụng lớp (mối quan hệ is-a)
//    Nếu không có mối quan hệ gần gũi thì nên chọn interface (mối quan hệ can-do)
