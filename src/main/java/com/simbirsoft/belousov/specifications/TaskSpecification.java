package com.simbirsoft.belousov.specifications;

import com.simbirsoft.belousov.entity.TaskEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TaskSpecification {
public static Specification <TaskEntity> GetByName (String name) {
    return new Specification<TaskEntity>() {
        @Override
        public Predicate toPredicate(Root<TaskEntity> root,
                                     CriteriaQuery<?> criteriaQuery,
                                     CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.like(root.get("name"),"%"+name+"%");
        }
    };
    }
}

