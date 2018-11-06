package com.telesens.academy.automationpractice.model.comparator;

import com.telesens.academy.automationpractice.model.EntityDress;

import java.util.Comparator;

public class ComparatorDressByName implements Comparator<EntityDress> {

    @Override
    public int compare(EntityDress o1, EntityDress o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
