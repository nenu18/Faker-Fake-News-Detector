package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzib;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzna;
import com.google.android.gms.internal.zzok;
import com.google.android.gms.internal.zzop;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqq.zzc;
import java.util.Collections;
import org.json.JSONObject;

@zzmb
public class zzl extends zzc implements zzib, com.google.android.gms.internal.zzig.zza {
    private int zztA = -1;
    private boolean zztB;
    private float zztC;
    protected transient boolean zztz = false;

    @zzmb
    private class zza extends zzpd {
        final /* synthetic */ zzl zztD;
        private final int zztE;

        public zza(zzl zzl, int i) {
            this.zztD = zzl;
            this.zztE = i;
        }

        public void onStop() {
        }

        public void zzcm() {
            zzm zzm = new zzm(this.zztD.zzsw.zztH, this.zztD.zzcj(), this.zztD.zztB, this.zztD.zztC, this.zztD.zzsw.zztH ? this.zztE : -1);
            int requestedOrientation = this.zztD.zzsw.zzvk.zzMZ.getRequestedOrientation();
            final AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(this.zztD, this.zztD, this.zztD, this.zztD.zzsw.zzvk.zzMZ, requestedOrientation == -1 ? this.zztD.zzsw.zzvk.orientation : requestedOrientation, this.zztD.zzsw.zzvf, this.zztD.zzsw.zzvk.zzRP, zzm);
            zzpi.zzWR.post(new Runnable(this) {
                final /* synthetic */ zza zztG;

                public void run() {
                    zzv.zzcH().zza(this.zztG.zztD.zzsw.zzqr, adOverlayInfoParcel);
                }
            });
        }
    }

    public zzl(Context context, zzec zzec, String str, zzjs zzjs, zzqa zzqa, zzd zzd) {
        super(context, zzec, str, zzjs, zzqa, zzd);
    }

    private void zzb(Bundle bundle) {
        zzv.zzcJ().zzb(this.zzsw.zzqr, this.zzsw.zzvf.zzaZ, "gmob-apps", bundle, false);
    }

    static com.google.android.gms.internal.zzov.zza zzc(com.google.android.gms.internal.zzov.zza zza) {
        try {
            String jSONObject = zzna.zzc(zza.zzVB).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zza.zzSF.zzvd);
            zzji zzji = new zzji(jSONObject, null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList());
            zzmk zzmk = zza.zzVB;
            zzjj zzjj = new zzjj(Collections.singletonList(zzji), -1, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), zzmk.zzKb, zzmk.zzKc, "", -1, 0, 1, null, 0, -1, -1, false);
            return new com.google.android.gms.internal.zzov.zza(zza.zzSF, new zzmk(zza.zzSF, zzmk.zzNb, zzmk.body, Collections.emptyList(), Collections.emptyList(), zzmk.zzRJ, true, zzmk.zzRL, Collections.emptyList(), zzmk.zzKe, zzmk.orientation, zzmk.zzRN, zzmk.zzRO, zzmk.zzRP, zzmk.zzRQ, zzmk.zzRR, null, zzmk.zzRT, zzmk.zzzn, zzmk.zzRl, zzmk.zzRU, zzmk.zzRV, zzmk.zzRY, zzmk.zzzo, zzmk.zzzp, null, Collections.emptyList(), Collections.emptyList(), zzmk.zzSc, zzmk.zzSd, zzmk.zzRB, zzmk.zzRC, zzmk.zzKb, zzmk.zzKc, zzmk.zzSe, null, zzmk.zzSg, zzmk.zzSh), zzjj, zza.zzvj, zza.errorCode, zza.zzVv, zza.zzVw, null);
        } catch (Throwable e) {
            zzpy.zzb("Unable to generate ad state for an interstitial ad with pooling.", e);
            return zza;
        }
    }

    public void showInterstitial() {
        zzac.zzdn("showInterstitial must be called on the main UI thread.");
        if (this.zzsw.zzvk == null) {
            zzpy.zzbe("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) zzfx.zzCR.get()).booleanValue()) {
            Bundle bundle;
            String packageName = this.zzsw.zzqr.getApplicationContext() != null ? this.zzsw.zzqr.getApplicationContext().getPackageName() : this.zzsw.zzqr.getPackageName();
            if (!this.zztz) {
                zzpy.zzbe("It is not recommended to show an interstitial before onAdLoaded completes.");
                bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_before_load_finish");
                zzb(bundle);
            }
            if (!zzv.zzcJ().zzE(this.zzsw.zzqr)) {
                zzpy.zzbe("It is not recommended to show an interstitial when app is not in foreground.");
                bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_app_not_in_foreground");
                zzb(bundle);
            }
        }
        if (!this.zzsw.zzdn()) {
            if (this.zzsw.zzvk.zzRK && this.zzsw.zzvk.zzKB != null) {
                try {
                    this.zzsw.zzvk.zzKB.showInterstitial();
                } catch (Throwable e) {
                    zzpy.zzc("Could not show interstitial.", e);
                    zzck();
                }
            } else if (this.zzsw.zzvk.zzMZ == null) {
                zzpy.zzbe("The interstitial failed to load.");
            } else if (this.zzsw.zzvk.zzMZ.zzkZ()) {
                zzpy.zzbe("The interstitial is already showing.");
            } else {
                this.zzsw.zzvk.zzMZ.zzJ(true);
                if (this.zzsw.zzvk.zzVp != null) {
                    this.zzsy.zza(this.zzsw.zzvj, this.zzsw.zzvk);
                }
                if (zzs.zzyA()) {
                    final zzov zzov = this.zzsw.zzvk;
                    if (zzov.zzdz()) {
                        new zzcv(this.zzsw.zzqr, zzov.zzMZ.getView()).zza(zzov.zzMZ);
                    } else {
                        zzov.zzMZ.zzkV().zza(new zzc(this) {
                            final /* synthetic */ zzl zztD;

                            public void zzcd() {
                                new zzcv(this.zztD.zzsw.zzqr, zzov.zzMZ.getView()).zza(zzov.zzMZ);
                            }
                        });
                    }
                }
                Bitmap zzF = this.zzsw.zztH ? zzv.zzcJ().zzF(this.zzsw.zzqr) : null;
                this.zztA = zzv.zzde().zzb(zzF);
                if (!((Boolean) zzfx.zzDJ.get()).booleanValue() || zzF == null) {
                    zzm zzm = new zzm(this.zzsw.zztH, zzcj(), false, 0.0f, -1);
                    int requestedOrientation = this.zzsw.zzvk.zzMZ.getRequestedOrientation();
                    if (requestedOrientation == -1) {
                        requestedOrientation = this.zzsw.zzvk.orientation;
                    }
                    zzv.zzcH().zza(this.zzsw.zzqr, new AdOverlayInfoParcel(this, this, this, this.zzsw.zzvk.zzMZ, requestedOrientation, this.zzsw.zzvf, this.zzsw.zzvk.zzRP, zzm));
                    return;
                }
                new zza(this, this.zztA).zziw();
            }
        }
    }

    protected zzqp zza(com.google.android.gms.internal.zzov.zza zza, @Nullable zze zze, @Nullable zzop zzop) {
        zzqp zza2 = zzv.zzcK().zza(this.zzsw.zzqr, this.zzsw.zzvj, false, false, this.zzsw.zzve, this.zzsw.zzvf, this.zzsr, this, this.zzsz);
        zza2.zzkV().zza(this, null, this, this, ((Boolean) zzfx.zzCh.get()).booleanValue(), this, this, zze, null, zzop);
        zza((zzjb) zza2);
        zza2.zzbg(zza.zzSF.zzRr);
        zzig.zza(zza2, (com.google.android.gms.internal.zzig.zza) this);
        return zza2;
    }

    public void zza(com.google.android.gms.internal.zzov.zza zza, zzgf zzgf) {
        Object obj = 1;
        if (!((Boolean) zzfx.zzCA.get()).booleanValue()) {
            super.zza(zza, zzgf);
        } else if (zza.errorCode != -2) {
            super.zza(zza, zzgf);
        } else {
            Bundle bundle = zza.zzSF.zzRd.zzyP.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
            Object obj2 = (bundle == null || !bundle.containsKey("gw")) ? 1 : null;
            if (zza.zzVB.zzRK) {
                obj = null;
            }
            if (!(obj2 == null || r2 == null)) {
                this.zzsw.zzvl = zzc(zza);
            }
            super.zza(this.zzsw.zzvl, zzgf);
        }
    }

    public void zza(boolean z, float f) {
        this.zztB = z;
        this.zztC = f;
    }

    public boolean zza(zzdy zzdy, zzgf zzgf) {
        if (this.zzsw.zzvk == null) {
            return super.zza(zzdy, zzgf);
        }
        zzpy.zzbe("An interstitial is already loading. Aborting.");
        return false;
    }

    protected boolean zza(zzdy zzdy, zzov zzov, boolean z) {
        if (this.zzsw.zzdm() && zzov.zzMZ != null) {
            zzv.zzcL().zzl(zzov.zzMZ);
        }
        return this.zzsv.zzcv();
    }

    public boolean zza(@Nullable zzov zzov, zzov zzov2) {
        if (!super.zza(zzov, zzov2)) {
            return false;
        }
        if (!(this.zzsw.zzdm() || this.zzsw.zzvE == null || zzov2.zzVp == null)) {
            this.zzsy.zza(this.zzsw.zzvj, zzov2, this.zzsw.zzvE);
        }
        return true;
    }

    public void zzb(zzok zzok) {
        if (this.zzsw.zzvk != null) {
            if (this.zzsw.zzvk.zzSb != null) {
                zzv.zzcJ().zza(this.zzsw.zzqr, this.zzsw.zzvf.zzaZ, this.zzsw.zzvk.zzSb);
            }
            if (this.zzsw.zzvk.zzRZ != null) {
                zzok = this.zzsw.zzvk.zzRZ;
            }
        }
        zza(zzok);
    }

    protected void zzbH() {
        zzck();
        super.zzbH();
    }

    protected void zzbK() {
        super.zzbK();
        this.zztz = true;
    }

    public void zzbO() {
        recordImpression();
        super.zzbO();
        if (this.zzsw.zzvk != null && this.zzsw.zzvk.zzMZ != null) {
            zzqq zzkV = this.zzsw.zzvk.zzMZ.zzkV();
            if (zzkV != null) {
                zzkV.zzlt();
            }
        }
    }

    protected boolean zzcj() {
        if (!(this.zzsw.zzqr instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) this.zzsw.zzqr).getWindow();
        if (window == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        boolean z = (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
        return z;
    }

    public void zzck() {
        zzv.zzde().zzb(Integer.valueOf(this.zztA));
        if (this.zzsw.zzdm()) {
            this.zzsw.zzdj();
            this.zzsw.zzvk = null;
            this.zzsw.zztH = false;
            this.zztz = false;
        }
    }

    public void zzcl() {
        if (!(this.zzsw.zzvk == null || this.zzsw.zzvk.zzVu == null)) {
            zzv.zzcJ().zza(this.zzsw.zzqr, this.zzsw.zzvf.zzaZ, this.zzsw.zzvk.zzVu);
        }
        zzbL();
    }

    public void zzg(boolean z) {
        this.zzsw.zztH = z;
    }
}
