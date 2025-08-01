import java.io.*;

public class DataStreams {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("students.dat"))) {
            dos.writeInt(1);
            dos.writeUTF("Alice");
            dos.writeDouble(3.9);

            dos.writeInt(2);
            dos.writeUTF("Bob");
            dos.writeDouble(3.5);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("students.dat"))) {
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println(roll + " " + name + " " + gpa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}