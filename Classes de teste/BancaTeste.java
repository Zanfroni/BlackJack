import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BancaTeste {

	private Banca banca;
	
	@Before
	public void inicializar() {
		Baralho b = new Baralho();
		banca = new Banca(b);
	}
	
	@Test
	public void construtorTeste(){
		//garanta que a referência não seja null
		assertNotNull(banca);
	}
	
	@Test
	public void getIsPlayingTeste(){
		//como a banca começa jogando por default, o retornro deve ser true
		assertTrue(banca.getIsPlaying());
	}
	
	@Test
	public void setIsPlayingTeste(){
		banca.setIsPlaying(false);
		assertFalse(banca.getIsPlaying());
		banca.setIsPlaying(true);
		assertTrue(banca.getIsPlaying());
	}
	
	@Test
	public void getMaoTeste(){
		assertNotNull(banca.getMao());
	}
	
	@Test
	public void getBaralhoTeste(){
		assertNotNull(banca.getBaralho());
	}
	
	@Test
	public void getCountTeste(){
		assertTrue(banca.getCount() >= 0);
	}

}
