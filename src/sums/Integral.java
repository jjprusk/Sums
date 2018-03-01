/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sums;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
/**
 *
 * @author joe pruskowski 2/28/2018
 * Integral class that performs all of the sum calculations.
 * 
 */
final class Integral {
    double a, b, exact = 0;
    int n;
    String exp, eexp;
    Expression expression;
    
    public Integral(Values v) {
        setup(v.getExp(), v.getA(), v.getB(), v.getN(), v.getExpInt());
    }
    public double getExact() {
        return exact;
    }
    /**
     * Compute the left sum of the integral.
     */
    public double leftSum() {
        double dx, sum = 0;
        
        dx = (double) (b - a) / n;
        for (int i=0; i<n; i++) {
            sum += expression.setVariable("x", a + (i * dx)).evaluate();
	}
        return sum * dx;
    }
    /**
     * Compute the midpoint sum of the integral.
     */
    public double midPoint() {
	double dx, sum = 0;

	dx = (double) (b - a) / n;

	for (int i=0; i<n; i++) {
            sum += expression.setVariable("x", a + i*dx + dx/2).evaluate();
	}
	return sum * dx;
}
    /**
     * Compute the right sum of the integral.
     */
    double rightSum() {
	double dx, sum = 0;

	dx = (double) (b - a) / n;

	for (int i=1; i<n+1; i++) {
            sum += expression.setVariable("x", a + (i * dx)).evaluate();
	}
	return sum * dx;
}
   /**
     * Compute the sum with trapezoids.
     */
    double trapezoidSum() {
	double dx, sum;

	dx = (double) (b - a) / n;

        sum = expression.setVariable("x", a).evaluate();
	for (int i=1; i<n; i++) {
            sum += 2*expression.setVariable("x", a+(i*dx)).evaluate();
	}
        sum += expression.setVariable("x", b).evaluate();
        
	return sum * (dx / 2.0);
}
/**
 * Calculate the sum using Simpson's rule. Note this only works
 * with even values of n.
 */
    double simpsonsSum() {
	double dx, sum;
	
	if (n % 2 != 0) return 0; // won't work with odd values of n

	dx = (double) (b - a) / n;

	sum = expression.setVariable("x", a).evaluate();
	for (int i=1; i<n; i++) {
            //
            // Every odd iteration adds 4 times the function value while
            // the even iterations add twice the function value.
            //
            if(i % 2 != 0)
                sum += 4*expression.setVariable("x", a + (i * dx)).evaluate();
            else
                sum += 2*expression.setVariable("x", a + (i * dx)).evaluate();
	}
	sum += expression.setVariable("x", b).evaluate();

	return sum * (dx / 3.0);
}
    public void setup(String exp, double a, double b, int n, String eexp) {
        this.exp = exp;
        this.eexp = eexp;
        this.a = a;
        this.b = b;
        this.n = n;
        this.expression = new ExpressionBuilder(exp)
            .variables("x")
            .build();
        // Perform the exact computation if expression was supplied
        if (!eexp.equals("")) {
            Expression exactExp = new ExpressionBuilder(eexp)
                    .variables("x")
                    .build();
            exact = exactExp.setVariable("x", b).evaluate() - 
                    exactExp.setVariable("x", a).evaluate();
        }
    }
}
