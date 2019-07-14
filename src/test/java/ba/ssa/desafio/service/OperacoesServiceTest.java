package ba.ssa.desafio.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ba.ssa.desafio.domain.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperacoesServiceTest {
	
	private Cliente alesandro;
	
	@Before
	public void setUp() {
		
		this.alesandro = new Cliente("01678900956", "Alesandro");
		
	}
	

}
