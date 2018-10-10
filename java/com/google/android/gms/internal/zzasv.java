package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzac;

abstract class zzasv {
    private static volatile Handler zzaec;
    private volatile long zzaed;
    private final zzatp zzbpw;
    private boolean zzbqB = true;
    private final Runnable zzv = new C03051(this);

    /* renamed from: com.google.android.gms.internal.zzasv$1 */
    class C03051 implements Runnable {
        final /* synthetic */ zzasv zzbqC;

        C03051(zzasv zzasv) {
            this.zzbqC = zzasv;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.zzbqC.zzbpw.zzJs().zzm(this);
                return;
            }
            boolean zzcv = this.zzbqC.zzcv();
            this.zzbqC.zzaed = 0;
            if (zzcv && this.zzbqC.zzbqB) {
                this.zzbqC.run();
            }
        }
    }

    zzasv(zzatp zzatp) {
        zzac.zzw(zzatp);
        this.zzbpw = zzatp;
    }

    private Handler getHandler() {
        if (zzaec != null) {
            return zzaec;
        }
        Handler handler;
        synchronized (zzasv.class) {
            if (zzaec == null) {
                zzaec = new Handler(this.zzbpw.getContext().getMainLooper());
            }
            handler = zzaec;
        }
        return handler;
    }

    public void cancel() {
        this.zzaed = 0;
        getHandler().removeCallbacks(this.zzv);
    }

    public abstract void run();

    public boolean zzcv() {
        return this.zzaed != 0;
    }

    public void zzx(long j) {
        cancel();
        if (j >= 0) {
            this.zzaed = this.zzbpw.zznq().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzv, j)) {
                this.zzbpw.zzJt().zzLa().zzj("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }
}
