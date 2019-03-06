package com.dongck.nio;

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
public class NioUtils2 {
	
	

	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("d:/user.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		//create buffer with capacity of 48 bytes
		ByteBuffer buf = ByteBuffer.allocate(2);
		int bytesRead = inChannel.read(buf); //read into buffer.
		while (bytesRead != -1) {
		  buf.flip();  //make buffer ready for read
		  while(buf.hasRemaining()){
		      System.out.print((char) buf.get()); // read 1 byte at a time
		  }
		  buf.clear(); //make buffer ready for writing
		  bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}

}
