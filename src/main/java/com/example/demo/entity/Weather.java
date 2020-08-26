package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weatherSeq;

    @Column(length = 20, nullable = false)
    private String weatherNo;

    @Column(length = 500, nullable = false)
    private String dday;

    @Column(length = 500, nullable = false)
    private String mimg;

    @Column(length = 500, nullable = false)
    private String aimg;

    @Column(length = 500, nullable = false)
    private String mrr;

    @Column(length = 500, nullable = false)
    private String arr;

    @Column(length = 500, nullable = false)
    private String temp;

    @Builder
    public Weather(String weatherNo, String dday, String mimg, String aimg, String mrr, String arr,String temp) {
        this.weatherNo = weatherNo;
        this.dday = dday;
        this.mimg = mimg;
        this.aimg = aimg;
        this.mrr = mrr;
        this.arr = arr;
        this.temp = temp;
    }
}