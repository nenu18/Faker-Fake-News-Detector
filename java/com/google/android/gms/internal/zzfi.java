package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zznr.zza;

public class zzfi extends zza {
    private zznt zzAp;

    /* renamed from: com.google.android.gms.internal.zzfi$1 */
    class C03681 implements Runnable {
        final /* synthetic */ zzfi zzAq;

        C03681(zzfi zzfi) {
            this.zzAq = zzfi;
        }

        public void run() {
            if (this.zzAq.zzAp != null) {
                try {
                    this.zzAq.zzAp.onRewardedVideoAdFailedToLoad(1);
                } catch (Throwable e) {
                    zzpy.zzc("Could not notify onRewardedVideoAdFailedToLoad event.", e);
                }
            }
        }
    }

    public void destroy() throws RemoteException {
    }

    public boolean isLoaded() throws RemoteException {
        return false;
    }

    public void pause() throws RemoteException {
    }

    public void resume() throws RemoteException {
    }

    public void setUserId(String str) throws RemoteException {
    }

    public void show() throws RemoteException {
    }

    public void zza(zznt zznt) throws RemoteException {
        this.zzAp = zznt;
    }

    public void zza(zznx zznx) throws RemoteException {
        zzpy.m9e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzpx.zzXU.post(new C03681(this));
    }

    public void zzf(zzd zzd) throws RemoteException {
    }

    public void zzg(zzd zzd) throws RemoteException {
    }

    public void zzh(zzd zzd) throws RemoteException {
    }
}
