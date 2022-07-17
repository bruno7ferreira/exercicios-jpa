package teste.basico;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Teste {

    public static void main(String[] args) throws IOException {

        //Path path = Paths.get("C://Users/broge/Desktop/bancoDeDados/ale.txt");

        int i, n;
        FileWriter arq = new FileWriter("d:\\testeAle.txt");
        PrintWriter gravfarArq = new PrintWriter(arq);

        gravfarArq.println("Arquivo Alexandra");
        gravfarArq.println("");
        gravfarArq.println();



        int[] numeros = {4, 5, 8, 9, 10, 11, 12, 15, 17, 18, 23, 24, 27, 28, 30, 31, 32, 33, 37, 42, 46, 47, 49, 51, 52, 53, 58}; //vetor com os números determinados
        int numero = 27; // quantidade de números possíveis
        int resultado = 6; //quantidade de números por combinação

        List<int[]> combinations = generate(numero, resultado, numeros);
        for (int[] combination : combinations) {
            gravfarArq.println(Arrays.toString(combination));
            System.out.println(Arrays.toString(combination));
        }
        String texto = "Gerado "+combinations.size()+" combinações do "+numero+" itens de "+resultado;
        //Files.write(path,texto.getBytes(),StandardOpenOption.APPEND);


        //System.out.printf("Gerado %d combinações do %d itens de %d ", combinations.size(), numero, resultado);
        gravfarArq.println("");
        gravfarArq.printf("Gerado %d combinações do %d itens de %d ", combinations.size(), numero, resultado);
        gravfarArq.println(texto);
        arq.close();
    }

    private static void helper(List<int[]> combinations, int data[], int start, int end, int index, int[] elementos) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = elementos[start];
            helper(combinations, data, start + 1, end, index + 1, elementos);
            helper(combinations, data, start + 1, end, index, elementos);
        }
    }

    private static List<int[]> generate(int n, int r, int[] elementos) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n - 1, 0, elementos);
        return combinations;
    }



}


