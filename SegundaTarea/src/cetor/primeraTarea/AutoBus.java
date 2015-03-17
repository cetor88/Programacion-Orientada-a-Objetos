/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cetor.primeraTarea;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @author ana
 */
public class AutoBus {
    private int idAutoBus;
    private List <Asiento> listAsiento;
    private static AutoBus autoBus;
    private final static int maxAsientos = 40;
    private static int count=1;
    
    private AutoBus(){
    count=+1;
    }
    public static AutoBus getInstancia(){//List <Asiento> listAsient){
       //autoBus = (autoBus == null) ? new AutoBus(): autoBus;
        if(autoBus == null ){
            autoBus =  new AutoBus();
            autoBus.setIdVehiculo(count);
            autoBus.setListAsiento(crearAsientos());
        }
        
        return autoBus;
    }
    
    static private List<Asiento> crearAsientos() {
        List<Asiento> listAsientos = new ArrayList();
        for (int i = 1; i <= maxAsientos; i++) {
            Asiento asiento = new Asiento();
            asiento.setEstado(false);
            asiento.setIdAsiento(i);
            listAsientos.add(asiento);
        }
        return listAsientos;
    }
    public int getIdVehiculo() {return idAutoBus;   }
    public void setIdVehiculo(int idVehiculo) {this.idAutoBus = idVehiculo;}

    public List<Asiento> getListAsiento() {return listAsiento;}

    public void setListAsiento(List<Asiento> listAsiento) {this.listAsiento = listAsiento;}
    
    public String  toString(){return "MATRICULA BUS ## > " + idAutoBus + " \n ESTADO DE LOS ASIENTOS: **> " +listAsiento;}

}
