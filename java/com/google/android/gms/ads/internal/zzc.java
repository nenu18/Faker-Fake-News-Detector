package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzgi;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzkp;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzop;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqp;
import java.util.Map;

@zzmb
public abstract class zzc extends zzb implements zzh, zzkp {

    /* renamed from: com.google.android.gms.ads.internal.zzc$1 */
    class C06111 implements zzhx {
        final /* synthetic */ zzc zzsH;

        C06111(zzc zzc) {
            this.zzsH = zzc;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            if (this.zzsH.zzsw.zzvk != null) {
                this.zzsH.zzsy.zza(this.zzsH.zzsw.zzvj, this.zzsH.zzsw.zzvk, zzqp.getView(), (zzjb) zzqp);
            } else {
                zzpy.zzbe("Request to enable ActiveView before adState is available.");
            }
        }
    }

    public zzc(Context context, zzec zzec, String str, zzjs zzjs, zzqa zzqa, zzd zzd) {
        super(context, zzec, str, zzjs, zzqa, zzd);
    }

    protected zzqp zza(zza zza, @Nullable zze zze, @Nullable zzop zzop) {
        zzqp zzqp = null;
        View nextView = this.zzsw.zzvg.getNextView();
        if (nextView instanceof zzqp) {
            zzqp = (zzqp) nextView;
            if (((Boolean) zzfx.zzCn.get()).booleanValue()) {
                zzpy.zzbc("Reusing webview...");
                zzqp.zza(this.zzsw.zzqr, this.zzsw.zzvj, this.zzsr);
            } else {
                zzqp.destroy();
                zzqp = null;
            }
        }
        if (zzqp == null) {
            if (nextView != null) {
                this.zzsw.zzvg.removeView(nextView);
            }
            zzqp = zzv.zzcK().zza(this.zzsw.zzqr, this.zzsw.zzvj, false, false, this.zzsw.zzve, this.zzsw.zzvf, this.zzsr, this, this.zzsz);
            if (this.zzsw.zzvj.zzzm == null) {
                zzb(zzqp.getView());
            }
        }
        zzjb zzjb = zzqp;
        zzjb.zzkV().zza(this, this, this, this, false, this, null, zze, this, zzop);
        zza(zzjb);
        zzjb.zzbg(zza.zzSF.zzRr);
        return zzjb;
    }

    public void zza(int i, int i2, int i3, int i4) {
        zzbJ();
    }

    public void zza(zzgj zzgj) {
        zzac.zzdn("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzsw.zzvz = zzgj;
    }

    protected void zza(zzjb zzjb) {
        zzjb.zza("/trackActiveViewUnit", new C06111(this));
    }

    protected void zza(final zza zza, final zzgf zzgf) {
        if (zza.errorCode != -2) {
            zzpi.zzWR.post(new Runnable(this) {
                final /* synthetic */ zzc zzsH;

                public void run() {
                    this.zzsH.zzb(new zzov(zza, null, null, null, null, null, null, null));
                }
            });
            return;
        }
        if (zza.zzvj != null) {
            this.zzsw.zzvj = zza.zzvj;
        }
        if (!zza.zzVB.zzRK || zza.zzVB.zzzp) {
            zzpi.zzWR.post(new Runnable(this, null) {
                final /* synthetic */ zzc zzsH;

                public void run() {
                    if (zza.zzVB.zzRT && this.zzsH.zzsw.zzvz != null) {
                        String str = null;
                        if (zza.zzVB.zzNb != null) {
                            str = zzv.zzcJ().zzaV(zza.zzVB.zzNb);
                        }
                        zzgi zzgg = new zzgg(this.zzsH, str, zza.zzVB.body);
                        this.zzsH.zzsw.zzvF = 1;
                        try {
                            this.zzsH.zzsu = false;
                            this.zzsH.zzsw.zzvz.zza(zzgg);
                            return;
                        } catch (Throwable e) {
                            zzpy.zzc("Could not call the onCustomRenderedAdLoadedListener.", e);
                            this.zzsH.zzsu = true;
                        }
                    }
                    final zze zze = new zze(this.zzsH.zzsw.zzqr, zza);
                    zzqp zza = this.zzsH.zza(zza, zze, null);
                    zza.setOnTouchListener(new OnTouchListener(this) {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            zze.recordClick();
                            return false;
                        }
                    });
                    zza.setOnClickListener(new OnClickListener(this) {
                        public void onClick(View view) {
                            zze.recordClick();
                        }
                    });
                    this.zzsH.zzsw.zzvF = 0;
                    this.zzsH.zzsw.zzvi = zzv.zzcI().zza(this.zzsH.zzsw.zzqr, this.zzsH, zza, this.zzsH.zzsw.zzve, zza, this.zzsH.zzsD, this.zzsH, zzgf);
                }
            });
            return;
        }
        this.zzsw.zzvF = 0;
        this.zzsw.zzvi = zzv.zzcI().zza(this.zzsw.zzqr, this, zza, this.zzsw.zzve, null, this.zzsD, this, zzgf);
    }

    protected boolean zza(@Nullable zzov zzov, zzov zzov2) {
        if (this.zzsw.zzdm() && this.zzsw.zzvg != null) {
            this.zzsw.zzvg.zzds().zzaY(zzov2.zzRP);
        }
        return super.zza(zzov, zzov2);
    }

    public void zzbX() {
        onAdClicked();
    }

    public void zzbY() {
        recordImpression();
        zzbF();
    }

    public void zzbZ() {
        zzbH();
    }

    public void zzc(View view) {
        this.zzsw.zzvE = view;
        zzb(new zzov(this.zzsw.zzvl, null, null, null, null, null, null, null));
    }
}
