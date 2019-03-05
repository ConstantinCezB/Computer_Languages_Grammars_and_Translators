import java.nio.file.*;
%%
%{
    static int[] _ = {0,0,0,0,0,0};
    public static void main(String[] _7) throws Exception {
        new A2(new java.io.FileReader("A2.input")).yylex();
        Files.write(Paths.get("A2.output"), ("identifiers: " + _[0] + "\nkeywords: " + _[1] + "\nnumbers: " + _[2] + "\ncomments: " + _[3] + "\nquotedString: " + _[4]).getBytes());
    }
%}

%class A2
%integer
%state _1,_2
%%
<YYINITIAL>. {yybegin(_2);}
<_2> "/**"                                                            {_[3]++;yybegin(_1);}
<_2> \"[^\"]*\"                                                       {_[4]++;}
<_2> [a-zA-Z][a-zA-Z0-9]*                                             {_[5]=(java.util.Arrays.asList("WRITEzREADzIFzELSEzRETURNzBEGINzENDzMAINzSTRINGzINTzREAL".split("z")).contains(yytext()))?_[1]++:_[0]++;}
<_2> [0-9]+(\.[0-9]+)?                                                {_[2]++;}
<_1>   "**/"                                                          {yybegin(_2);}
\r|\n|.                                                               {}