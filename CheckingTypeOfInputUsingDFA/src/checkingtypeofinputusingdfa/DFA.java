/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkingtypeofinputusingdfa;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Wajeeha Parker
 */
public class DFA {
    int[][] identifier=new int[][]{{2,3,1},
                           {2,2,1},
                           {2,2,2},
                           {3,3,3}};
    int[] fs=new int[]{2};
    String[] achar= new String[]{"[A-Za-z]", "[0-9]", "_"};
    
    int[][] digit=new int[][]{{2,1},
                            {2,3},
                            {2,3},
                            {3,3}};
        int[] fs1=new int[]{2};  
    String[] achar1=new String[]{"[0-9]", "[+-]"};
    
    int[][] decimal=new int[][]{{7,5,1,9},
                            {2,9,9,9},
                            {2,9,9,3},
                            {4,8,9,9},
                            {4,9,9,9},
                            {6,9,1,9},
                            {6,9,1,9},
                            {7,9,1,9},
                            {4,9,9,9},
                            {9,9,9,9}};
    int[] fs2=new int[]{2,4};
    String[] achar2=new String[]{"[0-9]", "[+-]", "\\.", "[Ee]"};
    
    int[][] character=new int[][]{{4,4,4,4,1},
                            {4,5,5,2,4},
                            {5,4,5,5,5},
                            {4,4,4,4,4},
                            {4,4,4,4,4},
                            {4,4,4,4,3}};
    int[] fs3=new int[]{3};
  String[] achar3=new String[]{"\"", "[A-Zacdefghijklmopqsuvwxyz]", "[rbtn0]", "\\\\", "'"};
    
    int[][] string=new int[][]{{5,5,5,5,1},
                            {5,3,3,2,5},
                            {3,5,3,3,3},
                            {5,3,3,2,4},
                            {5,5,5,5,5},
                            {5,5,5,5,5}};                        
    int[] fs4=new int[]{4};
    String[] achar4=new String[]{"'", "[A-Zacdefghijklmopqsuvwxyz]", "[rbtn0]", "\\\\", "\""};
    
    TransitionTable[] trans=new TransitionTable[]{new TransitionTable(identifier, 0, fs, achar),
                                                  new TransitionTable(digit, 0, fs1, achar1),
                                                  new TransitionTable(decimal, 0, fs2, achar2),
                                                  new TransitionTable(character, 0, fs3, achar3),
                                                  new TransitionTable(string, 0, fs4, achar4)};
    
    public int validate(String input)
    {
        int cs, t=0;
        for(int i=0; i<5; i++)
        {
            cs=trans[i].is;
            for (int j=0; j<input.length(); j++)
            {
                cs=transition(cs, input.charAt(j), i);
                if (cs==11)
                    break;
            }
            if (cs!=11)
            {
                for (int j=0; j<trans[i].fs.length; j++)
                    if (cs==trans[i].fs[j])
                        return i;
            }
        }
        return 11;
    }
    public int transition(int state, char ch, int i)
    {
        for (int j=0; j<trans[i].allowedchar.length; j++)
            if (Pattern.compile(trans[i].allowedchar[j]).matcher(String.valueOf(ch)).matches())
                return trans[i].tt[state][j];
        return 11;
    }
}