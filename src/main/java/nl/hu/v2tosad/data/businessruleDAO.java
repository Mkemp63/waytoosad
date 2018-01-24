package main.java.nl.hu.v2tosad.data;

import nl.hu.v2tosad.model.Businessrule;

import java.util.ArrayList;

public interface businessruleDAO {
    ArrayList<Businessrule> getAllBusinessrules();
    ArrayList<Businessrule> getBusinessrulesByID(ArrayList<Integer> idList);
    void setStatus(Businessrule rule, String status);
}
