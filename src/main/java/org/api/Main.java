package org.api;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

public class Main {

    private static final String FUENTES_DATA = "./data/Fuentes.xml";

    public static void main(String[] args) {
        ArrayList<Fuente> fuentes = loadFuentes();
        System.out.println("Hello world!");
    }

    /**
     * Carga las fuentes de datos desde el archivo XML
     * @return ArrayList de fuentes
     */
    public static ArrayList<Fuente> loadFuentes() {

        ArrayList<Fuente> fuentes = new ArrayList<>();

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
        } catch (Exception e) {
            // Tratamiento genérico de excepciones
            e.printStackTrace();
        }
        return fuentes;
    }

}