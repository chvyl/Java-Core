//Demo Control Statements

import java.util.Scanner;

public class DemoControlStatements {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. If-Else: Xếp loại học lực
        System.out.println("=== Xếp loại học lực ===");
        System.out.print("Nhập điểm trung bình: ");
        double diem = sc.nextDouble();

        if (diem >= 8.5) {
            System.out.println("Giỏi");
        } else if (diem >= 7.0) {
            System.out.println("Khá");
        } else if (diem >= 5.0) {
            System.out.println("Trung bình");
        } else {
            System.out.println("Yếu");
        }

        // 2. Switch: Chọn số
        System.out.println("\n=== Chọn số ===");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.print("Chọn số (1-3): ");
        int luaChon = sc.nextInt();

        switch (luaChon) {
            case 1:
                System.out.println("Bạn đã chọn: 1.");
                break;
            case 2:
                System.out.println("Bạn đã chọn: 2.");
                break;
            case 3:
                System.out.println("Bạn đã chọn: 3");
                break;
            default:
                System.out.println("Số không hợp lệ.");
        }

        // 3. For: Tính tổng từ 1 đến n
        System.out.println("\n=== Tính tổng từ 1 tới n ===");
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        int tong = 0;
        for (int i = 1; i <= n; i++) {
            tong += i;
        }
        System.out.println("Tổng từ 1 đến " + n + " là: " + tong);

        // 4. While: Đoán số
        System.out.println("\n=== Đoán số ===");
        int soDoan = 7;
        int doan;
        int soLan = 0;

        do {
            System.out.print("Đoán số (1-10): ");
            doan = sc.nextInt();
            soLan++;

            if (doan < soDoan) {
                System.out.println("Số lớn hơn.");
            } else if (doan > soDoan) {
                System.out.println("Số nhỏ hơn.");
            }

        } while (doan != soDoan);

        System.out.println("Đúng rồi! Số lần đoán: " + soLan + " lần.");

        // 5. Nested Loop: Bảng cửu chương 
        System.out.println("\n=== Bảng cửu chương ===");
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%2d x %2d = %2d   ", i, j, i * j);
            }
            System.out.println();
        }

        // 6. BREAK & CONTINUE
        System.out.println("\n=== Break & Continue ===");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue; // bỏ qua số 5
            }
            if (i == 9) {
                break; // dừng tại 9
            }
            System.out.print(i + " ");
        }

        sc.close();
    }
}