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
                software.setSize(Integer.parseInt(nodesChild.get(j++).getTextContent()));
                software.setPrice(new BigDecimal(nodesChild.get(j++).getTextContent()));
                softwareList.add(software);
            }
        }
        return softwareList;
    }

    public static String getCountSizeAndPrise(List<Software> softwareList) {
        String countSize = getCountSize(softwareList);
        String countPrise = getCountPrise(softwareList);
        return countSize + "\n" + countPrise;
    }

    public static String getCountSize(List<Software> softwareList) {
        int sum = softwareList.stream()
                .mapToInt(Software::getSize)
                .sum();
        return String.format("sum size = %d", sum);
    }

    public static String getCountPrise(List<Software> softwareList) {
        BigDecimal sum = softwareList.stream()
                .map(Software::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return String.format("sum prise = %.2f", sum);


    }
    public static String toXml(Software software){
        String typeSoftware = software.getTypeSoftware();
        String name = software.getName();
        String format = String.format("<%s>\n %-20s<NAME>%s</NAME>\n</%s>", typeSoftware, name, typeSoftware);
        return format;
    }

}

