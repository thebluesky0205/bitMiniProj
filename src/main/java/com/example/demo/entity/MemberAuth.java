package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "member_auth")
public class MemberAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAuthNo;

    @Column(name = "user_no")
    private Long userNo;

    @Column(length = 50)
    private String auth;

    @JsonFormat(pattern = "yyyy-MM-DD HH:mm")
    @CreationTimestamp
    private Date regDate;

    @JsonFormat(pattern = "yyyy-MM-DD HH:mm")
    @CreationTimestamp
    private Date upDate;

    @Column(length = 100, nullable = false)
    private String userName;
}
