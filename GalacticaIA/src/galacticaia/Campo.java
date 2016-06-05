/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticaia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class Campo {

    protected int linha = 0;
    protected int coluna = 0;
    private Coordenada campo[][];
    private Integer caminho[][];
    private Coordenada coorIni;
    private Coordenada coorFim;
    private ArrayList<Coordenada> coorBoss;
    private ArrayList<Personagem> lstPersonagens;
    

    
    public Campo(File f) {
        coorBoss = new ArrayList<>();
        lstPersonagens = new ArrayList<>();
        
        try {
            // TODO code application logic here

            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String lerLinha;
            campo = new Coordenada[27][33];
            caminho = new Integer[27][33];
            String[] splited;
            
            while ((lerLinha = bufferedReader.readLine()) != null) {

                splited = lerLinha.split("\\|");
                for (String string : splited) {
                    if (!string.equals("")) {
                        
                        caminho[linha][coluna] = 0;
                        campo[linha][coluna] = new Coordenada(linha, coluna, Integer.parseInt(string));
                        coluna++;
                        
                    }
                }
                linha++;
                coluna = 0;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        coorBoss.add(new Coordenada(22, 17, 50, "Casa Áries"));
        coorBoss.add(new Coordenada(19, 4 , 60, "Casa Touro"));
        coorBoss.add(new Coordenada(16, 13, 70, "Casa Gêmios"));
        coorBoss.add(new Coordenada(16, 24, 80, "Casa Cancer"));
        coorBoss.add(new Coordenada(9, 18, 90, "Casa Leao"));
        coorBoss.add(new Coordenada(9, 10, 100, "Casa Virgem"));
        coorBoss.add(new Coordenada(4, 9, 110, "Casa Libra"));
        coorBoss.add(new Coordenada(4, 21, 120, "Casa Escorpiao"));
        coorIni = new Coordenada(22, 28);
        coorFim = new Coordenada(4, 28);
        lstPersonagens.add(new Personagem("Seiya", 1.5));
        lstPersonagens.add(new Personagem("Shiryu", 1.4));
        lstPersonagens.add(new Personagem("Hyoga", 1.3));
        lstPersonagens.add(new Personagem("Shun", 1.2));
        lstPersonagens.add(new Personagem("Lkki", 1.1));
        
    }

    

    

    /**
     * @return the coorIni
     */
    public Coordenada getCoorIni() {
        return coorIni;
    }

    /**
     * @param coorIni the coorIni to set
     */
    public void setCoorIni(Coordenada coorIni) {
        this.coorIni = coorIni;
    }

    /**
     * @return the coorFim
     */
    public Coordenada getCoorFim() {
        return coorFim;
    }

    /**
     * @param coorFim the coorFim to set
     */
    public void setCoorFim(Coordenada coorFim) {
        this.coorFim = coorFim;
    }

    /**
     * @return the coorBoss
     */
    public ArrayList<Coordenada> getCoorBoss() {
        return coorBoss;
    }

    /**
     * @param coorBoss the coorBoss to set
     */
    public void setCoorBoss(ArrayList<Coordenada> coorBoss) {
        this.coorBoss = coorBoss;
    }

    public Integer[][] getCaminho() {
        return caminho;
    }

    public void setCaminho(Integer[][] caminho) {
        this.caminho = caminho;
    }

    public Coordenada[][] getCampo() {
        return campo;
    }

    public void setCampo(Coordenada[][] campo) {
        this.campo = campo;
    }

    public ArrayList<Personagem> getLstPersonagens() {
        return lstPersonagens;
    }
}
