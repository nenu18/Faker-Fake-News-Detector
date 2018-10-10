package com.google.android.gms.ads.internal;

import android.os.Debug;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcp;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzek;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfl;
import com.google.android.gms.internal.zzfn;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zzok;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzpa;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpy;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

@zzmb
public abstract class zza extends com.google.android.gms.internal.zzep.zza implements zzq, zzdt, zzht, com.google.android.gms.internal.zzln.zza, com.google.android.gms.internal.zzmc.zza, zzpa {
    protected zzgf zzsr;
    protected zzgd zzss;
    protected zzgd zzst;
    protected boolean zzsu = false;
    protected final zzs zzsv;
    protected final zzw zzsw;
    @Nullable
    protected transient zzdy zzsx;
    protected final zzcp zzsy;
    protected final zzd zzsz;

    zza(zzw zzw, @Nullable zzs zzs, zzd zzd) {
        this.zzsw = zzw;
        if (zzs == null) {
            zzs = new zzs(this);
        }
        this.zzsv = zzs;
        this.zzsz = zzd;
        zzv.zzcJ().zzz(this.zzsw.zzqr);
        zzv.zzcN().zzc(this.zzsw.zzqr, this.zzsw.zzvf);
        zzv.zzcO().initialize(this.zzsw.zzqr);
        this.zzsy = zzv.zzcN().zzjZ();
        zzv.zzcM().initialize(this.zzsw.zzqr);
        zzbA();
    }

    private zzdy zza(zzdy zzdy) {
        return (!zzi.zzaK(this.zzsw.zzqr) || zzdy.zzyN == null) ? zzdy : new zzdz(zzdy).zza(null).zzex();
    }

    private TimerTask zza(final Timer timer, final CountDownLatch countDownLatch) {
        return new TimerTask(this) {
            final /* synthetic */ zza zzsC;

            public void run() {
                if (((long) ((Integer) zzfx.zzEh.get()).intValue()) != countDownLatch.getCount()) {
                    zzpy.zzbc("Stopping method tracing");
                    Debug.stopMethodTracing();
                    if (countDownLatch.getCount() == 0) {
                        timer.cancel();
                        return;
                    }
                }
                String concat = String.valueOf(this.zzsC.zzsw.zzqr.getPackageName()).concat("_adsTrace_");
                try {
                    zzpy.zzbc("Starting method tracing");
                    countDownLatch.countDown();
                    Debug.startMethodTracing(new StringBuilder(String.valueOf(concat).length() + 20).append(concat).append(zzv.zzcP().currentTimeMillis()).toString(), ((Integer) zzfx.zzEi.get()).intValue());
                } catch (Throwable e) {
                    zzpy.zzc("Exception occurred while starting method tracing.", e);
                }
            }
        };
    }

    private void zzbA() {
        if (((Boolean) zzfx.zzEf.get()).booleanValue()) {
            Timer timer = new Timer();
            timer.schedule(zza(timer, new CountDownLatch(((Integer) zzfx.zzEh.get()).intValue())), 0, ((Long) zzfx.zzEg.get()).longValue());
        }
    }

    private void zzd(zzov zzov) {
        if (zzv.zzcR().zzkz() && !zzov.zzVA && !TextUtils.isEmpty(zzov.zzSg)) {
            zzpy.zzbc("Sending troubleshooting signals to the server.");
            zzv.zzcR().zza(this.zzsw.zzqr, this.zzsw.zzvf.zzaZ, zzov.zzSg, this.zzsw.zzvd);
            zzov.zzVA = true;
        }
    }

    public void destroy() {
        zzac.zzdn("destroy must be called on the main UI thread.");
        this.zzsv.cancel();
        this.zzsy.zzk(this.zzsw.zzvk);
        this.zzsw.destroy();
    }

    public boolean isLoading() {
        return this.zzsu;
    }

    public boolean isReady() {
        zzac.zzdn("isLoaded must be called on the main UI thread.");
        return this.zzsw.zzvh == null && this.zzsw.zzvi == null && this.zzsw.zzvk != null;
    }

    public void onAdClicked() {
        if (this.zzsw.zzvk == null) {
            zzpy.zzbe("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzpy.zzbc("Pinging click URLs.");
        if (this.zzsw.zzvm != null) {
            this.zzsw.zzvm.zzjA();
        }
        if (this.zzsw.zzvk.zzJY != null) {
            zzv.zzcJ().zza(this.zzsw.zzqr, this.zzsw.zzvf.zzaZ, this.zzsw.zzvk.zzJY);
        }
        if (this.zzsw.zzvn != null) {
            try {
                this.zzsw.zzvn.onAdClicked();
            } catch (Throwable e) {
                zzpy.zzc("Could not notify onAdClicked event.", e);
            }
        }
    }

    public void onAppEvent(String str, @Nullable String str2) {
        if (this.zzsw.zzvp != null) {
            try {
                this.zzsw.zzvp.onAppEvent(str, str2);
            } catch (Throwable e) {
                zzpy.zzc("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        zzac.zzdn("pause must be called on the main UI thread.");
    }

    public void resume() {
        zzac.zzdn("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean z) {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public void setUserId(String str) {
        zzpy.zzbe("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void stopLoading() {
        zzac.zzdn("stopLoading must be called on the main UI thread.");
        this.zzsu = false;
        this.zzsw.zzi(true);
    }

    public void zza(zzec zzec) {
        zzac.zzdn("setAdSize must be called on the main UI thread.");
        this.zzsw.zzvj = zzec;
        if (!(this.zzsw.zzvk == null || this.zzsw.zzvk.zzMZ == null || this.zzsw.zzvF != 0)) {
            this.zzsw.zzvk.zzMZ.zza(zzec);
        }
        if (this.zzsw.zzvg != null) {
            if (this.zzsw.zzvg.getChildCount() > 1) {
                this.zzsw.zzvg.removeView(this.zzsw.zzvg.getNextView());
            }
            this.zzsw.zzvg.setMinimumWidth(zzec.widthPixels);
            this.zzsw.zzvg.setMinimumHeight(zzec.heightPixels);
            this.zzsw.zzvg.requestLayout();
        }
    }

    public void zza(zzek zzek) {
        zzac.zzdn("setAdListener must be called on the main UI thread.");
        this.zzsw.zzvn = zzek;
    }

    public void zza(zzel zzel) {
        zzac.zzdn("setAdListener must be called on the main UI thread.");
        this.zzsw.zzvo = zzel;
    }

    public void zza(zzer zzer) {
        zzac.zzdn("setAppEventListener must be called on the main UI thread.");
        this.zzsw.zzvp = zzer;
    }

    public void zza(zzet zzet) {
        zzac.zzdn("setCorrelationIdProvider must be called on the main UI thread");
        this.zzsw.zzvq = zzet;
    }

    public void zza(@Nullable zzfn zzfn) {
        zzac.zzdn("setVideoOptions must be called on the main UI thread.");
        this.zzsw.zzvy = zzfn;
    }

    public void zza(zzgj zzgj) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void zza(zzkz zzkz) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    public void zza(zzld zzld, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    public void zza(zznt zznt) {
        zzac.zzdn("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzsw.zzvA = zznt;
    }

    protected void zza(@Nullable zzok zzok) {
        if (this.zzsw.zzvA != null) {
            try {
                String str = "";
                int i = 0;
                if (zzok != null) {
                    str = zzok.type;
                    i = zzok.zzVj;
                }
                this.zzsw.zzvA.zza(new zznn(str, i));
            } catch (Throwable e) {
                zzpy.zzc("Could not call RewardedVideoAdListener.onRewarded().", e);
            }
        }
    }

    public void zza(com.google.android.gms.internal.zzov.zza zza) {
        if (!(zza.zzVB.zzRO == -1 || TextUtils.isEmpty(zza.zzVB.zzRX))) {
            long zzw = zzw(zza.zzVB.zzRX);
            if (zzw != -1) {
                zzgd zzc = this.zzsr.zzc(zzw + zza.zzVB.zzRO);
                this.zzsr.zza(zzc, "stc");
            }
        }
        this.zzsr.zzX(zza.zzVB.zzRX);
        this.zzsr.zza(this.zzss, "arf");
        this.zzst = this.zzsr.zzfw();
        this.zzsr.zzg("gqi", zza.zzVB.zzRY);
        this.zzsw.zzvh = null;
        this.zzsw.zzvl = zza;
        zza(zza, this.zzsr);
    }

    protected abstract void zza(com.google.android.gms.internal.zzov.zza zza, zzgf zzgf);

    public void zza(HashSet<zzow> hashSet) {
        this.zzsw.zza(hashSet);
    }

    protected abstract boolean zza(zzdy zzdy, zzgf zzgf);

    boolean zza(zzov zzov) {
        return false;
    }

    protected abstract boolean zza(@Nullable zzov zzov, zzov zzov2);

    protected void zzb(View view) {
        com.google.android.gms.ads.internal.zzw.zza zza = this.zzsw.zzvg;
        if (zza != null) {
            zza.addView(view, zzv.zzcL().zzks());
        }
    }

    public void zzb(zzov zzov) {
        this.zzsr.zza(this.zzst, "awr");
        this.zzsw.zzvi = null;
        if (!(zzov.errorCode == -2 || zzov.errorCode == 3)) {
            zzv.zzcN().zzb(this.zzsw.zzdi());
        }
        if (zzov.errorCode == -1) {
            this.zzsu = false;
            return;
        }
        if (zza(zzov)) {
            zzpy.zzbc("Ad refresh scheduled.");
        }
        if (zzov.errorCode != -2) {
            zzh(zzov.errorCode);
            return;
        }
        if (this.zzsw.zzvD == null) {
            this.zzsw.zzvD = new zzpb(this.zzsw.zzvd);
        }
        this.zzsy.zzj(this.zzsw.zzvk);
        if (zza(this.zzsw.zzvk, zzov)) {
            this.zzsw.zzvk = zzov;
            this.zzsw.zzdr();
            this.zzsr.zzg("is_mraid", this.zzsw.zzvk.zzdz() ? "1" : "0");
            this.zzsr.zzg("is_mediation", this.zzsw.zzvk.zzRK ? "1" : "0");
            if (!(this.zzsw.zzvk.zzMZ == null || this.zzsw.zzvk.zzMZ.zzkV() == null)) {
                this.zzsr.zzg("is_delay_pl", this.zzsw.zzvk.zzMZ.zzkV().zzlr() ? "1" : "0");
            }
            this.zzsr.zza(this.zzss, "ttc");
            if (zzv.zzcN().zzjN() != null) {
                zzv.zzcN().zzjN().zza(this.zzsr);
            }
            if (this.zzsw.zzdm()) {
                zzbK();
            }
        }
        if (zzov.zzKb != null) {
            zzv.zzcJ().zza(this.zzsw.zzqr, zzov.zzKb);
        }
    }

    public boolean zzb(zzdy zzdy) {
        zzac.zzdn("loadAd must be called on the main UI thread.");
        zzv.zzcO().zzeq();
        if (((Boolean) zzfx.zzCy.get()).booleanValue()) {
            zzdy.zzj(zzdy);
        }
        zzdy zza = zza(zzdy);
        if (this.zzsw.zzvh == null && this.zzsw.zzvi == null) {
            zzpy.zzbd("Starting ad request.");
            zzbB();
            this.zzss = this.zzsr.zzfw();
            if (!zza.zzyI) {
                String valueOf = String.valueOf(zzeh.zzeO().zzO(this.zzsw.zzqr));
                zzpy.zzbd(new StringBuilder(String.valueOf(valueOf).length() + 71).append("Use AdRequest.Builder.addTestDevice(\"").append(valueOf).append("\") to get test ads on this device.").toString());
            }
            this.zzsv.zzg(zza);
            this.zzsu = zza(zza, this.zzsr);
            return this.zzsu;
        }
        if (this.zzsx != null) {
            zzpy.zzbe("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        } else {
            zzpy.zzbe("Loading already in progress, saving this object for future refreshes.");
        }
        this.zzsx = zza;
        return false;
    }

    public void zzbB() {
        this.zzsr = new zzgf(((Boolean) zzfx.zzBK.get()).booleanValue(), "load_ad", this.zzsw.zzvj.zzzk);
        this.zzss = new zzgd(-1, null, null);
        this.zzst = new zzgd(-1, null, null);
    }

    public zzd zzbC() {
        zzac.zzdn("getAdFrame must be called on the main UI thread.");
        return zze.zzA(this.zzsw.zzvg);
    }

    @Nullable
    public zzec zzbD() {
        zzac.zzdn("getAdSize must be called on the main UI thread.");
        return this.zzsw.zzvj == null ? null : new zzfl(this.zzsw.zzvj);
    }

    public void zzbE() {
        zzbI();
    }

    public void zzbF() {
        zzac.zzdn("recordManualImpression must be called on the main UI thread.");
        if (this.zzsw.zzvk == null) {
            zzpy.zzbe("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzpy.zzbc("Pinging manual tracking URLs.");
        if (this.zzsw.zzvk.zzRM != null && !this.zzsw.zzvk.zzVz) {
            zzv.zzcJ().zza(this.zzsw.zzqr, this.zzsw.zzvf.zzaZ, this.zzsw.zzvk.zzRM);
            this.zzsw.zzvk.zzVz = true;
            zzd(this.zzsw.zzvk);
        }
    }

    public zzew zzbG() {
        return null;
    }

    protected void zzbH() {
        zzpy.zzbd("Ad closing.");
        if (this.zzsw.zzvo != null) {
            try {
                this.zzsw.zzvo.onAdClosed();
            } catch (Throwable e) {
                zzpy.zzc("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.zzsw.zzvA != null) {
            try {
                this.zzsw.zzvA.onRewardedVideoAdClosed();
            } catch (Throwable e2) {
                zzpy.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    protected void zzbI() {
        zzpy.zzbd("Ad leaving application.");
        if (this.zzsw.zzvo != null) {
            try {
                this.zzsw.zzvo.onAdLeftApplication();
            } catch (Throwable e) {
                zzpy.zzc("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.zzsw.zzvA != null) {
            try {
                this.zzsw.zzvA.onRewardedVideoAdLeftApplication();
            } catch (Throwable e2) {
                zzpy.zzc("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    protected void zzbJ() {
        zzpy.zzbd("Ad opening.");
        if (this.zzsw.zzvo != null) {
            try {
                this.zzsw.zzvo.onAdOpened();
            } catch (Throwable e) {
                zzpy.zzc("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.zzsw.zzvA != null) {
            try {
                this.zzsw.zzvA.onRewardedVideoAdOpened();
            } catch (Throwable e2) {
                zzpy.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    protected void zzbK() {
        zzpy.zzbd("Ad finished loading.");
        this.zzsu = false;
        if (this.zzsw.zzvo != null) {
            try {
                this.zzsw.zzvo.onAdLoaded();
            } catch (Throwable e) {
                zzpy.zzc("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.zzsw.zzvA != null) {
            try {
                this.zzsw.zzvA.onRewardedVideoAdLoaded();
            } catch (Throwable e2) {
                zzpy.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    protected void zzbL() {
        if (this.zzsw.zzvA != null) {
            try {
                this.zzsw.zzvA.onRewardedVideoStarted();
            } catch (Throwable e) {
                zzpy.zzc("Could not call RewardedVideoAdListener.onVideoStarted().", e);
            }
        }
    }

    public zzd zzbz() {
        return this.zzsz;
    }

    protected void zzc(@Nullable zzov zzov) {
        if (zzov == null) {
            zzpy.zzbe("Ad state was null when trying to ping impression URLs.");
            return;
        }
        zzpy.zzbc("Pinging Impression URLs.");
        if (this.zzsw.zzvm != null) {
            this.zzsw.zzvm.zzjz();
        }
        if (zzov.zzJZ != null && !zzov.zzVy) {
            zzv.zzcJ().zza(this.zzsw.zzqr, this.zzsw.zzvf.zzaZ, zzov.zzJZ);
            zzov.zzVy = true;
            zzd(zzov);
        }
    }

    protected boolean zzc(zzdy zzdy) {
        if (this.zzsw.zzvg == null) {
            return false;
        }
        ViewParent parent = this.zzsw.zzvg.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        return zzv.zzcJ().zza(view, view.getContext());
    }

    public void zzd(zzdy zzdy) {
        if (zzc(zzdy)) {
            zzb(zzdy);
            return;
        }
        zzpy.zzbd("Ad is not visible. Not refreshing ad.");
        this.zzsv.zzh(zzdy);
    }

    protected void zzh(int i) {
        zzpy.zzbe("Failed to load ad: " + i);
        this.zzsu = false;
        if (this.zzsw.zzvo != null) {
            try {
                this.zzsw.zzvo.onAdFailedToLoad(i);
            } catch (Throwable e) {
                zzpy.zzc("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.zzsw.zzvA != null) {
            try {
                this.zzsw.zzvA.onRewardedVideoAdFailedToLoad(i);
            } catch (Throwable e2) {
                zzpy.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    long zzw(String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            zzpy.zzbe("Invalid index for Url fetch time in CSI latency info.");
            return -1;
        } catch (NumberFormatException e2) {
            zzpy.zzbe("Cannot find valid format of Url fetch time in CSI latency info.");
            return -1;
        }
    }
}
