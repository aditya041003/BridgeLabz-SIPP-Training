import java.io.*;

public class ReadWriteTextFile {
    public static void main(String[] args) {
        File sourceFile = new File("source.txt");
        File destFile = new File("destination.txt");

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}