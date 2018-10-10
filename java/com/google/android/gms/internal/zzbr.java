package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf.zza;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class zzbr extends zzby {
    private List<Long> zzrd = null;

    public zzbr(zzbc zzbc, String str, String str2, zza zza, int i, int i2) {
        super(zzbc, str, str2, zza, i, i2);
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        this.zzra.zzbw = Long.valueOf(-1);
        this.zzra.zzbx = Long.valueOf(-1);
        if (this.zzrd == null) {
            this.zzrd = (List) this.zzrj.invoke(null, new Object[]{this.zzpC.getContext()});
        }
        if (this.zzrd != null && this.zzrd.size() == 2) {
            synchronized (this.zzra) {
                this.zzra.zzbw = Long.valueOf(((Long) this.zzrd.get(0)).longValue());
                this.zzra.zzbx = Long.valueOf(((Long) this.zzrd.get(1)).longValue());
            }
        }
    }
}
