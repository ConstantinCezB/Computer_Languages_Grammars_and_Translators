package Assignment_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Assignment_1 {

    private static LinkedList<String> readText(String path) {
        LinkedList<String> ans = new LinkedList<>();
        FileReader in;

        try {
            in = new FileReader("src/TextCasesAssignment1/" + path);
            BufferedReader br = new BufferedReader(in);

            String line;
            while ((line = br.readLine()) != null) {
                ans.add(line);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    private static void writeText(String toWrite, String path) {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/TextOutputAssignment1/" + path);

            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(toWrite);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static int countIdentifiersStringToken(LinkedList<String> content) {
        int countIdentifiers = 0;
        String delimiter = " !@#$%^&*()_+-=:;<>,.?/'{}[]|\\~`";
        String[] keyWords = {"WRITE", "READ", "IF", "ELSE", "RETURN", "BEGIN", "END", "MAIN", "STRING", "INT", "REAL"};
        ArrayList<String> delimitersUsed = new ArrayList<>();

        for (String line : content) {
            StringTokenizer st = new StringTokenizer(line, delimiter);
            while (st.hasMoreTokens()) {
                String temp = st.nextToken();
                if (!Arrays.asList(keyWords).contains(temp) && !delimitersUsed.contains(temp) && startsAlpha(temp) && isAlphaAndNum(temp)) {
                    delimitersUsed.add(temp);
                    countIdentifiers++;
                }
            }
        }
        return countIdentifiers;
    }

    private static int countIdentifiersRegex(LinkedList<String> content) {
        int countIdentifiers = 0;
        ArrayList<String> delimitersUsed = new ArrayList<>();
        String[] temp;

        for (String line : content) {
            temp = line.split("(WRITE)|(READ)|(IF)|(ELSE)|(RETURN)|(BEGIN)|(END)|(MAIN)|(STRING)|(INT)|(REAL)|\\s|(\".*\")|[^a-zA-Z0-9]");
            for (String word : temp) {
                if (!delimitersUsed.contains(word) && !word.isBlank()) {
                    delimitersUsed.add(word);
                    countIdentifiers++;
                }
            }
        }
        return countIdentifiers;
    }

    private static boolean isAlphaAndNum(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!(Character.isLetter(c) || Character.isDigit(c))) {
                return false;
            }
        }
        return true;
    }

    private static boolean startsAlpha(String name) {
        return Character.isLetter(name.charAt(0));
    }

    private static String prepareAnsForText(int num, String caseName) {
        return caseName + "\nidentifiers:" + num;
    }

    private static void testCases(int method) {
        File folder = new File("src/TextCasesAssignment1");
        File[] listOfFiles = folder.listFiles();
        int countIdentifiers = 0;

        if (listOfFiles == null) {
            return;
        }

        String pathRead, pathWrite;
        for (int i = 1; i <= listOfFiles.length; i++) {
            pathRead = listOfFiles[i - 1].getName();
            pathWrite = "output" + i + ".txt";

            if (method == 0){
                countIdentifiers = countIdentifiersStringToken(readText(pathRead));
            }else if (method == 1) {
                countIdentifiers = countIdentifiersRegex(readText(pathRead));
            }
            writeText(prepareAnsForText(countIdentifiers, pathRead), pathWrite);
        }
    }

    public static void main(String[] args) {
        testCases(1);
    }
}
