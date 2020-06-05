/*
 * To change this license header, choose License Headers 
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.model;

import cz.amware.model.CocktailIngredientId;
import cz.amware.model.TCocktail;
import cz.amware.model.TIngredient;

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
    @MapsId("cocktailId")
    @JoinColumn(name="cocktail_id", nullable=false)
    private TCocktail cocktail;

    
    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name="ingredient_id", nullable=false)
    private TIngredient ingredient;
    
    public TCocktailXIngredient(){
        super();
    }

    public CocktailIngredientId getId() {
        return id;
    }

    public void setId(CocktailIngredientId id) {
        this.id = id;
    }

    public TCocktail getCocktail() {
        return cocktail;
    }

    public void setCocktail(TCocktail cocktail) {
        this.cocktail = cocktail;
    }

    public TIngredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(TIngredient ingredient) {
        this.ingredient = ingredient;
    }
    
    
}
