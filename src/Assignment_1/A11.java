package Assignment_1;

import java.io.*;
import java.util.*;

public class A11 {
    public static  void main (String[] args) throws Exception {
        String content = new Scanner(new File("filename")).useDelimiter("\\Z").next();
        StringTokenizer st = new StringTokenizer(content, " !@#$%^&*()_+-=:;<>,.?/'{}[]|\\~`");
        LinkedHashSet<String> identifiersUsed = new LinkedHashSet<>(Arrays.asList("WRITE", "READ", "IF", "ELSE", "RETURN", "BEGIN", "END", "MAIN", "STRING", "INT", "REAL"));
        while (st.hasMoreTokens()){
            String temp = st.nextToken();
            if (!identifiersUsed.contains(temp) && isAlphaAndNum(temp)) {
                identifiersUsed.add(temp);
            }
        }
        System.out.println(identifiersUsed.size() - 11);

    }
    @SuppressWarnings("Duplicates")
    private static boolean isAlphaAndNum(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(name.charAt(0)) && (!(Character.isLetter(c) || Character.isDigit(c)))) {
                return false;
            }
        }
        return true;
    }
}