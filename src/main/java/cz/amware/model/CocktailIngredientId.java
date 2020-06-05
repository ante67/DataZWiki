/*
 * To change this license header, choose License Headers in 
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;


/**
 *
 * @author m.ambros
 */
@Embeddable
public class CocktailIngredientId implements Serializable {
    @Column(name="cocktail_Id")
    private long cocktailId;
    
    @Column(name="ingredient_Id")
    private long ingredientId;
    
    public CocktailIngredientId(){
        super();
    }
    
    public CocktailIngredientId(Long cocktailId, Long ingredientId){
        this.cocktailId=cocktailId;
        this.ingredientId=ingredientId;        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (this.cocktailId ^ 
                (this.cocktailId >>> 32));
        hash = 43 * hash + (int) (this.ingredientId ^ 
                (this.ingredientId >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CocktailIngredientId other = (CocktailIngredientId) obj;
        if (this.cocktailId != other.cocktailId) {
            return false;
        }
        if (this.ingredientId != other.ingredientId) {
            return false;
        }
        return true;
    }
}
