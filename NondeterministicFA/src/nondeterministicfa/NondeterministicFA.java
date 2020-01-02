/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nondeterministicfa;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author Wajeeha Parker
 */
public class NondeterministicFA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList obj0=new ArrayList();
        obj0.add(new table(0, 'a'));
        obj0.add(new table(1, 'a'));
        obj0.add(new table(3, 'a'));
        obj0.add(new table(4, 'b'));
        ArrayList obj1=new ArrayList();
        obj1.add(new table(2, 'a'));
        ArrayList obj2=new ArrayList();
        obj2.add(new table(2, 'a'));
        obj2.add(new table(2, 'b'));
        obj2.add(new table(3, 'b'));
        ArrayList obj3=new ArrayList();
        obj3.add(new table(1, 'b'));
        obj3.add(new table(2, 'b'));
        ArrayList obj4=new ArrayList();
        obj4.add(new table(3, 'a'));
        obj4.add(new table(4, 'b'));
        ArrayList tt= new ArrayList();
        tt.add(obj0);
        tt.add(obj1);
        tt.add(obj2);
        tt.add(obj3);
        tt.add(obj4);
        NFA nfa= new NFA(tt, "ab", 0, new int[]{2});
        boolean f=nfa.validate("abab");
        if(f)
            System.out.println("true");
        else System.out.println("false");
//        Scanner scan=new Scanner(System.in);
//        System.out.println("Enter total number of states");
//        int states=scan.nextInt();
//        ArrayList tt=new ArrayList(states);
//       
//        //tt0
//        
//        System.out.println("Enter the number of transitions of state 0");
//        int n=scan.nextInt();
//        ArrayList tt0= new ArrayList();
//        for (int i=0; i<n; i++)
//        {
//            System.out.println("Enter character of transition"+i+" of state 0");
//            String trans1char=scan.next();
//            System.out.println("Enter ending node of transition"+i+" of state 0");
//            int trans1node=scan.nextInt();
//            tt0.add(new table(trans1node, trans1char));
//        }
//        tt.add(tt0);
//        
//        
//        //tt1
//        
//        System.out.println("Enter the number of transitions of state 0");
//        n=scan.nextInt();
//        ArrayList tt1= new ArrayList();
//        for (int i=0; i<n; i++)
//        {
//            System.out.println("Enter character of transition"+i+" of state 1");
//            String trans1char=scan.next();
//            System.out.println("Enter ending node of transition"+i+" of state 1");
//            int trans1node=scan.nextInt();
//            tt0.add(new table(trans1node, trans1char));
//        }
//        tt.add(tt0);
//        
//        
//        //tt2
//        
//        System.out.println("Enter the number of transitions of state 0");
//        n=scan.nextInt();
//        ArrayList tt2= new ArrayList();
//        for (int i=0; i<n; i++)
//        {
//            System.out.println("Enter character of transition"+i+" of state 0");
//            String trans1char=scan.next();
//            System.out.println("Enter ending node of transition"+i+" of state 0");
//            int trans1node=scan.nextInt();
//            tt0.add(new table(trans1node, trans1char));
//        }
//        tt.add(tt0);
//        
//        //tt3
//        
//        System.out.println("Enter the number of transitions of state 0");
//        n=scan.nextInt();
//        ArrayList tt3= new ArrayList();
//        for (int i=0; i<n; i++)
//        {
//            System.out.println("Enter character of transition"+i+" of state 0");
//            String trans1char=scan.next();
//            System.out.println("Enter ending node of transition"+i+" of state 0");
//            int trans1node=scan.nextInt();
//            tt0.add(new table(trans1node, trans1char));
//        }
//        tt.add(tt0);
//        
//        //tt4
//        
//        System.out.println("Enter the number of transitions of state 0");
//        n=scan.nextInt();
//        ArrayList tt4= new ArrayList();
//        for (int i=0; i<n; i++)
//        {
//            System.out.println("Enter character of transition"+i+" of state 0");
//            String trans1char=scan.next();
//            System.out.println("Enter ending node of transition"+i+" of state 0");
//            int trans1node=scan.nextInt();
//            tt0.add(new table(trans1node, trans1char));
//        }
//        tt.add(tt0); 
    }
    
}
