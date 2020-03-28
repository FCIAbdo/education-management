package packageOne;
import java.io.*;
import java.util.Scanner;
public class SystemWeaker {
   private String worName;
   private String worPassword;
   private String worUserName;
   private File file=new File("worker.txt");
   private FileWriter fw;
   private Scanner fr;
   private String list1[];
   private String list2[];
   public SystemWeaker() {
       try {
           fr=new Scanner(file);
           list1=fr.nextLine().split("  ");
           fr.close();
           for(int i=0;i<list1.length;i++) {
           list2=list1[i].split(" ");
           switch(i) {
               case 0 :    worName=list2[1];         break;
               case 1 :    worPassword=list2[1];     break;
               case 2 :    worUserName=list2[1];     break;   
             }
           }
       } catch(Exception e) {
           System.out.println("file can not open ");
       }      
   }
   public void worDisplayFileName() {
      System.out.println(worName);
   }
   public String worGetFilePassword() {
       return worPassword;
   }
   public String worGetFileUserName() {
       return worUserName;
   }
   public void worChangePass() {
       System.out.print("plaese enter old password : ");
       fr=new Scanner(System.in);
        String oldPassword=fr.nextLine();
        if(oldPassword==worPassword) {
            System.out.print("please enter new password : ");
            worPassword=fr.nextLine();
        }
        else {
            System.out.println("error password ");
        }
   }
   public void worChangeUserName() {
       System.out.print("plaese enter old userName : ");
       fr=new Scanner(System.in);
        String oldUserName=fr.nextLine();
        if(oldUserName==worUserName) {
            System.out.print("please enter new userName : ");
            worUserName=fr.nextLine();
        }
        else {
            System.out.println("error userName ");
        }
   }
}