import ad.teis.model.DataIOPersistencia;
import ad.teis.model.Persona;

public class Main {
    public static void main(String[] args) {
        Persona p = new Persona(3,"aaaaaaaa7", 20, 5000);
        DataIOPersistencia diop = new DataIOPersistencia();
        diop.escribirPersona(p,"D:\\IdeaProjects\\UD1_Actividad1.3\\fichero.dat");
        System.out.println(diop.leerDatos("D:\\IdeaProjects\\UD1_Actividad1.3\\fichero.dat").toString());
    }
}
