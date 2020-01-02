/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfaoperations;

import java.util.ArrayList;

/**
 *
 * @author Wajeeha Parker
 */
public class DFA {
    int[][] tt;
    String inputchar;
    int is;
    ArrayList fs;
    
    public DFA(int[][] tt, String ch, int is, ArrayList fs)
    {
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
        for (int i=0; i<fs.size(); i++)
            if (cs==(int)fs.get(i))
                return true;
        return false;
    }
    public int transition(int state, char ch)
    {
        return tt[state][inputchar.indexOf(ch)];
    }
}
