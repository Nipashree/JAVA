import java . util . Scanner ;

public class QuickSortNames {
public static void quickSort ( String [] names , int low , int high ) {
 if ( low < high ) {
 int pivotIndex = partition ( names , low , high ) ;
 quickSort ( names , low , pivotIndex - 1) ;
 quickSort ( names , pivotIndex + 1 , high ) ;
 }
  
 public static int partition ( String [] names , int low , int high ) {
 String pivot = names [ high ]; // Choosing last element as pivot
 int i = low - 1;

 for (int j = low ; j < high ; j ++) {
 if ( names [ j ]. compareToIgnoreCase ( pivot ) < 0) {
 i ++;

 String temp = names [ i ];
 names [ i ] = names [ j ];
 names [ j ] = temp ;
 }
 }
  String temp = names [ i + 1];
 names [ i + 1] = names [ high ];
 names [ high ] = temp ;

 return i + 1;
 }

 public static void main ( String [] args ) {
 Scanner scanner = new Scanner ( System . in ) ;

 System . out . print (" Enter number of names : ") ;
 int n = scanner . nextInt () ;
 scanner . nextLine () ; // Consume newline

 String [] names = new String [ n ];
System . out . println (" Enter the names :") ;
 for (int i = 0; i < n ; i ++) {
 names [ i ] = scanner . nextLine () ;
 }
 quickSort ( names , 0 , n - 1) ;


 System . out . println (" Sorted Names :") ;
 for ( String name : names ) {
 System . out . println ( name ) ;
 }

 scanner . close () ;
 }
}
