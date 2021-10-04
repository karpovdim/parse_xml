package by.karpov.service;

import by.karpov.models.Software;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Node;

import java.math.BigDecimal;
import java.util.*;

public class SoftwareService {
    public static List<Software> nodeToSoftware(List<Node> nodesParent) {
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
        return String.format("\n<SUM_SIZE>%d</SUM_SIZE>", sum);
    }

    public static String getCountPrise(List<Software> softwareList) {
        BigDecimal sum = softwareList.stream()
                .map(Software::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return String.format("<SUM_PRICE>%.2f</SUM_PRICE>", sum);

    }

    public static String toXmlByListSoftware(List<Software> softwareList) {
        StringBuilder result = new StringBuilder("<?xml version=\"1.0\"?>");
        result.append("\n<SOFTWARE>");
        Map<String, TreeSet<Software>> processingSoftwareMap = getSortedMap(softwareList);
        for (String s : processingSoftwareMap.keySet()) {
            result.append(String.format("\n<%s>", s));
            for (TreeSet<Software> value : processingSoftwareMap.values()) {
                for (Software software : value) {
                    if (s.equals(software.getTypeSoftware())) {
                        String xmlElement = toXmlByElement(software);
                        result.append(xmlElement);
                    }
                }
            }
            result.append(String.format("\n</%s>", s));
        }
        result.append(getCountSizeAndPrise(softwareList));
        result.append("\n</SOFTWARE>");
        return result.toString();
    }

    public static String toXmlByElement(Software software) {
        String name = software.getName();
        String version = software.getVersion();
        Integer size = software.getSize();
        BigDecimal price = software.getPrice();
        return String.format("\n\t<ELEMENT>\n\t\t<NAME>%s</NAME>\n\t\t<VERSION>%s</VERSION>\n\t\t<SIZE>%d</SIZE>\n\t\t<PRICE>%.2f</PRICE>\n\t</ELEMENT>",
                name,
                version,
                size,
                price);
    }

    public static Map<String, TreeSet<Software>> getSortedMap(List<Software> softwareList) {
        Map<String, TreeSet<Software>> processingSoftwareMap = new HashMap<>();
        for (Software software : softwareList) {
            String typeSoftware = software.getTypeSoftware();
            if (StringUtils.isEmpty(software.getTypeSoftware())) {
                continue;
            }
            if (!processingSoftwareMap.containsKey(typeSoftware)) {
                processingSoftwareMap.put(typeSoftware, new TreeSet<>());
            }
            processingSoftwareMap.get(typeSoftware).add(software);
        }
        return processingSoftwareMap;
    }
}

