package com.google.android.gms.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.zzaf.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class zzbm extends zzby {
    public zzbm(zzbc zzbc, String str, String str2, zza zza, int i, int i2) {
        super(zzbc, str, str2, zza, i, i2);
    }

    private void zzbj() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzra) {
            this.zzra.zzbV = (String) this.zzrj.invoke(null, new Object[]{this.zzpC.getApplicationContext()});
        }
    }

    private void zzbk() {
        AdvertisingIdClient zzaZ = this.zzpC.zzaZ();
        if (zzaZ != null) {
            try {
                Info info = zzaZ.getInfo();
                String zzr = zzbe.zzr(info.getId());
                if (zzr != null) {
                    synchronized (this.zzra) {
                        this.zzra.zzbV = zzr;
                        this.zzra.zzbX = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                        this.zzra.zzbW = Integer.valueOf(5);
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        if (this.zzpC.zzaO()) {
            zzbk();
        } else {
            zzbj();
        }
    }
}
