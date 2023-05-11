
package nhom6;


public class KhieuNai {
    private String khieuNaiID;
    private String hoTenKhach;
    private String diaChiKhach;
    private String tourID;
    private String lyDoKN;

    public KhieuNai() {
    }

    public KhieuNai(String khieuNaiID, String hoTenKhach, String diaChiKhach, String tourID, String lyDoKN) {
        this.khieuNaiID = khieuNaiID;
        this.hoTenKhach = hoTenKhach;
        this.diaChiKhach = diaChiKhach;
        this.tourID = tourID;
        this.lyDoKN = lyDoKN;
    }

    public String getKhieuNaiID() {
        return khieuNaiID;
    }

    public String getHoTenKhach() {
        return hoTenKhach;
    }

    public String getDiaChiKhach() {
        return diaChiKhach;
    }

    public String getTourID() {
        return tourID;
    }

    public String getLyDoKN() {
        return lyDoKN;
    }

    public void setKhieuNaiID(String khieuNaiID) {
        this.khieuNaiID = khieuNaiID;
    }

    public void setHoTenKhach(String hoTenKhach) {
        this.hoTenKhach = hoTenKhach;
    }

    public void setDiaChiKhach(String diaChiKhach) {
        this.diaChiKhach = diaChiKhach;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
    }

    public void setLyDoKN(String lyDoKN) {
        this.lyDoKN = lyDoKN;
    }

    
    
    
}
