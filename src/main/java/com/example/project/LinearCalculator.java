package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1=0;
    private int x2=0;
    private int y1=0;
    private int y2=0;

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String point1, String point2){ // <--add 2 string parameters to this constructor
     this.x1=Integer.parseInt(point1.substring(1,point1.indexOf(","))); //pull out value of x1
     this.y1=Integer.parseInt(point1.substring(point1.indexOf(",")+1,point1.indexOf(")"))); 
     this.x2=Integer.parseInt(point2.substring(1,point2.indexOf(","))); 
     this.y2=Integer.parseInt(point2.substring(point2.indexOf(",")+1,point2.indexOf(")"))); 
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int x1){this.x1 = x1;}
    public void setY1(int y1){this.y1 = y1;}
    public void setX2(int x2){this.x2 = x2;}
    public void setY2(int y2){this.y2 = y2;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double dist = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
        return roundedToHundredth(dist);
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        double slope = slope();
        if (slope == -999.99){return -999.99;}
        return roundedToHundredth (y1 - slope()* x1);
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
       if (x2-x1 == 0){return -999.99;}
       double slope =(double) (y2-y1)/(x2-x1);
       return roundedToHundredth(slope);
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
    if (yInt() == -999.99) {return "undefined";}
    else if (yInt() == 0) {return "y=" + slope() + "x";}
    else if (slope() == 0) {return "y=" + yInt();}
    else if (yInt() < 0) {return "y=" + slope() + "x" + yInt();}
    else {return "y=" + slope() + "x+" + yInt();} 
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return Math.round(x*100.0) / 100.0;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
 
        return str;
    }



}