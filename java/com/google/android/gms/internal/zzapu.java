package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;
import com.google.android.gms.internal.zzapz.zza;

public class zzapu extends zzf<zzapz> {
    public zzapu(Context context, Looper looper, zzb zzb, zzc zzc) {
        super(context, looper, 116, zzb, zzc, null);
    }

    public zzapz zzFX() throws DeadObjectException {
        return (zzapz) super.zzwW();
    }

    protected zzapz zzcT(IBinder iBinder) {
        return zza.zzcU(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.gms.gass.START";
    }

    protected String zzev() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzcT(iBinder);
    }
}
