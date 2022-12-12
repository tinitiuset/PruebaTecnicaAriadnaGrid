package org.api;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Buscador {

    /**
     * Imprimir los eventos que se encuentren en la lista de fechas
     * @param eventos Listado de eventos
     */
    protected static void printEventosDate(ArrayList<Evento> eventos) {
    }

    /**
     * Imprimir los eventos que coincidan con el fuenteId introducido
     * @param eventos Listado de eventos
     */
    protected static void printEventosFuenteId(ArrayList<Evento> eventos) {
    }

    /**
     * Imprimir los eventos que se encuentran dentro de un rango de valores
     * @param eventos Listado de eventos
     */
    protected static void printEventosMinMax(ArrayList<Evento> eventos) {

        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Introduzca el valor mínimo:");
            int min = input.nextInt();
            System.out.println("Introduzca el valor máximo:");
            int max = input.nextInt();

            for (Evento evento : eventos) {
                if (evento.getValor() >= min && evento.getValor() <= max) {
                    System.out.println(evento);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, introduzca un número");
        } catch (Exception e) {
            System.out.println("Error genérico");
        }
    }
}
