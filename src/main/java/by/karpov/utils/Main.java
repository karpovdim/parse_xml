package by.karpov.utils;

import by.karpov.Order.OrderAssemblyStrategy;
import by.karpov.Order.SmallerPriseKitOrderAssemblyStrategy;
import by.karpov.models.Software;
import by.karpov.service.DocumentService;
import by.karpov.service.NodeElementService;
import by.karpov.service.SoftwareService;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Document document = DocumentService.getDocument("software.xml");
        List<Node> softwareElements = NodeElementService.getSoftwareElements(document);
        List<Software> softwareList = SoftwareService.converter(softwareElements);
        OrderAssemblyStrategy order = new SmallerPriseKitOrderAssemblyStrategy();
        List<Software> smallerPriseOrder = order.getOrder(softwareList);
        System.out.println(smallerPriseOrder);
        System.out.println(SoftwareService.getCountSizeAndPrise(smallerPriseOrder));
        System.out.println(SoftwareService.toXml(smallerPriseOrder.get(0)));
//        for (Software software : softwareList) {
//            System.out.println(software.toString());
//        }
        //  List<Software>smallerSizeOrder = order(softwareList);
    }
}
