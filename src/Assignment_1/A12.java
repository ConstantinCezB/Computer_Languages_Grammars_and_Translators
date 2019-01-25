package Assignment_1;

import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class A12 {
    public static void main(String[] args) throws Exception {
        Pattern p = Pattern.compile("([a-zA-Z][a-zA-Z0-9]*)|(\"[^\"]*\")");
        LinkedHashSet i = new LinkedHashSet(Arrays.asList("WRITEaREADaIFaELSEaRETURNaBEGINaENDaMAINaSTRINGaINTaREAL".split("a")));
        Matcher m = p.matcher(new String(Files.readAllBytes(Paths.get(args[0]))));
        while (m.find()) if (!m.group().startsWith("\"")) i.add(m.group());
        Files.write(Paths.get("./A1.output"), ("Identifiers: " + (i.size() - 11)).getBytes());
    }
}