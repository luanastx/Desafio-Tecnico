package com.mercadolivre.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Test {
    // Executar os testes da classe SearchiPadTest

    // Executar os testes da classe SearchiPadTest e armazenar o resultado
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SearchiPadTest.class);

        // Verificar se todos os testes foram executados com sucesso
        if (result.wasSuccessful()) {
            System.out.println("Successfully executed tests!");
        } else {
            // Caso algum teste tenha falhado, exibir as falhas encontradas
            System.out.println("Tests failed:");
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }
}