package VinteUm;

import java.util.ArrayList;

/**
 * Classe destinada a armazenar as informações referentes às mãos da banca e do jogador
 * @author Guilherme Munaretto
 */
public class Mao {
    private ArrayList<Carta> mao;
    //private int pontos;

    public Mao() {
        this.mao = new ArrayList<Carta>();
    }

    /**
     * Método que retorna uma referência para um ArrayList de cartas
     * @return Uma referência para um ArrayList de cartas
     */
    public ArrayList<Carta> getMao() {
        return mao;
    }

//    /**
//     * Retorna um inteiro contendo o número de pontos da mão
//     * @return
//     */
//    public int getPontos() {
//        return pontos;
//    }

    /**
     * Função que calcula e retorna a quantidade de pontos de uma mão com base no valor das suas cartas
     */
    public int getPontos(){
        if (mao.size() <= 0){
            return 0;
        }
        int pontos = 0;
        for(Carta c: mao){
            pontos = pontos + c.getValorNumerico();
        }
        return pontos;
    }
}