package by.karpov.Order;

import by.karpov.models.Software;
import org.apache.commons.lang3.StringUtils;

import java.util.*;


public class SmallerPriseKitOrderAssemblyStrategy implements OrderAssemblyStrategy {

    final static Comparator<Software> comparator = Comparator.comparing(Software::getPrice);

    public List<Software> getOrder(List<Software> softwareList) {
        Map<String, TreeSet<Software>> sortedSoftwareList = getSortedMap(softwareList);
        List<Software> processingSoftwareList = new ArrayList<>();
        for (Set<Software> softwareSet : sortedSoftwareList.values()) {
            ArrayList<Software> software = new ArrayList<>();
            software.sort(comparator);
            processingSoftwareList.add(softwareSet.iterator().next());
        }
        return processingSoftwareList;
    }

    private Map<String, TreeSet<Software>> getSortedMap(List<Software> softwareList) {
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