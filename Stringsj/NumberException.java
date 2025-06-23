package Java_Strings;

public class NumberException {
    public static void main(String[] args) {
        String invalidNumber = "123abc"; 
        try {
            
            int number = Integer.parseInt(invalidNumber); 
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }

    
}
