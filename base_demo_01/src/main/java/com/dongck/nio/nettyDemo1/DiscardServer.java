package com.dongck.nio.nettyDemo1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DiscardServer {
	
	private int port;
	
	public DiscardServer(int port){
		this.port = port;
	}
	
	public void run() throws Exception{
		EventLoopGroup boosGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		
		try{
			
			ServerBootstrap b = new ServerBootstrap();
			b.group(boosGroup, workerGroup)
			.channel(NioServerSocketChannel.class)
			.childHandler(new ChannelInitializer<SocketChannel>() {
				
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new DiscardServerHandler());
				}
			})
			.option(ChannelOption.SO_BACKLOG, 128)
			.childOption(ChannelOption.SO_KEEPALIVE, true);
			
			ChannelFuture f = b.bind(port).sync();
			
			f.channel().closeFuture().sync();
		}finally{
			workerGroup.shutdownGracefully();
			boosGroup.shutdownGracefully();
		}
			
		
	}
	
	public static void main(String[] args) {
		
		try {
			new DiscardServer(9999).run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
