package diff.io;

import java.io.*;
import java.math.BigDecimal;

public class DataStream {
    private static final String file = "/tmp/output_java.txt";

    private static BigDecimal[] prices = {new BigDecimal(13.33), new BigDecimal(42.8), new BigDecimal(24.59)};
    private static int[] units = {1, 2, 3};
    private static String[] names = {"one", "two", "three"};

    public static void main(String[] args) throws IOException {
        write();
        read();
    }

    static void write() throws IOException {
        //DataOutputStream out = null;
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            for (int i = 0; i < prices.length; i++) {
                out.writeObject(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(names[i]);
            }
        } finally {
            if (out != null) out.close();
        }
    }

    static void read() throws IOException {
        //DataInputStream in = null;
        ObjectInputStream in = null;

        BigDecimal price;
        int unit;
        String name;

        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

            while (true) {
                price = (BigDecimal) in.readObject();
                unit = in.readInt();
                name = in.readUTF();

                System.out.printf("%f %d %s\n", price, unit, name);
            }
        } catch (EOFException e) {

        } catch (ClassNotFoundException e) {

        } finally {
            if (in != null) in.close();
        }
    }
}
