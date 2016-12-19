/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanewtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Redha
 */
public class JavaNewTest implements BookList{
  /**
     * @param args the command line arguments
     */
     private static final String FILENAME = "C:\\Users\\RSH\\Documents\\NetBeansProjects\\JavaNewTest\\bookstoredata.txt";
        static List <Book> book;
    static  List <Book> basket=new ArrayList<Book>();
    static  List <Integer> basketNumber=new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
         JavaNewTest ptj=new JavaNewTest();
          System.out.println("Select one number from list \n"
                + "0- EXIT \n"
               + "1- List of book in Book Store \n"
               + "2- Search for Book in book store\n"
               +"3- Add to basket\n"
          +"4-Buy The Item");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       try{
          while (true ) {
              String name=br.readLine();
              if(isInteger(name)){
                  int select=Integer.parseInt(name);
  if(select==0){
      break;
  }else if(select==1){
  
        ArrayList s= ptj.listBook();
     for(int i=0;i<s.size();i++){
         System.out.println(s.get(i));     }
      System.out.println("Select one number from list \n"
                + "0- EXIT \n"
               + "1- List of book in Book Store \n"
               + "2- Search for Book in book store\n"
               +"3- Add to basket\n"
          +"4-Buy The Item");
  }else if(select==2){
  
          System.out.println("Write the book Name");
       
           String bookName=br.readLine();;
           ptj.list(bookName);
         for(int i=0;i<book.size();i++){
             System.out.println(book.get(i).getTitle()+" "+book.get(i).getAuther()+" "+book.get(i).getPrice()+" "+book.get(i).getQuantity());   
         }
            System.out.println("Select one number from list \n"
                + "0- EXIT \n"
               + "1- List of book in Book Store \n"
               + "2- Search for Book in book store\n"
               +"3- Add to basket\n"
          +"4-Buy The Item");  
        
        
  }else if(select==3){
  System.out.println("Write book name");
   String bookName=br.readLine();
    String line = null;
      List<String> list = new ArrayList<String>();
  System.out.println("Select Number of book you like to buy ");
   String bookNumber=br.readLine();;
   
   if(isInteger(bookNumber)&&!bookName.isEmpty()){
           try {
        Charset inputCharset = Charset.forName("ISO-8859-1");
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                      new FileInputStream(FILENAME), inputCharset ));
        while((line = reader.readLine()) != null){
            list.add(line);
        }
        for(int i=0;i<list.size();i++){
        String li=list.get(i);
        String mix="";
        String [] bookN=li.split(";");
        if(bookN[0].equals(bookName)&&Integer.parseInt(bookN[3])>=Integer.parseInt(bookNumber)){
            
            String [] boDec=bookN[2].split(",");
            for(int j=0;j<boDec.length;j++){
                mix+=boDec[j];
            }
            
       Book bokB= new Book(bookN[0],bookN[1],new BigDecimal(mix),Integer.parseInt(bookN[3]));
       ptj.add(bokB, Integer.parseInt(bookNumber));
        }
        }
        
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }
       
 
    System.out.println("The book is add to basket ");
     for(int i=0;i<basket.size();i++){
          System.out.println("Item Name "+basket.get(i).getTitle()+"  Item Number "+basketNumber.get(i));
     }
   System.out.println("Select one number from list \n"
                + "0- EXIT \n"
               + "1- List of book in Book Store \n"
               + "2- Search for Book in book store\n"
               +"3- Add to basket\n"
          +"4-Buy The Item");  
  
   }else{
 break;
   }
  }else if(select==4){
      if(!basket.isEmpty()){
          int sum=0;
     int [] result= ptj.buy(basket, basketNumber);
       for(int i=0;i<result.length;i++){
           int n=i+1;
        System.out.println( "Item "+(n)+"-"+result[i]); 
        sum+=result[i];
       
       }
         System.out.println( "Total  "+sum); 
      System.out.println( "Select one number from list \n"
                + "0- EXIT \n"
               + "1- List of book in Book Store \n"
               + "2- Search for Book in book store\n"
               +"3- Add to basket\n"
          +"4-Buy The Item");
      }else{
       System.out.println("There is no item in basket \n"
               + "Select one number from list \n"
                + "0- EXIT \n"
               + "1- List of book in Book Store \n"
               + "2- Search for Book in book store\n"
               +"3- Add to basket\n"
          +"4-Buy The Item");
      }
      
        
  }
 
    }else{
       break;        
              }
          }
       } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public List <Book>  list(String searchString) {
                 String line = null;
                 Book bo;
           List<String> list = new ArrayList<String>();
           book=new ArrayList<Book>();
 ArrayList <String> bookList=new  ArrayList<String>();
    try {
        Charset inputCharset = Charset.forName("ISO-8859-1");
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                      new FileInputStream(FILENAME), inputCharset ));
        while((line = reader.readLine()) != null){
            list.add(line);
        }
        for(int i=0;i<list.size();i++){
        String li=list.get(i);
        String mix="";
        String [] bookName=li.split(";");
        if(bookName[0].equals(searchString)){
            String [] boDec=bookName[2].split(",");
            for(int j=0;j<boDec.length;j++){
                mix+=boDec[j];
            }
        book.add(new Book(bookName[0],bookName[1],new BigDecimal(mix),Integer.parseInt(bookName[3])));
        }
        }
        
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    return book;
    }
//List All Book
    @Override
    public ArrayList<String> listBook() {
                        String line = null;
           ArrayList<String> list = new ArrayList<String>();
 ArrayList <String> bookList=new  ArrayList<String>();
    try {
        Charset inputCharset = Charset.forName("ISO-8859-1");
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                      new FileInputStream(FILENAME), inputCharset ));
        while((line = reader.readLine()) != null){
            list.add(line);
        }
        for(int i=0;i<list.size();i++){
        String li=list.get(i);
        String [] bookName=li.split(";");
        bookList.add(bookName[0]);
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    return  bookList;
    }

    @Override
    public boolean add(Book book, int quantity) {
    
      basket.add(book);
      basketNumber.add(quantity);
    return true;
    }

    @Override
    public int[] buy(List <Book> book,List<Integer> number) {
        int [] sum=new int[book.size()];
          for(int i=0;i<basket.size();i++){
           sum[i]=basket.get(i).getPrice().intValue()*number.get(i);
       }
      basket.clear();
      basketNumber.clear();
      return sum;
    }
   public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    // only got here if we didn't return false
    return true;
} 
}
