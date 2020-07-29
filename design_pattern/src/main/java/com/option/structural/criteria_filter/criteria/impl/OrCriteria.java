package com.option.structural.criteria_filter.criteria.impl;

import com.option.structural.criteria_filter.criteria.Criteria;
import com.option.structural.criteria_filter.entity.Person;

import java.util.List;

public class OrCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;
    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstMeetCriteriaPersons = criteria.meetCriteria(persons);
        List<Person> secondMeetCriteriaPersons = otherCriteria.meetCriteria(persons);
        for (Person person : secondMeetCriteriaPersons) {
            if (!firstMeetCriteriaPersons.contains(person)) {
                firstMeetCriteriaPersons.add(person);
            }
        }
        return firstMeetCriteriaPersons;
    }
}
