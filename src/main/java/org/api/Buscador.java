package org.api;

import java.util.*;

/**
 * @author Martin Valiente Ainz
 */
public class Buscador {

    /**
     * Imprimir los eventos que se encuentren en la lista de fechas
     *
     * @param eventos Listado de eventos
     */
    protected static void printEventosDate(Set<Evento> eventos) {

        try {

            Set<Date> dateSet = new HashSet<>();
            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.println(
                        "Introduzca el valor de Unix timestamp a buscar," +
                                " o introduzca '0' confirmar entrada:"
                );
                int date = input.nextInt();
                if (date == 0)
                    break;
                dateSet.add(new Date(date * 1000L));
            }
            for (Evento evento : getEventosDate(eventos, dateSet))
                System.out.println(evento);
            System.out.println("\n");
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, introduzca un número");
        } catch (Exception e) {
            System.out.println("Error genérico");
        }
    }

    /**
     * Devuelve los eventos cuyas fechas coincidan con las de la lista
     *
     * @param haystack Lista de eventos a buscar
     * @param needle   Lista de fechas validas
     * @return Lista de eventos que coinciden con las fechas
     */
    private static Set<Evento> getEventosDate(Set<Evento> haystack, Set<Date> needle) {

        Set<Evento> eventos = new HashSet<>();

        for (Evento evento : haystack)
            if (needle.contains(evento.getFecha()))
                eventos.add(evento);

        return eventos;
    }

    /**
     * Imprimir los eventos que coincidan con el fuenteId introducido
     *
     * @param eventos Listado de eventos
     */
    protected static void printEventosFuenteId(Set<Evento> eventos) {

        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Introduzca el valor de fuenteId:");
            int fuenteId = input.nextInt();

            for (Evento evento : getEventosFuenteId(eventos, fuenteId))
                System.out.println(evento);
            System.out.println("\n");
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, introduzca un número");
        } catch (Exception e) {
            System.out.println("Error genérico");
        }
    }

    /**
     * Devuelve los eventos cuyos fuenteId coincidan con el introducido
     *
     * @param haystack Lista de eventos a buscar
     * @param fuenteId fuenteId a buscar
     * @return Lista de eventos que coinciden con fuenteId
     */
    private static Set<Evento> getEventosFuenteId(Set<Evento> haystack, int fuenteId) {

        Set<Evento> eventos = new HashSet<>();

        for (Evento evento : haystack)
            if (evento.getFuenteId() == fuenteId)
                eventos.add(evento);

        return eventos;
    }

    /**
     * Imprimir los eventos que se encuentran dentro de un rango de valores
     *
     * @param eventos Listado de eventos
     */
    protected static void printEventosMinMax(Set<Evento> eventos) {

        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Introduzca el valor mínimo:");
            int min = input.nextInt();
            System.out.println("Introduzca el valor máximo:");
            int max = input.nextInt();

            for (Evento evento : getEventosMinMax(eventos, min, max))
                System.out.println(evento);
            System.out.println("\n");
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, introduzca un número");
        } catch (IllegalArgumentException e) {
            System.out.println("Error : El valor mínimo no puede ser mayor que el máximo");
        } catch (Exception e) {
            System.out.println("Error genérico");
        }
    }

    /**
     * Devuelve los eventos cuyos valores estén dentro del rango
     *
     * @param haystack Lista de eventos a buscar
     * @param min      valor mínimo a buscar
     * @param max      valor máximo a buscar
     * @return Lista de eventos que estén dentro del rango
     */
    private static Set<Evento> getEventosMinMax(Set<Evento> haystack, int min, int max) {

        if (min > max)
            throw new IllegalArgumentException();
        Set<Evento> eventos = new HashSet<>();

        for (Evento evento : haystack)
            if (evento.getValor() >= min && evento.getValor() <= max)
                eventos.add(evento);

        return eventos;
    }

    /**
     * El tester ejecuta 100 veces cada método de búsqueda, con parámetros aleatorios y printa los resultados
     *
     * @param eventos Listado de eventos
     */
    protected static void tester(Set<Evento> eventos) {

        // Test getEventosDate 100 times with random a set of 100 random dates
        for (int i = 0; i < 100; i++) {
            try {
                Set<Date> fechas = new HashSet<>();

                for (int j = 0; j < 100; j++)
                    fechas.add(new Date(new Random().nextInt() * 1000L));

                System.out.println("Eventos cuyas fechas se encuentran en el set actual: ");

                for (Evento evento : getEventosDate(eventos, fechas))
                    System.out.println(evento);

                System.out.println();
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage() + "\n");
            }
        }

        // Test getEventosFuenteId 100 times with random values from 1 to 100
        for (int i = 0; i < 100; i++) {
            try {
                int fuenteId = new Random().nextInt(100) + 1;

                System.out.println("Eventos con fuenteId: " + fuenteId);

                for (Evento evento : getEventosFuenteId(eventos, fuenteId))
                    System.out.println(evento);

                System.out.println();
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage() + "\n");
            }
        }

        // Test getEventosMinMax 100 times with random values from 1 to 10
        for (int i = 0; i < 100; i++) {
            try {
                int min = new Random().nextInt(10) + 1;
                int max = new Random().nextInt(10) + 1;

                System.out.println("Eventos con valor mínimo: " + min + " y valor máximo: " + max);

                for (Evento evento : getEventosMinMax(eventos, min, max))
                    System.out.println(evento);

                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println("Error : El valor mínimo no puede ser mayor que el máximo \n");
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage() + "\n");
            }
        }
    }
}
