package ba.ssa.desafio.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class OperacoesTest {
	
	private Cliente alesandro;
	
	private Conta contaTest;
	
	@Before
	public void setUp() {
		
		this.alesandro = new Cliente("01678900956", "Alesandro");
		
		this.contaTest = new Conta( new Cliente("00099988877766", "Master Test"), 100);
		
	}
	
	@Test(expected=RuntimeException.class)
	public void nao_abre_conta_sem_saldo() {
		
		new Conta(this.alesandro, 0.0);
		
	}
	
	@Test(expected=RuntimeException.class)
	public void nao_abre_conta_saldo_negativo() {
		
		new Conta(this.alesandro, -10.0);
		
	}	
	
	@Test(expected=RuntimeException.class)
	public void nao_permite_saque_maior_que_saldo() {
		
		this.contaTest.saque(200.0);
		
	}
	
	@Test(expected=RuntimeException.class)
	public void nao_permite_saque_com_valor_negativo() {
		
		this.contaTest.saque(-20.0);
		
	}	
	
	@Test
	public void saque_valido() {
		
		this.contaTest.saque(80.0);
		
		assertEquals(this.contaTest.getSaldo(), 20.0, 0.00001);
		
	}
	
	@Test(expected=RuntimeException.class)
	public void nao_permite_deposito_negativo() {
		
		this.contaTest.deposito(-30.0);
		
	}	
			

}
