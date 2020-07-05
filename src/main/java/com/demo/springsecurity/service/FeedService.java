package com.demo.springsecurity.service;

import com.demo.springsecurity.domainobject.FeedDO;
import com.demo.springsecurity.dto.CreateFeedRequest;

import java.util.List;

public interface FeedService {

    FeedDO getFeedForUser(String userId);

    FeedDO createFeed(CreateFeedRequest createFeedRequest);

    List<FeedDO> getAllFeeds();
}
