package com.dongci777.im.common.user.domain.vo.ws;

import com.dongci777.im.common.model.BasePOJO;
import lombok.*;

/**
 * @author: zxb
 */
@Getter
@Setter
public class WSLoginSuccess extends BasePOJO {

    private Long uid;

    private String avatar;

    private String token;

    private String name;

    //用户权限 0普通用户 1超管
    private Integer power;

}
