package com.dongci777.im.common.user.domain.vo.ws;

import com.dongci777.im.common.model.BasePOJO;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author: zxb
 */
@Getter
@Setter
public class WSMessageRead extends BasePOJO {

    @ApiModelProperty("消息")
    private Long msgId;

    @ApiModelProperty("阅读人数（可能为0）")
    private Integer readCount;

}
