package com.example.demo.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * test_user
 * @author 
 */
@Data
public class TestUser implements Serializable {
    private Integer id;

    private String name;

    private Integer deptId;

    private Double salary;

    private static final long serialVersionUID = 1L;
}