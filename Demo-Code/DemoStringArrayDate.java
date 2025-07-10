import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DemoStringArrayDate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập thông tin sinh viên
        System.out.println("=== NHẬP THÔNG TIN SINH VIÊN ===");
        System.out.print("Họ và tên: ");
        String hoTen = sc.nextLine();

        System.out.print("Số môn học: ");
        int soMon = sc.nextInt();
        int[] diem = new int[soMon];

        for (int i = 0; i < soMon; i++) {
            System.out.print("Nhập điểm môn " + (i + 1) + ": ");
            diem[i] = sc.nextInt();
        }

        System.out.print("Nhập năm sinh: ");
        int nam = sc.nextInt();
        System.out.print("Nhập tháng sinh: ");
        int thang = sc.nextInt();
        System.out.print("Nhập ngày sinh: ");
        int ngay = sc.nextInt();

        // === String: xử lý họ tên ===
        int viTriCuoi = hoTen.lastIndexOf(" ");
        String ho = hoTen.substring(0, viTriCuoi);
        String ten = hoTen.substring(viTriCuoi + 1);

        // === Array: tính điểm trung bình ===
        int tong = 0;
        for (int d : diem) {
            tong += d;
        }
        double diemTB = (double) tong / diem.length;

        // === Date: tính tuổi ===
        LocalDate ngaySinh = LocalDate.of(nam, thang, ngay);
        LocalDate homNay = LocalDate.now();
        int tuoi = homNay.getYear() - ngaySinh.getYear();

        // === In thông tin ===
        System.out.println("\n=== THÔNG TIN SINH VIÊN ===");
        System.out.println("Họ: " + ho);
        System.out.println("Tên: " + ten);
        System.out.println("Điểm trung bình: " + diemTB);
        System.out.println("Tuổi: " + tuoi);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Ngày sinh: " + ngaySinh.format(format));

        sc.close();
    }
}
