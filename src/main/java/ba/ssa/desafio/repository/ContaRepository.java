package ba.ssa.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ba.ssa.desafio.domain.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	public Conta save(Conta contaTest);
	
	Optional<Conta> findOneByClienteCpf(String cpf);
	
}
