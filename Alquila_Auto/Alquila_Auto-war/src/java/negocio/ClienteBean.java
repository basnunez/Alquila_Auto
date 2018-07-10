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
import pojos.Cliente;
import servicios.ClienteFacadeLocal;

/**
 *
 * @author Baazt
 */
@Named(value = "clienteBean")
@RequestScoped
public class ClienteBean {

    @EJB
    private ClienteFacadeLocal clienteFacade;
    private String rut;
    private String nombre;
    private String apellido;
    private List<Cliente> busqueda;

    
    public ClienteBean() {
    }
    
        public String crear(){
        Cliente c = new Cliente();
        c.setRut(rut);
        c.setNombre(nombre);
        c.setApellido(apellido);
        
        clienteFacade.create(c);
        
        return "cliente";
    }
    
    public String eliminar(){
        Cliente c = clienteFacade.find(this.rut);
        clienteFacade.remove(c);
        return "eliminar_cliente";
        
    }
    
    public String editar(){
        Cliente c = clienteFacade.find(this.rut);
        
        c.setNombre(this.nombre);
        c.setApellido(this.apellido);
        
        clienteFacade.edit(c);
        
        return "editar_cliente";
    }
    
    public List<Cliente> getCliente(){
        return clienteFacade.findAll();
    }

    public ClienteFacadeLocal getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacadeLocal clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Cliente> getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(List<Cliente> busqueda) {
        this.busqueda = busqueda;
    }
    
    
    
}
