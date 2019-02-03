import java.io.*;
import java.nio.file.*;
%%
%{
    static int[] count = {0,0,0,0,0};
    public static void main(String[] args) throws IOException {
        A2 y = new A2(new FileReader("A2.input"));
        while (y.yylex() > y.YYEOF);
        Files.write(Paths.get("A2.output"), ("identifiers: " + count[0] + "\nkeywords: " + count[1] + "\nnumbers: " + count[2] + "\ncomments: " + count[3] + "\nquotedString: " + count[4]).getBytes());
    }
%}

%class A2
%integer
%state COMMENT
%%
<YYINITIAL> "/**"                                                            {count[3]++;yybegin(COMMENT);}
<YYINITIAL> \"[^\"]*\"                                                       {count[4]++;}
<YYINITIAL> WRITE|READ|IF|ELSE|RETURN|BEGIN|END|MAIN|STRING|INT|REAL         {count[1]++;}
<YYINITIAL> [a-zA-Z][a-zA-Z0-9]*                                             {count[0]++;}
<YYINITIAL> [0-9]+(\.[0-9]+)?                                                {count[2]++;}
<COMMENT>   "**/"                                                            {yybegin(YYINITIAL);}
\r|\n|.                                                                      {}