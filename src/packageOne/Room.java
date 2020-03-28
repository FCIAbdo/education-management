package packageOne;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Room {
    private int roomNumber;
    private int floorNum;
    private int numOfBid;
    private float bidPrice;
    private String roomBooked;
    private Customer customer;
    private static int countOfObject = 0;
    int indicat;
    private File file;
    private FileWriter fw;
    private Scanner fr;
    public Room() {
        countOfObject++; //to read correct line 
        indicat=countOfObject;
        int count=1; //to read specific line in file and make loop
        String s[];//to save specific string from file
        String ss[];//used to split string
        file=new File("Hotel.txt");//pointer to file
        try {
            fr=new Scanner(file); //to read from file
            while(fr.hasNextLine()) {
                if(count==countOfObject) {  //to read specific line from file
                    s=fr.nextLine().split("  "); //to split specific line
                    for(int i=0;i<s.length;i++) {
                        ss=s[i].split(" ");
                        switch(i) {
                            case 0 :  floorNum=Integer.parseInt(ss[ss.length-1]);     break;
                            case 1 :  roomNumber=Integer.parseInt(ss[ss.length-1]);   break;
                            case 2 :  numOfBid=Integer.parseInt(ss[ss.length-1]);     break;
                            case 3 :  bidPrice=Float.parseFloat(ss[ss.length-1]);    break;
                            case 4 :  roomBooked=ss[ss.length-1];                     break;
                        }
                    }
                    break;
                }
                else {
                    fr.nextLine();
                    count++;
                }
            }
            fr.close();
        } catch(Exception e) {
            System.out.println("error in file please cheeck file format!");
        }
    }
    public int getIndicat() {
        return indicat;
    }
    public int getRoomNum() {
        return roomNumber;
    }
    public int getFloorRoomNum() {
        return floorNum;
    }
    public int getNumbOfBid() {
        return numOfBid;
    }
    public float getRoomPrice() {
        return getNumbOfBid()*bidPrice;
    }
    public boolean checkBooked() {
        if(roomBooked.equals("no"))
            return false;
        else
            return true;   
    }
    public void register(Customer customer) {
        this.customer=customer;
        ArrayList<String>list=new ArrayList<String>();
        try { 
            fr=new Scanner(file);
        while(fr.hasNextLine()) {
            list.add(fr.nextLine());
        }
        fr.close();
        int roomNum=customer.cusGetRoomNum();
            String s=list.get(roomNum-1).replace("no","yes  ").concat("customer "+customer.cusGetName()+" "+
                customer.cusGetPhone()+" "+customer.cusGetEmail()+" "+customer.cusGetNumOfNight()+
                " "+customer.cusGetCountry());
            list.remove(roomNum-1);
            list.add(roomNum-1,s);
        fw=new FileWriter(file);
            for(String ss : list)
              fw.write(ss+"\n");
            fw.close();
             roomBooked="yes";
        } catch(Exception e) {
           System.out.println("error in file please check file format!");
        }
    }
    public void unRegister() {
        ArrayList<String>list=new ArrayList<String>();
    try {
        fr=new Scanner(file);
        while(fr.hasNextLine()) {
            list.add(fr.nextLine());
        }
        fr.close();
        String lastData=list.get(indicat-1).replaceAll("yes.*","no");
        list.remove(indicat-1);
        list.add(indicat-1,lastData); 
        fw=new FileWriter(file); //to write to file
            for(String s : list)
              fw.write(s+"\n");
            fw.close();
        } catch(Exception e) {
           System.out.println("error in file please check file format!");
        }
        roomBooked="no";
    }
    public void setPrice(float price) {
        ArrayList<String>list=new ArrayList<String>();
        try {
        fr=new Scanner(file);
        while(fr.hasNextLine()) {
            list.add(fr.nextLine().replace("50",String.valueOf(price)));
        }
        fr.close();
        fw=new FileWriter(file); //to write to file
            for(String s : list)
              fw.write(s+"\n");
            fw.close();
        } catch(Exception e) {
           System.out.println("error in file please check file format!");
        }
        bidPrice=price;
    }
    public Customer getCustomerDataFromFile() {
        Customer customer=new Customer();
        String s="";
        String sSplit[];
        int count=1;
        try {
        fr=new Scanner(file);
        while(fr.hasNextLine()) {
            if(count==indicat) {
                s=fr.nextLine();
                break;
            } 
            else {
                 count++;
                 fr.nextLine();
            }
        }
        fr.close();
        if(s.contains("customer")==true) {
             s=s.replaceAll(".*customer ","");
           sSplit=s.split(" ");
           customer.cusSetName(sSplit[0]);
           customer.cusSetPhone(sSplit[1]);
           customer.cusSetEmail(sSplit[2]);
           customer.cusSetNumOfNieght(Integer.parseInt(sSplit[3]));
           customer.cusSetCountry(sSplit[4]);
           customer.cusSetRoomNum(indicat);
           
        }
        }catch(Exception e) {
            System.out.println("error in file !");
        }
         return customer;
} 
}