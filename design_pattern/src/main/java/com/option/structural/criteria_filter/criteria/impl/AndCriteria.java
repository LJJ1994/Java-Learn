package com.option.structural.criteria_filter.criteria.impl;

import com.option.structural.criteria_filter.criteria.Criteria;
import com.option.structural.criteria_filter.entity.Person;

import java.util.List;

public class AndCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;
    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstMeetCriteriaPersons = criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstMeetCriteriaPersons);
    }
}
