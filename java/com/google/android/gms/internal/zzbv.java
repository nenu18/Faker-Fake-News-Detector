package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf.zza;
import java.lang.reflect.InvocationTargetException;

public class zzbv extends zzby {
    public zzbv(zzbc zzbc, String str, String str2, zza zza, int i, int i2) {
        super(zzbc, str, str2, zza, i, i2);
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        this.zzra.zzbJ = Integer.valueOf(2);
        boolean booleanValue = ((Boolean) this.zzrj.invoke(null, new Object[]{this.zzpC.getApplicationContext()})).booleanValue();
        synchronized (this.zzra) {
            if (booleanValue) {
                this.zzra.zzbJ = Integer.valueOf(1);
            } else {
                this.zzra.zzbJ = Integer.valueOf(0);
            }
        }
    }
}
