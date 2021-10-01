package by.karpov.Order;

import by.karpov.models.Software;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

public class SmallerKit {
    public List<Software> getOrder(List<Software> softwareList) {
        return getList(getSortedMap(softwareList));
    }

    private Map<String, TreeSet<Software>> getSortedMap(List<Software> softwareList) {
        Map<String, TreeSet<Software>> sets = new HashMap<>();
        for (Software software : softwareList) {
            Map<String, TreeSet<Software>> stringSetMap = addToSet(software, sets);
        }
        return sets;
    }

    private Map<String, TreeSet<Software>> addToSet(Software value, Map<String, TreeSet<Software>> sets) {
        String softType = value.getTypeSoftware();
        if (!sets.containsKey(softType)) {
            sets.put(softType, new TreeSet<Software>());
        }
        TreeSet<Software> values = sets.get(softType);
        values.add(value);
        return sets;
    }

    private List<Software> getList(Map<String, TreeSet<Software>> sets) {
        List<Software> softwareList = new ArrayList<>();
        for (TreeSet<Software> value : sets.values()) {
            softwareList.add(CollectionUtils.get(value, 0));
        }
        return softwareList;
    }
}
