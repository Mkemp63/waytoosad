package main.java.nl.hu.v2tosad.model;

import java.util.Date;

public class Businessrule {
    private int id;
    private String code;
    private String ruleName;
    private String businessruleType;
    private String discription;
    private String tablename;
    private String status;
    private Date   dateModified;

    public Businessrule(int id, String code, String ruleName, String businessruleType, String discription, String tablename, String status, Date dateModified) {
        this.id = id;
        this.code = code;
        this.ruleName = ruleName;
        this.businessruleType = businessruleType;
        this.discription = discription;
        this.tablename = tablename;
        this.status = status;
        this.dateModified = dateModified;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getBusinessruleType() {
        return businessruleType;
    }

    public String getDiscription() {
        return discription;
    }

    public String getTablename() {
        return tablename;
    }

    public String getStatus() {
        return status;
    }

    public Date getDateModified() {
        return dateModified;
    }

    @Override
    public String toString() {
        return "Businessrule{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", businessruleType='" + businessruleType + '\'' +
                ", discription='" + discription + '\'' +
                ", tablename='" + tablename + '\'' +
                ", status='" + status + '\'' +
                ", dateModified=" + dateModified +
                '}';
    }
}
