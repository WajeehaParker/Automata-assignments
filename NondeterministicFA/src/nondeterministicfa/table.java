/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nondeterministicfa;

/**
 *
 * @author Wajeeha Parker
 */
public class table {
    int state;
    char character;
    public table(int n, char s)
    {
        this.state=n;
        this.character=s;
    }
    public String toString()
    {
        return this.state+" "+ this.character;
    }
}
