package by.karpov.Order;

import by.karpov.models.Software;

import java.util.*;

import static by.karpov.service.SoftwareService.getSortedMap;

public class SmallerSizeKitOrderAssemblyStrategy implements OrderAssemblyStrategy {

    final static Comparator<Software> comparator = Comparator.comparingInt(Software::getSize);

    @Override
    public List<Software> getOrder(List<Software> softwareList) {
        Map<String, TreeSet<Software>> sortedSoftwareList = getSortedMap(softwareList);
        List<Software> processingSoftwareList = new ArrayList<>();
        for (Set<Software> softwareSet : sortedSoftwareList.values()) {
            ArrayList<Software> softwares = new ArrayList<>();
            softwares.sort(comparator);
            processingSoftwareList.add(softwareSet.iterator().next());
        }
        return processingSoftwareList;
    }
}
