/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanewtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Redha
 */
class Book {
     private String title;
   private String author;
   private BigDecimal price;
   private int quantity;
   private static final String FILENAME = "C:\\Users\\RSH\\Documents\\NetBeansProjects\\ProgrammingTestJava\\bookstoredata.txt";
  public Book(){}
   public Book(String title,String auther,BigDecimal price,int quantity){
   this.title=title;
   this.author=auther;
   this.price=price;
   this.quantity=quantity;
   }
  
   public String getTitle(){
  return title;
   }
  public String getAuther(){
  return author;
   }
    public BigDecimal getPrice(){
  return price;
   }

   public int getQuantity(){
  return quantity;
   }
}
