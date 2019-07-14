package ba.ssa.desafio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ba.ssa.desafio.exception.SaldoInsuficienteException;
import ba.ssa.desafio.exception.ValorSaqueNaoPermitidoException;

@Entity
@Table(name="conta")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@Column(nullable = false)
	private double saldo;
	
	public Conta() {
		super();
	}
	

	public Conta(Long id) {
		super();
		this.id = id;
	}

	public Conta(Cliente cliente, double saldo) {
		
		super();
		
		this.cliente = cliente;
		
		if (saldo <= 0) {
			throw new SaldoInsuficienteException("Saldo menor ou igual a zero");
		}
		
		this.saldo = saldo;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void saque(double valor) {
		
		if (valor < 0.0) {
			throw new ValorSaqueNaoPermitidoException("Valor não permitido para saque!");
		}
		
		if (valor > this.saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente...");
		}
		
		this.saldo = this.saldo - valor; 
		
	}
	
	public void deposito(double valor) {
		
		if (valor <= 0.0) {
			throw new RuntimeException("Valor não permitido para depósito!");
		}
			
		this.saldo = this.saldo + valor; 
		
	}	
	
	
}
