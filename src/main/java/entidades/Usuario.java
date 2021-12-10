package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class Usuario implements Serializable{

   
    @Id
    private String usuario;
    
    @Column
    private String contrasena;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


}
