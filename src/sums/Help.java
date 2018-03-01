/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sums;

/**
 *
 * @author joe pruskowski 2/28/2018
 * Show the user some help.
 * 
 */
public class Help {
    public void usage() {
        System.out.printf("sum: usage: sum eq a b n ieq\n");
        System.out.printf("Where:\n");
        System.out.printf("  eq    - the target equation\n");
        System.out.printf("  a     - the lower bound\n");  
        System.out.printf("  b     - the upper bound\n");  
        System.out.printf("  n     - the number of subintervals\n");
        System.out.printf("  [ieq] - result of integration equation\n");     
    }
}
