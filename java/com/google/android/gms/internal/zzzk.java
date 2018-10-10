package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzzn.zza;

public class zzzk extends zzl<zzzn> {
    public zzzk(Context context, Looper looper, zzg zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 40, zzg, connectionCallbacks, onConnectionFailedListener);
    }

    public void zza(zzzm zzzm, zzzh zzzh) throws RemoteException {
        ((zzzn) zzwW()).zza(zzzm, zzzh);
    }

    protected zzzn zzbm(IBinder iBinder) {
        return zza.zzbo(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.gms.clearcut.service.START";
    }

    protected String zzev() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzbm(iBinder);
    }
}
