package com.stackroute.recommendationcommandservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    private long answerId;
    private String answerString;
    @Relationship(type = "accepted", direction = Relationship.INCOMING)
    private List<User> user;
    @Relationship(type = "answered", direction = Relationship.INCOMING)
    private List<User> user1;
    @Relationship(type = "upvoted", direction = Relationship.INCOMING)
    private List<User> user2;
    @Relationship(type = "downvoted", direction = Relationship.INCOMING)
    private List<User> user3;

}

