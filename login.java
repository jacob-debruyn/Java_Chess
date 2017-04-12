import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class login {
	static boolean loginUser(String username, String password, int j, int moves){
		try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File("users.xml");
            if (file.exists()) {
                Document doc = db.parse(file);
                Element docEle = doc.getDocumentElement(); 
                NodeList userList = docEle.getElementsByTagName("user");
               
                for (int i = 0; i < userList.getLength(); i++) {
 
	                Node node = userList.item(i);
	 
	                if (node.getNodeType() == Node.ELEMENT_NODE) {                     
	                    Element e = (Element) node;
	                    NodeList nodeList = e.getElementsByTagName("username");
	                    String name = nodeList.item(0).getChildNodes().item(0).getNodeValue();  
	                    
	                    if(name.compareTo(username)==0){
	                    	
	                    	nodeList = e.getElementsByTagName("password");
	                        String pass = nodeList.item(0).getChildNodes().item(0).getNodeValue();
	                        if(pass.compareTo(password)==0){
	                        	return true;
	                        }
	                        
	                    }
	                   
	                }
                }
        	}
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
		
		return false;
	}
}
