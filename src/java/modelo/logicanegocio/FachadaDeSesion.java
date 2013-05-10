package modelo.logicanegocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import modelo.accesodatos.Solicitud;
import modelo.accesodatos.Taxi;

/**
 *
 * @author Grupo 4
 */
@Stateless
public class FachadaDeSesion {//implements InterfazFachadaRemota {

    @PersistenceContext
    EntityManager em;

    //@Override
    public List<Integer> consultaListaTaxis() {
        //Devuelve la lista de identidicadores de los taxis de la BBDD
        return (List<Integer>) em.createNamedQuery("Taxi.findAllByNumBastidor").getResultList();
    }

    //@Override
    public String consultaEstadoTaxi(Integer idTaxi) {
        //Devuelve el estado del taxi
        return (String) em.createNamedQuery("Taxi.findEstadoByNumBastidor").
                setParameter("numBastidor", idTaxi).getSingleResult();
    }

    //@Override
    public Taxi consultaInfoTaxi(Integer idTaxi) {
        //Devuelve el taxi con la información de estado, ubicacion y destino
        return (Taxi) em.createNamedQuery("Taxi.findByNumBastidor").
                setParameter("numBastidor", idTaxi).getSingleResult();
    }

    //@Override
    public Integer insertarSolicitud(String nombre, String direccion, String telefono) {
        //Inserta la solicitud en la BBDD
        Date fecha = new Date();
        Solicitud solicitud = new Solicitud(nombre, direccion, telefono, fecha.toString());
       // solicitud.setIdSolicitud(1);
        
        //solicitud.setTaxiNumBastidor(null);
        //obtenemos el id del taxi que hara el servicio y asignamos su id ala solicitud
        //solicitud.setIdSolicitud(obtenerTaxi(solicitud.getIdSolicitud()));
        //solicitud.setIdSolicitud(123);
        //em.lock(solicitud, LockModeType.NONE);
        List list = em.createNamedQuery("Solicitud.findAll").getResultList();
        em.persist(solicitud);
        return solicitud.getIdSolicitud();
    }

    //@Override
    public Integer obtenerTaxi(Integer idSolicitud) {

        //Obtiene los taxis que han atendido alguna solicitud
        List<Taxi> listaSolicitudes = em.createNamedQuery("Solicitud.findTaxis").getResultList();
        int numSolicitudes = listaSolicitudes.size();

        //Obtiene la lista de taxis que disponemos
        List<Integer> listaTaxis = consultaListaTaxis();
        int numTaxis = listaTaxis.size();

        //Taxi al que se le va a enviar el mensaje
        Integer taxiCandidato = null;

        boolean libre;
        int i;

        //En caso de que no tenga ningun taxi en la BBDD
        if (numTaxis == 0) {
            //Aqui no se hace nada?
        } else if (numSolicitudes == 0) {
            //Si aun no se ha antendido ninguna solicitud devuelve el primer taxi libre
            i = 0;
            libre = false;
            while (i < numTaxis && !libre) {
                taxiCandidato = listaTaxis.get(i);
                if (consultaEstadoTaxi(taxiCandidato).equals("disponible")) {
                    libre = true;
                } else {
                    i++;
                }
            }

        } else {
            //Genera una lista ordenada por el tiempo de espera de los taxis
            ArrayList<Integer> taxisCandidatos = new ArrayList<Integer>();
            taxisCandidatos = generarCandidatos(numTaxis, listaSolicitudes, taxisCandidatos);

            libre = false;
            if (taxisCandidatos.size() < numTaxis) {
                //En caso de que no esten todos los taxis de los que se dispone lo busca
                i = 0;
                while (i < numTaxis && taxisCandidatos.size() < numTaxis && !libre) {
                    taxiCandidato = listaTaxis.get(i);
                    //Busca el taxi que no haya atendido ninguna solicitud y este libre
                    if (!estaEnLista(taxisCandidatos, taxiCandidato) && consultaEstadoTaxi(taxiCandidato).equals("disponible")) {
                        libre = true;
                    } else {
                        i++;
                    }
                }
            } else {
                //Obtiene el primer taxi disponible
                i = taxisCandidatos.size() - 1;
                while (i >= 0 && !libre) {
                    taxiCandidato = listaTaxis.get(i);
                    if (consultaEstadoTaxi(taxiCandidato).equals("disponible")) {
                        libre = true;
                    } else {
                        i--;
                    }
                }
            }
        }

        return taxiCandidato;
    }

    //@Override
    public boolean enviarMensaje(Integer idSolicitud, Integer idTaxi) {
        //Envia un mensaje al taxi indicado con la solicitud asignada

        //Obtiene la solicitud
        Solicitud solicitud = (Solicitud) em.createNamedQuery("Solicitud.findByIdSolicitud").setParameter("idSolicitud", idSolicitud).getResultList().get(0);
        //Obtiene el taxi
        Taxi taxi = (Taxi) em.createNamedQuery("Taxi.findByNumBastidor").setParameter("numBastidor", idTaxi).getResultList().get(0);

        //Adigna el taxi a la solicitud
        //solicitud.setTaxiNumBastidor(taxi);

        em.lock(solicitud, LockModeType.NONE);
        //Actualiza la BBD
        em.persist(solicitud);

        return true;
    }

    //Genera la lista de los ultimos taxis que han atendido solicitudes
    private ArrayList<Integer> generarCandidatos(int numTaxis, List<Taxi> listaSolicitudes, ArrayList<Integer> taxisCandidatos) {
        int numSolicitudes = listaSolicitudes.size();
        Integer taxiCandidato;

        while (numTaxis > 0 && numSolicitudes > 0) {
            taxiCandidato = listaSolicitudes.get(numSolicitudes - 1).getNumBastidor();
            //Añade el taxi si no esta repetido
            if (!estaEnLista(taxisCandidatos, taxiCandidato)) {
                taxisCandidatos.add(taxiCandidato);
                numTaxis--;
            }
            numSolicitudes--;
        }
        return taxisCandidatos;
    }

    //Comprueba si ya esta en la lista
    private boolean estaEnLista(ArrayList lista, int id) {
        boolean encontrado = false;
        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size() - 1; i++) {
                if (id == lista.get(i)) {
                    encontrado = true;
                }
            }
        }
        return encontrado;
    }
}