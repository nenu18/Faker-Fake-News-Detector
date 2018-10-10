package com.google.android.gms.tasks;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzaaw;
import com.google.android.gms.internal.zzaax;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

final class zzh<TResult> extends Task<TResult> {
    private final zzg<TResult> zzbLH = new zzg();
    private boolean zzbLI;
    private TResult zzbLJ;
    private Exception zzbLK;
    private final Object zzrN = new Object();

    private static class zza extends zzaaw {
        private final List<WeakReference<zzf<?>>> mListeners = new ArrayList();

        private zza(zzaax zzaax) {
            super(zzaax);
            this.zzaBs.zza("TaskOnStopCallback", (zzaaw) this);
        }

        public static zza zzw(Activity activity) {
            zzaax zzs = zzaaw.zzs(activity);
            zza zza = (zza) zzs.zza("TaskOnStopCallback", zza.class);
            return zza == null ? new zza(zzs) : zza;
        }

        @MainThread
        public void onStop() {
            synchronized (this.mListeners) {
                for (WeakReference weakReference : this.mListeners) {
                    zzf zzf = (zzf) weakReference.get();
                    if (zzf != null) {
                        zzf.cancel();
                    }
                }
                this.mListeners.clear();
            }
        }

        public <T> void zzb(zzf<T> zzf) {
            synchronized (this.mListeners) {
                this.mListeners.add(new WeakReference(zzf));
            }
        }
    }

    zzh() {
    }

    private void zzSe() {
        zzac.zza(this.zzbLI, (Object) "Task is not yet complete");
    }

    private void zzSf() {
        zzac.zza(!this.zzbLI, (Object) "Task is already complete");
    }

    private void zzSg() {
        synchronized (this.zzrN) {
            if (this.zzbLI) {
                this.zzbLH.zza((Task) this);
                return;
            }
        }
    }

    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        zzf zzc = new zzc(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.zzbLH.zza(zzc);
        zza.zzw(activity).zzb(zzc);
        zzSg();
        return this;
    }

    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, (OnCompleteListener) onCompleteListener);
    }

    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzbLH.zza(new zzc(executor, onCompleteListener));
        zzSg();
        return this;
    }

    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        zzf zzd = new zzd(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.zzbLH.zza(zzd);
        zza.zzw(activity).zzb(zzd);
        zzSg();
        return this;
    }

    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zzbLH.zza(new zzd(executor, onFailureListener));
        zzSg();
        return this;
    }

    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zzf zze = new zze(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.zzbLH.zza(zze);
        zza.zzw(activity).zzb(zze);
        zzSg();
        return this;
    }

    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener) onSuccessListener);
    }

    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzbLH.zza(new zze(executor, onSuccessListener));
        zzSg();
        return this;
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        Task zzh = new zzh();
        this.zzbLH.zza(new zza(executor, continuation, zzh));
        zzSg();
        return zzh;
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        Task zzh = new zzh();
        this.zzbLH.zza(new zzb(executor, continuation, zzh));
        zzSg();
        return zzh;
    }

    @Nullable
    public Exception getException() {
        Exception exception;
        synchronized (this.zzrN) {
            exception = this.zzbLK;
        }
        return exception;
    }

    public TResult getResult() {
        TResult tResult;
        synchronized (this.zzrN) {
            zzSe();
            if (this.zzbLK != null) {
                throw new RuntimeExecutionException(this.zzbLK);
            }
            tResult = this.zzbLJ;
        }
        return tResult;
    }

    public <X extends Throwable> TResult getResult(@NonNull Class<X> cls) throws Throwable {
        TResult tResult;
        synchronized (this.zzrN) {
            zzSe();
            if (cls.isInstance(this.zzbLK)) {
                throw ((Throwable) cls.cast(this.zzbLK));
            } else if (this.zzbLK != null) {
                throw new RuntimeExecutionException(this.zzbLK);
            } else {
                tResult = this.zzbLJ;
            }
        }
        return tResult;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzbLI;
        }
        return z;
    }

    public boolean isSuccessful() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzbLI && this.zzbLK == null;
        }
        return z;
    }

    public void setException(@NonNull Exception exception) {
        zzac.zzb((Object) exception, (Object) "Exception must not be null");
        synchronized (this.zzrN) {
            zzSf();
            this.zzbLI = true;
            this.zzbLK = exception;
        }
        this.zzbLH.zza((Task) this);
    }

    public void setResult(TResult tResult) {
        synchronized (this.zzrN) {
            zzSf();
            this.zzbLI = true;
            this.zzbLJ = tResult;
        }
        this.zzbLH.zza((Task) this);
    }

    public boolean trySetException(@NonNull Exception exception) {
        boolean z = true;
        zzac.zzb((Object) exception, (Object) "Exception must not be null");
        synchronized (this.zzrN) {
            if (this.zzbLI) {
                z = false;
            } else {
                this.zzbLI = true;
                this.zzbLK = exception;
                this.zzbLH.zza((Task) this);
            }
        }
        return z;
    }

    public boolean trySetResult(TResult tResult) {
        boolean z = true;
        synchronized (this.zzrN) {
            if (this.zzbLI) {
                z = false;
            } else {
                this.zzbLI = true;
                this.zzbLJ = tResult;
                this.zzbLH.zza((Task) this);
            }
        }
        return z;
    }
}
