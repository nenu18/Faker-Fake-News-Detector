package com.google.android.gms.internal;

import android.content.Context;

@zzmb
public class zzmc {

    public interface zza {
        void zza(com.google.android.gms.internal.zzov.zza zza);
    }

    public zzpd zza(Context context, com.google.android.gms.internal.zzmh.zza zza, zzav zzav, zza zza2) {
        zzpd zzmu = zza.zzRd.extras.getBundle("sdk_less_server_data") != null ? new zzmu(context, zza, zza2) : new zzmd(context, zza, zzav, zza2);
        zzmu.zziw();
        return zzmu;
    }
}
