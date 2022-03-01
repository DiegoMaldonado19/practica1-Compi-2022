package controlador;

public class Manejador {
    /**
     * Clase manejador que sirve para recoger los lexemas de nuestro analizador sintactico
     */

    /**
     * Variable que almacena el lexema del token
     */
    private String lexeme;
    private int tipo;

    /**
     * Constructor de la clase
     * @param lexeme       lexema del token
     * @param tipo          tipo al que pertenece
     */
    public Manejador(String lexeme, int tipo){
        this.lexeme = lexeme;
        this.tipo = tipo;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Manejador{" +
                "lexeme='" + lexeme + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}

