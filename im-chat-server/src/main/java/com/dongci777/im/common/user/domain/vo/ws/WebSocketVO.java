package com.dongci777.im.common.user.domain.vo.ws;

import com.dongci777.im.common.model.BasePOJO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: zxb
 */
@Getter
@Setter
public class WebSocketVO<T> extends BasePOJO {

    /**
     * @see com.dongci777.im.common.user.enums.WebSocketVOTypeEnum
     */
    private Integer type;

    private T data;

}
