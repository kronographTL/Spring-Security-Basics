package com.demo.springsecurity.dao;

import com.demo.springsecurity.domainobject.FeedDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends JpaRepository<FeedDO,String> {

    FeedDO findByUser(String userId);
}
