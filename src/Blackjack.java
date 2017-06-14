//package com.T2IntroES;

import java.util.Scanner;

/**
 * Classe que implementa a lógica do jogo Blackjack
 * @author Guilherme Munaretto
 * @author Octavio Carpez
 */
public class Blackjack {
    private int isSplitted;
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
        this.isSplitted = 0;
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


    /**
     * Faz a jogada de "hit", responsável por pedir mais cartas
     * @param c A carta a ser adicionada na mão do jogador
     */
    public boolean hit(Carta c){
        // Adiciona a carta na mão atual
        jogador.getMaoAtual().getMao().add(c);
        // Calcula os pontos do jogador ja com a nova carta em sua mão
        jogador.getMaoAtual().calculaPontos();
        if (jogador.getMaoAtual().getPontos() > 21){
            return false;
        }
        return true;
    }

    /**
     * Faz uma jogada de "hit" para a banca
     * @return True se nao estourou 21 pontos; False caso contrário
     */
    private boolean hitBanca(Carta c){
        // Adiciona a carta na mão atual
        banca.getMao().getMao().add(c);
        // Calcula os pontos do jogador ja com a nova carta em sua mão
        banca.getMao().calculaPontos();
        if (banca.getMao().getPontos() > 21){
            return false;
        }
        return true;
    }

    /**
     * Realiza a jogada "stand", indicando que o jogador não quer mais pedir cartas
     */
    public void stand(){
        jogador.setStand(false);
    }


//    public void split(int numeroMao){
//        if (numeroMao < 1 || numeroMao > 2){
//            System.out.println("Escolha entre a mão 1 e 2");
//            this.isSplitted = 0;
//        }
//        int valor1 = jogador.getMaoAtual().getMao().get(0).getValorNumerico();
//        int valor2 = jogador.getMaoAtual().getMao().get(1).getValorNumerico();
//
//        if (valor1 == valor2){
//            Carta c1 = jogador.getMaoAtual().getMao().remove(1);
//            jogador.getSegundaMao().add(c1);
//            if (numeroMao == 2){
//                jogador.setMaoAtual(jogador.getSegundaMao());
//            }
//            this.isSplitted = 1;
//            return;
//        }
//        System.out.println("Só é possível realizar um split quando duas cartas tiverem o mesmo valor");
//        this.isSplitted = 0;
//    }

//    /**
//     * Verifica e retorna o ganhador de uma rodada
//     * @return Uma string contendo um texto indicativo sobre o vencedor da rodada
//     */
//    private String verificaGanhador(){
//        // Caso de empate
//        if (!jogador.getIsPlaying() && !banca.getIsPlaying()){
//            return "Empate";
//        }
//        // Caso o jogador tenha vencido
//        else if (jogador.getIsPlaying() && !banca.getIsPlaying()){
//            return "Vencedor: Jogador";
//        }
//        // Caso a mesa tenha vencido
//        else if(!jogador.getIsPlaying() && banca.getIsPlaying()){
//            return "Vencedor: Dealer";
//        }
//        else{
//            return "Ok";
//        }
//    }

    private int jogada(){
        Scanner in = new Scanner(System.in);
        System.out.println("Faça uma jogada: \n"
        +"[1] - Hit: Pede mais uma carta \n" +
                "[2] - Split: Divide suas cartas entre duas mãos, caso tenham o mesmo valor \n" +
                "[3] - Stand: Encerra a jogada \n" +
                "[4] - Surrender: Desiste da partida");
        int order = in.nextInt();
        return order;
    }
    public void rodada(){

        // Remove as primeiras 2 cartas do baralho e adiciona na mão do jogador
        jogador.getMaoAtual().getMao().add(banca.getBaralho().getCartas().remove(0));
        jogador.getMaoAtual().getMao().add(banca.getBaralho().getCartas().remove(0));
        // Remove mais 2 cartas do baralho e adiciona na mão do dealer
        banca.getMao().getMao().add(banca.getBaralho().getCartas().remove(0));
        banca.getMao().getMao().add(banca.getBaralho().getCartas().remove(0));

        // Enquando o jogador não der um stand, permanece jogando
        while(jogador.getStand() == false){

            // Pega a ação do jogador
            int order = jogada();
            switch (order){
                case 1:
                    boolean flag = hit(banca.getBaralho().getCartas().remove(0));
                    // Se o hit estourou, o jogador perdeu
                    if (!flag){
                        System.out.println("Vencedor: Dealer");
                        System.out.println("Você estourou o limite de 21 pontos");
                        break;
                    }
                case 2: stand();


                case 3:
                    System.out.println("Vencedor: Banca");
                    System.out.println("O jogador desistiu da partida");


            }
        }

        // Jogada da banca

        banca.getMao().calculaPontos();
        jogador.getPrimeiraMao().calculaPontos();

        // Se os pontos da banca forem maior do que o do jogador, ela ganha
        if (banca.getMao().getPontos() > jogador.getPrimeiraMao().getPontos()){
            System.out.println("Vencedor: Banca");
            banca.setIsPlaying(false);
            jogador.setIsPlaying(false);
        }
        // Se a banca e o jogador tiverem um blackjack
        else if(banca.getMao().getPontos() == 21 && jogador.getPrimeiraMao().getPontos() == 21){
            System.out.println("Empate");
            banca.setIsPlaying(false);
            jogador.setIsPlaying(false);
        }
        // Caso a banca tenha menos pontos que o jogador, deverá comprar mais cartas
        while(banca.getIsPlaying() && banca.getCount() < 7){
            banca.getMao().calculaPontos();
            jogador.getPrimeiraMao().calculaPontos();

            // Se o numero de pontos da banca for menor do que o jogador, comprar até estourar,
            // ganhar ou empatar
            if (banca.getMao().getPontos() < jogador.getPrimeiraMao().getPontos()){
                if(!hitBanca(banca.getBaralho().getCartas().remove(0))){
                    System.out.println("Vencedor: Jogador");
                    System.out.println("A banca estourou o limite de 21 pontos");
                    banca.setIsPlaying(false);
                }
            }
        }


    }



}
