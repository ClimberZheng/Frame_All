package com.entity.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: StevenClise
 * @Date : 2019/11/26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String cusNo;
    private String cusName;
    private String cusPhNumber;

}
