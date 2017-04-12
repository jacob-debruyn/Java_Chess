import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class register {

	static boolean registerUser(String username,String password) throws IOException{
		checkFile();		
		if(!checkUser(username,password)){
			confirmRegistation(username,password);
			return true;
		}
		else return false;
		
		
	}
	static void checkFile() throws IOException{	
		File file = new File("users.xml");
		if(!file.exists()) { 
			PrintWriter writer = new PrintWriter("users.xml", "UTF-8");
			writer.println("<users></users>");
			writer.close();
		}
	}
	static boolean checkUser(String username, String password) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();		
            Document doc = db.parse(new File("users.xml"));
            
            Element docEle = doc.getDocumentElement(); 
            NodeList userList = docEle.getElementsByTagName("user");
            
            
            for (int i = 0; i < userList.getLength(); i++) {
                Node node = userList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {                     
                    Element e = (Element) node;
                    NodeList nodeList = e.getElementsByTagName("username");
                    String name = nodeList.item(0).getChildNodes().item(0).getNodeValue();  
                    
                    if(name.compareTo(username)==0){
                    	return true;
                    }
                    
                }
            }                   
		}
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
		return false;
	}
	static boolean confirmRegistation(String username,String password){
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	       		
            Document doc = db.parse(new File("users.xml"));
            
            Element docEle = doc.getDocumentElement(); 	            
            Element newUser = doc.createElement("user");
            Element name = doc.createElement("username");
            Element pass = doc.createElement("password");
            
            name.appendChild(doc.createTextNode(username));    
            pass.appendChild(doc.createTextNode(password));
            
            newUser.appendChild(name);
            newUser.appendChild(pass);
            docEle.appendChild(newUser);
           

            DOMSource source = new DOMSource(doc);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("users.xml");
            transformer.transform(source, result);
	        
            return true;
		}
		catch (Exception e) {
            System.out.println(e);
            return false;
        }
	}
}
