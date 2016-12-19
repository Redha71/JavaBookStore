/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanewtest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Redha
 */
public interface BookList {
     public List <Book> list(String searchString);
        public ArrayList<String> listBook();
   public boolean add(Book book, int quantity);
   public int[] buy(List <Book> book,List<Integer> number);

}
