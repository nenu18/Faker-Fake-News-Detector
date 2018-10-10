package com.google.android.gms.internal;

import android.os.Build.VERSION;
import android.os.ConditionVariable;
import com.google.android.gms.internal.zzae.zza;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadLocalRandom;

public class zzap {
    private static final ConditionVariable zzpD = new ConditionVariable();
    protected static volatile zzzf zzpE = null;
    private static volatile Random zzpG = null;
    private zzbc zzpC;
    protected Boolean zzpF;

    /* renamed from: com.google.android.gms.internal.zzap$1 */
    class C03001 implements Runnable {
        final /* synthetic */ zzap zzpH;

        C03001(zzap zzap) {
            this.zzpH = zzap;
        }

        public void run() {
            if (this.zzpH.zzpF == null) {
                synchronized (zzap.zzpD) {
                    if (this.zzpH.zzpF != null) {
                        return;
                    }
                    boolean booleanValue = ((Boolean) zzfx.zzDf.get()).booleanValue();
                    if (booleanValue) {
                        zzap.zzpE = new zzzf(this.zzpH.zzpC.getContext(), "ADSHIELD", null);
                    }
                    this.zzpH.zzpF = Boolean.valueOf(booleanValue);
                    zzap.zzpD.open();
                }
            }
        }
    }

    public zzap(zzbc zzbc) {
        this.zzpC = zzbc;
        zza(zzbc.zzaJ());
    }

    private static Random zzU() {
        if (zzpG == null) {
            synchronized (zzap.class) {
                if (zzpG == null) {
                    zzpG = new Random();
                }
            }
        }
        return zzpG;
    }

    private void zza(Executor executor) {
        executor.execute(new C03001(this));
    }

    public int zzT() {
        try {
            return VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : zzU().nextInt();
        } catch (RuntimeException e) {
            return zzU().nextInt();
        }
    }

    public void zza(int i, int i2, long j) throws IOException {
        try {
            zzpD.block();
            if (this.zzpF.booleanValue() && zzpE != null && this.zzpC.zzaP()) {
                zzbut zza = new zza();
                zza.zzaR = this.zzpC.getContext().getPackageName();
                zza.zzaS = Long.valueOf(j);
                zzzf.zza zzm = zzpE.zzm(zzbut.zzf(zza));
                zzm.zzco(i2);
                zzm.zzcn(i);
                zzm.zze(this.zzpC.zzaN());
            }
        } catch (Exception e) {
        }
    }
}
