package com.dongci777.im.common.user.domain.req.ws;

import com.dongci777.im.common.model.BasePOJO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: zxb
 */
@Getter
@Setter
public class WebSocketRequest extends BasePOJO {

    /**
     * @see com.dongci777.im.common.user.enums.WebSocketRequestTypeEnum
     */
    private Integer type;

    private String data;

}
