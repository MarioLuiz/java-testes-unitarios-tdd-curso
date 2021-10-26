package com.arruda.testes.junit.curso;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

	@Test
	public void deveriaSomarDoisNumerosPositivosInteiros() {
		Calculadora calc = new Calculadora();
		int soma = calc.somar(3, 7);
		
		Assert.assertEquals(10, soma);
	}

}
