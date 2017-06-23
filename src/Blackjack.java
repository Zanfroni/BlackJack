//package com.T2IntroES;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        iniciaJogo();
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
    public void hit(Carta c){
        // Adiciona a carta na mão atual
        jogador.getPrimeiraMao().getMao().add(c);
        // Calcula os pontos do jogador ja com a nova carta em sua mão

        if (jogador.getPrimeiraMao().getPontos() > 21){
            jogador.setIsPlaying(false);
        }
    }

    /**
     * Faz uma jogada de "hit" para a banca (Pede uma carta do baralho da banca)
     * @param c A carta a ser adicionada na mão da banca
     */
    private void hitBanca(Carta c){
        // Adiciona a carta na mão atual
        banca.getMao().getMao().add(c);
        // Calcula os pontos do jogador ja com a nova carta em sua mão
        if (banca.getMao().getPontos() > 21){
            banca.setIsPlaying(false);
        }
    }

    /**
     * Faz a jogada stand
     */
    public void stand(){

        // Caso a banca tenha mais pontos que o jogador e não tenha estourado 21 pontos, então ela é o vencedor
        if (banca.getMao().getPontos() > jogador.getPrimeiraMao().getPontos()){
            jogador.setIsPlaying(false);
            return;

        }
        // Caso o jogador tenha mais pontos que a banca e não tenha estourado 21 pontos, a banca deve comprar mais cartas
        else if (jogador.getPrimeiraMao().getPontos() > banca.getMao().getPontos()){
            // Enquanto a banca estiver jogando e tiver menos de 7 cartas na mão
            while(banca.getCount() <= 7 && banca.getIsPlaying()){
                // Compra uma nova carta do baralho
                hitBanca(banca.getBaralho().getCartas().remove(0));
                // Se após comprar, a banca possui mais pontos do que o jogador sem estourar o limite de 21, então ela venceu
                if (banca.getMao().getPontos() > jogador.getPrimeiraMao().getPontos() && banca.getMao().getPontos() <= 21){
                    jogador.setIsPlaying(false);
                    return;
                }
                // Se a banca estourou o limite de 21 pontos, então ela perdeu
                if(banca.getMao().getPontos() > 21){
                    banca.setIsPlaying(false);
                    return;
                }
            }
            banca.setIsPlaying(false);
        }
        // Caso ambos tenham um blackjack, então da empate
        else if(jogador.getPrimeiraMao().getPontos() == 21 && banca.getMao().getPontos() == 21){
            jogador.setIsPlaying(false);
            banca.setIsPlaying(false);
        }

    }

    /**
     * Realiza a jogada "surrender", fazendo o jogador desistir da partida e o dealer ser o vencedor
     */
    public void surrender(){
        jogador.setIsPlaying(false);
    }

    /**
     * Verifica e retorna o ganhador de uma rodada
     * @return Uma string contendo um texto indicativo sobre o vencedor da rodada
     */
    private String verificaGanhador(){
        if(jogador.getIsPlaying()){
            if (banca.getMao().getPontos() == 21){
                jogador.setIsPlaying(false);
            }
            if (banca.getMao().getPontos() == 21 && jogador.getPrimeiraMao().getPontos() == 21) {
                return "Empate";
            }
            if (banca.getMao().getPontos() > 21){
                banca.setIsPlaying(false);
            }
            if(jogador.getPrimeiraMao().getPontos() == 21){
                banca.setIsPlaying(false);
            }
            if(jogador.getPrimeiraMao().getPontos() > 21){
                jogador.setIsPlaying(false);
            }
        }

        // Caso de empate
        if (!jogador.getIsPlaying() && !banca.getIsPlaying()){
            return "Empate";
        }
        // Caso o jogador tenha vencido
        else if (jogador.getIsPlaying() && !banca.getIsPlaying()){
            return "Jogador";
        }
        // Caso a mesa tenha vencido
        else if(!jogador.getIsPlaying() && banca.getIsPlaying()){
            return "Dealer";
        }
        else{
            return "Ok";
        }
    }

    /**
     * Método que executa a lógica de uma rodada no jogo 21
     * @param jogada é a próxima jogada que o jogador deseja executar
     * @return Uma string contendo o status atual do jogo
     */
    public String rodada(String jogada){

        String statusJogo = verificaGanhador();
        mostraCartas();
        // Verifica se o jogo ja terminou no inicio
        if(!statusJogo.equals("Ok")){
            return statusJogo;
        }


        // Caso a jogada seja um hit
        if(jogada.equals("hit")){
            // Verifica o status do jogo (antes de fazer a jogada)
            statusJogo = verificaGanhador();
            // Se for diferente de "ok", retorna o nome do vencedor
            if(!statusJogo.equals("Ok")){
                return statusJogo;
            }

            // Da uma carta ao jogador
            hit(banca.getBaralho().getCartas().remove(0));

            // Verifica o status do jogo (depois de fazer a jogada)
            statusJogo = verificaGanhador();
            mostraCartas();
            // Se for diferente de "ok", retorna o nome do vencedor
            if(!statusJogo.equals("Ok")){
                return statusJogo;
            }
        }

        // Caso a jogada seja um stand
        else if(jogada.equals("stand")){
            // Verifica o status do jogo (antes de fazer a jogada)
            statusJogo = verificaGanhador();
            // Se for diferente de "ok", retorna o nome do vencedor
            if(!statusJogo.equals("Ok")){
                return statusJogo;
            }

            stand();

            // Verifica o status do jogo (antes de fazer a jogada)
            statusJogo = verificaGanhador();
            mostraCartas();
            // Se for diferente de "ok", retorna o nome do vencedor
            if(!statusJogo.equals("Ok")){
                return statusJogo;
            }

        }

        // Caso a jogada seja um surrender
        else if (jogada.equals("surrender")){
            mostraCartas();
            return "Dealer";
        }

        // Caso o jogador deseje salvar o progresso atual
        else if(jogada.equals("save")){
            salvaJogo();
        }
        else{
            System.out.print("Você deseja salvar o seu progresso? [sim/nao]");
            Scanner in = new Scanner(System.in);
            boolean flag = false;
            while(!flag){
                String opcao = in.next();
                if(opcao.equals("sim") || opcao.equals("nao")){
                    if (opcao.equals("sim")){
                        salvaJogo();
                        flag = true;
                    }
                    else{
                        flag = true;
                    }
                }
            }
            System.exit(0);
        }
        return "";
    }

    /**
     * Método que distribui as cartas iniciais e inicia o jogo
     */
    private String iniciaJogo(){
        // Se as mãos da banca e do jogador estiverem vazias, dou as cartas iniciais
        if (jogador.getPrimeiraMao().getMao().size() == 0 && banca.getMao().getMao().size() == 0){
            // Retira 2 cartas do baralho da banca e adiciona na mão do jogador
            jogador.getPrimeiraMao().getMao().add(banca.getBaralho().getCartas().remove(0));
            jogador.getPrimeiraMao().getMao().add(banca.getBaralho().getCartas().remove(0));
            // Retira 2 cartas do baralho da banca e adiciona na mão da banca
            banca.getMao().getMao().add(banca.getBaralho().getCartas().remove(0));
            banca.getMao().getMao().add(banca.getBaralho().getCartas().remove(0));
        }
        mostraCartas();
        // Verificando se há um ganhador no inicio da partida
        String status = verificaGanhador();
        // Se o status for diferente de Ok, retorna ele mesmo
        if (!status.equals("Ok")){
            return status;
        }
        return "";
    }

    /**
     * Imprime no console as cartas contidas na mão do dealer e do jogador
     * @requires
     */
    private void mostraCartas(){
        // Imprime as cartas da mão do jogador
        System.out.println("--------------------------------------------------------------");
        System.out.println("Mão do Jogador: ");
        for(Carta c : jogador.getPrimeiraMao().getMao()){
            System.out.println("["+c.getValor()+" de "+c.getNaipe()+"]");;
        }
        System.out.println("--------------------------------------------------------------");

        System.out.println("");

        // Imprime as cartas da mão do dealer
        System.out.println("--------------------------------------------------------------");
        System.out.println("Mão do Dealer: ");
        for(Carta c : banca.getMao().getMao()){
            System.out.println("["+c.getValor()+" de "+c.getNaipe()+"]");
        }
        System.out.println("--------------------------------------------------------------");
    }

    /**
     * Método utilizado no final de cada partida para imprimir em um arquivo o vencedor e a sua quantia de pontos
     */
    public void salvaJogo() {

        try {


            File file = new File("progresso.txt");
            BufferedWriter br = new BufferedWriter(new FileWriter(file));

            //TODO Padrão; J:PontosJogador
            //TODO Naipe1;Carta1
            //TODO ...
            //TODO (espaço em branco)

            //TODO Padrão; B:PontosBanca
            //TODO Naipe1;Carta1
            //TODO ...
            //TODO (espaço em branco)

            br.write("J;" + jogador.getPrimeiraMao().getPontos());
            br.newLine();
            for (Carta c : jogador.getPrimeiraMao().getMao()) {
                br.write(c.getNaipe() + ";" + c.getValor());
                br.newLine();
            }
            br.newLine();


            br.write("B;" + banca.getMao().getPontos());
            br.newLine();
            for (Carta c : banca.getMao().getMao()) {
                br.write(c.getNaipe() +";"+ c.getValor());
                br.newLine();
            }
            br.newLine();
            br.newLine();
            br.flush();
            br.close();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    /**
     * Método que reseta o estado da partida
     */
    public void reset(){
            this.jogador = new Jogador();
            this.baralho = new Baralho();
            this.banca = new Banca(baralho);
            this.isSplitted = 0;
            iniciaJogo();
    }

}







