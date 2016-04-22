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
    private int custo;
    private int custoG = 0;
    private int custoH = 9999;
    private Coordenada pai = null;
    
    public Coordenada(Integer linha, Integer coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.custo = custo;
    }

    public Coordenada(Integer linha, Integer coluna, Integer custo) {
        this.linha = linha;
        this.coluna = coluna;
        this.custo = custo;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
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

    public int getCustoG() {
        return custoG;
    }

    public void setCustoG(int custoG) {
        this.custoG = custoG;
    }

    public int getCustoH() {
        return custoH;
    }

    public void setCustoH(int custoH) {
        this.custoH = custoH;
    }

    public Coordenada getPai() {
        return pai;
    }

    public void setPai(Coordenada pai) {
        this.pai = pai;
    }
    
    
    public int getCustoTotal(){
        return custoG + custoH;
    }
    
    
    
}
