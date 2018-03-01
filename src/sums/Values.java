/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sums;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
/**
 *
 * @author joe pruskowski 2/28/2018
 * Class converts user input into internally usable data
 * 
 */
final class Values {
    double a, b;
    int n;
    String exp, expInt = "";
    public Values(String[] args){
        Scanner scan = new Scanner(System.in);
        //
        // If args not provided, then prompt
        //
        if (args.length <= 3) {
            System.out.print("Enter equation: ");
            exp = scan.next();
            System.out.print("Enter staring value: ");
            a = scan.nextDouble();
            System.out.print("Enter ending value: ");
            b = scan.nextDouble();
            System.out.print("Enter number of intervals: ");
            n = scan.nextInt();
            System.out.print("Enter exact equation: ");
            expInt = scan.next();
            return;
        }
        this.convertValues(args);
}
    public int getN() {
        return this.n;
    }
    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public String getExp() {
        return this.exp;
    }
    public String getExpInt() {
        return this.expInt;
    }
    void convertValues(String[] args) {
        exp = args[0];
        a = parseDouble(args[1]);
        b = parseDouble(args[2]);
        n = parseInt(args[3]);
        if (args.length > 4) expInt = args[4];
    }
}