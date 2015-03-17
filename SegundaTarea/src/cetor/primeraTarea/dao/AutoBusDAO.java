package cetor.primeraTarea.dao;

import cetor.primeraTarea.Asiento;
import cetor.primeraTarea.AutoBus;
import cetor.primeraTarea.Pasajero;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ana
 */
public class AutoBusDAO  {

    private List<AutoBus> lisVehiculo = new ArrayList();
    private static int countVehiculo = 0;
    private final int numAutobuses   = 6; 

    public List<AutoBus> getLisVehiculo() {     return this.lisVehiculo;   }
    
    public AutoBus crearVehiculo() {
        //countVehiculo += 1;
        AutoBus bus = null;
        if (lisVehiculo.size() <= numAutobuses) {// ya que solo cuentan con 6 Buses
            bus = AutoBus.getInstancia(); //singleton
            lisVehiculo.add(bus);
        }
        return bus;
    }

    
    public boolean apartarAsiento(AutoBus autoBus, Pasajero pasajero) {
        List<Asiento> asientos = autoBus.getListAsiento();
        boolean bandera = false;
        for (int i = 0; i < asientos.size(); i++) {
            if (asientos.get(i).isEstado() == false) {//apartar asiento consecutivamente
                asientos.get(i).setEstado(true);
                asientos.get(i).setPasajero(pasajero);
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    public int personaXBus(int idAutoBus) {
        List<Asiento> listAsiento = null;
        int contador = 0;
        for (AutoBus itemBus : lisVehiculo) {
            if (itemBus.getIdVehiculo() == idAutoBus) {
                listAsiento = itemBus.getListAsiento();
                for (Asiento itemAsient : listAsiento) {
                    if (itemAsient.isEstado() == true) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    public AutoBus buscarPersonaEnBus(Pasajero pasajero) {
        AutoBus bus = null;
        List<Asiento> listAsiento = null;
        for (AutoBus itemBus : lisVehiculo) {
            listAsiento = itemBus.getListAsiento();
            for (Asiento itemAsient : listAsiento) {
                if (itemAsient.getPasajero().equals( pasajero) ) {
                    bus = itemBus;
                }
            }
        }
        return bus;
    }

   
}