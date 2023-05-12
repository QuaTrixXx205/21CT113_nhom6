
package nhom6;


public class DoanhThu {
    private String doanhThuID;
    private String ngayThangDoanhThu;
    private double soTien;
    private String phuongThucThanhToan;
    private String nguoiThanhToan;

    public DoanhThu() {
    }

    public DoanhThu(String doanhThuID, String ngayThangDoanhThu, double soTien, String phuongThucThanhToan, String nguoiThanhToan) {
        this.doanhThuID = doanhThuID;
        this.ngayThangDoanhThu = ngayThangDoanhThu;
        this.soTien = soTien;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.nguoiThanhToan = nguoiThanhToan;
    }

    public String getDoanhThuID() {
        return doanhThuID;
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

    public void setDoanhThuID(String doanhThuID) {
        this.doanhThuID = doanhThuID;
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

   

    
    
    
}
