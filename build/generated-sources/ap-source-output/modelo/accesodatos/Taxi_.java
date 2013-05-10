package modelo.accesodatos;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.accesodatos.Solicitud;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-10T16:26:52")
@StaticMetamodel(Taxi.class)
public class Taxi_ { 

    public static volatile SingularAttribute<Taxi, String> destino;
    public static volatile SingularAttribute<Taxi, String> estado;
    public static volatile SingularAttribute<Taxi, Integer> numBastidor;
    public static volatile CollectionAttribute<Taxi, Solicitud> solicitudCollection;
    public static volatile SingularAttribute<Taxi, String> ubicacion;

}