package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;
import java.util.WeakHashMap;

@zzmb
public final class zzng {
    private WeakHashMap<Context, zza> zzUx = new WeakHashMap();

    private class zza {
        public final long zzUy = zzv.zzcP().currentTimeMillis();
        public final zznf zzUz;

        public zza(zzng zzng, zznf zznf) {
            this.zzUz = zznf;
        }

        public boolean hasExpired() {
            return ((Long) zzfx.zzCQ.get()).longValue() + this.zzUy < zzv.zzcP().currentTimeMillis();
        }
    }

    public zznf zzv(Context context) {
        zza zza = (zza) this.zzUx.get(context);
        zznf zzjn = (zza == null || zza.hasExpired() || !((Boolean) zzfx.zzCP.get()).booleanValue()) ? new com.google.android.gms.internal.zznf.zza(context).zzjn() : new com.google.android.gms.internal.zznf.zza(context, zza.zzUz).zzjn();
        this.zzUx.put(context, new zza(this, zzjn));
        return zzjn;
    }
}
