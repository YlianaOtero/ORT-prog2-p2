/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico2;

import java.util.Scanner;
import java.util.Arrays;

public class Practico2 {
    // Leer 10 números y mostrarlos en orden inverso al ingresado.
    public static void ejercicio2() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese 10 numeros: ");
        int [] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = input.nextInt();
        }
        System.out.println("Los numeros en orden inverso son: ");
        for (int i = 9; i >= 0; i--) {
            System.out.print(arr[i] +" ");
        }
    }
    
    /* Leer 10 números. Al final indicar si están ordenados ascendentemente, descendentemente o no
ordenados. */
    public static void ejercicio3() {
        Scanner input = new Scanner(System.in);
        int [] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Ingrese el numero " +(i+1) +" de 10");
            arr[i] = input.nextInt();
        }
        
        int anterior = arr[0];
        boolean ordenadoAsc = true;
        boolean ordenadoDes = true;
        
        for (int i = 1; i < 10; i++) {
            if (arr[i] > anterior) {
                ordenadoAsc = true;
                ordenadoDes = false;
            } 
            if (arr[i] < anterior) {
                ordenadoDes = true;
                ordenadoAsc = false;
            }
            anterior = arr[i];
        }
        
        if (ordenadoAsc){
            System.out.println("Ordenado ascendentemente.");
        } else {
            if (ordenadoDes){
                System.out.println("Ordenado descendentemente.");
            } else {
                System.out.println("No esta ordenado.");
            }
        }
    }
    
    /*Escribir un método que permita evaluar un polinomio p(x) suponiendo que los coeficientes 
    reales ai (i = 0,1, 2,…,.n), el entero n (grado) y el punto a evaluar son datos
    entrados inicialmente por el usuario. */
    
    public static void ejercicio4(String args[]) {
        System.out.println("Ingrese el grado del polinomio: ");
        Scanner input = new Scanner(System.in);
        int grado = input.nextInt();
        System.out.println();
        
        if (grado > 0) {
            System.out.println("Ahora debe definir los coeficientes del polinomio.");
            double [] coeficientes = new double[grado];

            for (int i = 0; i < grado; i++) {
                System.out.println("Ingrese el coeficiente " +(i+1) +" de " +grado +": ");
                coeficientes[i] = input.nextInt();
            }
            System.out.println();

            System.out.println("Ingrese el punto a evaluar: ");
            double punto = input.nextInt();

            double resultado = coeficientes[0];
            for (int i = 1; i < grado; i++) {
                resultado += coeficientes[i] * Math.pow(punto, i+1);
            }

            System.out.println("El resultado de evaluar " +punto +" en el polinomio dado es " +resultado); 
        } else {
            System.out.println("El resultado de evaluar cualquier punto en un polinomio de grado 0, es la constante que define al polinomio.");
        }
        
    }
    
    /*5) Dados dos arrays ordenados, generar un tercer array con el resultado de la intercalación ordenada.
    Ej: [10, 20, 50], [1, 2, 20, 24, 80], resultado: [1, 2, 10, 20, 20, 24, 50, 80] */
    
    public static int[] ejercicio5 (int[] arrA, int[] arrB) {
        int tamanio = arrA.length + arrB.length;
        int [] resultado = new int[tamanio];
        
        int j = 0;
        int k = 0;
        
        for (int i = 0; i < resultado.length; i++) {
            if (j < arrA.length && k < arrB.length && arrA[j] < arrB[k] || k >= arrB.length) {
                resultado[i] = arrA[j];
                j++;
            } else {
                resultado[i] = arrB[k];
                k++;
            }
        }
    
    return resultado;
    }
    
    /*6) Cargar un array de 10 elementos con números aleatorios entre 1 y 20. Asegurarse que no haya
    números repetidos. */
    
    public static int [] ejercicio6 () {
        int [] resultado = new int[10];
        
        int rango = 20;
        int [] repetidos = new int[rango];
        
        for (int i = 0; i < rango; i++) {
            repetidos[i] = 0;
        }
        
        for (int i = 0; i < 10; i++) {
            resultado[i] = (int)(Math.random() *  rango);
            int aux = resultado[i];
            repetidos[aux]++;

            while (repetidos[resultado[i]] > 1) {
                repetidos[resultado[i]]--;
                resultado[i] = (int)(Math.random() *  rango);
                repetidos[resultado[i]]++;
            }
        }
         
        return resultado;
    }
    
    /*7) “En la casa de Pinocho...todos cuentan hasta ocho:...pinuno, pindos, pintres, pincuatro, pincinco,
    pinseis, pinsiete, pinocho!.” Este tradicional cantito es el que usan los niños para elegir al azar uno de
    ellos en un grupo. Los niños se disponen en círculo y el responsable del canto, ubicado en el centro
    del círculo, va señalando consecutivamente a cada uno diciendo en voz alta una palabra del canto. Al
    que le toca la última palabra de la canción es el elegido. Se ingresará desde teclado una lista de
    nombres (entre 5 y 30), luego que se termina la lista se indica cuál va a cantar al centro y desde cuál
    se comienza. El programa debe informar a quién se elegirá.
    Ejemplo:
    Se ingresan: Nicolás Andrés Mariana Inés Marcelo Matías Mauricio Daniel. Mariana cantará y se
    comienza con Matías. El programa debe indicar que el elegido será Daniel. */
    
    public static void ejercicio7() {
        System.out.println("Ingrese la cantidad de ninos que juegan. Deben ser entre 5 y 30:");
        Scanner input = new Scanner(System.in);
        int cantidad = input.nextInt();
        input.nextLine();
        
        String[] nombres = new String[cantidad];
        System.out.println("Ahora debera ingresar los " +cantidad +" nombres.");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese el nombre del nino numero " +(i+1) +": ");
            nombres[i] = input.nextLine();
        }
        
        System.out.println("Ahora ingrese el nombre del nino que va a cantar al centro:");
        String canta = input.nextLine();
        System.out.println("Y por ultimo, ingrese el nombre del nino desde el cual se empieza:");
        String comienza = input.nextLine();
        
        int i = 0;
        while(!nombres[i].equals(comienza)) {
            i++;
        }
                
        for (int j = 0; j <= 17; j++) {
            if (i < cantidad) {
                if (nombres[i].equals(canta)) {
                    i++;
                }
                i++;
            } else {
                i = 0;
            }
        }
        
        System.out.println("El elegido es " +nombres[i]);
    }
    
    /*8) Marcos, distraído en la clase de física, se imagina cómo sería cambiar la gravedad. Diseñó una caja
    especial que contiene n columnas de cubitos. La columna i contiene ai cubos. Al principio, la gravedad
    en la caja es normal, o sea, empujando los cubos hacia abajo, pero cuando cambia la gravedad los
    empuja hacia la derecha
    A partir de la configuración inicial de los cubos, el objetivo es encontrar la cantidad de cubos en cada
    una de las columnas luego del cambio de gravedad.
    Implementar un método que recibe un array con la cantidad de cubos en cada una de las columnas e
    imprime la cantidad de cubos de cada columna luego del cambio de gravedad.
    Ejemplo: recibe 3 2 1 2, imprime 1 2 2 3. La firma es: public static void gravedad(int[] datos)*/
    //revisar
    public static void gravedad(int[] datos) {
        int tope = maximoEnArray(datos);
        int piso = minimoEnArray(datos);
        
        for (int i = 0; i < datos.length; i++) {
            while ((i + 1 < datos.length) && (datos[i+1] < tope) && (datos[i] > piso)) {
                datos[i]--;
                datos[i+1]++;
            }
        }
            
        System.out.println(tope + " " + piso);
        imprimirArrayInt(datos);
    }
    
    public static void imprimirArrayInt(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] +" ");
        }
        System.out.println();
    }
    
    public static int minimoEnArray(int[] array) {
        int minimo = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimo) {
                minimo = array[i];
            }
        }
        
        return minimo;
    }
    
    public static int maximoEnArray(int[] array) {
        int maximo = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximo) {
                maximo = array[i];
            }
        }
        
        return maximo;
    }
    
    public static void main(String args[]) {
        int[] datos = {3, 2, 1, 2};
        gravedad(datos);
        
    }
}

