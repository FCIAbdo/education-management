package packageOne;
import java.util.Scanner;
import java.util.ArrayList;
public class SystemManage {
    private Scanner in = new Scanner(System.in);
    private Customer customer=new Customer();
    private ArrayList<Integer>roomNumList;
    private Floor floor1=new Floor(10);
    private Floor floor2=new Floor(10);
    private Floor floor3=new Floor(10);
    private Floor floor4=new Floor(10);
    public void askToEnterCusVals() {
        System.out.print("please enter customer name first,midle and last like AliAhmedAli : ");
             String cusName=in.nextLine();
              customer.cusSetName(cusName);
             System.out.print("please enter customer phone : ");
             customer.cusSetPhone(in.nextLine());
             System.out.print("please enter customer email : ");
             customer.cusSetEmail(in.nextLine());
             System.out.print("please enter customer num of neight : ");
             customer.cusSetNumOfNieght(in.nextInt());
             in.nextLine();
             System.out.print("please enter customer country : ");
             customer.cusSetCountry(in.nextLine());
    }
    public void registeration()
    {   
        int floorNumChoiced;
        System.out.println("the empty room in floor \"1\" and contain \"1\" bid ");
        roomNumList=floor1.getEmptyRoomOne();
        for(int roomNum : roomNumList)
            System.out.print(roomNum+"  ");
        System.out.println();
        System.out.println("the empty room in floor \"1\" and contain \"2\" bid ");
        roomNumList=floor1.getEmptyRoomTwo();
        for(int roomNum : roomNumList)
            System.out.print(roomNum+"  ");
        System.out.println();
   //*****************************************************************************************//   
        System.out.println("the empty room in floor \"2\" and contain \"1\" bid ");
        roomNumList=floor2.getEmptyRoomOne();
        for(int roomNum : roomNumList)
            System.out.print(roomNum+"  ");
        System.out.println();
        System.out.println("the empty room in floor \"2\" and contain \"2\" bid ");
        roomNumList=floor2.getEmptyRoomTwo();
        for(int roomNum : roomNumList)
            System.out.print(roomNum+"  ");
        System.out.println();
   //*****************************************************************************************//   
        System.out.println("the empty room in floor \"3\" and contain \"1\" bid ");
        roomNumList=floor3.getEmptyRoomOne();
        for(int roomNum : roomNumList)
            System.out.print(roomNum+"  ");
        System.out.println();
        System.out.println("the empty room in floor \"3\" and contain \"2\" bid ");
        roomNumList=floor3.getEmptyRoomTwo();
        for(int roomNum : roomNumList)
            System.out.print(roomNum+"  ");
        System.out.println();
   //*****************************************************************************************// 
        System.out.println("the empty room in floor \"4\" and contain \"1\" bid ");
        roomNumList=floor4.getEmptyRoomOne();
        for(int roomNum: roomNumList)
            System.out.print(roomNum+"  ");
        System.out.println();
        System.out.println("the empty room in floor \"4\" and contain \"2\" bid ");
        roomNumList=floor4.getEmptyRoomTwo();
        for(int roomNum : roomNumList)
            System.out.print(roomNum+"  ");
        System.out.println();
   //*****************************************************************************************// 
        System.out.print("please choice floor number and then choice room number : ");
        floorNumChoiced=in.nextInt();
        int roomNumChoiced=in.nextInt();
        customer.cusSetRoomNum(roomNumChoiced);
        in.nextLine();
             if(floorNumChoiced==1) {
                 if(floor1.getEmptyRoomInFloor().contains(roomNumChoiced)==true) {
                     askToEnterCusVals();
                     floor1.registration(customer);
                 }
                 else
                     System.out.println("room you enter is registered befor try another ");
             }
             else if(floorNumChoiced==2) {
                 if(floor2.getEmptyRoomInFloor().contains(roomNumChoiced)==true) {
                     askToEnterCusVals();
                     floor2.registration(customer);
                 }
                 else
                     System.out.println("room you enter is registered befor try another ");
             }
             else if(floorNumChoiced==3) {
                 if(floor3.getEmptyRoomInFloor().contains(roomNumChoiced)==true) {
                     askToEnterCusVals();
                     floor3.registration(customer);
                 }
                 else
                     System.out.println("room you enter is registered befor try another ");
             }
             else if(floorNumChoiced==4) {
                 if(floor4.getEmptyRoomInFloor().contains(roomNumChoiced)==true) {
                     askToEnterCusVals();
                     floor4.registration(customer);
                 }
                 else
                     System.out.println("room you enter is registered befor try another ");
             }
             else {
                 System.out.println("floor you choice is not found please enter correct number :");
             }
    }
    public void unRegister(int floorNum,int roomNum) {
        switch(floorNum) {
            case 1 :     floor1.unRegistration(roomNum);                  break;
            case 2 :     floor2.unRegistration(roomNum);                  break;
            case 3 :     floor3.unRegistration(roomNum);                  break;
            case 4 :     floor4.unRegistration(roomNum);                  break;
            default :    System.out.println("floor number wrong ");       break;
        }
    }
    public void displayList(int floorNum,int roomNumb) { 
        switch(floorNum) {
            case 1 :     floor1.showList(roomNumb);                       break;
            case 2 :     floor2.showList(roomNumb);                       break;
            case 3 :     floor3.showList(roomNumb);                       break;
            case 4 :     floor4.showList(roomNumb);                       break;
            default :    System.out.println("floorNum is wrong !");       break;
        }
    }
    //to search do customer is exist in hotel or not
    public int quaryAboutCustomer(String customerName) {
        int returnValue1=floor1.cheeckCustomerExist(customerName);
        if(returnValue1>0)
            return returnValue1;
        int returnValue2=floor2.cheeckCustomerExist(customerName);
        if(returnValue2>0)
            return returnValue2;
        int returnValue3=floor3.cheeckCustomerExist(customerName);
        if(returnValue3>0)
            return returnValue3;
        int returnValue4=floor4.cheeckCustomerExist(customerName);
        if(returnValue4>0)
            return returnValue4;
        else
            return -1;
    }
}
