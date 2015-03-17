
package cetor.primeraTarea;

/**
 *
 * @author ana
 */
public class Asiento {
    private int idAsiento;
    private boolean estado;
    private Pasajero pasajero;
    
    public Asiento(){}
   
    public int getIdAsiento() {
        return idAsiento;
    }
    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }
    public String toString() {
        
        String status = (estado == true) ? "ocupado":"vacio";
        return "\n \t asiento # -> " + idAsiento +" \n \t estado-> " + status + "\n \t Pasajero: "+pasajero +"\n";
    }
    
}
