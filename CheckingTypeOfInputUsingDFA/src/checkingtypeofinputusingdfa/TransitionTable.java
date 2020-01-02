/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkingtypeofinputusingdfa;

/**
 *
 * @author Wajeeha Parker
 */
public class TransitionTable {
    int[][] tt;
    int is;
    int[] fs;
    String[] allowedchar;
    
    public TransitionTable(int[][] tt, int is, int[] fs, String[] allowedchar)
    {
        this.tt=tt;
        this.is=is;
        this.fs=fs;
        this.allowedchar= allowedchar;
    }
}
