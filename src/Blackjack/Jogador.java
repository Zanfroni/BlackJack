package Blackjack;//package com.T2IntroES;

/**
 * Classe que realiza todas as ações pertinentes ao jogador
 * @author Guilherme Munaretto
 * @author Octavio Carpez
 */
public class Jogador {
    private boolean isPlaying;
    //private boolean moreCards;
    private Mao primeiraMao;

    /**
     * Método construtor da classe Blackjack.Jogador
     */
    public Jogador(){
        this.primeiraMao = new Mao();
        isPlaying = true;
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
     * Retorna uma referência para a primeira mão do jogador
     * @return Uma referência para a primeira mão do jogador
     */
    public Mao getPrimeiraMao(){
        return this.primeiraMao;
    }


}
