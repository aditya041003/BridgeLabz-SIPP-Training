import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("original.jpg");
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream("copy.jpg")) {
                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}