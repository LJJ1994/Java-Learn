package com.option.structural.criteria_filter.criteria.impl;

import com.option.structural.criteria_filter.criteria.Criteria;
import com.option.structural.criteria_filter.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria {
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> people = new ArrayList<Person>();
        for (Person person : persons) {
            if ("Female".equalsIgnoreCase(person.getGender())) {
                people.add(person);
            }
        }
        return people;
    }
}
