package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.zzi;

@zzmb
public final class zzme {

    public interface zza {
        void zzb(zzmk zzmk);
    }

    interface zzb {
        boolean zza(zzqa zzqa);
    }

    /* renamed from: com.google.android.gms.internal.zzme$1 */
    class C07691 implements zzb {
        final /* synthetic */ Context zztd;

        C07691(Context context) {
            this.zztd = context;
        }

        public boolean zza(zzqa zzqa) {
            return zzqa.zzYd || (zzi.zzaK(this.zztd) && !((Boolean) zzfx.zzBF.get()).booleanValue());
        }
    }

    public static zzpk zza(Context context, zzqa zzqa, zzqi<zzmh> zzqi, zza zza) {
        return zza(context, zzqa, zzqi, zza, new C07691(context));
    }

    static zzpk zza(Context context, zzqa zzqa, zzqi<zzmh> zzqi, zza zza, zzb zzb) {
        return zzb.zza(zzqa) ? zza(context, zzqi, zza) : zzb(context, zzqa, zzqi, zza);
    }

    private static zzpk zza(Context context, zzqi<zzmh> zzqi, zza zza) {
        zzpy.zzbc("Fetching ad response from local ad request service.");
        zzpk zza2 = new com.google.android.gms.internal.zzmf.zza(context, zzqi, zza);
        zza2.zziw();
        return zza2;
    }

    private static zzpk zzb(Context context, zzqa zzqa, zzqi<zzmh> zzqi, zza zza) {
        zzpy.zzbc("Fetching ad response from remote ad request service.");
        if (zzeh.zzeO().zzP(context)) {
            return new com.google.android.gms.internal.zzmf.zzb(context, zzqa, zzqi, zza);
        }
        zzpy.zzbe("Failed to connect to remote ad request service.");
        return null;
    }
}
