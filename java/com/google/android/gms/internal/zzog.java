package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzov.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@zzmb
public class zzog extends zzpd implements zzof {
    private final Context mContext;
    private final zza zzPo;
    private final long zzUP;
    private final ArrayList<Future> zzVa;
    private final ArrayList<String> zzVb;
    private final HashMap<String, zzoa> zzVc;
    private final List<zzob> zzVd;
    private final HashSet<String> zzVe;
    private final zznp zzVf;
    private final Object zzrN;

    public zzog(Context context, zza zza, zznp zznp) {
        this(context, zza, zznp, ((Long) zzfx.zzCs.get()).longValue());
    }

    zzog(Context context, zza zza, zznp zznp, long j) {
        this.zzVa = new ArrayList();
        this.zzVb = new ArrayList();
        this.zzVc = new HashMap();
        this.zzVd = new ArrayList();
        this.zzVe = new HashSet();
        this.zzrN = new Object();
        this.mContext = context;
        this.zzPo = zza;
        this.zzVf = zznp;
        this.zzUP = j;
    }

    private static int zzR(int i) {
        switch (i) {
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 4;
            case 6:
                return 0;
            case 7:
                return 3;
            default:
                return 6;
        }
    }

    private zzov zza(int i, @Nullable String str, @Nullable zzji zzji) {
        return new zzov(this.zzPo.zzSF.zzRd, null, this.zzPo.zzVB.zzJY, i, this.zzPo.zzVB.zzJZ, this.zzPo.zzVB.zzRM, this.zzPo.zzVB.orientation, this.zzPo.zzVB.zzKe, this.zzPo.zzSF.zzRg, this.zzPo.zzVB.zzRK, zzji, null, str, this.zzPo.zzVr, null, this.zzPo.zzVB.zzRL, this.zzPo.zzvj, this.zzPo.zzVB.zzRJ, this.zzPo.zzVv, this.zzPo.zzVB.zzRO, this.zzPo.zzVB.zzRP, this.zzPo.zzVp, null, this.zzPo.zzVB.zzRZ, this.zzPo.zzVB.zzSa, this.zzPo.zzVB.zzSb, this.zzPo.zzVB.zzSc, this.zzPo.zzVB.zzSd, zzjv(), this.zzPo.zzVB.zzKb, this.zzPo.zzVB.zzSg);
    }

    private zzov zza(String str, zzji zzji) {
        return zza(-2, str, zzji);
    }

    private static String zza(zzob zzob) {
        String str = zzob.zzJJ;
        int zzR = zzR(zzob.errorCode);
        return new StringBuilder(String.valueOf(str).length() + 33).append(str).append(".").append(zzR).append(".").append(zzob.zzKF).toString();
    }

    private void zza(String str, String str2, zzji zzji) {
        synchronized (this.zzrN) {
            zzoh zzaM = this.zzVf.zzaM(str);
            if (zzaM == null || zzaM.zzjx() == null || zzaM.zzjw() == null) {
                this.zzVd.add(new zzob.zza().zzaP(zzji.zzJJ).zzaO(str).zzl(0).zzac(7).zzjt());
                return;
            }
            zzpd zza = zza(str, str2, zzji, zzaM);
            this.zzVa.add((Future) zza.zziw());
            this.zzVb.add(str);
            this.zzVc.put(str, zza);
        }
    }

    private zzov zzju() {
        return zza(3, null, null);
    }

    private String zzjv() {
        StringBuilder stringBuilder = new StringBuilder("");
        if (this.zzVd == null) {
            return stringBuilder.toString();
        }
        for (zzob zzob : this.zzVd) {
            if (!(zzob == null || TextUtils.isEmpty(zzob.zzJJ))) {
                stringBuilder.append(String.valueOf(zza(zzob)).concat("_"));
            }
        }
        return stringBuilder.substring(0, Math.max(0, stringBuilder.length() - 1));
    }

    public void onStop() {
    }

    protected zzoa zza(String str, String str2, zzji zzji, zzoh zzoh) {
        return new zzoa(this.mContext, str, str2, zzji, this.zzPo, zzoh, this, this.zzUP);
    }

    public void zza(String str, int i) {
    }

    public void zzaN(String str) {
        synchronized (this.zzrN) {
            this.zzVe.add(str);
        }
    }

    public void zzcm() {
        zzoa zzoa;
        final zzov zza;
        for (zzji zzji : this.zzPo.zzVr.zzJW) {
            String str = zzji.zzJO;
            for (String str2 : zzji.zzJI) {
                String str22;
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str22) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str22)) {
                    try {
                        str22 = new JSONObject(str).getString("class_name");
                    } catch (Throwable e) {
                        zzpy.zzb("Unable to determine custom event class name, skipping...", e);
                    }
                }
                zza(str22, str, zzji);
            }
        }
        int i = 0;
        while (i < this.zzVa.size()) {
            String str3;
            try {
                ((Future) this.zzVa.get(i)).get();
                synchronized (this.zzrN) {
                    str3 = (String) this.zzVb.get(i);
                    if (!TextUtils.isEmpty(str3)) {
                        zzoa = (zzoa) this.zzVc.get(str3);
                        if (zzoa != null) {
                            this.zzVd.add(zzoa.zzjq());
                        }
                    }
                }
                synchronized (this.zzrN) {
                    if (this.zzVe.contains(this.zzVb.get(i))) {
                        str3 = (String) this.zzVb.get(i);
                        zza = zza(str3, this.zzVc.get(str3) != null ? ((zzoa) this.zzVc.get(str3)).zzjr() : null);
                        zzpx.zzXU.post(new Runnable(this) {
                            final /* synthetic */ zzog zzVg;

                            public void run() {
                                this.zzVg.zzVf.zzb(zza);
                            }
                        });
                        return;
                    }
                }
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                synchronized (this.zzrN) {
                    str3 = (String) this.zzVb.get(i);
                    if (!TextUtils.isEmpty(str3)) {
                        zzoa = (zzoa) this.zzVc.get(str3);
                        if (zzoa != null) {
                            this.zzVd.add(zzoa.zzjq());
                        }
                    }
                }
            } catch (Throwable e3) {
                zzpy.zzc("Unable to resolve rewarded adapter.", e3);
                synchronized (this.zzrN) {
                    str3 = (String) this.zzVb.get(i);
                    if (!TextUtils.isEmpty(str3)) {
                        zzoa = (zzoa) this.zzVc.get(str3);
                        if (zzoa != null) {
                            this.zzVd.add(zzoa.zzjq());
                        }
                    }
                }
            } catch (Throwable e32) {
                Throwable th = e32;
                synchronized (this.zzrN) {
                    str3 = (String) this.zzVb.get(i);
                    if (!TextUtils.isEmpty(str3)) {
                        zzoa = (zzoa) this.zzVc.get(str3);
                        if (zzoa != null) {
                            this.zzVd.add(zzoa.zzjq());
                        }
                    }
                }
            }
        }
        zza = zzju();
        zzpx.zzXU.post(new Runnable(this) {
            final /* synthetic */ zzog zzVg;

            public void run() {
                this.zzVg.zzVf.zzb(zza);
            }
        });
        return;
        i++;
    }
}
