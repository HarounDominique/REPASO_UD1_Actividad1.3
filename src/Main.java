import ad.teis.model.DataIOPersistencia;
import ad.teis.model.Persona;
import ad.teis.model.RandomAccessPersistencia;

public class Main {
    public static void main(String[] args) {

        Persona p = new Persona(3,"aaaaaaaa7", 20, 5000);
        /*
        DataIOPersistencia diop = new DataIOPersistencia();
        diop.escribirPersona(p,"D:\\IdeaProjects\\UD1_Actividad1.3\\fichero.dat");
        System.out.println(diop.leerDatos("D:\\IdeaProjects\\UD1_Actividad1.3\\fichero.dat").toString());
         */
        RandomAccessPersistencia rap = new RandomAccessPersistencia();
        rap.escribirPersona(p, "D:\\IdeaProjects\\UD1_Actividad1.3\\fichero.dat");
        System.out.println(rap.leerDatos("D:\\IdeaProjects\\UD1_Actividad1.3\\fichero.dat").toString());

    }
}
