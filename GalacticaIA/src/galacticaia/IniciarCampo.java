/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticaia;

import java.io.BufferedReader;
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
    

    
    public IniciarCampo() {
        
        
        try {
            // TODO code application logic here

            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Guilherme\\Documents\\NetBeansProjects\\iagalactica\\GalacticaIA\\campo2.txt"));
            String lerLinha;
            campo = new Integer[27][33];
            String[] splited;

            while ((lerLinha = bufferedReader.readLine()) != null) {

                splited = lerLinha.split("\\|");
                for (String string : splited) {
                    if (!string.equals("")) {
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

    }

    public Integer[][] getCampo() {
        return campo;
    }
    
    

}
