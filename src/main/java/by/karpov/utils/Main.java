package by.karpov.utils;

import by.karpov.Order.Order;
import by.karpov.Order.SmallerKit;
import by.karpov.models.Software;
import by.karpov.service.DocumentService;
import by.karpov.service.NodeElementService;
import by.karpov.service.SoftwareService;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.*;

public class Main {



    public static void main(String[] args) {

        Document document = DocumentService.getDocument("software.xml");
        List<Node> softwareElements = NodeElementService.getSoftwareElements(document);
        List<Software> softwareList = SoftwareService.converter(softwareElements);
        SmallerKit order = new SmallerKit();
        List<Software>smallerSizeOrder = order.getOrder(softwareList);
        System.out.println(smallerSizeOrder);
//        for (Software software : softwareList) {
//            System.out.println(software.toString());
//        }
    }
}
