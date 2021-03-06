package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmm;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.internal.zzpy;

@zzmb
public class zze {
    private final Context mContext;
    private final zzmm zzsQ;
    private boolean zzsR;

    public zze(Context context) {
        this(context, false);
    }

    public zze(Context context, @Nullable zza zza) {
        this.mContext = context;
        if (zza == null || zza.zzVB.zzSd == null) {
            this.zzsQ = new zzmm();
        } else {
            this.zzsQ = zza.zzVB.zzSd;
        }
    }

    public zze(Context context, boolean z) {
        this.mContext = context;
        this.zzsQ = new zzmm(z);
    }

    public void recordClick() {
        this.zzsR = true;
    }

    public boolean zzcb() {
        return !this.zzsQ.zzSi || this.zzsR;
    }

    public void zzx(@Nullable String str) {
        if (str == null) {
            str = "";
        }
        zzpy.zzbd("Action was blocked because no touch was detected.");
        if (this.zzsQ.zzSi && this.zzsQ.zzSj != null) {
            for (String str2 : this.zzsQ.zzSj) {
                if (!TextUtils.isEmpty(str2)) {
                    zzv.zzcJ().zzc(this.mContext, "", str2.replace("{NAVIGATION_URL}", Uri.encode(str)));
                }
            }
        }
    }
}
