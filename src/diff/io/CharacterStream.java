package diff.io;

import java.io.*;

public class CharacterStream {
    private static final String file = "src/diff/io/test.txt";
    private static final String outputFile = "/tmp/output_java.txt";

    public static void main(String[] args) throws IOException {
        //CharacterStream.characters();
        CharacterStream.lines();
    }

    static void characters() throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader(file);
            outputStream = new FileWriter(outputFile);

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }

        } finally {
            if (inputStream != null) inputStream.close();
            if (outputStream != null) outputStream.close();
        }
    }

    static void lines() throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader(file));
            outputStream = new PrintWriter(new FileWriter(outputFile));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }

        } finally {
            if (inputStream != null) inputStream.close();
            if (outputStream != null) outputStream.close();
        }
    }
}
