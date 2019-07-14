package ba.ssa.desafio.exception.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ba.ssa.desafio.exception.ContaInvalidaException;
import ba.ssa.desafio.exception.SaldoInsuficienteException;
import ba.ssa.desafio.exception.ValorSaqueNaoPermitidoException;
import ba.ssa.desafio.exception.domain.DetalheErro;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(SaldoInsuficienteException.class)
	public ResponseEntity<DetalheErro> handleSaldoInsuficiente(SaldoInsuficienteException e,
			HttpServletRequest request) {

		DetalheErro erro = new DetalheErro();
		erro.setStatus(HttpStatus.BAD_REQUEST.value());
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.api.desafio.cap/400");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		erro.setTimestamp(dtf.format(now));

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

	}

	@ExceptionHandler(ContaInvalidaException.class)
	public ResponseEntity<DetalheErro> handleContaInvalida(ContaInvalidaException e, HttpServletRequest request) {

		DetalheErro erro = new DetalheErro();
		erro.setStatus(HttpStatus.BAD_REQUEST.value());
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.api.desafio.cap/400");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		erro.setTimestamp(dtf.format(now));

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

	}

	@ExceptionHandler(ValorSaqueNaoPermitidoException.class)
	public ResponseEntity<DetalheErro> handleValorSaqueNaoPermitido(ValorSaqueNaoPermitidoException e,
			HttpServletRequest request) {

		DetalheErro erro = new DetalheErro();
		erro.setStatus(HttpStatus.BAD_REQUEST.value());
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.api.desafio.cap/400");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		erro.setTimestamp(dtf.format(now));

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

	}

}