package ba.ssa.desafio.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.ssa.desafio.domain.Cliente;
import ba.ssa.desafio.repository.ClienteRepository;
import ba.ssa.desafio.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository; 
	}
	
	@Override
	public List<Cliente> listar() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente salvar(Cliente clientTest) {
		
		Optional<Cliente> clientCPF = this.clienteRepository.findOneByCpf(clientTest.getCpf());
		
		if (clientCPF.isPresent()){
			throw new RuntimeException("Cpf já utilizado!");
		}
		
		return this.clienteRepository.save(clientTest);
	}

	@Override
	public Cliente findOneByCpf(String cpf) {
		
		Optional<Cliente> clienteOpt = this.clienteRepository.findOneByCpf(cpf);
		
		return clienteOpt.orElseThrow(() -> new RuntimeException("Cpf não encontrado!"));
		
	}

}
