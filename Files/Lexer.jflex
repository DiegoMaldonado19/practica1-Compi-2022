/* Codigo del Usuario */

package analizadores;

import java.util.*;

import java_cup.runtime.*;
import modelo.Token;

%%

/* Configuracion */

%public
%class Lexer
%unicode
%line
%column
%cup
%cupdebug

ESPACIO_BLANCO = [\s\t\r\n]+

DEF = (D|d)ef
BARRAS = Barras
PIE = Pie
TITULO = titulo
EJE_X = ejex
EJE_Y = ejey
ETIQUETAS = etiquetas
VALORES = valores
UNIR = unir
TIPO = tipo
CANTIDAD = Cantidad
PORCENTAJE = Porcentaje
TOTAL = total
EXTRA = extra
EJECUTAR = Ejecutar

MAS = "+"
MENOS = "-"
ALMOHADILLA = "*"
DIAGONAL = "/"

PARENTESIS_A = "("
PARENTESIS_C = ")"

CORCHETE_A = "["
CORCHETE_C = "]"

LLAVE_A = "{"
LLAVE_C = "}"

COMILLA = "\""

COMA = ","
PUNTO_COMA = ";"
DOS_PUNTOS = ":"

COMENTARIO = [#]([a-zA-z]|[0-9]|[ ])+([a-zA-z]|[0-9]|[ ])*

NUMERO = ([0-9])+
DECIMAL = ([0-9])+[.]([0-9])+

IDENTIFICADOR = ([a-zA-z]|[0-9])+([a-zA-z]|[0-9])*


%{
    private ArrayList<String>  errorList;  
%}

%{
    private Symbol symbol(int type){
        String lexeme = yytext();
        return new Symbol( type, new Token(lexeme, yyline + 1, yycolumn +1) );
    }

    private Symbol symbol(int type, String lexeme){
        return new Symbol( type, new Token(lexeme, yyline + 1, yycolumn + 1) );
    }

    private void error(String lexeme){
        errorList.add(String.format("Error lexico en el texto: , %s, linea %d, columna %d, corrige e intenta de nuevo :)", lexeme, yyline+1, yycolumn+1));
    }

    public ArrayList<String> getErrorList(){
        return errorList;
    }
%}

%init{
    errorList = new ArrayList();    
%init}


%%

/* Reglas lexicas */

<YYINITIAL> {
    {DEF}  { return symbol(sym.DEF, yytext());}

    {BARRAS}  { return symbol(sym.BARRAS, yytext()); }

    {PIE}  { return symbol(sym.PIE, yytext());}

    {ESPACIO_BLANCO}  { /*Ignoramos*/ }

    {TITULO}  { return symbol(sym.TITULO, yytext()); }

    {EJE_X}  { return symbol(sym.EJE_X, yytext()); }

    {EJE_Y}  { return symbol(sym.EJE_Y, yytext());}

    {ETIQUETAS}  { return symbol(sym.ETIQUETAS, yytext());}

    {VALORES}  { return symbol(sym.VALORES, yytext());}

    {UNIR}  { return symbol(sym.UNIR, yytext());}

    {TIPO}  { return symbol(sym.TIPO, yytext());}

    {CANTIDAD}  { return symbol(sym.CANTIDAD, yytext());}

    {PORCENTAJE}  { return symbol(sym.PORCENTAJE, yytext());}

    {TOTAL}  { return symbol(sym.TOTAL, yytext());}

    {EXTRA}  { return symbol(sym.EXTRA, yytext());}

    {EJECUTAR}  { return symbol(sym.EJECUTAR, yytext());}

    {MAS}  { return symbol(sym.MAS, yytext());}

    {MENOS}  { return symbol(sym.MENOS, yytext());}

    {ALMOHADILLA}  { return symbol(sym.ALMOHADILLA, yytext());}

    {DIAGONAL}  { return symbol(sym.DIAGONAL, yytext());}

    {PARENTESIS_A}  { return symbol(sym.PARENTESIS_A, yytext());}

    {PARENTESIS_C}  { return symbol(sym.PARENTESIS_C, yytext());}

    {CORCHETE_A}  { return symbol(sym.CORCHETE_A, yytext());}

    {CORCHETE_C}  { return symbol(sym.CORCHETE_C, yytext());}

    {LLAVE_A}  { return symbol(sym.LLAVE_A, yytext());}

    {LLAVE_C}  { return symbol(sym.LLAVE_C, yytext());}

    {COMILLA}  { return symbol(sym.COMILLA, yytext());}

    {COMA}      { return symbol(sym.COMA, yytext());  }

    {PUNTO_COMA}  { return symbol(sym.PUNTO_COMA, yytext());}

    {DOS_PUNTOS}  { return symbol(sym.DOS_PUNTOS, yytext());}

    {COMENTARIO}  { return symbol(sym.COMENTARIO, yytext());}

    {NUMERO}  { return symbol(sym.NUMERO, yytext());}

    {DECIMAL}  { return symbol(sym.DECIMAL, yytext());}

    {IDENTIFICADOR}  { return symbol(sym.IDENTIFICADOR, yytext());}

}

[^]   { error(yytext()); return symbol(sym.ERROR, yytext());}


<<EOF>>         { return symbol(sym.EOF); }