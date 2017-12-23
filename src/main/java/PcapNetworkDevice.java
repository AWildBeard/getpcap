public enum PcapNetworkDevice {
    ETHERNET, AX25, IEEE802_5, ARCNET_BSD, SLIP, PPP, FDDI, PPP_HDLC, 
    PPP_ETHER, ATM_RFC1483, RAW, C_HDLC, IEEE802_11, FRELAY, LOOP, LINUX_SSL, 
    LTALK, PFLOG,IEEE802_11_PRISM, IP_OVER_FC, SUNATM, IEEE802_11_RADIOTAP, 
    ARCNET_LINUX, APPLE_IP_OVER_IEEE1394, MTP2_WITH_PHDR, MTP2, MTP3, SCCP, 
    DOCSIS, LINUX_IRDA, USER0_USER15, IEEE802_11_AVS, BACNET_MS_TP, PPP_PPPD,
    GPRS_LLC, GPF_T, GPF_F, LINUX_LAPD, BLUETOOTH_HCI_H4, USB_LINUX, PPI, 
    IEEE802_15_4, SITA, ERF, BLUETOOTH_HCI_H4_WITH_PHDR, AX25_KISS, LAPD, 
    PPP_WITH_DIR, C_HDLC_WITH_DIR, FRELAY_WITH_DIR, IPMB_LINUX, 
    IEEE802_15_4_NONASK_PHY, USB_LINUX_MMAPPED, FC_2, FC_2_WITH_FRAME_DELIMS, 
    IPNET, CAN_SOCKETCAN, IPV4, IPV6, IEEE802_15_4_NOFCS, DBUS, DVB_CI, MUX27010, 
    STANAG_5066_D_PDU, NFLOG, NETANALYZER, NETANALYZER_TRANSPARENT, IPOIB, 
    MPEG_2_TS, NG40, NFC_LLCP, INFINIBAND, SCTP, USBPCAP, RTAC_SERIAL, 
    BLUETOOTH_LE_LL, NETLINK, BLUETOOTH_LINUX_MONITOR, BLUETOOTH_BREDR_BB, 
    BLUETOOTH_LE_LL_WITH_PHDR, PROFIBUS_DL, PKTAP, EPON, IPMI_HPM_2, 
    ZWAVE_R1_R2, ZWAVE_R3, WATTSTOPPER_DLM, ISO_14443, RDS, USB_DARWIN, SDLC, 
    LORATAP, VSOCK, NORDIC_BLE, ETHERNET_MPACKET, NULL;

    // Same thing as above but missing USER0_USER15 and NULL
    private static final PcapNetworkDevice[] devs = {
        //1       3      6         7           8     9    10    50
        ETHERNET, AX25, IEEE802_5, ARCNET_BSD, SLIP, PPP, FDDI, PPP_HDLC, 
        //51       100          101  104     105         107     108
        PPP_ETHER, ATM_RFC1483, RAW, C_HDLC, IEEE802_11, FRELAY, LOOP, 
        //113      114    117    119               122         123
        LINUX_SSL, LTALK, PFLOG, IEEE802_11_PRISM, IP_OVER_FC, SUNATM, 
        //127                129           138
        IEEE802_11_RADIOTAP, ARCNET_LINUX, APPLE_IP_OVER_IEEE1394, 
        //139           140   141   142   143     144         163
        MTP2_WITH_PHDR, MTP2, MTP3, SCCP, DOCSIS, LINUX_IRDA, IEEE802_11_AVS, 
        //165         166       169       170    171    177
        BACNET_MS_TP, PPP_PPPD, GPRS_LLC, GPF_T, GPF_F, LINUX_LAPD, 
        //187             189        192  195           196   197
        BLUETOOTH_HCI_H4, USB_LINUX, PPI, IEEE802_15_4, SITA, ERF, 
        //201                       202        203   204
        BLUETOOTH_HCI_H4_WITH_PHDR, AX25_KISS, LAPD, PPP_WITH_DIR, 
        //205            206              209         215
        C_HDLC_WITH_DIR, FRELAY_WITH_DIR, IPMB_LINUX, IEEE802_15_4_NONASK_PHY, 
        //220              224   225                     226    227
        USB_LINUX_MMAPPED, FC_2, FC_2_WITH_FRAME_DELIMS, IPNET, CAN_SOCKETCAN, 
        //228 229   230                 231   235     236
        IPV4, IPV6, IEEE802_15_4_NOFCS, DBUS, DVB_CI, MUX27010, 
        //237              239    240          241
        STANAG_5066_D_PDU, NFLOG, NETANALYZER, NETANALYZER_TRANSPARENT,
        //242  243        244   245       247         248   249      250
        IPOIB, MPEG_2_TS, NG40, NFC_LLCP, INFINIBAND, SCTP, USBPCAP, RTAC_SERIAL, 
        //251            253      254                      255
        BLUETOOTH_LE_LL, NETLINK, BLUETOOTH_LINUX_MONITOR, BLUETOOTH_BREDR_BB, 
        //256                      257          258    259   260
        BLUETOOTH_LE_LL_WITH_PHDR, PROFIBUS_DL, PKTAP, EPON, IPMI_HPM_2, 
        //261        262       263              264        265  266
        ZWAVE_R1_R2, ZWAVE_R3, WATTSTOPPER_DLM, ISO_14443, RDS, USB_DARWIN,
        //268 270      271    272         274
        SDLC, LORATAP, VSOCK, NORDIC_BLE, ETHERNET_MPACKET
    };

    // All codes for net devs except the ones for USER0_USER15 and 0
    private static final int[] codes = {
        1,   3,   6,   7,   8,   9,   10,  50,  51,  100, 101, 104, 105, 107, 
        108, 113, 114, 117, 119, 122, 123, 127, 129, 138, 139, 140, 141, 142, 
        143, 144, 163, 165, 166, 169, 170, 171, 177, 187, 189, 192, 195, 196, 
        197, 201, 202, 203, 204, 205, 206, 209, 215, 220, 224, 225, 226, 227, 
        228, 229, 230, 231, 235, 236, 237, 239, 240, 241, 242, 243, 244, 245, 
        247, 248, 249, 250, 251, 253, 254, 255, 256, 257, 258, 259, 260, 261, 
        262, 263, 264, 265, 266, 268, 270, 271, 272, 274
    };

    public static final PcapNetworkDevice valueOf(int code) {
        if (code >= 147 && code <= 162)
                return USER0_USER15;

        for (int count = 0 ; count < devs.length ; count++) {
            if (code == codes[count])
                return devs[count];
        }

        return NULL;
    }
}