package com.google.android.gms.internal;

import java.util.concurrent.Future;

@zzmb
public abstract class zzpd implements zzpk<Future> {
    private volatile Thread zzWx;
    private boolean zzWy;
    private final Runnable zzv;

    /* renamed from: com.google.android.gms.internal.zzpd$1 */
    class C04451 implements Runnable {
        final /* synthetic */ zzpd zzWz;

        C04451(zzpd zzpd) {
            this.zzWz = zzpd;
        }

        public final void run() {
            this.zzWz.zzWx = Thread.currentThread();
            this.zzWz.zzcm();
        }
    }

    public zzpd() {
        this.zzv = new C04451(this);
        this.zzWy = false;
    }

    public zzpd(boolean z) {
        this.zzv = new C04451(this);
        this.zzWy = z;
    }

    public final void cancel() {
        onStop();
        if (this.zzWx != null) {
            this.zzWx.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzcm();

    public /* synthetic */ Object zziw() {
        return zzkf();
    }

    public final Future zzkf() {
        return this.zzWy ? zzph.zza(1, this.zzv) : zzph.zza(this.zzv);
    }
}
