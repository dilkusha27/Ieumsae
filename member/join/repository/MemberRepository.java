package com.ieumsae.project.member.join.repository;

import com.ieumsae.project.member.join.model.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberModel, Long> {
    Optional<MemberModel> findByUserId(String userId);
}
