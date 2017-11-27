/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.novaroma.checkevents.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rodrigo alves
 */
@Entity
@Table(name = "localizacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localizacao.findAll", query = "SELECT l FROM Localizacao l"),
    @NamedQuery(name = "Localizacao.findById", query = "SELECT l FROM Localizacao l WHERE l.id = :id"),
    @NamedQuery(name = "Localizacao.findByLatitude", query = "SELECT l FROM Localizacao l WHERE l.latitude = :latitude"),
    @NamedQuery(name = "Localizacao.findByLongitude", query = "SELECT l FROM Localizacao l WHERE l.longitude = :longitude")})
public class Localizacao extends BaseEntity {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Float latitude;
    @Column(name = "longitude")
    private Float longitude;
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "localizacao")
    private Evento evento;

    public Localizacao() {
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "br.com.novaroma.checkevents.entities.Localizacao[ id=" + this.getId() + " ]";
    }
}
