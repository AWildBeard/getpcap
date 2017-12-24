// PcapMagic.java

public enum PcapMagic {
    FORWARD,
    BACKWARD,
    INVALID;

    private static final int MG_FORWARD = 0xA1B2C3D4;
    private static final int MG_BACKWARD = 0xD4C3B2A1;

    public static PcapMagic valueOf(int val) {
        switch (val) {
            case MG_FORWARD:
                return FORWARD;
            case MG_BACKWARD:
                return BACKWARD;
            default:
                return INVALID;
        }
    }
}