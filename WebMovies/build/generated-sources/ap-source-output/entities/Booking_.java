package entities;

import entities.Film;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-31T12:32:03")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Integer> phone;
    public static volatile SingularAttribute<Booking, Integer> qualtity;
    public static volatile SingularAttribute<Booking, String> name;
    public static volatile SingularAttribute<Booking, Film> movieId;
    public static volatile SingularAttribute<Booking, Integer> id;
    public static volatile SingularAttribute<Booking, String> email;

}