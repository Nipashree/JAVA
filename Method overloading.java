class Adder {
 // Method to add two integers
 int add (int a , int b ) {
 return a + b ;
 }

 // Method to add two floating - point numbers
 float add ( float a , float b ) {
 return a + b ;
 }
 }

 // Main class
 public class MethodOverloadingDemo {
 public static void main ( String [] args ) {
 Adder adder = new Adder () ;

 // Calling overloaded methods
 int intSum = adder . add (10 , 20) ;
 float floatSum = adder . add (5.5 f , 2.3 f ) ;

 // Displaying results
 System . out . println ("Sum of two integers : " + intSum ) ;
 System . out . println ("Sum of two floats : " + floatSum ) ;
 }
 }
