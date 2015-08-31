/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tbl_Film")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f"),
    @NamedQuery(name = "Film.findById", query = "SELECT f FROM Film f WHERE f.id = :id"),
    @NamedQuery(name = "Film.findByName", query = "SELECT f FROM Film f WHERE f.name = :name"),
    @NamedQuery(name = "Film.findByOpenning", query = "SELECT f FROM Film f WHERE f.openning = :openning"),
    @NamedQuery(name = "Film.findByDescript", query = "SELECT f FROM Film f WHERE f.descript = :descript"),
    @NamedQuery(name = "Film.findByImg", query = "SELECT f FROM Film f WHERE f.img = :img"),
    @NamedQuery(name = "Film.findByLinkVideo", query = "SELECT f FROM Film f WHERE f.linkVideo = :linkVideo"),
    @NamedQuery(name = "Film.findByIsHot", query = "SELECT f FROM Film f WHERE f.isHot = :isHot"),
    @NamedQuery(name = "Film.findByPrice", query = "SELECT f FROM Film f WHERE f.price = :price")})
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "openning")
    private String openning;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "descript")
    private String descript;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "img")
    private String img;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "linkVideo")
    private String linkVideo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isHot")
    private boolean isHot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category categoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieId")
    private Collection<Booking> bookingCollection;

    public Film() {
    }

    public Film(Integer id) {
        this.id = id;
    }

    public Film(Integer id, String name, String openning, String descript, String img, String linkVideo, boolean isHot, double price) {
        this.id = id;
        this.name = name;
        this.openning = openning;
        this.descript = descript;
        this.img = img;
        this.linkVideo = linkVideo;
        this.isHot = isHot;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenning() {
        return openning;
    }

    public void setOpenning(String openning) {
        this.openning = openning;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

    public boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(boolean isHot) {
        this.isHot = isHot;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
