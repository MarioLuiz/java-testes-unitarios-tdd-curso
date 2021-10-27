package com.arruda.testes.junit.curso.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.arruda.testes.junit.curso.modelo.Desempenho;
import com.arruda.testes.junit.curso.modelo.Funcionario;

public class ReajusteServiceTest {
	
	@Test
	void reajusteDeveriaSerDeTresPorCentoDoSalarioBaseQuandoDesempenhoForADesejar() {
		ReajusteSevice service = new ReajusteSevice();
		Funcionario funcionario = new Funcionario("Carlos", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteDeveriaSerDeQuinzePorCentoDoSalarioBaseQuandoDesempenhoForBom() {
		ReajusteSevice service = new ReajusteSevice();
		Funcionario funcionario = new Funcionario("Carlos", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.concederReajuste(funcionario, Desempenho.BOM);
		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteDeveriaSerDeVintePorCentoDoSalarioBaseQuandoDesempenhoForOtimo() {
		ReajusteSevice service = new ReajusteSevice();
		Funcionario funcionario = new Funcionario("Carlos", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
}
