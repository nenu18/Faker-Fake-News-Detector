package com.google.android.gms.internal;

import com.google.android.gms.internal.zzln.zza;

@zzmb
public class zzlp extends zzpd {
    private final zza zzPn;
    private final zzov.zza zzPo;
    private final zzmk zzPp = this.zzPo.zzVB;

    public zzlp(zzov.zza zza, zza zza2) {
        this.zzPo = zza;
        this.zzPn = zza2;
    }

    private zzov zzQ(int i) {
        return new zzov(this.zzPo.zzSF.zzRd, null, null, i, null, null, this.zzPp.orientation, this.zzPp.zzKe, this.zzPo.zzSF.zzRg, false, null, null, null, null, null, this.zzPp.zzRL, this.zzPo.zzvj, this.zzPp.zzRJ, this.zzPo.zzVv, this.zzPp.zzRO, this.zzPp.zzRP, this.zzPo.zzVp, null, null, null, null, this.zzPo.zzVB.zzSc, this.zzPo.zzVB.zzSd, null, null, null);
    }

    public void onStop() {
    }

    public void zzcm() {
        final zzov zzQ = zzQ(0);
        zzpi.zzWR.post(new Runnable(this) {
            final /* synthetic */ zzlp zzPH;

            public void run() {
                this.zzPH.zzPn.zzb(zzQ);
            }
        });
    }
}
