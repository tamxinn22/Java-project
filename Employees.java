package Tam;
 
public class Employees extends Person1 {
    public float salary;
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary =salary;
    }
    public Employees(){};
    public Employees(String name, String ID, String phoneNumber, String address,float salary) {
        super(name,ID,phoneNumber,address);
        this.salary = salary;
    }
    
     public static void displayEmp() {
        System.out.print(
            "======================================================================================");
        System.out.print(
            "\n|                             Danh Sách Nhân Viên                                    |\n");

        System.out.println("======================================================================================");
        System.out.printf("| %-10s | %-15s  | %-15s | %-15s | %-13s |\n", "Mã nhân viên", "Tên nhân viên",
        "Số điện thoại","Địa chỉ","Lương");
        if ( Menu.employeeList .isEmpty())
        System.out.println("Danh sách trống! Chưa có nhân viên nào trong danh sách ");
        else{
        for(Employees x: Menu.employeeList){
        System.out.printf("| %-12s | %-16s | %-16s| %-15s| %-13.2fVND|\n", x.getID(), x.getName(),
                        x.getPhoneNumber(),x.getAddress(),x.getSalary());}
        System.out.println("======================================================================================");}
     }
}
 

