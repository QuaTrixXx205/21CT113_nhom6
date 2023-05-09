
package nhom6;


public class Tour {
    private String tourID;
    private String tenTour;
    private String ngayKhoiHanh;
    private String ngayKetThuc;
    private String diaDiem;
    private int soLuongKhachToiDa;
    private double giaTour;
    private double soTienDatCoc; //Khoảng 40%
    private String phuongThucThanhToan;

    public Tour() {
    }

    public Tour(String tourID, String tenTour, String ngayKhoiHanh, String ngayKetThuc, String diaDiem, int soLuongKhachToiDa, double giaTour, double soTienDatCoc, String phuongThucThanhToan) {
        this.tourID = tourID;
        this.tenTour = tenTour;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayKetThuc = ngayKetThuc;
        this.diaDiem = diaDiem;
        this.soLuongKhachToiDa = soLuongKhachToiDa;
        this.giaTour = giaTour;
        this.soTienDatCoc = soTienDatCoc;
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getTourID() {
        return tourID;
    }

    public String getTenTour() {
        return tenTour;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public int getSoLuongKhachToiDa() {
        return soLuongKhachToiDa;
    }

    public double getGiaTour() {
        return giaTour;
    }

    public double getSoTienDatCoc() {
        return soTienDatCoc;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
    }

    public void setTenTour(String tenTour) {
        this.tenTour = tenTour;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public void setSoLuongKhachToiDa(int soLuongKhachToiDa) {
        this.soLuongKhachToiDa = soLuongKhachToiDa;
    }

    public void setGiaTour(double giaTour) {
        this.giaTour = giaTour;
    }

    public void setSoTienDatCoc(double soTienDatCoc) {
        this.soTienDatCoc = soTienDatCoc;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    

    
    
    
}
