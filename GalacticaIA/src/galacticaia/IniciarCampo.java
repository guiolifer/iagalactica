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
public class IniciarCampo {

    protected int linha = 0;
    protected int coluna = 0;
    private Integer campo[][];
    private Coordenada coorIni;
    private Coordenada coorFim;
    private ArrayList<Coordenada> coorBoss;
    

    
    public IniciarCampo(File f) {
        coorBoss = new ArrayList<Coordenada>();
        
        try {
            // TODO code application logic here

            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String lerLinha;
            campo = new Integer[27][33];
            String[] splited;

            while ((lerLinha = bufferedReader.readLine()) != null) {

                splited = lerLinha.split("\\|");
                for (String string : splited) {
                    if (!string.equals("")) {
                        if(Integer.parseInt(string)==10){
                            coorIni = new Coordenada(linha, coluna);
                        }else if (Integer.parseInt(string)==100) {
                            coorFim = new Coordenada(linha, coluna);
                        }
                        campo[linha][coluna++] = Integer.parseInt(string);
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
        coorBoss.add(new Coordenada(22, 17));
        coorBoss.add(new Coordenada(19, 4));
        coorBoss.add(new Coordenada(16, 13));
        coorBoss.add(new Coordenada(16, 24));
        coorBoss.add(new Coordenada(9, 18));
        coorBoss.add(new Coordenada(9, 10));
        coorBoss.add(new Coordenada(4, 9));
        coorBoss.add(new Coordenada(4, 21));
        
    }

    

    public Integer[][] getCampo() {
        return campo;
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
    
    
    
    
    
}
