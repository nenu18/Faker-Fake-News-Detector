package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf.zza;
import java.lang.reflect.InvocationTargetException;

public class zzbh extends zzby {
    private static volatile String zzqV = null;
    private static final Object zzqW = new Object();

    public zzbh(zzbc zzbc, String str, String str2, zza zza, int i, int i2) {
        super(zzbc, str, str2, zza, i, i2);
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        this.zzra.zzbv = "E";
        if (zzqV == null) {
            synchronized (zzqW) {
                if (zzqV == null) {
                    zzqV = (String) this.zzrj.invoke(null, new Object[]{this.zzpC.getContext()});
                }
            }
        }
        synchronized (this.zzra) {
            this.zzra.zzbv = zzal.zza(zzqV.getBytes(), true);
        }
    }
}
