import java.util.*;

class ChuSoHuu {
    String cmnd;
    String hoTen;
    String email;

    public ChuSoHuu(String cmnd, String hoTen, String email) {
        this.cmnd = cmnd;
        this.hoTen = hoTen;
        this.email = email;
    }
}

abstract class PhuongTien {
    String soXe;
    String hangSX;
    int namSX;
    String mauXe;
    ChuSoHuu chu;

    public PhuongTien(String soXe, String hangSX, int namSX, String mauXe, ChuSoHuu chu) {
        this.soXe = soXe;
        this.hangSX = hangSX;
        this.namSX = namSX;
        this.mauXe = mauXe;
        this.chu = chu;
    }

    public abstract String loai();
}

class Oto extends PhuongTien {
    int soCho;
    String dongCo;

    public Oto(String soXe, String hangSX, int namSX, String mauXe, ChuSoHuu chu, int soCho, String dongCo) {
        super(soXe, hangSX, namSX, mauXe, chu);
        this.soCho = soCho;
        this.dongCo = dongCo;
    }

    public String loai() {
        return "Oto";
    }
}

class XeMay extends PhuongTien {
    double dungTich;

    public XeMay(String soXe, String hangSX, int namSX, String mauXe, ChuSoHuu chu, double dungTich) {
        super(soXe, hangSX, namSX, mauXe, chu);
        this.dungTich = dungTich;
    }

    public String loai() {
        return "XeMay";
    }
}

class XeTai extends PhuongTien {
    double taiTrong;

    public XeTai(String soXe, String hangSX, int namSX, String mauXe, ChuSoHuu chu, double taiTrong) {
        super(soXe, hangSX, namSX, mauXe, chu);
        this.taiTrong = taiTrong;
    }

    public String loai() {
        return "XeTai";
    }
}

class QLPhuongTien {
    ArrayList<PhuongTien> ds = new ArrayList<>();

    public boolean them(PhuongTien p) {
        for (PhuongTien x : ds) {
            if (x.soXe.equals(p.soXe)) return false;
        }
        ds.add(p);
        return true;
    }

    public PhuongTien timTheoSoXe(String soXe) {
        for (PhuongTien x : ds) {
            if (x.soXe.equals(soXe)) return x;
        }
        return null;
    }

    public ArrayList<PhuongTien> timTheoCMND(String cmnd) {
        ArrayList<PhuongTien> kq = new ArrayList<>();
        for (PhuongTien x : ds) {
            if (x.chu.cmnd.equals(cmnd)) kq.add(x);
        }
        return kq;
    }

    public void xoaTheoHang(String hang) {
        ds.removeIf(p -> p.hangSX.equals(hang));
    }

    public String hangNhieuNhat() {
        HashMap<String, Integer> map = new HashMap<>();
        for (PhuongTien x : ds) {
            map.put(x.hangSX, map.getOrDefault(x.hangSX, 0) + 1);
        }
        int max = 0;
        String kq = "";
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                kq = key;
            }
        }
        return kq;
    }

    public void sapXepGiamTheoNam() {
        ds.sort((a, b) -> b.namSX - a.namSX);
    }

    public void thongKeTheoLoai() {
        int oto = 0, xemay = 0, xetai = 0;
        for (PhuongTien x : ds) {
            switch (x.loai()) {
                case "Oto": oto++; break;
                case "XeMay": xemay++; break;
                case "XeTai": xetai++; break;
            }
        }
        System.out.println("Oto: " + oto);
        System.out.println("Xe may: " + xemay);
        System.out.println("Xe tai: " + xetai);
    }
}