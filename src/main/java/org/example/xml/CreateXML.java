package org.example.xml;



import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreateXML {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

//            root element
            Element tag0 = doc.createElement("tag0");
            doc.appendChild(tag0);

//            tag 1
            Element tag1 = doc.createElement("tag1");
            tag0.appendChild(tag1);
//            setting attribute to element
            Attr attr = doc.createAttribute("tag1Name");
            attr.setValue("t1Name1");
            tag1.setAttributeNode(attr);
            Attr attr1 = doc.createAttribute("tag1_id");
            attr1.setValue("1");
            tag1.setAttributeNode(attr1);

//            Student Name Element
            Element tag2 = doc.createElement("tag2");
            Attr attrType = doc.createAttribute("tag2_ID");
            attrType.setValue("001");
            tag2.setAttributeNode(attrType);

            Element t1 = doc.createElement("t1");
            t1.appendChild(doc.createTextNode("string"));
            tag2.appendChild(t1);

            Element t2 = doc.createElement("t2");
            t2.appendChild(doc.createTextNode("string"));
            tag2.appendChild(t2);

            Element t3 = doc.createElement("t3");
            t3.appendChild(doc.createTextNode("28.10.1998"));
            tag2.appendChild(t3);

            Element t4 = doc.createElement("t4");
            t4.appendChild(doc.createTextNode("string"));
            tag2.appendChild(t4);
            tag1.appendChild(tag2);

            Element listElements = doc.createElement("listElements");
            Element listElement = doc.createElement("listElement");
            listElement.appendChild(doc.createTextNode("string"));
            listElements.appendChild(listElement);
            tag2.appendChild(listElements);

            Element listElement2 = doc.createElement("listElement");
            listElement2.appendChild(doc.createTextNode("string"));
            listElements.appendChild(listElement2);
            tag2.appendChild(listElements);

            Element listElement3 = doc.createElement("listElement");
            listElement3.appendChild(doc.createTextNode("string"));
            listElements.appendChild(listElement3);
            tag2.appendChild(listElements);

            Element t5 = doc.createElement("t5");
            t5.appendChild(doc.createTextNode("123456789"));
            tag2.appendChild(t5);
            tag1.appendChild(tag2);

//            Second tag 2

            Element tag22 = doc.createElement("tag2");
            Attr attrType2 = doc.createAttribute("tag2_ID");
            attrType2.setValue("002");
            tag22.setAttributeNode(attrType2);

            Element t11 = doc.createElement("t1");
            t11.appendChild(doc.createTextNode("string"));
            tag22.appendChild(t11);

            Element t22 = doc.createElement("t2");
            t22.appendChild(doc.createTextNode("string"));
            tag22.appendChild(t22);

            Element t33 = doc.createElement("t3");
            t33.appendChild(doc.createTextNode("02.02.2020"));
            tag22.appendChild(t33);

            Element t44 = doc.createElement("t4");
            t44.appendChild(doc.createTextNode("string"));
            tag22.appendChild(t44);

            Element listElem = doc.createElement("listElements");

            Element listElem1 = doc.createElement("listElement");
            listElem1.appendChild(doc.createTextNode("string"));
            listElem.appendChild(listElem1);
            tag22.appendChild(listElem);

            Element listElem2 = doc.createElement("listElement");
            listElem2.appendChild(doc.createTextNode("string"));
            listElem.appendChild(listElem2);
            tag22.appendChild(listElem);

            Element listElem3 = doc.createElement("listElement");
            listElem3.appendChild(doc.createTextNode("string"));
            listElem.appendChild(listElem3);
            tag22.appendChild(listElem);

            Element t55 = doc.createElement("t5");
            t55.appendChild(doc.createTextNode("001"));
            tag22.appendChild(t55);

            tag1.appendChild(tag22);


            Element newTag1 = doc.createElement("tag1");
            tag0.appendChild(newTag1);
//            setting attribute to element
            Attr att = doc.createAttribute("tag1Name");
            att.setValue("t1Name2");
            newTag1.setAttributeNode(att);
            Attr att1 = doc.createAttribute("tag1_id");
            att1.setValue("2");
            newTag1.setAttributeNode(att1);

            Element someElement = doc.createElement("someAnotherElement");
            someElement.appendChild(doc.createTextNode("some info"));
            newTag1.appendChild(someElement);

//            Write in XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/home/cristian/IdeaProjects/Laborator1/students.xml"));
            transformer.transform(source, result);

//            Console output
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);


        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
