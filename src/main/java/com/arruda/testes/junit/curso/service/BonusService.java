package com.arruda.testes.junit.curso.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.arruda.testes.junit.curso.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Funcionario com salario maior do que R$10000 n�o pode receber bonus!");
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
