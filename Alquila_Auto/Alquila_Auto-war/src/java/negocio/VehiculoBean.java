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
import pojos.Vehiculo;
import servicios.OficinaFacadeLocal;
import servicios.VehiculoFacadeLocal;

/**
 *
 * @author Baazt
 */
@Named(value = "vehiculoBean")
@RequestScoped
public class VehiculoBean {

    @EJB
    private OficinaFacadeLocal oficinaFacade;

    @EJB
    private VehiculoFacadeLocal vehiculoFacade;
    
    private String patente;
    private String marca;
    private String modelo;
    private boolean estado;
    private List <Vehiculo> busqueda;
    private Oficina oficina;
    
    public VehiculoBean() {
        oficina = new Oficina();
    }
    
    public List<Vehiculo> getVehiculos(){
        return vehiculoFacade.findAll();
    }
    
    public String crear(){
        Vehiculo v = new Vehiculo();
        v.setPatente(patente);
        v.setMarca(marca);
        v.setModelo(modelo);
        v.setEstado(true);
        v.setFkOficina(oficinaFacade.find(oficina.getIdOficina()));
        vehiculoFacade.create(v);
        return "vehiculo";
    }
    
    public String eliminar(){
        Vehiculo v = vehiculoFacade.find(this.patente);
        vehiculoFacade.remove(v);
        return "eliminar_vehiculo";
    }
    
    public String editar(){
        Vehiculo v = vehiculoFacade.find(this.patente);
        v.setMarca(marca);
        v.setModelo(modelo);
        v.setEstado(estado);
        v.setFkOficina(oficinaFacade.find(oficina.getIdOficina()));
        vehiculoFacade.edit(v);
        return "editar_vehiculo";
    }

    public VehiculoFacadeLocal getVehiculoFacade() {
        return vehiculoFacade;
    }

    public void setVehiculoFacade(VehiculoFacadeLocal vehiculoFacade) {
        this.vehiculoFacade = vehiculoFacade;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Vehiculo> getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(List<Vehiculo> busqueda) {
        this.busqueda = busqueda;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
    
    
    
}
