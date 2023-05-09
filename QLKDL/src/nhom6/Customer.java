package nhom6;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import nhom6.Main;

public class Customer {
    private String username;
    private String userPassword;
    private String fullName;
    private String sdt;
    private String email;
    private String diaChiKhach;
    private String ngaySinh;
    private String gioiTinh;
    private String CCCD;
    
    
    public Customer() {

    }
    
    

    public Customer(String username, String userPassword, String fullName, String sdt, String email, String diaChiKhach, String ngaySinh, String gioiTinh, String CCCD) {
        this.username = username;
        this.userPassword = userPassword;
        this.fullName = fullName;
        this.sdt = sdt;
        this.email = email;
        this.diaChiKhach = diaChiKhach;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.CCCD = CCCD;
    }

    // các phương thức getter và setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChiKhach() {
        return diaChiKhach;
    }

    public void setDiaChiKhach(String diaChiKhach) {
        this.diaChiKhach = diaChiKhach;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCCCD() {
        return CCCD;
    }
    
    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }
    

    ////////////////////////////////////
    
    public void myProfileInfo() {
    System.out.println("==================== Thong tin tai khoan ====================");
    System.out.println("Ho ten: " + fullName);
    System.out.println("So dien thoai: " + sdt);
    System.out.println("Email: " + email);
    System.out.println("Dia chi: " + diaChiKhach);
    System.out.println("Ngay sinh: " + ngaySinh);
    System.out.println("Gioi tinh: " + gioiTinh);
    System.out.println("So CCCD/CMND: " + CCCD);
    System.out.println("=============================================================");
    }
    
    public void lichSuDatTour()
    {
        
    }
    
    public void HotelInfo() {
    String filePath = "src/nhom6/hotelList.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        System.out.printf("%-10s %-20s %-20s %-10s %-20s %-20s %-30s %-30s%n",
                "Ma KS", "Ten khach san", "Dia chi", "So sao", "So luong phong", "Gia phong", "Tien nghi", "Thong tin lien he");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
        while ((line = br.readLine()) != null) {
            String[] hotelData = line.split(",");
            System.out.printf("%-10s %-20s %-20s %-10s %-20s %-20s %-30s %-30s%n",
                    hotelData[0], hotelData[1], hotelData[2], hotelData[3], hotelData[4],
                    hotelData[5], hotelData[6], hotelData[7]);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    
    public void KhieuNai()
    {
        
    }
    
    public void customerInterface()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("====================Customer======================");
        System.out.println("Xin chao khach hang!");
        System.out.println("1. Dang Nhap");
        System.out.println("2. Dang Ky Tai Khoan");
        System.out.println("3. Quay lai man hinh chinh");
        System.out.print("Lua chon: ");
        int choice = sc.nextInt();
        
        switch (choice) {
            case 2:
                {
                    System.out.println("Vui long nhap thong tin tai khoan");
                    sc.nextLine();
                    System.out.print("Ten dang nhap: ");
                    String username = sc.nextLine();
                    System.out.print("Mat khau: ");
                    String userPassword = sc.nextLine();
                    System.out.print("Ho ten: ");
                    String fullName = sc.nextLine();
                    System.out.print("So dien thoai: ");
                    String sdt = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Dia chi: ");
                    String diaChiKhach = sc.nextLine();
                    System.out.print("Ngay sinh: ");
                    String ngaySinh = sc.nextLine();
                    System.out.print("Gioi tinh: ");
                    String gioiTinh = sc.nextLine();
                    System.out.print("So CCCD/CMND: ");
                    String CCCD = sc.next();
                    Customer customer = new Customer(username, userPassword, fullName, sdt, email, diaChiKhach, ngaySinh, gioiTinh, CCCD);
                    try {
                        // Mở file để ghi dữ liệu
                        File file = new File("src/nhom6/CustomerInfo.txt");
                        FileWriter fileWriter = new FileWriter(file, true);
                        
                        // Ghi dữ liệu vào file
                        fileWriter.write(customer.getUsername() + "," + customer.getUserPassword() + "," + customer.getFullName() + "," + customer.getSdt() + "," + customer.getEmail() + "," + customer.getDiaChiKhach() + "," + customer.getNgaySinh() + "," + customer.getGioiTinh() + "," + customer.getCCCD() + "\n");
                        
                        // Đóng file
                        fileWriter.close();
                        
                        System.out.println("Dang ky tai khoan thanh cong!");
                        customerInterface();
                        
                    } catch (IOException e) {
                        System.out.println("Loi ghi du lieu vao file!");
                        e.printStackTrace();
                    }       break;
                }
            case 1:
                {
                    System.out.print("Ten dang nhap: ");
                    String username = sc.next();
                    System.out.print("Mat khau: ");
                    String userPassword = sc.next();
                    boolean isUserExist = false;
                    try {
                        // Mở file để đọc dữ liệu
                        File file = new File("src/nhom6/CustomerInfo.txt");
                        FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        
                        // Đọc các dòng dữ liệu trong file
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            // Tách các thuộc tính của khách hàng từ dòng đọc được
                            String[] attributes = line.split(",");
                            
                            // Kiểm tra xem tài khoản có tồn tại trong file hay không
                            if (attributes[0].equals(username) && attributes[1].equals(userPassword)) {
                                System.out.println("Dang nhap thanh cong!");
                                boolean customerMenu = true;
                                isUserExist = true;
                                
                                while(customerMenu)
                                {
                                    // Thực hiện các chức năng khác của khách hàng ở đây
                                    String fullName = attributes[2];
                                    String sdt = attributes[3];
                                    String email = attributes[4];
                                    String diaChiKhach = attributes[5];
                                    String ngaySinh = attributes[6];
                                    String gioiTinh = attributes[7];
                                    String CCCD = attributes[8];
                                    
                                    Customer loggedInCustomer = new Customer(username, userPassword, fullName, sdt, email, diaChiKhach, ngaySinh, gioiTinh, CCCD);
                                
                                    System.out.println("1. Thong tin tai khoan cua toi");
                                    System.out.println("2. Xem cac tour hien co trong khu du lich");
                                    System.out.println("3. Xem thong tin cac khach san trong khu du lich");
                                    System.out.println("4. Dat Tour");
                                    System.out.println("5. Lam don khieu nai");
                                    System.out.println("6. Dang xuat va quay lai trang dang nhap/dang ky khach hang");
                                    System.out.print("Lua chon: ");
                                    int choice3 = sc.nextInt();
                                    sc.nextLine();
                                    
                                    
                                    switch(choice3)
                                    {
                                        case 1:
                                            loggedInCustomer.myProfileInfo();
                                            break;
                                        case 2:
                                            System.out.println("Tour");
                                            break;
                                        case 3:
                                            HotelInfo();
                                            break;
                                        case 4:
                                            System.out.println("Dat Tour");
                                            break;
                                        case 5:
                                            
                                            break;
                                        case 6:
                                            isUserExist = false;
                                            customerInterface();
                                            break;
                                        default:
                                            System.out.println("Lua chon khong hop le, vui long nhap lai");
                                    }
                                }
                                                           
                                break;
                            }
                        }
                        
                        // Đóng file sau khi hoàn thành việc đọc dữ liệu
                        bufferedReader.close();
                        
                        boolean continueLoop = true;
                        // Nếu tài khoản không tồn tại, yêu cầu người dùng đăng nhập lại hoặc là tạo tài khoản mới
                        while (!isUserExist && continueLoop) {
                            System.out.println("Tai khoan khong ton tai, vui long dang nhap lai!");
                            System.out.println("Neu quy khach khong co tai khoan thi co the dang ky tai day!");
                            System.out.println("1. Dang nhap lai     2. Dang ky tai khoan moi    3. Quay lai man hinh chinh");
                            System.out.print("Lua chon: ");
                            int choice2 = sc.nextInt();
                            sc.nextLine();
                            
                            switch(choice2)
                            {
                                case 1:
                                    System.out.print("Ten dang nhap: ");
                                    username = sc.next();
                                    System.out.print("Mat khau: ");
                                    userPassword = sc.next();
                                    //Kiểm tra thông tin tài khoản vừa nhập xem có tồn tại không
                                    isUserExist = false;
                                    fileReader = new FileReader(file);
                                    bufferedReader = new BufferedReader(fileReader);
                                    while((line = bufferedReader.readLine()) != null)
                                    {
                                        String[] attributes = line.split(",");
                                        if (attributes[0].equals(username) && attributes[1].equals(userPassword)) {
                                System.out.println("Dang nhap thanh cong!");
                                boolean customerMenu = true;
                                isUserExist = true;
                                
                                while(customerMenu)
                                {
                                    // Thực hiện các chức năng khác của khách hàng ở đây
                                    String fullName = attributes[2];
                                    String sdt = attributes[3];
                                    String email = attributes[4];
                                    String diaChiKhach = attributes[5];
                                    String ngaySinh = attributes[6];
                                    String gioiTinh = attributes[7];
                                    String CCCD = attributes[8];
                                    
                                    Customer loggedInCustomer = new Customer(username, userPassword, fullName, sdt, email, diaChiKhach, ngaySinh, gioiTinh, CCCD);
                                
                                    System.out.println("1. Thong tin tai khoan cua toi");
                                    System.out.println("2. Dat Tour");
                                    System.out.println("3. Thong tin cac khach san trong khu du lich");
                                    System.out.println("4. Lam don khieu nai");
                                    System.out.println("5. Dang xuat va quay lai trang dang nhap/dang ky khach hang");
                                    System.out.print("Lua chon: ");
                                    int choice3 = sc.nextInt();
                                    sc.nextLine();
                                    
                                    
                                    switch(choice3)
                                    {
                                        case 1:
                                            loggedInCustomer.myProfileInfo();
                                            break;
                                        case 2:
                                            System.out.println("Tour");
                                            break;
                                        case 3:
                                            HotelInfo();
                                            break;
                                        case 4:
                                            System.out.println("Khieu nai");
                                            break;
                                        case 5:
                                            isUserExist = false;
                                            customerInterface();
                                            break;
                                        default:
                                            System.out.println("Lua chon khong hop le, vui long nhap lai");
                                    }
                                }
                                                           
                                break;
                            }
                                    }
                                    bufferedReader.close();
                                    break;
                                case 2:
                                    System.out.println("Dang ky tai khoan moi");
                                    System.out.print("Ten dang nhap: ");
                                    username = sc.nextLine();
                                    System.out.print("Mat khau: ");
                                    userPassword = sc.nextLine();
                                    System.out.print("Ho ten: ");
                                    fullName = sc.nextLine();
                                    System.out.print("So dien thoai: ");
                                    sdt = sc.nextLine();
                                    System.out.print("Email: ");
                                    email = sc.nextLine();
                                    System.out.print("Dia chi: ");
                                    diaChiKhach = sc.nextLine();
                                    System.out.print("Ngay sinh: ");
                                    ngaySinh = sc.nextLine();
                                    System.out.print("Gioi tinh: ");
                                    gioiTinh = sc.nextLine();
                                    System.out.print("So CCCD/CMND: ");
                                    CCCD = sc.next();
                                    
                                    Customer newCustomer = new Customer(username, userPassword, fullName, sdt, email, diaChiKhach, ngaySinh, gioiTinh, CCCD);
                                    
                                    try {
                                        // Mở file để ghi dữ liệu
                                        BufferedWriter writer = new BufferedWriter(new FileWriter("src/nhom6/CustomerInfo.txt", true));
                                        
                                        writer.write(newCustomer.getUsername() + "," + newCustomer.getUserPassword() + "," + newCustomer.getFullName() + "," + newCustomer.getSdt() + "," + newCustomer.getEmail() + "," + newCustomer.getDiaChiKhach() + "," + newCustomer.getNgaySinh() + "," + newCustomer.getGioiTinh() + "," + newCustomer.getCCCD() + "\n");
                                        writer.close();
                                        
                                        System.out.println("Dang ky tai khoan thanh cong!");
                                        isUserExist = true;
                                        customerInterface();
                                        break;
                                    } catch (IOException e) {
                                        System.out.println("Loi khi ghi du lieu vao file!");
                                        e.printStackTrace();
                                    }
                                    
                                    
                                case 3:
                                    Main.main(null);
                                    System.exit(0);
                                    break;
                            }
                            
                        }
                        
                    } catch (IOException e) {
                        System.out.println("Loi khi doc file!");
                        e.printStackTrace();
                    }           break;
                }
            case 3:
                Main.main(null);
                System.exit(0);
            default:
                break;
        }

    }       
}
