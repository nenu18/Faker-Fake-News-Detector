package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzv;
import org.json.JSONObject;

@zzmb
public class zzmd extends zzpd implements com.google.android.gms.internal.zzme.zza {
    private final Context mContext;
    private final zzav zzGr;
    private zzmh zzKG;
    zzjj zzKq;
    zzmk zzPp;
    private Runnable zzPq;
    private final Object zzPr = new Object();
    private final com.google.android.gms.internal.zzmc.zza zzQQ;
    private final com.google.android.gms.internal.zzmh.zza zzQR;
    zzpk zzQS;

    /* renamed from: com.google.android.gms.internal.zzmd$1 */
    class C04281 implements Runnable {
        final /* synthetic */ zzmd zzQT;

        C04281(zzmd zzmd) {
            this.zzQT = zzmd;
        }

        public void run() {
            synchronized (this.zzQT.zzPr) {
                if (this.zzQT.zzQS == null) {
                    return;
                }
                this.zzQT.onStop();
                this.zzQT.zzd(2, "Timed out waiting for ad response.");
            }
        }
    }

    @zzmb
    static final class zza extends Exception {
        private final int zzPF;

        public zza(String str, int i) {
            super(str);
            this.zzPF = i;
        }

        public int getErrorCode() {
            return this.zzPF;
        }
    }

    public zzmd(Context context, com.google.android.gms.internal.zzmh.zza zza, zzav zzav, com.google.android.gms.internal.zzmc.zza zza2) {
        this.zzQQ = zza2;
        this.mContext = context;
        this.zzQR = zza;
        this.zzGr = zzav;
    }

    private void zzd(int i, String str) {
        if (i == 3 || i == -1) {
            zzpy.zzbd(str);
        } else {
            zzpy.zzbe(str);
        }
        if (this.zzPp == null) {
            this.zzPp = new zzmk(i);
        } else {
            this.zzPp = new zzmk(i, this.zzPp.zzKe);
        }
        this.zzQQ.zza(new com.google.android.gms.internal.zzov.zza(this.zzKG != null ? this.zzKG : new zzmh(this.zzQR, null, -1), this.zzPp, this.zzKq, null, i, -1, this.zzPp.zzRO, null));
    }

    public void onStop() {
        synchronized (this.zzPr) {
            if (this.zzQS != null) {
                this.zzQS.cancel();
            }
        }
    }

    zzpk zza(zzqa zzqa, zzqi<zzmh> zzqi) {
        return zzme.zza(this.mContext, zzqa, zzqi, this);
    }

    protected zzec zzb(zzmh zzmh) throws zza {
        int i;
        if (this.zzPp.zzzo) {
            for (zzec zzec : zzmh.zzvj.zzzm) {
                if (zzec.zzzo) {
                    return new zzec(zzec, zzmh.zzvj.zzzm);
                }
            }
        }
        if (this.zzPp.zzRN == null) {
            throw new zza("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.zzPp.zzRN.split("x");
        if (split.length != 2) {
            String str = "Invalid ad size format from the ad response: ";
            String valueOf = String.valueOf(this.zzPp.zzRN);
            throw new zza(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (zzec zzec2 : zzmh.zzvj.zzzm) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                i = zzec2.width == -1 ? (int) (((float) zzec2.widthPixels) / f) : zzec2.width;
                int i2 = zzec2.height == -2 ? (int) (((float) zzec2.heightPixels) / f) : zzec2.height;
                if (parseInt == i && parseInt2 == i2 && !zzec2.zzzo) {
                    return new zzec(zzec2, zzmh.zzvj.zzzm);
                }
            }
            str = "The ad size from the ad response was not one of the requested sizes: ";
            valueOf = String.valueOf(this.zzPp.zzRN);
            throw new zza(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        } catch (NumberFormatException e) {
            str = "Invalid ad size number from the ad response: ";
            valueOf = String.valueOf(this.zzPp.zzRN);
            throw new zza(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        }
    }

    public void zzb(@NonNull zzmk zzmk) {
        zzpy.zzbc("Received ad response.");
        this.zzPp = zzmk;
        long elapsedRealtime = zzv.zzcP().elapsedRealtime();
        synchronized (this.zzPr) {
            this.zzQS = null;
        }
        zzv.zzcN().zzd(this.mContext, this.zzPp.zzRB);
        try {
            if (this.zzPp.errorCode == -2 || this.zzPp.errorCode == -3) {
                JSONObject jSONObject;
                zziX();
                zzec zzb = this.zzKG.zzvj.zzzm != null ? zzb(this.zzKG) : null;
                zzv.zzcN().zzE(this.zzPp.zzRU);
                zzv.zzcN().zzF(this.zzPp.zzSh);
                if (!TextUtils.isEmpty(this.zzPp.zzRS)) {
                    try {
                        jSONObject = new JSONObject(this.zzPp.zzRS);
                    } catch (Throwable e) {
                        zzpy.zzb("Error parsing the JSON for Active View.", e);
                    }
                    this.zzQQ.zza(new com.google.android.gms.internal.zzov.zza(this.zzKG, this.zzPp, this.zzKq, zzb, -2, elapsedRealtime, this.zzPp.zzRO, jSONObject));
                    zzpi.zzWR.removeCallbacks(this.zzPq);
                    return;
                }
                jSONObject = null;
                this.zzQQ.zza(new com.google.android.gms.internal.zzov.zza(this.zzKG, this.zzPp, this.zzKq, zzb, -2, elapsedRealtime, this.zzPp.zzRO, jSONObject));
                zzpi.zzWR.removeCallbacks(this.zzPq);
                return;
            }
            throw new zza("There was a problem getting an ad response. ErrorCode: " + this.zzPp.errorCode, this.zzPp.errorCode);
        } catch (zza e2) {
            zzd(e2.getErrorCode(), e2.getMessage());
            zzpi.zzWR.removeCallbacks(this.zzPq);
        }
    }

    public void zzcm() {
        zzpy.zzbc("AdLoaderBackgroundTask started.");
        this.zzPq = new C04281(this);
        zzpi.zzWR.postDelayed(this.zzPq, ((Long) zzfx.zzDd.get()).longValue());
        final zzqi zzqj = new zzqj();
        long elapsedRealtime = zzv.zzcP().elapsedRealtime();
        zzph.zza(new Runnable(this) {
            final /* synthetic */ zzmd zzQT;

            public void run() {
                synchronized (this.zzQT.zzPr) {
                    this.zzQT.zzQS = this.zzQT.zza(this.zzQT.zzQR.zzvf, zzqj);
                    if (this.zzQT.zzQS == null) {
                        this.zzQT.zzd(0, "Could not start the ad request service.");
                        zzpi.zzWR.removeCallbacks(this.zzQT.zzPq);
                    }
                }
            }
        });
        this.zzKG = new zzmh(this.zzQR, this.zzGr.zzW().zzb(this.mContext), elapsedRealtime);
        zzqj.zzg(this.zzKG);
    }

    protected void zziX() throws zza {
        if (this.zzPp.errorCode != -3) {
            if (TextUtils.isEmpty(this.zzPp.body)) {
                throw new zza("No fill from ad server.", 3);
            }
            zzv.zzcN().zzc(this.mContext, this.zzPp.zzRl);
            if (this.zzPp.zzRK) {
                try {
                    this.zzKq = new zzjj(this.zzPp.body);
                    zzv.zzcN().zzG(this.zzKq.zzKc);
                } catch (Throwable e) {
                    zzpy.zzb("Could not parse mediation config.", e);
                    String str = "Could not parse mediation config: ";
                    String valueOf = String.valueOf(this.zzPp.body);
                    throw new zza(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
                }
            }
            zzv.zzcN().zzG(this.zzPp.zzKc);
            if (!TextUtils.isEmpty(this.zzPp.zzRC) && ((Boolean) zzfx.zzEH.get()).booleanValue()) {
                zzpy.zzbc("Received cookie from server. Setting webview cookie in CookieManager.");
                CookieManager zzL = zzv.zzcL().zzL(this.mContext);
                if (zzL != null) {
                    zzL.setCookie("googleads.g.doubleclick.net", this.zzPp.zzRC);
                }
            }
        }
    }
}
