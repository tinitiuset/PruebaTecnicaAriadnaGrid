package org.api;

import java.util.*;

public class Buscador {

    /**
     * Imprimir los eventos que se encuentren en la lista de fechas
     * @param eventos Listado de eventos
     */
    protected static void printEventosDate(ArrayList<Evento> eventos) {

        try {

            Set<Date> dateSet = new HashSet<>();
            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.println(
                        "Introduzca el valor de Unix timestamp a buscar," +
                        " o introduzca '0' confirmar entrada:"
                );
                int date = input.nextInt();
                if (date == 0) {
                    break;
                }
                dateSet.add(new Date(date * 1000L));
            }
            for (Evento evento : eventos) {
                if (dateSet.contains(evento.getFecha())) {
                    System.out.println(evento);
                }
            }
            System.out.println("\n");
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, introduzca un número");
        } catch (Exception e) {
            System.out.println("Error genérico");
        }
    }

    /**
     * Imprimir los eventos que coincidan con el fuenteId introducido
     * @param eventos Listado de eventos
     */
    protected static void printEventosFuenteId(ArrayList<Evento> eventos) {

        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Introduzca el valor de fuenteId:");
            int fuenteId = input.nextInt();

            for (Evento evento : eventos) {
                if (evento.getFuenteId() == fuenteId) {
                    System.out.println(evento);
                }
            }
            System.out.println("\n");
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, introduzca un número");
        } catch (Exception e) {
            System.out.println("Error genérico");
        }
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
            System.out.println("\n");
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, introduzca un número");
        } catch (Exception e) {
            System.out.println("Error genérico");
        }
    }
}
