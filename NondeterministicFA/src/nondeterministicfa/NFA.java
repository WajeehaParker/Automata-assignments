/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nondeterministicfa;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Stack;

/**
 *
 * @author Wajeeha Parker
 */
public class NFA {
    String inputchar;
    int is, c=1;
    int[] fs;
    Stack trans=new Stack();
    Stack visited=new Stack();
    ArrayList<ArrayList<table>> tt;
//    ArrayList<table> t=new ArrayList<table>();
    table[] t;
    Stack count=new Stack();
    
    public NFA(ArrayList<ArrayList<table>> tt, String ch, int is, int[] fs)
    {
        this.tt=tt;
        this.inputchar=ch;
        this.is=is;
        this.fs=fs;
        this.trans.push(-1);
        this.visited.push(new table(-1,'@'));
    }
    public boolean validate(String input)
    {
        int cs=is, i=0;
        while(true)
        {
            cs=transition(cs, input.charAt(i));
            i++;
            while (i==input.length() || (i!=input.length() && cs==100))
            {
                if(i==input.length())
                {
                    for (int j=0; j<fs.length; j++)
                    {
                        if (cs==fs[j])
                            return true;
                    }
                }
                cs=(int)trans.pop();
                i--;
                for (int j=0; j<tt.get(cs).size(); j++)
                {
                    if(tt.get(cs).get(j)==visited.pop())
                    {
                        for (int k=j+1; k<tt.get(cs).size(); k++)
                            if (tt.get(cs).get(j).character==input.charAt(i))
                            {
                                trans.push(cs);
                                visited.push(tt.get(cs).get(j));
                                cs=tt.get(cs).get(j).state;
                                i++;
                            }
                    }
                }
            }
            if(i==0 && cs==is)
                break;
        }
        return false;
    }
    public int transition(int state, char ch)
    {
        for (int i=0; i<tt.get(state).size(); i++)
            if (tt.get(state).get(i).character==ch)
            {
                trans.push(state);
                visited.push(tt.get(state).get(i));
                return tt.get(state).get(i).state;
            }
            return 100;
    }
//    public boolean validate(String input)
//    {
//        int cs=is, i=0;
//        while(i!=input.length())
//        {
//            cs=transition(cs, input.charAt(i));
//            i++;
//            if (i==input.length())
//            {
//                for (int j=0; j<fs.length; j++)
//                {
//                    if (cs==fs[j])
//                        return true;
////                    else{
////                        i--;
////                        tr[k]=cs;
////                        vi[k]=tt.get(cs).get(obj);
////                        k++;
////                        cs=(int)trans.pop();
////                        visited.pop();
////                        transmark=(int)trans.peek();
////                        visitedmark=(table)visited.peek();
////                        if (cs==transmark)
////                        {
////                            k=0;
////                            tr=new int[10];
////                            vi=new table[10];
////                        }
////                    }
//                }
//            }
//        }
//        return false;
//    }
//    public int transition(int state, char ch)
//    {
//        for (int i=0; i<tt.get(state).size(); i++)
//            if (tt.get(state).get(i).character==ch)
//            {
////                for (int j=0; j<k; j++)
////                    if((int)trans.peek()==tr[j] && visited.peek().equals(vi[j]))
////                        i++;
//                trans.push(state);
//                visited.push(tt.get(state).get(i));
//                obj=i;
//                return tt.get(state).get(i).state;
//            }
//            return 100;
//    }
}
