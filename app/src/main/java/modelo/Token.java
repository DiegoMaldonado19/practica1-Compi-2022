package modelo;

public class Token {
    /**
     * Clase destinada para la creacion de tokens
     */

    /**
     * Variables para almacenar un lexema, una linea y una columna
     */
    private String lexeme;
    private int line;
    private int column;

    /**
     * Constructor de la clase
     * @param lexeme    lexema que contiene el token
     * @param line      linea donde se encuentra
     * @param column    columna donde se encuentra
     */
    public Token(String lexeme, int line, int column){
        this.lexeme = lexeme;
        this.line = line;
        this.column = column;
    }

    /**
     * Metodos getter y setter de la clase
     * @return
     */

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Token{" +
                "lexeme='" + lexeme + '\'' +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
