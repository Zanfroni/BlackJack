import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaoTeste {

	private Mao mao;
	
	@Before
	public void iniciar(){
		mao = new Mao();
	}
	
	@Test
	public void construtorTeste() {
		//garanta que a referência criada não seja null
		assertNotNull(mao);
	}
	
	@Test
	public void getMaoTeste(){
		//garanta que a referência retornada não seja null
		assertNotNull(mao.getMao());
	}
	
	@Test
	public void getPontosTeste(){
		/*teste do primeiro condicional, com a mão sem cartas
		 * garanta que a pontuação seja 0
		 */
		assertEquals(0, mao.getPontos());
		/*teste com pelo menos uma carta na mão
		 * garanta que a pontuação seja maior que 0
		 */
		mao.getMao().add(new Carta("Ouro", "7", 7 ));
		assertTrue(mao.getPontos() > 0);
		mao.getMao().add(new Carta("Ouro", "5", 5 ));
		//garanta que a pontuação seja 12
		assertEquals(12, mao.getPontos());
		
	}

}
