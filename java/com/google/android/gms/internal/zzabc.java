package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

public final class zzabc<R extends Result> extends OptionalPendingResult<R> {
    private final zzzx<R> zzaBC;

    public zzabc(PendingResult<R> pendingResult) {
        if (pendingResult instanceof zzzx) {
            this.zzaBC = (zzzx) pendingResult;
            return;
        }
        throw new IllegalArgumentException("OptionalPendingResult can only wrap PendingResults generated by an API call.");
    }

    public R await() {
        return this.zzaBC.await();
    }

    public R await(long j, TimeUnit timeUnit) {
        return this.zzaBC.await(j, timeUnit);
    }

    public void cancel() {
        this.zzaBC.cancel();
    }

    public R get() {
        if (isDone()) {
            return await(0, TimeUnit.MILLISECONDS);
        }
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    public boolean isCanceled() {
        return this.zzaBC.isCanceled();
    }

    public boolean isDone() {
        return this.zzaBC.isReady();
    }

    public void setResultCallback(ResultCallback<? super R> resultCallback) {
        this.zzaBC.setResultCallback(resultCallback);
    }

    public void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        this.zzaBC.setResultCallback(resultCallback, j, timeUnit);
    }

    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        return this.zzaBC.then(resultTransform);
    }

    public void zza(zza zza) {
        this.zzaBC.zza(zza);
    }

    public Integer zzuR() {
        return this.zzaBC.zzuR();
    }
}
