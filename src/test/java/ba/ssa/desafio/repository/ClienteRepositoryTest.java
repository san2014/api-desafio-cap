package ba.ssa.desafio.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import ba.ssa.desafio.domain.Cliente;

@RunWith(SpringRunner.class)
@Sql(value="/carga.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@DataJpaTest
public class ClienteRepositoryTest {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Test
	public void teste_listar_clientes() {
		
		List<Cliente> clientes = this.clienteRepository.findAll();
		
		assertThat(clientes.size()).isGreaterThanOrEqualTo(1);
		
	}
	
	@Test
	public void teste_listar_cliente_por_cpf() {
		
		Optional<Cliente> cliente = this.clienteRepository.findOneByCpf("01977755567");
		
		assertThat(cliente.isPresent()).isTrue();
		
	}	
	
	@Test
	public void teste_salvar_novo_cliente() {
		
		Cliente cliente = new Cliente("22244433367", "Teste Repository");
		
		this.clienteRepository.save(cliente);
		
		Optional<Cliente> optional = this.clienteRepository.findOneByCpf("22244433367");

		assertThat(optional.isPresent()).isTrue();	
		
		Cliente clienteSalvo = optional.get();
		
		assertThat(clienteSalvo.getNome()).isEqualTo(cliente.getNome());
		
	}

}
