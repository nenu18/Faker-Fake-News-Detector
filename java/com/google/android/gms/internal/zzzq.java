package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzzq {
    public final int zzanR;

    private static abstract class zza extends zzzq {
        protected final TaskCompletionSource<Void> zzayo;

        public zza(int i, TaskCompletionSource<Void> taskCompletionSource) {
            super(i);
            this.zzayo = taskCompletionSource;
        }

        public void zza(@NonNull zzaad zzaad, boolean z) {
        }

        public final void zza(com.google.android.gms.internal.zzaap.zza<?> zza) throws DeadObjectException {
            try {
                zzb(zza);
            } catch (RemoteException e) {
                zzy(zzzq.zza(e));
                throw e;
            } catch (RemoteException e2) {
                zzy(zzzq.zza(e2));
            }
        }

        protected abstract void zzb(com.google.android.gms.internal.zzaap.zza<?> zza) throws RemoteException;

        public void zzy(@NonNull Status status) {
            this.zzayo.trySetException(new com.google.android.gms.common.api.zza(status));
        }
    }

    public static class zzb<A extends com.google.android.gms.internal.zzzv.zza<? extends Result, com.google.android.gms.common.api.Api.zzb>> extends zzzq {
        protected final A zzayp;

        public zzb(int i, A a) {
            super(i);
            this.zzayp = a;
        }

        public void zza(@NonNull zzaad zzaad, boolean z) {
            zzaad.zza(this.zzayp, z);
        }

        public void zza(com.google.android.gms.internal.zzaap.zza<?> zza) throws DeadObjectException {
            this.zzayp.zzb(zza.zzvr());
        }

        public void zzy(@NonNull Status status) {
            this.zzayp.zzA(status);
        }
    }

    public static final class zzd<TResult> extends zzzq {
        private final TaskCompletionSource<TResult> zzayo;
        private final zzabn<com.google.android.gms.common.api.Api.zzb, TResult> zzays;
        private final zzabk zzayt;

        public zzd(int i, zzabn<com.google.android.gms.common.api.Api.zzb, TResult> zzabn, TaskCompletionSource<TResult> taskCompletionSource, zzabk zzabk) {
            super(i);
            this.zzayo = taskCompletionSource;
            this.zzays = zzabn;
            this.zzayt = zzabk;
        }

        public void zza(@NonNull zzaad zzaad, boolean z) {
            zzaad.zza(this.zzayo, z);
        }

        public void zza(com.google.android.gms.internal.zzaap.zza<?> zza) throws DeadObjectException {
            try {
                this.zzays.zza(zza.zzvr(), this.zzayo);
            } catch (DeadObjectException e) {
                throw e;
            } catch (RemoteException e2) {
                zzy(zzzq.zza(e2));
            }
        }

        public void zzy(@NonNull Status status) {
            this.zzayo.trySetException(this.zzayt.zzz(status));
        }
    }

    public static final class zzc extends zza {
        public final zzabe<com.google.android.gms.common.api.Api.zzb, ?> zzayq;
        public final zzabr<com.google.android.gms.common.api.Api.zzb, ?> zzayr;

        public zzc(zzabf zzabf, TaskCompletionSource<Void> taskCompletionSource) {
            super(3, taskCompletionSource);
            this.zzayq = zzabf.zzayq;
            this.zzayr = zzabf.zzayr;
        }

        public /* bridge */ /* synthetic */ void zza(@NonNull zzaad zzaad, boolean z) {
            super.zza(zzaad, z);
        }

        public void zzb(com.google.android.gms.internal.zzaap.zza<?> zza) throws RemoteException {
            if (this.zzayq.zzwp() != null) {
                zza.zzwc().put(this.zzayq.zzwp(), new zzabf(this.zzayq, this.zzayr));
            }
        }

        public /* bridge */ /* synthetic */ void zzy(@NonNull Status status) {
            super.zzy(status);
        }
    }

    public static final class zze extends zza {
        public final com.google.android.gms.internal.zzaaz.zzb<?> zzayu;

        public zze(com.google.android.gms.internal.zzaaz.zzb<?> zzb, TaskCompletionSource<Void> taskCompletionSource) {
            super(4, taskCompletionSource);
            this.zzayu = zzb;
        }

        public /* bridge */ /* synthetic */ void zza(@NonNull zzaad zzaad, boolean z) {
            super.zza(zzaad, z);
        }

        public void zzb(com.google.android.gms.internal.zzaap.zza<?> zza) throws RemoteException {
            zzabf zzabf = (zzabf) zza.zzwc().remove(this.zzayu);
            if (zzabf != null) {
                zzabf.zzayq.zzwq();
                return;
            }
            Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
            this.zzayo.trySetException(new com.google.android.gms.common.api.zza(Status.zzayj));
        }

        public /* bridge */ /* synthetic */ void zzy(@NonNull Status status) {
            super.zzy(status);
        }
    }

    public zzzq(int i) {
        this.zzanR = i;
    }

    private static Status zza(RemoteException remoteException) {
        StringBuilder stringBuilder = new StringBuilder();
        if (zzs.zzyB() && (remoteException instanceof TransactionTooLargeException)) {
            stringBuilder.append("TransactionTooLargeException: ");
        }
        stringBuilder.append(remoteException.getLocalizedMessage());
        return new Status(8, stringBuilder.toString());
    }

    public abstract void zza(@NonNull zzaad zzaad, boolean z);

    public abstract void zza(com.google.android.gms.internal.zzaap.zza<?> zza) throws DeadObjectException;

    public abstract void zzy(@NonNull Status status);
}
