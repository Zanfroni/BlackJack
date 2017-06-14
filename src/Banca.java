//package com.T2IntroES;
//import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.*;
/**
 * Classe responsável por guardar as informações do dealer.
 * @author Guilherme Munaretto
 * @author Octavio Carpez
 */
public class Banca {
    private boolean isPlaying;
    private int pontos;
    private int count;
    private Baralho baralho;
    private Mao mao;

    /**
     * Método construtor da banca
     * @param baralho Um baralho de cartas
     */
    public Banca(Baralho baralho) {
        this.mao = new Mao ();
        this.baralho = baralho;
        this.count  = mao.getMao().size();
        this.isPlaying = true;
    }

    /**
     * Consulta o valor da variável isPlaying, retornando-a
     * @return O valor da variável isPlaying
     */
    public boolean getIsPlaying(){
        return this.isPlaying;
    }

    /**
     * Atualiza o valor da variável isPlaying para o statu passado por parâmetro
     * @param status O novo valor da variável isPlaying
     */
    public void setIsPlaying(boolean status){
        this.isPlaying = status;
    }


    /**
     * Retorna uma referênia para a mão do dealer
     * @return Uma referência para a mão do dealer
     */
    public Mao getMao(){
        return this.mao;
    }

    /**
     * Retorna uma referência para o baralho da banca
     * @return Uma referência para o baralho da banca
     */
    public Baralho getBaralho(){
        return this.baralho;
    }

    /**
     * Retorna a quantidade de cartas da mão da banca
     * @return A quantidade de cartas da mão da banca
     */
    public int getCount() {
        return count;
    }
}

