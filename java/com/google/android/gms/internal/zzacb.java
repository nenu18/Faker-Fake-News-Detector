package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzacd.zza;

public class zzacb extends zzl<zzacd> {
    public zzacb(Context context, Looper looper, zzg zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, zzg, connectionCallbacks, onConnectionFailedListener);
    }

    protected zzacd zzbz(IBinder iBinder) {
        return zza.zzbB(iBinder);
    }

    public String zzeu() {
        return "com.google.android.gms.common.service.START";
    }

    protected String zzev() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzbz(iBinder);
    }
}
