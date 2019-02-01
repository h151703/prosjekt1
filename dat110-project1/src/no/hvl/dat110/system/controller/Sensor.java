package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		
		int temp;
		
		
//		byte[] marshalled = RPCUtils.marshallInteger(RPCID, temp);
		
//		RPCUtils.unmarshallInteger(rmiclient.call(marshalled));
		
	
		
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		
		if (true) {
			  throw new RuntimeException("not yet implemented");
		}
		
		return temp;
	}
	
}
