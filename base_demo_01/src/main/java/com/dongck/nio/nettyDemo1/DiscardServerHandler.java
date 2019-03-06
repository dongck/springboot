package com.dongck.nio.nettyDemo1;

import java.util.concurrent.atomic.AtomicInteger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * handler 处理器
 * 作用:netty 用来处理i/o事件
 * Adapter适配器
 * @author dongck
 *
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
	
	private static final AtomicInteger i = new AtomicInteger(1);
	
	/**
	 * 当获取到msg后默默丢弃
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("release"+i.getAndIncrement());
		((ByteBuf) msg).release();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
	

}
