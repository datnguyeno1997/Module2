//Kế thừa là cơ chế cho phép 1 lớp con sử dụng lại các đặc điểm và hành vi đã được định nghĩa trong lớp cha

//ví dụ
//lớp Cha : Car
//lớp con: sport Car, luxury Car, Family Car

//Quan hệ giữa lớp con và lớp cha là quan hệ is-a (là- một)

//Lớp được kế thừa gọi là lớp cha (parent class) hoặc lớp cơ sở (base class) hoặc super class
//lớp kế thừa gọi là lớp con(child class) hoặc lớp dẫn xuất (derived class) hoặc subclass
//lớp con kế thừa tất cả các thành phần của lớp cha, ngoại trừ các thành phần được khai báo là private
//Constructor không được kế thừa
//lớp con có thể gọi constructor của lớp cha
//lớp con có thể định nghĩa thêm các thuộc tính và phương thức mới
//Java không cho phép đa kế thừa( một lớp kế thừa nhiều lớp cha)

//Một số dạng kế thừa:
//Single: 1 lớp kế thừa từ 1 lớp cha          Class B ----> Class A
//Multilevel: 1 lớp kế thừ từ 1 lớp cha, lớp cha lại kế thừa từ lớp khác trên nó      Class C -----> Class B -----> CLass A
//Hierarchical: 1 lớp cha có nhiều lớp con với nhiều level khác nhauơ
//Multiple: Một lớp con kế thừa từ nhiều lớp cha

//Cú pháp:

//Class SubClass extends SupperClass
//      {  Class body }

//SubClass là tên của lớp con
//SupperClass là tên của lớp cha

//Method overriding (ghi đè phương thức) là cơ chế cho phép lớp con định nghĩa lại các phương thức đã được định nghĩa trước đó ở lớp cha
//Overriding là một khái niệm trong lập trình hướng đối tượng
// Phương thức override ở lớp con có cùng tên, cùng danh sách tham sô và kiểu dữ liệu trả về so với phương thức ở lớp cha
//Phương thức ở lớp con phải có access modifier có level bằng hoặc cao hơn so với phương thức ở lớp cha
//Từ khóa override được sử dụng để ghi đè phương thức
//@override có thể được sử dụng để đánh dấu phương thức ghi đè
//Lý do chúng ta cần ghi đè phương thức là để thay đổi hoặc mở rộng hành vi của phương thức đã được định nghĩa trong lớp cha. Điều này cho phép chúng ta tùy chỉnh và cung cấp hành vi đặc biệt cho lớp con mà không làm ảnh hưởng đến các lớp cha khác.
//Việc ghi đè phương thức là một cách quan trọng để triển khai tính đa hình trong lập trình hướng đối tượng, nơi các đối tượng có thể có các hành vi khác nhau dựa trên kiểu của chúng.


//Từ khóa super được sử dụng ở lớp con để gọi đến constructor hoặc phương thức của lớp cha


//Lớp Object là lớp gốc của tất cả các lớp trong Java
//Tất cả các lớp trong java đều kế thừa từ lớp Object
//Lớp Object có 1 phương thức được sử dụng thông dụng đó là:
//toString(): Trả về 1 chuỗi mô tả đối tượng
//Mô tả của phương thức toString() là:
//        public String toString()
//Các lớp có thể ghi đè phương thức toString() để mô tả đối tượng tốt hơn


//Đa hình khi gọi phương thức: Khi một tác vụ được thực hiện theo nhiều cách khác nhau được gọi là tính đa hình.
// Polymorphism is the ability of an object to take on many forms là Đa hình là khả năng một đối tượng có nhiều dạng
//Đa hình khi tạo đối tượng: Đa hình là cơ chế cho phép 1 đối tượng của lớp cha có thể trỏ đến các đối tượng lớp con hoặc có thể phát biểu: 1 đối tượng có thể đảm nhận nhiều hình dạng khác nhau
//Đa hình tại thời thời điểm biên dịch (0verloading): đối tượng sẽ gọi trước phương thức theo kiểu khai báo
//Đa hình tại thời điểm run-time (Override): đối tượng sẽ gọi phương thức theo kiểu thực tế
//Khi 1 lớp con kế thừa lớp cha thì kiểu dữ liệu của lớp cha được gọi là supertype , kiểu dữ liệu của lớp con gọi là subtype

//            Geometric geometricObj = new Circle(1)


//Dynamic Binding( Liên kết động)
//Khi triển khai kế thừa, 1 phương thức có thể được viết ở những lớp khác nhau
//Dynamic Binding là cơ chế của JVM để xác định sẽ gọi phương thức nào tại thời điểm thực thi

//Kiểu khai báo của 1 biến( declared type) là kiểu sử dụng trong bước khai báo
//Kiểu thực tế (actual type) của 1 biến là kiểu của đối tượng mà biến trỏ đến
//Ví dụ:

//            Object o =new Circle();
//kiểu khai báo của biến o là Object
//kiểu thực tế của biến o là Circle
//Cơ chế Dynamic Binding sẽ dựa vào kiểu thực tế để gọi phương thức

//Toán tử instanceof giúp kiểm tra kiểu của 1 đối tượng
//Giá trị trả về là boolean

//Từ khóa final áp dụng cho lớp và phương thức để ngăn ngừa việc kế thừa và ghi đè phương thức

//Ép kiểu là hình thức chuyển đổi tham chiếu đối tượng từ 1 kiểu này sang tham chiếu đối tượng thuộc kiểu khác
//Có 2 loại ép kiểu
// Implicit casting( ép kiểu ngầm định): ép từ subtype lên supertype
// Explicit casting( ép kiểu tường minh): ép từ supertype xuống subtype