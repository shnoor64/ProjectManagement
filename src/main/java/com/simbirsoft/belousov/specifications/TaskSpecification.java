//package com.simbirsoft.belousov.specifications;
//
//import com.simbirsoft.belousov.entity.TaskEntity;
//import org.springframework.data.jpa.domain.Specification;
//
//import javax.persistence.criteria.*;
//
//public class TaskSpecification {
//    public static Specification<TaskEntity> GetByName(String name) {
//        return new Specification<TaskEntity>() {
//            @Override
//            public Predicate toPredicate(Root<TaskEntity> root,
//                                         CriteriaQuery<?> criteriaQuery,
//                                         CriteriaBuilder criteriaBuilder) {
//                return criteriaBuilder.like(root.get("name"), "%" + name + "%");
//            }
//        };
//    }
//
//    public static Specification<TaskEntity> GetByRelease(int releaseVersion) {
//        return new Specification<TaskEntity>() {
//            @Override
//            public Predicate toPredicate(Root<TaskEntity> root,
//                                         CriteriaQuery<?> criteriaQuery,
//                                         CriteriaBuilder criteriaBuilder) {
//                Join join = root.join("releaseId");
//                return criteriaBuilder.equal(join.get("version"), releaseVersion );
//            }
//        };
//    }
//    public static Specification<TaskEntity> GetByAuthor(String authorName) {
//        return new Specification<TaskEntity>() {
//            @Override
//            public Predicate toPredicate(Root<TaskEntity> root,
//                                         CriteriaQuery<?> criteriaQuery,
//                                         CriteriaBuilder criteriaBuilder) {
//                Join join = root.join("authorId");
//                return criteriaBuilder.equal(join.get("name"), authorName );
//            }
//        };
//    }
//    public static Specification<TaskEntity> GetByPerformer(String performerName) {
//        return new Specification<TaskEntity>() {
//            @Override
//            public Predicate toPredicate(Root<TaskEntity> root,
//                                         CriteriaQuery<?> criteriaQuery,
//                                         CriteriaBuilder criteriaBuilder) {
//                Join join = root.join("performerId");
//                return criteriaBuilder.equal(join.get("name"), performerName );
//            }
//        };
//    }
//}
//
package com.simbirsoft.belousov.specifications;

import com.simbirsoft.belousov.entity.TaskEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class TaskSpecification {
    public static Specification<TaskEntity> GetByName(String taskName) {
        return new Specification<TaskEntity>() {
            @Override
            public Predicate toPredicate(Root<TaskEntity> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("name"), "%" + taskName + "%");
            }
        };
    }

    public static Specification<TaskEntity> GetByRelease(int taskRelease) {
        return new Specification<TaskEntity>() {
            @Override
            public Predicate toPredicate(Root<TaskEntity> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                Join join = root.join("releaseId");
                return criteriaBuilder.equal(join.get("version"), taskRelease);
            }
        };
    }

    public static Specification<TaskEntity> GetByAuthor(String taskAuthor) {
        return new Specification<TaskEntity>() {
            @Override
            public Predicate toPredicate(Root<TaskEntity> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                Join join = root.join("authorId");
                return criteriaBuilder.equal(join.get("name"), taskAuthor);
            }
        };
    }

    public static Specification<TaskEntity> GetByPerformer(String taskPerformer) {
        return new Specification<TaskEntity>() {
            @Override
            public Predicate toPredicate(Root<TaskEntity> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                Join join = root.join("performerId");
                return criteriaBuilder.equal(join.get("name"), taskPerformer);
            }
        };
    }
}

