import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("largefile.txt"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copiedfile.txt"))) {

            byte[] buffer = new byte[4096];
            long start = System.nanoTime();

            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();
            System.out.println("Buffered copy completed in " + (end - start) / 1_000_000 + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}