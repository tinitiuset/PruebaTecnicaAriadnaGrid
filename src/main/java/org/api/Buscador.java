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
     * @param haystack Lista de eventos a buscar
     * @param needle Lista de fechas validas
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
        } catch (Exception e) {
            System.out.println("Error genérico");
        }
    }

    /**
     * Devuelve los eventos cuyos valores estén dentro del rango
     * @param haystack Lista de eventos a buscar
     * @param min valor mínimo a buscar
     * @param max valor máximo a buscar
     * @return Lista de eventos que estén dentro del rango
     */
    private static Set<Evento> getEventosMinMax(Set<Evento> haystack, int min, int max) {

        Set<Evento> eventos = new HashSet<>();

        for (Evento evento : haystack)
            if (evento.getValor() >= min && evento.getValor() <= max)
                eventos.add(evento);

        return eventos;
    }
}
