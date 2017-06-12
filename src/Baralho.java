package com.T2IntroES;

import java.util.*;


/**
 * Classe responsável por realizar todas as operações pertinentes ao baralho
 * @author Guilherme Munaretto
 * @author Octavio
 */
public class Baralho {

    private ArrayList<Carta> baralho;


    public Baralho() {
        baralho = new ArrayList<Carta>();
        fill();
        // Embaralhando o baralho
        Collections.shuffle(baralho);
    }

    private void fill(){
        // Verificando se o varalho não está completo
        if (baralho.size() >= 52){
            return;
        }

        String[] naipes = {"Copas", "Espada", "Ouro", "Paus"};
        String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int indexNaipes = 0;
        int indexValores = 0;

        // Enquanto ainda tenho naipes para inserir
        while(indexNaipes <= 3){
            // Se já inseri todas as cartas de um naipe, pula para o próximo
            if (indexValores == 13){
                indexNaipes++;
                indexValores = 0;
            }
            // Inserindo as cartas no baralho
            baralho.add(new Carta(naipes[indexNaipes],valores[indexValores]));
            indexValores++;
        }
    }

    public ArrayList<Carta> getBaralho(){ return baralho;}

    public int getSize(){
        return baralho.size();
    }

}
