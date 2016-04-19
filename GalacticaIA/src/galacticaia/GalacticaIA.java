/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticaia;

import javax.swing.JFrame;

/**
 *
 * @author Guilherme
 */
public class GalacticaIA extends JFrame{

    public GalacticaIA() {
        IniciarCampo iniciarCampo = new IniciarCampo();
        Integer[][] campo = iniciarCampo.getCampo();
        TelaPrincipal telaPrincipal = new TelaPrincipal(campo);
        telaPrincipal.setVisible(true);
        
    }

    
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GalacticaIA();
            }
        });
        
    }
    
}
