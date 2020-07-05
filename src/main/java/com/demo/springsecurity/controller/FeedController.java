package com.demo.springsecurity.controller;

import com.demo.springsecurity.domainobject.FeedDO;
import com.demo.springsecurity.dto.CreateFeedRequest;
import com.demo.springsecurity.dto.FeedDTO;
import com.demo.springsecurity.mapper.FeedMapper;
import com.demo.springsecurity.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/feed")
public class FeedController {

    @Autowired
    FeedService feedService;

    @GetMapping("/{id}")
    ResponseEntity<FeedDTO> getFeedForUser(String userId){
        FeedDO feedDO = feedService.getFeedForUser(userId);
        return new ResponseEntity<>(FeedMapper.convertToFeedDTO(feedDO), HttpStatus.OK);
    }
    @GetMapping()
    ResponseEntity<List<FeedDTO>> getAllFeeds(){
        List<FeedDO> feedDOs = feedService.getAllFeeds();
        return new ResponseEntity<>(FeedMapper.convertToFeedDTOs(feedDOs),HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<FeedDTO> createFeed(CreateFeedRequest createFeedRequest){
        FeedDO feedDO = feedService.createFeed(createFeedRequest);
        return new ResponseEntity<>(FeedMapper.convertToFeedDTO(feedDO),HttpStatus.CREATED);
    }
}
