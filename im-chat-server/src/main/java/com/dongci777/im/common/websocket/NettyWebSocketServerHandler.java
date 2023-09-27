package com.dongci777.im.common.websocket;

import cn.hutool.json.JSONUtil;
import com.dongci777.im.common.user.domain.req.ws.WebSocketRequest;
import com.dongci777.im.common.user.enums.WebSocketRequestTypeEnum;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author: zxb
 */
public class NettyWebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            System.out.println("握手完成");
        } else if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                System.out.println("读空闲");
                // todo 用户下线
            }
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        WebSocketRequest webSocketRequest = JSONUtil.toBean(msg.text(), WebSocketRequest.class);
        switch (WebSocketRequestTypeEnum.of(webSocketRequest.getType())) {
            case LOGIN:
                System.out.println("请求登录二维码");
                ctx.channel().writeAndFlush(new TextWebSocketFrame("你好"));
                break;
            case AUTHORIZE:
                break;
            case HEARTBEAT:
                break;
            default:
                break;
        }
    }
}
