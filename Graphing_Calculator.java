//Ved Mehta
//January 11th 2024
//Graphing Calculator

package Graphing_Calculator;

import hsa_ufa.Console ;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat ;
import java.io.IOException ;
import java.io.Writer;
import javax.swing.*;
import java.awt.*;

public class Graphing_Calculator { //start of class

	static Console c ;
	static Console d ;
		
	 public static void main(String[] args) { //start of main
		 
		 try
		 
		 { //start of try
		     
			 BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/vedmehta/Documents/Grade 11/Computer Science/Culminating/Graphing_Calculator_Output.txt")) ;
			 
			 int userInput ;
			 c = new Console() ;
			 	
			 		do
			 			
			 		{ //start of do while
			 			
				 		 userInput = menuSelection() ;
	
						 if (userInput > 12)
							 
						 { //start of if
							 
							 c.println("Please re-start the program and enter a valid number!") ;
							 
						 } //end of if
						
						 switch (userInput)
						 
						 { //start of switch
						 
						 	case 1 :
						 		
						 		linearFunction() ;
						 		break ;
						 		
						 	case 2 :
						 		
						 		quadraticFunction() ;
						 		break ;
						 		
						 	case 3 :
						 		
						 		cubicFunction() ;
						 		break ;
						 		
						 	case 4 :
						 		
						 		quarticFunction() ;
						 		break ;
				
						 	case 5 :
						 		
						 		trigFunction() ;
						 		break ;
				
						 	case 6 :
						 		
						 		inverseTrigFunction() ;
						 		break ;
				
						 	case 7 :
						 		
						 		squareRootFunction() ;
						 		break ;
				
						 	case 8 :
						 		
						 		logarithmicFunction() ;
						 		break ;
				
						 	case 9 :
						 		
						 		exponentialFunction() ;
						 		break ;
						 	
						 } //end of switch
						 
			 		}//end of do while
				 		
			 		while (userInput != -1) ;
			 		writer.close() ;
		 		
		 } //end of try
		 
		 catch (IOException e)
		 
		 { //start of catch
			 
				e.printStackTrace() ;
				
		 } //end of catch
		 
	 } //end of main
	 
	 public static int menuSelection()
	 
	 { //start of menuSelection method
		 
		 c.println ("\nSelect Option (enter menu number)");
         c.println ("No.\t" + "Option");
         c.println ("1\t" + "Linear Function");
         c.println ("2\t" + "Quadratic Function");
         c.println ("3\t" + "Cubic Function");
         c.println ("4\t" + "Quartic Function");
         c.println ("5\t" + "Sine and Cosine Functions (In Degrees)");
         c.println ("6\t" + "Inverse Sine and Cosine Functions (In Degrees)");
         c.println ("7\t" + "Square Root Function");
         c.println ("8\t" + "Logarithmic Function (Only Log Base 10)");
         c.println ("9\t" + "Exponential Function (Only Base 2)");
         c.println ("-1\t" + "Quit");
         
         return c.readInt() ;
         
	 } //end of menuSelection method
	 
	 public static void linearFunction()
	 
	 { //start of linearFunction method
		 
		 try
		 
		 { //start of try
			 
		 BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/vedmehta/Documents/Grade 11/Computer Science/Culminating/Graphing_Calculator_Output.txt")) ;
		 
		 final DecimalFormat df = new DecimalFormat("0.00") ; //this rounds all decimals to 2 decimal spaces
		 
		 c.println("Please enter the slope of the function (The \"m\" value)") ;
		 double mValue = c.readDouble() ;
		 c.println("Please enter the starting point of the function (The \"b\" value)") ;
		 double bValue = c.readDouble() ;
		 c.println("The function you have entered is: " + "f(x) = " + mValue + "x" + " + " + bValue) ;
		 writer.write("The function you have entered is: " + "f(x) = " + mValue + "x" + " + " + bValue) ;
		 
		 int points = 11 ;
	     int incrementFactor = -100 ;
		 double[] x = new double[points] ; //defines the x value outside the for loop
		 double[] y = new double[points] ; //defines the y value outside the for loop
		 
		 for (int i = 0 ; i < points ; i++)
			 
		 { //start of for loop
			 
			 y[i] = ((mValue * incrementFactor) + bValue) ; //calculates the x value
			 x[i] = incrementFactor ; //this is the x-value that does up by 20 each time
			 incrementFactor = incrementFactor + 20 ;
			 
		 } //end of for loop
		 
		 for (int i = 0 ; i < points ; i++)
		        	
		{ //start of for loop
			 
			 writer.write("\nPoint " + (i + 1) + ": " + "(" + x[i] + " , " + y[i] + ")") ;
			 c.println("Point " + (i + 1) + ": " + "(" + x[i] + " , " + y[i] + ")") ;
			 
		} //end of for loop
	
		 int maxValue = 200 ; //this is the amount of pixels the second console (the graph) will be composed out of
		 d = new Console(maxValue, maxValue) ; //this console d is a separate window that will be used to graph a linear function
		 
		 d.drawLine(0, (maxValue / 2), maxValue, (maxValue / 2)) ; //plots x-axis
		 d.drawLine((maxValue / 2), 0, (maxValue / 2), maxValue) ; //plots y-axis
		 d.setColor(Color.RED) ; //changes the color of the console to red
		 d.drawLine(0, 200, 200, 0) ; //draws the base y = x function as a comparison to the transformed graph
		 d.setColor(Color.BLUE) ; //changes the color of the console to blue
         int yLast = (int)(mValue * 100 + bValue) ; //this calculates the y-point for the last coordinate of the transformed graph
         int yFirst = (int)(mValue * (-100) + bValue) ; //this calculates the x-point for the last coordinate of the transformed graph
         d.drawLine(-100 + (maxValue / 2), (maxValue / 2) - yFirst, 100 + (maxValue / 2), (maxValue / 2) - yLast) ; //these are the transformations needed in order to graph the function the user entered
		 
		 writer.close() ;
		 
		 }//end of try
		 
		 catch (IOException e)
		 
		 {//start of catch
			 
				e.printStackTrace() ;
				
		 }//end of catch
		 
	 } //end of linearFunction method
	 
	 public static void quadraticFunction()
	 
	 { //start of quadraticFunction method
		 
		 final DecimalFormat df = new DecimalFormat("0.00") ; //this rounds all decimals to 2 decimal spaces

		  	c.println("Please enter the vertical stretch or compression (The \"a\" value)") ;
		    double aValue = c.readDouble() ;
		    c.println("Please enter the horizontal stretch or compression (The \"k\" value)") ;
		    double kValue = c.readDouble() ;
		    c.println("Please enter the vertical shift (The \"d\" value)") ;
		    double dValue = c.readDouble() ;
		    c.println("Please enter the horizontal shift (The \"c\" value)") ;
		    double cValue = c.readDouble() ;
		    c.println("The function you have entered is: " + "f(x) = " + aValue + "(" + kValue + "(x + " + dValue + "))^2 + " + cValue) ;

		    c.println("\nPlease enter how many points you want to plot!") ;
		    int points = c.readInt() ;

		    double[] y = new double[points] ; //defines the y value outside the for loop
		    double[] x = new double[points] ; //defines the x value outside the for loop
		    double[] temp = new double[points] ; //this is the non-transformed x-values the user entered
	        double[] temp2 = new double[points] ; //this is the non-transformed y-values the user entered
	        kValue = (1 / kValue) ;
	        dValue = (-1 * dValue) ;

		    //for loop gets the user top enter the x value, then calculates the y value based on that information
		    for (int i = 0 ; i < points ; i++)
		    
		    { //start of for loop
		    	
	        	c.println("Enter x-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
		        x[i] = c.readDouble() ; //gets the x value from the user
	            temp[i] = x[i] ;
	            x[i] = ((1 / kValue) * x[i]) + dValue ;
	        	c.println("Enter y-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
		        y[i] = c.readDouble() ; //gets the x value from the user
		        temp2[i] = y[i] ;
		        y[i] = (aValue * y[i]) + cValue ; //calculates the y value
		        
		    } //end of for loop
		    
		    for (int i = 0 ; i < points ; i++)
	        	
	        {
	        	c.println("Point " + (i + 1) + ": " + "(" + temp[i] + " , " + temp2[i] + ") --> " + "(" + x[i] + " , " + y[i] + ")") ;
	        }

	 } //end of quadraticFunction method
	  
	 public static void cubicFunction()
	 
	 {
		 final DecimalFormat df = new DecimalFormat("0.00") ; //this rounds all decimals to 2 decimal spaces

		  	c.println("Please enter the coefficient of x^3") ;
		    double aValue = c.readDouble() ;
		  	c.println("Please enter the coefficient of x^2") ;
		    double bValue = c.readDouble() ;
		    c.println("Please enter the coefficient of x") ;
		    double cValue = c.readDouble() ;
		    c.println("Please enter the constant value") ;
		    double dValue = c.readDouble() ;
	        c.println("The function you have entered is: f(x) = " + aValue + "x^3 + " + bValue + "x^2 + " + cValue + "x + " + dValue) ;

		    c.println("\nPlease enter how many points you want to plot!") ;
		    int points = c.readInt() ;

		    double[] y = new double[points] ; //defines the y value outside the for loop
		    double[] x = new double[points] ; //defines the x value outside the for loop

		    //for loop gets the user top enter the x value, then calculates the y value based on that information
		    for (int i = 0 ; i < points ; i++)
		    
		    { //start of for loop
		    	
		        c.println("Enter x-coordinate for point " + (i + 1) + ":") ;
		        x[i] = c.readDouble() ; //gets the x value from the user
	            y[i] = aValue * Math.pow(x[i], 3) + bValue * Math.pow(x[i], 2) + cValue * x[i] + dValue ; //calculates the y value
	            
		    } //end of for loop
		    
		    for (int i = 0 ; i < points ; i++)
	        	
	        {
	        	c.println("Point " + (i + 1) + ": " + "(" + x[i] + " , " + y[i] + ")") ;
	        }
	 }
	 
	 public static void quarticFunction()
	 
	 {
		 final DecimalFormat df = new DecimalFormat("0.00") ; //this rounds all decimals to 2 decimal spaces

		  	c.println("Please enter the coefficient of x^4") ;
		    double aValue = c.readDouble() ;
		  	c.println("Please enter the coefficient of x^3") ;
		    double bValue = c.readDouble() ;
		    c.println("Please enter the coefficient of x^2") ;
		    double cValue = c.readDouble() ;
		    c.println("Please enter the coefficent of x") ;
		    double dValue = c.readDouble() ;
		    c.println("Please enter the constant value") ;
		    double eValue = c.readDouble() ;
	        c.println("The function you have entered is: f(x) = " + aValue + "x^4 + " + bValue + "x^3 + " + cValue + "x^2 + " + dValue + "x " + eValue) ;

		    c.println("\nPlease enter how many points you want to plot!") ;
		    int points = c.readInt() ;

		    double[] y = new double[points] ; //defines the y value outside the for loop
		    double[] x = new double[points] ; //defines the x value outside the for loop
		    
		    //for loop gets the user top enter the x value, then calculates the y value based on that information
		    for (int i = 0 ; i < points ; i++)
		    
		    { //start of for loop
		    	
		        c.println("Enter x-coordinate for point " + (i + 1) + ":") ;
		        x[i] = c.readDouble() ; //gets the x value from the user
	            y[i] = aValue * Math.pow(x[i], 4) + bValue * Math.pow(x[i], 3) + cValue * Math.pow(x[i], 2) + dValue * x[i] + eValue ; //calculates the y value
		        
		    } //end of for loop
		    
		    for (int i = 0 ; i < points ; i++)
	        	
	        {
	        	c.println("Point " + (i + 1) + ": " + "(" + x[i] + " , " + y[i] + ")") ;
	        }
	 }
	 
	 public static void trigFunction()
	 
	 {
		 
		 final DecimalFormat df = new DecimalFormat("0.00");
		 c.println("Please enter if you want a sine or cosine function") ;
		 String userInput = c.readLine() ;
		 
		 switch(userInput)
		 
		 {
		 
		 case "cosine", "Cosine", "cos", "Cos" :
			 
				c.println("Please enter the a value (The amplitude)") ;
			    double aValue = c.readDouble() ;
			  	c.println("Please enter the k value (The period)") ;
			    double kValue = c.readDouble() ;
			    c.println("Please enter the d value (The phase shift)") ;
			    double dValue = c.readDouble() ;
			    c.println("Please enter the c value (The vertical shift)") ;
			    double cValue = c.readDouble() ;
			 
				c.println("What you have entered is: f(x) = " + aValue + " cos(" + kValue + "(x + " + dValue + ")) + " + cValue) ;
	
		        c.println("\nPlease enter how many points you want to plot!") ;
		        int points = c.readInt() ;
	
		        double[] y = new double[points] ;
		        double[] x = new double[points] ;
		        double[] temp3 = new double[points] ; //this is the non-transformed x-values the user entered
		        double[] temp4 = new double[points] ; //this is the non-transformed y-values the user entered
		        kValue = (1 / kValue) ;
		        dValue = (-1 * dValue) ;
	
		        for (int i = 0; i < points; i++) 
		        
		        {
		        	
		        	c.println("Enter x-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
			        x[i] = c.readDouble() ;
			        temp3[i] = x[i] ;
		        	x[i] = ((1 / kValue) * x[i]) + dValue ;
		        	c.println("Enter y-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
			        y[i] = c.readDouble() ;
			        temp4[i] = y[i] ;
		        	y[i] = (aValue * y[i]) + cValue ;
		            
		        }
		        
		        for (int i = 0 ; i < points ; i++)
		        	
		        {
		        	c.println("Point " + (i + 1) + ": " + "(" + temp3[i] + " , " + temp4[i] + ") --> " + "(" + x[i] + " , " + y[i] + ")") ;
		        }
		        
				 break ;

		 case "sine", "Sine", "sin", "Sin" :
			 
				c.println("Please enter the a value (The amplitude)") ;
			    double aValue2 = c.readDouble() ;
			  	c.println("Please enter the k value (The period)") ;
			    double kValue2 = c.readDouble() ;
			    c.println("Please enter the d value (The phase shift)") ;
			    double dValue2 = c.readDouble() ;
			    c.println("Please enter the c value (The vertical shift)") ;
			    double cValue2 = c.readDouble() ;
			 
				c.println("What you have entered is: f(x) = " + aValue2 + " sin(" + kValue2 + "(x + " + dValue2 + ")) + " + cValue2) ;
	
		        c.println("\nPlease enter how many points you want to plot!") ;
		        int points2 = c.readInt() ;
	
		        double[] y2 = new double[points2] ;
		        double[] x2 = new double[points2] ;
		        double[] temp = new double[points2] ; //this is the non-transformed x-values the user entered
		        double[] temp2 = new double[points2] ; //this is the non-transformed x-values the user entered
		        kValue = (1 / kValue2) ;
		        dValue = (-1 * dValue2) ;
	
		        for (int i = 0 ; i < points2 ; i++) 
		        
		        {
		        	
		        	c.println("Enter x-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
			        x2[i] = c.readDouble() ;
			        temp[i] = x2[i] ;
		        	x2[i] = ((1 / kValue2) * x2[i]) + dValue2 ;
		        	c.println("Enter y-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
			        y2[i] = c.readDouble() ;
			        temp2[i] = y2[i] ;
		        	y2[i] = (aValue2 * y2[i]) + cValue2 ;
				 
		        }
		        
		        
		        
		        for (int i = 0 ; i < points2 ; i++)
		        	
		        {
		        	c.println("Point " + (i + 1) + ": " + "(" + temp[i] + " , " + temp2[i] + ") --> " + "(" + x2[i] + " , " + y2[i] + ")") ;
		        }
	        
		        break ;
			 
		 }
		 
	 }
  
	 public static void inverseTrigFunction()
	 
	 {
		 final DecimalFormat df = new DecimalFormat("0.00");
		 
		 c.println("Please enter if you want a sec or csc function") ;
		 String userInput = c.readLine() ;
		 
		 switch(userInput)
		 
		 {
		 
		 case "SEC", "sec" :
			 
				c.println("Please enter the a value (The amplitude)") ;
			    double aValue = c.readDouble() ;
			  	c.println("Please enter the k value (The period)") ;
			    double kValue = c.readDouble() ;
			    c.println("Please enter the d value (The phase shift)") ;
			    double dValue = c.readDouble() ;
			    c.println("Please enter the c value (The vertical shift)") ;
			    double cValue = c.readDouble() ;
			 
				c.println("What you have entered is: f(x) = " + aValue + " sec(" + kValue + "(x + " + dValue + ")) + " + cValue) ;
	
		        c.println("\nPlease enter how many points you want to plot!") ;
		        int points = c.readInt() ;
	
		        double[] y = new double[points] ;
		        double[] x = new double[points] ;
		        double[] temp3 = new double[points] ;
		        double[] temp4 = new double[points] ;
		        kValue = (1 / kValue) ;
		        dValue = (-1 * dValue) ;
	
		        for (int i = 0; i < points; i++) 
		        
		        {
		        	
		        	c.println("Enter x-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
			        x[i] = c.readDouble() ;
			        temp3[i] = x[i] ;
		        	x[i] = ((1 / kValue) * x[i]) + dValue ;
		        	c.println("Enter y-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
			        y[i] = c.readDouble() ;
			        temp4[i] = y[i] ;
		        	y[i] = (aValue * y[i]) + cValue ;
		            
		        }
		        
		        for (int i = 0 ; i < points ; i++)
		        	
		        {
		        	c.println("Point " + (i + 1) + ": " + "(" + temp3[i] + " , " + temp4[i] + ") --> " + "(" + x[i] + " , " + y[i] + ")") ;
		        }
		        
				 break ;

		 case "CSC", "csc" :
			 
				c.println("Please enter the a value (The amplitude)") ;
			    double aValue2 = c.readDouble() ;
			  	c.println("Please enter the k value (The period)") ;
			    double kValue2 = c.readDouble() ;
			    c.println("Please enter the d value (The phase shift)") ;
			    double dValue2 = c.readDouble() ;
			    c.println("Please enter the c value (The vertical shift)") ;
			    double cValue2 = c.readDouble() ;
			 
				c.println("What you have entered is: f(x) = " + aValue2 + " csc(" + kValue2 + "(x + " + dValue2 + ")) + " + cValue2) ;
	
		        c.println("\nPlease enter how many points you want to plot!") ;
		        int points2 = c.readInt() ;
	
		        double[] y2 = new double[points2] ;
		        double[] x2 = new double[points2] ;
		        double[] temp = new double[points2] ;
		        double[] temp2 = new double[points2] ;
		        kValue = (1 / kValue2) ;
		        dValue = (-1 * dValue2) ;
	
		        for (int i = 0 ; i < points2 ; i++) 
		        
		        {
		        	
		        	c.println("Enter x-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
			        x2[i] = c.readDouble() ;
			        temp[i] = x2[i] ;
		        	x2[i] = ((1 / kValue2) * x2[i]) + dValue2 ;
		        	c.println("Enter y-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
			        y2[i] = c.readDouble() ;
			        temp2[i] = y2[i] ;
		        	y2[i] = (aValue2 * y2[i]) + cValue2 ;
				 
		        }
		        
		        
		        
		        for (int i = 0 ; i < points2 ; i++)
		        	
		        {
		        	c.println("Point " + (i + 1) + ": " + "(" + temp[i] + " , " + temp2[i] + ") --> " + "(" + x2[i] + " , " + y2[i] + ")") ;
		        }
	        
		        break ;
		 }
		 
	 }
	 
	 public static void squareRootFunction()
	 
	 {
		 
		 	final DecimalFormat df = new DecimalFormat("0.00");

		 	c.println("Please enter the vertical stretch or compression (The \"a\" value)") ;
		    double aValue = c.readDouble() ;
		    c.println("Please enter the horizontal stretch or compression(The \"k\" value)") ;
		    double kValue = c.readDouble() ;
		    c.println("Please enter the vertical shift (The \"d\" value)") ;
		    double dValue = c.readDouble() ;
		    c.println("Please enter the horizontal shift (The \"c\" value)") ;
		    double cValue = c.readDouble() ;
		    
		    c.println("The function you have entered is: " + "f(x) = " + aValue + " √(" + kValue + "(x + " + dValue + ")) + " + cValue) ;

		    c.println("\nPlease enter how many points you want to plot!") ;
		    int points = c.readInt() ;

		    double[] y = new double[points] ; //defines the y value outside the for loop
		    double[] x = new double[points] ; //defines the x value outside the for loop
		    double[] temp = new double[points] ; //this is the non-transformed x-values the user entered
	        double[] temp2 = new double[points] ; //this is the non-transformed y-values the user entered
	        kValue = (1 / kValue) ;
	        dValue = (-1 * dValue) ;

		    //for loop gets the user top enter the x value, then calculates the y value based on that information
		    for (int i = 0 ; i < points ; i++)
		    
		    { //start of for loop
		    	
		    	c.println("Enter x-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
		        x[i] = c.readDouble() ; //gets the x value from the user
	            temp[i] = x[i] ;
	            x[i] = ((1 / kValue) * x[i]) + dValue ;
	        	c.println("Enter y-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
		        y[i] = c.readDouble() ; //gets the x value from the user
		        temp2[i] = y[i] ;
		        y[i] = (aValue * y[i]) + cValue ; //calculates the y value
		        
		    } //end of for loop
		    
		    for (int i = 0 ; i < points ; i++)
	        	
	        {
	        	c.println("Point " + (i + 1) + ": " + "(" + temp[i] + " , " + temp2[i] + ") --> " + "(" + x[i] + " , " + y[i] + ")") ;
	        }

	 }
	 
	 public static void logarithmicFunction()
	 
	 {
		 
		 	final DecimalFormat df = new DecimalFormat("0.00");
		 
		 	c.println("Please enter the vertical stretch or compression (The \"a\" value)") ;
		    double aValue = c.readDouble() ;
		    c.println("Please enter the horizontal stretch or compression(The \"k\" value)") ;
		    double kValue = c.readDouble() ;
		    c.println("Please enter the vertical shift (The \"d\" value)") ;
		    double dValue = c.readDouble() ;
		    c.println("Please enter the horizontal shift (The \"c\" value)") ;
		    double cValue = c.readDouble() ;
		    
		    c.println("The function you have entered is: " + "f(x) = " + aValue + " log(" + kValue + "(x + " + dValue + ")) + " + cValue) ;

		    c.println("\nPlease enter how many points you want to plot!") ;
		    int points = c.readInt() ;

		    double[] y = new double[points] ; //defines the y value outside the for loop
		    double[] x = new double[points] ; //defines the x value outside the for loop
		    double[] temp = new double[points] ; //this is the non-transformed x-values the user entered
	        double[] temp2 = new double[points] ; //this is the non-transformed y-values the user entered
	        kValue = (1 / kValue) ;
	        dValue = (-1 * dValue) ;

		    //for loop gets the user top enter the x value, then calculates the y value based on that information
		    for (int i = 0 ; i < points ; i++)
		    
		    { //start of for loop
		    	
		    	c.println("Enter x-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
		        x[i] = c.readDouble() ; //gets the x value from the user
	            temp[i] = x[i] ;
	            x[i] = ((1 / kValue) * x[i]) + dValue ;
	        	c.println("Enter y-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
		        y[i] = c.readDouble() ; //gets the x value from the user
		        temp2[i] = y[i] ;
		        y[i] = (aValue * y[i]) + cValue ; //calculates the y value
		        
		    } //end of for loop
		    
		    for (int i = 0 ; i < points ; i++)
	        	
	        {
	        	c.println("Point " + (i + 1) + ": " + "(" + temp[i] + " , " + temp2[i] + ") --> " + "(" + x[i] + " , " + y[i] + ")") ;
	        }
	 }
	 
	 public static void exponentialFunction()
	 
	 {
		 final DecimalFormat df = new DecimalFormat("0.00");
		 
		 	c.println("Please enter the vertical stretch or compression (The \"a\" value)") ;
		    double aValue = c.readDouble() ;
		    c.println("Please enter the horizontal stretch or compression(The \"k\" value)") ;
		    double kValue = c.readDouble() ;
		    c.println("Please enter the vertical shift (The \"d\" value)") ;
		    double dValue = c.readDouble() ;
		    c.println("Please enter the horizontal shift (The \"c\" value)") ;
		    double cValue = c.readDouble() ;
		    
		    c.println("The function you have entered is: " + "f(x) = " + aValue + " * 2^(" + kValue + "(x + " + dValue + ")) + " + cValue) ;

		    c.println("\nPlease enter how many points you want to plot!") ;
		    int points = c.readInt() ;

		    double[] y = new double[points] ; //defines the y value outside the for loop
		    double[] x = new double[points] ; //defines the x value outside the for loop
		    double[] temp = new double[points] ; //this is the non-transformed x-values the user entered
	        double[] temp2 = new double[points] ; //this is the non-transformed y-values the user entered
	        kValue = (1 / kValue) ;
	        dValue = (-1 * dValue) ;

		    //for loop gets the user top enter the x value, then calculates the y value based on that information
		    for (int i = 0 ; i < points ; i++)
		    
		    { //start of for loop
		    	
		    	c.println("Enter x-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
		        x[i] = c.readDouble() ; //gets the x value from the user
	            temp[i] = x[i] ;
	            x[i] = ((1 / kValue) * x[i]) + dValue ;
	        	c.println("Enter y-coordinate for point " + (i + 1) + "(use the non-transformed graph for points you want to be transformed) :") ;
		        y[i] = c.readDouble() ; //gets the x value from the user
		        temp2[i] = y[i] ;
		        y[i] = (aValue * y[i]) + cValue ; //calculates the y value
		        
		    } //end of for loop
		    
		    for (int i = 0 ; i < points ; i++)
	        	
	        {
	        	c.println("Point " + (i + 1) + ": " + "(" + temp[i] + " , " + temp2[i] + ") --> " + "(" + x[i] + " , " + y[i] + ")") ;
	        } 
	 
	 }
	 
} //end of class
		 
		 
