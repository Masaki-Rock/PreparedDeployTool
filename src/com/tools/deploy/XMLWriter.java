package com.tools.deploy;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWriter {

    public void create(String path, List<MetaObject> mlist) {

        // Documentインスタンスの生成
        DocumentBuilder documentBuilder = null;
        try {
             documentBuilder = DocumentBuilderFactory.newInstance()
                       .newDocumentBuilder();
        } catch (ParserConfigurationException e) {
             e.printStackTrace();
        }
        Document document = documentBuilder.newDocument();

        // XML文書の作成
        Element p = document.createElement("Package");
        p.setAttribute("xmlns", "http://soap.sforce.com/2006/04/metadata");
        document.appendChild(p);
 
        for (MetaObject m : mlist) {
        	Element t = document.createElement("types");
        	for (String str : m.getMembers()) {
        		Element mem = document.createElement("members");
                mem.appendChild(document.createTextNode(str));
                t.appendChild(mem);
        	}
            Element name = document.createElement("name");
            name.appendChild(document.createTextNode(m.getName()));
            t.appendChild(name);
            p.appendChild(t);
        }
        
        Element v = document.createElement("version");
        v.appendChild(document.createTextNode(Const.VERSION_API));
        p.appendChild(v);
        

        // XMLファイルの作成
        File file = new File(path + Const.MANIFEST_FILE);
        write(file, document);
   }

   private boolean write(File file, Document document) {

        // Transformerインスタンスの生成
        Transformer transformer = null;
        try {
             TransformerFactory transformerFactory = TransformerFactory.newInstance();
             transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
             e.printStackTrace();
             return false;
        }

        // Transformerの設定
        transformer.setOutputProperty("indent", "yes"); //改行指定
        transformer.setOutputProperty("encoding", "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","2");

        // XMLファイルの作成
        System.out.println("Manifest file create..."+ transformer + ":" + document + ":" + file);
        try {
             transformer.transform(new DOMSource(document), new StreamResult(file));
        } catch (TransformerException e) {
             e.printStackTrace();
             return false;
        }

        return true;
   }
}
