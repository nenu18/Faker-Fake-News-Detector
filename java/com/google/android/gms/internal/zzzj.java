package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc;

public class zzzj extends zzc<NoOptions> implements zzzg {

    static final class zza extends com.google.android.gms.internal.zzzv.zza<Status, zzzk> {
        private final zzzh zzawO;

        /* renamed from: com.google.android.gms.internal.zzzj$zza$1 */
        class C08301 extends com.google.android.gms.internal.zzzm.zza {
            final /* synthetic */ zza zzawP;

            C08301(zza zza) {
                this.zzawP = zza;
            }

            public void zzv(Status status) {
                this.zzawP.zzb(status);
            }

            public void zzw(Status status) {
                throw new UnsupportedOperationException();
            }
        }

        zza(zzzh zzzh, GoogleApiClient googleApiClient) {
            super(zzzf.API, googleApiClient);
            this.zzawO = zzzh;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            return this.zzawO.equals(((zza) obj).zzawO);
        }

        public String toString() {
            String valueOf = String.valueOf(this.zzawO);
            return new StringBuilder(String.valueOf(valueOf).length() + 20).append("LogEventMethodImpl(").append(valueOf).append(")").toString();
        }

        protected void zza(zzzk zzzk) throws RemoteException {
            zzzm c08301 = new C08301(this);
            try {
                zzzj.zzb(this.zzawO);
                zzzk.zza(c08301, this.zzawO);
            } catch (Throwable e) {
                Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e);
                zzA(new Status(10, "MessageProducer"));
            }
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    zzzj(@NonNull Context context) {
        super(context, zzzf.API, null, new zzzr());
    }

    public static zzzg zzai(@NonNull Context context) {
        return new zzzj(context);
    }

    static void zzb(zzzh zzzh) {
        if (zzzh.zzawM != null && zzzh.zzawL.zzcsF.length == 0) {
            zzzh.zzawL.zzcsF = zzzh.zzawM.zzuw();
        }
        if (zzzh.zzawN != null && zzzh.zzawL.zzcsL.length == 0) {
            zzzh.zzawL.zzcsL = zzzh.zzawN.zzuw();
        }
        zzzh.zzawF = zzbut.zzf(zzzh.zzawL);
    }

    public PendingResult<Status> zza(zzzh zzzh) {
        return doBestEffortWrite(new zza(zzzh, asGoogleApiClient()));
    }
}
