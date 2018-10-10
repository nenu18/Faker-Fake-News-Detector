package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.internal.zzhj.zza;

@zzmb
public class zzho extends zza {
    private final OnAppInstallAdLoadedListener zzGY;

    public zzho(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzGY = onAppInstallAdLoadedListener;
    }

    public void zza(zzhd zzhd) {
        this.zzGY.onAppInstallAdLoaded(zzb(zzhd));
    }

    zzhe zzb(zzhd zzhd) {
        return new zzhe(zzhd);
    }
}
