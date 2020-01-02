/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finiteautomata;

import java.util.*;

/**
 *
 * @author Wajeeha Parker
 */
public class finiteautometa {
    int maxsize;
    int[][] tt;
    String inputchar;
    int is;
    int[] fs;
    
    public finiteautometa(int maxsize, int[][] tt, String ch, int is, int[] fs)
    {
        this.maxsize=maxsize;
        this.tt=tt;
        this.inputchar=ch;
        this.is=is;
        this.fs=fs;
    }
    public boolean validate(String input)
    {
        int cs=is;
        boolean found=true;
        for(int i=0; i<input.length(); i++)
            cs=transition(cs, input.charAt(i));
        for (int i=0; i<fs.length; i++)
            if (cs==(int)fs[i])
                return true;
        return false;
    }
    public int transition(int state, char ch)
    {
        return tt[state][inputchar.indexOf(ch)];
    }
}
