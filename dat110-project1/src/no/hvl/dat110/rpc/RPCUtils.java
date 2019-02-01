package no.hvl.dat110.rpc;

import java.util.Arrays;

public class RPCUtils {

	
	/*
	 * RPCUtils.java containing utility methods for the unmarshalling
	 * and marshalling of the data types supported. 
	 * The implementation of the marshalling/unmarshalling of booleans
	 * is provided and can be used for inspiration. 
	 * Remember that an integer in Java is 4 bytes.
	 * 
	 */
	
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.getBytes().length +1];
		
		byte[] byteArray = str.getBytes();
		
		encoded[0] = rpcid;
		
		for(int i=1; i < byteArray.length + 1; i++) {
			encoded[i] = byteArray[i-1];
		}		

		// TODO: marshall RPC identifier and string into byte array

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded = new String(Arrays.copyOfRange(data, 1, data.length));
		
		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1]; 
		
		encoded[0] = rpcid;  
			
		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {
  
		return;
		
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded = new byte[5];
		
		//remember that an integer in java is 4 bytes

		// TODO: marshall RPC identifier and string (int?) into byte array

		for(int i = 0; i < 4; i++) {
			encoded[i+1] = (byte) (x >> (i *8));
		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded = 0;

		// TODO: unmarshall integer contained in data

		for(int i = 0; i < 4; i++) {
			decoded += Byte.toUnsignedInt(data[i+1]) << (i*8);
		}

		return decoded;

	}
}
