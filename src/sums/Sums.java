/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sums;
/**
 *
 * @author joe pruskowski 2/28/2018
 * Demonstration of numerical integration using different techniques.
 * 
 */
public class Sums {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length != 4 && args.length != 5) {
            Help help = new Help();
            help.usage();
        }
        Values values = new Values(args);
        Integral integral = new Integral(values);
        
        System.out.printf("\nIntegrating %s from %f to %f using %d subintervals\n\n",
            values.getExp(), values.getA(), values.getB(), values.getN());
        System.out.printf("%-15s %-10.6f\n\n", "Exact Value", integral.getExact());
        System.out.printf("%-15s %-10.6f %-5s %-10.6f\n", "Left Value", integral.leftSum(),
            "a_err", Math.abs(integral.leftSum()-integral.getExact()));
        System.out.printf("%-15s %-10.6f %-5s %-10.6f\n", "Midpoint Value", integral.midPoint(),
            "a_err", Math.abs(integral.midPoint()-integral.getExact()));
        System.out.printf("%-15s %-10.6f %-5s %-10.6f\n", "Right Value", integral.rightSum(),
            "a_err", Math.abs(integral.rightSum()-integral.getExact()));
        System.out.printf("%-15s %-10.6f %-5s %-10.6f\n", "Trapezoid Value", integral.trapezoidSum(),
            "a_err", Math.abs(integral.trapezoidSum()-integral.getExact()));
        System.out.printf("%-15s %-10.6f %-5s %-10.6f\n\n", "Simpson's Value", integral.simpsonsSum(),
            "a_err", Math.abs(integral.simpsonsSum()-integral.getExact()));

    }
}