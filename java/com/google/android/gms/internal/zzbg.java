package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf.zza;
import java.lang.reflect.InvocationTargetException;

public class zzbg extends zzby {
    public zzbg(zzbc zzbc, String str, String str2, zza zza, int i, int i2) {
        super(zzbc, str, str2, zza, i, i2);
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzra) {
            this.zzra.zzbb = Long.valueOf(-1);
            this.zzra.zzbb = (Long) this.zzrj.invoke(null, new Object[]{this.zzpC.getContext()});
        }
    }
}
