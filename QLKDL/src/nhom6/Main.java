package nhom6;

import java.util.Scanner;
import nhom6.Admin;
import nhom6.Customer;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.println("======= Chuong Trinh Quan Ly Khu Du Lich ===========");
        System.out.println("Chon vai tro cua ban");
        System.out.println("1. Admin" );
        System.out.println("2. Customer");
        System.out.println("3. Thoat Chuong Trinh");
        System.out.print("Ban chon: ");
        int choice = sc.nextInt();

        while (choice != 1 && choice != 2 && choice !=3) {
            System.out.print("Lua chon khong hop le, vui long chon lai: ");
            choice = sc.nextInt();
        }

        switch (choice) {
            case 1:
                // chon vai tro Admin
                Admin admin = new Admin();
                admin.adminInterface(false);
                sc.nextLine();
                break;
            case 2:
                // chon vai tro Customer
                Customer customer = new Customer();
                customer.customerInterface();
                break;
            case 3:
                System.out.println("Cam on vi da su dung chuong trinh cua chung toi");
                System.exit(0);
            default:
                break;
        }

        sc.close();
    }
}
