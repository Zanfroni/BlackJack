//package com.T2IntroES;

/**
 * Classe que implementa a lógica do jogo Blackjack
 * @author Guilherme Munaretto
 * @author Octavio Carpez
 */
public class Blackjack {

    private Jogador jogador;
    private Baralho baralho;
    private Banca banca;

    /**
     * Método construtor da classe Blackjack
     */
    public Blackjack(){
        this.jogador = new Jogador();
        this.baralho = new Baralho();
        this.banca = new Banca(baralho);
    }

    /**
     * Retorna uma referência para o jogador da partida
     * @return Uma referência para o jogador da partida
     */
    public Jogador getJogador(){
        return this.jogador;
    }

    /**
     * Retorna uma referência para o dealer da partida
     * @return Uma referência para o dealer da partida
     */
    public Banca getBanca(){
        return this.banca;
    }


}
