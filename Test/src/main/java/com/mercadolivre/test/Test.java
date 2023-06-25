package com.mercadolivre.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Test {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SearchiPadTest.class);

        if (result.wasSuccessful()) {
            System.out.println("Successfully executed tests!");
        } else {
            System.out.println("Tests failed:");
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }
}