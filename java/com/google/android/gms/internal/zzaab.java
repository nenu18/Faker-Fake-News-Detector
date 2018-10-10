package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.internal.zzg;

public final class zzaab<O extends ApiOptions> extends zzc<O> {
    private final zza<? extends zzaxn, zzaxo> zzaxY;
    private final zze zzazq;
    private final zzzy zzazr;
    private final zzg zzazs;

    public zzaab(@NonNull Context context, Api<O> api, Looper looper, @NonNull zze zze, @NonNull zzzy zzzy, zzg zzg, zza<? extends zzaxn, zzaxo> zza) {
        super(context, api, looper);
        this.zzazq = zze;
        this.zzazr = zzzy;
        this.zzazs = zzg;
        this.zzaxY = zza;
        this.zzaxK.zza((zzc) this);
    }

    public zze buildApiClient(Looper looper, zzaap.zza<O> zza) {
        this.zzazr.zza(zza);
        return this.zzazq;
    }

    public zzabj createSignInCoordinator(Context context, Handler handler) {
        return new zzabj(context, handler, this.zzazs, this.zzaxY);
    }

    public zze zzvr() {
        return this.zzazq;
    }
}
