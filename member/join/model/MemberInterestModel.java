package com.ieumsae.project.member.join.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "member_interest_part")
@Getter
@Setter
public class MemberInterestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx")
    private Long userIdx;

    @Column(name = "user_sub_1")
    private int userInterest1; // 관심분야1

    @Column(name = "user_sub_2")
    private int userInterest2; // 관심분야2

    @Column(name = "user_region_1")
    private int userRegion1; // 관심지역1

    @Column(name = "user_region_2")
    private int userRegion2; // 관심지역2

    // Getter, Setter methods

}