package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzmb
public class zzgf {
    boolean zzFa;
    private final List<zzgd> zzFr = new LinkedList();
    private final Map<String, String> zzFs = new LinkedHashMap();
    private String zzFt;
    private zzgd zzFu;
    @Nullable
    private zzgf zzFv;
    private final Object zzrN = new Object();

    public zzgf(boolean z, String str, String str2) {
        this.zzFa = z;
        this.zzFs.put("action", str);
        this.zzFs.put("ad_format", str2);
    }

    public void zzX(String str) {
        if (this.zzFa) {
            synchronized (this.zzrN) {
                this.zzFt = str;
            }
        }
    }

    public boolean zza(zzgd zzgd, long j, String... strArr) {
        synchronized (this.zzrN) {
            for (String zzgd2 : strArr) {
                this.zzFr.add(new zzgd(j, zzgd2, zzgd));
            }
        }
        return true;
    }

    public boolean zza(@Nullable zzgd zzgd, String... strArr) {
        return (!this.zzFa || zzgd == null) ? false : zza(zzgd, zzv.zzcP().elapsedRealtime(), strArr);
    }

    @Nullable
    public zzgd zzc(long j) {
        return !this.zzFa ? null : new zzgd(j, null, null);
    }

    public void zzc(@Nullable zzgf zzgf) {
        synchronized (this.zzrN) {
            this.zzFv = zzgf;
        }
    }

    public zzgd zzfA() {
        zzgd zzgd;
        synchronized (this.zzrN) {
            zzgd = this.zzFu;
        }
        return zzgd;
    }

    public zzgd zzfw() {
        return zzc(zzv.zzcP().elapsedRealtime());
    }

    public void zzfx() {
        synchronized (this.zzrN) {
            this.zzFu = zzfw();
        }
    }

    public String zzfy() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        synchronized (this.zzrN) {
            for (zzgd zzgd : this.zzFr) {
                long time = zzgd.getTime();
                String zzft = zzgd.zzft();
                zzgd zzgd2 = zzgd2.zzfu();
                if (zzgd2 != null && time > 0) {
                    stringBuilder2.append(zzft).append('.').append(time - zzgd2.getTime()).append(',');
                }
            }
            this.zzFr.clear();
            if (!TextUtils.isEmpty(this.zzFt)) {
                stringBuilder2.append(this.zzFt);
            } else if (stringBuilder2.length() > 0) {
                stringBuilder2.setLength(stringBuilder2.length() - 1);
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    Map<String, String> zzfz() {
        Map<String, String> map;
        synchronized (this.zzrN) {
            zzfz zzjN = zzv.zzcN().zzjN();
            if (zzjN == null || this.zzFv == null) {
                map = this.zzFs;
            } else {
                map = zzjN.zza(this.zzFs, this.zzFv.zzfz());
            }
        }
        return map;
    }

    public void zzg(String str, String str2) {
        if (this.zzFa && !TextUtils.isEmpty(str2)) {
            zzfz zzjN = zzv.zzcN().zzjN();
            if (zzjN != null) {
                synchronized (this.zzrN) {
                    zzjN.zzV(str).zza(this.zzFs, str, str2);
                }
            }
        }
    }
}
