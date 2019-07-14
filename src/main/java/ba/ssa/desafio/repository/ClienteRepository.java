package ba.ssa.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ba.ssa.desafio.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public Optional<Cliente> findOneByCpf(String cpf);

}
