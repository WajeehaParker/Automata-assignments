/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfaoperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 *
 * @author Wajeeha Parker
 */
public class operations {
    public DFA OR(DFA f1, DFA f2)
    {
        boolean p;
        int index;
        int[] trans=new int [f1.inputchar.length()];
        ArrayList tt=new ArrayList();
        ArrayList statecomb=new ArrayList<states>();
        states s=new states(f1.is, f2.is, null), s2;
        statecomb.add(s);
        for (int i=0; i<=statecomb.size(); i++)
        {
            trans=new int [f1.inputchar.length()];
            for (int j=0; j<f1.inputchar.length(); j++)
            {
                p=false;
                index=0;
                s2=new states(f1.transition(s.x, f1.inputchar.charAt(j)), f2.transition(s.y, f1.inputchar.charAt(j)), null);
                for (int k=0; k<statecomb.size(); k++)
                    if(((states)statecomb.get(k)).x==s2.x && ((states)statecomb.get(k)).y==s2.y)
                    {
                        p=true;
                        break;
                    }
                if (!p)
                    statecomb.add(s2);
                for (int k=0; k<statecomb.size(); k++)
                    if(((states)statecomb.get(k)).x==s2.x && ((states)statecomb.get(k)).y==s2.y)
                    {
                        index=k;
                        break;
                    }
                trans[j]=index;
            }
            if(i!=0)
            tt.add(trans);
            if(i!=statecomb.size())
                s=(states)statecomb.get(i);
        }
        //for setting final states
        ArrayList fs=new ArrayList();
        for(int i=0; i<statecomb.size(); i++)
            if(f1.fs.contains(((states)statecomb.get(i)).x) || f2.fs.contains(((states)statecomb.get(i)).y))
                if(!fs.contains(i))
                    fs.add(i);
                
        //converting tt to type int[][]
        int[][] TT=new int[tt.size()][f1.inputchar.length()];
        for (int i=0; i<tt.size(); i++)
            for (int j=0; j<((int[])tt.get(i)).length; j++)
                TT[i][j]=((int[])tt.get(i))[j];
        
        return new DFA (TT, f1.inputchar, 0, fs);
    }
    public DFA concat(DFA f1, DFA f2)
    {
        boolean p;
        int index;
        int[] trans=new int [f1.inputchar.length()];
        ArrayList tt=new ArrayList();
        ArrayList statecomb=new ArrayList<states>();
        states s=new states(f1.is, 0, null), s2;
        statecomb.add(s);
        for (int i=0; i<=statecomb.size(); i++)
        {
            trans=new int [f1.inputchar.length()];
            for (int j=0; j<f1.inputchar.length(); j++)
            {
                p=false;
                index=0;
                s2=new states(f1.transition(s.x, f1.inputchar.charAt(j)), 0, new ArrayList<Integer>());
                if(s.yy!=null && s.yy.size()!=0)
                    for (int k=0; k<s.yy.size(); k++)
                        s2.yy.add(f2.transition((int)s.yy.get(k), f1.inputchar.charAt(j)));
                if(f1.fs.contains(s2.x))       //adding in y when dfa1 ends
                    s2.yy.add(f2.is);
                s2.yy=(ArrayList) s2.yy.stream().distinct().collect(Collectors.toList());
                Collections.sort(s2.yy);             //sorting y in ascending order
                for (int k=0; k<statecomb.size(); k++)
                    if(((states)statecomb.get(k)).yy!=null)
                    {
                        if(((states)statecomb.get(k)).x==s2.x && ((states)statecomb.get(k)).yy.equals(s2.yy))
                        {
                            p=true;
                            break;
                        }
                    }
                    else
                    {
                        if(((states)statecomb.get(k)).x==s2.x)
                        {
                            p=true;
                            break;
                        }
                    }
                if (!p)
                    statecomb.add(s2);
                for (int k=0; k<statecomb.size(); k++)
                    if(((states)statecomb.get(k)).yy!=null)
                    {
                        if(((states)statecomb.get(k)).x==s2.x && ((states)statecomb.get(k)).yy.equals(s2.yy))
                        {
                            index=k;
                            break;
                        }
                    }
                    else
                    {
                        if(((states)statecomb.get(k)).x==s2.x)
                        {
                            index=k;
                            break;
                        }
                    }
                trans[j]=index;
            }
            if(i!=0)
            tt.add(trans);
            if(i!=statecomb.size())
                s=(states)statecomb.get(i);
        }
        
        //for setting final states
        ArrayList fs=new ArrayList();
        for(int i=0; i<statecomb.size(); i++)
            if (((states)statecomb.get(i)).yy!=null)
                for (int j=0; j<((states)statecomb.get(i)).yy.size(); j++)
                    if(f2.fs.contains(((states)statecomb.get(i)).yy.get(j)))
                        if(!fs.contains(i))
                        {
                            fs.add(i);
                            break;
                        }
                
        //converting tt to type int[][]
        int[][] TT=new int[tt.size()][f1.inputchar.length()];
        for (int i=0; i<tt.size(); i++)
            for (int j=0; j<((int[])tt.get(i)).length; j++)
                TT[i][j]=((int[])tt.get(i))[j];
        
        return new DFA (TT, f1.inputchar, 0, fs);
    }
    public DFA closure(DFA f1)
    {
        boolean p;
        int index;
        int[] trans=new int [f1.inputchar.length()];
        ArrayList tt=new ArrayList();
        ArrayList statecomb=new ArrayList<states>();
        states s=new states(f1.is, 0, null), s2;
        statecomb.add(s);
        for (int i=0; i<=statecomb.size(); i++)
        {
            trans=new int [f1.inputchar.length()];
            for (int j=0; j<f1.inputchar.length(); j++)
            {
                p=false;
                index=0;
                s2=new states(f1.transition(s.x, f1.inputchar.charAt(j)), 0, new ArrayList<Integer>());
                if(s.yy!=null && s.yy.size()!=0)
                    for (int k=0; k<s.yy.size(); k++)
                        s2.yy.add(f1.transition((int)s.yy.get(k), f1.inputchar.charAt(j)));
                if(f1.fs.contains(s2.x))       //adding in y when dfa1 ends
                    s2.yy.add(f1.is);
                s2.yy=(ArrayList) s2.yy.stream().distinct().collect(Collectors.toList());
                Collections.sort(s2.yy);             //sorting y in ascending order
                for (int k=0; k<statecomb.size(); k++)
                    if(((states)statecomb.get(k)).yy!=null)
                    {
                        if(((states)statecomb.get(k)).x==s2.x && ((states)statecomb.get(k)).yy.equals(s2.yy))
                        {
                            p=true;
                            break;
                        }
                    }
                    else
                    {
                        if(((states)statecomb.get(k)).x==s2.x)
                        {
                            p=true;
                            break;
                        }
                    }
                if (!p)
                    statecomb.add(s2);
                for (int k=0; k<statecomb.size(); k++)
                    if(((states)statecomb.get(k)).yy!=null)
                    {
                        if(((states)statecomb.get(k)).x==s2.x && ((states)statecomb.get(k)).yy.equals(s2.yy))
                        {
                            index=k;
                            break;
                        }
                    }
                    else
                    {
                        if(((states)statecomb.get(k)).x==s2.x)
                        {
                            index=k;
                            break;
                        }
                    }
                trans[j]=index;
            }
            if(i!=0)
            tt.add(trans);
            if(i!=statecomb.size())
                s=(states)statecomb.get(i);
        }
        
        //for setting final states
        ArrayList fs=new ArrayList();
        for(int i=0; i<statecomb.size(); i++)
            if (((states)statecomb.get(i)).yy!=null)
                for (int j=0; j<((states)statecomb.get(i)).yy.size(); j++)
                    if(f1.fs.contains(((states)statecomb.get(i)).yy.get(j)))
                        if(!fs.contains(i))
                        {
                            fs.add(i);
                            break;
                        }
                
        //converting tt to type int[][]
        int[][] TT=new int[tt.size()][f1.inputchar.length()];
        for (int i=0; i<tt.size(); i++)
            for (int j=0; j<((int[])tt.get(i)).length; j++)
                TT[i][j]=((int[])tt.get(i))[j];
        
        return new DFA (TT, f1.inputchar, 0, fs);
    }
    public DFA complement(DFA f1)
    {
        ArrayList fs=new ArrayList();
        for(int i=0; i<f1.tt.length; i++)
            if(!f1.fs.contains(i))
                fs.add(i);
        return new DFA (f1.tt, f1.inputchar, f1.is, fs);
    }
    public DFA intersection(DFA f1, DFA f2)
    {
        return complement(OR(complement(f1),complement(f2)));
    }
}
