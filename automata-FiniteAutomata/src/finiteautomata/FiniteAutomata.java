/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finiteautomata;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Wajeeha Parker
 */
public class FiniteAutomata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
        String chararray= new String("ab");
        int[][] transtable=new int[4][2];
        transtable[0][0]=1;
        transtable[0][1]=3;
        transtable[1][0]=0;
        transtable[1][1]=2;
        transtable[2][0]=3;
        transtable[2][1]=1;
        transtable[3][0]=2;
        transtable[3][1]=0;
        int[] fstate=new int[1];
        fstate[0]=0;
        finiteautometa eveneven=new finiteautometa(2, transtable, chararray, 0, fstate);
        
        boolean correct;
        correct=eveneven.validate("aababbab");
        System.out.println("Checking String 'aababbab'");
        if (correct)
            System.out.println("It is an even-even string");
        else System.out.println("It is not an even-even string");
        
        correct=eveneven.validate("ababbab");
        System.out.println("Checking String 'ababbab'");
        if (correct)
            System.out.println("It is an even-even string");
        else System.out.println("It is not an even-even string");
        

        
        System.out.println("Do you want to check yourself?(yes,no)");
        String ans=input.nextLine();
        if (ans.toLowerCase().equals("yes"))
        {
            System.out.println("Enter the maximum nuber of states");
            int maxstates=input.nextInt();
            System.out.println("Enter number of char");
            int maxchar=input.nextInt();
            System.out.println("Enter characters");
            char[] inchar= new char[maxchar];
            for(int i=0; i<maxchar; i++)
                inchar[i]=input.next().charAt(0);
            String inputchar= new String(inchar);
            System.out.println("Enter initail state");
            int is=input.nextInt();
            System.out.println("Enter number of final states");
            int maxfs=input.nextInt();
            System.out.println("Enter the final states");
            int[] fs= new int[maxfs];
            for (int i=0; i<maxfs; i++)
                fs[i]=input.nextInt();
            System.out.println("Enter row wise transition table");
            int[][] tt=new int[maxstates][maxchar];
            for (int i=0; i<maxstates; i++)
                for (int j=0; j<maxchar; j++)
                    tt[i][j]=input.nextInt();
            finiteautometa fa=new finiteautometa(maxstates, tt, inputchar, is, fs);

            boolean check=false;
            int charchecked=0;
            String str="";
            while(check!=true)
            {
                System.out.println("Enter the string to check the automata");
                str=input.next();
                for (int i=0; i<str.length(); i++)
                {
                    for (int j=0; j<inputchar.length(); j++)
                    {
                        if (str.charAt(i)==inputchar.charAt(j))
                        {
                            check=true;
                            break;
                        }
                        check=false;
                    }
                    if (check==true)
                        continue;
                    else break;
                }
                if (check==false)
                    System.out.println("Invalid String.");
            }    
            correct=fa.validate(str);
            if (correct)
                System.out.println("String matches the automata");
            else System.out.println("String does not match the automata");
        }        
    }
}