package com.jiangtj.demo.switchexpressions.factory;

import com.jiangtj.demo.switchexpressions.PayService;
import com.jiangtj.demo.switchexpressions.pay.AliService;
import com.jiangtj.demo.switchexpressions.pay.WechatService;
import org.springframework.stereotype.Service;

/**
 * Created by MrTT (jiang.taojie@foxmail.com)
 * 2019/8/19.
 */
@Service
public class OldPays {

    private final WechatService wechatService;
    private final AliService aliService;

    public OldPays(WechatService wechatService, AliService aliService) {
        this.wechatService = wechatService;
        this.aliService = aliService;
    }

    public PayService get(String no) {
        switch (no) {
            case "wechat": return wechatService;
            case "ali": return aliService;
            default: return null;
        }
    }

}
