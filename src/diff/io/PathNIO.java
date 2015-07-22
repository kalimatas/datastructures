package diff.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathNIO {
    private static final String file = "test.txt";

    public static void main(String[] args) {
        Path current = Paths.get(".");

        Path path = Paths.get(file);
        System.out.println(path.toAbsolutePath());

        Path absPath = Paths.get(path.toAbsolutePath().toString());
        System.out.println(absPath.getParent());

        System.out.println(absPath.getParent().resolve("nofile"));

        System.out.println(absPath.getParent().equals(current));

        for (Path part : absPath.getParent()) {
            System.out.println(part);
        }
    }
}
