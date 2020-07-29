package com.option.structural.criteria_filter.criteria;

import com.option.structural.criteria_filter.entity.Person;

import java.util.List;

public interface Criteria {
    // 满足条件
    List<Person> meetCriteria(List<Person> persons);
}
