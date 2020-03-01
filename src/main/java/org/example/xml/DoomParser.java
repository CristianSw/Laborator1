package org.example.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DoomParser {
    public static void main(String[] args) {

        try {
            File inputFile = new File("students.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("tag2");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("ID : "
                            + eElement.getAttribute("tag2_ID"));
                    System.out.println("t1 : "
                            + eElement
                            .getElementsByTagName("t1")
                            .item(0)
                            .getTextContent());
                    System.out.println("t2 : "
                            + eElement
                            .getElementsByTagName("t2")
                            .item(0)
                            .getTextContent());
                    System.out.println("t3 : "
                            + eElement
                            .getElementsByTagName("t3")
                            .item(0)
                            .getTextContent());
                    System.out.println("t4 : "
                            + eElement
                            .getElementsByTagName("t4")
                            .item(0)
                            .getTextContent());
                    System.out.println("t5 : "
                            + eElement
                            .getElementsByTagName("t5")
                            .item(0)
                            .getTextContent());
                }
//                System.out.println("TEMP : " + temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

