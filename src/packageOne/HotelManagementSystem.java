package packageOne;
import java.util.*;
public class HotelManagementSystem {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        SystemWeaker employee=new SystemWeaker();
        SystemManage sm=new SystemManage();
        boolean check=false; //to break while loop
        int takeChoice;
        boolean checkContinue=true;  //check to continue in four choices or not
        while(check==false) {
           System.out.println("enter your password and then your userName ");
           String pass=in.nextLine();
           String userName=in.nextLine();
           if(employee.worGetFilePassword().equals(pass)&&employee.worGetFileUserName().equals(userName)) {
               System.out.print("hello mester ");
               employee.worDisplayFileName();
               check=true;
           }  
           else {
               System.out.println("your password or userName is wronge please try again ");
           }
          }
        while(checkContinue==true) {
           System.out.println("to register enter 1:");
           System.out.println("to display List enter 2:");
           System.out.println("to Quary  enter 3:");
           System.out.println("to unregister enter 4:");
           System.out.println("to end system enter 5 :");
           takeChoice=in.nextInt();
           in.nextLine();
           switch(takeChoice) {
               case 1 :       sm.registeration();                         break;
                   
               case 2 :       System.out.print("please enter floor number and then room number : "); 
                              int floorNum=in.nextInt();
                              int roomNum=in.nextInt();
                              sm.displayList(floorNum,roomNum);           break;
                   
               case 3 :       System.out.println("to quary about customer name enter name first midle last like AliAhmedKassem :");
                                  String customerName=in.nextLine();
                                  int returnValue=sm.quaryAboutCustomer(customerName);
                                  if(returnValue>0)
                                      System.out.println("customer exist in floor number  "+returnValue%10+" and room number  "+returnValue/10);
                                  else
                                      System.out.println("customer not exist");
                                                                          break;
               
               case 4 :        System.out.print("enter floor number and then room number : ");
                               sm.unRegister(in.nextInt(),in.nextInt());  break;
               case 5 :        checkContinue=false;                       break;
           }
        }
    
       }
}