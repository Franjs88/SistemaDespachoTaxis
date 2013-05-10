package modelo.accesodatos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author fran
 */
@Entity
@Table(name = "taxi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxi.findAll", query = "SELECT t FROM Taxi t"),
    @NamedQuery(name = "Taxi.findAllByNumBastidor", query = "SELECT t.numBastidor FROM Taxi t"),
    @NamedQuery(name = "Taxi.findByNumBastidor", query = "SELECT t FROM Taxi t WHERE t.numBastidor = :numBastidor"),
    @NamedQuery(name = "Taxi.findEstadoByNumBastidor", query = "SELECT t.estado FROM Taxi t WHERE t.numBastidor = :numBastidor"),
    @NamedQuery(name = "Taxi.findUbicacionByNumBastidor", query = "SELECT t.estado FROM Taxi t WHERE t.numBastidor = :numBastidor"),
    @NamedQuery(name = "Taxi.findDestinoByNumBastidor", query = "SELECT t.estado FROM Taxi t WHERE t.numBastidor = :numBastidor"),
    @NamedQuery(name = "Taxi.findByEstado", query = "SELECT t FROM Taxi t WHERE t.estado = :estado"),
    @NamedQuery(name = "Taxi.findByUbicacion", query = "SELECT t FROM Taxi t WHERE t.ubicacion = :ubicacion"),
    @NamedQuery(name = "Taxi.findByDestino", query = "SELECT t FROM Taxi t WHERE t.destino = :destino")})
public class Taxi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumBastidor")
    private Integer numBastidor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Size(max = 45)
    @Column(name = "destino")
    private String destino;
    @OneToMany(mappedBy = "taxiNumBastidor")
    private Collection<Solicitud> solicitudCollection;

    public Taxi() {
    }

    public Taxi(Integer numBastidor) {
        this.numBastidor = numBastidor;
    }

    public Taxi(Integer numBastidor, String estado, String ubicacion) {
        this.numBastidor = numBastidor;
        this.estado = estado;
        this.ubicacion = ubicacion;
    }

    public Integer getNumBastidor() {
        return numBastidor;
    }

    public void setNumBastidor(Integer numBastidor) {
        this.numBastidor = numBastidor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numBastidor != null ? numBastidor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxi)) {
            return false;
        }
        Taxi other = (Taxi) object;
        if ((this.numBastidor == null && other.numBastidor != null) || (this.numBastidor != null && !this.numBastidor.equals(other.numBastidor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.accesodatos.Taxi[ numBastidor=" + numBastidor + " ]";
    }
    
}
