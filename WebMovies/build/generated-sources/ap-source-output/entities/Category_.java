package entities;

import entities.Film;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-31T12:32:03")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile CollectionAttribute<Category, Film> filmCollection;
    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, Integer> id;

}