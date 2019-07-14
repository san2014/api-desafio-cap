package ba.ssa.desafio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.ssa.desafio.domain.Conta;
import ba.ssa.desafio.repository.ContaRepository;
import ba.ssa.desafio.service.ContaService;

@Service
public class ContaServiceImpl implements ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	public ContaServiceImpl(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}
	
	public List<Conta> listar() {
		return this.contaRepository.findAll();
	}

	public Conta obter(Long id) {
		return this.contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta inválida..."));
	}

	@Override
	public void alterar(Conta conta) {
				
		this.contaRepository.save(conta);	
		
	}

	@Override
	public Conta criar(Conta contaTest) {
		return this.contaRepository.save(contaTest);
	}

}
