package com.purchase.pojo.admin;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class TbProjectManger {
    private String id;

    private String projectNo;

    private BigDecimal contractPrice;

    private Integer settleType;

    private String name;

    private String shortName;

    private Integer source;

    private Integer nature;

    private Integer progressPlan;

    private Long projectManager;

    private Long budgetLeader;

    private String developer;

    private String developerLeaderName;

    private String developerLeaderPhone;

    private String consignor;

    private String consignorLeaderName;

    private String consignorLeaderPhone;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date contractSignDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date overDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date acceptanceDate;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }

    public Integer getSettleType() {
        return settleType;
    }

    public void setSettleType(Integer settleType) {
        this.settleType = settleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public Integer getProgressPlan() {
        return progressPlan;
    }

    public void setProgressPlan(Integer progressPlan) {
        this.progressPlan = progressPlan;
    }

    public Long getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Long projectManager) {
        this.projectManager = projectManager;
    }

    public Long getBudgetLeader() {
        return budgetLeader;
    }

    public void setBudgetLeader(Long budgetLeader) {
        this.budgetLeader = budgetLeader;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer == null ? null : developer.trim();
    }

    public String getDeveloperLeaderName() {
        return developerLeaderName;
    }

    public void setDeveloperLeaderName(String developerLeaderName) {
        this.developerLeaderName = developerLeaderName == null ? null : developerLeaderName.trim();
    }

    public String getDeveloperLeaderPhone() {
        return developerLeaderPhone;
    }

    public void setDeveloperLeaderPhone(String developerLeaderPhone) {
        this.developerLeaderPhone = developerLeaderPhone == null ? null : developerLeaderPhone.trim();
    }

    public String getConsignor() {
        return consignor;
    }

    public void setConsignor(String consignor) {
        this.consignor = consignor == null ? null : consignor.trim();
    }

    public String getConsignorLeaderName() {
        return consignorLeaderName;
    }

    public void setConsignorLeaderName(String consignorLeaderName) {
        this.consignorLeaderName = consignorLeaderName == null ? null : consignorLeaderName.trim();
    }

    public String getConsignorLeaderPhone() {
        return consignorLeaderPhone;
    }

    public void setConsignorLeaderPhone(String consignorLeaderPhone) {
        this.consignorLeaderPhone = consignorLeaderPhone == null ? null : consignorLeaderPhone.trim();
    }

    public Date getContractSignDate() {
        return contractSignDate;
    }

    public void setContractSignDate(Date contractSignDate) {
        this.contractSignDate = contractSignDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getOverDate() {
        return overDate;
    }

    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }

    public Date getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(Date acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}