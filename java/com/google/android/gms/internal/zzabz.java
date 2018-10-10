package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzzv.zzb;

public final class zzabz implements zzaby {

    private static class zza extends zzabw {
        private final zzb<Status> zzaFq;

        public zza(zzb<Status> zzb) {
            this.zzaFq = zzb;
        }

        public void zzcX(int i) throws RemoteException {
            this.zzaFq.setResult(new Status(i));
        }
    }

    public PendingResult<Status> zzg(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            protected void zza(zzacb zzacb) throws RemoteException {
                ((zzacd) zzacb.zzwW()).zza(new zza(this));
            }
        });
    }
}
