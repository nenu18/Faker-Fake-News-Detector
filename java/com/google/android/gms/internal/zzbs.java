package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf.zza;
import java.lang.reflect.InvocationTargetException;

public class zzbs extends zzby {
    private final StackTraceElement[] zzre;

    public zzbs(zzbc zzbc, String str, String str2, zza zza, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzbc, str, str2, zza, i, i2);
        this.zzre = stackTraceElementArr;
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        if (this.zzre != null) {
            zzba zzba = new zzba((String) this.zzrj.invoke(null, new Object[]{this.zzre}));
            synchronized (this.zzra) {
                this.zzra.zzbI = zzba.zzqm;
                if (zzba.zzqn.booleanValue()) {
                    this.zzra.zzbQ = Integer.valueOf(zzba.zzqo.booleanValue() ? 0 : 1);
                }
            }
        }
    }
}
