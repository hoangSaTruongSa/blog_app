package com.vti.BlogApp.specification;

import com.vti.BlogApp.entity.Comment;
import com.vti.BlogApp.form.CommentFilterForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;

public class CommentSpecification {
    public static Specification<Comment> buildSpec(CommentFilterForm form)
    {
        return (root, query, criteriaBuilder) -> {
            var predicates = new ArrayList<Predicate>();

            var postId = form.getPostId();
            if (postId != null)
            {
                var predicate = criteriaBuilder.equal(root.get("post").get("id"), postId);
                predicates.add(predicate);
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
