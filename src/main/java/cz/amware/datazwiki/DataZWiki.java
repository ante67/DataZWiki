/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.datazwiki;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.io.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.HttpStatusException;

/**
 *
 * @author m.ambros
 */
public class DataZWiki {
    
   public static void main(String[] args) throws IOException {

   List<String> cocktailsUrlList   = new LinkedList<String>();
       
   Document document = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_IBA_official_cocktails")
           .header("Accept-Encoding","gzip,deflate")
           .userAgent("Mozilla/5.0 (Windows NT 6.1;WOW64;rw23.0) Gecko/20100101 Firefox 23.0")
           .maxBodySize(0).timeout(600000).get();
   
   Elements divElements = document.getElementsByClass("mw-parser-output");  
   Element divElement = divElements.get(0);
   Elements liElements = divElement.getElementsByTag("li");
   
   //System.out.println(liElements);
  // System.out.println("VYPIS");
   //System.out.println(liElements.size());
   //System.out.println(liElements.);

   //System.out.println(liElements.size());
   
   
   //for(int i=0;i<liElements.size(); i++) {
   
   for(int i=0;i<100; i++) {
       Element elementNew = liElements.get(i);
       //System.out.println(elementNew.getElementsByTag("a"));
       String attrHref = elementNew.getElementsByTag("a").get(0).attr("href"); 
       //System.out.println(i); 
    
       if (attrHref.contains("(cocktail)")){
           cocktailsUrlList.add("https://en.wikipedia.org/"+attrHref);
         //  System.out.println(i+"  https://en.wikipedia.org/"+attrHref); 
           
       }      
   }    
    for (Iterator<String> iterator = cocktailsUrlList.iterator(); iterator.hasNext();){
        String cocktailUrl = iterator.next();
        //System.out.println(cocktailUrl);  
        try{
        Document document2 = Jsoup.connect(cocktailUrl)
           .header("Accept-Encoding","gzip,deflate")
           .userAgent("Mozilla/5.0 (Windows NT 6.1;WOW64;rw23.0) Gecko/20100101 Firefox 23.0")
           .maxBodySize(0).timeout(600000).get();
        String name = document2.getElementsByTag("caption").get(0).text(); //COCKTAIL NAME
        Element tableElement = document2.getElementsByClass("infobox").isEmpty() ?
                null : document2.getElementsByClass("infobox").get(0);
        
        Elements liElements2 = tableElement.getElementsByTag("li");
        
        for (Element liElement : liElements2){
            //Ingredient Name
            String ingredient = liElement.getElementsByTag("a").isEmpty() ?
                    "" :
                    liElement.getElementsByTag("a").get(0).text().toLowerCase();
            System.out.println(ingredient);  
        }
                
        
        //System.out.println(name);  
        }catch(HttpStatusException e){
            e.printStackTrace();
        }catch(Exception f){
            f.printStackTrace();        
        }
    }
       
       //String attrHref = elementNew.getElementsByTags("a").isEmpty() ?
       //        "" : elementNew.getElementsByTags("a").get(0).attr("href");   
       
       //System.out.println(attrHref);
   
   
   
  // for (Element element : liElements){       
  //     String attrHref = element.getElementsByTags("a").isEmpty() ?
  //             "" : element.getElementsByTags("a").get(0).attr("href");
       
  //     if (attrHref.contains("(cocktail)")){
  //         cocktailsUrlList.add("https://en.wikipedia.org/wiki"+attrHref);
  //     }           
   //}
  // for (Iterator<String> iterator = cocktailsUrlList.iterator(); iterator.hasNext();){
   //    String cocktailUrl = iterator.next();
    //   System.out.println(cocktailUrl);
       
  // }
   //System.out.println(divElement);
   
   }
}
