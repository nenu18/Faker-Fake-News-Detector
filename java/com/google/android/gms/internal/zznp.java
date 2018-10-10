package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzov.zza;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zznp extends zzb implements zzod {
    private static final zzjr zzUF = new zzjr();
    private final Map<String, zzoh> zzUG = new HashMap();
    private boolean zzUH;

    /* renamed from: com.google.android.gms.internal.zznp$1 */
    class C04381 implements Runnable {
        final /* synthetic */ zznp zzUI;

        C04381(zznp zznp) {
            this.zzUI = zznp;
        }

        public void run() {
            this.zzUI.zzh(1);
        }
    }

    public zznp(Context context, zzd zzd, zzec zzec, zzjs zzjs, zzqa zzqa) {
        super(context, zzec, null, zzjs, zzqa, zzd);
    }

    private zza zzd(zza zza) {
        zzpe.m13v("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String jSONObject = zzna.zzc(zza.zzVB).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zza.zzSF.zzvd);
            zzji zzji = new zzji(jSONObject, null, Arrays.asList(new String[]{"com.google.ads.mediation.admob.AdMobAdapter"}), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList());
            return new zza(zza.zzSF, zza.zzVB, new zzjj(Arrays.asList(new zzji[]{zzji}), -1, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1, 0, 1, null, 0, -1, -1, false), zza.zzvj, zza.errorCode, zza.zzVv, zza.zzVw, zza.zzVp);
        } catch (Throwable e) {
            zzpy.zzb("Unable to generate ad state for non-mediated rewarded video.", e);
            return zze(zza);
        }
    }

    private zza zze(zza zza) {
        return new zza(zza.zzSF, zza.zzVB, null, zza.zzvj, 0, zza.zzVv, zza.zzVw, zza.zzVp);
    }

    public void destroy() {
        String valueOf;
        zzac.zzdn("destroy must be called on the main UI thread.");
        for (String valueOf2 : this.zzUG.keySet()) {
            try {
                zzoh zzoh = (zzoh) this.zzUG.get(valueOf2);
                if (!(zzoh == null || zzoh.zzjw() == null)) {
                    zzoh.zzjw().destroy();
                }
            } catch (RemoteException e) {
                String str = "Fail to destroy adapter: ";
                valueOf2 = String.valueOf(valueOf2);
                zzpy.zzbe(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
            }
        }
    }

    public boolean isLoaded() {
        zzac.zzdn("isLoaded must be called on the main UI thread.");
        return this.zzsw.zzvh == null && this.zzsw.zzvi == null && this.zzsw.zzvk != null && !this.zzUH;
    }

    public void onContextChanged(@NonNull Context context) {
        for (zzoh zzjw : this.zzUG.values()) {
            try {
                zzjw.zzjw().zzj(zze.zzA(context));
            } catch (Throwable e) {
                zzpy.zzb("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    public void onRewardedVideoAdClosed() {
        zzbH();
    }

    public void onRewardedVideoAdLeftApplication() {
        zzbI();
    }

    public void onRewardedVideoAdOpened() {
        zza(this.zzsw.zzvk, false);
        zzbJ();
    }

    public void onRewardedVideoStarted() {
        if (!(this.zzsw.zzvk == null || this.zzsw.zzvk.zzKA == null)) {
            zzv.zzdc().zza(this.zzsw.zzqr, this.zzsw.zzvf.zzaZ, this.zzsw.zzvk, this.zzsw.zzvd, false, this.zzsw.zzvk.zzKA.zzJP);
        }
        zzbL();
    }

    public void pause() {
        zzac.zzdn("pause must be called on the main UI thread.");
        for (String str : this.zzUG.keySet()) {
            String str2;
            try {
                zzoh zzoh = (zzoh) this.zzUG.get(str2);
                if (!(zzoh == null || zzoh.zzjw() == null)) {
                    zzoh.zzjw().pause();
                }
            } catch (RemoteException e) {
                String str3 = "Fail to pause adapter: ";
                str2 = String.valueOf(str2);
                zzpy.zzbe(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
    }

    public void resume() {
        String valueOf;
        zzac.zzdn("resume must be called on the main UI thread.");
        for (String valueOf2 : this.zzUG.keySet()) {
            try {
                zzoh zzoh = (zzoh) this.zzUG.get(valueOf2);
                if (!(zzoh == null || zzoh.zzjw() == null)) {
                    zzoh.zzjw().resume();
                }
            } catch (RemoteException e) {
                String str = "Fail to resume adapter: ";
                valueOf2 = String.valueOf(valueOf2);
                zzpy.zzbe(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
            }
        }
    }

    public void zza(zznx zznx) {
        zzac.zzdn("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(zznx.zzvd)) {
            zzpy.zzbe("Invalid ad unit id. Aborting.");
            zzpi.zzWR.post(new C04381(this));
            return;
        }
        this.zzUH = false;
        this.zzsw.zzvd = zznx.zzvd;
        super.zzb(zznx.zzRd);
    }

    public void zza(final zza zza, zzgf zzgf) {
        if (zza.errorCode != -2) {
            zzpi.zzWR.post(new Runnable(this) {
                final /* synthetic */ zznp zzUI;

                public void run() {
                    this.zzUI.zzb(new zzov(zza, null, null, null, null, null, null, null));
                }
            });
            return;
        }
        this.zzsw.zzvl = zza;
        if (zza.zzVr == null) {
            this.zzsw.zzvl = zzd(zza);
        }
        this.zzsw.zzvF = 0;
        this.zzsw.zzvi = zzv.zzcI().zza(this.zzsw.zzqr, this.zzsw.zzvl, this);
    }

    protected boolean zza(zzdy zzdy, zzov zzov, boolean z) {
        return false;
    }

    public boolean zza(zzov zzov, zzov zzov2) {
        return true;
    }

    @Nullable
    public zzoh zzaM(String str) {
        zzoh zzoh;
        Throwable th;
        String str2;
        String valueOf;
        zzoh zzoh2 = (zzoh) this.zzUG.get(str);
        if (zzoh2 != null) {
            return zzoh2;
        }
        try {
            zzoh = new zzoh(("com.google.ads.mediation.admob.AdMobAdapter".equals(str) ? zzUF : this.zzsD).zzar(str), this);
            try {
                this.zzUG.put(str, zzoh);
                return zzoh;
            } catch (Throwable e) {
                th = e;
                str2 = "Fail to instantiate adapter ";
                valueOf = String.valueOf(str);
                zzpy.zzc(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf), th);
                return zzoh;
            }
        } catch (Throwable e2) {
            th = e2;
            zzoh = zzoh2;
            str2 = "Fail to instantiate adapter ";
            valueOf = String.valueOf(str);
            if (valueOf.length() == 0) {
            }
            zzpy.zzc(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf), th);
            return zzoh;
        }
    }

    public void zzc(@Nullable zzok zzok) {
        if (!(this.zzsw.zzvk == null || this.zzsw.zzvk.zzKA == null)) {
            zzv.zzdc().zza(this.zzsw.zzqr, this.zzsw.zzvf.zzaZ, this.zzsw.zzvk, this.zzsw.zzvd, false, this.zzsw.zzvk.zzKA.zzJQ);
        }
        if (!(this.zzsw.zzvk == null || this.zzsw.zzvk.zzVr == null || TextUtils.isEmpty(this.zzsw.zzvk.zzVr.zzKf))) {
            zzok = new zzok(this.zzsw.zzvk.zzVr.zzKf, this.zzsw.zzvk.zzVr.zzKg);
        }
        zza(zzok);
    }

    public void zzjo() {
        zzac.zzdn("showAd must be called on the main UI thread.");
        if (isLoaded()) {
            this.zzUH = true;
            zzoh zzaM = zzaM(this.zzsw.zzvk.zzKC);
            if (zzaM != null && zzaM.zzjw() != null) {
                try {
                    zzaM.zzjw().showVideo();
                    return;
                } catch (Throwable e) {
                    zzpy.zzc("Could not call showVideo.", e);
                    return;
                }
            }
            return;
        }
        zzpy.zzbe("The reward video has not loaded.");
    }

    public void zzjp() {
        onAdClicked();
    }
}
