package org.example;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Practica {
    public void Ejercicio(){

        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();

        String array_datos[];
        int array_resultado[] = new int[6], array_datos_int[] = new int[7], array_datos_nums[] = new int[6];
        Integer array_resultado_integer[] = new Integer[6], array_datos_integer[] = new Integer[7];

        String datos;
        int complementario, reintegro, aciertos = 0;
        boolean complementario_acierto = false;

        bucle_principal:
        while(true){
            System.out.println("Introduce los datos de tu boleto:");
            datos = entrada.nextLine();
            if (!datos.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}/\\d{1}")){
                System.out.println("ERROR. Los datos se han introducido de manera incorrecta...");
                continue;
            }
            array_datos = datos.split("[-/]");
            for(int i = 0; i < 7; i++){
                array_datos_int[i] = Integer.parseInt(array_datos[i]);
                if (array_datos_int[i] > 49 || array_datos_int[i]  < 1){
                    System.out.println("ERROR. Los datos se han introducido de manera incorrecta...");
                    continue bucle_principal;
                }
            }
            array_datos_int[6] = Integer.parseInt(array_datos[6]);
            if (array_datos_int[6] > 9 || array_datos_int[6] < 0){
                System.out.println("ERROR. Los datos se han introducido de manera incorrecta...");
                continue bucle_principal;
            }
            for(int i = 0; i < 6; i++){
                array_datos_nums[i] = array_datos_int[i];
            }


            int array_datos_nums2[] = Arrays.stream(array_datos_nums).distinct().toArray();
            if(array_datos_nums2.length != array_datos_nums.length){
                System.out.println("ERROR. Los números no se pueden repetir...");
                continue bucle_principal;
            }

            System.out.println(Arrays.toString(array_datos_int));
            while(true){
                for(int i = 0; i < 6; i++) {
                    array_resultado[i] = aleatorio.nextInt(49)+1;
                }
                int array_resultado2[] = Arrays.stream(array_resultado).distinct().toArray();
                if(array_resultado.length != array_resultado2.length){
                    continue;
                }
                break;
            }
            Arrays.sort(array_resultado);
            System.out.println("");
            System.out.println("SORTEO:");
            System.out.println(Arrays.toString(array_resultado));
            complementario = aleatorio.nextInt(49)+1;
            System.out.println("Complementario: " + complementario);
            reintegro = aleatorio.nextInt(10);
            System.out.println("Reintegro: " + reintegro);
            System.out.println("");
            System.out.println("RESULTADOS:");

            for(int i = 0; i < 6; i++){
                array_resultado_integer[i] = array_resultado[i];
                array_datos_integer[i] = array_datos_int[i];
            }
            for(int i = 0; i < 6; i++){
                boolean numeros_encontrados = Arrays.asList(array_resultado_integer).contains(array_datos_integer[i]);
                if (numeros_encontrados){
                    aciertos += 1;
                }
            }
            System.out.println("Aciertos: " + aciertos);
            if (reintegro == array_datos_int[6]){
                System.out.println("Reintegro");
            }else{
                System.out.println("No reintegro");
            }

            for(int i = 0; i < 6; i++){
                if(array_datos_int[i] == complementario){
                    complementario_acierto = true;
                    break;
                }

            }

            if(aciertos == 6 & reintegro == array_datos_int[6]){
                System.out.println("Categoría: Categoría Especial");
            }else if(aciertos == 6){
                System.out.println("Categoría: 1ª Categoría");
            }else if(aciertos == 5 & complementario_acierto){
                System.out.println("Categoría: 2ª Categoría");
            }else if(aciertos == 5){
                System.out.println("Categoría: 3ª Categoría");
            }else if(aciertos == 4){
                System.out.println("Categoría: 4ª Categoría");
            }else if(aciertos == 3){
                System.out.println("Categoría: 5ª Categoría");
            }
            else{
                System.out.println("Categoría: No premiado");
            }
            break;
        }
    }
}
