import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JogadorTeste {

	private Jogador jogador;
	
	@Before
	public void iniciar(){
		jogador = new Jogador();
	}
	
	@Test
	public void construtorTeste() {
		//garanta que a referência criada não seja null
		assertNotNull(jogador);
	}
	
	@Test
	public void getIsPlayingTeste(){
		//teste com o jogador jogando
		assertTrue(jogador.getIsPlaying());
	}
	
	@Test
	public void getPrimeiraMaoTeste(){
		//garanta que a referência para a mao não seja null
		assertNotNull(jogador.getPrimeiraMao());
	}

	
	@Test
	public void setIsPlayingTeste(){
		//teste com o jogador jogando
		jogador.setIsPlaying(true);
		assertTrue(jogador.getIsPlaying());
		//teste com o jogador NAO jogando
		jogador.setIsPlaying(false);
		assertFalse(jogador.getIsPlaying());
	}
	

}
