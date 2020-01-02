/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtore;

import java.util.ArrayList;

/**
 *
 * @author Wajeeha Parker
 */
public class TGtoRE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        ArrayList tt=new ArrayList();
        ArrayList obj0=new ArrayList();
        ArrayList obj1=new ArrayList();
        ArrayList obj2=new ArrayList();
        ArrayList obj3=new ArrayList();
        ArrayList obj4=new ArrayList();
        ArrayList obj5=new ArrayList();
        ArrayList obj6=new ArrayList();
        ArrayList obj7=new ArrayList();
        ArrayList obj8=new ArrayList();
        obj3.add(new table(4, "34"));
        obj4.add(new table(5, "45"));
        tt.add(obj0);
        tt.add(obj1);
        tt.add(obj2);
        tt.add(obj3);
        tt.add(obj4);
        tt.add(obj5);
        tt.add(obj6);
        tt.add(obj7);
        tt.add(obj8);
        Converter tg=new Converter(tt.size(), tt, "ab", new int[]{3}, new int[]{5});
        tg.convert();
        tg=new Converter(tt.size(), tt, "ab", new int[]{3}, new int[]{5});
        System.out.println(tt.size());
        tg.convert();
        
        
//        ArrayList obj0=new ArrayList();
//        obj0.add(new table(1,"a"));
//        obj0.add(new table(5,"a"));
//        ArrayList obj1=new ArrayList();
//        obj1.add(new table(2,"a"));
//        obj1.add(new table(1,"b"));
//        obj1.add(new table(2,"b"));
//        obj1.add(new table(5,"bbb"));
//        ArrayList obj2=new ArrayList();
//        obj2.add(new table(2,"b"));
//        obj2.add(new table(3,"ab"));
//        ArrayList obj3=new ArrayList();
//        obj3.add(new table(4,"bb"));
//        ArrayList obj4=new ArrayList();
//        obj4.add(new table(5,"bb"));
//        obj4.add(new table(2,"bbb"));
//        obj4.add(new table(4,"a"));
//        ArrayList obj5=new ArrayList();
//        obj5.add(new table(2,"a"));
//        obj5.add(new table(0,"a"));
//        obj5.add(new table(3,"b"));
//        ArrayList tt=new ArrayList();
//        tt.add(obj0);
//        tt.add(obj1);
//        tt.add(obj2);
//        tt.add(obj3);
//        tt.add(obj4);
//        tt.add(obj5);
//        Converter c= new Converter(6, tt, "ab", new int[]{0}, new int[]{2});
//        c.convert();
        
        
        
         
    }
    
}