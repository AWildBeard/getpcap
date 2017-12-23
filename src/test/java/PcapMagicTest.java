// Test PcapMagic
import org.junit.Test;
import static org.junit.Assert.*;

public class PcapMagicTest {
    @Test 
    public void testPcapMagic() {
        assertEquals(PcapMagic.FORWARD, PcapMagic.valueOf(0xA1B2C3D4));
        assertEquals(PcapMagic.BACKWARD, PcapMagic.valueOf(0xD4C3B2A1));
        assertNotEquals(PcapMagic.FORWARD, PcapMagic.valueOf(20));
        assertNotEquals(PcapMagic.BACKWARD, PcapMagic.valueOf(20));
    }
}
