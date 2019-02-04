package no.hvl.dat110.messaging;

public class Message {

    private byte[] payload;

    public Message(byte[] payload) {
        this.payload = payload; // TODO: check for length within boundary
    }

    public Message() {
        super();
    }

    public byte[] getData() {
        return this.payload;
    }

    public byte[] encapsulate() {

        byte[] encoded = new byte[128];

        encoded[0] = (byte) payload.length;

        for (int i = 0; i < payload.length; i++) {
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