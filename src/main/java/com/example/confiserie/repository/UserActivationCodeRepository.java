package com.example.confiserie.repository;

import com.example.confiserie.model.entity.UserActivationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivationCodeRepository extends JpaRepository<UserActivationCode, Long> {
}
