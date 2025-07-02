    //CP - Write a program to demonstrate StringIndexOutOfBoundsException
public class StringException {          

    public static void main(String[] args) {
        String str = "Hello, World!";
        try {
            // Attempt to access an index that is out of bounds
            char ch = str.charAt(20); // This will throw StringIndexOutOfBoundsException
            System.out.println("Character at index 20: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
}