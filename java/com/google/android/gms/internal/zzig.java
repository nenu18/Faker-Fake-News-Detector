package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

@zzmb
public class zzig implements zzhx {
    private final zza zzHS;

    public interface zza {
        void zzb(zzok zzok);

        void zzcl();
    }

    public zzig(zza zza) {
        this.zzHS = zza;
    }

    public static void zza(zzqp zzqp, zza zza) {
        zzqp.zzkV().zza("/reward", new zzig(zza));
    }

    private void zzf(Map<String, String> map) {
        zzok zzok;
        try {
            int parseInt = Integer.parseInt((String) map.get("amount"));
            String str = (String) map.get("type");
            if (!TextUtils.isEmpty(str)) {
                zzok = new zzok(str, parseInt);
                this.zzHS.zzb(zzok);
            }
        } catch (Throwable e) {
            zzpy.zzc("Unable to parse reward amount.", e);
        }
        zzok = null;
        this.zzHS.zzb(zzok);
    }

    private void zzg(Map<String, String> map) {
        this.zzHS.zzcl();
    }

    public void zza(zzqp zzqp, Map<String, String> map) {
        String str = (String) map.get("action");
        if ("grant".equals(str)) {
            zzf(map);
        } else if ("video_start".equals(str)) {
            zzg(map);
        }
    }
}
