// 1. Interface định nghĩa hành vi 
interface IXepLoai {
    void xepLoai(); // phương thức trừu tượng 
}

// 2. Lớp cơ sở NguoiHoc chứa thông tin cơ bản
class NguoiHoc {
    protected String hoTen;
    protected double diemTB;

    public NguoiHoc(String hoTen, double diemTB) {
        this.hoTen = hoTen;
        this.diemTB = diemTB;
    }

    public void hienThiThongTin() {
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Điểm TB: " + diemTB);
    }
}

// 3. Lớp HocVien triển khai interface IXepLoai
class HocVien implements IXepLoai {
    private NguoiHoc thongTin;

    public HocVien(String hoTen, double diemTB) {
        this.thongTin = new NguoiHoc(hoTen, diemTB);
    }

    public void hienThi() {
        thongTin.hienThiThongTin();
        xepLoai(); 
    }

    // 4. Ghi đè phương thức interface 
    @Override
    public void xepLoai() {
        if (thongTin.diemTB >= 8.5) {
            System.out.println("Xếp loại: Giỏi");
        } else if (thongTin.diemTB >= 7.0) {
            System.out.println("Xếp loại: Khá");
        } else if (thongTin.diemTB >= 5.0) {
            System.out.println("Xếp loại: Trung bình");
        } else {
            System.out.println("Xếp loại: Yếu");
        }
    }
}

// 5. hàm main
public class DemoInterface {
    public static void main(String[] args) {
        HocVien hv1 = new HocVien("Nguyen Van A", 8.2);
        HocVien hv2 = new HocVien("Le Thi B", 6.7);

        System.out.println("=== DANH SÁCH HỌC VIÊN ===");
        hv1.hienThi();
        System.out.println();
        hv2.hienThi();
    }
}