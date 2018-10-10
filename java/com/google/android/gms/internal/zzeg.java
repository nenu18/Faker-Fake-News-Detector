package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zze;
import com.google.firebase.analytics.FirebaseAnalytics.Event;

@zzmb
public class zzeg {
    private final Object zzrN = new Object();
    private zzes zzzs;
    private final zzdx zzzt;
    private final zzdw zzzu;
    private final zzfd zzzv;
    private final zzhn zzzw;
    private final zznv zzzx;
    private final zzlf zzzy;
    private final zzkq zzzz;

    @VisibleForTesting
    abstract class zza<T> {
        final /* synthetic */ zzeg zzzC;

        zza(zzeg zzeg) {
            this.zzzC = zzeg;
        }

        @Nullable
        protected abstract T zzb(zzes zzes) throws RemoteException;

        @Nullable
        protected abstract T zzeE() throws RemoteException;

        @Nullable
        protected final T zzeL() {
            T t = null;
            zzes zza = this.zzzC.zzeC();
            if (zza == null) {
                zzpy.zzbe("ClientApi class cannot be loaded.");
            } else {
                try {
                    t = zzb(zza);
                } catch (Throwable e) {
                    zzpy.zzc("Cannot invoke local loader using ClientApi class", e);
                }
            }
            return t;
        }

        @Nullable
        protected final T zzeM() {
            try {
                return zzeE();
            } catch (Throwable e) {
                zzpy.zzc("Cannot invoke remote loader", e);
                return null;
            }
        }
    }

    public zzeg(zzdx zzdx, zzdw zzdw, zzfd zzfd, zzhn zzhn, zznv zznv, zzlf zzlf, zzkq zzkq) {
        this.zzzt = zzdx;
        this.zzzu = zzdw;
        this.zzzv = zzfd;
        this.zzzw = zzhn;
        this.zzzx = zznv;
        this.zzzy = zzlf;
        this.zzzz = zzkq;
    }

    private static boolean zza(Activity activity, String str) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra(str)) {
            return intent.getBooleanExtra(str, false);
        }
        zzpy.m9e("useClientJar flag not found in activity intent extras.");
        return false;
    }

    private void zzc(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzeh.zzeO().zza(context, null, "gmob-apps", bundle, true);
    }

    @Nullable
    private static zzes zzeB() {
        try {
            Object newInstance = zzeg.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return com.google.android.gms.internal.zzes.zza.asInterface((IBinder) newInstance);
            }
            zzpy.zzbe("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Throwable e) {
            zzpy.zzc("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    @Nullable
    private zzes zzeC() {
        zzes zzes;
        synchronized (this.zzrN) {
            if (this.zzzs == null) {
                this.zzzs = zzeB();
            }
            zzes = this.zzzs;
        }
        return zzes;
    }

    public zzep zza(final Context context, final zzec zzec, final String str) {
        return (zzep) zza(context, false, new zza<zzep>(this) {
            final /* synthetic */ zzeg zzzC;

            public zzep zza(zzes zzes) throws RemoteException {
                return zzes.createSearchAdManager(zze.zzA(context), zzec, str, 10084000);
            }

            public /* synthetic */ Object zzb(zzes zzes) throws RemoteException {
                return zza(zzes);
            }

            public zzep zzeD() {
                zzep zza = this.zzzC.zzzt.zza(context, zzec, str, null, 3);
                if (zza != null) {
                    return zza;
                }
                this.zzzC.zzc(context, Event.SEARCH);
                return new zzff();
            }

            public /* synthetic */ Object zzeE() throws RemoteException {
                return zzeD();
            }
        });
    }

    public zzep zza(Context context, zzec zzec, String str, zzjs zzjs) {
        final Context context2 = context;
        final zzec zzec2 = zzec;
        final String str2 = str;
        final zzjs zzjs2 = zzjs;
        return (zzep) zza(context, false, new zza<zzep>(this) {
            final /* synthetic */ zzeg zzzC;

            public zzep zza(zzes zzes) throws RemoteException {
                return zzes.createBannerAdManager(zze.zzA(context2), zzec2, str2, zzjs2, 10084000);
            }

            public /* synthetic */ Object zzb(zzes zzes) throws RemoteException {
                return zza(zzes);
            }

            public zzep zzeD() {
                zzep zza = this.zzzC.zzzt.zza(context2, zzec2, str2, zzjs2, 1);
                if (zza != null) {
                    return zza;
                }
                this.zzzC.zzc(context2, "banner");
                return new zzff();
            }

            public /* synthetic */ Object zzeE() throws RemoteException {
                return zzeD();
            }
        });
    }

    public zzhb zza(final Context context, final FrameLayout frameLayout, final FrameLayout frameLayout2) {
        return (zzhb) zza(context, false, new zza<zzhb>(this) {
            final /* synthetic */ zzeg zzzC;

            public /* synthetic */ Object zzb(zzes zzes) throws RemoteException {
                return zze(zzes);
            }

            public zzhb zze(zzes zzes) throws RemoteException {
                return zzes.createNativeAdViewDelegate(zze.zzA(frameLayout), zze.zzA(frameLayout2));
            }

            public /* synthetic */ Object zzeE() throws RemoteException {
                return zzeH();
            }

            public zzhb zzeH() {
                zzhb zzb = this.zzzC.zzzw.zzb(context, frameLayout, frameLayout2);
                if (zzb != null) {
                    return zzb;
                }
                this.zzzC.zzc(context, "native_ad_view_delegate");
                return new zzfh();
            }
        });
    }

    public zznr zza(final Context context, final zzjs zzjs) {
        return (zznr) zza(context, false, new zza<zznr>(this) {
            final /* synthetic */ zzeg zzzC;

            public /* synthetic */ Object zzb(zzes zzes) throws RemoteException {
                return zzf(zzes);
            }

            public /* synthetic */ Object zzeE() throws RemoteException {
                return zzeI();
            }

            public zznr zzeI() {
                zznr zzb = this.zzzC.zzzx.zzb(context, zzjs);
                if (zzb != null) {
                    return zzb;
                }
                this.zzzC.zzc(context, "rewarded_video");
                return new zzfi();
            }

            public zznr zzf(zzes zzes) throws RemoteException {
                return zzes.createRewardedVideoAd(zze.zzA(context), zzjs, 10084000);
            }
        });
    }

    @VisibleForTesting
    <T> T zza(Context context, boolean z, zza<T> zza) {
        if (!(z || zzeh.zzeO().zzP(context))) {
            zzpy.zzbc("Google Play Services is not available");
            z = true;
        }
        T zzeL;
        if (z) {
            zzeL = zza.zzeL();
            return zzeL == null ? zza.zzeM() : zzeL;
        } else {
            zzeL = zza.zzeM();
            return zzeL == null ? zza.zzeL() : zzeL;
        }
    }

    public zzen zzb(final Context context, final String str, final zzjs zzjs) {
        return (zzen) zza(context, false, new zza<zzen>(this) {
            final /* synthetic */ zzeg zzzC;

            public /* synthetic */ Object zzb(zzes zzes) throws RemoteException {
                return zzc(zzes);
            }

            public zzen zzc(zzes zzes) throws RemoteException {
                return zzes.createAdLoaderBuilder(zze.zzA(context), str, zzjs, 10084000);
            }

            public /* synthetic */ Object zzeE() throws RemoteException {
                return zzeF();
            }

            public zzen zzeF() {
                zzen zza = this.zzzC.zzzu.zza(context, str, zzjs);
                if (zza != null) {
                    return zza;
                }
                this.zzzC.zzc(context, "native_ad");
                return new zzfe();
            }
        });
    }

    public zzep zzb(Context context, zzec zzec, String str, zzjs zzjs) {
        final Context context2 = context;
        final zzec zzec2 = zzec;
        final String str2 = str;
        final zzjs zzjs2 = zzjs;
        return (zzep) zza(context, false, new zza<zzep>(this) {
            final /* synthetic */ zzeg zzzC;

            public zzep zza(zzes zzes) throws RemoteException {
                return zzes.createInterstitialAdManager(zze.zzA(context2), zzec2, str2, zzjs2, 10084000);
            }

            public /* synthetic */ Object zzb(zzes zzes) throws RemoteException {
                return zza(zzes);
            }

            public zzep zzeD() {
                zzep zza = this.zzzC.zzzt.zza(context2, zzec2, str2, zzjs2, 2);
                if (zza != null) {
                    return zza;
                }
                this.zzzC.zzc(context2, "interstitial");
                return new zzff();
            }

            public /* synthetic */ Object zzeE() throws RemoteException {
                return zzeD();
            }
        });
    }

    @Nullable
    public zzla zzb(final Activity activity) {
        return (zzla) zza((Context) activity, zza(activity, "com.google.android.gms.ads.internal.purchase.useClientJar"), new zza<zzla>(this) {
            final /* synthetic */ zzeg zzzC;

            public /* synthetic */ Object zzb(zzes zzes) throws RemoteException {
                return zzg(zzes);
            }

            public /* synthetic */ Object zzeE() throws RemoteException {
                return zzeJ();
            }

            public zzla zzeJ() {
                zzla zzg = this.zzzC.zzzy.zzg(activity);
                if (zzg != null) {
                    return zzg;
                }
                this.zzzC.zzc(activity, "iap");
                return null;
            }

            public zzla zzg(zzes zzes) throws RemoteException {
                return zzes.createInAppPurchaseManager(zze.zzA(activity));
            }
        });
    }

    @Nullable
    public zzkr zzc(final Activity activity) {
        return (zzkr) zza((Context) activity, zza(activity, "com.google.android.gms.ads.internal.overlay.useClientJar"), new zza<zzkr>(this) {
            final /* synthetic */ zzeg zzzC;

            public /* synthetic */ Object zzb(zzes zzes) throws RemoteException {
                return zzh(zzes);
            }

            public /* synthetic */ Object zzeE() throws RemoteException {
                return zzeK();
            }

            public zzkr zzeK() {
                zzkr zzf = this.zzzC.zzzz.zzf(activity);
                if (zzf != null) {
                    return zzf;
                }
                this.zzzC.zzc(activity, "ad_overlay");
                return null;
            }

            public zzkr zzh(zzes zzes) throws RemoteException {
                return zzes.createAdOverlay(zze.zzA(activity));
            }
        });
    }

    public zzeu zzk(final Context context) {
        return (zzeu) zza(context, false, new zza<zzeu>(this) {
            final /* synthetic */ zzeg zzzC;

            public /* synthetic */ Object zzb(zzes zzes) throws RemoteException {
                return zzd(zzes);
            }

            public zzeu zzd(zzes zzes) throws RemoteException {
                return zzes.getMobileAdsSettingsManagerWithClientJarVersion(zze.zzA(context), 10084000);
            }

            public /* synthetic */ Object zzeE() throws RemoteException {
                return zzeG();
            }

            public zzeu zzeG() {
                zzeu zzl = this.zzzC.zzzv.zzl(context);
                if (zzl != null) {
                    return zzl;
                }
                this.zzzC.zzc(context, "mobile_ads_settings");
                return new zzfg();
            }
        });
    }
}
