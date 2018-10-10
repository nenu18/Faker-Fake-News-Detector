package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf.zza;
import java.lang.reflect.InvocationTargetException;

public class zzbu extends zzby {
    private static final Object zzqW = new Object();
    private static volatile Long zzrf = null;

    public zzbu(zzbc zzbc, String str, String str2, zza zza, int i, int i2) {
        super(zzbc, str, str2, zza, i, i2);
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        if (zzrf == null) {
            synchronized (zzqW) {
                if (zzrf == null) {
                    zzrf = (Long) this.zzrj.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzra) {
            this.zzra.zzby = zzrf;
        }
    }
}
