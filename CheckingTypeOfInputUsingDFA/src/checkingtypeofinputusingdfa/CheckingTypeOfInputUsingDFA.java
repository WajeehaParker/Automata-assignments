/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkingtypeofinputusingdfa;
import java.util.*;

/**
 *
 * @author Wajeeha Parker
 */
public class CheckingTypeOfInputUsingDFA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        System.out.println("Input");
        String input=scan.next();
        DFA dfa=new DFA();
        int a=dfa.validate(input);
                switch(a)
                {
                    case 0:
                        System.out.println("Identifier");
                        break;
                    case 1:
                        System.out.println("Digit");
                        break;
                    case 2:
                        System.out.println("Decimal");
                        break;
                    case 3:
                        System.out.println("Character");
                        break;
                    case 4:
                        System.out.println("String");
                        break;
                    default:
                        System.out.println("Invalid");

                }
            }
            
        }