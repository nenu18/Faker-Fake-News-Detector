package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.zzac;

@zzmb
public class zzpq {
    private Handler mHandler = null;
    private HandlerThread zzXF = null;
    private int zzXG = 0;
    private final Object zzrN = new Object();

    /* renamed from: com.google.android.gms.internal.zzpq$1 */
    class C04601 implements Runnable {
        final /* synthetic */ zzpq zzXH;

        C04601(zzpq zzpq) {
            this.zzXH = zzpq;
        }

        public void run() {
            synchronized (this.zzXH.zzrN) {
                zzpe.m13v("Suspending the looper thread");
                while (this.zzXH.zzXG == 0) {
                    try {
                        this.zzXH.zzrN.wait();
                        zzpe.m13v("Looper thread resumed");
                    } catch (InterruptedException e) {
                        zzpe.m13v("Looper thread interrupted.");
                    }
                }
            }
        }
    }

    public Looper zzkC() {
        Looper looper;
        synchronized (this.zzrN) {
            if (this.zzXG != 0) {
                zzac.zzb(this.zzXF, (Object) "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzXF == null) {
                zzpe.m13v("Starting the looper thread.");
                this.zzXF = new HandlerThread("LooperProvider");
                this.zzXF.start();
                this.mHandler = new Handler(this.zzXF.getLooper());
                zzpe.m13v("Looper thread started.");
            } else {
                zzpe.m13v("Resuming the looper thread");
                this.zzrN.notifyAll();
            }
            this.zzXG++;
            looper = this.zzXF.getLooper();
        }
        return looper;
    }

    public void zzkD() {
        synchronized (this.zzrN) {
            zzac.zzb(this.zzXG > 0, (Object) "Invalid state: release() called more times than expected.");
            int i = this.zzXG - 1;
            this.zzXG = i;
            if (i == 0) {
                this.mHandler.post(new C04601(this));
            }
        }
    }
}
