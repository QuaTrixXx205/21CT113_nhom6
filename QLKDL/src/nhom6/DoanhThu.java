
package nhom6;


public class DoanhThu {
    private String tourID;
    private String ngayThangDoanhThu;
    private double soTien;
    private String phuongThucThanhToan;
    private String nguoiThanhToan;
    private String nhanVienBanHang;

    public DoanhThu() {
    }

    public DoanhThu(String tourID, String ngayThangDoanhThu, double soTien, String phuongThucThanhToan, String nguoiThanhToan, String nhanVienBanHang) {
        this.tourID = tourID;
        this.ngayThangDoanhThu = ngayThangDoanhThu;
        this.soTien = soTien;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.nguoiThanhToan = nguoiThanhToan;
        this.nhanVienBanHang = nhanVienBanHang;
    }

    public String getTourID() {
        return tourID;
    }

    public String getNgayThangDoanhThu() {
        return ngayThangDoanhThu;
    }

    public double getSoTien() {
        return soTien;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public String getNguoiThanhToan() {
        return nguoiThanhToan;
    }

    public String getNhanVienBanHang() {
        return nhanVienBanHang;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
    }

    public void setNgayThangDoanhThu(String ngayThangDoanhThu) {
        this.ngayThangDoanhThu = ngayThangDoanhThu;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public void setNguoiThanhToan(String nguoiThanhToan) {
        this.nguoiThanhToan = nguoiThanhToan;
    }

    public void setNhanVienBanHang(String nhanVienBanHang) {
        this.nhanVienBanHang = nhanVienBanHang;
    }
    
    
}
