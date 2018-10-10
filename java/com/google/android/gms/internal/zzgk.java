package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.internal.zzgj.zza;

@zzmb
public final class zzgk extends zza {
    private final OnCustomRenderedAdLoadedListener zzAb;

    public zzgk(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzAb = onCustomRenderedAdLoadedListener;
    }

    public void zza(zzgi zzgi) {
        this.zzAb.onCustomRenderedAdLoaded(new zzgh(zzgi));
    }
}
