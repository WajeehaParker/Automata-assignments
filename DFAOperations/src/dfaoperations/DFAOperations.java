/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfaoperations;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Wajeeha Parker
 */
public class DFAOperations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String chararray= new String("ab");
        int[][] transtable=new int[5][2];
        transtable[0][0]=1;
        transtable[0][1]=3;
        transtable[1][0]=2;
        transtable[1][1]=3;
        transtable[2][0]=2;
        transtable[2][1]=3;
        transtable[3][0]=1;
        transtable[3][1]=4;
        transtable[4][0]=1;
        transtable[4][1]=4;
        ArrayList fstate=new ArrayList<>();
        fstate.add(1);
        fstate.add(3);
        DFA dfa1=new DFA(transtable, chararray, 0, fstate);  //doesnt end on double letter
        
        chararray= new String("ab");
        transtable=new int[4][2];
        transtable[0][0]=1;
        transtable[0][1]=3;
        transtable[1][0]=0;
        transtable[1][1]=2;
        transtable[2][0]=3;
        transtable[2][1]=1;
        transtable[3][0]=2;
        transtable[3][1]=0;
        fstate=new ArrayList<>();
        fstate.add(2);
        DFA dfa2=new DFA(transtable, chararray, 0, fstate);   //odd odd
        
        chararray= new String("ab");
        transtable=new int[3][2];
        transtable[0][0]=1;
        transtable[0][1]=2;
        transtable[1][0]=1;
        transtable[1][1]=1;
        transtable[2][0]=2;
        transtable[2][1]=2;
        fstate=new ArrayList<>();
        fstate.add(1);
        fstate.add(0);
        DFA dfa3=new DFA(transtable, chararray, 0, fstate);   //starts with a
        
        chararray= new String("ab");
        transtable=new int[2][2];
        transtable[0][0]=0;
        transtable[0][1]=1;
        transtable[1][0]=0;
        transtable[1][1]=1;
        fstate=new ArrayList<>();
        fstate.add(1);
        DFA dfa4=new DFA(transtable, chararray, 0, fstate);   //ends on b
        
        chararray= new String("ab");
        transtable=new int[4][2];
        transtable[0][0]=0;
        transtable[0][1]=1;
        transtable[1][0]=1;
        transtable[1][1]=2;
        transtable[2][0]=2;
        transtable[2][1]=3;
        transtable[3][0]=3;
        transtable[3][1]=3;
        fstate=new ArrayList<>();
        fstate.add(2);
        DFA dfa5=new DFA(transtable, chararray, 0, fstate);   //having exactly 2 b
        
        chararray= new String("ab");
        transtable=new int[2][2];
        transtable[0][0]=1;
        transtable[0][1]=0;
        transtable[1][0]=1;
        transtable[1][1]=0;
        fstate=new ArrayList<>();
        fstate.add(1);
        DFA dfa6=new DFA(transtable, chararray, 0, fstate);   //end on a
        
        chararray= new String("ab");
        transtable=new int[3][2];
        transtable[0][0]=1;
        transtable[0][1]=0;
        transtable[1][0]=2;
        transtable[1][1]=0;
        transtable[2][0]=2;
        transtable[2][1]=2;
        fstate=new ArrayList<>();
        fstate.add(2);
        DFA dfa7=new DFA(transtable, chararray, 0, fstate);   //have aa
        
        
        operations opr=new operations();
        
        //COMPLEMENT
        System.out.println("Complementing 'odd-odd'");
        DFA temp=opr.complement(dfa2);
        System.out.println("For ababab");
        System.out.println(temp.validate("ababab"));
        System.out.println("For abab");
        System.out.println(temp.validate("abab"));
        
        System.out.println();
        
        //OR
        System.out.println("ORing 'odd-odd' and 'doesn't ends on double letter'");
        temp=opr.OR(dfa2,dfa1);
        System.out.println("For ababb");
        System.out.println(temp.validate("ababb"));
        System.out.println("For ababa");
        System.out.println(temp.validate("ababb"));
        
        System.out.println();
        
        //CONCATENATION
        System.out.println("Concatenating 'starts with a' and 'ends on b'");
        temp=opr.concat(dfa3,dfa4);
        System.out.println("For abaa");
        System.out.println(temp.validate("abaa"));
        System.out.println("For babab");
        System.out.println(temp.validate("b"));
        
        System.out.println();
        
        //CLOSURE
        System.out.println("CLosure of 'having exactly 2 b'");
        temp=opr.closure(dfa5);
        System.out.println("For ababbab");
        System.out.println(temp.validate("ababbab"));
        System.out.println("For ababba");
        System.out.println(temp.validate("ababba"));
        
        System.out.println();
        
        System.out.println("Intersection of 'ends on a' and 'have aa'");
        temp=opr.intersection(dfa6,dfa7);
        System.out.println("For baababa");
        System.out.println(temp.validate("baabba"));
        System.out.println("For ababba");
        System.out.println(temp.validate("ababba"));
        
        System.out.println();
        
        
        
    }
    
}
