package Assignment_1;

import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class A12 {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(args[0])));
        Pattern p = Pattern.compile("([a-zA-Z][a-zA-Z0-9]*)|(\"[^\"]*\")");
        LinkedHashSet<String> identifiersUsed = new LinkedHashSet<>(Arrays.asList("WRITE", "READ", "IF", "ELSE", "RETURN", "BEGIN", "END", "MAIN", "STRING", "INT", "REAL"));
        Matcher m = p.matcher(content);
        while (m.find()) if (!m.group().startsWith("\"")) identifiersUsed.add(m.group());
        Files.write(Paths.get("./A1.output"), ("Identifiers: " + (identifiersUsed.size() - 11)).getBytes());
    }
}