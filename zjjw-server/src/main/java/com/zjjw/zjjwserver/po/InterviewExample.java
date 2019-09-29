package com.zjjw.zjjwserver.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InterviewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InterviewExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Long value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Long value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Long value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Long value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Long value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Long> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Long> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Long value1, Long value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Long value1, Long value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNull() {
            addCriterion("position_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("position_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(Long value) {
            addCriterion("position_id =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(Long value) {
            addCriterion("position_id <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(Long value) {
            addCriterion("position_id >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("position_id >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(Long value) {
            addCriterion("position_id <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(Long value) {
            addCriterion("position_id <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<Long> values) {
            addCriterion("position_id in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<Long> values) {
            addCriterion("position_id not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(Long value1, Long value2) {
            addCriterion("position_id between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(Long value1, Long value2) {
            addCriterion("position_id not between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andStatueIsNull() {
            addCriterion("statue is null");
            return (Criteria) this;
        }

        public Criteria andStatueIsNotNull() {
            addCriterion("statue is not null");
            return (Criteria) this;
        }

        public Criteria andStatueEqualTo(Integer value) {
            addCriterion("statue =", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueNotEqualTo(Integer value) {
            addCriterion("statue <>", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueGreaterThan(Integer value) {
            addCriterion("statue >", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueGreaterThanOrEqualTo(Integer value) {
            addCriterion("statue >=", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueLessThan(Integer value) {
            addCriterion("statue <", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueLessThanOrEqualTo(Integer value) {
            addCriterion("statue <=", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueIn(List<Integer> values) {
            addCriterion("statue in", values, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueNotIn(List<Integer> values) {
            addCriterion("statue not in", values, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueBetween(Integer value1, Integer value2) {
            addCriterion("statue between", value1, value2, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueNotBetween(Integer value1, Integer value2) {
            addCriterion("statue not between", value1, value2, "statue");
            return (Criteria) this;
        }

        public Criteria andResumeIdIsNull() {
            addCriterion("resume_id is null");
            return (Criteria) this;
        }

        public Criteria andResumeIdIsNotNull() {
            addCriterion("resume_id is not null");
            return (Criteria) this;
        }

        public Criteria andResumeIdEqualTo(Long value) {
            addCriterion("resume_id =", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotEqualTo(Long value) {
            addCriterion("resume_id <>", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdGreaterThan(Long value) {
            addCriterion("resume_id >", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("resume_id >=", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLessThan(Long value) {
            addCriterion("resume_id <", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLessThanOrEqualTo(Long value) {
            addCriterion("resume_id <=", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdIn(List<Long> values) {
            addCriterion("resume_id in", values, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotIn(List<Long> values) {
            addCriterion("resume_id not in", values, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdBetween(Long value1, Long value2) {
            addCriterion("resume_id between", value1, value2, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotBetween(Long value1, Long value2) {
            addCriterion("resume_id not between", value1, value2, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeShareIsNull() {
            addCriterion("resume_share is null");
            return (Criteria) this;
        }

        public Criteria andResumeShareIsNotNull() {
            addCriterion("resume_share is not null");
            return (Criteria) this;
        }

        public Criteria andResumeShareEqualTo(Integer value) {
            addCriterion("resume_share =", value, "resumeShare");
            return (Criteria) this;
        }

        public Criteria andResumeShareNotEqualTo(Integer value) {
            addCriterion("resume_share <>", value, "resumeShare");
            return (Criteria) this;
        }

        public Criteria andResumeShareGreaterThan(Integer value) {
            addCriterion("resume_share >", value, "resumeShare");
            return (Criteria) this;
        }

        public Criteria andResumeShareGreaterThanOrEqualTo(Integer value) {
            addCriterion("resume_share >=", value, "resumeShare");
            return (Criteria) this;
        }

        public Criteria andResumeShareLessThan(Integer value) {
            addCriterion("resume_share <", value, "resumeShare");
            return (Criteria) this;
        }

        public Criteria andResumeShareLessThanOrEqualTo(Integer value) {
            addCriterion("resume_share <=", value, "resumeShare");
            return (Criteria) this;
        }

        public Criteria andResumeShareIn(List<Integer> values) {
            addCriterion("resume_share in", values, "resumeShare");
            return (Criteria) this;
        }

        public Criteria andResumeShareNotIn(List<Integer> values) {
            addCriterion("resume_share not in", values, "resumeShare");
            return (Criteria) this;
        }

        public Criteria andResumeShareBetween(Integer value1, Integer value2) {
            addCriterion("resume_share between", value1, value2, "resumeShare");
            return (Criteria) this;
        }

        public Criteria andResumeShareNotBetween(Integer value1, Integer value2) {
            addCriterion("resume_share not between", value1, value2, "resumeShare");
            return (Criteria) this;
        }

        public Criteria andInterviewExperienceIsNull() {
            addCriterion("interview_experience is null");
            return (Criteria) this;
        }

        public Criteria andInterviewExperienceIsNotNull() {
            addCriterion("interview_experience is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewExperienceEqualTo(String value) {
            addCriterion("interview_experience =", value, "interviewExperience");
            return (Criteria) this;
        }

        public Criteria andInterviewExperienceNotEqualTo(String value) {
            addCriterion("interview_experience <>", value, "interviewExperience");
            return (Criteria) this;
        }

        public Criteria andInterviewExperienceGreaterThan(String value) {
            addCriterion("interview_experience >", value, "interviewExperience");
            return (Criteria) this;
        }

        public Criteria andInterviewExperienceGreaterThanOrEqualTo(String value) {
            addCriterion("interview_experience >=", value, "interviewExperience");
            return (Criteria) this;
        }

        public Criteria andInterviewExperienceLessThan(String value) {
            addCriterion("interview_experience <", value, "interviewExperience");
            return (Criteria) this;
        }

        public Criteria andInterviewExperienceLessThanOrEqualTo(String value) {
            addCriterion("interview_experience <=", value, "interviewExperience");
            return (Criteria) this;
        }

        public Criteria andInterviewExperienceLike(String value) {
            addCriterion("interview_experience like", value, "interviewExperience");
            return (Criteria) this;
        }

        public Criteria andInterviewExperienceNotLike(String value) {
            addCriterion("interview_experience not like", value, "interviewExperience");
            return (Criteria) this;
        }

        public Criteria andInterviewExperienceIn(List<String> values) {
            addCriterion("interview_experience in", values, "interviewExperience");
            return (Criteria) this;
        }

        public Criteria andInterviewExperienceNotIn(List<String> values) {
            addCriterion("interview_experience not in", values, "interviewExperience");
            return (Criteria) this;
        }

        public Criteria andInterviewExperienceBetween(String value1, String value2) {
            addCriterion("interview_experience between", value1, value2, "interviewExperience");
            return (Criteria) this;
        }

        public Criteria andInterviewExperienceNotBetween(String value1, String value2) {
            addCriterion("interview_experience not between", value1, value2, "interviewExperience");
            return (Criteria) this;
        }

        public Criteria andCompanyConditionIsNull() {
            addCriterion("company_condition is null");
            return (Criteria) this;
        }

        public Criteria andCompanyConditionIsNotNull() {
            addCriterion("company_condition is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyConditionEqualTo(String value) {
            addCriterion("company_condition =", value, "companyCondition");
            return (Criteria) this;
        }

        public Criteria andCompanyConditionNotEqualTo(String value) {
            addCriterion("company_condition <>", value, "companyCondition");
            return (Criteria) this;
        }

        public Criteria andCompanyConditionGreaterThan(String value) {
            addCriterion("company_condition >", value, "companyCondition");
            return (Criteria) this;
        }

        public Criteria andCompanyConditionGreaterThanOrEqualTo(String value) {
            addCriterion("company_condition >=", value, "companyCondition");
            return (Criteria) this;
        }

        public Criteria andCompanyConditionLessThan(String value) {
            addCriterion("company_condition <", value, "companyCondition");
            return (Criteria) this;
        }

        public Criteria andCompanyConditionLessThanOrEqualTo(String value) {
            addCriterion("company_condition <=", value, "companyCondition");
            return (Criteria) this;
        }

        public Criteria andCompanyConditionLike(String value) {
            addCriterion("company_condition like", value, "companyCondition");
            return (Criteria) this;
        }

        public Criteria andCompanyConditionNotLike(String value) {
            addCriterion("company_condition not like", value, "companyCondition");
            return (Criteria) this;
        }

        public Criteria andCompanyConditionIn(List<String> values) {
            addCriterion("company_condition in", values, "companyCondition");
            return (Criteria) this;
        }

        public Criteria andCompanyConditionNotIn(List<String> values) {
            addCriterion("company_condition not in", values, "companyCondition");
            return (Criteria) this;
        }

        public Criteria andCompanyConditionBetween(String value1, String value2) {
            addCriterion("company_condition between", value1, value2, "companyCondition");
            return (Criteria) this;
        }

        public Criteria andCompanyConditionNotBetween(String value1, String value2) {
            addCriterion("company_condition not between", value1, value2, "companyCondition");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("salary is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("salary is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(Integer value) {
            addCriterion("salary =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(Integer value) {
            addCriterion("salary <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(Integer value) {
            addCriterion("salary >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("salary >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(Integer value) {
            addCriterion("salary <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(Integer value) {
            addCriterion("salary <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<Integer> values) {
            addCriterion("salary in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<Integer> values) {
            addCriterion("salary not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(Integer value1, Integer value2) {
            addCriterion("salary between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("salary not between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andInterviewNumIsNull() {
            addCriterion("interview_num is null");
            return (Criteria) this;
        }

        public Criteria andInterviewNumIsNotNull() {
            addCriterion("interview_num is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewNumEqualTo(Integer value) {
            addCriterion("interview_num =", value, "interviewNum");
            return (Criteria) this;
        }

        public Criteria andInterviewNumNotEqualTo(Integer value) {
            addCriterion("interview_num <>", value, "interviewNum");
            return (Criteria) this;
        }

        public Criteria andInterviewNumGreaterThan(Integer value) {
            addCriterion("interview_num >", value, "interviewNum");
            return (Criteria) this;
        }

        public Criteria andInterviewNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("interview_num >=", value, "interviewNum");
            return (Criteria) this;
        }

        public Criteria andInterviewNumLessThan(Integer value) {
            addCriterion("interview_num <", value, "interviewNum");
            return (Criteria) this;
        }

        public Criteria andInterviewNumLessThanOrEqualTo(Integer value) {
            addCriterion("interview_num <=", value, "interviewNum");
            return (Criteria) this;
        }

        public Criteria andInterviewNumIn(List<Integer> values) {
            addCriterion("interview_num in", values, "interviewNum");
            return (Criteria) this;
        }

        public Criteria andInterviewNumNotIn(List<Integer> values) {
            addCriterion("interview_num not in", values, "interviewNum");
            return (Criteria) this;
        }

        public Criteria andInterviewNumBetween(Integer value1, Integer value2) {
            addCriterion("interview_num between", value1, value2, "interviewNum");
            return (Criteria) this;
        }

        public Criteria andInterviewNumNotBetween(Integer value1, Integer value2) {
            addCriterion("interview_num not between", value1, value2, "interviewNum");
            return (Criteria) this;
        }

        public Criteria andEntryIntentionIsNull() {
            addCriterion("entry_intention is null");
            return (Criteria) this;
        }

        public Criteria andEntryIntentionIsNotNull() {
            addCriterion("entry_intention is not null");
            return (Criteria) this;
        }

        public Criteria andEntryIntentionEqualTo(Integer value) {
            addCriterion("entry_intention =", value, "entryIntention");
            return (Criteria) this;
        }

        public Criteria andEntryIntentionNotEqualTo(Integer value) {
            addCriterion("entry_intention <>", value, "entryIntention");
            return (Criteria) this;
        }

        public Criteria andEntryIntentionGreaterThan(Integer value) {
            addCriterion("entry_intention >", value, "entryIntention");
            return (Criteria) this;
        }

        public Criteria andEntryIntentionGreaterThanOrEqualTo(Integer value) {
            addCriterion("entry_intention >=", value, "entryIntention");
            return (Criteria) this;
        }

        public Criteria andEntryIntentionLessThan(Integer value) {
            addCriterion("entry_intention <", value, "entryIntention");
            return (Criteria) this;
        }

        public Criteria andEntryIntentionLessThanOrEqualTo(Integer value) {
            addCriterion("entry_intention <=", value, "entryIntention");
            return (Criteria) this;
        }

        public Criteria andEntryIntentionIn(List<Integer> values) {
            addCriterion("entry_intention in", values, "entryIntention");
            return (Criteria) this;
        }

        public Criteria andEntryIntentionNotIn(List<Integer> values) {
            addCriterion("entry_intention not in", values, "entryIntention");
            return (Criteria) this;
        }

        public Criteria andEntryIntentionBetween(Integer value1, Integer value2) {
            addCriterion("entry_intention between", value1, value2, "entryIntention");
            return (Criteria) this;
        }

        public Criteria andEntryIntentionNotBetween(Integer value1, Integer value2) {
            addCriterion("entry_intention not between", value1, value2, "entryIntention");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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