package by.karpov.service;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class NodeElementService {
    public static final short ELEMENT_NODE = Node.ELEMENT_NODE;

    public static List<Node> getSoftwareElements(Document document){
        List<Node> nodeList = getListTegsByNode(document.getFirstChild());
       return getListTegsByNodeList(nodeList);
    }
   private static List<Node> getListTegsByNode(Node firstChild) {
        NodeList childNodes = firstChild.getChildNodes();
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() != ELEMENT_NODE) {
                continue;
            }
            Node node = childNodes.item(i);
            nodeList.add(node);
        }
        return nodeList;
    }

    public static List<Node> getListTegsByNodeList(List<Node> nodeList) {
        List<Node> nodesResult = new ArrayList<>();
        for (int i = 0; i < nodeList.size(); i++) {
            NodeList childNodes = nodeList.get(i).getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                if (childNodes.item(j).getNodeType() != ELEMENT_NODE) {
                    continue;
                }
                //  System.out.println(childNodes.item(j).getNodeName());
                nodesResult.add(childNodes.item(j));
                // if (nodesResult.get(i).hasChildNodes()) getListTegsByNodeList(nodesResult);
            }
        }
        return nodesResult;
    }
}
