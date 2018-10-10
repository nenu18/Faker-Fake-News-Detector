package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzc;
import java.util.Map;

@zzmb
public class zzim implements zzhx {
    public void zza(zzqp zzqp, Map<String, String> map) {
        zzik zzdg = zzv.zzdg();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str == null) {
                zzpy.zzbe("Precache video action is missing the src parameter.");
                return;
            }
            int parseInt;
            try {
                parseInt = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e) {
                parseInt = 0;
            }
            String str2 = map.containsKey("mimetype") ? (String) map.get("mimetype") : "";
            if (zzdg.zzf(zzqp)) {
                zzpy.zzbe("Precache task already running.");
                return;
            }
            zzc.zzt(zzqp.zzbz());
            new zzij(zzqp, zzqp.zzbz().zzsM.zza(zzqp, parseInt, str2), str).zziw();
        } else if (!zzdg.zze(zzqp)) {
            zzpy.zzbe("Precache abort but no preload task running.");
        }
    }
}
