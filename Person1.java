package Tam;
import java.util.Scanner;
public abstract class Person1 {
    public String name;
    public String ID;
    public String phoneNumber;
    public String address;
 
    public Person1() {
    }
    public Person1(String name, String ID, String phoneNumber, String address) {
        this.name = name;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getID() {
        return ID;
    }
 
    public void setID(String ID) {
        this.ID = ID;
    }
 
    public String getPhoneNumber() {
        return phoneNumber;
    }
 
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", ID=" + ID + ", phoneNumber=" + phoneNumber + ", address=" + address + '}';
    }
    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id:");
        ID = (sc.nextLine());
        System.out.println("Nhập vào tên:");
        name = (sc.nextLine());
        System.out.println("Nhập Số điện thoại:");
        phoneNumber = (sc.nextLine());
        System.out.println("Nhập địa chỉ:");
        address = (sc.nextLine());
    }
}
