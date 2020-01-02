/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfg.samenumberofaandb;

import java.util.Scanner;

/**
 *
 * @author Wajeeha Parker
 */
public class CFGSameNumberOfAAndB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        System.out.println("Input");
        String input=scan.next();
        input+="$";
        CFG cfg=new CFG();
        System.out.println(cfg.validate(input));   
    }
    
}
