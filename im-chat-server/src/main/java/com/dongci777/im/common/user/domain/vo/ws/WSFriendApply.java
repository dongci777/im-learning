package com.dongci777.im.common.user.domain.vo.ws;

import com.dongci777.im.common.model.BasePOJO;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author: zxb
 */
@Getter
@Setter
public class WSFriendApply extends BasePOJO {

    @ApiModelProperty("申请人")
    private Long uid;

    @ApiModelProperty("申请未读数")
    private Integer unreadCount;

}
