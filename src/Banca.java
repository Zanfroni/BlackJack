//package com.T2IntroES;
import java.util.*;
/**
 * Classe responsável por guardar as informações do dealer.
 * @author Guilherme Munaretto
 * @author Octavio Carpez
 */
public class Banca {
    private int pontos;
    private int count;
    private Baralho baralho;
    private ArrayList<Carta> mao;

    /**
     * Método construtor da banca
     * @param baralho Um baralho de cartas
     */
    public Banca(Baralho baralho) {
        this.mao = new ArrayList<Carta>();
        this.baralho = baralho;
        this.count  = baralho.getSize();
        this.pontos = 0;
    }

    /**
     * Retorna o tamanho do baralho
     * @return O tamanho do baralho
     */
    public int count(){
        return this.count;
    }

    /**
     * Retorna uma referênia para a mão do dealer
     * @return Uma referência para a mão do dealer
     */
    public ArrayList<Carta> getMao(){
        return this.mao;
    }

    /**
     * Retorna uma referência para o baralho da banca
     * @return Uma referência para o baralho da banca
     */
    public Baralho getBaralho(){
        return this.baralho;
    }


}

