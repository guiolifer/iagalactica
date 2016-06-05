/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticaia;

/**
 *
 * @author Guilherme
 */
public class Personagem {
    
    private String nome;
    private double poder;
    private int qtdLuta;
    
    public Personagem(String nome, double poder) {
        this.nome = nome;
        this.poder = poder;
        qtdLuta = 5;
    }

    public int getQtdLuta() {
        return qtdLuta;
    }

    public void setQtdLuta(int qtdLuta) {
        this.qtdLuta = qtdLuta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPoder() {
        return poder;
    }

    public void setPoder(double poder) {
        this.poder = poder;
    }
    
    
}
