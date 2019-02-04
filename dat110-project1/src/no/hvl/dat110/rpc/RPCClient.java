package no.hvl.dat110.rpc;

import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void register(RPCStub remote) {
		remote.register(this);
	}
	
	
	public void connect() {	
		// TODO: connect using the underlying messaging layer connection
		
		connection = msgclient.connect();
			
	}
	
	public void disconnect() {
		
	 connection.close();	
		
	}
	
	/* TODO: 
	
	Make a remote call on the RPC server by sending a request message
	and receive a reply message
	
	rpcrequest is the marshalled rpcrequest from the client-stub
	rpcreply is the rpcreply to be unmarshalled by the client-stub
	
	*/
	
	public byte[] call(byte[] rpcrequest) {
		
		byte[] rpcreply;
		
		connection.send(new Message(rpcrequest));
		rpcreply = connection.receive().getData();
		

//		Message requestMes = new Message(rpcrequest);
//		
//		connection.send(requestMes);
//		
//		Message replymsg = connection.receive();
//	
//		rpcreply = 	replymsg.getData();
//		
//		System.out.println("er denne 5? " + rpcreply.length);
		
		return rpcreply;
		
	}

}
