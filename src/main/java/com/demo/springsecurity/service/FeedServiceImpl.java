package com.demo.springsecurity.service;

import com.demo.springsecurity.dao.FeedRepository;
import com.demo.springsecurity.domainobject.FeedDO;
import com.demo.springsecurity.dto.CreateFeedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedServiceImpl implements FeedService{

    @Autowired
    FeedRepository feedRepository;
    @Override
    public FeedDO getFeedForUser(String userId) {
        return feedRepository.findByUser(userId);
    }

    @Override
    public FeedDO createFeed(CreateFeedRequest createFeedRequest) {
        FeedDO feedDO = FeedDO.builder().title(createFeedRequest.getTitle())
                .body(createFeedRequest.getBody())
                .build();
        return feedRepository.save(feedDO);
    }

    @Override
    public List<FeedDO> getAllFeeds() {
        FeedDO feedDO = FeedDO.builder().title("My Feed")
                .body("My Feed Body")
                .user("ADMIN")
                .build();
        List<FeedDO> feedDOs = new ArrayList<>();
        feedDOs.add(feedDO);
        return feedDOs;//feedRepository.findAll();
    }
}
