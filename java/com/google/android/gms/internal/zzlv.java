package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.internal.zzqq.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zzlv {
    private final Context mContext;
    private final zzr zzGl;
    private final zzav zzGr;
    private final zza zzPo;
    private OnGlobalLayoutListener zzQA;
    private OnScrollChangedListener zzQB;
    private final Object zzrN = new Object();
    private final zzgf zzsr;
    private int zzvI = -1;
    private int zzvJ = -1;
    private zzpt zzvK;

    /* renamed from: com.google.android.gms.internal.zzlv$2 */
    class C07682 implements zzhx {
        final /* synthetic */ zzlv zzQE;

        C07682(zzlv zzlv) {
            this.zzQE = zzlv;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            this.zzQE.zzGl.zzcr();
        }
    }

    public zzlv(Context context, zzav zzav, zza zza, zzgf zzgf, zzr zzr) {
        this.mContext = context;
        this.zzGr = zzav;
        this.zzPo = zza;
        this.zzsr = zzgf;
        this.zzGl = zzr;
        this.zzvK = new zzpt(200);
    }

    private OnGlobalLayoutListener zza(final WeakReference<zzqp> weakReference) {
        if (this.zzQA == null) {
            this.zzQA = new OnGlobalLayoutListener(this) {
                final /* synthetic */ zzlv zzQE;

                public void onGlobalLayout() {
                    this.zzQE.zza(weakReference, false);
                }
            };
        }
        return this.zzQA;
    }

    private void zza(WeakReference<zzqp> weakReference, boolean z) {
        if (weakReference != null) {
            zzqp zzqp = (zzqp) weakReference.get();
            if (zzqp != null && zzqp.getView() != null) {
                if (!z || this.zzvK.tryAcquire()) {
                    int[] iArr = new int[2];
                    zzqp.getView().getLocationOnScreen(iArr);
                    int zzc = zzeh.zzeO().zzc(this.mContext, iArr[0]);
                    int zzc2 = zzeh.zzeO().zzc(this.mContext, iArr[1]);
                    synchronized (this.zzrN) {
                        if (!(this.zzvI == zzc && this.zzvJ == zzc2)) {
                            this.zzvI = zzc;
                            this.zzvJ = zzc2;
                            zzqp.zzkV().zza(this.zzvI, this.zzvJ, !z);
                        }
                    }
                }
            }
        }
    }

    private OnScrollChangedListener zzb(final WeakReference<zzqp> weakReference) {
        if (this.zzQB == null) {
            this.zzQB = new OnScrollChangedListener(this) {
                final /* synthetic */ zzlv zzQE;

                public void onScrollChanged() {
                    this.zzQE.zza(weakReference, true);
                }
            };
        }
        return this.zzQB;
    }

    private void zzj(zzqp zzqp) {
        zzqq zzkV = zzqp.zzkV();
        zzkV.zza("/video", zzhw.zzHq);
        zzkV.zza("/videoMeta", zzhw.zzHr);
        zzkV.zza("/precache", zzhw.zzHs);
        zzkV.zza("/delayPageLoaded", zzhw.zzHv);
        zzkV.zza("/instrument", zzhw.zzHt);
        zzkV.zza("/log", zzhw.zzHl);
        zzkV.zza("/videoClicked", zzhw.zzHm);
        zzkV.zza("/trackActiveViewUnit", new C07682(this));
    }

    public zzqf<zzqp> zzf(final JSONObject jSONObject) {
        final zzqf zzqc = new zzqc();
        zzv.zzcJ().runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzlv zzQE;

            /* renamed from: com.google.android.gms.internal.zzlv$1$2 */
            class C07672 implements zzqq.zza {
                final /* synthetic */ C04231 zzQF;

                C07672(C04231 c04231) {
                    this.zzQF = c04231;
                }

                public void zza(zzqp zzqp, boolean z) {
                    this.zzQF.zzQE.zzGl.zzcu();
                    zzqc.zzh(zzqp);
                }
            }

            public void run() {
                try {
                    final zzqp zziU = this.zzQE.zziU();
                    this.zzQE.zzGl.zzc(zziU);
                    WeakReference weakReference = new WeakReference(zziU);
                    zziU.zzkV().zza(this.zzQE.zza(weakReference), this.zzQE.zzb(weakReference));
                    this.zzQE.zzj(zziU);
                    zziU.zzkV().zza(new zzb(this) {
                        final /* synthetic */ C04231 zzQF;

                        public void zzk(zzqp zzqp) {
                            zziU.zza("google.afma.nativeAds.renderVideo", jSONObject);
                        }
                    });
                    zziU.zzkV().zza(new C07672(this));
                    zziU.loadUrl(zzlt.zza(this.zzQE.zzPo, (String) zzfx.zzDS.get()));
                } catch (Throwable e) {
                    zzpy.zzc("Exception occurred while getting video view", e);
                    zzqc.zzh(null);
                }
            }
        });
        return zzqc;
    }

    zzqp zziU() {
        return zzv.zzcK().zza(this.mContext, zzec.zzj(this.mContext), false, false, this.zzGr, this.zzPo.zzSF.zzvf, this.zzsr, null, this.zzGl.zzbz());
    }
}
