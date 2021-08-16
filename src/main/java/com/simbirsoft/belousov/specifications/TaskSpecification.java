package com.simbirsoft.belousov.specifications;

import com.simbirsoft.belousov.entity.TaskEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class TaskSpecification {

    /**
     * Метод позволяет получить спецификацию для поиска задачи по имени
     *
     * @param taskName - искомое имя
     * @return Specification<TaskEntity> - спецификация для поиска задачи
     */
    public static Specification<TaskEntity> getByName(String taskName) {
        if (taskName == null) {
            return null;
        }
        return new Specification<TaskEntity>() {
            @Override
            public Predicate toPredicate(Root<TaskEntity> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("name"), "%" + taskName + "%");
            }
        };
    }

    /**
     * Метод позволяет получить спецификацию для поиска задачи по релизу
     *
     * @param taskRelease - искомый релиз
     * @return Specification<TaskEntity> - спецификация для поиска задачи
     */
    public static Specification<TaskEntity> GetByRelease(int taskRelease) {
        if (taskRelease == 0) {
            return null;
        }
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

    /**
     * Метод позволяет получить спецификацию для поиска задачи по автору
     *
     * @param taskAuthor - искомый автор
     * @return Specification<TaskEntity> - спецификация для поиска задачи
     */
    public static Specification<TaskEntity> GetByAuthor(String taskAuthor) {
        if (taskAuthor == null) {
            return null;
        }
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

    /**
     * Метод позволяет получить спецификацию для поиска задачи по исполнителю
     *
     * @param taskPerformer - искомый исполнитель
     * @return Specification<TaskEntity> - спецификация для поиска задачи
     */
    public static Specification<TaskEntity> GetByPerformer(String taskPerformer) {
        if (taskPerformer == null) {
            return null;
        }
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

