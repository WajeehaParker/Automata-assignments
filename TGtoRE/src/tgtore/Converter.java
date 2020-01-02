/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtore;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Wajeeha Parker
 */
public class Converter {
    String inputchar;
    int maxstates;
    int[] istate;
    int[] fstate;
    ArrayList<ArrayList<table>> tt;
    int is, fs;
    
    public Converter(int maxstates, ArrayList<ArrayList<table>> tt, String ch, int[] is, int[] fs)
    {
        this.maxstates=maxstates;
        this.tt=tt;
        this.inputchar=ch;
        this.istate=is;
        this.fstate=fs;
    }
    public void convert()
    {
        addnulltrans();
        reducemultipleedges();
        eliminate();
    }
    public void addnulltrans()
    {
        is=maxstates;
        fs=maxstates+1;
        ArrayList obj11=new ArrayList();
        for (int i=0; i<istate.length; i++)
            obj11.add(new table(istate[i], ""));
        ArrayList obj12=new ArrayList();
        tt.add(obj11);
        tt.add(obj12);
        table t=new table(maxstates+1, "");
        for (int i=0; i<fstate.length; i++)
            tt.get(fstate[i]).add(t);
    }
    public void reducemultipleedges()
    {
        for (int i=0; i<tt.size(); i++)
            for (int j=0; j<tt.get(i).size(); j++)
                for (int k=j+1; k<tt.get(i).size(); k++)
                    if (tt.get(i).get(j).state==tt.get(i).get(k).state)
                    {
                        table t=new table(tt.get(i).get(j).state, "(" + tt.get(i).get(j).s+")" + "|" + "("+tt.get(i).get(k).s+")");
                        tt.get(i).remove(k);
                        tt.get(i).remove(j);
                        tt.get(i).add(t);
                    }
    }
    public void eliminate()
    {
        ArrayList<table> incoming, outgoing, t;
        table loop, tab;
        ArrayList<Integer> incomingindex;
        String str;
        for (int i=0; i<tt.size(); i++)
        {
            reducemultipleedges();
            incoming=new ArrayList();
            outgoing= new ArrayList<table>();
            incomingindex=new ArrayList<Integer>();
            loop=null;
            //adding incoming edges of index i to the arraylist
            for (int j=0; j<tt.size(); j++)
                for (int k=0; k<tt.get(j).size(); k++)
                    if (tt.get(j).get(k).state==i && j!=i)
                    {
                        incoming.add(tt.get(j).get(k));
                        incomingindex.add(j);
                    }
            //adding outgoing edges and loop at index i to arraylist
            for(int j=0; j<tt.get(i).size(); j++)
            {
                if(tt.get(i).get(j).state==i)
                    loop=tt.get(i).get(j);
                else
                    outgoing.add(tt.get(i).get(j));
            }
            //forming new table and adding new edge
            for(int j=0; j<incomingindex.size(); j++)
            {
                reducemultipleedges();
                t=new ArrayList();
                for (int k=0; k<outgoing.size(); k++)
                {
                    str="";    
                    if(incoming.get(j).s!="")
                        str+="("+incoming.get(j).s+")";
                    if(loop!=null)
                        str+="("+loop.s+")*";
                    if(outgoing.get(k).s!="")
                        str+="("+outgoing.get(k).s+")";
                    
//                    System.out.println(i);
//                    System.out.println("from"+incomingindex.get(j)+"-"+outgoing.get(k).state);
//                    if(loop!=null)
//                        System.out.println("1."+incoming.get(j).s+" 2."+loop.s+" 3."+outgoing.get(k).s+ " str."+str);
//                    else
//                        System.out.println("1."+incoming.get(j).s+" 3."+outgoing.get(k).s+ " str."+str);
                    
                    tab=new table(outgoing.get(k).state, str);
                    t.add(tab);
                }
                for (int l=0; l<tt.get(incomingindex.get(j)).size(); l++)
                        if(tt.get(incomingindex.get(j)).get(l).state==i)
                            tt.get(incomingindex.get(j)).remove(l);
                for (int m=0; m<t.size(); m++)
                    tt.get(incomingindex.get(j)).add(t.get(m));    
            }
            if (i==tt.size()-2)
                System.out.println(tt.get(i).get(0).s);
            tt.get(i).clear();
        }
    }
}