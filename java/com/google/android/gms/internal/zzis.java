package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.zznf.zza;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

@zzmb
public class zzis {
    private final LinkedList<zzit> zzIA = new LinkedList();
    @Nullable
    private zzip zzIB;
    private final Map<zzit, zziu> zzIz = new HashMap();

    private static void zza(String str, zzit zzit) {
        if (zzpy.zzai(2)) {
            zzpe.m13v(String.format(str, new Object[]{zzit}));
        }
    }

    private String[] zzai(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), "UTF-8");
            }
            return split;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    private boolean zzaj(String str) {
        try {
            return Pattern.matches((String) zzfx.zzCH.get(), str);
        } catch (Throwable e) {
            zzv.zzcN().zza(e, "InterstitialAdPool.isExcludedAdUnit");
            return false;
        }
    }

    private static void zzc(Bundle bundle, String str) {
        String[] split = str.split("/", 2);
        if (split.length != 0) {
            String str2 = split[0];
            if (split.length == 1) {
                bundle.remove(str2);
                return;
            }
            Bundle bundle2 = bundle.getBundle(str2);
            if (bundle2 != null) {
                zzc(bundle2, split[1]);
            }
        }
    }

    private String zzgk() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = this.zzIA.iterator();
            while (it.hasNext()) {
                stringBuilder.append(Base64.encodeToString(((zzit) it.next()).toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    stringBuilder.append("\u0000");
                }
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    @Nullable
    static Bundle zzk(zzdy zzdy) {
        Bundle bundle = zzdy.zzyP;
        return bundle == null ? null : bundle.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
    }

    static zzdy zzl(zzdy zzdy) {
        zzdy zzo = zzo(zzdy);
        Bundle zzk = zzk(zzo);
        if (zzk == null) {
            zzk = new Bundle();
            zzo.zzyP.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzk);
        }
        zzk.putBoolean("_skipMediation", true);
        return zzo;
    }

    static boolean zzm(zzdy zzdy) {
        Bundle bundle = zzdy.zzyP;
        if (bundle == null) {
            return false;
        }
        bundle = bundle.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        return bundle != null && bundle.containsKey("_skipMediation");
    }

    private static zzdy zzn(zzdy zzdy) {
        zzdy zzo = zzo(zzdy);
        for (String zzc : ((String) zzfx.zzCD.get()).split(",")) {
            zzc(zzo.zzyP, zzc);
        }
        return zzo;
    }

    static zzdy zzo(zzdy zzdy) {
        Parcel obtain = Parcel.obtain();
        zzdy.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        zzdy zzdy2 = (zzdy) zzdy.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        zzdy.zzj(zzdy2);
        return zzdy2;
    }

    void flush() {
        while (this.zzIA.size() > 0) {
            zzit zzit = (zzit) this.zzIA.remove();
            zziu zziu = (zziu) this.zzIz.get(zzit);
            zza("Flushing interstitial queue for %s.", zzit);
            while (zziu.size() > 0) {
                zziu.zzp(null).zzIG.zzck();
            }
            this.zzIz.remove(zzit);
        }
    }

    void restore() {
        if (this.zzIB != null) {
            SharedPreferences sharedPreferences = this.zzIB.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
            flush();
            try {
                Map hashMap = new HashMap();
                for (Entry entry : sharedPreferences.getAll().entrySet()) {
                    if (!((String) entry.getKey()).equals("PoolKeys")) {
                        zziw zzak = zziw.zzak((String) entry.getValue());
                        zzit zzit = new zzit(zzak.zzug, zzak.zztq, zzak.zzIE);
                        if (!this.zzIz.containsKey(zzit)) {
                            this.zzIz.put(zzit, new zziu(zzak.zzug, zzak.zztq, zzak.zzIE));
                            hashMap.put(zzit.toString(), zzit);
                            zza("Restored interstitial queue for %s.", zzit);
                        }
                    }
                }
                for (Object obj : zzai(sharedPreferences.getString("PoolKeys", ""))) {
                    zzit zzit2 = (zzit) hashMap.get(obj);
                    if (this.zzIz.containsKey(zzit2)) {
                        this.zzIA.add(zzit2);
                    }
                }
            } catch (Throwable th) {
                zzv.zzcN().zza(th, "InterstitialAdPool.restore");
                zzpy.zzc("Malformed preferences value for InterstitialAdPool.", th);
                this.zzIz.clear();
                this.zzIA.clear();
            }
        }
    }

    void save() {
        if (this.zzIB != null) {
            Editor edit = this.zzIB.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            edit.clear();
            for (Entry entry : this.zzIz.entrySet()) {
                zzit zzit = (zzit) entry.getKey();
                zziu zziu = (zziu) entry.getValue();
                if (zziu.zzgp()) {
                    edit.putString(zzit.toString(), new zziw(zziu).zzgs());
                    zza("Saved interstitial queue for %s.", zzit);
                }
            }
            edit.putString("PoolKeys", zzgk());
            edit.apply();
        }
    }

    @Nullable
    zza zza(zzdy zzdy, String str) {
        if (zzaj(str)) {
            return null;
        }
        zziu zziu;
        int i = new zza(this.zzIB.getApplicationContext()).zzjn().zzUm;
        zzdy zzn = zzn(zzdy);
        zzit zzit = new zzit(zzn, str, i);
        zziu zziu2 = (zziu) this.zzIz.get(zzit);
        if (zziu2 == null) {
            zza("Interstitial pool created at %s.", zzit);
            zziu2 = new zziu(zzn, str, i);
            this.zzIz.put(zzit, zziu2);
            zziu = zziu2;
        } else {
            zziu = zziu2;
        }
        this.zzIA.remove(zzit);
        this.zzIA.add(zzit);
        zziu.zzgo();
        while (this.zzIA.size() > ((Integer) zzfx.zzCE.get()).intValue()) {
            zzit zzit2 = (zzit) this.zzIA.remove();
            zziu zziu3 = (zziu) this.zzIz.get(zzit2);
            zza("Evicting interstitial queue for %s.", zzit2);
            while (zziu3.size() > 0) {
                zziu3.zzp(null).zzIG.zzck();
            }
            this.zzIz.remove(zzit2);
        }
        while (zziu.size() > 0) {
            zza zzp = zziu.zzp(zzn);
            if (!zzp.zzIK || zzv.zzcP().currentTimeMillis() - zzp.zzIJ <= 1000 * ((long) ((Integer) zzfx.zzCG.get()).intValue())) {
                String str2 = zzp.zzIH != null ? " (inline) " : " ";
                zza(new StringBuilder(String.valueOf(str2).length() + 34).append("Pooled interstitial").append(str2).append("returned at %s.").toString(), zzit);
                return zzp;
            }
            zza("Expired interstitial at %s.", zzit);
        }
        return null;
    }

    void zza(zzip zzip) {
        if (this.zzIB == null) {
            this.zzIB = zzip.zzgi();
            restore();
        }
    }

    void zzb(zzdy zzdy, String str) {
        if (this.zzIB != null) {
            int i = new zza(this.zzIB.getApplicationContext()).zzjn().zzUm;
            zzdy zzn = zzn(zzdy);
            zzit zzit = new zzit(zzn, str, i);
            zziu zziu = (zziu) this.zzIz.get(zzit);
            if (zziu == null) {
                zza("Interstitial pool created at %s.", zzit);
                zziu = new zziu(zzn, str, i);
                this.zzIz.put(zzit, zziu);
            }
            zziu.zza(this.zzIB, zzdy);
            zziu.zzgo();
            zza("Inline entry added to the queue at %s.", zzit);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void zzgj() {
        /*
        r9 = this;
        r8 = 2;
        r0 = r9.zzIB;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r0 = r9.zzIz;
        r0 = r0.entrySet();
        r3 = r0.iterator();
    L_0x0010:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0076;
    L_0x0016:
        r0 = r3.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (com.google.android.gms.internal.zzit) r1;
        r0 = r0.getValue();
        r0 = (com.google.android.gms.internal.zziu) r0;
        r2 = com.google.android.gms.internal.zzpy.zzai(r8);
        if (r2 == 0) goto L_0x0056;
    L_0x002e:
        r2 = r0.size();
        r4 = r0.zzgm();
        if (r4 >= r2) goto L_0x0056;
    L_0x0038:
        r5 = "Loading %s/%s pooled interstitials for %s.";
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r2 - r4;
        r4 = java.lang.Integer.valueOf(r4);
        r6[r7] = r4;
        r4 = 1;
        r2 = java.lang.Integer.valueOf(r2);
        r6[r4] = r2;
        r6[r8] = r1;
        r2 = java.lang.String.format(r5, r6);
        com.google.android.gms.internal.zzpe.m13v(r2);
    L_0x0056:
        r0.zzgn();
    L_0x0059:
        r4 = r0.size();
        r2 = com.google.android.gms.internal.zzfx.zzCF;
        r2 = r2.get();
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        if (r4 >= r2) goto L_0x0010;
    L_0x006b:
        r2 = "Pooling and loading one new interstitial for %s.";
        zza(r2, r1);
        r2 = r9.zzIB;
        r0.zzb(r2);
        goto L_0x0059;
    L_0x0076:
        r9.save();
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzis.zzgj():void");
    }
}
