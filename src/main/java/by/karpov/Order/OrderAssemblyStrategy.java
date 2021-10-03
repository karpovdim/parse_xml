package by.karpov.Order;

import by.karpov.models.Software;

import java.util.*;

public interface OrderAssemblyStrategy {
    List<Software> getOrder(List<Software> softwareList);
}

