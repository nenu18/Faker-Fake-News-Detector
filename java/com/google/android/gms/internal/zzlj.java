package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzqq.zza;
import java.util.concurrent.atomic.AtomicBoolean;

@zzmb
public abstract class zzlj implements zzpk<Void>, zza {
    protected final Context mContext;
    protected final zzqp zzGt;
    protected final zzln.zza zzPn;
    protected final zzov.zza zzPo;
    protected zzmk zzPp;
    private Runnable zzPq;
    protected final Object zzPr = new Object();
    private AtomicBoolean zzPs = new AtomicBoolean(true);

    /* renamed from: com.google.android.gms.internal.zzlj$1 */
    class C04161 implements Runnable {
        final /* synthetic */ zzlj zzPt;

        C04161(zzlj zzlj) {
            this.zzPt = zzlj;
        }

        public void run() {
            if (this.zzPt.zzPs.get()) {
                zzpy.m9e("Timed out waiting for WebView to finish loading.");
                this.zzPt.cancel();
            }
        }
    }

    protected zzlj(Context context, zzov.zza zza, zzqp zzqp, zzln.zza zza2) {
        this.mContext = context;
        this.zzPo = zza;
        this.zzPp = this.zzPo.zzVB;
        this.zzGt = zzqp;
        this.zzPn = zza2;
    }

    private zzov zzP(int i) {
        zzmh zzmh = this.zzPo.zzSF;
        return new zzov(zzmh.zzRd, this.zzGt, this.zzPp.zzJY, i, this.zzPp.zzJZ, this.zzPp.zzRM, this.zzPp.orientation, this.zzPp.zzKe, zzmh.zzRg, this.zzPp.zzRK, null, null, null, null, null, this.zzPp.zzRL, this.zzPo.zzvj, this.zzPp.zzRJ, this.zzPo.zzVv, this.zzPp.zzRO, this.zzPp.zzRP, this.zzPo.zzVp, null, this.zzPp.zzRZ, this.zzPp.zzSa, this.zzPp.zzSb, this.zzPp.zzSc, this.zzPp.zzSd, null, this.zzPp.zzKb, this.zzPp.zzSg);
    }

    public void cancel() {
        if (this.zzPs.getAndSet(false)) {
            this.zzGt.stopLoading();
            zzv.zzcL().zzl(this.zzGt);
            zzO(-1);
            zzpi.zzWR.removeCallbacks(this.zzPq);
        }
    }

    protected void zzO(int i) {
        if (i != -2) {
            this.zzPp = new zzmk(i, this.zzPp.zzKe);
        }
        this.zzGt.zzkQ();
        this.zzPn.zzb(zzP(i));
    }

    public void zza(zzqp zzqp, boolean z) {
        int i = 0;
        zzpy.zzbc("WebView finished loading.");
        if (this.zzPs.getAndSet(false)) {
            if (z) {
                i = zziv();
            }
            zzO(i);
            zzpi.zzWR.removeCallbacks(this.zzPq);
        }
    }

    public final Void zzit() {
        zzac.zzdn("Webview render task needs to be called on UI thread.");
        this.zzPq = new C04161(this);
        zzpi.zzWR.postDelayed(this.zzPq, ((Long) zzfx.zzDe.get()).longValue());
        zziu();
        return null;
    }

    protected abstract void zziu();

    protected int zziv() {
        return -2;
    }

    public /* synthetic */ Object zziw() {
        return zzit();
    }
}
