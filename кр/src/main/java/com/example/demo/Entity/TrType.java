package com.example.demo.Entity;


import javax.persistence.*;


@Entity
@Table(name = "tr_types")
public class TrType {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  trType;

    @Column(name = "tr_description")
    private String trDescription;

    public int getTrType() {
        return trType;
    }

    public void setTrType(int trType) {
        this.trType = trType;
    }

    public String getTrDescription() {
        return trDescription;
    }

    public void setTrDescription(String tr_description) {
        this.trDescription = trDescription;
    }


}
