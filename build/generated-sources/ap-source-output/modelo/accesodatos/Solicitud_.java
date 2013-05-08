package modelo.accesodatos;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.accesodatos.Taxi;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-07T18:16:44")
@StaticMetamodel(Solicitud.class)
public class Solicitud_ { 

    public static volatile SingularAttribute<Solicitud, Integer> idSolicitud;
    public static volatile SingularAttribute<Solicitud, String> direccionDestino;
    public static volatile SingularAttribute<Solicitud, Taxi> taxiNumBastidor;
    public static volatile SingularAttribute<Solicitud, String> telefono;
    public static volatile SingularAttribute<Solicitud, String> nombreCliente;
    public static volatile SingularAttribute<Solicitud, Long> fechaSolicitud;

}