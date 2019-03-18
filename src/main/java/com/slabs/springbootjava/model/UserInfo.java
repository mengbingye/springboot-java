package com.slabs.springbootjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;


/**
 * @create: 2019/03/18 10:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    private String id;

    @Column(name = "user_name")
    private String userName;
}
