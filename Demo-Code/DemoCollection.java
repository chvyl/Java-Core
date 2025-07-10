// Collections, Generics và Lambda

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 1. Lớp NguoiHoc
class NguoiHoc {
    private String hoTen;
    private double diemTB;

    public NguoiHoc(String hoTen, double diemTB) {
        this.hoTen = hoTen;
        this.diemTB = diemTB;
    }

    public String getHoTen() {
        return hoTen;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void hienThi() {
        System.out.println("Họ tên: " + hoTen + ", Điểm TB: " + diemTB);
    }
}

// 2. Lớp chính
public class DemoCollection {
    public static void main(String[] args) {
        // 2.1 List để lưu danh sách người học
        List<NguoiHoc> danhSach = new ArrayList<>();
        danhSach.add(new NguoiHoc("Nguyen Van A", 8.3));
        danhSach.add(new NguoiHoc("Chau Thi B", 9.1));
        danhSach.add(new NguoiHoc("Tran Van C", 5.0));
        danhSach.add(new NguoiHoc("Le Thi D", 7.8));

        // 2.2 Duyệt danh sách (forEach + lambda)
        System.out.println("=== Danh sách ban đầu ===");
        danhSach.forEach(nh -> nh.hienThi());

        // 2.3 Sắp xếp danh sách theo điểm giảm dần (lambda)
        danhSach.sort((a, b) -> Double.compare(b.getDiemTB(), a.getDiemTB()));

        System.out.println("\n=== Danh sách sắp xếp điểm giảm dần ===");
        danhSach.forEach(nh -> nh.hienThi());

        // 2.4 Tìm người có điểm cao nhất (lambda + Collections.max)
        NguoiHoc max = Collections.max(danhSach, Comparator.comparingDouble(NguoiHoc::getDiemTB));
        System.out.println("\nNgười có điểm cao nhất:");
        max.hienThi();
    }
}