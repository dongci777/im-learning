package com.dongci777.im.common.annotation;

import cn.hutool.core.util.DesensitizedUtil;

import java.lang.annotation.*;

/**
 * @author: zxb
 * <p>
 * 敏感词注解
 * BasePOJO.toString() 不会打印此注解的字段
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface Sensitive {

    /**
     * 敏感词类型
     */
    Type value();

    enum Type {
        /**
         * 密码
         */
        PASSWORD,
        /**
         * 银行卡号
         */
        CARD_NO,
        /**
         * 身份证号
         */
        ID_CARD_NO,
        /**
         * 手机号
         */
        MOBILE,
        /**
         * 其他
         */
        OTHER;

        /**
         * 掩码
         */
        public String mask(String value) {
            if (this == PASSWORD || this == OTHER) {
                return "******";
            } else if (this == CARD_NO) {
                return DesensitizedUtil.bankCard(value);
            } else if (this == ID_CARD_NO) {
                return DesensitizedUtil.idCardNum(value, 3, 6);
            } else if (this == MOBILE) {
                return DesensitizedUtil.mobilePhone(value);
            }

            return value;
        }
    }

}