package ad.teis.model;

public class Persona {
    long id;
    String dni;
    int edad;
    float salario;

    public Persona(long id, String dni, int edad, float salario) {
        this.id = id;
        this.dni = dni;
        this.edad = edad;
        this.salario = salario;
        if(!dniCheck(dni)){
            this.dni="00000000A";
        }
    }

    public boolean dniCheck(String id) {
        if (id.matches("[0-9]{8}[A-Za-z]")) {
            return true;
        } else {
            return false;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}