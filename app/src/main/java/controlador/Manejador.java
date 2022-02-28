package controlador;

public class Manejador {
    /**
     * Clase manejador que sirve para recoger los lexemas de nuestro analizador sintactico
     */

    /**
     * Variable que almacena el lexema del token
     */
    private String lexeme;

    /**
     * Constructor de la clase
     * @param lexeme    lexema de un token especifico
     */
    public Manejador(String lexeme){
        this.lexeme = lexeme;
    }

    /**
     * Getters y setters
     * @return
     */

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        return "Manejador{" +
                "lexeme='" + lexeme + '\'' +
                '}';
    }
}

