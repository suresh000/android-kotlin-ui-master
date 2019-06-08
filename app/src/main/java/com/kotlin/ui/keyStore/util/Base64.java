package com.kotlin.ui.keyStore.util;


public class Base64 {
    public Base64() {
    }

    public static final String encode(byte[] d) {
        if(d == null) {
            return null;
        } else {
            int len = d.length;
            byte[] data = new byte[d.length + 2];
            System.arraycopy(d, 0, data, 0, d.length);
            byte[] dest = new byte[data.length / 3 * 4];
            int idx = 0;

            for(int didx = 0; idx < d.length; didx += 4) {
                dest[didx] = (byte)(data[idx] >>> 2 & 63);
                dest[didx + 1] = (byte)(data[idx + 1] >>> 4 & 15 | data[idx] << 4 & 63);
                dest[didx + 2] = (byte)(data[idx + 2] >>> 6 & 3 | data[idx + 1] << 2 & 63);
                dest[didx + 3] = (byte)(data[idx + 2] & 63);
                idx += 3;
            }

            for(idx = 0; idx < dest.length; ++idx) {
                if(dest[idx] < 26) {
                    dest[idx] = (byte)(dest[idx] + 65);
                } else if(dest[idx] < 52) {
                    dest[idx] = (byte)(dest[idx] + 97 - 26);
                } else if(dest[idx] < 62) {
                    dest[idx] = (byte)(dest[idx] + 48 - 52);
                } else if(dest[idx] < 63) {
                    dest[idx] = 43;
                } else {
                    dest[idx] = 47;
                }
            }

            for(idx = dest.length - 1; idx > d.length * 4 / 3; --idx) {
                dest[idx] = 61;
            }

            return new String(dest);
        }
    }

    public static final String encode(String s) {
        return encode(s.getBytes());
    }

    public static final byte[] decode(String str) {
        if(str == null) {
            return null;
        } else {
            byte[] data = str.getBytes();
            return decode(data);
        }
    }

    public static final byte[] decode(byte[] data) {
        int tail;
        for(tail = data.length; data[tail - 1] == 61; --tail) {
            ;
        }

        byte[] dest = new byte[tail - data.length / 4];

        int sidx;
        for(sidx = 0; sidx < data.length; ++sidx) {
            if(data[sidx] == 61) {
                data[sidx] = 0;
            } else if(data[sidx] == 47) {
                data[sidx] = 63;
            } else if(data[sidx] == 43) {
                data[sidx] = 62;
            } else if(data[sidx] >= 48 && data[sidx] <= 57) {
                data[sidx] -= -4;
            } else if(data[sidx] >= 97 && data[sidx] <= 122) {
                data[sidx] = (byte)(data[sidx] - 71);
            } else if(data[sidx] >= 65 && data[sidx] <= 90) {
                data[sidx] = (byte)(data[sidx] - 65);
            }
        }

        sidx = 0;

        int didx;
        for(didx = 0; didx < dest.length - 2; didx += 3) {
            dest[didx] = (byte)(data[sidx] << 2 & 255 | data[sidx + 1] >>> 4 & 3);
            dest[didx + 1] = (byte)(data[sidx + 1] << 4 & 255 | data[sidx + 2] >>> 2 & 15);
            dest[didx + 2] = (byte)(data[sidx + 2] << 6 & 255 | data[sidx + 3] & 63);
            sidx += 4;
        }

        if(didx < dest.length) {
            dest[didx] = (byte)(data[sidx] << 2 & 255 | data[sidx + 1] >>> 4 & 3);
        }

        ++didx;
        if(didx < dest.length) {
            dest[didx] = (byte)(data[sidx + 1] << 4 & 255 | data[sidx + 2] >>> 2 & 15);
        }

        return dest;
    }
}