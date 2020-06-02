/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.model;

import cz.amware.firstjava.app.model.CocktailIngredientId;
import cz.amware.firstjava.app.model.TCocktail;
import cz.amware.firstjava.app.model.TIngredient;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author m.ambros
 */
@Entity
@Table(name="t_cocktails_x_ingredients", schema="co")
public class TCocktailXIngredient implements Serializable {
    @EmbeddedId
    private CocktailIngredientId id;

    @ManyToOne
    @MapsId("cocktail_id")
    @JoinColumn(name="cocktail_id", nullable=false)
    private TCocktail cocktail;

    
    @ManyToOne
    @MapsId("ingredient_id")
    @JoinColumn(name="ingredient_id", nullable=false)
    private TIngredient ingredient;
    
    public TCocktailXIngredient(){
        super();
    }
}
