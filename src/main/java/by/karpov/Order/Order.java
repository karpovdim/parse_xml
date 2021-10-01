package by.karpov.Order;

import by.karpov.models.Software;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public  interface Order {
   List<Software> getOrder(Map<String, TreeSet<Software>> sets);
     BigDecimal price = null;
     Integer size = null;
     
}
