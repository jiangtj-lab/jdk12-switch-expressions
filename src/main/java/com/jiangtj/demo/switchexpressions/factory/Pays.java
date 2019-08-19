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
public class Pays {

    private final WechatService wechatService;
    private final AliService aliService;

    public Pays(WechatService wechatService, AliService aliService) {
        this.wechatService = wechatService;
        this.aliService = aliService;
    }

    public PayService get(String no) {
        return switch (no) {
            case "wechat" -> wechatService;
            case "ali" -> aliService;
            default -> null;
        };
    }

}
