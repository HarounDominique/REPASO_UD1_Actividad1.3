package ad.teis.model;

import java.io.*;
import java.util.Scanner;

public class DataIOPersistencia implements Persistencia {

    @Override
    public void escribirPersona(Persona persona, String ruta) {
        File fichero = new File(ruta);
        if (!fichero.exists()) {
            try {
                fichero.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (
                FileOutputStream fos = new FileOutputStream(fichero);
                DataOutputStream dos = new DataOutputStream(fos);
        ) {
            dos.writeLong(persona.getId());
            dos.writeChars(persona.getDni());
            dos.writeInt(persona.getEdad());
            dos.writeFloat(persona.getSalario());
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Override
    public Persona leerDatos(String ruta) {
        long id = 0;
        char caracter;
        String dni = "";
        StringBuilder sb = new StringBuilder();
        int edad = 0;
        float salario = 0;
        Persona personaRecuperada = null;

        try(
                FileInputStream fis = new FileInputStream(ruta);
                DataInputStream dis = new DataInputStream(fis))
        {

            id = dis.readLong();

            for(int i = 0; i<9; i++){
                caracter = dis.readChar();
                //dni.concat(String.valueOf(caracter));
                sb.append(caracter);
            }
            dni = sb.toString();

            edad = dis.readInt();

            salario = dis.readFloat();

            personaRecuperada = new Persona(id, dni, edad, salario);

        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }

        return personaRecuperada;
    }
}
