package com.arruda.testes.junit.curso.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.arruda.testes.junit.curso.modelo.Desempenho;
import com.arruda.testes.junit.curso.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteSevice service;
	private Funcionario funcionario;
	
	@BeforeAll
	public static void antesDeTudo() {
		System.out.println("ANTES DE TUDO");
	}
	
	@BeforeEach
	public void inicializar() {
		System.out.println("Antes de cada teste");
		this.service = new ReajusteSevice();
		this.funcionario = new Funcionario("Carlos", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("Executado depois de cada teste");
	}
	
	@AfterAll
	public static void depoisDeTudo() {
		System.out.println("DEPOIS DE TUDO");
	}

	@Test
	void reajusteDeveriaSerDeTresPorCentoDoSalarioBaseQuandoDesempenhoForADesejar() {

		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	void reajusteDeveriaSerDeQuinzePorCentoDoSalarioBaseQuandoDesempenhoForBom() {

		service.concederReajuste(funcionario, Desempenho.BOM);

		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	void reajusteDeveriaSerDeVintePorCentoDoSalarioBaseQuandoDesempenhoForOtimo() {

		service.concederReajuste(funcionario, Desempenho.OTIMO);

		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

}
