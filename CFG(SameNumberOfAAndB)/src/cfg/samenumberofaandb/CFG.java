/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfg.samenumberofaandb;

/**
 *
 * @author Wajeeha Parker
 */
public class CFG {
    static int index=0;
    static String input;
    public boolean validate(String in)
    {
        this.input=in;
        if(Sfun() && input.charAt(index)=='$')
            return true;
        return false;
    }
    public boolean Sfun()
    {
        if(input.charAt(index)=='a')
        {
            index++;
            if(Sfun())
                if(input.charAt(index)=='b')
                {
                    index++;
                    return true;
                }
        }
        else
            return true;
        return false;
    }
}
