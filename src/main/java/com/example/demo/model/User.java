package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2020-09-03 17:02
 */
@Data
public class User {
    int id;
    String email;
    String name;
    int managerId;
    Timestamp createdAt;
    Timestamp updatedAt;
}
