//package com.T2IntroES;

import java.util.ArrayList;

/**
 * Classe que realiza todas as ações pertinentes ao jogador
 * @author Guilherme Munaretto
 * @author Octavio Carpez
 */
public class Jogador {
    private int pontos;
    private boolean isPlaying;
    private boolean moreCards;
    private ArrayList<Carta> mao;
    private ArrayList<Carta> segundaMao;

    /**
     * Método construtor da classe Jogador
     */
    public Jogador(){
        mao = new ArrayList<Carta>();
        segundaMao = new ArrayList<Carta>();
        isPlaying = true;
        moreCards = true;
        pontos = 0;
    }

    /**
     * Atribui um novo valor para o status do jogador
     * @param status Novo status a ser atualizado
     */
    public void setIsPlaying(boolean status){
        this.isPlaying = status;
    }

    /**
     * Retorna o status do jogador
     * @return Um booleano contendo o status do jogador na partida
     */
    public boolean getIsPlaying(){
        return this.isPlaying;
    }

    /**
     * Altera o valor da variável de controle sobre o recebimento de novas cartas
     * @param bool Novo valor da variável
     */
    public void setMoreCards(boolean bool){
        this.moreCards = bool;
    }

    /**
     * Retorna o estado atual da variável de controle sobre o recebimento de novas cartas
     * @return O valor atual da variável
     */
    public boolean getMoreCards(){
        return this.moreCards;
    }

    /**
     * Retorna uma referência para a primeira mão do jogador
     * @return Uma referência para a primeira mão do jogador
     */
    public ArrayList<Carta> getMao(){
        return this.mao;
    }

    /**
     * Retorna uma referência para a segunda mão do jogador
     * @return Uma referência para a segunda mão do jogador
     */
    public ArrayList<Carta> getSegundaMao(){
        return this.segundaMao;
    }

}
