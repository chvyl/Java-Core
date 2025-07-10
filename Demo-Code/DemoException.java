// Exception Handling

import java.util.InputMismatchException;
import java.util.Scanner;

// 1. định nghĩa ngoại lệ 
class DiemKhongHopLeException extends Exception {
    public DiemKhongHopLeException(String message) {
        super(message);
    }
}

// 2. Lớp NguoiHoc, ném exception nếu điểm không hợp lệ
class NguoiHoc {
    private String hoTen;
    private double diemTB;

    public NguoiHoc(String hoTen, double diemTB) throws DiemKhongHopLeException {
        if (diemTB < 0 || diemTB > 10) {
            throw new DiemKhongHopLeException("Điểm phải nằm trong khoảng từ 0 đến 10.");
        }
        this.hoTen = hoTen;
        this.diemTB = diemTB;
    }

    public void hienThi() {
        System.out.println("Họ tên: " + hoTen + ", Điểm TB: " + diemTB);
    }
}

// 3. Lớp chính kiểm tra ngoại lệ khi nhập
public class DemoException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập họ tên học viên: ");
            String ten = sc.nextLine();

            System.out.print("Nhập điểm trung bình: ");
            double diem = sc.nextDouble();

            // Ném ngoại lệ nếu điểm không hợp lệ
            NguoiHoc hv = new NguoiHoc(ten, diem);
            hv.hienThi();

        } catch (DiemKhongHopLeException e) {
            System.out.println("Lỗi nhập điểm: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập số hợp lệ cho điểm.");
        } catch (Exception e) {
            System.out.println("Lỗi không xác định: " + e.getMessage());
        } finally {
            System.out.println("Kết thúc chương trình.");
        }

        sc.close();
    }
}
