package entidades;

import javax.persistence.*;

@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    private long clave;
    
    @Column
    private String titulo;

    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String nombre) {
        this.titulo = nombre;
    }

}
