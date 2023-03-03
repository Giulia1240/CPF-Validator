package calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalcularCpf {
    public CalcularCpf(String cpf) {
        var calculator = validarCalculoCPF(cpf);
        System.out.println(calculator);
    }

    public static boolean validarCalculoCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        int[] cpfArray = new int[9];
        int[] cpfArrayDois = new int[10];

        for (int i = 0; i < cpfArray.length; i++) {
            cpfArray[i] = Character.getNumericValue(cpf.charAt(i));
        }
        for (int i = 0; i < cpfArrayDois.length; i++) {
            cpfArrayDois[i] = Character.getNumericValue(cpf.charAt(i));
        }

        int primeiroDigito = calcularDigito(cpfArray, 10);
        int segundoDigito = calcularDigito(cpfArrayDois, 11);

        if (cpf.length() != 11) {
            return false;
        }

        boolean validator = (cpf.charAt(9) - '0' == primeiroDigito) && (cpf.charAt(10) - '0' == segundoDigito);

        return validator;
    }

    private static int calcularDigito(int[] number, int peso) {
        int sum = 0;
        for (int i = 0; i < number.length; i++) {
            sum += number[i] * peso--;
        }
        int resto = sum % 11;
        return resto < 2 ? 0 : 11 - resto;
    }
}
