package com.zking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userid;

    private String username;

    private String password;

    private String salt;

    private Date createdate;

}