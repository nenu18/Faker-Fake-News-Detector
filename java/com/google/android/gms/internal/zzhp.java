package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.internal.zzhk.zza;

@zzmb
public class zzhp extends zza {
    private final OnContentAdLoadedListener zzGZ;

    public zzhp(OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzGZ = onContentAdLoadedListener;
    }

    public void zza(zzhf zzhf) {
        this.zzGZ.onContentAdLoaded(zzb(zzhf));
    }

    zzhg zzb(zzhf zzhf) {
        return new zzhg(zzhf);
    }
}
