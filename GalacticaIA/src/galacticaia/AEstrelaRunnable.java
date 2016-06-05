/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticaia;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class AEstrelaRunnable implements Runnable{

    private final ArrayList<Coordenada> listaAberta;
    private final ArrayList<Coordenada> listaFechada;
    private final Campo iniciarCampo;
    private final Coordenada[][] grade;
    private Personagem combPersonagem[][];

    public AEstrelaRunnable(Campo iniCampo) {
        this.grade = iniCampo.getCampo();
        this.iniciarCampo = iniCampo;
        listaAberta = new ArrayList<>();
        listaFechada = new ArrayList<>();
    }
    
    
    
    @Override
    public void run() {
        ArrayList<Personagem> lstPersonagens = iniciarCampo.getLstPersonagens();
        Coordenada position = iniciarCampo.getCoorIni();
        ArrayList<Coordenada> pontos = iniciarCampo.getCoorBoss();
        ArrayList<Coordenada> casas = (ArrayList<Coordenada>) pontos.clone();
        
        pontos.add(iniciarCampo.getCoorFim());
        
        for (Coordenada boss : pontos) {
            listaAberta.add(position);
            
            
            position = moverBoss(boss);
            //Parada na casa do boss as cordenadas estao na variavel "position"
            double somaForcaCasa = somaCasas(casas);
            double somaForcaPersonagem = somaPersonagem(lstPersonagens);
            
            
            
            //-----
            Coordenada corrente=position.getPai();
            while (corrente!=null) {
                iniciarCampo.getCaminho()[corrente.getLinha()][corrente.getColuna()] = 1;
                corrente =  corrente.getPai();
            }
            position.setPai(null);
            listaAberta.clear();
            listaFechada.clear();
            casas.remove(boss);
        }
        
    }
    
    public Coordenada moverBoss(Coordenada boss) {
        
        Coordenada corrente = listaAberta.get(0);
        
        for (Coordenada x : listaAberta) {
            if(corrente.getCustoTotal() > x.getCustoTotal()){
                corrente = x;
            }
        }
        
        listaFechada.add(corrente);
        listaAberta.remove(corrente);
        if(iniciarCampo.getCaminho()[corrente.getLinha()][corrente.getColuna()] == 0)
            iniciarCampo.getCaminho()[corrente.getLinha()][corrente.getColuna()] = 2;
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(AEstrelaRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(Coordenada.isCoordenateEqual(corrente, boss)){
            
            return corrente;
        }
        
        if(corrente.getLinha() - 1 >= 0){
            Coordenada pSuperior = this.iniciarCampo.getCampo()[corrente.getLinha()-1][corrente.getColuna()];
            if(!listaFechada.contains(pSuperior)){
                int custoG = pSuperior.getCusto();
                int custoH = this.getDistancia(pSuperior, boss);
                if(!listaAberta.contains(pSuperior)){
                    pSuperior.setPai(corrente);
                    listaAberta.add(pSuperior);
                    pSuperior.setCustoG(custoG);
                    pSuperior.setCustoH(custoH);
                }else{
                    if(pSuperior.getCustoH()> custoH){
                        pSuperior.setPai(corrente);       
                        pSuperior.setCustoG(custoG);      
                        pSuperior.setCustoH(custoH);
                    }
                }
            }
        }
        
        if(corrente.getLinha() + 1 >= 0){
            Coordenada pInferior = grade[corrente.getLinha() + 1][corrente.getColuna()];
            if(!listaFechada.contains(pInferior)){
                int custoG = pInferior.getCusto();
                int custoH = this.getDistancia(pInferior, boss);
                if(!listaAberta.contains(pInferior)){
                    pInferior.setPai(corrente);
                    listaAberta.add(pInferior);
                    pInferior.setCustoG(custoG);
                    pInferior.setCustoH(custoH);
                }else{
                    if(pInferior.getCustoH()> custoH){
                        pInferior.setPai(corrente);       
                        pInferior.setCustoG(custoG);      
                        pInferior.setCustoH(custoH);
                    }
                }
            }
        }
        
        if(corrente.getColuna() + 1 >= 0){
            Coordenada pDireita = grade[corrente.getLinha()][corrente.getColuna() + 1];
            if(!listaFechada.contains(pDireita)){
                int custoG = pDireita.getCusto();
                int custoH = this.getDistancia(pDireita, boss);
                if(!listaAberta.contains(pDireita)){
                    pDireita.setPai(corrente);
                    listaAberta.add(pDireita);
                    pDireita.setCustoG(custoG);
                    pDireita.setCustoH(custoH);
                }else{
                    if(pDireita.getCustoH()> custoH){
                        pDireita.setPai(corrente);       
                        pDireita.setCustoG(custoG);      
                        pDireita.setCustoH(custoH);
                    }
                }
            }
        }
        
        if(corrente.getColuna() - 1 >= 0){
            Coordenada pEsquerda = grade[corrente.getLinha()][corrente.getColuna() - 1];
            if(!listaFechada.contains(pEsquerda)){
                int custoG = pEsquerda.getCusto();
                int custoH = this.getDistancia(pEsquerda, boss);
                if(!listaAberta.contains(pEsquerda)){
                    pEsquerda.setPai(corrente);
                    listaAberta.add(pEsquerda);
                    pEsquerda.setCustoG(custoG);
                    pEsquerda.setCustoH(custoH);
                }else{
                    if(pEsquerda.getCustoH()> custoH){
                        pEsquerda.setPai(corrente);       
                        pEsquerda.setCustoG(custoG);      
                        pEsquerda.setCustoH(custoH);
                    }
                }
            }
        }
        
        if (listaAberta.isEmpty()) {    //nao ha nenhum caminho
            return null;
        }
        
        return moverBoss(boss);
        
    }
    
    public Integer getDistancia(Coordenada p1, Coordenada p2) {
        Integer linha = Math.abs(p1.getLinha() - p2.getLinha());
        Integer coluna = Math.abs(p1.getColuna() - p2.getColuna());

        return linha + coluna;
    }

    private double somaCasas(ArrayList<Coordenada> casas) {
        double result=0;
        for(Coordenada boss : casas){
            result += boss.getCusto();
        }
        return result;
    }

    private double somaPersonagem(ArrayList<Personagem> lstPersonagens) {
        double result = 0;
        for(Personagem p : lstPersonagens){
            result += p.getPoder()*p.getQtdLuta();
        }
        
        return result;
        
    }
    
}
