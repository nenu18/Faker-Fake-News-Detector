package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.concurrent.atomic.AtomicBoolean;

@zzmb
public class zzez {
    private InAppPurchaseListener zzAa;
    private OnCustomRenderedAdLoadedListener zzAb;
    private PlayStorePurchaseListener zzAc;
    private String zzAd;
    private ViewGroup zzAe;
    private int zzAf;
    private final zzeb zzrB;
    private boolean zzsS;
    private VideoOptions zzsb;
    private String zztq;
    private zzdt zzyD;
    private AdListener zzyE;
    private final zzjr zzzU;
    private final AtomicBoolean zzzV;
    private final VideoController zzzW;
    final zzej zzzX;
    private Correlator zzzY;
    private zzep zzzZ;
    private AppEventListener zzzq;
    private AdSize[] zzzr;

    /* renamed from: com.google.android.gms.internal.zzez$1 */
    class C08201 extends zzej {
        final /* synthetic */ zzez zzAg;

        C08201(zzez zzez) {
            this.zzAg = zzez;
        }

        public void onAdFailedToLoad(int i) {
            this.zzAg.zzzW.zza(this.zzAg.zzbt());
            super.onAdFailedToLoad(i);
        }

        public void onAdLoaded() {
            this.zzAg.zzzW.zza(this.zzAg.zzbt());
            super.onAdLoaded();
        }
    }

    public zzez(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzeb.zzey(), 0);
    }

    public zzez(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzeb.zzey(), i);
    }

    public zzez(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzeb.zzey(), 0);
    }

    public zzez(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, z, zzeb.zzey(), i);
    }

    zzez(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzeb zzeb, int i) {
        this(viewGroup, attributeSet, z, zzeb, null, i);
    }

    zzez(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzeb zzeb, zzep zzep, int i) {
        this.zzzU = new zzjr();
        this.zzzW = new VideoController();
        this.zzzX = new C08201(this);
        this.zzAe = viewGroup;
        this.zzrB = zzeb;
        this.zzzZ = zzep;
        this.zzzV = new AtomicBoolean(false);
        this.zzAf = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzef zzef = new zzef(context, attributeSet);
                this.zzzr = zzef.zzm(z);
                this.zztq = zzef.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzeh.zzeO().zza(viewGroup, zza(context, this.zzzr[0], this.zzAf), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzeh.zzeO().zza(viewGroup, new zzec(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private static zzec zza(Context context, AdSize adSize, int i) {
        zzec zzec = new zzec(context, adSize);
        zzec.zzl(zzy(i));
        return zzec;
    }

    private static zzec zza(Context context, AdSize[] adSizeArr, int i) {
        zzec zzec = new zzec(context, adSizeArr);
        zzec.zzl(zzy(i));
        return zzec;
    }

    private void zzfc() {
        try {
            zzd zzbC = this.zzzZ.zzbC();
            if (zzbC != null) {
                this.zzAe.addView((View) zze.zzE(zzbC));
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to get an ad frame.", e);
        }
    }

    private static boolean zzy(int i) {
        return i == 1;
    }

    public void destroy() {
        try {
            if (this.zzzZ != null) {
                this.zzzZ.destroy();
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.zzyE;
    }

    public AdSize getAdSize() {
        try {
            if (this.zzzZ != null) {
                zzec zzbD = this.zzzZ.zzbD();
                if (zzbD != null) {
                    return zzbD.zzeA();
                }
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to get the current AdSize.", e);
        }
        return this.zzzr != null ? this.zzzr[0] : null;
    }

    public AdSize[] getAdSizes() {
        return this.zzzr;
    }

    public String getAdUnitId() {
        return this.zztq;
    }

    public AppEventListener getAppEventListener() {
        return this.zzzq;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzAa;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.zzzZ != null) {
                return this.zzzZ.getMediationAdapterClassName();
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzAb;
    }

    public VideoController getVideoController() {
        return this.zzzW;
    }

    public VideoOptions getVideoOptions() {
        return this.zzsb;
    }

    public boolean isLoading() {
        try {
            if (this.zzzZ != null) {
                return this.zzzZ.isLoading();
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to check if ad is loading.", e);
        }
        return false;
    }

    public void pause() {
        try {
            if (this.zzzZ != null) {
                this.zzzZ.pause();
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        if (!this.zzzV.getAndSet(true)) {
            try {
                if (this.zzzZ != null) {
                    this.zzzZ.zzbF();
                }
            } catch (Throwable e) {
                zzpy.zzc("Failed to record impression.", e);
            }
        }
    }

    public void resume() {
        try {
            if (this.zzzZ != null) {
                this.zzzZ.resume();
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to call resume.", e);
        }
    }

    public void setAdListener(AdListener adListener) {
        this.zzyE = adListener;
        this.zzzX.zza(adListener);
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (this.zzzr != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zza(adSizeArr);
    }

    public void setAdUnitId(String str) {
        if (this.zztq != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.zztq = str;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzzq = appEventListener;
            if (this.zzzZ != null) {
                this.zzzZ.zza(appEventListener != null ? new zzee(appEventListener) : null);
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to set the AppEventListener.", e);
        }
    }

    public void setCorrelator(Correlator correlator) {
        this.zzzY = correlator;
        try {
            if (this.zzzZ != null) {
                this.zzzZ.zza(this.zzzY == null ? null : this.zzzY.zzbr());
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to set correlator.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.zzAc != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.zzAa = inAppPurchaseListener;
            if (this.zzzZ != null) {
                this.zzzZ.zza(inAppPurchaseListener != null ? new zzle(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.zzsS = z;
        try {
            if (this.zzzZ != null) {
                this.zzzZ.setManualImpressionsEnabled(this.zzsS);
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to set manual impressions.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzAb = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzzZ != null) {
                this.zzzZ.zza(onCustomRenderedAdLoadedListener != null ? new zzgk(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.zzAa != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
        }
        try {
            this.zzAc = playStorePurchaseListener;
            this.zzAd = str;
            if (this.zzzZ != null) {
                this.zzzZ.zza(playStorePurchaseListener != null ? new zzli(playStorePurchaseListener) : null, str);
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to set the play store purchase parameter.", e);
        }
    }

    public void setVideoOptions(VideoOptions videoOptions) {
        this.zzsb = videoOptions;
        try {
            if (this.zzzZ != null) {
                this.zzzZ.zza(videoOptions == null ? null : new zzfn(videoOptions));
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to set video options.", e);
        }
    }

    public void zza(zzdt zzdt) {
        try {
            this.zzyD = zzdt;
            if (this.zzzZ != null) {
                this.zzzZ.zza(zzdt != null ? new zzdu(zzdt) : null);
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to set the AdClickListener.", e);
        }
    }

    public void zza(zzey zzey) {
        try {
            if (this.zzzZ == null) {
                zzfd();
            }
            if (this.zzzZ.zzb(this.zzrB.zza(this.zzAe.getContext(), zzey))) {
                this.zzzU.zzi(zzey.zzeY());
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to load ad.", e);
        }
    }

    public void zza(AdSize... adSizeArr) {
        this.zzzr = adSizeArr;
        try {
            if (this.zzzZ != null) {
                this.zzzZ.zza(zza(this.zzAe.getContext(), this.zzzr, this.zzAf));
            }
        } catch (Throwable e) {
            zzpy.zzc("Failed to set the ad size.", e);
        }
        this.zzAe.requestLayout();
    }

    public boolean zzb(zzec zzec) {
        return "search_v2".equals(zzec.zzzk);
    }

    public zzew zzbt() {
        zzew zzew = null;
        if (this.zzzZ != null) {
            try {
                zzew = this.zzzZ.zzbG();
            } catch (Throwable e) {
                zzpy.zzc("Failed to retrieve VideoController.", e);
            }
        }
        return zzew;
    }

    void zzfd() throws RemoteException {
        if ((this.zzzr == null || this.zztq == null) && this.zzzZ == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        this.zzzZ = zzfe();
        this.zzzZ.zza(new zzdv(this.zzzX));
        if (this.zzyD != null) {
            this.zzzZ.zza(new zzdu(this.zzyD));
        }
        if (this.zzzq != null) {
            this.zzzZ.zza(new zzee(this.zzzq));
        }
        if (this.zzAa != null) {
            this.zzzZ.zza(new zzle(this.zzAa));
        }
        if (this.zzAc != null) {
            this.zzzZ.zza(new zzli(this.zzAc), this.zzAd);
        }
        if (this.zzAb != null) {
            this.zzzZ.zza(new zzgk(this.zzAb));
        }
        if (this.zzzY != null) {
            this.zzzZ.zza(this.zzzY.zzbr());
        }
        if (this.zzsb != null) {
            this.zzzZ.zza(new zzfn(this.zzsb));
        }
        this.zzzZ.setManualImpressionsEnabled(this.zzsS);
        zzfc();
    }

    protected zzep zzfe() throws RemoteException {
        Context context = this.zzAe.getContext();
        zzec zza = zza(context, this.zzzr, this.zzAf);
        return zzb(zza) ? zzeh.zzeP().zza(context, zza, this.zztq) : zzeh.zzeP().zza(context, zza, this.zztq, this.zzzU);
    }
}
