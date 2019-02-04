package no.hvl.dat110.rpc;

import java.util.HashMap;
import no.hvl.dat110.messaging.*;


public class RPCServer {

	private MessagingServer msgserver;
	private Connection connection;

	// hashmap to register RPC methods which are required to implement RPCImpl

	private HashMap<Integer, RPCImpl> services;

	public RPCServer(int port) {

		this.msgserver = new MessagingServer(port);
		this.services = new HashMap<Integer, RPCImpl>();

		// the stop RPC methods is built into the server
		services.put((int) RPCCommon.RPIDSTOP, new RPCServerStopImpl());
	}

	public void run() {

		boolean stop = false;

		System.out.println("RPC SERVER RUN - Services: " + services.size());

		connection = msgserver.accept();

		System.out.println("RPC SERVER ACCEPTED");

		while (!stop) {
			
			int rpcid;
			Message receiveMsg = connection.receive();

			byte[] request = receiveMsg.getData();

			 rpcid = request[0];

			// lookup the methods to be invoked
			 
			 RPCImpl impl;
			 
			 impl = services.get(rpcid);

			byte[] reply = impl.invoke(request);
			
			Message replymsg = new Message(reply);
			

			connection.send(replymsg);
			
			if (rpcid == RPCCommon.RPIDSTOP) {
				stop = true;
			}

			// TODO
			// - receive message containing RPC request
			// - find the identifier for the RPC methods to invoke
			// - lookup the methods to be invoked
			// - invoke the method
			// - send back message containing RPC reply

		}
	}

	public void register(int rmid, RPCImpl impl) {
		services.put(rmid, impl);
	}

	public void stop() {
		connection.close();
		msgserver.stop();

	}

}
