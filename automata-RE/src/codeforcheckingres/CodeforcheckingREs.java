/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeforcheckingres;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Wajeeha Parker
 */
public class CodeforcheckingREs {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        String identifier= "[A-Za-z][A-Za-z0-9]*|_([A-Za-z0-9])+";
        String integer= "[+-]?([0-9])+";
        String floatnumber= "[+-]?[0-9]*\\.[0-9]+([Ee][+-]?([0-9])+)?";
        String character= "\'(\\(\"|[rbtn0]|'|\\)|[rbtn0]|\\S)\'";
        String string= "\"(\\(\'|[rbtn0]|\"|\\)|[rbtn0]|\\S)*\"";
        boolean loop=true;
        while(loop)
        {
            System.out.println("Input:");
            String input=scan.next();
            if (Pattern.compile(identifier).matcher(input).matches())
                System.out.println("Identifier");
            else if (Pattern.compile(integer).matcher(input).matches())
                System.out.println("Integer");
            else if (Pattern.compile(floatnumber).matcher(input).matches())
                System.out.println("Float");
            else if (Pattern.compile(character).matcher(input).matches())
                System.out.println("Character");
            else if (Pattern.compile(string).matcher(input).matches())
                System.out.println("String");
            else
                System.out.println("Invalid");
            System.out.println("Do you want to continue? (yes/no)");
            String ans=scan.next();
            if (ans.equals("no"))
                loop=false;
        }
    }
    
}
