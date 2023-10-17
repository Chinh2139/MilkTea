package com.vti.specification;

import com.vti.entity.Orders;
import com.vti.form.OrderFilterForm;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

//package com.vti.specification;
//
//import com.vti.entity.*;
//import com.vti.form.OrderFilterForm;
//import com.vti.form.ProductReviewsFilterForm;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.util.StringUtils;
//
//import java.time.LocalDate;
//
public class OrdersSpectification implements Specification<Orders> {
    private static final long serialVersionUID = 1L;

    private String field;
    private String operator;
    private Object value;

    public OrdersSpectification(String field, String operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }
    @Override
    public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (operator == "LIKE") {
            if (field == "name") {
                return criteriaBuilder.like(root.get("name"), "%" + value.toString() + "%");
            } else if (field == "category") {
                return criteriaBuilder.like(root.get("category").get("name"), "%" + value.toString() + "%");
            } else if (field == "unit_price") {
                return criteriaBuilder.like(root.get("unit_price"), "%" + value.toString() + "%");
            }
            else if (field == "product_id") {
                return criteriaBuilder.like(root.get("product_id"), "%" + value.toString() + "%");
            }
        }
        return null;
    }
//    public static Specification<Orders> buildWhere ( OrderFilterForm form ) {
//        if (form == null) {
//            return null;
//        }
//        return  hasNamelike(form.getSearch()).
//                or(hasAdresslike(form.getSearch())).
//                or(hasEmaillike(form.getSearch())).
//                or(hasPhonelike(form.getSearch())).
//                and(hasOrderDateGreaterThanOrEqualTo(form.getMinOrderDate())).
//                and(hasOrderDateLessThanOrEqualTo(form.getMaxOrderDate())).
//                and(hasUnitPriceGreaterThanOrEqualTo(form.getMinUnitPrice())).
//                and(hasUnitPriceLessThanOrEqualTo(form.getMaxUnitPrice())).
//                and(hasSizeEqual(form.getFilterSize())).
//                and(hasOrdersStatusEqual(form.getFilterOrderStatus())).
//                and(hasTypePayEqual(form.getFilterTypePay()));
//    }
//
//    private static Specification<Orders> hasNamelike ( String search ) {
//        return ( root, query, builder ) -> {
//            if (!StringUtils.hasText(search)) {
//                return null;
//            }
//            return builder.like(root.get(Orders_.name), "%" + search.trim() + "%");
//        };
//    }
//    private static Specification<Orders> hasPhonelike ( String search ) {
//        return ( root, query, builder ) -> {
//            if (!StringUtils.hasText(search)) {
//                return null;
//            }
//            return builder.like(root.get(Orders_.phone), "%" + search.trim() + "%") ;
//        };
//    }
//    private static Specification<Orders> hasAdresslike ( String search ) {
//        return ( root, query, builder ) -> {
//            if (!StringUtils.hasText(search)) {
//                return null;
//            }
//            return builder.like(root.get(Orders_.address), "%" + search.trim() + "%") ;
//        };
//    }
//    private static Specification<Orders> hasEmaillike ( String search ) {
//        return ( root, query, builder ) -> {
//            if (!StringUtils.hasText(search)) {
//                return null;
//            }
//            return builder.like(root.get(Orders_.email), "%" + search.trim() + "%") ;
//        };
//    }
//    private static Specification<Orders> hasSizeEqual(String filterSize) {
//        return (root, query, builder) -> {
//            if (!StringUtils.hasText(filterSize)) {
//                return null;
//            }
//            return builder.equal(root.get(Orders_.size), Orders.Size.valueOf(filterSize));
//        };
//    }
//    private static Specification<Orders> hasOrdersStatusEqual(String filterOrderStatus) {
//        return (root, query, builder) -> {
//            if (!StringUtils.hasText(filterOrderStatus)) {
//                return null;
//            }
//            return builder.equal(root.get(Orders_.orderStatus), Orders.OrderStatus.valueOf(filterOrderStatus));
//        };
//    }
//    private static Specification<Orders> hasTypePayEqual(String filterTypePay) {
//        return (root, query, builder) -> {
//            if (!StringUtils.hasText(filterTypePay)) {
//                return null;
//            }
//            return builder.equal(root.get(Orders_.typePay), Orders.TypePay.valueOf(filterTypePay));
//        };
//    }
//
//
//    private static Specification<Orders> hasUnitPriceGreaterThanOrEqualTo ( Double minUnitPrice ) {
//        return ( root, query, builder ) -> {
//            if (minUnitPrice == null) {
//                return null;
//            }
//            return builder.greaterThanOrEqualTo(root.get(Orders_.unitPrice),minUnitPrice);
//        };
//    }
//
//    private static Specification<Orders> hasUnitPriceLessThanOrEqualTo ( Double maxUnitPrice ) {
//        return ( root, query, builder ) -> {
//            if (maxUnitPrice == null) {
//                return null;
//            }
//            return builder.lessThanOrEqualTo(root.get(Orders_.unitPrice),maxUnitPrice);
//        };
//    }
//    private static Specification<Orders> hasOrderDateGreaterThanOrEqualTo ( LocalDate minOrderDate ) {
//        return ( root, query, builder ) -> {
//            if (minOrderDate == null) {
//                return null;
//            }
//            return builder.greaterThanOrEqualTo(root.get(Orders_.orderDate).as(LocalDate.class),minOrderDate);
//        };
//    }
//
//    private static Specification<Orders> hasOrderDateLessThanOrEqualTo ( LocalDate maxOrderDate ) {
//        return ( root, query, builder ) -> {
//            if (maxOrderDate == null) {
//                return null;
//            }
//            return builder.lessThanOrEqualTo(root.get(Orders_.orderDate).as(LocalDate.class),maxOrderDate);
//        };
//    }
}
