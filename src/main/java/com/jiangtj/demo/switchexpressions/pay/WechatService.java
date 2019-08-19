package com.jiangtj.demo.switchexpressions.pay;

import com.jiangtj.demo.switchexpressions.PayService;
import com.jiangtj.demo.switchexpressions.Result;
import org.springframework.stereotype.Service;

/**
 * Created by MrTT (jiang.taojie@foxmail.com)
 * 2019/8/19.
 */
@Service
public class WechatService implements PayService {
    @Override
    public Result pay() {
        return Result.of("success", "Paying by Wechat!");
    }
}
