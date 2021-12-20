package Tam;

public class Customer extends Person1{
    public Customer() {
    }
    public Customer(String name, String ID, String phoneNumber, String address) {
        super(name, ID, phoneNumber, address);
    }
    public static void displayCus() {
        System.out.print(
                            "=====================================================================");
        System.out.print(
                                "\n|                    Danh Sach Khach Hang                           |\n");

        System.out.println("=====================================================================");
        System.out.printf("| %-10s | %-15s | %-15s | %-15s |\n", "Ma Khach hang", "Ten khach hang",
            "So dien thoai","Dia chi");
        if ( Menu.customerList .isEmpty())
        System.out.println("Danh sách trống! Chưa có khách hàng");
        else{
        for(Customer x: Menu.customerList){
            System.out.printf("| %-12s |  %-16s| %-16s| %-15s|\n", x.getID(), x.getName(),
                                        x.getPhoneNumber(),x.getAddress());}
        System.out.println("======================================================================");
        }
           
    }
    
}
 

