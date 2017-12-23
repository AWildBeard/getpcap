// Test PcapNetworkDevice
import org.junit.Test;
import static org.junit.Assert.*;

public class PcapNetworkDeviceTest {
    @Test
    public void testPcapNetworkDevice() {
        assertEquals(PcapNetworkDevice.ETHERNET, PcapNetworkDevice.valueOf(1));
        assertEquals(PcapNetworkDevice.SUNATM, PcapNetworkDevice.valueOf(123));
        assertEquals(PcapNetworkDevice.USER0_USER15, PcapNetworkDevice.valueOf(162));
        assertEquals(PcapNetworkDevice.USER0_USER15, PcapNetworkDevice.valueOf(147));
        assertEquals(PcapNetworkDevice.AX25, PcapNetworkDevice.valueOf(3));
        assertEquals(PcapNetworkDevice.LINUX_LAPD, PcapNetworkDevice.valueOf(177));
        assertEquals(PcapNetworkDevice.EPON, PcapNetworkDevice.valueOf(259));
        assertEquals(PcapNetworkDevice.NULL, PcapNetworkDevice.valueOf(0));
    }
}