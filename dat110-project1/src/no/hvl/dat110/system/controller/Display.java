package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {
	
	/*
	 *  here you have to implement the client-side
	 *  stub of the void write(String str) RPC method
	 */

	private byte RPCID = 1;

	public void write(String message) {

		// TODO
		// implement marshalling, call and unmarshalling for write RPC method
			
		byte[] marshalled = RPCUtils.marshallString(RPCID, message);
		
		RPCUtils.unmarshallVoid(rmiclient.call(marshalled));
		
	}
}
