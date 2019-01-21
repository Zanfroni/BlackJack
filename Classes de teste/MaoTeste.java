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
		//garanta que a refer�ncia criada n�o seja null
		assertNotNull(mao);
	}
	
	@Test
	public void getMaoTeste(){
		//garanta que a refer�ncia retornada n�o seja null
		assertNotNull(mao.getMao());
	}
	
	@Test
	public void getPontosTeste(){
		/*teste do primeiro condicional, com a m�o sem cartas
		 * garanta que a pontua��o seja 0
		 */
		assertEquals(0, mao.getPontos());
		/*teste com pelo menos uma carta na m�o
		 * garanta que a pontua��o seja maior que 0
		 */
		mao.getMao().add(new Carta("Ouro", "7", 7 ));
		assertTrue(mao.getPontos() > 0);
		mao.getMao().add(new Carta("Ouro", "5", 5 ));
		//garanta que a pontua��o seja 12
		assertEquals(12, mao.getPontos());
		
	}

}
