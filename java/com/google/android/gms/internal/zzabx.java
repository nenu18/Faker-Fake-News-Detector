package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;

public final class zzabx {
    public static final Api<NoOptions> API = new Api("Common.API", zzahd, zzahc);
    public static final zzaby zzaFp = new zzabz();
    public static final zzf<zzacb> zzahc = new zzf();
    private static final zza<zzacb, NoOptions> zzahd = new C08171();

    /* renamed from: com.google.android.gms.internal.zzabx$1 */
    class C08171 extends zza<zzacb, NoOptions> {
        C08171() {
        }

        public /* synthetic */ zze zza(Context context, Looper looper, zzg zzg, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzf(context, looper, zzg, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzacb zzf(Context context, Looper looper, zzg zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzacb(context, looper, zzg, connectionCallbacks, onConnectionFailedListener);
        }
    }
}
