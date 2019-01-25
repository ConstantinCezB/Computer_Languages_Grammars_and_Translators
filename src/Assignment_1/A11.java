package Assignment_1;

import java.nio.file.*;
import java.util.*;

public class A11 {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(args[0])));
        LinkedHashSet<String> identifiersUsed = new LinkedHashSet<>(Arrays.asList("WRITE", "READ", "IF", "ELSE", "RETURN", "BEGIN", "END", "MAIN", "STRING", "INT", "REAL"));
        int start = 0, pos;
        boolean found = false;

        for (int i = 0; i < content.length(); i++){
            char c = content.charAt(i);
            if(Character.isLetter(c) && !found){
                found = true;
                start = i;
            }
            if (c == '"') {
                if ((pos = isQuoted(content.substring(i + 1), i))!= -1) i = pos;
            }
            if (!Character.isLetterOrDigit(c) && found) {
                    found = false;
                    identifiersUsed.add(content.substring(start, i));
            }
        }
        Files.write(Paths.get("./A1.output"), ("Identifiers: " + (identifiersUsed.size() - 11)).getBytes());
    }
    private static int isQuoted(String content, int start){
        for (int i = 0; i < content.length(); i++) if (content.charAt(i) == '"') return ++i + start;
        return -1;
    }
}