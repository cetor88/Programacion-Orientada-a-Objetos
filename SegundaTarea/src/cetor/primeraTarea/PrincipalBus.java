package cetor.primeraTarea;

import cetor.primeraTarea.dao.PasajeroDAO;
import cetor.primeraTarea.dao.AutoBusDAO;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ana
 */
public class PrincipalBus {

    private static boolean registroPersonal(List<Pasajero> pasajeroList, boolean bandera, Scanner scan, int indice) {
        Pasajero pasajero = new Pasajero();
        PasajeroDAO pasajeroDao = new PasajeroDAO();
        pasajero.setDni(indice);
        System.out.println("Introduce tu nombre");
        pasajero.setNombre(scan.next().toUpperCase());
        System.out.println("Introduce tu Apellido Paterno");
        pasajero.setApPat(scan.next().toUpperCase());
        System.out.println("Introduce tu Apellido Materno");
        pasajero.setApMat(scan.next().toUpperCase());

        //pasajeroList.add(pasajero);
        bandera = pasajeroDao.rePoblarTXT(pasajero);
        //System.out.println("Se actualizo el archivo " + pasajeroDao.rePoblarTXT(pasajero));
        return bandera;
    }

    static public AutoBusDAO elegirOpcion(Scanner scan, List<Pasajero> pasajerosRegistrados,
            PasajeroDAO pasajeroDAO, int indice) {
        //System.out.println("Que desea hacer, [R]egistar ó [A]bordar");
        System.out.println("Que desea hacer [A]bordar");
        char opc = scan.next().toUpperCase().charAt(0);
        boolean bandera = false;
        AutoBusDAO busDAO = null;
        switch (opc) {
            /*case 'R':                  
             System.out.println("Para poder transportarte debes ingresar tus datos");
             registroPersonal(pasajerosRegistrados, bandera, scan, indice);
             break;*/
            case 'A':
                System.out.println("Escribe tu DNI");
                int dni = scan.nextInt();
                Pasajero pasajero = pasajeroDAO.findPasajero(dni);
                if (pasajero != null) {
                    busDAO = new AutoBusDAO();
                    AutoBus bus = busDAO.crearVehiculo();

                    System.out.println("Se aparto el boleto -> " + busDAO.apartarAsiento(bus, pasajero));
                }
                break;
            default:
                break;
        }

        return busDAO;
    }

    static public AutoBus abordar(Scanner scan, List<Pasajero> pasajerosRegistrados,
            PasajeroDAO pasajeroDAO, int indice) {
        AutoBusDAO busDAO = new AutoBusDAO();
        AutoBus bus = busDAO.crearVehiculo();
        boolean abordar = true;
        do {
            System.out.println("Que desea hacer [A]bordar [S]alir?");
            char opc = scan.next().toUpperCase().charAt(0);
            switch (opc) {
                case 'A':
                    System.out.println("Escribe tu DNI");
                    int dni = scan.nextInt();
                    Pasajero pasajero = pasajeroDAO.findPasajero(dni);
                    if (pasajero != null) {
                        System.out.println("Se aparto el boleto -> " + busDAO.apartarAsiento(bus, pasajero));
                    }
                    break;
                    case 'S':
                        abordar = false;
                    break;
                default:
                    break;
            }
        } while (abordar);
        return bus;
    }

    public static void main(String[] args) {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        List<Pasajero> pasajerosRegistrados = pasajeroDAO.obtenerPasajerosTXT("");;
        System.out.println(pasajerosRegistrados);

        int indice = pasajerosRegistrados.size() + 1;
        Scanner scan = new Scanner(System.in);

        //AutoBusDAO busDAO = elegirOpcion(scan, pasajerosRegistrados, pasajeroDAO, indice);
        AutoBus bus = abordar(scan, pasajerosRegistrados, pasajeroDAO, indice);
        System.out.println("Estado del Buss???: " + bus);
        /*List<AutoBus> buses = busDAO.getLisVehiculo();
        for (AutoBus itemBus : buses) {
            System.out.println("Personas en el Autobus "
                    + itemBus.getIdVehiculo() + " -> "
                    + busDAO.personaXBus(itemBus.getIdVehiculo()));
        }
        System.out.println("Introduce el DNI a buscar? para localizar a la persona");
        int dni = scan.nextInt();
        AutoBus busito = busDAO.buscarPersonaEnBus(pasajeroDAO.findPasajero(dni));
        System.out.println("La persona con DNI: " + dni
                + "se encuentra en asiento " + busito.getIdVehiculo() + "en el asiento ");
    
                */
    }
}
