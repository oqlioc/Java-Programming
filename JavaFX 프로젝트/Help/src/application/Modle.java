package application;

public class Modle {

   public int calculate(String operator, int x) {
      if (operator.equals( "반장" )) {
         return 4*4*(1000 + ( x * 100));         
      }else if (operator.equals( "팀장" )) {
         return 4*4*(1000 + ( x * 100));         
      }else if (operator.equals( "부팀장" )) {
         return 2*4*(1000 + ( x * 100));         
      }else{
         return 4*(1000 + ( x * 100));         
      }
   }
}
