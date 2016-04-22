/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticaia;

import java.util.Objects;

/**
 *
 * @author Guilherme
 */
public class Coordenada {
    private Integer linha;
    private Integer coluna;

    public Coordenada(Integer linha, Integer coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    
    
    /**
     * @return the linha
     */
    public Integer getLinha() {
        return linha;
    }

    /**
     * @return the coluna
     */
    public Integer getColuna() {
        return coluna;
    }

    /**
     * @param linha the linha to set
     */
    public void setLinha(Integer linha) {
        this.linha = linha;
    }

    /**
     * @param coluna the coluna to set
     */
    public void setColuna(Integer coluna) {
        this.coluna = coluna;
    }
    
    public static boolean isCoordenateEqual(Coordenada c1, Coordenada c2){
        if(Objects.equals(c1.getLinha(), c2.getLinha()) && Objects.equals(c1.getColuna(), c2.getColuna())){
            return true;
        }
        return false;
        
    }
    
    
    
}
