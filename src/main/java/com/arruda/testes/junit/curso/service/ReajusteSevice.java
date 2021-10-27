package com.arruda.testes.junit.curso.service;

import java.math.BigDecimal;

import com.arruda.testes.junit.curso.modelo.Desempenho;
import com.arruda.testes.junit.curso.modelo.Funcionario;

public class ReajusteSevice {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
		BigDecimal percentual = desempenho.percentualReajuste();
		BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
		funcionario.reajustarSalario(reajuste);
	}

}
