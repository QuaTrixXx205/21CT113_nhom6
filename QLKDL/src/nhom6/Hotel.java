
package nhom6;


public class Hotel {
    private String maKS;
    private String diaChiKhachSan;
    private int soSao; //VD: Khách sạn 3*, 4*, 5*
    private int soLuongPhong;
    private double giaPhong;
    private String tienNghiKhachSan; //Tiện nghi khách sạn
    private String thongTinLienHe; //Thông tin liên hệ của khách sạn

    public Hotel() {
    }

    public Hotel(String maKS, String diaChiKhachSan, int soSao, int soLuongPhong, double giaPhong, String tienNghiKhachSan, String thongTinLienHe) {
        this.maKS = maKS;
        this.diaChiKhachSan = diaChiKhachSan;
        this.soSao = soSao;
        this.soLuongPhong = soLuongPhong;
        this.giaPhong = giaPhong;
        this.tienNghiKhachSan = tienNghiKhachSan;
        this.thongTinLienHe = thongTinLienHe;
    }

    public String getMaKS() {
        return maKS;
    }

    public String getDiaChiKhachSan() {
        return diaChiKhachSan;
    }

    public int getSoSao() {
        return soSao;
    }

    public int getSoLuongPhong() {
        return soLuongPhong;
    }

    public double getGiaPhong() {
        return giaPhong;
    }

    public String getTienNghiKhachSan() {
        return tienNghiKhachSan;
    }

    public String getThongTinLienHe() {
        return thongTinLienHe;
    }

    public void setMaKS(String maKS) {
        this.maKS = maKS;
    }

    public void setDiaChiKhachSan(String diaChiKhachSan) {
        this.diaChiKhachSan = diaChiKhachSan;
    }

    public void setSoSao(int soSao) {
        this.soSao = soSao;
    }

    public void setSoLuongPhong(int soLuongPhong) {
        this.soLuongPhong = soLuongPhong;
    }

    public void setGiaPhong(double giaPhong) {
        this.giaPhong = giaPhong;
    }

    public void setTienNghiKhachSan(String tienNghiKhachSan) {
        this.tienNghiKhachSan = tienNghiKhachSan;
    }

    public void setThongTinLienHe(String thongTinLienHe) {
        this.thongTinLienHe = thongTinLienHe;
    }

    
    
    
}
