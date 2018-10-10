package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

@zzmb
public class zzic implements zzhx {
    final HashMap<String, zzqc<JSONObject>> zzHM = new HashMap();

    public void zza(zzqp zzqp, Map<String, String> map) {
        zzh((String) map.get("request_id"), (String) map.get("fetched_ad"));
    }

    public Future<JSONObject> zzab(String str) {
        Future zzqc = new zzqc();
        this.zzHM.put(str, zzqc);
        return zzqc;
    }

    public void zzac(String str) {
        zzqc zzqc = (zzqc) this.zzHM.get(str);
        if (zzqc == null) {
            zzpy.m9e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!zzqc.isDone()) {
            zzqc.cancel(true);
        }
        this.zzHM.remove(str);
    }

    public void zzh(String str, String str2) {
        zzpy.zzbc("Received ad from the cache.");
        zzqc zzqc = (zzqc) this.zzHM.get(str);
        if (zzqc == null) {
            zzpy.m9e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            zzqc.zzh(new JSONObject(str2));
        } catch (Throwable e) {
            zzpy.zzb("Failed constructing JSON object from value passed from javascript", e);
            zzqc.zzh(null);
        } finally {
            this.zzHM.remove(str);
        }
    }
}
