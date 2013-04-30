/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logicanegocio;

/**
 *
 * @author fran
 */
public class InfoTaxi {
    
    private String estado;
    private String ubicacion;
    private Integer numBastidor;
    
    public InfoTaxi(String estado, String ubicacion, Integer numBastidor){
        estado = this.estado;
        ubicacion = this.ubicacion;
        numBastidor = this.numBastidor;
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

    public Integer getNumBastidor() {
        return numBastidor;
    }

    public void setNumBastidor(Integer numBastidor) {
        this.numBastidor = numBastidor;
    }
    
}
