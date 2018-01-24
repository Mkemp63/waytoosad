package main.java.nl.hu.v2tosad.model;


import java.sql.Date;

public class Businessrule {
    private int id;
    private String code;
    private String rulename;
    private String businessruleType;
    private String discription;
    private String tablename;
    private String status;
    private String dateModified;

    public Businessrule(int id, String code, String rulename, String businessruleType, String discription, String tablename, String status, String dateModified) {
        this.id = id;
        this.code = code;
        this.rulename = rulename;
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

    public String getRulename() {return rulename; }

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

    public String getDateModified() {
        return dateModified;
    }

    @Override
    public String toString() {
        return "Businessrule{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", ruleName='" + rulename + '\'' +
                ", businessruleType='" + businessruleType + '\'' +
                ", discription='" + discription + '\'' +
                ", tablename='" + tablename + '\'' +
                ", status='" + status + '\'' +
                ", dateModified=" + dateModified +
                '}';
    }
}
