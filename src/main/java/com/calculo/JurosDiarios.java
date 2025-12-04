package com.calculo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class JurosDiarios {

    private static final double VALOR_ORIGINAL = 1418.90;
    private static final String DATA_VENCIMENTO_STR = "05/11/2025";
    private static final double MULTA_DIARIA_PERCENTUAL = 2.5;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final int ESCALA_MONETARIA = 2;
    private static final RoundingMode ARREDONDAMENTO = RoundingMode.HALF_UP;

    public static void main(String[] args) {
        System.out.println("--- Calculadora de Juros Diários ---");

        LocalDate dataVencimento = LocalDate.parse(DATA_VENCIMENTO_STR, FORMATTER);
        LocalDate dataHoje = LocalDate.now();

        System.out.println("Data de Vencimento: " + dataVencimento.format(FORMATTER));
        System.out.println("Data de Cálculo em Tempo Real: " + dataHoje.format(FORMATTER));
        System.out.println("Valor Original da Dívida: R$ " + String.format("%.2f", VALOR_ORIGINAL));
        System.out.println("Multa Diária Aplicada: " + String.format("%.1f", MULTA_DIARIA_PERCENTUAL) + "%");
        System.out.println("-------------------------------------------");

        long diasAtrasoLong = ChronoUnit.DAYS.between(dataVencimento, dataHoje);

        if (diasAtrasoLong <= 0) {
            System.out.println("A data de hoje (" + dataHoje.format(FORMATTER) + ") ainda não ultrapassou o vencimento.");
            System.out.println("Dias de atraso: 0. Valor total a pagar: R$ " + String.format("%.2f", VALOR_ORIGINAL));
            return;
        }

        int diasAtraso = (int) diasAtrasoLong;
        System.out.println("Total de dias em atraso (a partir do dia seguinte ao vencimento): " + diasAtraso + " dias.");

        BigDecimal valorOriginalBd = new BigDecimal(VALOR_ORIGINAL).setScale(ESCALA_MONETARIA, ARREDONDAMENTO);
        BigDecimal multaDiariaBd = new BigDecimal(MULTA_DIARIA_PERCENTUAL)
                .divide(new BigDecimal(100), 4, ARREDONDAMENTO);

        BigDecimal taxaTotalMulta = multaDiariaBd.multiply(new BigDecimal(diasAtraso));

        BigDecimal valorJurosBd = valorOriginalBd.multiply(taxaTotalMulta)
                .setScale(ESCALA_MONETARIA, ARREDONDAMENTO);

        BigDecimal valorTotalBd = valorOriginalBd.add(valorJurosBd);


        System.out.println("-------------------------------------------");
        System.out.println("Taxa Total de Multa Aplicada: " +
                taxaTotalMulta.multiply(new BigDecimal(100)).setScale(2, ARREDONDAMENTO) + "%");

        System.out.println("Valor dos Juros/Multa (R$): " + valorJurosBd);
        System.out.println("Valor Total a Pagar (R$): " + valorTotalBd);
        System.out.println("-------------------------------------------");
    }
}