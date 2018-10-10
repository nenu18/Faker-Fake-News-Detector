package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzg;

public final class zzaxm {
    public static final Api<zzaxo> API = new Api("SignIn.API", zzahd, zzahc);
    public static final Api<zza> zzaJq = new Api("SignIn.INTERNAL_API", zzbCe, zzbCd);
    public static final zzf<zzaxy> zzahc = new zzf();
    public static final com.google.android.gms.common.api.Api.zza<zzaxy, zzaxo> zzahd = new C08181();
    public static final Scope zzajd = new Scope(Scopes.PROFILE);
    public static final Scope zzaje = new Scope("email");
    public static final zzf<zzaxy> zzbCd = new zzf();
    static final com.google.android.gms.common.api.Api.zza<zzaxy, zza> zzbCe = new C08192();

    /* renamed from: com.google.android.gms.internal.zzaxm$1 */
    class C08181 extends com.google.android.gms.common.api.Api.zza<zzaxy, zzaxo> {
        C08181() {
        }

        public zzaxy zza(Context context, Looper looper, zzg zzg, zzaxo zzaxo, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzaxy(context, looper, true, zzg, zzaxo == null ? zzaxo.zzbCg : zzaxo, connectionCallbacks, onConnectionFailedListener);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaxm$2 */
    class C08192 extends com.google.android.gms.common.api.Api.zza<zzaxy, zza> {
        C08192() {
        }

        public zzaxy zza(Context context, Looper looper, zzg zzg, zza zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzaxy(context, looper, false, zzg, zza.zzOd(), connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static class zza implements HasOptions {
        private final Bundle zzbCf;

        public Bundle zzOd() {
            return this.zzbCf;
        }
    }
}
