package com.siva.standup.userInfo.data;

import com.siva.standup.userInfo.model.AccountProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountProfileRepository extends JpaRepository<AccountProfile, Long> {
    AccountProfile findProfileByUserName(String UserName);
}
