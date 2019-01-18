package Assignment_1;

import java.nio.file.*;
import java.util.*;

public class A11 {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(args[0])));
        StringTokenizer st = new StringTokenizer(content, " !@#$%^&*()_+-=:;<>,?/'{}[]|\\~`\n");
        LinkedHashSet<String> identifiersUsed = new LinkedHashSet<>(Arrays.asList("WRITE", "READ", "IF", "ELSE", "RETURN", "BEGIN", "END", "MAIN", "STRING", "INT", "REAL"));
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            if (isAlphaAndNum(temp)) identifiersUsed.add(temp);
        }
        Files.write(Paths.get("./A1.output"), ("Identifiers: " + (identifiersUsed.size() - 11)).getBytes());
    }

    private static boolean isAlphaAndNum(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) if (!(Character.isLetter(c) || Character.isDigit(c))) return false;
        return true;
    }
}