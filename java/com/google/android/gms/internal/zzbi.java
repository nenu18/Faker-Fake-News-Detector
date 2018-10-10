package com.google.android.gms.internal;

import com.google.android.gms.internal.zzad.zza;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;

public class zzbi extends zzby {
    private static final Object zzqW = new Object();
    private static volatile zzam zzqX = null;
    private boolean zzqY = false;
    private zza zzqZ = null;

    public zzbi(zzbc zzbc, String str, String str2, zzaf.zza zza, int i, int i2, boolean z, zza zza2) {
        super(zzbc, str, str2, zza, i, i2);
        this.zzqY = z;
        this.zzqZ = zza2;
    }

    public static Boolean zza(zza zza) {
        boolean z = false;
        if (!zzbe.zzs(zzb(zza))) {
            return Boolean.valueOf(false);
        }
        if (!(zza == null || zza.zzaJ == null || zza.zzaJ.zzaL.intValue() != 3)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static String zzb(zza zza) {
        return (zza == null || zza.zzaK == null || zzbe.zzs(zza.zzaK.zzaM)) ? null : zza.zzaK.zzaM;
    }

    private boolean zzbf() {
        return zzqX == null || zzbe.zzs(zzqX.zzaM) || zzqX.zzaM.equals("E");
    }

    private int zzbg() {
        return !zzbe.zzs(zzb(this.zzqZ)) ? 4 : (zza(this.zzqZ).booleanValue() && zzbh()) ? 3 : 2;
    }

    private boolean zzbh() {
        return this.zzpC.zzaR() && ((Boolean) zzfx.zzDF.get()).booleanValue() && ((Boolean) zzfx.zzDG.get()).booleanValue() && ((Boolean) zzfx.zzDD.get()).booleanValue();
    }

    private String zzbi() {
        try {
            if (this.zzpC.zzaT() != null) {
                this.zzpC.zzaT().get();
            }
            zzaf.zza zzaS = this.zzpC.zzaS();
            if (!(zzaS == null || zzaS.zzaM == null)) {
                return zzaS.zzaM;
            }
        } catch (InterruptedException e) {
        } catch (ExecutionException e2) {
        }
        return null;
    }

    private void zze(int i) throws IllegalAccessException, InvocationTargetException {
        boolean z = true;
        Method method = this.zzrj;
        Object[] objArr = new Object[3];
        objArr[0] = this.zzpC.getContext();
        objArr[1] = Boolean.valueOf(this.zzqY);
        if (i != 2) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        zzqX = new zzam((String) method.invoke(null, objArr));
        if (zzbe.zzs(zzqX.zzaM) || zzqX.zzaM.equals("E")) {
            switch (i) {
                case 3:
                    String zzbi = zzbi();
                    if (!zzbe.zzs(zzbi)) {
                        zzqX.zzaM = zzbi;
                        return;
                    }
                    return;
                case 4:
                    zzqX.zzaM = this.zzqZ.zzaK.zzaM;
                    return;
                default:
                    return;
            }
        }
    }

    protected void zzbe() throws IllegalAccessException, InvocationTargetException {
        if (zzbf()) {
            synchronized (zzqW) {
                int zzbg = zzbg();
                if (zzbg == 3) {
                    this.zzpC.zzaW();
                }
                zze(zzbg);
            }
        }
        synchronized (this.zzra) {
            if (zzqX != null) {
                this.zzra.zzaM = zzqX.zzaM;
                this.zzra.zzbz = Long.valueOf(zzqX.zzlH);
                this.zzra.zzaO = zzqX.zzaO;
                if (this.zzqY) {
                    this.zzra.zzaP = zzqX.zzaP;
                    this.zzra.zzaQ = zzqX.zzaQ;
                }
            }
        }
    }
}
