package com.ieumsae.project.member.join.repository;

import com.ieumsae.project.member.join.model.MemberInterestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberInterestRepository extends JpaRepository<MemberInterestModel, Long> {

}
