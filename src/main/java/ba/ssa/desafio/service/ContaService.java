package ba.ssa.desafio.service;

import java.util.List;

import ba.ssa.desafio.domain.Conta;

public interface ContaService {
	
	public List<Conta> listar();
	
	public Conta obter(Long id);

	public Conta criar(Conta conta);

	public void alterar(Conta conta);

}
