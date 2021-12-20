package Tam;
import java.util.Scanner;
public class Main {
    static Menu menu=new Menu();
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        String choose;
        while (true) {
            System.out.println("==================================");
            System.out.println("--Chào Mừng Đến Với Cửa Hàng Giày--");
            System.out.println("==================================");
            System.out.println("|             © by Đinh Thị Mỷ Tâm|");
            System.out.println("|                                 |");
            System.out.println("|************--MENU--*************|");
            System.out.println("| 1. Quản Lý Sản Phẩm             |");
            System.out.println("| 2. Quản Lý Khách Hàng           |");
            System.out.println("| 3. Quản Lý Nhân Viên            |");
            System.out.println("| 4. Quản Lý Hóa Đơn              |");
            System.out.println("| 0. Thoát                        |");
            System.out.println("==================================");
            System.out.print("# Mời nhập lựa chọn: ");
            choose = sc.nextLine().trim();
            switch (choose) {
                case "1":
                    menu.productManage();
                    break;
                case "2":
                    menu.customerManage();
                    break;
                case "3":
                    menu.employeeManage();
                    break;
                 case "4":
                     menu.billManage();
                     break;
                case "0":
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập sai lựa chọn!!! Mời nhập lại:");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        mainMenu();
    }
      
}
 

