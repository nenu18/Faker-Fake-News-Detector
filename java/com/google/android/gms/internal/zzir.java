package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;

@zzmb
class zzir {
    @Nullable
    zzer zzIt;
    @Nullable
    zzkz zzIu;
    @Nullable
    zzgj zzIv;
    @Nullable
    zzek zzIw;
    @Nullable
    zznt zzIx;
    @Nullable
    zzel zzti;

    private static class zza extends com.google.android.gms.internal.zzel.zza {
        private final zzel zzIy;

        zza(zzel zzel) {
            this.zzIy = zzel;
        }

        public void onAdClosed() throws RemoteException {
            this.zzIy.onAdClosed();
            zzv.zzcY().zzgj();
        }

        public void onAdFailedToLoad(int i) throws RemoteException {
            this.zzIy.onAdFailedToLoad(i);
        }

        public void onAdLeftApplication() throws RemoteException {
            this.zzIy.onAdLeftApplication();
        }

        public void onAdLoaded() throws RemoteException {
            this.zzIy.onAdLoaded();
        }

        public void onAdOpened() throws RemoteException {
            this.zzIy.onAdOpened();
        }
    }

    zzir() {
    }

    void zzc(zzl zzl) {
        if (this.zzti != null) {
            zzl.zza(new zza(this.zzti));
        }
        if (this.zzIt != null) {
            zzl.zza(this.zzIt);
        }
        if (this.zzIu != null) {
            zzl.zza(this.zzIu);
        }
        if (this.zzIv != null) {
            zzl.zza(this.zzIv);
        }
        if (this.zzIw != null) {
            zzl.zza(this.zzIw);
        }
        if (this.zzIx != null) {
            zzl.zza(this.zzIx);
        }
    }
}
