//package com.T2IntroES;

import java.util.ArrayList;

/**
 * Classe que realiza todas as ações pertinentes ao jogador
 * @author Guilherme Munaretto
 * @author Octavio Carpez
 */
public class Jogador {
    private boolean isPlaying;
    private boolean moreCards;
    private Mao maoAtual;
    private Mao primeiraMao;
    private Mao segundaMao;

    /**
     * Método construtor da classe Jogador
     */
    public Jogador(){
        this.primeiraMao = new Mao();
        this.maoAtual = primeiraMao;
        this.segundaMao = new Mao();
        isPlaying = true;
        moreCards = true;
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
    public void setStand(boolean bool){
        this.moreCards = bool;
    }

    /**
     * Retorna o estado atual da variável de controle sobre o recebimento de novas cartas
     * @return O valor atual da variável
     */
    public boolean getStand(){
        return this.moreCards;
    }

    /**
     * Retorna uma referência para a primeira mão do jogador
     * @return Uma referência para a primeira mão do jogador
     */
    public Mao getPrimeiraMao(){
        return this.primeiraMao;
    }

    /**
     * Retorna uma referência para a segunda mão do jogador
     * @return Uma referência para a segunda mão do jogador
     */
    public Mao getSegundaMao(){
        return this.segundaMao;
    }

    /**
     * Retorna uma referência para a mão atual do jogador
     * @return Uma referência para a mão atual do jogador
     */
    public Mao getMaoAtual(){
        return this.maoAtual;
    }

    /**
     * Atualiza a mão atual do jogador
     * @param newMao A nova mão atual do jogador
     */
    public void setMaoAtual(Mao newMao){
        this.maoAtual = newMao;
    }

}
