package Tam;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Menu {
    static int j=0;
    public static ArrayList<Products> productList = new ArrayList<Products>();
    public static ArrayList<Customer> customerList = new ArrayList<>();
    public static ArrayList<Employees> employeeList = new ArrayList<>();
    public static ArrayList<Order> orderList = new ArrayList<>();
    public static Date dateSystem = new Date();
    public static Scanner sc = new Scanner(System.in);
    public  void billManage() {
            String Choose;
    
            while (true) {
                System.out.println("======================================================");
                System.out.println("|----------------- Quản lý Hóa Đơn ------------------|");
                System.out.println("|====================================================|");
                System.out.println("| 1. Tạo Hóa Đơn                                     |");
                System.out.println("| 2. Hiển thị hóa đơn                                |");
                System.out.println("| 0. Trở về menu chính                               |");
                System.out.println("======================================================");
                System.out.print(" # Nhập lựa chọn cho chức năng tương ứng: ");
                while (true) {
                    Integer i = -1;
                    Choose = sc.nextLine();
                    switch (Choose) {
                        case "1":
                            i += 1;
                            inputorder();
                            break;
                        case "2":
                            i +=1;
                            showBill();
                            break;
                        case "0":
                            Main.mainMenu();
                        default:
                            System.out.print("Nhập sai tùy chọn! Mời nhập lại: ");
                            break;
                    }
                    if (i != -1) {
                        break;
                    }
                }
            }
    }
    public void inputorder(){
        System.out.println("Nhập mã đơn hàng: ");
        String id_od=sc.nextLine();
        String id_Cus;
        String name_Cus;
        while(true){
            System.out.println("Nhập mã khách hàng: ");
            id_Cus=sc.nextLine(); 
            int index=this.checkIDCus(id_Cus);
            if (index!=-1){
                name_Cus=customerList.get(index).getName();
                break;
            }else{
                System.out.println(" Mã khách hàng bạn vừa nhập không có trong danh sách khách hàng! Mời nhập lại : ");
            }
        }
        String id_Emp;
        String name_Emp;
        while(true){
            System.out.println("Nhập mã nhân viên: ");
            id_Emp =sc.nextLine();
            int index= this.checkIDEmp(id_Emp);
            if (index!=-1){
                name_Emp=employeeList.get(index).getName();
                break;
            }else{
                System.out.println("Mã nhân viên bạn vừa nhập không có trong danh sách nhân viên của Shop! Mời nhập lại : ");    
            }
        }
        System.out.println("Nhập ngày đặt hàng ");
        String date=sc.nextLine();
        System.out.println("Nhập số hàng muốn mua: ");
        Order order = new Order(id_od, id_Cus,name_Cus, id_Emp,name_Emp, date);
        int number=Integer.parseInt(sc.nextLine());
        for(int i=1;i<=number;i++){
            String idPro;
            String namePro;
            Float cost;
            while(true){
                System.out.println("Nhập mã sản phẩm thứ "+i+" : ");
                idPro=sc.nextLine();
                int index= this.checkIDProduct(idPro);
                if (index!=-1){
                    namePro=productList.get(index).getProName();
                    cost=productList.get(index).getCost();
                    break;
                }else{
                    System.out.println("Mã sản phẩm bạn vừa nhập không có trong danh sách sản phẩm! Mời nhập lại : ");    
                }
            }
            System.out.println("Nhập số lượng sản phẩm mua: ");
            int amount=sc.nextInt();
            sc.nextLine();
            Products products= new Products(idPro,namePro, amount,cost);
            order.getProductList().add(products); 
        }
         orderList.add(order);
    }
    public int checkIDCus(String id_Cus){
        for(Customer customer: customerList){
            if(customer.getID().equals(id_Cus)){
                return customerList.indexOf(customer);
            }  
        }
        return -1;
    }
    public int checkIDEmp(String id_Emp){
        for(Employees employees: employeeList){
            if(employees.getID().equals(id_Emp)){
                return employeeList.indexOf(employees);
            }  
        }
        return -1;
    }
    public int checkIDProduct(String idPro){
        for(Products products: productList){
            if(products.getIdPro(idPro).equals(idPro)){
                return productList.indexOf(products);
            }  
        }
        return -1;
    }
    public static void showBill(){
            Order order=new Order();
            order=orderList.get(j);
            System.out.print(
                            "=====================================================================");
            System.out.print(
                            "\n|                        Hóa Đơn Đặt Hàng                            |\n");
            System.out.println("=====================================================================");
            System.out.printf("| %-10s | %-15s | %-15s | %-15s |\n", "Mã hóa đơn", "Ngày tạo hóa đơn",
            "Nhân viên tạo", "Tên khách hàng");
            System.out.println("=====================================================================");   
            System.out.printf("| %-10s | %-15s | %-15s | %-15s|\n",
            order.getId_od(),
            order.getDate(),
            order.getName_Emp(),
            order.getName_Cus());
            System.out.println("\n ==========================================================");
            System.out.printf("| %-15s | %-15s | %-18s|\n", "Tên sản phẩm", "Số lượng","Tổng tiền");
            System.out.println("===========================================================");   
                for (Products products:order.getProductList()){
                    order.setAmoutMoney(products.getamount()*products.getCost());
                    System.out.printf("| %-15s | %-15d | %-18.2fVND |\n",
                        products.getProName(),
                        products.getamount(),
                        order.getAmoutMoney());
                order.setTotalMoneyOnbill(order.getTotalMoneyOnbill() + order.getAmoutMoney());
                }
            System.out.println("===========================================================");
            System.out.println("                                         Tổng cộng tiền thu");
            System.out.printf("| %-15s | %-15s | %-18.2fVND |\n", " "," ",order.getTotalMoneyOnbill());
            System.out.println("                                       © by Đinh Thị Mỷ Tâm");
            j+=1;
    } 
    public void productManage() {
        String Choose;
        while (true) {
            System.out.println("==================================");
            System.out.println("--- Quản lý danh sách mặt hàng ---");
            System.out.println("==================================");
            System.out.println("| 1.Xem danh sách các mặt hàng   |");
            System.out.println("| 2.Tạo danh sách mặt hàng       |");
            System.out.println("| 3.Thêm 1 mặt hàng vào danh sách|");
            System.out.println("| 4.Xóa 1 mặt hàng khỏi danh sách|");
            System.out.println("| 5.Tìm 1 mặt hàng trong danh sách|");
            System.out.println("| 6.Sắp xếp mặt hàng theo giá    |");
            System.out.println("| 0.Trở về menu chính            |");
            System.out.println("==================================");
            System.out.print("# Nhập lựa chọn cho chức năng tương ứng: ");
            while (true) {
                Integer check = -1;
                Choose = sc.nextLine().trim();
                switch (Choose) {
                    case "1":
                        check += 1;
                        showProducts();
                        break;
                    case "2":
                        check += 1;
                        createProducts();
                        break;
                    case "3":
                        check += 1;
                        addProduct();
                        break;
                    case "4":
                        check += 1;
                        removePro();;
                        break;
                    case "5":
                        check+=1;
                        findPro();
                        break;
                    case "6":
                        check+=1;
                        RangebyCost();
                        break;
                    case "0":
                        Main.mainMenu();
                        break;
                    default:
                        System.out.print("Không có chức năng " + Choose + " Mời nhập lại: ");
                        break;
                }
                if (check != -1) {
                    break;
                }
 
            }
        }
    }
    private static void createProducts() {
        System.out.println("Nhập số lượng sản phẩm muốn tạo: ");
        int num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++) {
            System.out.format("Nhập sản phẩm thứ %d\n", i + 1);
            Products products = new Products();
            products.inputInfoProdusct();
            productList.add(products);
        }
    }
    public void removePro(){
        while(true){
            System.out.println("Nhập mã sản phẩm muốn xóa : ");
            String idPro=sc.nextLine();
            //for(Products i:productList){
            int index= this.checkIDProduct(idPro);
            if (index!=-1){
                productList.remove(index);
                System.out.println("Danh sách sản phẩm sau khi cập nhật là: ");
                showProducts();
                break;
            }else{
                System.out.println("Mã sản phẩm bạn vừa nhập không có trong danh sách sản phẩm! Mời nhập lại : ");    
            }
        }
    }
        
  public void addProduct(){
      while(true) {
        Products products = new Products();
        System.out.println("Nhập mã sản phẩm muốn thêm: ");
         String idPro = sc.nextLine();
         int index= this.checkIDProduct(idPro);
                if (index!=-1){
                    System.out.println("Mã sản phẩm bạn vừa nhập đã có trong kho! Mời bạn nhập lại mã sản phẩm khác: ");    
                }else{
                    //Products products = new Products();
                    products.setIdPro(idPro);
                    System.out.println("Nhập tên sản phẩm: ");
                    products.setProName(sc.nextLine());
                    System.out.println("Nhập loại sản phẩm: ");
                    products.setType(sc.nextLine());
                    System.out.println("Nhập số lượng sản phẩm: ");
                    products.setamount(sc.nextInt());
                    System.out.println("Nhập giá sản phẩm: ");
                    products.setCost(sc.nextFloat());
                    sc.nextLine();
                    productList.add(products);
                    break;
                }
           }
       }
       public void findPro(){
        while(true){
            System.out.println("Nhập mã sản phẩm muốn tìm  : ");
            String idPro=sc.nextLine();
            int index= this.checkIDProduct(idPro);
            if (index!=-1){
                System.out.println("Danh sách sản phẩm sau khi cập nhật là: ");
                System.out.println("MaSP = " + productList.get(index).idPro + ", loại = " + productList.get(index).type + ", TenSP = " +  productList.get(index).proName + ", Solg = " +  productList.get(index).amount + ", Giaban = " +  productList.get(index).cost);
                break;
            }else{
                System.out.println("Mã sản phẩm bạn vừa nhập không có trong danh sách sản phẩm! Mời nhập lại : ");    
            }
        }
    }
        public void RangebyCost() {
            for (int i = 0; i < productList.size(); i++) {
                for (int j = 0; j < productList.size(); j++) {
                    if (productList.get(i).getCost() < productList.get(j).getCost()) {
                        Products temp = productList.get(j);
                        productList.set(j, productList.get(i));
                        productList.set(i, temp);
    
                    }
                }
            }
            showProducts();
        }
    
    private static void showProducts() {
        if (productList.isEmpty()) {
            System.out.println("Chưa có sản phẩm ");
        }
        for (Products products : productList) {
            products.displayPro();
        }
    }
    public void customerManage() {
        String Choose;
        while (true) {
            //CommonMethod.clrscr();
            System.out.println("======================================");
            System.out.println("|--- Quản lý danh sách khách hàng ---|");
            System.out.println("|====================================|");
            System.out.println("| 1. Xem danh sách các khách hàng    |");
            System.out.println("| 2. Thêm mới khách hàng             |");
            System.out.println("| 0. Trở về menu chinh               |");
            System.out.println("======================================");
            System.out.print("# Nhậplựa chọn cho chức năng tương ứng: ");
            while (true) {
                Integer i = -1;
                Choose = sc.nextLine();
                switch (Choose) {
                    case "1":
                        i += 1;
                        Customer.displayCus();
                        break;
                    case "2":
                        i += 1;
                        createCustomers();
                        break;
                    case "0":
                        Main.mainMenu();
                    default:
                        System.out.print("Nhập sai tùy chọn! Mời nhập lại: ");
                        break;
                }
                if (i != -1) {
                    break;
                }
            }
        }
    }
    private static void createCustomers() {
        System.out.println("Nhập số lượng khách muốn thêm: ");
        int num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++) {
            System.out.format("Nhập khách hàng thứ %d\n", i + 1);
            Customer customer = new Customer();
            customer.inputInfo();
            customerList.add(customer);
        }
    }
    public void employeeManage(){
        String Choose;
        while (true) {
            //CommonMethod.clrscr();
            System.out.println("======================================");
            System.out.println("| --- Quản lý danh sách nhân viên ---|");
            System.out.println("|====================================|");
            System.out.println("| 1. Xem danh sách các nhân viên     |");
            System.out.println("| 2. Thêm mới nhân viên              |");
            System.out.println("| 3. Sắp xếp nhân viên theo lương    |");
            System.out.println("| 0. Trở về menu chính               |");
            System.out.println("======================================");
            System.out.print("# Nhập lựa chọn cho chức năng tương ứng: ");
            while (true) {
                Integer i = -1;
                Choose = sc.nextLine();
                switch (Choose) {
                    case "1":
                        i += 1;
                        Employees.displayEmp();
                        break;
                    case "2":
                        i += 1;
                        createEmployees();
                        break;
                    case "3":
                        i +=1;
                        rangeBySalary();
                        break;
                    case "0":
                        Main.mainMenu();
                    default:
                        System.out.print("Nhập sai tùy chọn! Mời nhập lại: ");
                        break;
                }
                if (i != -1) {
                    break;
                }
            }
        }
    }
        private static void createEmployees() {
        System.out.println("Nhập số nhân viên muốn thêm: ");
        int num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++) {
            System.out.format("Nhập nhân viên thứ %d\n", i + 1);
            Employees employees = new Employees();
            employees.inputInfo();
            System.out.println("Nhập lương nhân viên: ");
            employees.setSalary(sc.nextFloat());
            sc.nextLine();
            employeeList.add(employees);
        }
    }
    public void rangeBySalary() {
        for (int i = 0; i < employeeList.size(); i++) {
            for (int j = 0; j < employeeList.size(); j++) {
                if (employeeList.get(i).getSalary() < employeeList.get(j).getSalary()) {
                    Employees temp = employeeList.get(j);
                    employeeList.set(j, employeeList.get(i));
                    employeeList.set(i, temp);

                }
            }
        }
        showProducts();
    }
}
 
    
 
 


