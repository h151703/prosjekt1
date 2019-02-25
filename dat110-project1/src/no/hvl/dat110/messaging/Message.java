package no.hvl.dat110.messaging;

public class Message {

	private byte[] payload;
	public int segmentSize = MessageConfig.SEGMENTSIZE;

	public Message(byte[] payload) {
		this.payload = payload; // TODO: check for length within boundary

		if (payload.length + 1 > segmentSize) {
			try {
				throw new Exception("Payload is too big.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {

		// TODO
		// encapulate/encode the payload of the message

		byte[] encoded = new byte[segmentSize];

		encoded[0] = (byte) payload.length;

		for (int i = 0; i < payload.length; i++) {
			encoded[i + 1] = payload[i];
		}

		return encoded;

	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate data in received and put in payload
		
		payload = new byte[received[0]];
		for (int i = 0; i < payload.length; i++) {
			payload[i] = received[i + 1];
		}
	}
}