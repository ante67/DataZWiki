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

import java.io.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
   //System.out.println(document);
   Elements divElements = document.getElementsByClass("mw-parser-output");
   Element divElement = divElements.get(0);
   
   Elements liElements = divElement.getElementsByTag("li");
   
   for (Element element : liElements){
       String attrHref = element.getElementsByTags("a").isEmpty() ?
               "" : element.getElementsByTags("a").get(0).attr("href");
       
       if (attrHref.contains("(cocktail)")){
           cocktailsUrlList.add("https://en.wikipedia.org/wiki"+attrHref);
       }           
   }
   for (Iterator<String> iterator = cocktailsUrlList.iterator(); iterator.hasNext();){
       String cocktailUrl = iterator.next();
       System.out.println(cocktailUrl);
       
   }
   //System.out.println(divElement);
   
   }
}
