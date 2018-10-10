package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@zzmb
public final class zzkf<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzju zzKW;

    /* renamed from: com.google.android.gms.internal.zzkf$1 */
    class C03971 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C03971(zzkf zzkf) {
            this.zzLc = zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdClicked();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$2 */
    class C03982 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C03982(zzkf zzkf) {
            this.zzLc = zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdOpened();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$3 */
    class C03993 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C03993(zzkf zzkf) {
            this.zzLc = zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdLoaded();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$4 */
    class C04004 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C04004(zzkf zzkf) {
            this.zzLc = zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdClosed();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$6 */
    class C04026 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C04026(zzkf zzkf) {
            this.zzLc = zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdLeftApplication();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$7 */
    class C04037 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C04037(zzkf zzkf) {
            this.zzLc = zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdOpened();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$8 */
    class C04048 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C04048(zzkf zzkf) {
            this.zzLc = zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdLoaded();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$9 */
    class C04059 implements Runnable {
        final /* synthetic */ zzkf zzLc;

        C04059(zzkf zzkf) {
            this.zzLc = zzkf;
        }

        public void run() {
            try {
                this.zzLc.zzKW.onAdClosed();
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClosed.", e);
            }
        }
    }

    public zzkf(zzju zzju) {
        this.zzKW = zzju;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onClick.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdClicked();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClicked.", e);
                return;
            }
        }
        zzpy.zzbe("onClick must be called on the main UI thread.");
        zzpx.zzXU.post(new C03971(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onDismissScreen.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdClosed();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClosed.", e);
                return;
            }
        }
        zzpy.zzbe("onDismissScreen must be called on the main UI thread.");
        zzpx.zzXU.post(new C04004(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzpy.zzbc("Adapter called onDismissScreen.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdClosed();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdClosed.", e);
                return;
            }
        }
        zzpy.zzbe("onDismissScreen must be called on the main UI thread.");
        zzpx.zzXU.post(new C04059(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        zzpy.zzbc(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error. ").append(valueOf).toString());
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdFailedToLoad(zzkg.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzpy.zzbe("onFailedToReceiveAd must be called on the main UI thread.");
        zzpx.zzXU.post(new Runnable(this) {
            final /* synthetic */ zzkf zzLc;

            public void run() {
                try {
                    this.zzLc.zzKW.onAdFailedToLoad(zzkg.zza(errorCode));
                } catch (Throwable e) {
                    zzpy.zzc("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        zzpy.zzbc(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error ").append(valueOf).append(".").toString());
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdFailedToLoad(zzkg.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzpy.zzbe("onFailedToReceiveAd must be called on the main UI thread.");
        zzpx.zzXU.post(new Runnable(this) {
            final /* synthetic */ zzkf zzLc;

            public void run() {
                try {
                    this.zzLc.zzKW.onAdFailedToLoad(zzkg.zza(errorCode));
                } catch (Throwable e) {
                    zzpy.zzc("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onLeaveApplication.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzpy.zzbe("onLeaveApplication must be called on the main UI thread.");
        zzpx.zzXU.post(new C04026(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzpy.zzbc("Adapter called onLeaveApplication.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzpy.zzbe("onLeaveApplication must be called on the main UI thread.");
        zzpx.zzXU.post(new Runnable(this) {
            final /* synthetic */ zzkf zzLc;

            {
                this.zzLc = r1;
            }

            public void run() {
                try {
                    this.zzLc.zzKW.onAdLeftApplication();
                } catch (Throwable e) {
                    zzpy.zzc("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onPresentScreen.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdOpened();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdOpened.", e);
                return;
            }
        }
        zzpy.zzbe("onPresentScreen must be called on the main UI thread.");
        zzpx.zzXU.post(new C04037(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzpy.zzbc("Adapter called onPresentScreen.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdOpened();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdOpened.", e);
                return;
            }
        }
        zzpy.zzbe("onPresentScreen must be called on the main UI thread.");
        zzpx.zzXU.post(new C03982(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzpy.zzbc("Adapter called onReceivedAd.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzpy.zzbe("onReceivedAd must be called on the main UI thread.");
        zzpx.zzXU.post(new C04048(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzpy.zzbc("Adapter called onReceivedAd.");
        if (zzeh.zzeO().zzkJ()) {
            try {
                this.zzKW.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzpy.zzc("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzpy.zzbe("onReceivedAd must be called on the main UI thread.");
        zzpx.zzXU.post(new C03993(this));
    }
}
