import java.io.*;

public class ReadUserInput {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("user.txt")) {

            System.out.print("Enter your name: ");
            String name = reader.readLine();
            System.out.print("Enter your age: ");
            int age = Integer.parseInt(reader.readLine());
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Language: " + language + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}