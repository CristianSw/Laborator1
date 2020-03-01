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
            Element rootElement = doc.createElement("tag0");
            doc.appendChild(rootElement);

//            best element
            Element bestStudent = doc.createElement("tag1");
            rootElement.appendChild(bestStudent);
//            setting attribute to element
            Attr attr = doc.createAttribute("grupa");
            attr.setValue("Student");
            bestStudent.setAttributeNode(attr);
            Attr attr1 = doc.createAttribute("id");
            attr1.setValue("1");
            bestStudent.setAttributeNode(attr1);

//            Student Name Element
            Element studentName = doc.createElement("tag2");
            Attr attrType = doc.createAttribute("tag2_ID");
            attrType.setValue("001");
            studentName.setAttributeNode(attrType);
            Element t1 = doc.createElement("t1");
            t1.appendChild(doc.createTextNode("string"));
            studentName.appendChild(t1);
            bestStudent.appendChild(studentName);

            Element studentName2 = doc.createElement("studentName");
            Attr attrType2 = doc.createAttribute("name");
            attrType2.setValue("Cristian");
            studentName2.setAttributeNode(attrType2);
            studentName2.appendChild(doc.createTextNode("10000000000000000000"));
            bestStudent.appendChild(studentName2);

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
