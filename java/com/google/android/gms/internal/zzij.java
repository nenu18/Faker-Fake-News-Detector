package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;

@zzmb
public class zzij extends zzpd {
    final zzqp zzGt;
    final zzil zzHU;
    private final String zzHV;

    /* renamed from: com.google.android.gms.internal.zzij$1 */
    class C03751 implements Runnable {
        final /* synthetic */ zzij zzHW;

        C03751(zzij zzij) {
            this.zzHW = zzij;
        }

        public void run() {
            zzv.zzdg().zzb(this.zzHW);
        }
    }

    zzij(zzqp zzqp, zzil zzil, String str) {
        this.zzGt = zzqp;
        this.zzHU = zzil;
        this.zzHV = str;
        zzv.zzdg().zza(this);
    }

    public void onStop() {
        this.zzHU.abort();
    }

    public void zzcm() {
        try {
            this.zzHU.zzad(this.zzHV);
        } finally {
            zzpi.zzWR.post(new C03751(this));
        }
    }
}
