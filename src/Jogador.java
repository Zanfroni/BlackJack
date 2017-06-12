package com.T2IntroES;

import java.util.ArrayList;

/**
 * Classe que realiza todas as ações pertinentes ao jogador
 * @author Guilherme Munaretto
 * @author Octavio
 */
public class Jogador {
    private int pontos;
    private ArrayList<Carta> mao;
    private ArrayList<Carta> segundaMao;

    public Jogador(){
        mao = new ArrayList<Carta>();
        segundaMao = new ArrayList<Carta>();
        pontos = 0;
        receberMao();
    }

    // Recebe a mão inicial da banca
    private void receberMao(Carta c1, Carta c2){
        mao.add(c1);
        mao.add(c2);
    }

    // Continua a pedir cartas
    public void hit(Carta c){
        mao.add(c);
    }

    //Para de receber cartas
    public boolean stand(){
        return false;
    }

    // jogada Split:
    // Se as primeiras 2 cartas do jogador forem de valores iguais, ele pode escolher
    // dividir suas cartas em 2 mãos diferentes então ele pode jogar com as 2 mãos.
    // se ele estoura uma mão ele não sai do jogo, pode jogar até estourar a segunda mão

    // Sai do jogo
    public void surrender(){

    }
}
