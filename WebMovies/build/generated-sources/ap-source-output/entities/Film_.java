package entities;

import entities.Booking;
import entities.Category;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-21T21:23:17")
@StaticMetamodel(Film.class)
public class Film_ { 

    public static volatile SingularAttribute<Film, String> img;
    public static volatile SingularAttribute<Film, Double> price;
    public static volatile SingularAttribute<Film, String> name;
    public static volatile SingularAttribute<Film, String> openning;
    public static volatile SingularAttribute<Film, String> linkVideo;
    public static volatile SingularAttribute<Film, Integer> id;
    public static volatile SingularAttribute<Film, String> descript;
    public static volatile CollectionAttribute<Film, Booking> bookingCollection;
    public static volatile SingularAttribute<Film, Boolean> isHot;
    public static volatile SingularAttribute<Film, Category> categoryId;

}