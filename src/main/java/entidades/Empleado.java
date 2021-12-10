package entidades;

import javax.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    private long clave;

    @Column
    private String nombre;

    @Column
    private String direccion;

    @Column
    private String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }
    
}
