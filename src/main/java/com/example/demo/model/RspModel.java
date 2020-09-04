package com.example.demo.model;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2020-09-03 17:55
 */
@Data
@NoArgsConstructor
public class RspModel {
    @NotNull
    private int code;
    @NotNull
    private String msg;

    private Object users;
}
