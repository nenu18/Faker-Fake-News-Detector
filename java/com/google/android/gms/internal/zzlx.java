package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.internal.zzlu.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzlx implements zza<zzgq> {
    private final boolean zzQH;
    private final boolean zzQI;

    public zzlx(boolean z, boolean z2) {
        this.zzQH = z;
        this.zzQI = z2;
    }

    public /* synthetic */ zzgu.zza zza(zzlu zzlu, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return zzc(zzlu, jSONObject);
    }

    public zzgq zzc(zzlu zzlu, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        List<zzqf> zza = zzlu.zza(jSONObject, "images", true, this.zzQH, this.zzQI);
        Future zza2 = zzlu.zza(jSONObject, "secondary_image", false, this.zzQH);
        Future zze = zzlu.zze(jSONObject);
        List arrayList = new ArrayList();
        for (zzqf zzqf : zza) {
            arrayList.add((zzgo) zzqf.get());
        }
        return new zzgq(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (zzgz) zza2.get(), jSONObject.getString("call_to_action"), jSONObject.getString("advertiser"), (zzgm) zze.get(), new Bundle());
    }
}
