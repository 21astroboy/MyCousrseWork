package com.example.demo.Entity;

import javax.persistence.*;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer customer_id;
    @Column
    private String tr_datetime;
    @Column
    private Integer mcc_code;
    @Column
    private Integer tr_type;
    @Column
    private Integer amount;
    @Column
    private Integer term_id;

    public Transactions() {
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getTr_datetime() {
        return tr_datetime;
    }

    public void setTr_datetime(String tr_datetime) {
        this.tr_datetime = tr_datetime;
    }

    public int getMcc_code() {
        return mcc_code;
    }

    public void setMcc_code(int mcc_code) {
        this.mcc_code = mcc_code;
    }

    public int getTr_type() {
        return tr_type;
    }

    public void setTr_type(int tr_type) {
        this.tr_type = tr_type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTerm_id() {
        return term_id;
    }

    public void setTerm_id(int term_id) {
        this.term_id = term_id;
    }

    public Transactions(String tr_datetime, int mcc_code, int tr_type, int amount, int term_id) {

        this.tr_datetime = tr_datetime;
        this.mcc_code = mcc_code;
        this.tr_type = tr_type;
        this.amount = amount;
        this.term_id = term_id;
    }
}
