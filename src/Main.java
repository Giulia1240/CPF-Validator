import calculator.CalcularCpf;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Enter file full path: ");
        String path = "C:\\Dev\\Academia\\projetos\\validacao-cpf\\src\\file\\cpf.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line.split(";");
                new CalcularCpf(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}