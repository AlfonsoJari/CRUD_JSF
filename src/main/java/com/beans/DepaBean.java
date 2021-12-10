/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.models.DepartamentosModel;
import com.models.EmpleadosModel;
import entidades.Departamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author alfon
 */
@ManagedBean
@SessionScoped
public class DepaBean implements Serializable{
    
    private static final long serialVersionUID = 1094801825228386363L;
    private Departamento dep;
    private List<Departamento> arrayDepartamentos = null;

    public DepaBean() {
        this.dep = new Departamento();
    }

    private void limpiar() {
        dep = new Departamento();
    }

    public void save() {
        DepartamentosModel departamentosModel = new DepartamentosModel();
        boolean valid = departamentosModel.create(this.dep);
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
        DepartamentosModel departamentosModel = new DepartamentosModel();
        boolean valid = departamentosModel.delete(this.dep);
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
        DepartamentosModel departamentosModel = new DepartamentosModel();
        boolean valid = departamentosModel.update(this.dep);
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
        DepartamentosModel departamentosModel = new DepartamentosModel();
        arrayDepartamentos = new ArrayList<>();
        arrayDepartamentos.add(departamentosModel.get(this.dep.getClave()));
        if (arrayDepartamentos.contains(this.dep)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Consulta", "Consulta exitosa"));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error consultar", "Error"));
        }
    }

    public void consultarTodos() {
        DepartamentosModel departamentosModel = new DepartamentosModel();
        arrayDepartamentos = new ArrayList<>();
        arrayDepartamentos = departamentosModel.getAll();
        if (arrayDepartamentos.containsAll(arrayDepartamentos)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Consulta", "Consulta exitosa"));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error consultar", "Error"));
        }
    }

    public Departamento getDep() {
        return dep;
    }

    public void setDep(Departamento dep) {
        this.dep = dep;
    }

    public List<Departamento> getArrayDepartamentos() {
        return arrayDepartamentos;
    }

    public void setArrayDepartamentos(List<Departamento> arrayDepartamentos) {
        this.arrayDepartamentos = arrayDepartamentos;
    }
    
}
