package com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Usuario;
import com.models.SessionUtils;
import com.models.UsuariosModel;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;
    public Usuario user;

    public LoginBean() {
        user = new Usuario();
    }

    public String acceder() {
        UsuariosModel usuariosModel = new UsuariosModel();
        Usuario valid = usuariosModel.get(this.user);
        if (valid != null && valid.getContrasena().equals(user.getContrasena())) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "crudEmpleado";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Atencion", "Credenciales incorrectas")); 
            return "index";
        }
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "index";
    }
    
    

    /*private UsuariosClient service;
    private Usuario user;

    public LoginBean() {
        service = new UsuariosClient();
        user = new Usuario();
    }

    public String acceder() {
        try {
            service.getUsuario(user, Usuario.class);
            return "crudEmpleado";
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Atencion", "Credenciales incorrectas"));
            return null;
        }
    }

    public String nuevoRegistro() {
        try {
            service.postUsuario(user, Usuario.class);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Nuevo", "Registro nuevo exitoso"));
            return "index";
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Atencion", "Datos incorrectos o faltantes"));
            return null;
        }
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }*/

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
