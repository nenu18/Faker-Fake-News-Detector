package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;
import com.google.android.gms.common.internal.zzm.zza;
import java.util.Set;

public abstract class zzl<T extends IInterface> extends zzf<T> implements zze, zza {
    private final Account zzagg;
    private final Set<Scope> zzajm;
    private final zzg zzazs;

    /* renamed from: com.google.android.gms.common.internal.zzl$1 */
    class C06301 implements zzb {
        final /* synthetic */ ConnectionCallbacks zzaEu;

        C06301(ConnectionCallbacks connectionCallbacks) {
            this.zzaEu = connectionCallbacks;
        }

        public void onConnected(@Nullable Bundle bundle) {
            this.zzaEu.onConnected(bundle);
        }

        public void onConnectionSuspended(int i) {
            this.zzaEu.onConnectionSuspended(i);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zzl$2 */
    class C06312 implements zzc {
        final /* synthetic */ OnConnectionFailedListener zzaEv;

        C06312(OnConnectionFailedListener onConnectionFailedListener) {
            this.zzaEv = onConnectionFailedListener;
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            this.zzaEv.onConnectionFailed(connectionResult);
        }
    }

    protected zzl(Context context, Looper looper, int i, zzg zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzn.zzaC(context), GoogleApiAvailability.getInstance(), i, zzg, (ConnectionCallbacks) zzac.zzw(connectionCallbacks), (OnConnectionFailedListener) zzac.zzw(onConnectionFailedListener));
    }

    protected zzl(Context context, Looper looper, zzn zzn, GoogleApiAvailability googleApiAvailability, int i, zzg zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, zzn, googleApiAvailability, i, zza(connectionCallbacks), zza(onConnectionFailedListener), zzg.zzxi());
        this.zzazs = zzg;
        this.zzagg = zzg.getAccount();
        this.zzajm = zzb(zzg.zzxf());
    }

    @Nullable
    private static zzb zza(ConnectionCallbacks connectionCallbacks) {
        return connectionCallbacks == null ? null : new C06301(connectionCallbacks);
    }

    @Nullable
    private static zzc zza(OnConnectionFailedListener onConnectionFailedListener) {
        return onConnectionFailedListener == null ? null : new C06312(onConnectionFailedListener);
    }

    private Set<Scope> zzb(@NonNull Set<Scope> set) {
        Set<Scope> zzc = zzc(set);
        for (Scope contains : zzc) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zzc;
    }

    public final Account getAccount() {
        return this.zzagg;
    }

    @NonNull
    protected Set<Scope> zzc(@NonNull Set<Scope> set) {
        return set;
    }

    protected final Set<Scope> zzwY() {
        return this.zzajm;
    }

    protected final zzg zzxp() {
        return this.zzazs;
    }
}
