package Tam;
import java.util.ArrayList;
public class Order extends Products {
    public static  ArrayList<Products> productList=new ArrayList<Products>();
    private String id_od;
    private String id_Cus;
    private String name_Cus;
    private String id_Emp;
    private String name_Emp;
    private Float amountMoney;
    private String date;
    private Float totalMoneyOnbill=0.0f;
    public Float getTotalMoneyOnbill() {
        return totalMoneyOnbill;
    }
    public void setTotalMoneyOnbill(Float x) {
        totalMoneyOnbill = x;
    }
    public Float getAmoutMoney() {
        return amountMoney;
    }
    public void setAmoutMoney(Float amoutMoney) {
        this.amountMoney = amoutMoney;
    }
    public Order(String id_od,String id_Cus,String name_Cus,String id_Emp,String name_Emp,String date){
        this.id_od=id_od;
        this.id_Cus=id_Cus;
        this.id_Emp=id_Emp;
        this.date=date;
        this.name_Cus=name_Cus;
        this.name_Emp=name_Emp;
    }
    public Order() {
    }
    public ArrayList<Products> getProductList() {
        return productList;
    }
 
    public String getName_Cus() {
        return name_Cus;
    }
    public void setName_Cus(String name_Cus) {
        this.name_Cus = name_Cus;
    }
    public String getName_Emp() {
        return name_Emp;
    }
    public void setName_Emp(String name_Emp) {
        this.name_Emp = name_Emp;
    }
    public String getId_od() {
        return id_od;
    }
    public void setId_od(String id_od) {
        this.id_od = id_od;
    }
    public String getId_Cus() {
        return id_Cus;
    }
    public void setId_Cus(String id_Cus) {
        this.id_Cus = id_Cus;
    }
    public String getId_Emp() {
        return id_Emp;
    }
    public void setId_Emp(String id_Emp) {
        this.id_Emp = id_Emp;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    
}
 


