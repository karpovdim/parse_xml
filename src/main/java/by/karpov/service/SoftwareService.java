package by.karpov.service;

import by.karpov.models.Software;
import org.w3c.dom.Node;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SoftwareService {
    public static List<Software> converter(List<Node> nodesParent) {
        List<Software> softwareList = new ArrayList<>();
        List<Node> nodesChild = NodeElementService.getListTegsByNodeList(nodesParent);

        for (int j = 0; j < nodesChild.size(); j++) {

            for (Node node : nodesParent) {
                Software software = new Software();
                software.setTypeSoftware(node.getParentNode().getNodeName());
                software.setName(nodesChild.get(j++).getTextContent());
                software.setVersion(nodesChild.get(j++).getTextContent());
                software.setSize(Integer.parseInt( nodesChild.get(j++).getTextContent()));
                software.setPrice( new BigDecimal( nodesChild.get(j++).getTextContent()));
                softwareList.add(software);
            }
        }
        return softwareList;
    }
}


