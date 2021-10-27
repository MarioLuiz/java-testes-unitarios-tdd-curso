package com.arruda.testes.junit.curso.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.arruda.testes.junit.curso.modelo.Funcionario;

class BonusServiceTest {

	private BonusService service;
	private Funcionario funcionario;

	@Test
	void bonusDeveriaSerZeroParaSalarioMuitoAlto() {
		service = new BonusService();
		funcionario = new Funcionario("Luiz Carlos", LocalDate.now(), new BigDecimal("25000"));
		
		try {
			service.calcularBonus(funcionario);
			fail("Não deu a IllegalArgumentException");
		} catch (Exception e) {
			assertEquals("Funcionario com salario maior do que R$10000 não pode receber bonus!", e.getMessage());
		}
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
