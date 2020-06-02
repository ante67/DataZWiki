/*
 * To change this license header, choose License Headers in Project Properties.
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
    @Column(name="cocktail_id")
    private long cocktail_id;
    
    @Column(name="ingredient_id")
    private long ingredient_id;
    
    public CocktailIngredientId(){
        super();
    }
    
    public CocktailIngredientId(Long cocktail_id, Long ingredient_id){
        this.cocktail_id=cocktail_id;
        this.ingredient_id=ingredient_id;        
    }
}
