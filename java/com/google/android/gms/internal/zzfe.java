package com.google.android.gms.internal;

import android.os.RemoteException;

public class zzfe extends com.google.android.gms.internal.zzen.zza {
    private zzel zzti;

    private class zza extends com.google.android.gms.internal.zzem.zza {
        final /* synthetic */ zzfe zzAm;

        /* renamed from: com.google.android.gms.internal.zzfe$zza$1 */
        class C03661 implements Runnable {
            final /* synthetic */ zza zzAn;

            C03661(zza zza) {
                this.zzAn = zza;
            }

            public void run() {
                if (this.zzAn.zzAm.zzti != null) {
                    try {
                        this.zzAn.zzAm.zzti.onAdFailedToLoad(1);
                    } catch (Throwable e) {
                        zzpy.zzc("Could not notify onAdFailedToLoad event.", e);
                    }
                }
            }
        }

        private zza(zzfe zzfe) {
            this.zzAm = zzfe;
        }

        public String getMediationAdapterClassName() throws RemoteException {
            return null;
        }

        public boolean isLoading() throws RemoteException {
            return false;
        }

        public void zzf(zzdy zzdy) throws RemoteException {
            zzpy.m9e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
            zzpx.zzXU.post(new C03661(this));
        }
    }

    public void zza(zzgw zzgw) throws RemoteException {
    }

    public void zza(zzhj zzhj) throws RemoteException {
    }

    public void zza(zzhk zzhk) throws RemoteException {
    }

    public void zza(String str, zzhm zzhm, zzhl zzhl) throws RemoteException {
    }

    public void zzb(zzel zzel) throws RemoteException {
        this.zzti = zzel;
    }

    public void zzb(zzet zzet) throws RemoteException {
    }

    public zzem zzci() throws RemoteException {
        return new zza();
    }
}
