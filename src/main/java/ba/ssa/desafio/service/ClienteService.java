package ba.ssa.desafio.service;

import java.util.List;

import ba.ssa.desafio.domain.Cliente;

public interface ClienteService {
	
	public List<Cliente> listar();

	public Cliente salvar(Cliente clientTest);

	public Cliente findOneByCpf(String cpf);

}
