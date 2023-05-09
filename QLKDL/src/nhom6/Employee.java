
package nhom6;
import java.util.List;
import java.util.ArrayList;

public class Employee {
    private String maNV;
    private String tenNV;
    private String chucVuNV;
    private String diaChiNV;
    private String sdtNV;
    private String emailNV;
    private String ngayThangNamSinhNV;

    public Employee() {
    }

    public Employee(String maNV, String tenNV, String chucVuNV, String diaChiNV, String sdtNV, String emailNV, String ngayThangNamSinhNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.chucVuNV = chucVuNV;
        this.diaChiNV = diaChiNV;
        this.sdtNV = sdtNV;
        this.emailNV = emailNV;
        this.ngayThangNamSinhNV = ngayThangNamSinhNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getChucVuNV() {
        return chucVuNV;
    }

    public String getDiaChiNV() {
        return diaChiNV;
    }

    public String getSdtNV() {
        return sdtNV;
    }

    public String getEmailNV() {
        return emailNV;
    }

    public String getNgayThangNamSinhNV() {
        return ngayThangNamSinhNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setChucVuNV(String chucVuNV) {
        this.chucVuNV = chucVuNV;
    }

    public void setDiaChiNV(String diaChiNV) {
        this.diaChiNV = diaChiNV;
    }

    public void setSdtNV(String sdtNV) {
        this.sdtNV = sdtNV;
    }

    public void setEmailNV(String emailNV) {
        this.emailNV = emailNV;
    }

    public void setNgayThangNamSinhNV(String ngayThangNamSinhNV) {
        this.ngayThangNamSinhNV = ngayThangNamSinhNV;
    }
    

    // Danh sách nhân viên
    private static List<Employee> employeeList = new ArrayList<>();

    // Phương thức thêm nhân viên
    public static void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    // Phương thức xóa nhân viên
    public static void deleteEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    // Phương thức lấy danh sách nhân viên
    public static List<Employee> getEmployeeList() {
        return employeeList;
    }
    
    @Override
public String toString() {
    return maNV + ";" + tenNV + ";" + chucVuNV + ";" + diaChiNV + ";" + sdtNV + ";" + emailNV + ";" + ngayThangNamSinhNV;
}


    
    
}
