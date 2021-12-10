package com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Empleado;
import com.models.EmpleadosModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class EmpBean implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;
    private Empleado emp;
    private List<Empleado> arrayEmpleados = null;

    public EmpBean() {
        this.emp = new Empleado();
    }

    private void limpiar() {
        emp = new Empleado();
    }

    public void save() {
        EmpleadosModel empleadosModel = new EmpleadosModel();
        boolean valid = empleadosModel.create(this.emp);
        limpiar();
        if (valid) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Nuevo", "Registro exitoso"));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error crear", "Datos invalidos"));
        }
    }

    public void eliminar() {
        EmpleadosModel empleadosModel = new EmpleadosModel();
        boolean valid = empleadosModel.delete(this.emp);
        limpiar();
        if (valid) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Eliminar", "Registro eliminado"));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error eliminar", "Datos invalidos"));
        }
    }

    public void actualizar() {
        EmpleadosModel empleadosModel = new EmpleadosModel();
        boolean valid = empleadosModel.update(this.emp);
        limpiar();
        if (valid) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Actualizar", "Registro actualizado"));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error actualizar", "Datos invalidos"));
        }
    }

    public void consultarId() {
        EmpleadosModel empleadosModel = new EmpleadosModel();
        arrayEmpleados = new ArrayList<>();
        arrayEmpleados.add(empleadosModel.get(this.emp.getClave()));
        if (arrayEmpleados.contains(this.emp)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Consulta", "Consulta exitosa"));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error consultar", "Error"));
        }
    }

    public void consultarTodos() {
        EmpleadosModel empleadosModel = new EmpleadosModel();
        arrayEmpleados = new ArrayList<>();
        arrayEmpleados = empleadosModel.getAll();
        if (arrayEmpleados.containsAll(arrayEmpleados)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Consulta", "Consulta exitosa"));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error consultar", "Error"));
        }
    }


    /*    private EmpleadosClient service;
    private JSONArray jsonArray;
    private Empleado emp;
    private List<Empleado> arrayEmpleados;

    public EmpBean() {
        service = new EmpleadosClient();
        emp = new Empleado();
    }

    private void limpiar() {
        emp = new Empleado();
    }

    public void ingresar() {
        service.postEmpleado(emp, Empleado.class);
        limpiar();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Nuevo", "Registro exitoso"));
    }

    public void eliminar() {
        service.deleteEmpleado(emp.getClave());
        limpiar();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Eliminar", "Registro eliminado"));
    }

    public void actualizar() {
        service.putEmpleado(emp, Empleado.class);
        limpiar();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Actualizar", "Registro actualizado"));
    }

    public void consultarId() {
        arrayEmpleados = new ArrayList<>();
        emp = service.getEmpleado(Empleado.class, emp.getClave());
        arrayEmpleados.add(emp);
        limpiar();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Consulta", "Consulta exitosa"));
    }

    public void consultarTodos() {
        arrayEmpleados = new ArrayList<>();
        jsonArray = new JSONArray(service.getEmpleados(String.class));
        for (int i = 0; i < jsonArray.length(); i++) {
            emp = new Empleado();
            emp.setClave(jsonArray.getJSONObject(i).getString("clave"));
            emp.setNombre(jsonArray.getJSONObject(i).getString("nombre"));
            emp.setDireccion(jsonArray.getJSONObject(i).getString("direccion"));
            emp.setTelefono(jsonArray.getJSONObject(i).getString("telefono"));
            arrayEmpleados.add(emp);
        }
        limpiar();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Consultar Todos", "Consulta exitosa"));
    }

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public List<Empleado> getArrayEmpleados() {
        return arrayEmpleados;
    }

    public void setArrayEmpleados(List<Empleado> arrayEmpleados) {
        this.arrayEmpleados = arrayEmpleados;
    }
     */
    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public List<Empleado> getArrayEmpleados() {
        return arrayEmpleados;
    }

    public void setArrayEmpleados(List<Empleado> arrayEmpleados) {
        this.arrayEmpleados = arrayEmpleados;
    }
}
