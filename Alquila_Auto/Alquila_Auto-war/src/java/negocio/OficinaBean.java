/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import pojos.Oficina;
import servicios.OficinaFacadeLocal;

/**
 *
 * @author Baazt
 */
@Named(value = "oficinaBean")
@RequestScoped
public class OficinaBean {

    @EJB
    private OficinaFacadeLocal oficinaFacade;
    private int id_oficina;
    private String codigo;
    private String ciudad;
    private String direccion;
    private List <Oficina> busqueda;
    
    public OficinaBean() {
    }
    
    public String crear(){
        Oficina o = new Oficina();
        
        o.setCodigo(codigo);
        o.setCiudad(ciudad);
        o.setDireccion(direccion);
        oficinaFacade.create(o);
        return "oficina";
    }
    
    public String eliminar(){
        Oficina o = oficinaFacade.find(this.id_oficina);
        oficinaFacade.remove(o);
        return "eliminar_oficina";
    }
    
    public String editar(){
        Oficina o = oficinaFacade.find(this.id_oficina);
        
        o.setCodigo(codigo);
        o.setCiudad(ciudad);
        o.setDireccion(direccion);
        
        oficinaFacade.edit(o);
        
        return "editar_oficina";
    }
    
    public List<Oficina> getOficina(){
        return oficinaFacade.findAll();
    }

    public OficinaFacadeLocal getOficinaFacade() {
        return oficinaFacade;
    }

    public void setOficinaFacade(OficinaFacadeLocal oficinaFacade) {
        this.oficinaFacade = oficinaFacade;
    }

    public int getId_oficina() {
        return id_oficina;
    }

    public void setId_oficina(int id_oficina) {
        this.id_oficina = id_oficina;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Oficina> getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(List<Oficina> busqueda) {
        this.busqueda = busqueda;
    }
    
    
    
}
