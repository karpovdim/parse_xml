package by.karpov.utils;

import by.karpov.Order.OrderAssemblyStrategy;
import by.karpov.Order.SmallerPriseKitOrderAssemblyStrategy;
import by.karpov.models.Software;
import by.karpov.service.DocumentService;
import by.karpov.service.NodeElementService;
import by.karpov.service.SoftwareService;
import by.karpov.service.Writer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Document document = DocumentService.getDocument("software.xml");
        List<Node> softwareNodElements = NodeElementService.getSoftwareNodElements(document);
        List<Software> softwareList = SoftwareService.nodeToSoftware(softwareNodElements);
        OrderAssemblyStrategy order = new SmallerPriseKitOrderAssemblyStrategy();
        List<Software> smallerPriseOrder = order.getOrder(softwareList);
        String xmlString = SoftwareService.toXmlByListSoftware(smallerPriseOrder);
        Writer.writeToXmlFile(xmlString, "order.xml");
    }
}
