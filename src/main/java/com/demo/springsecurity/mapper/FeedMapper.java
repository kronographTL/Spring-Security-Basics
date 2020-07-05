package com.demo.springsecurity.mapper;

import com.demo.springsecurity.domainobject.FeedDO;
import com.demo.springsecurity.dto.FeedDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FeedMapper {

    public static FeedDTO convertToFeedDTO(FeedDO feedDO) {
        return FeedDTO.builder().title(feedDO.getTitle())
                .body(feedDO.getBody())
                .build();
    }

    public static List<FeedDTO> convertToFeedDTOs(List<FeedDO> feedDOs) {
        return feedDOs.stream().map(FeedMapper::convertToFeedDTO).collect(Collectors.toList());
    }
}
