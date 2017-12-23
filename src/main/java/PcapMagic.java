public enum PcapMagic {
    FORWARD,
    BACKWARD,
    NULL;

    private static final int MG_FORWARD = 0xA1B2C3D4;
    private static final int MG_BACKWARD = 0xD4C3B2A1;

    public static PcapMagic valueOf(int val) {
        switch (val) {
            case MG_FORWARD:
                return PcapMagic.FORWARD;
            case MG_BACKWARD:
                return PcapMagic.BACKWARD;
            default:
                return PcapMagic.NULL;
        }
    }
}