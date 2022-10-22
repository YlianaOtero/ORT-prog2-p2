/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practico2;
import java.util.Scanner;

public class Ejercicio1 {

    public static void ejecucion() {
        Scanner input = new Scanner(System.in);
        System.out.println("Elija la cantidad de numeros que quiere ingresar: ");
        int cant = input.nextInt();
        while (cant <= 0) {
            System.out.println("Ingrese una cantidad mayor que 0: ");
            cant = input.nextInt();
        }
        int [] arr = new int[cant];
        System.out.println("Ingrese " +cant +" enteros: ");
        for (int i = 0; i < cant; i++) {
            arr[i] = input.nextInt();
        }
        System.out.println("El histograma de los datos del array es: ");
        for (int i = 0; i < cant; i++) {
            for (int j = 0; j < arr[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
}
