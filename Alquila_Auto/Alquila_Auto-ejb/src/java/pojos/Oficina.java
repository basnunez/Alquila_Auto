/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Baazt
 */
@Entity
@Table(name = "Oficina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oficina.findAll", query = "SELECT o FROM Oficina o")
    , @NamedQuery(name = "Oficina.findByIdOficina", query = "SELECT o FROM Oficina o WHERE o.idOficina = :idOficina")
    , @NamedQuery(name = "Oficina.findByCodigo", query = "SELECT o FROM Oficina o WHERE o.codigo = :codigo")
    , @NamedQuery(name = "Oficina.findByCiudad", query = "SELECT o FROM Oficina o WHERE o.ciudad = :ciudad")
    , @NamedQuery(name = "Oficina.findByDireccion", query = "SELECT o FROM Oficina o WHERE o.direccion = :direccion")})
public class Oficina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_oficina")
    private Integer idOficina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkOficina")
    private List<Vehiculo> vehiculoList;

    public Oficina() {
    }

    public Oficina(Integer idOficina) {
        this.idOficina = idOficina;
    }

    public Oficina(Integer idOficina, String codigo, String ciudad, String direccion) {
        this.idOficina = idOficina;
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Integer getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Integer idOficina) {
        this.idOficina = idOficina;
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

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOficina != null ? idOficina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oficina)) {
            return false;
        }
        Oficina other = (Oficina) object;
        if ((this.idOficina == null && other.idOficina != null) || (this.idOficina != null && !this.idOficina.equals(other.idOficina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Oficina[ idOficina=" + idOficina + " ]";
    }
    
}
