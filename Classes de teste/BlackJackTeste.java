import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlackJackTeste {
	
	private Blackjack bj;

	@Before
	public void inicializar() {
		bj = new Blackjack();
	}
	
	@Test
	public void getJogadorTeste(){
		assertNotNull(bj.getJogador());
	}
	
	@Test
	public void getBancaTeste(){
		assertNotNull(bj.getBanca());
	}
	
	@Test
	public void hitTeste(){
		//O jogador deve estar jogando no inicio do jogo
		assertTrue(bj.getJogador().getIsPlaying());
		bj.hit(new Carta("Espada", "K", 10));
		bj.hit(new Carta("Paus", "J", 10));
		//O jogador não pode mais estar jogando
		assertFalse(bj.getJogador().getIsPlaying());
	}
	
	@Test
	public void standTeste(){
		bj.stand();
		int ban = bj.getBanca().getMao().getPontos();
		int jog = bj.getJogador().getPrimeiraMao().getPontos();
		 if (ban <= 21 && ban > jog)
			 assertFalse(bj.getJogador().getIsPlaying());
		 if(jog <= 21 && ban > 21)
			 assertFalse(bj.getBanca().getIsPlaying());
		 if(jog == 21 && ban == 21){
			 assertFalse(bj.getJogador().getIsPlaying() && bj.getBanca().getIsPlaying());
		 }
	}
	
	@Test
	public void surrenderTeste(){
		bj.surrender();
		assertFalse(bj.getJogador().getIsPlaying());
	}
	

}
