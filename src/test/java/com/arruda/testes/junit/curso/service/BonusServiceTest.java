package com.arruda.testes.junit.curso.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.arruda.testes.junit.curso.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaSalarioMuitoAlto() {
		BonusService service = new BonusService();
		Funcionario funcionario = new Funcionario("Luiz Carlos", LocalDate.now(), new BigDecimal("25000"));
		BigDecimal bonus = service.calcularBonus(funcionario);
		
		assertEquals(new BigDecimal("0.00"),bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoDoSalario() {
		BonusService service = new BonusService();
		Funcionario funcionario = new Funcionario("Luiz Carlos", LocalDate.now(), new BigDecimal("2500"));
		BigDecimal bonus = service.calcularBonus(funcionario);
		
		assertEquals(new BigDecimal("250.00"),bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		Funcionario funcionario = new Funcionario("Luiz Carlos", LocalDate.now(), new BigDecimal("10000"));
		BigDecimal bonus = service.calcularBonus(funcionario);
		
		assertEquals(new BigDecimal("1000.00"),bonus);
	}

}
