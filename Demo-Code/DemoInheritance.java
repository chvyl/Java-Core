// Inheritance

class NguoiHoc {
    protected String hoTen;
    protected int namSinh;

    public NguoiHoc(String hoTen, int namSinh) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
    }

    public void hienThiThongTin() {
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Năm sinh: " + namSinh);
    }

    public void loaiNguoiHoc() {
        System.out.println("Loại: Chưa xác định");
    }
}

class HocVienChinhQuy extends NguoiHoc {
    private String lop;

    public HocVienChinhQuy(String hoTen, int namSinh, String lop) {
        super(hoTen, namSinh);
        this.lop = lop;
    }

    @Override
    public void loaiNguoiHoc() {
        System.out.println("Loại: Chính quy, lớp: " + lop);
    }
}

class HocVienOnline extends NguoiHoc {
    private String email;

    public HocVienOnline(String hoTen, int namSinh, String email) {
        super(hoTen, namSinh);
        this.email = email;
    }

    @Override
    public void loaiNguoiHoc() {
        System.out.println("Loại: VB2, email: " + email);
    }
}

public class DemoInheritance {
    public static void main(String[] args) {
        NguoiHoc[] danhSach = {
            new HocVienChinhQuy("Nguyen Van A", 2004, "IT001"),
            new HocVienOnline("Tran Van B", 1999, "btran@example.com")
        };

        System.out.println("=== DANH SÁCH NGƯỜI HỌC ===");
        for (NguoiHoc nh : danhSach) {
            nh.hienThiThongTin();
            nh.loaiNguoiHoc();
            System.out.println();
        }
    }
}