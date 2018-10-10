package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf.zza;
import java.lang.reflect.InvocationTargetException;

public class zzbo extends zzby {
    private static final Object zzqW = new Object();
    private static volatile Long zzrb = null;

    public zzbo(zzbc zzbc, String str, String str2, zza zza, int i, int i2) {
        super(zzbc, str, str2, zza, i, i2);
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        if (zzrb == null) {
            synchronized (zzqW) {
                if (zzrb == null) {
                    zzrb = (Long) this.zzrj.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzra) {
            this.zzra.zzbt = zzrb;
        }
    }
}
