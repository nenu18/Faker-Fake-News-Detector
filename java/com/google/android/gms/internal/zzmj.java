package com.google.android.gms.internal;

import com.google.android.gms.internal.zzmr.zza;
import java.lang.ref.WeakReference;

@zzmb
public final class zzmj extends zza {
    private final WeakReference<zzme.zza> zzRI;

    public zzmj(zzme.zza zza) {
        this.zzRI = new WeakReference(zza);
    }

    public void zzb(zzmk zzmk) {
        zzme.zza zza = (zzme.zza) this.zzRI.get();
        if (zza != null) {
            zza.zzb(zzmk);
        }
    }
}
