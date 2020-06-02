/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author m.ambros
 */
@Entity
@Table(name="t_cocktails", schema="co")
public class TCocktail implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="t_cocktails_seq")
    @SequenceGenerator(name="t_cocktails_seq", sequenceName="co.t_cocktails_cocktail_id_seq", allocationSize=1, initialValue=0)
    @Column(name="cocktail_id",nullable = false)
    private Long cocktailId;
    
    @Column(name="name",nullable = false)
    private String name;
    
    @Column(name="url",nullable = false)
    private String url;
    
    public TCocktail(){
        super();
    }

    public Long getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(Long cocktailId) {
        this.cocktailId = cocktailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
}


