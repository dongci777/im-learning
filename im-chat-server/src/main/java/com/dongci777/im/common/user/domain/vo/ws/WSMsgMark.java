package com.dongci777.im.common.user.domain.vo.ws;

import com.dongci777.im.common.model.BasePOJO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: zxb
 */
@Getter
@Setter
public class WSMsgMark extends BasePOJO {

    private List<WSMsgMarkItem> markList;

    @Getter
    @Setter
    public static class WSMsgMarkItem extends BasePOJO{

        @ApiModelProperty("操作者")
        private Long uid;

        @ApiModelProperty("消息id")
        private Long msgId;

        @ApiModelProperty("标记类型 1点赞 2举报")
        private Integer markType;

        @ApiModelProperty("被标记的数量")
        private Integer markCount;

        @ApiModelProperty("动作类型 1确认 2取消")
        private Integer actType;

    }

}
