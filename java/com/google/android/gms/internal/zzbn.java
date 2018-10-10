package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf.zza;
import java.util.concurrent.Callable;

public class zzbn implements Callable {
    private final zzbc zzpC;
    private final zza zzra;

    public zzbn(zzbc zzbc, zza zza) {
        this.zzpC = zzbc;
        this.zzra = zza;
    }

    public /* synthetic */ Object call() throws Exception {
        return zzbl();
    }

    public Void zzbl() throws Exception {
        if (this.zzpC.zzaT() != null) {
            this.zzpC.zzaT().get();
        }
        zzbut zzaS = this.zzpC.zzaS();
        if (zzaS != null) {
            try {
                synchronized (this.zzra) {
                    zzbut.zza(this.zzra, zzbut.zzf(zzaS));
                }
            } catch (zzbus e) {
            }
        }
        return null;
    }
}
