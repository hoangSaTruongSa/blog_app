package com.vti.BlogApp.specification;

import com.vti.BlogApp.entity.Post;
import com.vti.BlogApp.form.PostFilterForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class PostSpecification {
    //phuong thuc build ra menh de Where
    public static Specification<Post> buildSpec(PostFilterForm form)
    {
        return (root, query, criteriaBuilder) -> {
            var predicates = new ArrayList<Predicate>();

            var search = form.getSearch();
            if (StringUtils.hasText(search))
            {
                var pattern = "%" + search.trim() +"%";
                var predicate = criteriaBuilder.like(root.get("title"), pattern);
                //From Post Where title like '%pattern%'
                predicates.add(predicate);
            }

            var minCreatedDate = form.getMinCreatedDate();
            if (minCreatedDate != null)
            {
                var minCreatedAt = LocalDateTime.of(minCreatedDate, LocalTime.MIN);
                var predicate = criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), minCreatedAt);
                predicates.add(predicate);
            }

            var maxCreatedDate = form.getMaxCreatedDate();
            if (maxCreatedDate != null)
            {
                var maxCreatedAt = LocalDateTime.of(maxCreatedDate, LocalTime.MAX);
                var predicate = criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), maxCreatedAt);
                predicates.add(predicate);
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
