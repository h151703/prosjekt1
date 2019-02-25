package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class RPCUtils {

	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] byteArray = str.getBytes();
		byte[] encoded = new byte[str.getBytes().length +1];
		
		encoded[0] = rpcid;
		
		for(int i=0; i < byteArray.length; i++) {
			encoded[i+1] = byteArray[i];
		}		

		return encoded;
	}

	public static String unmarshallString(byte[] data) {
		
		//TODO: unmarshall String contained in data into decoded
		
		byte[] byteArray = Arrays.copyOfRange(data, 1, data.length);

		String decoded = new String(byteArray);
		
		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {
		
		//TODO: marshall RPC identifier in case of void type

		byte[] encoded = new byte[1]; 
		
		encoded[0] = rpcid;  
			
		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {
		
		//TODO: marshall RPC identifier in case of void type
  
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
		
		// TODO: marshall RPC identifier and string into byte array


		byte[] encoded = new byte[5];

		encoded[0] = rpcid;
		
		byte[] byteArray = ByteBuffer.allocate(4).putInt(x).array();
		System.arraycopy(byteArray, 0, encoded, 1, byteArray.length);

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;
		
		byte[] byteArray = Arrays.copyOfRange(data, 1, data.length);
		decoded = ByteBuffer.wrap(byteArray).getInt();


		return decoded;

	}
}
