package com.dongck.nio.nioSocket.common;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

public class CommonServerSocketChannel{
	
	private String addr;
	private String port;
	
	public CommonServerSocketChannel(){ }
	
	public CommonServerSocketChannel(String addr ,String port){ 
		this.addr = addr;
		this.port = port;
	}
	

}
