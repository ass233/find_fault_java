package com.zjjw.zjjwserver.po;

import java.util.Date;

public class Interview {
    private Long id;

    private Long companyId;

    private Long positionId;

    private Long userId;

    private Integer statue;

    private Long resumeId;

    private Integer resumeShare;

    private String interviewExperience;

    private String companyCondition;

    private Integer salary;

    private Integer interviewNum;

    private Integer entryIntention;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public Long getResumeId() {
        return resumeId;
    }

    public void setResumeId(Long resumeId) {
        this.resumeId = resumeId;
    }

    public Integer getResumeShare() {
        return resumeShare;
    }

    public void setResumeShare(Integer resumeShare) {
        this.resumeShare = resumeShare;
    }

    public String getInterviewExperience() {
        return interviewExperience;
    }

    public void setInterviewExperience(String interviewExperience) {
        this.interviewExperience = interviewExperience == null ? null : interviewExperience.trim();
    }

    public String getCompanyCondition() {
        return companyCondition;
    }

    public void setCompanyCondition(String companyCondition) {
        this.companyCondition = companyCondition == null ? null : companyCondition.trim();
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getInterviewNum() {
        return interviewNum;
    }

    public void setInterviewNum(Integer interviewNum) {
        this.interviewNum = interviewNum;
    }

    public Integer getEntryIntention() {
        return entryIntention;
    }

    public void setEntryIntention(Integer entryIntention) {
        this.entryIntention = entryIntention;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}