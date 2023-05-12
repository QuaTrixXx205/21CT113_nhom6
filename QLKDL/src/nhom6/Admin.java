
package nhom6;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Admin {
    static Scanner sc = new Scanner(System.in);
    private String adminUsername;
    private String adminPassword;

    public Admin() {
    }
    
    
        
    
    public Admin(String adminUsername, String adminPassword) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
    
    
    
    // Phương thức để tạo tài khoản admin mới
    public Admin createAdminAccount(String username, String password) {
        return new Admin(username, password);
    }
    
    private static double calculateTourRevenue(String customerTourFile) {
    double totalRevenue = 0.0;

    try {
        FileReader fileReader = new FileReader(customerTourFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] tourData = line.split(",");

            double giaTour = Double.parseDouble(tourData[7].trim());
            int soLuongKhach = Integer.parseInt(tourData[6].trim());

            // Tính toán doanh thu từ đặt tour
            double tourRevenue = giaTour * soLuongKhach;
            totalRevenue += tourRevenue;
        }

        bufferedReader.close();
    } catch (IOException e) {
        System.out.println("Lỗi khi đọc file danh sách tour!");
        e.printStackTrace();
    }

    return totalRevenue;
}

private static double calculateHotelRevenue(String customerHotelFile) {
    double totalRevenue = 0.0;

    try {
        FileReader fileReader = new FileReader(customerHotelFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] hotelData = line.split(",");

            double giaPhong = Double.parseDouble(hotelData[5].trim());
            int soPhong = Integer.parseInt(hotelData[4].trim());

            // Tính toán doanh thu từ đặt khách sạn
            double hotelRevenue = giaPhong * soPhong;
            totalRevenue += hotelRevenue;
        }

        bufferedReader.close();
    } catch (IOException e) {
        System.out.println("Lỗi khi đọc file danh sách khách sạn!");
        e.printStackTrace();
    }

    return totalRevenue;
}




    
        public void adminInterface(boolean loggedIn) {
        List<Employee> employeeList = loadEmployeeListFromFile("src/nhom6/EmployeeList.txt");   
        boolean continueLoop = true;

        while (continueLoop) {         
            Admin admin = createAdminAccount("admin", "admin2k3");

            while (!loggedIn) {
                System.out.println("===============Admin======================");
                System.out.print("Ten dang nhap: ");
                String username = sc.nextLine().trim();
                System.out.print("Mat khau: ");
                String password = sc.nextLine().trim();

                if (username.equals(admin.getAdminUsername()) && password.equals(admin.getAdminPassword())) {
                    loggedIn = true;
                    System.out.println("Dang nhap thanh cong!");
                } else {
                    System.out.println("Sai ten dang nhap hoac mat khau, vui long nhap lai!");
                }
            }
            System.out.println("=====================================");
            System.out.println("1. Nhan Vien");
            System.out.println("2. Khach Hang");
            System.out.println("3. Doanh Thu");
            System.out.println("4. Tour");
            System.out.println("5. Hotel");
            System.out.println("6. Khieu Nai");
            System.out.println("7. Dang Xuat Va Quay Lai Trang Chu");
            System.out.print("Lua chon: ");
            int choice = sc.nextInt();
            employeeList = loadEmployeeListFromFile("src/nhom6/EmployeeList.txt");

            
            switch (choice) {
                case 1:
                    System.out.println("============= Nhan Vien ================");

                    boolean employeeMenu = true;
                    while(employeeMenu)
                    {   
                        System.out.println("1. In danh sach cac nhan vien");
                        System.out.println("2. Them nhan vien");
                        System.out.println("3. Xoa nhan vien");
                        System.out.println("4. Quay lai");
                        System.out.print("Lua chon: ");
                        int NVchoice = sc.nextInt();

                        switch(NVchoice)
                        {
                            case 1:
                                // Kiểm tra nếu danh sách nhân viên không rỗng
                                if (!employeeList.isEmpty()) {
                                    System.out.println("Danh sach nhan vien:");

                                    // In tiêu đề cột
                                    System.out.printf("%-10s %-20s %-15s %-30s %-15s %-30s %-15s\n",
                                    "Ma NV", "Ten NV", "Chuc vu NV", "Dia chi NV", "SDT NV", "Email NV", "Ngay thang nam sinh NV");

                                    // In thông tin từng nhân viên
                                    for (Employee employee : employeeList) {
                                    System.out.printf("%-10s %-20s %-15s %-30s %-15s %-30s %-15s\n",
                                   employee.getMaNV(), employee.getTenNV(), employee.getChucVuNV(),
                                   employee.getDiaChiNV(), employee.getSdtNV(), employee.getEmailNV(),
                                   employee.getNgayThangNamSinhNV());
                                    }
                                } else {
                                    System.out.println("Khong co nhan vien nao trong danh sach.");
                                }
                                break;
                            case 2:
                                sc.nextLine();
                                System.out.println("Them nhan vien moi");

                                System.out.print("Nhap ma NV: ");
                                String maNV = sc.nextLine();
                                System.out.print("Nhap ten NV: ");
                                String tenNV = sc.nextLine();
                                System.out.print("Nhap chuc vu NV: ");
                                String chucVuNV = sc.nextLine();
                                System.out.print("Nhap dia chi NV: ");
                                String diaChiNV = sc.nextLine();
                                System.out.print("Nhap so dien thoai NV: ");
                                String sdtNV = sc.nextLine();
                                System.out.print("Nhap email NV: ");
                                String emailNV = sc.nextLine();
                                System.out.print("Nhap ngay thang nam sinh NV: ");
                                String ngayThangNamSinhNV = sc.nextLine();

                                Employee newEmployee = new Employee(maNV, tenNV, chucVuNV, diaChiNV, sdtNV, emailNV, ngayThangNamSinhNV);

                                employeeList.add(newEmployee);
                                saveEmployeeListToFile(employeeList, "src/nhom6/EmployeeList.txt");
                                System.out.println("Da them nhan vien moi");
                                break;
                            case 3:
                                System.out.println("Xoa nhan vien (dua tren maNV)");
                                sc.nextLine();
                                System.out.print("Nhap maNV cua nhan vien can xoa: ");
                                String maNVCanXoa = sc.nextLine();

                                // Tìm và xóa nhân viên có mã nhân viên tương ứng
                                boolean found = false;
                                Iterator<Employee> iterator = employeeList.iterator();
                                while (iterator.hasNext()) {
                                    Employee employee = iterator.next();
                                    if (employee.getMaNV().equals(maNVCanXoa)) {
                                        iterator.remove();
                                        found = true;
                                        break;
                                    }
                                }

                                if (found) {
                                    saveEmployeeListToFile(employeeList, "src/nhom6/EmployeeList.txt");
                                    System.out.println("Da xoa nhan vien co maNV: " + maNVCanXoa);
                                } else {
                                    System.out.println("Khong tim thay nhan vien co maNV: " + maNVCanXoa);
                                }
                           break;
                        case 4:
                            employeeMenu = false;
                            adminInterface(true);
                            break;
                        default:
                            System.out.println("Lua chon khong hop le, vui long nhap lai");
                    }
                    
                }
                
                break;
            case 2:
                System.out.println("============== Khach Hang =================");
                
                boolean customerMenu = true;
                while(customerMenu)
                {
                    System.out.println("1. In danh sach cac khach hang");
                    System.out.println("2. Xoa khach hang");
                    System.out.println("3. Quay lai");
                    System.out.print("Lua chon: ");
                    int KHchoice = sc.nextInt();
                    
                    switch(KHchoice)
                    {
                        case 1:
                            String filePath = "src/nhom6/CustomerInfo.txt";
                            
                            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                                System.out.println("Username\tPassword\tFull Name\t\tPhone\t\tEmail\t\t\tAddress\t\tDate of Birth\tGender\t\tCCCD");
                                String line;
                                while ((line = br.readLine()) != null) {
                                    String[] customerInfo = line.split(",");
                                    String formattedInfo = String.format("%-15s\t%-15s\t%-20s\t%-15s\t%-20s\t%-15s\t%-15s\t%-10s\t%s",
                                    customerInfo[0], customerInfo[1], customerInfo[2], customerInfo[3], customerInfo[4],
                                    customerInfo[5], customerInfo[6], customerInfo[7], customerInfo[8]);
                                    System.out.println(formattedInfo);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                }
                            break;
                        case 2:
                            sc.nextLine();
                            String filePath2 = "src/nhom6/CustomerInfo.txt";
                            String usernameToDelete;
                            System.out.print("Nhap username cua khach hang can xoa: ");
                            usernameToDelete = sc.nextLine();
                            List<String> customerList = new ArrayList<>();
                            
                            try (BufferedReader br = new BufferedReader(new FileReader(filePath2))) {
                                String line;
                            while ((line = br.readLine()) != null) {
                                customerList.add(line);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            
                            boolean isDeleted = false;
                            Iterator<String> iterator = customerList.iterator();
                            while (iterator.hasNext()) {
                                String customerInfo = iterator.next();
                                String[] customerData = customerInfo.split(",");

                                if (customerData[0].equals(usernameToDelete)) {
                                    iterator.remove();
                                    isDeleted = true;
                                    break;
                                }
                            }
                            
                            if (isDeleted) {
                            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath2))) {
                                for (String customerInfo : customerList) {
                                    bw.write(customerInfo);
                                    bw.newLine();
                                }
                                System.out.println("Khach hang da duoc xoa thanh cong.");
                            } catch (IOException e) {
                                e.printStackTrace();
                                }
                            } else {
                            System.out.println("Khong tim thay khach hang nao co username: " + usernameToDelete);
                            }
                            
                            break;
                        case 3:
                            employeeMenu = false;
                            adminInterface(true);
                            break;
                        default:
                            System.out.println("Lua chon khong hop le, vui long nhap lai");
                    }
                }
                        
                break;
            case 3:
                System.out.println("=============== Doanh Thu =====================");
                    double tourRevenue = calculateTourRevenue("src/nhom6/customerTour.txt");
                    double hotelRevenue = calculateHotelRevenue("src/nhom6/customerHotel.txt");
        
                    double totalRevenue = tourRevenue + hotelRevenue;
        
                    System.out.println("Doanh thu tu dat tour: " + tourRevenue);
                    System.out.println("Doanh thu tu dat khach san: " + hotelRevenue);
                    System.out.println("Tong doanh thu: " + totalRevenue);
                break;
            case 4:
                System.out.println("=================== Tour Du Lich ====================");
                
                boolean tourMenu = true;
                while(tourMenu)
                {
                    System.out.println("1, In thong tin cac tour du lich");
                    System.out.println("2. Them tour moi");
                    System.out.println("3. Xoa mot tour dua tren tourID");
                    System.out.println("4. Quay lai");
                    System.out.print("Lua chon: ");
                    int tourChoice = sc.nextInt();
                    
                    switch(tourChoice)
                    {
                        case 1:
                            String filePath = "src/nhom6/tourList.txt";
                            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.printf("%-10s | %-30s | %-15s | %-15s | %-25s | %-15s | %-15s | %-15s | %-20s\n",
                        "Tour ID", "Ten Tour", "Ngay Khoi Hanh", "Ngay Ket Thuc", "Dia Diem", "So Luong Toi Da", "Gia Tour",
                        "So Tien Dat Coc", "Phuong Thuc Thanh Toan");
                            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                            String line;
                            while ((line = br.readLine()) != null) {
                            String[] tourInfo = line.split(",");
                            String tourID = tourInfo[0].trim();
                            String tenTour = tourInfo[1].trim();
                            String ngayKhoiHanh = tourInfo[2].trim();
                            String ngayKetThuc = tourInfo[3].trim();
                            String diaDiem = tourInfo[4].trim();
                            String soLuongKhachToiDa = tourInfo[5].trim();
                            String giaTour = tourInfo[6].trim();
                            String soTienDatCoc = tourInfo[7].trim();
                            String phuongThucThanhToan = tourInfo[8].trim();

                            System.out.printf("%-10s | %-30s | %-15s | %-15s | %-25s | %-15s | %-15s | %-15s | %-20s\n",
                        tourID, tenTour, ngayKhoiHanh, ngayKetThuc, diaDiem, soLuongKhachToiDa, giaTour, soTienDatCoc, phuongThucThanhToan);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            }
   
                            break;
                        case 2:
                            sc.nextLine();
                            String filePath2 = "src/nhom6/tourList.txt";
                             try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath2, true))) {


                                System.out.println("Them mot tour moi");
                                System.out.print("Nhap Tour ID: ");
                                String tourID = sc.nextLine();

                                System.out.print("Nhap Ten Tour: ");
                                String tenTour = sc.nextLine();

                                System.out.print("Nhap Ngay Khoi Hanh: ");
                                String ngayKhoiHanh = sc.nextLine();

                                System.out.print("Nhap Ngay Ket Thuc: ");
                                String ngayKetThuc = sc.nextLine();

                                System.out.print("Nhap Dia Diem: ");
                                String diaDiem = sc.nextLine();

                                System.out.print("Nhap So Luong Khach Toi Da: ");
                                int soLuongKhachToiDa = sc.nextInt();

                                System.out.print("Nhap Gia Tour: ");
                                double giaTour = sc.nextDouble();

                                System.out.print("Nhap So Tien Dat Coc: ");
                                double soTienDatCoc = sc.nextDouble();

                                sc.nextLine(); // Đọc bỏ dòng mới sau khi đọc số

                                System.out.print("Nhap Phuong Thuc Thanh Toan: ");
                                String phuongThucThanhToan = sc.nextLine();

                                // Ghi thông tin tour mới vào file
                                String newTour = String.format("%s, %s, %s, %s, %s, %d, %.2f, %.2f, %s",
                                tourID, tenTour, ngayKhoiHanh, ngayKetThuc, diaDiem, soLuongKhachToiDa, giaTour, soTienDatCoc, phuongThucThanhToan);

                                bw.newLine();
                                bw.write(newTour);

                                System.out.println("Tour moi da duoc them thanh cong!");

                            } catch (IOException e) {
                                e.printStackTrace();
                                }
                            break;
                        case 3:
                            sc.nextLine();
                            System.out.println("Xoa mot tour dua tren ID");
                            String filePath3 = "src/nhom6/tourList.txt";
                            String tourIDToDelete;
                            System.out.print("Nhap tourID caa tour can xoa: ");
                            tourIDToDelete = sc.nextLine();
                            List<String> tourList = new ArrayList<>();
                            
                            try (BufferedReader br = new BufferedReader(new FileReader(filePath3))) {
                            String line;
                                while ((line = br.readLine()) != null) {
                                    tourList.add(line);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        boolean isDeleted = false;
                        Iterator<String> iterator = tourList.iterator();
                        while (iterator.hasNext()) {
                            String tourInfo = iterator.next();
                            String[] tourData = tourInfo.split(",");

                            if (tourData[0].equals(tourIDToDelete)) {
                                iterator.remove();
                                isDeleted = true;
                                break;
                            }
                        }

                        if (isDeleted) {
                            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath3))) {
                                for (String tourInfo : tourList) {
                                    bw.write(tourInfo);
                                    bw.newLine();
                                }
                            System.out.println("Tour da duoc xoa thanh cong");
                            } catch (IOException e) {
                                e.printStackTrace();
                                }
                        } else {
                            System.out.println("Khong tim thay tour nao co tourID: " + tourIDToDelete);
                        }
                            break;
                        case 4:
                            tourMenu = false;
                            adminInterface(true);
                            
                        default:
                            System.out.println("Lua chon khong hop le, vui long nhap lai");
                    }
                }
                break;
            case 5:
                System.out.println("=============== Khach San =====================");
                boolean hotelMenu = true;
                
                while(hotelMenu)
                {
                    System.out.println("1. In danh sach cac khach san trong tour du lich");
                    System.out.println("2. Them thong tin khach san moi");
                    System.out.println("3, Xoa thong tin mot khach san dua tren ma khach san");
                    System.out.println("4. Quay lai");
                    System.out.print("Lua chon: ");
                    int hotelChoice = sc.nextInt();
                    
                    switch(hotelChoice)
                    {
                        case 1:
                            String filePath = "src/nhom6/hotelList.txt";
                            
                            try {
                                // Mở file để đọc dữ liệu
                                File file = new File(filePath);
                                FileReader fileReader = new FileReader(file);
                                BufferedReader bufferedReader = new BufferedReader(fileReader);
        
                                // In tiêu đề
                                System.out.printf("%-10s%-20s%-30s%-10s%-15s%-15s%-30s%-30s%n",
                            "Ma KS", "Ten khach san", "Dia chi khach san", "So sao", "So luong phong", "Gia phong", "Tien nghi khach san", "Thong tin lien he");
        
                                // In dữ liệu khách sạn
                                String line;
                                while ((line = bufferedReader.readLine()) != null) {
                                    // Tách các thuộc tính của khách sạn từ dòng đọc được
                                    String[] attributes = line.split(",");
            
                                    // In thông tin khách sạn
                                    System.out.printf("%-10s%-20s%-30s%-10s%-15s%-15s%-30s%-30s%n",
                                        attributes[0], attributes[1], attributes[2], attributes[3], attributes[4],
                                        attributes[5], attributes[6], attributes[7]);
                                }
        
                                // Đóng file sau khi hoàn thành việc đọc dữ liệu
                                    bufferedReader.close();
                                } catch (IOException e) {
                                    System.out.println("Loi khi doc file!");
                                    e.printStackTrace();
                                }
                            break;
                        case 2:
                            sc.nextLine();
                            String filePath2 = "src/nhom6/hotelList.txt";
                            try {
                                // Mở file để ghi dữ liệu
                                FileWriter fileWriter = new FileWriter(filePath2, true);
                                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                                System.out.println("Them thong tin khach san moi");
                                
                                System.out.print("Ma KS: ");
                                String maKS = sc.nextLine();
                                System.out.print("Ten khach san: ");
                                String tenKhachSan = sc.nextLine();
                                System.out.print("Dia chi khach san: ");
                                String diaChiKhachSan  = sc.nextLine();
                                System.out.print("So sao: ");
                                int soSao  = sc.nextInt();
                                System.out.print("So luong phong: ");
                                int soLuongPhong  = sc.nextInt();
                                System.out.print("Gia phong: ");
                                double giaPhong  = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("Tien nghi khach san: ");
                                String tienNghiKhachSan  = sc.nextLine();
                                System.out.print("Thong tin lien he: ");
                                String thongTinLienHe  = sc.nextLine();
                                
                                // Ghi thông tin khách sạn mới vào file
                                printWriter.println(maKS + "," + tenKhachSan + "," + diaChiKhachSan + "," + soSao + ","
                                + soLuongPhong + "," + giaPhong + "," + tienNghiKhachSan + "," + thongTinLienHe);
                                
                                printWriter.close();
                                System.out.println("Them thong tin khach san moi thanh cong");
                                
                            } catch (IOException e) {
                                System.out.println("Loi khi ghi file");
                                e.printStackTrace();         
                            }
                            break;
                        case 3:
                            sc.nextLine();
                            String filePath3 = "src/nhom6/hotelList.txt";
                            String maKSToDelete;
                            System.out.print("Nhap ma khach san can xoa: ");
                            maKSToDelete = sc.nextLine();
                            List<String> hotelList = new ArrayList<>();

                            try (BufferedReader br = new BufferedReader(new FileReader(filePath3))) {
                                String line;
                                while ((line = br.readLine()) != null) {
                                    hotelList.add(line);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            
                            boolean isDeleted = false;
                            Iterator<String> iterator = hotelList.iterator();
                            while (iterator.hasNext()) {
                                String hotelInfo = iterator.next();
                                String[] hotelData = hotelInfo.split(",");

                                if (hotelData[0].equals(maKSToDelete)) {
                                iterator.remove();
                                isDeleted = true;
                                break;
                                }
                            }

                            if (isDeleted) {
                                try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath3))) {
                                    for (String hotelInfo : hotelList) {
                                    bw.write(hotelInfo);
                                    bw.newLine();
                                }
                                    System.out.println("Xoa thong tin khach san thanh cong");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    }
                            } else {
                                System.out.println("Khong tim thay khach san voi ma " + maKSToDelete);
                            }
                            break;
                        case 4:
                            hotelMenu = false;
                            adminInterface(true);
                            break;
                        default:
                            System.out.println("Lua chon khong hop le, vui long chon lai");
                    }
                }
                        
                break;
            case 6:
                System.out.println("============= Khieu Nai ======================");
                boolean khieuNaiMenu = true;
                
                while(khieuNaiMenu)
                {
                    System.out.println("1. In cac khieu nai tu khach hang");
                    System.out.println("2. Xoa khieu nai khach hang (khieuNaiID)");
                    System.out.println("3. Quay lai");
                    System.out.print("Lua chon: ");
                    int knChoice = sc.nextInt();
                    
                    switch(knChoice)
                    {
                        case 1:
                            String filePath = "src/nhom6/KhieuNai.txt";
                            
                            try {
                                // Mở file để đọc dữ liệu
                                File file = new File(filePath);
                                FileReader fileReader = new FileReader(file);
                                BufferedReader bufferedReader = new BufferedReader(fileReader);
        
                                System.out.println("Danh sach khieu nai:");
                                System.out.println("------------------------------------------");
                                System.out.printf("%-20s %-20s %-20s %-20s %-20s%n",
                                "KhieuNaiID", "Ho Ten Khach", "Dia Chi Khach", "Tour ID", "Ly Do Khieu Nai");
                                System.out.println("------------------------------------------");
                                
                                String line;
                                while ((line = bufferedReader.readLine()) != null) {
                                    String[] complaintData = line.split(",");

                                    String khieuNaiID = complaintData[0];
                                    String hoTenKhach = complaintData[2];
                                    String diaChiKhach = complaintData[3];
                                    String tourID = complaintData[4];
                                    String lyDoKN = complaintData[5];

                                    KhieuNai complaint = new KhieuNai(khieuNaiID, hoTenKhach, diaChiKhach, tourID, lyDoKN);

                                    System.out.printf("%-20s %-20s %-20s %-20s %-20s%n",
                                complaint.getKhieuNaiID(), complaint.getHoTenKhach(), complaint.getDiaChiKhach(),
                                complaint.getTourID(), complaint.getLyDoKN());
                                    }
        
                                // Đóng file sau khi hoàn thành việc đọc dữ liệu
                                    bufferedReader.close();
                                } catch (IOException e) {
                                    System.out.println("Loi khi doc file!");
                                    e.printStackTrace();
                                }
                            break;
                        case 2:
                            sc.nextLine();
                            System.out.println("Xoa khieu nai");
                            try {
                                // Mở file để đọc dữ liệu
                                File inputFile = new File("src/nhom6/KhieuNai.txt");
                                File tempFile = new File("src/nhom6/tempKhieuNai.txt");
                                FileReader fileReader = new FileReader(inputFile);
                                BufferedReader bufferedReader = new BufferedReader(fileReader);
                                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                                // Yêu cầu Admin nhập ID của khiếu nại cần xóa
                                System.out.print("Nhap ID khieu nai can xoa: ");
                                String id = sc.nextLine();

                                String line;
                                boolean found = false;
                                while ((line = bufferedReader.readLine()) != null) {
                                    String[] complaintData = line.split(",");

                                    // Kiểm tra nếu ID của khiếu nại trùng khớp, thì bỏ qua dòng này
                                    if (complaintData[0].equals(id)) {
                                        found = true;
                                        continue;
                                    }

                                // Ghi lại các dòng khiếu nại không cần xóa vào file tạm
                                writer.write(line + "\n");
                                }

                                // Đóng file sau khi hoàn thành việc đọc và ghi dữ liệu
                                bufferedReader.close();
                                writer.close();

                                if (found) {
                                    // Xóa file gốc
                                    inputFile.delete();

                                    // Đổi tên file tạm thành tên file gốc
                                    tempFile.renameTo(inputFile);

                                    System.out.println("Xoa khieu nai thanh cong!");
                                } else {
                                    System.out.println("Khong tim thay khieu nai co ID: " + id);
                                    }
                                } catch (IOException e) {
                                    System.out.println("Loi khi doc hoac ghi ghi file!");
                                    e.printStackTrace();
                                }
                                break;
                        case 3:
                            khieuNaiMenu = false;
                            adminInterface(true);
                            break;
                        default:
                            System.out.println("Lua chon khong hop le, vui long chon lai");
                    }
                }
                
                break;
            case 7:
                sc.nextLine();
                Main.main(null);
                break;
            default:
                System.out.println("Lua chon khong hop le, vui long nhap lai!");
        }
        sc.nextLine(); 
    }
}
        
        
        public void saveEmployeeListToFile(List<Employee> employeeList, String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (Employee employee : employeeList) {
                writer.println(employee.toString());
            }
//            System.out.println("Da luu danh sach nhan vien vao file: " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Loi: Khong tim thay file " + filePath);
        }
    }
        
       
        
        public List<Employee> loadEmployeeListFromFile(String filePath) {
        List<Employee> employeeList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            if (parts.length == 7) {
                String maNV = parts[0].trim();
                String tenNV = parts[1].trim();
                String chucVuNV = parts[2].trim();
                String diaChiNV = parts[3].trim();
                String sdtNV = parts[4].trim();
                String emailNV = parts[5].trim();
                String ngayThangNamSinhNV = parts[6].trim();

                Employee employee = new Employee(maNV, tenNV, chucVuNV, diaChiNV, sdtNV, emailNV, ngayThangNamSinhNV);
                employeeList.add(employee);
            }
        }
//        System.out.println("Da tai danh sach nhan vien tu file: " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Loi: Khong tim thay file " + filePath);
        }

    return employeeList;
}
        
        public List<Customer> loadCustomerListFromFile(String filePath) {
        List<Customer> customerList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 9) {
                String username = parts[0].trim();
                String userPassword = parts[1].trim();
                String fullName = parts[2].trim();
                String sdt = parts[3].trim();
                String email = parts[4].trim();
                String diaChiKhach = parts[5].trim();
                String ngaySinh = parts[6].trim();
                String gioiTinh = parts[7].trim();
                String CCCD = parts[8].trim();

                Customer customer = new Customer(username, userPassword, fullName, sdt, email, diaChiKhach, ngaySinh, gioiTinh, CCCD);
                customerList.add(customer);
            }
        }
//        System.out.println("Da tai danh sach nhan vien tu file: " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Loi: Khong tim thay file " + filePath);
        }

    return customerList;
}



}
