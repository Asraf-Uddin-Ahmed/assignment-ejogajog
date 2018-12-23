package com.ejogajog.rsql;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.ejogajog.rsql.handler.EqualOperationHandler;
import com.ejogajog.rsql.handler.GreaterThanOperationHandler;
import com.ejogajog.rsql.handler.GreaterThanOrEqualOperationHandler;
import com.ejogajog.rsql.handler.InOperationHandler;
import com.ejogajog.rsql.handler.LessThanOperationHandler;
import com.ejogajog.rsql.handler.LessThanOrEqualOperationHandler;
import com.ejogajog.rsql.handler.NotEqualOperationHandler;
import com.ejogajog.rsql.handler.NotInOperationHandler;
import com.ejogajog.rsql.handler.OperationHandler;

import cz.jirutka.rsql.parser.ast.ComparisonOperator;

@SuppressWarnings("serial")
public class GenericRsqlSpecification<T> implements Specification<T> {

	private String property;
	private ComparisonOperator operator;
	private List<String> arguments;

	public GenericRsqlSpecification(final String property, final ComparisonOperator operator,
			final List<String> arguments) {
		super();
		this.property = property;
		this.operator = operator;
		this.arguments = arguments;
	}

	@Override
	public Predicate toPredicate(final Root<T> root, final CriteriaQuery<?> query, final CriteriaBuilder builder) {
		OperationHandler<T> equalOperationHandler = new EqualOperationHandler<>(property, this.arguments, root,
				builder);
		OperationHandler<T> notEqualOperationHandler = new NotEqualOperationHandler<>(property, this.arguments, root,
				builder);
		OperationHandler<T> greaterThanOperationHandler = new GreaterThanOperationHandler<>(property, this.arguments,
				root, builder);
		OperationHandler<T> greaterThanOrEqualOperationHandler = new GreaterThanOrEqualOperationHandler<>(property,
				this.arguments, root, builder);
		OperationHandler<T> lessThanOperationHandler = new LessThanOperationHandler<>(property, this.arguments, root,
				builder);
		OperationHandler<T> lessThanOrEqualOperationHandler = new LessThanOrEqualOperationHandler<>(property,
				this.arguments, root, builder);
		OperationHandler<T> inOperationHandler = new InOperationHandler<>(property, this.arguments, root, builder);
		OperationHandler<T> notInOperationHandler = new NotInOperationHandler<>(property, this.arguments, root,
				builder);

		RsqlSearchOperation operation = RsqlSearchOperation.getSimpleOperator(operator);

		equalOperationHandler.setSuccessor(notEqualOperationHandler);
		notEqualOperationHandler.setSuccessor(greaterThanOperationHandler);
		greaterThanOperationHandler.setSuccessor(greaterThanOrEqualOperationHandler);
		greaterThanOrEqualOperationHandler.setSuccessor(lessThanOperationHandler);
		lessThanOperationHandler.setSuccessor(lessThanOrEqualOperationHandler);
		lessThanOrEqualOperationHandler.setSuccessor(inOperationHandler);
		inOperationHandler.setSuccessor(notInOperationHandler);

		return equalOperationHandler.handleOperation(operation);
	}

}