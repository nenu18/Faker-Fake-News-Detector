package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;
import com.google.android.gms.internal.zzmq.zza;

@zzmb
public class zzmg extends zzf<zzmq> {
    final int zzRb;

    public zzmg(Context context, Looper looper, zzb zzb, zzc zzc, int i) {
        super(context, looper, 8, zzb, zzc, null);
        this.zzRb = i;
    }

    protected zzmq zzad(IBinder iBinder) {
        return zza.zzae(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.gms.ads.service.START";
    }

    protected String zzev() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzad(iBinder);
    }

    public zzmq zzjb() throws DeadObjectException {
        return (zzmq) super.zzwW();
    }
}
