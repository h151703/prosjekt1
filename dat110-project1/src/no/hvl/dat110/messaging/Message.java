package no.hvl.dat110.messaging;

import java.util.Arrays;

public class Message {

	private byte[] payload;

	/*
	 * If Payload =< 127 bytes then this.payload = payload;
	 */

	public Message(byte[] payload) {

		if (payload.length <= 127) {
			this.payload = payload; // TODO: check for length within boundary
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	/*
	 * The messaging protocol is based on sending segments of 128 bytes on the
	 * underlying TCP connection such that the first byte of the segment is to be
	 * interpreted as an integer in the range 0..127 specifying how many of the
	 * subsequent 127 bytes is payload data. Any remaining bytes is simply
	 * considered to be padding and can be ignored.
	 */

	@SuppressWarnings({ "null", "unused" })
	public byte[] encapsulate() {

		byte[] encoded = new byte[128];

		int payLength = payload.length; // convert payload length to byte

		encoded[0] = (byte) payLength;

		for (int i = 0; i < payLength; i++) {
			encoded[i + 1] = payload[i];
		}

		// TODO
		// encapulate/encode the payload of the message

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
