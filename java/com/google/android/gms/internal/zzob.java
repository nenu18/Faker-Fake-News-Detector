package com.google.android.gms.internal;

@zzmb
public class zzob {
    public final int errorCode;
    public final String zzJJ;
    public final long zzKF;
    public final String zzUV;

    public static final class zza {
        private String zzKo;
        private int zzPF;
        private String zzUW;
        private long zzUX;

        public zza zzaO(String str) {
            this.zzKo = str;
            return this;
        }

        public zza zzaP(String str) {
            this.zzUW = str;
            return this;
        }

        public zza zzac(int i) {
            this.zzPF = i;
            return this;
        }

        public zzob zzjt() {
            return new zzob();
        }

        public zza zzl(long j) {
            this.zzUX = j;
            return this;
        }
    }

    private zzob(zza zza) {
        this.zzUV = zza.zzKo;
        this.zzJJ = zza.zzUW;
        this.errorCode = zza.zzPF;
        this.zzKF = zza.zzUX;
    }
}
