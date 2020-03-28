package packageOne;
import java.util.Scanner;
import java.util.ArrayList;
public class Customer {
    Scanner in=new Scanner(System.in);
    private String cusName;//
    private String cusCountry; 
    private String cusEmail; //
    private String cusEmailFormat;
    private String cusPhone;//
    private int cusRoomNum;
    private int cusNumOfNieght;//
    public Customer() {
        cusName="";
        cusCountry=null;
        cusEmail="FCI1571999@gmail.com";
        cusEmailFormat="@gmail.com";
        cusPhone="01154634683";
        cusNumOfNieght=1;
    }
    public void cusSetName(String cusName) {
        this.cusName=cusName;
    }
    public void cusSetCountry(String cusCountry) {
        this.cusCountry=cusCountry;
    }
    public void cusSetPhone(String cusPhone) {
        this.cusPhone=cusPhone;
    }
    public void cusSetEmail(String cusEmail) {
        String formating[]=cusEmail.split("@");
        while(cusEmail.contains(cusEmailFormat)==false||(formating[formating.length-1].equals(cusEmailFormat.substring(1)))==false) {
             System.out.println("please enter Email format like "+cusEmailFormat);
             cusEmail=in.nextLine();
        } 
        this.cusEmail=cusEmail;
    }
    public void cusSetNumOfNieght(int cusNumOfNight) {
        this.cusNumOfNieght=cusNumOfNieght;
    }
    public void cusSetRoomNum(int cusRoomNum) {
        this.cusRoomNum=cusRoomNum;
    }
    public int cusGetRoomNum() {
        return cusRoomNum;
    }
    public String cusGetName() {
        return cusName;
    }
    public String cusGetCountry() {
        return cusCountry;
    }
    public int cusGetNumOfNight() {
        return cusNumOfNieght;
    }
    public String cusGetPhone() {
        return cusPhone;
    }
    public String cusGetEmail() {
        return cusEmail;
    }
    public String cusGetData() {
        return cusGetName()+" "+cusGetPhone()+" "+cusGetEmail()+" "+cusGetCountry()+" "+cusGetNumOfNight();
    }
    
}
