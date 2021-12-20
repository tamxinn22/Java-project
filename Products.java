package Tam;
import java.util.Scanner;
public class Products {
    public String idPro;
    public String type;
    public String proName;
    public int amount;
    public Float cost;
 
    public Products() {
    }
    public Products(String idPro,String proName,int amount,Float cost){
        this.idPro =idPro;
        this.proName=proName;
        this.amount = amount;
        this.cost=cost;
    }
    public Products(String idPro, String type, String proName, int amount, Float cost) {
        this.idPro = idPro;
        this.type = type;
        this.proName = proName;
        this.amount = amount;
        this.cost =cost;
    }
    public int getamount() {
        return amount;
    }
    
    public void setamount(int amount) {
        this.amount = amount;
    }
    public String getIdPro(String string) {
        return idPro;
    }
 
    public void setIdPro(String idPro) {
        this.idPro = idPro;
    }
 
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
 
    public String getProName() {
        return proName;
    }
 
    public void setProName(String proName) {
        this.proName = proName;
    }
 
    public float getCost() {
        return cost;
    }
 
    public void setCost(Float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" + "MaSP=" + idPro + ", Loai=" + type + ", TenSP=" + proName + ", Solg=" + amount + ", Giaban=" + cost + '}';
    }
    public void inputInfoProdusct() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Nhâp mã sản phẩm: ");
        idPro = scan.nextLine();
        System.out.println("Nhập loại sản phẩm: ");
        type = scan.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        proName = scan.nextLine();
        System.out.println("Nhập số lượng sản phẩm: ");
        amount = Integer.parseInt(scan.nextLine());
        System.out.println("Nhập giá bán sản phẩm: ");
        cost = Float.parseFloat(scan.nextLine());
    }
    public void displayPro() {
        System.out.println(this);
    }
}
 

