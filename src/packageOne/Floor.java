package packageOne;  
import java.util.ArrayList;
public class Floor {
   private ArrayList<Room>twoBidRoomList;
   private ArrayList<Room>oneBidRoomList;
   private Customer customer=new Customer();
   private int floorNum;
   private static int floorNumber=0;
   public Floor(int numOfRoomInFloor) {
       floorNumber++;
       floorNum=floorNumber;
       twoBidRoomList=new ArrayList();
       oneBidRoomList=new ArrayList();
       Room rooms[]=new Room[numOfRoomInFloor];
       for(int i=0;i<numOfRoomInFloor;i++) {
           rooms[i]=new Room();
           if(rooms[i].getNumbOfBid()>1)
               twoBidRoomList.add(rooms[i]);
           else
               oneBidRoomList.add(rooms[i]);
       }
   }
   public ArrayList<Integer> getEmptyRoomOne() {
       ArrayList<Integer>emptyRoom=new<Integer> ArrayList();
       for(int i=0;i<oneBidRoomList.size();i++) {
           if(oneBidRoomList.get(i).checkBooked()!=true) {
               emptyRoom.add(oneBidRoomList.get(i).getRoomNum());
           }
       }
       return emptyRoom;
   }
   public ArrayList<Integer> getEmptyRoomTwo() {
       ArrayList<Integer>emptyRoom=new <Integer>ArrayList();
       for(int i=0;i<twoBidRoomList.size();i++) {
           if(twoBidRoomList.get(i).checkBooked()!=true) {
               emptyRoom.add(twoBidRoomList.get(i).getRoomNum());
           }
       }
       return emptyRoom;
   }
   public ArrayList<Integer> getEmptyRoomInFloor() {
        ArrayList<Integer>emptyRoom=new ArrayList();
        ArrayList<Integer> emptyRoomTwo= getEmptyRoomTwo();
        ArrayList<Integer>emptyRoomOne=getEmptyRoomOne();
         for(int roomNum :emptyRoomOne) {
            emptyRoom.add(roomNum);
        }
        for(int roomNum :emptyRoomTwo) {
            emptyRoom.add(roomNum);
        }
        return emptyRoom;
   }
   
   public int cheeckCustomerExist(String name) {
       for(Room room : oneBidRoomList) {
           if(room.getCustomerDataFromFile().cusGetName().equals("")==false){
             if(room.getCustomerDataFromFile().cusGetName().equals(name)) 
                 return room.getRoomNum()*10+floorNum;
           }
       }
       for(Room room : twoBidRoomList) {
         if(room.getCustomerDataFromFile().cusGetName().equals("")==false)
           if(room.getCustomerDataFromFile().cusGetName().equals(name))
                return room.getRoomNum()*10+floorNum;
       }
       return -1;
   }
   public void registration(Customer customer) {
       if(customer.cusGetRoomNum()<=oneBidRoomList.size()) {
           oneBidRoomList.get(customer.cusGetRoomNum()-1).register(customer);
       }
       else {
           twoBidRoomList.get(customer.cusGetRoomNum()-oneBidRoomList.size()-1).register(customer);
       }
   }
   public void unRegistration(int roomNum) {
       if(roomNum<=oneBidRoomList.size()) {
           oneBidRoomList.get(roomNum-1).unRegister();
       }
       else if(roomNum-oneBidRoomList.size()<=twoBidRoomList.size()){
           oneBidRoomList.get(roomNum-oneBidRoomList.size()-1).unRegister();
       }
       else {
           System.out.println("room number entered to un register is wrong ");
       }
   }
   public void showList(int roomNum) {
       if(roomNum<=oneBidRoomList.size()) {
           if(oneBidRoomList.get(roomNum-1).checkBooked()==true) {
               customer=oneBidRoomList.get(roomNum-1).getCustomerDataFromFile();
               float roomPrice=oneBidRoomList.get(roomNum-1).getRoomPrice();
               System.out.println(customer.cusGetName()+"  "+customer.cusGetCountry()+"  "+customer.cusGetPhone()+
                        "  "+customer.cusGetEmail()+"  "+customer.cusGetRoomNum()+"  "+customer.cusGetNumOfNight()+
                        "  "+roomPrice);
           }
           else
               System.out.println("this room is empty ");
       }
       else if(roomNum-oneBidRoomList.size()<=twoBidRoomList.size()) {
           if(twoBidRoomList.get(roomNum-oneBidRoomList.size()-1).checkBooked()==true) {
                customer=twoBidRoomList.get(roomNum-oneBidRoomList.size()-1).getCustomerDataFromFile();
                float roomPrice=twoBidRoomList.get(roomNum-oneBidRoomList.size()-1).getRoomPrice();
                System.out.println(customer.cusGetName()+"  "+customer.cusGetCountry()+"  "+customer.cusGetPhone()+
                        "  "+customer.cusGetEmail()+"  "+customer.cusGetRoomNum()+"  "+customer.cusGetNumOfNight()+
                        "  "+roomPrice);
           }
           else
               System.out.println("room is empty ");
       }
       else {
           System.out.println("roomNumber is wronge ! ");
       }
   }
}
