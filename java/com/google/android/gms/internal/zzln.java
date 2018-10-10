package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.zzs;

@zzmb
public class zzln {

    public interface zza {
        void zzb(zzov zzov);
    }

    public zzpk zza(Context context, com.google.android.gms.ads.internal.zza zza, com.google.android.gms.internal.zzov.zza zza2, zzav zzav, @Nullable zzqp zzqp, zzjs zzjs, zza zza3, zzgf zzgf) {
        zzmk zzmk = zza2.zzVB;
        zzpk zzlr = zzmk.zzRK ? new zzlr(context, zza2, zzjs, zza3, zzgf, zzqp) : (zzmk.zzzn || (zza instanceof zzr)) ? (zzmk.zzzn && (zza instanceof zzr)) ? new zzls(context, (zzr) zza, zza2, zzav, zza3, zzgf) : new zzlp(zza2, zza3) : (((Boolean) zzfx.zzBN.get()).booleanValue() && zzmk.zzRQ) ? new zzll(context, zza2, zzqp, zza3) : (((Boolean) zzfx.zzCg.get()).booleanValue() && zzs.zzyF() && !zzs.zzyH() && zzqp != null && zzqp.zzbD().zzzl) ? new zzlq(context, zza2, zzqp, zza3) : new zzlo(context, zza2, zzqp, zza3);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(zzlr.getClass().getName());
        zzpy.zzbc(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        zzlr.zziw();
        return zzlr;
    }

    public zzpk zza(Context context, com.google.android.gms.internal.zzov.zza zza, zznp zznp) {
        zzpk zzog = new zzog(context, zza, zznp);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(zzog.getClass().getName());
        zzpy.zzbc(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        zzog.zziw();
        return zzog;
    }
}
