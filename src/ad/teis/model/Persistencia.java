package ad.teis.model;

public interface Persistencia {
    void escribirPersona(Persona persona, String ruta);
    Persona leerDatos(String ruta);
}
