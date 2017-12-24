// PcapHeader.java

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import java.io.IOException;

public class PcapHeader {

    private static final int HEADER_BYTE_SIZE = 24;

    private final PcapMagic magic; // Magic, represents the ordering of the data within the pcap

    private final int timeZone, // Timezone offset of the capture
        sigFigs, // Accuracy of timestamps
        snapLen; // length of captured packets

    private final String version;   // version of the pcap file
    private final PcapNetworkDevice netCapDev; // The device that caputred the packets.

    /* Must pass an InputStream to make a header. 
     * Satisfy the "variable might not have bben initialized clause"
     */
    private PcapHeader() {
        this.magic = PcapMagic.INVALID;
        this.timeZone = this.sigFigs = this.snapLen = 0;
        this.version = "";
        this.netCapDev = PcapNetworkDevice.NULL;
    } 

    public PcapHeader(InputStream is) throws IOException {

        byte[] header = new byte[HEADER_BYTE_SIZE];
        is.read(header);

        ByteBuffer buffer = ByteBuffer.wrap(header);

        this.magic = PcapMagic.valueOf(buffer.getInt());

        switch (this.magic) {
            case FORWARD:
                buffer.order(ByteOrder.BIG_ENDIAN);
                break;
            case BACKWARD:
                buffer.order(ByteOrder.LITTLE_ENDIAN);
                break;
            default:
                throw new IOException("Invalid magic header. " + 
                    "Should be 0xA1B2C3D4 (FORWARD) --or-- 0xD4C3B2A1 (BACKWARD)");
        }

        this.version = String.valueOf(buffer.getShort()) + 
            "." + String.valueOf(buffer.getShort());

        this.timeZone = buffer.getInt();

        this.sigFigs = buffer.getInt();

        this.snapLen = buffer.getInt();

        this.netCapDev = PcapNetworkDevice.valueOf(buffer.getInt());
    }

    public PcapMagic getMagic() {return this.magic;}

    public int getTimeZone() {return this.timeZone;}

    public int getSigFigs() {return this.sigFigs;}

    public int getSnapLen() {return this.snapLen;}

    public String getVersion() {return this.version;}

    public PcapNetworkDevice getNetCapDev() {return this.netCapDev;}
}