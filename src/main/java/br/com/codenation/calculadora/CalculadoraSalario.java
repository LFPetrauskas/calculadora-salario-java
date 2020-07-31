package br.com.codenation.calculadora;

public class CalculadoraSalario {
	private static final double SALARIO_MINIMO = 1039;

	public long calcularSalarioLiquido(double salarioBase) {
		// Use o Math.round apenas no final do método para arredondar o valor final.
		// Documentação do método:
		// https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		if (salarioBase < SALARIO_MINIMO) {
			return 0;
		}
		double salarioInss = calcularInss(salarioBase);
		double salarioLiquido = calcularIrrf(salarioInss);
		return Math.round(salarioLiquido);
	}

	// Exemplo de método que pode ser criado para separar melhor as
	// responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		double percentualInss;
		if (salarioBase <= 1500) {
			percentualInss = 8.0 / 100;
		} else if (salarioBase <= 4000) {
			percentualInss = 9.0 / 100;
		} else {
			percentualInss = 11.0 / 100;
		}
		return salarioBase * (1 - percentualInss);
	}

	private double calcularIrrf(double salarioBase) {
		double percentualIrrf;
		if (salarioBase <= 3000) {
			percentualIrrf = 0;
		} else if (salarioBase < 6000) {
			percentualIrrf = 7.5 / 100;
		} else {
			percentualIrrf = 15.0 / 100;
		}
		return salarioBase * (1 - percentualIrrf);
	}
}
/*
 * Dúvidas ou Problemas? Manda e-mail para o meajuda@codenation.dev que iremos
 * te ajudar!
 */