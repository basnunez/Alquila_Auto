/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import pojos.Alquiler;
import pojos.Cliente;
import pojos.Vehiculo;
import servicios.AlquilerFacadeLocal;
import servicios.ClienteFacadeLocal;
import servicios.VehiculoFacadeLocal;

/**
 *
 * @author Baazt
 */
@Named(value = "alquilerBean")
@RequestScoped
public class AlquilerBean {

    @EJB
    private VehiculoFacadeLocal vehiculoFacade;

    @EJB
    private ClienteFacadeLocal clienteFacade;

    @EJB
    private AlquilerFacadeLocal alquilerFacade;
    
    
    
    
    private int id_alquiler;
    Cliente cliente;
    Vehiculo vehiculo;
    private int precio;
    private Date fecha;
    private String prueba;
    private Boolean prueba2;
    private List <Alquiler> busqueda;
    
    public AlquilerBean() {
        cliente = new Cliente();
        vehiculo = new Vehiculo();
    }
    
    public String crear(){
        FacesContext facesContext = FacesContext.getCurrentInstance();

        Alquiler a = new Alquiler();

        a.setPrecio(precio);
        a.setFecha(fecha);
        a.setFkPatente(vehiculoFacade.find(vehiculo.getPatente()));
        prueba = a.getFkPatente().getPatente();
        prueba2 = a.getFkPatente().getEstado();
        a.setFkRut(clienteFacade.find(cliente.getRut()));        
        
        if(prueba2==true){
        alquilerFacade.create(a);
        Vehiculo v = vehiculoFacade.find(prueba);
        v.setEstado(false);
        vehiculoFacade.edit(v);
        facesContext.addMessage("form", new FacesMessage("Alquiler Exitoso!!"));
        return "alquiler";

        }else{
        facesContext.addMessage("form", new FacesMessage("El auto seleccionado ya está arrendado!!"));
        return null;
        }  
    }
    
    public class MessagesView {
        public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
    }
    }
    
    
    public String eliminar(){
        Alquiler a = alquilerFacade.find(this.id_alquiler);
        prueba = a.getFkPatente().getPatente();
        alquilerFacade.remove(a);
        Vehiculo v = vehiculoFacade.find(prueba);
        v.setEstado(true);
        vehiculoFacade.edit(v);
        return "eliminar_alquiler";
    }
    
    public List <Alquiler> getAlquileres(){
        return alquilerFacade.findAll();
    }

    public AlquilerFacadeLocal getAlquilerFacade() {
        return alquilerFacade;
    }

    public void setAlquilerFacade(AlquilerFacadeLocal alquilerFacade) {
        this.alquilerFacade = alquilerFacade;
    }

    public int getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(int id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Alquiler> getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(List<Alquiler> busqueda) {
        this.busqueda = busqueda;
    }

    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    public Boolean getPrueba2() {
        return prueba2;
    }

    public void setPrueba2(Boolean prueba2) {
        this.prueba2 = prueba2;
    }

    
    
}
