class SoBuoiHoc {
    private int tongBuoi = 0;

    public synchronized void diemDanh(String ten) {
        tongBuoi++;
        System.out.println(ten + " điểm danh. Tổng buổi: " + tongBuoi);
    }

    public synchronized int getTongBuoi() {
        return tongBuoi;
    }
}

// Luồng 1: kế thừa Thread
class HocVienChinhQuy extends Thread {
    private String ten;
    private SoBuoiHoc soBuoi;

    public HocVienChinhQuy(String ten, SoBuoiHoc soBuoi) {
        this.ten = ten;
        this.soBuoi = soBuoi;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            soBuoi.diemDanh(ten);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Luồng 2: implements Runnable
class HocVienOnline implements Runnable {
    private String ten;
    private SoBuoiHoc soBuoi;

    public HocVienOnline(String ten, SoBuoiHoc soBuoi) {
        this.ten = ten;
        this.soBuoi = soBuoi;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            soBuoi.diemDanh(ten);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DemoThreadHocVien {
    public static void main(String[] args) {
        SoBuoiHoc buoiHoc = new SoBuoiHoc();

        Thread t1 = new HocVienChinhQuy("Nguyen Van A", buoiHoc);
        Thread t2 = new Thread(new HocVienOnline("Le Thi B", buoiHoc));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tong so buoi hoc: " + buoiHoc.getTongBuoi());
    }
}