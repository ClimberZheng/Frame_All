package com.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: StevenClise
 * @Date : 2019/12/20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleUser {

    private String username;
    private String pwd;
}
