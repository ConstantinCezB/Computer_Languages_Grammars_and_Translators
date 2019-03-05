import java_cup.runtime.*;

%%
%{
  Symbol _1000(int _101) {
    return new Symbol(_101);
  }
%}

%implements Scanner
%type Symbol
%function next_token
%class A3Scanner

%init{
 yybegin(_____);
%init}

%state __, _____

______=a-zA-Z
_______=0-9
________=\t|\r|\n|" "

%%

<_____>"/**" {yybegin(__);}
<__> "**/" {yybegin(_____);}

<_____>\"[^\"]*\" { return _1000(2); }

<_____>"RETURN" {return _1000(22);}
<_____>"BEGIN" {return _1000(19);}
<_____>"END" {return _1000(20);}
<_____>"MAIN" {return _1000(21);}
<_____>"STRING" {return _1000(16);}
<_____>"INT" {return _1000(14);}
<_____>"WRITE" {return _1000(26);}
<_____>"READ" {return _1000(25);}
<_____>"IF" {return _1000(23);}
<_____>"ELSE" {return _1000(24);}

<_____>"REAL" {return _1000(15);}

<_____>[{_______}]*(\.[{_______}]+)? {return _1000(18);}

<_____>[{______}][{______}{_______}]* { return _1000(17); }

<_____>")" {return _1000(6);}
<_____>"+" {return _1000(7);}
<_____>"-" {return _1000(8);}
<_____>"*" {return _1000(9);}
<_____>"/" {return _1000(10);}
<_____>":=" {return _1000(11);}
<_____>";" {return _1000(3);}
<_____>"," {return _1000(4);}
<_____>"(" {return _1000(5);}
<_____>"==" {return _1000(12);}
<_____>"!=" {return _1000(13);}

<_____>{________} {}
<_____>. {return _1000(1);}
{________} {}
. {}