package com.aconex.hackathon.opendoor.representation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private UUID feedbackId;
    private UUID commentId;
    private String comment;
    private Timestamp createdAt;

}
