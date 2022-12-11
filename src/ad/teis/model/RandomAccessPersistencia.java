package ad.teis.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessPersistencia implements Persistencia {
    @Override
    public void escribirPersona(Persona persona, String ruta) {
        try (
                RandomAccessFile raf = new RandomAccessFile(new File(ruta), "rw")
        ) {
            raf.writeLong(persona.getId());
            StringBuilder sb = new StringBuilder(persona.getDni());
            sb.setLength(persona.getDni().length()); //este valor es igual a 9
            raf.writeChars(sb.toString());
            raf.writeInt(persona.getEdad());
            raf.writeFloat(persona.getSalario());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Persona leerDatos(String ruta) {
        Persona personaRecuperada = null;
        long id = 0;
        String dni = "";
        int edad = 0;
        float salario = 0;
        StringBuilder sb = new StringBuilder();
        try (
                RandomAccessFile raf = new RandomAccessFile(ruta, "rw")
        ) {
            id = raf.readLong();

            for (int i = 0; i < 8; i++) {
                sb.append(raf.readChar());
            }

            dni = sb.toString();

            edad = raf.readInt();

            salario = raf.readFloat();

            personaRecuperada = new Persona(id, dni, edad, salario);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return personaRecuperada;
    }
}
