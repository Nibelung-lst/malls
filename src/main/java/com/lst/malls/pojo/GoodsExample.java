package com.lst.malls.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andoriginal_priceIsNull() {
            addCriterion(" original_price is null");
            return (Criteria) this;
        }

        public Criteria andoriginal_priceIsNotNull() {
            addCriterion("original_price is not null");
            return (Criteria) this;
        }

        public Criteria andoriginal_priceEqualTo(BigDecimal value) {
            addCriterion("original_price =", value, "original_price");
            return (Criteria) this;
        }

        public Criteria andoriginal_priceNotEqualTo(BigDecimal value) {
            addCriterion("original_price <>", value, "original_price");
            return (Criteria) this;
        }

        public Criteria andoriginal_priceGreaterThan(BigDecimal value) {
            addCriterion("original_price >", value, " original_price");
            return (Criteria) this;
        }

        public Criteria andoriginal_priceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price >=", value, "original_price");
            return (Criteria) this;
        }

        public Criteria andoriginal_priceLessThan(BigDecimal value) {
            addCriterion("original_price <", value, "original_price");
            return (Criteria) this;
        }

        public Criteria andoriginal_priceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price <=", value, "original_price");
            return (Criteria) this;
        }

        public Criteria andoriginal_priceIn(List<BigDecimal> values) {
            addCriterion(" original_price in", values, " original_price");
            return (Criteria) this;
        }

        public Criteria andoriginal_priceNotIn(List<BigDecimal> values) {
            addCriterion("original_price not in", values, " original_price");
            return (Criteria) this;
        }

        public Criteria andoriginal_priceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price between", value1, value2, " original_price");
            return (Criteria) this;
        }

        public Criteria andoriginal_priceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion(" original_price not between", value1, value2, " original_price");
            return (Criteria) this;
        }

        public Criteria andReal_priceIsNull() {
            addCriterion("real_price is null");
            return (Criteria) this;
        }

        public Criteria andReal_priceIsNotNull() {
            addCriterion("real_price is not null");
            return (Criteria) this;
        }

        public Criteria andReal_priceEqualTo(BigDecimal value) {
            addCriterion("real_price =", value, "real_price");
            return (Criteria) this;
        }

        public Criteria andReal_priceNotEqualTo(BigDecimal value) {
            addCriterion("real_price <>", value, "real_price");
            return (Criteria) this;
        }

        public Criteria andReal_priceGreaterThan(BigDecimal value) {
            addCriterion("real_price >", value, "real_price");
            return (Criteria) this;
        }

        public Criteria andReal_priceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_price >=", value, "real_price");
            return (Criteria) this;
        }

        public Criteria andReal_priceLessThan(BigDecimal value) {
            addCriterion("real_price <", value, "real_price");
            return (Criteria) this;
        }

        public Criteria andReal_priceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_price <=", value, "real_price");
            return (Criteria) this;
        }

        public Criteria andReal_priceIn(List<BigDecimal> values) {
            addCriterion("real_price in", values, "real_price");
            return (Criteria) this;
        }

        public Criteria andReal_priceNotIn(List<BigDecimal> values) {
            addCriterion("real_price not in", values, "real_price");
            return (Criteria) this;
        }

        public Criteria andReal_priceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_price between", value1, value2, "real_price");
            return (Criteria) this;
        }

        public Criteria andReal_priceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_price not between", value1, value2, "real_price");
            return (Criteria) this;
        }

        public Criteria andRepresentIsNull() {
            addCriterion("represent is null");
            return (Criteria) this;
        }

        public Criteria andRepresentIsNotNull() {
            addCriterion("represent is not null");
            return (Criteria) this;
        }

        public Criteria andRepresentEqualTo(String value) {
            addCriterion("represent =", value, "represent");
            return (Criteria) this;
        }

        public Criteria andRepresentNotEqualTo(String value) {
            addCriterion("represent <>", value, "represent");
            return (Criteria) this;
        }

        public Criteria andRepresentGreaterThan(String value) {
            addCriterion("represent >", value, "represent");
            return (Criteria) this;
        }

        public Criteria andRepresentGreaterThanOrEqualTo(String value) {
            addCriterion("represent >=", value, "represent");
            return (Criteria) this;
        }

        public Criteria andRepresentLessThan(String value) {
            addCriterion("represent <", value, "represent");
            return (Criteria) this;
        }

        public Criteria andRepresentLessThanOrEqualTo(String value) {
            addCriterion("represent <=", value, "represent");
            return (Criteria) this;
        }

        public Criteria andRepresentLike(String value) {
            addCriterion("represent like", value, "represent");
            return (Criteria) this;
        }

        public Criteria andRepresentNotLike(String value) {
            addCriterion("represent not like", value, "represent");
            return (Criteria) this;
        }

        public Criteria andRepresentIn(List<String> values) {
            addCriterion("represent in", values, "represent");
            return (Criteria) this;
        }

        public Criteria andRepresentNotIn(List<String> values) {
            addCriterion("represent not in", values, "represent");
            return (Criteria) this;
        }

        public Criteria andRepresentBetween(String value1, String value2) {
            addCriterion("represent between", value1, value2, "represent");
            return (Criteria) this;
        }

        public Criteria andRepresentNotBetween(String value1, String value2) {
            addCriterion("represent not between", value1, value2, "represent");
            return (Criteria) this;
        }

        public Criteria andCategory_nameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategory_nameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategory_nameEqualTo(String value) {
            addCriterion("category_name =", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameGreaterThan(String value) {
            addCriterion("category_name >", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameLessThan(String value) {
            addCriterion("category_name <", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameLike(String value) {
            addCriterion("category_name like", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameNotLike(String value) {
            addCriterion("category_name not like", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameIn(List<String> values) {
            addCriterion("category_name in", values, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "category_name");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreate_dateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreate_dateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_dateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "create_date");
            return (Criteria) this;
        }

        public Criteria andFinal_changerIsNull() {
            addCriterion("final_changer is null");
            return (Criteria) this;
        }

        public Criteria andFinal_changerIsNotNull() {
            addCriterion("final_changer is not null");
            return (Criteria) this;
        }

        public Criteria andFinal_changerEqualTo(String value) {
            addCriterion("final_changer =", value, "final_changer");
            return (Criteria) this;
        }

        public Criteria andFinal_changerNotEqualTo(String value) {
            addCriterion("final_changer <>", value, "final_changer");
            return (Criteria) this;
        }

        public Criteria andFinal_changerGreaterThan(String value) {
            addCriterion("final_changer >", value, "final_changer");
            return (Criteria) this;
        }

        public Criteria andFinal_changerGreaterThanOrEqualTo(String value) {
            addCriterion("final_changer >=", value, "final_changer");
            return (Criteria) this;
        }

        public Criteria andFinal_changerLessThan(String value) {
            addCriterion("final_changer <", value, "final_changer");
            return (Criteria) this;
        }

        public Criteria andFinal_changerLessThanOrEqualTo(String value) {
            addCriterion("final_changer <=", value, "final_changer");
            return (Criteria) this;
        }

        public Criteria andFinal_changerLike(String value) {
            addCriterion("final_changer like", value, "final_changer");
            return (Criteria) this;
        }

        public Criteria andFinal_changerNotLike(String value) {
            addCriterion("final_changer not like", value, "final_changer");
            return (Criteria) this;
        }

        public Criteria andFinal_changerIn(List<String> values) {
            addCriterion("final_changer in", values, "final_changer");
            return (Criteria) this;
        }

        public Criteria andFinal_changerNotIn(List<String> values) {
            addCriterion("final_changer not in", values, "final_changer");
            return (Criteria) this;
        }

        public Criteria andFinal_changerBetween(String value1, String value2) {
            addCriterion("final_changer between", value1, value2, "final_changer");
            return (Criteria) this;
        }

        public Criteria andFinal_changerNotBetween(String value1, String value2) {
            addCriterion("final_changer not between", value1, value2, "final_changer");
            return (Criteria) this;
        }

        public Criteria andFinal_change_timeIsNull() {
            addCriterion("final_change_time is null");
            return (Criteria) this;
        }

        public Criteria andFinal_change_timeIsNotNull() {
            addCriterion("final_change_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinal_change_timeEqualTo(Date value) {
            addCriterionForJDBCDate("final_change_time =", value, "final_change_time");
            return (Criteria) this;
        }

        public Criteria andFinal_change_timeNotEqualTo(Date value) {
            addCriterionForJDBCDate("final_change_time <>", value, "final_change_time");
            return (Criteria) this;
        }

        public Criteria andFinal_change_timeGreaterThan(Date value) {
            addCriterionForJDBCDate("final_change_time >", value, "final_change_time");
            return (Criteria) this;
        }

        public Criteria andFinal_change_timeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("final_change_time >=", value, "final_change_time");
            return (Criteria) this;
        }

        public Criteria andFinal_change_timeLessThan(Date value) {
            addCriterionForJDBCDate("final_change_time <", value, "final_change_time");
            return (Criteria) this;
        }

        public Criteria andFinal_change_timeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("final_change_time <=", value, "final_change_time");
            return (Criteria) this;
        }

        public Criteria andFinal_change_timeIn(List<Date> values) {
            addCriterionForJDBCDate("final_change_time in", values, "final_change_time");
            return (Criteria) this;
        }

        public Criteria andFinal_change_timeNotIn(List<Date> values) {
            addCriterionForJDBCDate("final_change_time not in", values, "final_change_time");
            return (Criteria) this;
        }

        public Criteria andFinal_change_timeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("final_change_time between", value1, value2, "final_change_time");
            return (Criteria) this;
        }

        public Criteria andFinal_change_timeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("final_change_time not between", value1, value2, "final_change_time");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}