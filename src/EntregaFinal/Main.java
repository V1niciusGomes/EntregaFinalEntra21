package EntregaFinal;

import java.util.Scanner;

// Programa para monitorar consumo de energia elétrica de 12 meses
public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] consumos = new double[12];
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        // Pega consumos e mostra resultados
        coletarConsumos(scanner, consumos, meses);
        System.out.println("\nRelatório de Consumo");
        mostrarResultados(consumos, meses);
        scanner.close();
    }



    // Pega os consumos digitados pelo usuário
    private static void coletarConsumos(Scanner scanner, double[] consumos, String[] meses) {
        System.out.println("Entrada de Consumos (kWh)");
        for (int mes = 0; mes < 12; mes++) {
            System.out.print("Consumo de " + meses[mes] + ": ");
            consumos[mes] = scanner.nextDouble();
        }
    }



    // Mostra consumo total, média, maior/menor e classificação
    private static void mostrarResultados(double[] consumos, String[] meses) {
        double total = 0, maior = consumos[0], menor = consumos[0];
        String mesMaior = meses[0], mesMenor = meses[0];

        // Calcula total, maior e menor
        for (int mes = 0; mes < 12; mes++) {
            total += consumos[mes];
            if (consumos[mes] > maior) {
                maior = consumos[mes];
                mesMaior = meses[mes];
            }
            if (consumos[mes] < menor) {
                menor = consumos[mes];
                mesMenor = meses[mes];
            }
        }



        // Calcula média
        double media = total / 12;

        // Mostra resultados
        System.out.println("\nConsumo Total: " + total + " kWh");
        System.out.println("Média Mensal: " + media + " kWh");
        System.out.println("Maior Consumo: " + maior + " kWh em " + mesMaior);
        System.out.println("Menor Consumo: " + menor + " kWh em " + mesMenor);


        // Classifica consumo
        System.out.print("Classificação: ");
        if (media <= 150) {
            System.out.println("Baixo");
        } else if (media <= 300) {
            System.out.println("Moderado");
        } else {
            System.out.println("Elevado");
        }
    }
}