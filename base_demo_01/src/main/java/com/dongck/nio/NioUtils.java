package com.dongck.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * @Date 2019-03-05 
 * @author dongck
 *
 */
public class NioUtils {
	
	

	public static void main(String[] args) throws IOException {
//		RandomAccessFile aFile = new RandomAccessFile("d:/user.txt","rw");
		FileInputStream fis = new FileInputStream("d:/user.txt");
		
		FileChannel channel = fis.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(2);
		int bufread = channel.read(buf);
		while(bufread != -1){
			buf.flip();
			while(buf.hasRemaining()){
				System.out.print((char)buf.get());
			}
			buf.clear();
			bufread = channel.read(buf);
		}
		
		fis.close();
	}

}
