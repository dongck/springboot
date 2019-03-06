package com.dongck.nio.nioSocket.common;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class MySocketChannel {
	
	public static void connectSocket(String msg) throws IOException{

		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress(9999));
		
		ByteBuffer buf = ByteBuffer.allocate(64);
		buf.clear();
		buf.put(msg.getBytes());
		
		buf.flip();
		while(buf.hasRemaining()){
			socketChannel.write(buf);
		}
		
		socketChannel.close();
		
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		long st = System.currentTimeMillis();
		for(int i=1;i<=1000000;i++){
//			if(i%10000 == 0){
//				Thread.currentThread().sleep(5000);
//			}
			connectSocket("msg is "+ i);
		}
		System.out.println("共："+ (System.currentTimeMillis() - st));

	}

}
