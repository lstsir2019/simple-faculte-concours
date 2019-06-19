/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author BOSS
 */
public class SearchUtil {

    public static Date convert(String date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.parse(date);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static java.sql.Date convert(java.util.Date date) {
        if (date != null) {
            return new java.sql.Date(date.getTime());
        } else {
            return null;
        }
    }
    
//    public static String addConstraint2(String beanAbrev, String atributeName, String operator, Object value){
//        
//        
//    }

    public static String addConstraint(String beanAbrev, String atributeName, String operator, Object value) {
        boolean condition = value != null;
        if (value != null && value.getClass().getSimpleName().equals("String")) {
            condition = condition && !value.equals("");
        }
        if (condition && operator.equals("LIKE")) {
            return " AND " + beanAbrev + "." + atributeName + " " + operator + " '%" + value + "%'";
        } else if (condition) {
            return " AND " + beanAbrev + "." + atributeName + " " + operator + " '" + value + "'";
        }

        return "";
    }

    public static String addConstraintOr(String beanAbrev, String atributeName, String operator, Object value) {
        boolean condition = value != null;
        if (value != null && value.getClass().getSimpleName().equals("String")) {
            condition = condition && !value.equals("");
        }
        if (condition) {
            return " OR " + beanAbrev + "." + atributeName + " " + operator + " '" + value + "'";
        }
        return "";
    }

    public static String addConstraintMinMax(String beanAbrev, String atributeName, Object valueMin, Object valueMax) {
        String requette = "";
        if (valueMin != null) {
            requette += " AND " + beanAbrev + "." + atributeName + " >= '" + valueMin + "'";
        }
        if (valueMax != null) {
            requette += " AND " + beanAbrev + "." + atributeName + " <= '" + valueMax + "'";
        }
        return requette;
    }

    public static String addConstraintDate(String beanAbrev, String atributeName, String operator, Date value) {
        return addConstraint(beanAbrev, atributeName, operator, convert(value));
    }

    public static String addConstraintMinMaxDate(String beanAbrev, String atributeName, Date valueMin, Date valueMax) {
        return addConstraintMinMax(beanAbrev, atributeName, convert(valueMin), convert(valueMax));
    }

    public static String supprimerCleEtranger(String beanAbrev, String atributeName, String condition, Object value) {
        String requet = "";
        if (value != null) {
            requet = "UPDATE " + beanAbrev + " SET " + atributeName + " = NULL WHERE " + condition + " = " + value;
        }
        return requet;
    }

    public static String isTaxPaid(String abreviationAnnuel, String beanTrim, String abreviationNumTrim, int annee, int trim) {
        String requet = "";
        if (!abreviationAnnuel.equals("") && !beanTrim.equals("") && !abreviationNumTrim.equals("")) {
            requet = "SELECT item FROM " + beanTrim + " item WHERE item." + abreviationAnnuel + ".annee=" + annee + " AND item." + abreviationNumTrim + "=" + trim;
        }
        return requet;
    }

    // méthode pour ajouter une liste des contraintes dans une requete
    public static String findByAllString(String abreviationBean, List<String> attributes, List<String> data) {
        String requete = "";
        if (!abreviationBean.equals("") && !attributes.isEmpty() && attributes.size() == data.size()) {
            for (int i = 0; i < attributes.size(); i++) {
                requete += addConstraint(abreviationBean, attributes.get(i), "=", data.get(i));
            }
        }
        return requete;
    }

}
