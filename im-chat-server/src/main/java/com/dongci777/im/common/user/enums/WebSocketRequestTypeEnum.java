package com.dongci777.im.common.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: zxb
 */
@AllArgsConstructor
@Getter
public enum WebSocketRequestTypeEnum {
    LOGIN(1, "请求登录二维码"),
    HEARTBEAT(2, "心跳包"),
    AUTHORIZE(3, "登录认证"),
    ;

    private final Integer type;
    private final String desc;

    /**
     * type和枚举类型关联map
     */
    private static Map<Integer, WebSocketRequestTypeEnum> cache;

    /**
     * 初始化cache
     */
    static {
        cache = Arrays.stream(WebSocketRequestTypeEnum.values()).collect(Collectors.toMap(WebSocketRequestTypeEnum::getType, Function.identity()));
    }

    /**
     * 根据type获取对应的枚举类型
     * @param type
     * @return
     */
    public static WebSocketRequestTypeEnum of(Integer type) {
        return cache.get(type);
    }
}
