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

import ba.ssa.desafio.domain.Conta;

@RunWith(SpringRunner.class)
@Sql(value="/carga.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@DataJpaTest
public class ContaRepositoryTest {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Test
	public void teste_listar_contas() {
		
		List<Conta> contas = this.contaRepository.findAll();
		
		assertThat(contas.size()).isGreaterThanOrEqualTo(1);
		
	}
	
	@Test
	public void teste_pesquisar_por_cpf_cliente() {
		
		Optional<Conta> conta = this.contaRepository.findOneByClienteCpf("01977755567");
		
		assertThat(conta.isPresent()).isTrue();
		assertThat(conta.get().getCliente().getNome()).isEqualTo("alesandro carvalho");
		
	}

}
