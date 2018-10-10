package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

public class zzab {
    private static final zzb zzaEZ = new C06241();

    public interface zza<R extends Result, T> {
        T zzf(R r);
    }

    public interface zzb {
        com.google.android.gms.common.api.zza zzG(Status status);
    }

    /* renamed from: com.google.android.gms.common.internal.zzab$1 */
    class C06241 implements zzb {
        C06241() {
        }

        public com.google.android.gms.common.api.zza zzG(Status status) {
            return zzb.zzF(status);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zzab$2 */
    class C06252 implements com.google.android.gms.common.api.PendingResult.zza {
        final /* synthetic */ PendingResult zzaFa;
        final /* synthetic */ TaskCompletionSource zzaFb;
        final /* synthetic */ zza zzaFc;
        final /* synthetic */ zzb zzaFd;

        C06252(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, zza zza, zzb zzb) {
            this.zzaFa = pendingResult;
            this.zzaFb = taskCompletionSource;
            this.zzaFc = zza;
            this.zzaFd = zzb;
        }

        public void zzx(Status status) {
            if (status.isSuccess()) {
                this.zzaFb.setResult(this.zzaFc.zzf(this.zzaFa.await(0, TimeUnit.MILLISECONDS)));
                return;
            }
            this.zzaFb.setException(this.zzaFd.zzG(status));
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zzab$3 */
    class C06263 implements zza<R, T> {
        final /* synthetic */ zze zzaFe;

        C06263(zze zze) {
            this.zzaFe = zze;
        }

        public T zze(R r) {
            this.zzaFe.zzb(r);
            return this.zzaFe;
        }

        public /* synthetic */ Object zzf(Result result) {
            return zze(result);
        }
    }

    public static <R extends Result, T extends zze<R>> Task<T> zza(PendingResult<R> pendingResult, T t) {
        return zza((PendingResult) pendingResult, new C06263(t));
    }

    public static <R extends Result, T> Task<T> zza(PendingResult<R> pendingResult, zza<R, T> zza) {
        return zza(pendingResult, zza, zzaEZ);
    }

    public static <R extends Result, T> Task<T> zza(PendingResult<R> pendingResult, zza<R, T> zza, zzb zzb) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.zza(new C06252(pendingResult, taskCompletionSource, zza, zzb));
        return taskCompletionSource.getTask();
    }
}
