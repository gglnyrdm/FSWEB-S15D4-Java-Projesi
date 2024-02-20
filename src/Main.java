import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println("checkForPalindrome");
        System.out.print("\t " + checkForPalindrome("BONNOB"));
        System.out.print("\t " + checkForPalindrome("Is it a palindrom word?"));System.out.println("\ncheckForPalindromeFIFO");
        System.out.print("\t " + checkForPalindrome("on no , on no"));
        System.out.print(checkForPalindromeFIFO("BONNOB"));
        System.out.print(checkForPalindromeFIFO("Is it a palindrom word?"));
        System.out.print(checkForPalindromeFIFO("on no , on no"));
        System.out.println("\n--------------------");
        System.out.println("convertDecimalToBinary");
        System.out.println("\t13 için -> " + convertDecimalToBinary(13));
        System.out.println("\t5 için -> " + convertDecimalToBinary(5));
        System.out.println("\t6 için -> " + convertDecimalToBinary(6));
        System.out.println("\t75 için -> " + convertDecimalToBinary(75));
       
    }

    public static boolean checkForPalindrome(String text) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder noPunctionString = new StringBuilder();
        String lowerCase = text.toLowerCase(Locale.ENGLISH);

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                noPunctionString.append(c);
                stack.push(c);
            }
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return noPunctionString.toString().equals(reversed.toString());
    }

    public static boolean checkForPalindromeFIFO(String text) {
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        String lowerCase = text.toLowerCase(Locale.ENGLISH);


        for(int i = 0; i < lowerCase.length(); i++){
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c <= 'z'){
                queue.addLast(c);
                stack.push(c);
            }
        }
        if(stack.equals(queue)){
            System.out.print("\tEQUAL -> ");
        } else{
            System.out.print("\tNOT EQUAL  -> ");
        }

        while(!stack.isEmpty()){
            if(!stack.pop().equals(queue.removeFirst())){
                return false;
            }
        }
        return true;
    }

    public static String convertDecimalToBinary(int num){

        final int base = 2;
        Stack digits = new Stack();

        while(num > 0){
            //[1, 1, 0, 1]
            digits.push(num % base);
            num = num / base;
        }

        String bits = "";
        while (!digits.isEmpty()){
            bits += digits.pop();
        }
        digits.toString();
        return bits;
    }
}