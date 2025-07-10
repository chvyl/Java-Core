import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected double gia;
    protected int soLuong;

    public HangHoa(String maHang, String tenHang, double gia, int soLuong) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public String getMaHang() {
        return maHang;
    }

    public abstract double tinhVAT();
    public abstract String danhGia();

    public void hienThi() {
        System.out.println(maHang + " - " + tenHang + " - SL: " + soLuong + " - Giá: " + gia);
    }
}

class ThucPham extends HangHoa {
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private String nhaCungCap;

    public ThucPham(String maHang, String tenHang, double gia, int soLuong,
                    LocalDate ngaySanXuat, LocalDate ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, gia, soLuong);
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public double tinhVAT() {
        return gia * 0.05;
    }

    @Override
    public String danhGia() {
        if (soLuong > 0 && ngayHetHan.isBefore(LocalDate.now())) {
            return "Khó bán";
        }
        return "Bán được";
    }
}

class DienMay extends HangHoa {
    private int thoiGianBaoHanh;
    private double congSuat;

    public DienMay(String maHang, String tenHang, double gia, int soLuong,
                   int thoiGianBaoHanh, double congSuat) {
        super(maHang, tenHang, gia, soLuong);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuat = congSuat;
    }

    @Override
    public double tinhVAT() {
        return gia * 0.1;
    }

    @Override
    public String danhGia() {
        if (soLuong < 3) {
            return "Bán chạy";
        }
        return "Chậm";
    }
}

class SanhSu extends HangHoa {
    private String nhaSanXuat;
    private LocalDate ngayNhapKho;

    public SanhSu(String maHang, String tenHang, double gia, int soLuong,
                  String nhaSanXuat, LocalDate ngayNhapKho) {
        super(maHang, tenHang, gia, soLuong);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public double tinhVAT() {
        return gia * 0.1;
    }

    @Override
    public String danhGia() {
        long soNgay = ChronoUnit.DAYS.between(ngayNhapKho, LocalDate.now());
        if (soLuong > 50 && soNgay > 10) {
            return "Bán chậm";
        }
        return "Ổn";
    }
}

class QuanLyHangHoa {
    private HangHoa[] dsHang;
    private int soLuongHienTai;

    public QuanLyHangHoa(int kichThuoc) {
        dsHang = new HangHoa[kichThuoc];
        soLuongHienTai = 0;
    }

    public boolean themHang(HangHoa h) {
        if (soLuongHienTai >= dsHang.length) return false;

        for (int i = 0; i < soLuongHienTai; i++) {
            if (dsHang[i].getMaHang().equals(h.getMaHang())) return false;
        }

        dsHang[soLuongHienTai++] = h;
        return true;
    }

    public void hienThiTatCa() {
        for (int i = 0; i < soLuongHienTai; i++) {
            dsHang[i].hienThi();
        }
    }

    public void thongKeDanhGia() {
        for (int i = 0; i < soLuongHienTai; i++) {
            System.out.println(dsHang[i].tenHang + ": " + dsHang[i].danhGia());
        }
    }
}

public class Practice2 {
    public static void main(String[] args) {
        QuanLyHangHoa ql = new QuanLyHangHoa(10);

        ql.themHang(new ThucPham("TP01", "Sua tuoi", 20000, 10,
                LocalDate.of(2024, 6, 20),
                LocalDate.of(2024, 7, 5),
                "Vinamilk"));

        ql.themHang(new DienMay("DM01", "May say", 1500000, 2, 12, 1800));
        ql.themHang(new SanhSu("SS01", "Chen bat", 50000, 55, "Minh Long", LocalDate.now().minusDays(15)));

        ql.hienThiTatCa();

        System.out.println("\n=== Đánh giá ===");
        ql.thongKeDanhGia();
    }
}
