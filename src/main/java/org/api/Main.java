package org.api;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileNotFoundException;
import java.util.*;

import static org.api.Buscador.*;

/**
 * @author Martin Valiente Ainz
 */
public class Main {

    private static final String FUENTES_DATA = "./data/Fuentes.xml";
    private static final String EVENTOS_DATA = "./data/Eventos.xml";

    public static void main(String[] args) {
        Set<Fuente> fuentes = loadFuentes();
        Set<Evento> eventos = loadEventos();
        while (true) {
            try {
                switch (printMenu()) {
                    case 1 :
                        printEventosDate(eventos);
                        break;
                    case 2 :
                        printEventosFuenteId(eventos);
                        break;
                    case 3 :
                        printEventosMinMax(eventos);
                        break;
                    case 4 :
                        tester(eventos);
                        break;
                    default : System.out.println("Opción no válida");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, introduzca un número");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * Imprimir el menú principal y devolver la opción elegida
     *
     * @return Opción elegida como Integer
     */
    private static int printMenu() {

        Scanner input = new Scanner(System.in);

        System.out.println(
                "---- PRUEBA TÉCNICA ARIADNA GRID ----\n" +
                "1 - Buscar eventos por lista de timestamps.\n" +
                "2 - Buscar eventos por fuente_id.\n" +
                "3 - Buscar eventos dentro de un rango de valores (valor min, valor max).\n" +
                "4 - Ejecutar métodos de prueba."
        );
        return (input.nextInt());
    }

    /**
     * Carga las fuentes desde el archivo XML
     *
     * @return Set de fuentes
     */
    public static Set<Fuente> loadFuentes() {

        Set<Fuente> fuentes = new HashSet<>();

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(FUENTES_DATA);
            doc.getDocumentElement().normalize();
            NodeList fuenteList = doc.getElementsByTagName("Fuente");

            // Iterador por cada elemento "Fuente"
            for (int i = 0; i < fuenteList.getLength(); i++) {
                if (fuenteList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) fuenteList.item(i);
                    // Crea la fuente
                    Fuente fuente = new Fuente(
                            Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()),
                            element.getElementsByTagName("nombre").item(0).getTextContent());
                    fuentes.add(fuente);
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Error: No se ha encontrado el archivo " + FUENTES_DATA);
        } catch (Exception e) {
            // Tratamiento genérico de excepciones
            e.printStackTrace();
        }
        return fuentes;
    }

    /**
     * Carga los eventos desde el archivo XML
     *
     * @return Set de eventos
     */
    public static Set<Evento> loadEventos() {

        Set<Evento> eventos = new HashSet<>();

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(EVENTOS_DATA);
            doc.getDocumentElement().normalize();
            NodeList eventoList = doc.getElementsByTagName("Evento");

            // Iterador por cada elemento "Evento"
            for (int i = 0; i < eventoList.getLength(); i++) {
                if (eventoList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) eventoList.item(i);
                    // Crea el Evento
                    Evento evento = new Evento(
                            Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()),
                            Integer.parseInt(element.getElementsByTagName("fuenteId").item(0).getTextContent()),
                            // Convierte el Unix timestamp a Date,
                            // hay que multiplicar por 1000 porque Date espera milisegundos
                            // y casteamos a long
                            new Date(Integer.parseInt(
                                    element.getElementsByTagName("fecha").item(0).getTextContent()) * 1000L),
                            Integer.parseInt(element.getElementsByTagName("valor").item(0).getTextContent())
                    );
                    eventos.add(evento);
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Error: No se ha encontrado el archivo " + EVENTOS_DATA);
        } catch (Exception e) {
            // Tratamiento genérico de excepciones
            e.printStackTrace();
        }
        return eventos;
    }

}