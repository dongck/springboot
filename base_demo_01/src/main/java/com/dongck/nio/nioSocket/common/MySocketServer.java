package com.dongck.nio.nioSocket.common;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class MySocketServer {
	
	public static void main(String[] args) throws IOException {
		ServerSocketChannel sschannel = ServerSocketChannel.open();
		sschannel.socket().bind(new InetSocketAddress(9999));
		sschannel.configureBlocking(false);// 非阻塞模式
		
		Selector selector = Selector.open();
		int interestSet = SelectionKey.OP_CONNECT | SelectionKey.OP_ACCEPT 
								| SelectionKey.OP_READ | SelectionKey.OP_WRITE;
		
		SelectionKey key1 = sschannel.register(selector, interestSet );
		
		while (true) {
			SocketChannel socketChannel = sschannel.accept();

			if (socketChannel != null) {
				long startTime = System.currentTimeMillis();
				ByteBuffer buf = ByteBuffer.allocate(64);
				int bufread = socketChannel.read(buf);

				while (bufread != -1) {
					buf.flip();
					while (buf.hasRemaining()) {
						System.out.print((char) buf.get());
					}
					buf.clear();
					bufread = socketChannel.read(buf);
				}
				socketChannel.close();
				System.out.println("");
				System.out.println("共耗时：" + (System.currentTimeMillis() - startTime) + " ms");
			}

		}
	}
}
