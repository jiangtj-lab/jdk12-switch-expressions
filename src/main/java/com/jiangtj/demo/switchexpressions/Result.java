package com.jiangtj.demo.switchexpressions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by MrTT (jiang.taojie@foxmail.com)
 * 2019/8/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Result {
    private String status;
    private String message;
}
