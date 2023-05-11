package nhom6;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
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
       
    public void bookTour(String user) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Nhap ID tour muon dat: ");
    String tourID = sc.nextLine().trim();

    // Kiểm tra tour có tồn tại trong danh sách tour hay không
    if (isTourAvailable(tourID)) {
        // Lấy thông tin tour từ danh sách tour gốc
        Tour selectedTour = getTourByID(tourID);

        // Nhập thông tin ngày khởi hành và ngày kết thúc
        System.out.print("Nhap ngay khoi hanh: ");
        String ngayKhoiHanh = sc.nextLine();
        System.out.print("Nhap ngay ket thuc: ");
        String ngayKetThuc = sc.nextLine();

        // Nhập thông tin phương thức thanh toán
        System.out.print("Nhap phuong thuc thanh toan: ");
        String phuongThucThanhToan = sc.nextLine();

        // Lưu thông tin tour vào file customerTour.txt
        saveCustomerTour(user, tourID, ngayKhoiHanh, ngayKetThuc, selectedTour.getDiaDiem(),
                selectedTour.getSoLuongKhachToiDa(), selectedTour.getGiaTour(), selectedTour.getSoTienDatCoc(),
                phuongThucThanhToan);
        System.out.println("Da dat tour thanh cong.");
    } else {
        System.out.println("Tour khong ton tai.");
    }
}
    
    public Tour getTourByID(String tourID) {
    String filePath = "src/nhom6/tourList.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] tourData = line.split(",");
            if (tourData[0].trim().equals(tourID.trim())) { // Sử dụng phương thức trim() để loại bỏ khoảng trắng đầu và cuối chuỗi
                // Tạo đối tượng Tour từ dữ liệu tour trong danh sách
                return new Tour(tourData[0].trim(), tourData[1].trim(), tourData[2].trim(), tourData[3].trim(), tourData[4].trim(),
                        Integer.parseInt(tourData[5].trim()), Double.parseDouble(tourData[6].trim()),
                        Double.parseDouble(tourData[7].trim()), tourData[8].trim());
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null;
}

    
    public boolean isTourAvailable(String tourID) {
    String filePath = "src/nhom6/tourList.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] tourData = line.split(",");
            if (tourData[0].equals(tourID)) {
                return true;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return false;
}

    public String getTourNameByID(String tourID) {
    String filePath = "src/nhom6/tourList.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] tourData = line.split(",");
            if (tourData[0].equals(tourID)) {
                return tourData[1];
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return "";
}
    
    public void saveCustomerTour(String user, String tourID, String ngayKhoiHanh, String ngayKetThuc, String diaDiem,
        int soLuongKhachToiDa, double giaTour, double soTienDatCoc, String phuongThucThanhToan) {
    String filePath = "src/nhom6/customerTour.txt";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
        String tenTour = getTourNameByID(tourID);
        writer.write(user + "," + tourID + "," + tenTour + "," + ngayKhoiHanh + "," + ngayKetThuc + "," + diaDiem + ","
                + soLuongKhachToiDa + "," + giaTour + "," + soTienDatCoc + "," + phuongThucThanhToan);
        writer.newLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    public void TourInfo() {
    String filePath = "src/nhom6/tourList.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;

        // In tiêu đề cột
        System.out.printf("%-10s | %-30s | %-15s | %-15s | %-25s | %-15s | %-15s | %-15s | %-20s\n",
                        "Tour ID", "Ten Tour", "Ngay Khoi Hanh", "Ngay Ket Thuc", "Dia Diem", "So Luong Toi Da", "Gia Tour",
                        "So Tien Dat Coc", "Phuong Thuc Thanh Toan");

        // In dữ liệu từ file
        while ((line = br.readLine()) != null) {
            String[] tourData = line.split(",");
            System.out.printf("%-10s | %-30s | %-15s | %-15s | %-25s | %-15s | %-15s | %-15s | %-20s\n",
                    tourData[0], tourData[1], tourData[2], tourData[3], tourData[4],
                    tourData[5], tourData[6], tourData[7], tourData[8]);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
 
    public void lichSuDatTour(String user) {
    String filePath = "src/nhom6/customerTour.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        boolean foundUser = false;
        System.out.println("Lich su dat tour cua "+user);
        System.out.println("====================================================================================================================================================================================");
        System.out.printf("%-12s %-12s %-30s %-20s %-20s %-18s %-15s %-15s %-15s %-15s\n",
                "Username", "Tour ID", "Hanh trinh", "Ngay khoi hanh",
                "Ngay ket thuc", "Dia diem", "SL khach", "Gia tour", "Tien coc", "Phuong thuc");
        System.out.println("====================================================================================================================================================================================");

        while ((line = br.readLine()) != null) {
            String[] tourData = line.split(",");
            String username = tourData[0];

            if (username.equals(user) && tourData.length >= 10) {
                // In ra thông tin tour đã đặt của người dùng
                System.out.printf("%-12s %-12s %-30s %-20s %-20s %-18s %-15s %-15s %-15s %-15s\n",
                    tourData[0], tourData[1], tourData[2], tourData[3], tourData[4],
                    tourData[5], tourData[6], tourData[7], tourData[8], tourData[9]);

                foundUser = true;
            }
        }

        if (!foundUser) {
            System.out.println("Khong co lich su dat tour cho nguoi dung: " + user);
        }

        System.out.println("====================================================================================================================================================================================");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public boolean cancelTour(String user, String tourID) {
    String filePath = "src/nhom6/customerTour.txt";
    File file = new File(filePath);
    File tempFile = new File("src/nhom6/customerTourTemp.txt");

    boolean isCanceled = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(file));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

        String line;
        while ((line = reader.readLine()) != null) {
            String[] tourData = line.split(",");

            if (tourData.length >= 2 && tourData[0].equals(user) && tourData[1].equals(tourID)) {
                // Bỏ qua tour cần hủy
                isCanceled = true;
                continue;
            }

            writer.write(line);
            writer.newLine();
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    // Xóa file gốc
    file.delete();

    // Đổi tên file tạm thành tên file gốc
    tempFile.renameTo(file);

    return isCanceled;
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
    
    public void bookHotel(String user) {
    String filePath = "src/nhom6/customerHotel.txt";
    Scanner scanner = new Scanner(System.in);

    // In danh sách các khách sạn có sẵn
    System.out.println("Danh sach cac khach san");
    HotelInfo();

    System.out.print("Nhap ID khach san ban muon dat: ");
    String hotelID = scanner.nextLine();

    // Kiểm tra xem khách sạn có tồn tại không
    if (!checkHotelExist(hotelID)) {
        System.out.println("Khach san khong ton tai.");
        return;
    }

    // Lấy thông tin khách sạn từ ID
    String hotelInfo = getHotelInfoFromID(hotelID);
    if (hotelInfo == null) {
        System.out.println("Khach san khong ton tai.");
        return;
    }

    // Ghi tên user và thông tin khách sạn vào file
    try (FileWriter fw = new FileWriter(filePath, true)) {
        fw.write(user + "," + hotelInfo + "\n");
        System.out.println("Dat khach san thanh cong.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    public String getHotelInfoFromID(String hotelID) {
    // Lấy thông tin khách sạn từ ID
    String filePath = "src/nhom6/hotelList.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] hotelData = line.split(",");
            String currentHotelID = hotelData[0];

            if (currentHotelID.equals(hotelID)) {
                return String.join(",", hotelData);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null;
}
    
    public boolean checkHotelExist(String hotelID) {
        // Kiểm tra xem khách sạn có tồn tại không
        String filePath = "src/nhom6/hotelList.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] hotelData = line.split(",");
                String currentHotelID = hotelData[0];

                if (currentHotelID.equals(hotelID)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    
    public void printBookedHotels(String user) {
    String filePath = "src/nhom6/customerHotel.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        boolean isPrinted = false; // Biến kiểm tra đã in thông tin hay chưa
        while ((line = br.readLine()) != null) {
            String[] hotelData = line.split(",");
            String currentUser = hotelData[0];

            if (currentUser.equals(user)) {
                if (!isPrinted) {
                    System.out.println("Cac khach san da dat cua " + user);
                    System.out.println("------------------------------------------");
                    System.out.printf("%-12s %-20s %-20s %-15s %-20s %-15s %-25s %-20s%n",
                            "Tour ID","Khach san", "Dia chi", "So sao", "So luong phong", "Gia phong",
                            "Tien nghi khach san", "Thong tin lien he");
                    System.out.println("------------------------------------------");
                    isPrinted = true;
                }

                System.out.printf("%-12s %-20s %-20s %-15s %-20s %-15s %-25s %-20s%n",
                        hotelData[1], hotelData[2], hotelData[3], hotelData[4],
                        hotelData[5], hotelData[6], hotelData[7], hotelData[8]);
            }
        }

        if (!isPrinted) {
            System.out.println("Khong co khach san nao duoc dat boi nguoi dung.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public boolean cancelHotel(String user, String hotelID) {
    String filePath = "src/nhom6/customerHotel.txt";
    File file = new File(filePath);
    File tempFile = new File("src/nhom6/tempCustomerHotel.txt");

    boolean isCanceled = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(file));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
         PrintWriter pw = new PrintWriter(writer)) {

        String line;
        boolean isUserFound = false;

        System.out.println("Cac khach san da dat cua " + user);
        System.out.println("------------------------------------------");
        System.out.printf("%-12s %-20s %-20s %-15s %-20s %-15s %-25s %-20s%n",
                "ID", "Khach san", "Dia chi", "So sao", "So luong phong", "Gia phong",
                "Tien nghi khach san", "Thong tin lien he");
        System.out.println("------------------------------------------");

        while ((line = reader.readLine()) != null) {
            String[] hotelData = line.split(",");

            // Nếu dòng dữ liệu là dữ liệu của khách hàng hiện tại
            if (hotelData.length >= 2 && hotelData[0].equals(user)) {
                // Nếu dòng dữ liệu chứa thông tin tour muốn hủy
                if (hotelData[1].equals(hotelID)) {
                    isCanceled = true;
                    continue;
                }

                // In thông tin tour lên màn hình
                System.out.printf("%-12s %-20s %-20s %-15s %-20s %-15s %-25s %-20s%n",
                        hotelData[1], hotelData[2], hotelData[3], hotelData[4],
                        hotelData[5], hotelData[6], hotelData[7], hotelData[8]);
            }

            pw.println(line);
            pw.flush();
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    // Xóa file gốc
    file.delete();

    // Đổi tên file tạm thành tên file gốc
    tempFile.renameTo(file);

    return isCanceled;
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
                                    System.out.println("5. Dat khach san");
                                    System.out.println("6. Lam don khieu nai");
                                    System.out.println("7. Lich su dat tour");
                                    System.out.println("8. Khach san da dat");
                                    System.out.println("9. Huy tour");
                                    System.out.println("10. Huy khach san da dat");
                                    System.out.println("11. Dang xuat va quay lai trang dang nhap/dang ky khach hang");
                                    System.out.print("Lua chon: ");
                                    int choice3 = sc.nextInt();
                                    sc.nextLine();
                                    
                                    
                                    switch(choice3)
                                    {
                                        case 1:
                                            if(isUserExist)
                                            {
                                                loggedInCustomer.myProfileInfo();
                                            } else {
                                                System.out.println("Ban can dang nhap de su dung chuc nang nay");
                                            }                          
                                            break;
                                        case 2:
                                            if(isUserExist)
                                            {
                                                TourInfo();
                                            } else {
                                                System.out.println("Ban can dang nhap de su dung chuc nang nay");
                                            } 
                                            break;
                                        case 3:
                                            if(isUserExist)
                                            {
                                                HotelInfo();
                                            } else {
                                                System.out.println("Ban can dang nhap de su dung chuc nang nay");
                                            } 
                                            break;
                                        case 4:
                                            if (isUserExist) { 
                                                String user = loggedInCustomer.username;

                                                // Hiển thị danh sách tour hiện có
                                                System.out.println("Danh sach cac tour hien co trong khu du lich");
                                                TourInfo();

                                                // Gọi phương thức để đặt tour
                                                bookTour(user);
                                                } else {
                                                    System.out.println("Ban can dang nhap truoc khi dat tour.");
                                            }
                                            break;
                                        case 5:
                                            System.out.println("Dat khach san");
                                            if(isUserExist)
                                            {
                                                String user = loggedInCustomer.username;
                                                
                                                bookHotel(user);
                                            } else {
                                                System.out.println("Ban can dang nhap truoc khi dat khach san");
                                            }
                                            break;
                                        case 6:
                                            System.out.println("Lam don khieu nai");
                                            if(isUserExist)
                                            {
                                                if (isUserExist) {
                                                username = loggedInCustomer.username;
                                                fullName = loggedInCustomer.fullName;
                                                diaChiKhach = loggedInCustomer.diaChiKhach;
                                                
                                                System.out.print("Nhap ID khieu nai: ");
                                                String khieuNaiID = sc.nextLine();

                                                System.out.print("Nhap ma tour:");
                                                String tourID = sc.nextLine().trim();

                                                System.out.print("Noi dung khieu nai:");
                                                String content = sc.nextLine().trim();

                                                KhieuNai complaint = new KhieuNai(khieuNaiID,fullName, diaChiKhach, tourID, content);

                                                try {
                                                    // Mở file để ghi dữ liệu
                                                    BufferedWriter writer = new BufferedWriter(new FileWriter("src/nhom6/KhieuNai.txt", true));

                                                    // Ghi thông tin khiếu nại vào file
                                                    writer.write(khieuNaiID + "," + username + "," + fullName + "," + diaChiKhach + "," + tourID + "," + content + "\n");

                                                    // Đóng file
                                                    writer.close();

                                                    System.out.println("Gui khieu nai thanh cong!");
                                                } catch (IOException e) {
                                                    System.out.println("Loi khi gui khieu nai");
                                                    e.printStackTrace();
                                                    }
                                            } else {
                                                System.out.println("Ban can dang nhap de su dung chuc nang nay");
                                                }
                                            }                                     
                                            break;
                                        case 7:
                                            System.out.println("Lich su dat tour");
                                            if(isUserExist)
                                            {
                                                String user = loggedInCustomer.username;
                                            
                                                lichSuDatTour(user);
                                            } else {
                                                System.out.println("Ban can dang nhap de su dung chuc nang nay");
                                            }
                                            break;
                                        case 8:
                                            System.out.println("Khach san da dat");
                                            if(isUserExist)
                                            {
                                                String user = loggedInCustomer.username;
                                                
                                                printBookedHotels(user);
                                            } else {
                                                System.out.println("Ban can dang nhap truoc khi su dung tinh nang nay");
                                            }
                                            break;
                                        case 9:
                                            if (isUserExist) {
                                                System.out.println("Huy Tour");
                                                String user = loggedInCustomer.username;

                                                // Hiển thị danh sách tour đã đặt của người dùng
                                                System.out.println("Danh sach tour da dat cua ban:");
                                                lichSuDatTour(user);

                                                // Yêu cầu người dùng nhập ID tour muốn hủy
                                                System.out.print("Nhap ID tour muon huy: ");
                                                String tourID = sc.nextLine();

                                                // Xóa tour khỏi danh sách tour đã đặt
                                                boolean isTourCanceled = cancelTour(user, tourID);

                                                if (isTourCanceled) {
                                                    System.out.println("Huy tour thanh cong.");
                                                } else {
                                                    System.out.println("Khong tim thay tour hoac khong the huy tour.");
                                                }
                                            } else {
                                                System.out.println("Ban can dang nhap truoc khi huy tour.");
                                            }
                                            break;
                                        case 10:
                                             if (isUserExist) {
                                                String user = loggedInCustomer.username;

                                                // Hiển thị các tour đã đặt của người dùng
                                                cancelHotel(user, null);

                                                // Hỏi người dùng nhập ID của tour muốn hủy
                                                System.out.print("Nhap ID khach san muon huy: ");
                                                String hotelID = sc.nextLine().trim();

                                                // Hủy tour
                                                boolean isCanceled = cancelHotel(user, hotelID);
        
                                                if (isCanceled) {
                                                    System.out.println("Khach san da duoc huy thanh cong.");
                                                } else {
                                                    System.out.println("Khong tim thay khach san voi ID da duoc nhap.");
                                                }
                                                } else {
                                                    System.out.println("Ban can dang nhap truoc khi su dung chuc nang nay");
                                                }
                                             break;
                                        case 11:
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
                                    System.out.println("2. Xem cac tour hien co trong khu du lich");
                                    System.out.println("3. Xem thong tin cac khach san trong khu du lich");
                                    System.out.println("4. Dat Tour");
                                    System.out.println("5. Dat phong khach san");
                                    System.out.println("6. Lam don khieu nai");
                                    System.out.println("7. Lich su dat tour");
                                    System.out.println("8. Khach san da dat");
                                    System.out.println("9. Huy tour");
                                    System.out.println("10. Huy khach san da dat");
                                    System.out.println("11. Dang xuat va quay lai trang dang nhap/dang ky khach hang");
                                    System.out.print("Lua chon: ");
                                    int choice3 = sc.nextInt();
                                    sc.nextLine();
                                    
                                    
                                    switch(choice3)
                                    {
                                        case 1:
                                            if(isUserExist)
                                            {
                                                loggedInCustomer.myProfileInfo();
                                            } else {
                                                System.out.println("Ban can dang nhap de su dung chuc nang nay");
                                            }                          
                                            break;
                                        case 2:
                                            if(isUserExist)
                                            {
                                                TourInfo();
                                            } else {
                                                System.out.println("Ban can dang nhap de su dung chuc nang nay");
                                            } 
                                            break;
                                        case 3:
                                            if(isUserExist)
                                            {
                                                HotelInfo();
                                            } else {
                                                System.out.println("Ban can dang nhap de su dung chuc nang nay");
                                            } 
                                            break;
                                        case 4:
                                            if (isUserExist) { 
                                                String user = loggedInCustomer.username;

                                                // Hiển thị danh sách tour hiện có
                                                System.out.println("Danh sach cac tour hien co trong khu du lich");
                                                TourInfo();

                                                // Gọi phương thức để đặt tour
                                                bookTour(user);
                                                } else {
                                                    System.out.println("Ban can dang nhap truoc khi dat tour.");
                                            }
                                            break;
                                        case 5:
                                            System.out.println("Dat khach san");
                                            if(isUserExist)
                                            {
                                                String user = loggedInCustomer.username;
                                                
                                                bookHotel(user);
                                            } else {
                                                System.out.println("Ban can dang nhap truoc khi dat khach san");
                                            }
                                            break;
                                        case 6:
                                            System.out.println("Lam don khieu nai");
                                            if(isUserExist)
                                            {
                                                if (isUserExist) {
                                                username = loggedInCustomer.username;
                                                fullName = loggedInCustomer.fullName;
                                                diaChiKhach = loggedInCustomer.diaChiKhach;
                                                
                                                System.out.print("Nhap ID khieu nai: ");
                                                String khieuNaiID = sc.nextLine();

                                                System.out.print("Nhap ma tour:");
                                                String tourID = sc.nextLine().trim();

                                                System.out.print("Noi dung khieu nai:");
                                                String content = sc.nextLine().trim();

                                                KhieuNai complaint = new KhieuNai(khieuNaiID,fullName, diaChiKhach, tourID, content);

                                                try {
                                                    // Mở file để ghi dữ liệu
                                                    BufferedWriter writer = new BufferedWriter(new FileWriter("src/nhom6/KhieuNai.txt", true));

                                                    // Ghi thông tin khiếu nại vào file
                                                    writer.write(khieuNaiID + "," + username + "," + fullName + "," + diaChiKhach + "," + tourID + "," + content + "\n");

                                                    // Đóng file
                                                    writer.close();

                                                    System.out.println("Gui khieu nai thanh cong!");
                                                } catch (IOException e) {
                                                    System.out.println("Loi khi gui khieu nai");
                                                    e.printStackTrace();
                                                    }
                                            } else {
                                                System.out.println("Ban can dang nhap de su dung chuc nang nay");
                                                }
                                            }                                     
                                            break;
                                        case 7:
                                            System.out.println("Lich su dat tour");
                                            if(isUserExist)
                                            {
                                                String user = loggedInCustomer.username;
                                            
                                                lichSuDatTour(user);
                                            } else {
                                                System.out.println("Ban can dang nhap de su dung chuc nang nay");
                                            }
                                            break;
                                        case 8:
                                            System.out.println("Khach san da dat");
                                            if(isUserExist)
                                            {
                                                String user = loggedInCustomer.username;
                                                
                                                printBookedHotels(user);
                                            } else {
                                                System.out.println("Ban can dang nhap truoc khi su dung tinh nang nay");
                                            }
                                            break;
                                        case 9:
                                            if (isUserExist) {
                                                System.out.println("Huy Tour");
                                                String user = loggedInCustomer.username;

                                                // Hiển thị danh sách tour đã đặt của người dùng
                                                System.out.println("Danh sach tour da dat cua ban:");
                                                lichSuDatTour(user);

                                                // Yêu cầu người dùng nhập ID tour muốn hủy
                                                System.out.print("Nhap ID tour muon huy: ");
                                                String tourID = sc.nextLine();

                                                // Xóa tour khỏi danh sách tour đã đặt
                                                boolean isTourCanceled = cancelTour(user, tourID);

                                                if (isTourCanceled) {
                                                    System.out.println("Huy tour thanh cong.");
                                                } else {
                                                    System.out.println("Khong tim thay tour hoac khong the huy tour.");
                                                }
                                            } else {
                                                System.out.println("Ban can dang nhap truoc khi huy tour.");
                                            }
                                            break;
                                        case 10:
                                             if (isUserExist) {
                                                String user = loggedInCustomer.username;

                                                // Hiển thị các tour đã đặt của người dùng
                                                cancelHotel(user, null);

                                                // Hỏi người dùng nhập ID của tour muốn hủy
                                                System.out.print("Nhap ID khach san muon huy: ");
                                                String hotelID = sc.nextLine().trim();

                                                // Hủy tour
                                                boolean isCanceled = cancelHotel(user, hotelID);
        
                                                if (isCanceled) {
                                                    System.out.println("Khach san da duoc huy thanh cong.");
                                                } else {
                                                    System.out.println("Khong tim thay khach san voi ID da duoc nhap.");
                                                }
                                                } else {
                                                    System.out.println("Ban can dang nhap truoc khi su dung chuc nang nay");
                                                }
                                             break;
                                        case 11:
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
