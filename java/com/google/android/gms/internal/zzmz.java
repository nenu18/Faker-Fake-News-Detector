package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.zzja.zzb;
import com.google.android.gms.internal.zzja.zzc;
import com.google.android.gms.internal.zzmq.zza;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public final class zzmz extends zza {
    private static zzmz zzSS;
    private static final Object zztU = new Object();
    private final Context mContext;
    private final zzmy zzST;
    private final zzfq zzSU;
    private final zzja zzSV;

    /* renamed from: com.google.android.gms.internal.zzmz$1 */
    class C04341 implements Callable<Void> {
        final /* synthetic */ zzmy zzSW;
        final /* synthetic */ zzmh zzSX;
        final /* synthetic */ Bundle zzSY;
        final /* synthetic */ Context zztd;

        C04341(zzmy zzmy, Context context, zzmh zzmh, Bundle bundle) {
            this.zzSW = zzmy;
            this.zztd = context;
            this.zzSX = zzmh;
            this.zzSY = bundle;
        }

        public /* synthetic */ Object call() throws Exception {
            return zzbl();
        }

        public Void zzbl() throws Exception {
            String str = this.zzSX.zzRe.packageName;
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzmz$2 */
    class C04352 implements Runnable {
        final /* synthetic */ zznb zzSZ;
        final /* synthetic */ zzgd zzTa;
        final /* synthetic */ String zzTb;
        final /* synthetic */ zzgf zzsK;
        final /* synthetic */ zzja zzsZ;

        /* renamed from: com.google.android.gms.internal.zzmz$2$2 */
        class C07752 implements zzqi.zza {
            C07752(C04352 c04352) {
            }

            public void run() {
            }
        }

        C04352(zzja zzja, zznb zznb, zzgf zzgf, zzgd zzgd, String str) {
            this.zzsZ = zzja;
            this.zzSZ = zznb;
            this.zzsK = zzgf;
            this.zzTa = zzgd;
            this.zzTb = str;
        }

        public void run() {
            zzc zzgv = this.zzsZ.zzgv();
            this.zzSZ.zzb(zzgv);
            this.zzsK.zza(this.zzTa, "rwc");
            final zzgd zzfw = this.zzsK.zzfw();
            zzgv.zza(new zzqi.zzc<zzjb>(this) {
                final /* synthetic */ C04352 zzTd;

                public void zzb(zzjb zzjb) {
                    this.zzTd.zzsK.zza(zzfw, "jsf");
                    this.zzTd.zzsK.zzfx();
                    zzjb.zza("/invalidRequest", this.zzTd.zzSZ.zzTk);
                    zzjb.zza("/loadAdURL", this.zzTd.zzSZ.zzTl);
                    zzjb.zza("/loadAd", this.zzTd.zzSZ.zzTm);
                    try {
                        zzjb.zzi("AFMA_getAd", this.zzTd.zzTb);
                    } catch (Throwable e) {
                        zzpy.zzb("Error requesting an ad url", e);
                    }
                }

                public /* synthetic */ void zzd(Object obj) {
                    zzb((zzjb) obj);
                }
            }, new C07752(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzmz$3 */
    class C04363 implements Runnable {
        final /* synthetic */ zzmy zzSW;
        final /* synthetic */ zzmh zzSX;
        final /* synthetic */ zznb zzSZ;
        final /* synthetic */ Context zztd;

        C04363(zzmy zzmy, Context context, zznb zznb, zzmh zzmh) {
            this.zzSW = zzmy;
            this.zztd = context;
            this.zzSZ = zznb;
            this.zzSX = zzmh;
        }

        public void run() {
            this.zzSW.zzSM.zza(this.zztd, this.zzSZ, this.zzSX.zzvf);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzmz$4 */
    class C07764 implements zzpn<zzix> {
        C07764(zzmz zzmz) {
        }

        public void zza(zzix zzix) {
            zzix.zza("/log", zzhw.zzHl);
        }

        public /* synthetic */ void zzd(Object obj) {
            zza((zzix) obj);
        }
    }

    zzmz(Context context, zzfq zzfq, zzmy zzmy) {
        this.mContext = context;
        this.zzST = zzmy;
        this.zzSU = zzfq;
        this.zzSV = new zzja(context.getApplicationContext() != null ? context.getApplicationContext() : context, zzqa.zzkK(), zzfq.zzfl(), new C07764(this), new zzb());
    }

    private static zzmk zza(Context context, zzja zzja, zzfq zzfq, zzmy zzmy, zzmh zzmh) {
        Bundle bundle;
        Future future;
        Throwable e;
        zzmk zzmk;
        zzpy.zzbc("Starting ad request from service using: AFMA_getAd");
        zzfx.initialize(context);
        zzqf zzii = zzmy.zzSQ.zzii();
        zzgf zzgf = new zzgf(((Boolean) zzfx.zzBK.get()).booleanValue(), "load_ad", zzmh.zzvj.zzzk);
        if (zzmh.versionCode > 10 && zzmh.zzRu != -1) {
            zzgf.zza(zzgf.zzc(zzmh.zzRu), "cts");
        }
        zzgd zzfw = zzgf.zzfw();
        Bundle bundle2 = (zzmh.versionCode < 4 || zzmh.zzRk == null) ? null : zzmh.zzRk;
        if (!((Boolean) zzfx.zzCb.get()).booleanValue() || zzmy.zzSI == null) {
            bundle = bundle2;
            future = null;
        } else {
            if (bundle2 == null && ((Boolean) zzfx.zzCc.get()).booleanValue()) {
                zzpe.m13v("contentInfo is not present, but we'll still launch the app index task");
                bundle2 = new Bundle();
            }
            if (bundle2 != null) {
                bundle = bundle2;
                future = zzph.zza(new C04341(zzmy, context, zzmh, bundle2));
            } else {
                bundle = bundle2;
                future = null;
            }
        }
        zzqd zzqd = new zzqd(null);
        Bundle bundle3 = zzmh.zzRd.extras;
        Object obj = (bundle3 == null || bundle3.getString("_ad") == null) ? null : 1;
        if (zzmh.zzRB && obj == null) {
            zzqf zza = zzmy.zzSN.zza(zzmh.applicationInfo);
        } else {
            Object obj2 = zzqd;
        }
        zznf zzv = zzv.zzcS().zzv(context);
        if (zzv.zzUm == -1) {
            zzpy.zzbc("Device is offline.");
            return new zzmk(2);
        }
        String string;
        String uuid = zzmh.versionCode >= 7 ? zzmh.zzRr : UUID.randomUUID().toString();
        zznb zznb = new zznb(uuid, zzmh.applicationInfo.packageName);
        if (zzmh.zzRd.extras != null) {
            string = zzmh.zzRd.extras.getString("_ad");
            if (string != null) {
                return zzna.zza(context, zzmh, string);
            }
        }
        List zza2 = zzmy.zzSL.zza(zzmh);
        String zzg = zzmy.zzSR.zzg(zzmh);
        if (future != null) {
            try {
                zzpe.m13v("Waiting for app index fetching task.");
                future.get(((Long) zzfx.zzCd.get()).longValue(), TimeUnit.MILLISECONDS);
                zzpe.m13v("App index fetching task completed.");
            } catch (ExecutionException e2) {
                e = e2;
                zzpy.zzc("Failed to fetch app index signal", e);
            } catch (InterruptedException e3) {
                e = e3;
                zzpy.zzc("Failed to fetch app index signal", e);
            } catch (TimeoutException e4) {
                zzpy.zzbc("Timed out waiting for app index fetching task");
            }
        }
        string = zzmh.zzRe.packageName;
        zzd(zzii);
        JSONObject zza3 = zzna.zza(context, new zzmx().zzf(zzmh).zza(zzv).zza(null).zzc(zzc(zza)).zze(zzd(zzii)).zzaJ(zzg).zzk(zza2).zzf(bundle).zzaK(null).zzh(zzmy.zzSJ.zzi(context)));
        if (zza3 == null) {
            return new zzmk(0);
        }
        if (zzmh.versionCode < 7) {
            try {
                zza3.put("request_id", uuid);
            } catch (JSONException e5) {
            }
        }
        try {
            zza3.put("prefetch_mode", "url");
        } catch (Throwable e6) {
            zzpy.zzc("Failed putting prefetch parameters to ad request.", e6);
        }
        String jSONObject = zza3.toString();
        zzgf.zza(zzfw, "arc");
        zzpi.zzWR.post(new C04352(zzja, zznb, zzgf, zzgf.zzfw(), jSONObject));
        try {
            zzne zzne = (zzne) zznb.zzjh().get(10, TimeUnit.SECONDS);
            if (zzne == null) {
                zzmk = new zzmk(0);
                return zzmk;
            } else if (zzne.getErrorCode() != -2) {
                zzmk = new zzmk(zzne.getErrorCode());
                zzpi.zzWR.post(new C04363(zzmy, context, zznb, zzmh));
                return zzmk;
            } else {
                if (zzgf.zzfA() != null) {
                    zzgf.zza(zzgf.zzfA(), "rur");
                }
                zzmk = null;
                if (!TextUtils.isEmpty(zzne.zzjm())) {
                    zzmk = zzna.zza(context, zzmh, zzne.zzjm());
                }
                if (zzmk == null && !TextUtils.isEmpty(zzne.getUrl())) {
                    zzmk = zza(zzmh, context, zzmh.zzvf.zzaZ, zzne.getUrl(), null, zzne, zzgf, zzmy);
                }
                if (zzmk == null) {
                    zzmk = new zzmk(0);
                }
                zzgf.zza(zzfw, "tts");
                zzmk.zzRX = zzgf.zzfy();
                zzpi.zzWR.post(new C04363(zzmy, context, zznb, zzmh));
                return zzmk;
            }
        } catch (Exception e7) {
            zzmk = new zzmk(0);
            return zzmk;
        } finally {
            zzpi.zzWR.post(new C04363(zzmy, context, zznb, zzmh));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzmk zza(com.google.android.gms.internal.zzmh r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, com.google.android.gms.internal.zzne r18, com.google.android.gms.internal.zzgf r19, com.google.android.gms.internal.zzmy r20) {
        /*
        if (r19 == 0) goto L_0x00db;
    L_0x0002:
        r2 = r19.zzfw();
        r3 = r2;
    L_0x0007:
        r8 = new com.google.android.gms.internal.zznc;	 Catch:{ IOException -> 0x00e6 }
        r2 = r18.zzjj();	 Catch:{ IOException -> 0x00e6 }
        r8.<init>(r13, r2);	 Catch:{ IOException -> 0x00e6 }
        r4 = "AdRequestServiceImpl: Sending request: ";
        r2 = java.lang.String.valueOf(r16);	 Catch:{ IOException -> 0x00e6 }
        r5 = r2.length();	 Catch:{ IOException -> 0x00e6 }
        if (r5 == 0) goto L_0x00df;
    L_0x001c:
        r2 = r4.concat(r2);	 Catch:{ IOException -> 0x00e6 }
    L_0x0020:
        com.google.android.gms.internal.zzpy.zzbc(r2);	 Catch:{ IOException -> 0x00e6 }
        r4 = new java.net.URL;	 Catch:{ IOException -> 0x00e6 }
        r0 = r16;
        r4.<init>(r0);	 Catch:{ IOException -> 0x00e6 }
        r2 = 0;
        r5 = com.google.android.gms.ads.internal.zzv.zzcP();	 Catch:{ IOException -> 0x00e6 }
        r10 = r5.elapsedRealtime();	 Catch:{ IOException -> 0x00e6 }
        r6 = r2;
        r7 = r4;
    L_0x0035:
        r2 = r7.openConnection();	 Catch:{ IOException -> 0x00e6 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ IOException -> 0x00e6 }
        r4 = com.google.android.gms.ads.internal.zzv.zzcJ();	 Catch:{ all -> 0x010b }
        r5 = 0;
        r4.zza(r14, r15, r5, r2);	 Catch:{ all -> 0x010b }
        r4 = android.text.TextUtils.isEmpty(r17);	 Catch:{ all -> 0x010b }
        if (r4 != 0) goto L_0x0056;
    L_0x0049:
        r4 = r18.zzjl();	 Catch:{ all -> 0x010b }
        if (r4 == 0) goto L_0x0056;
    L_0x004f:
        r4 = "x-afma-drt-cookie";
        r0 = r17;
        r2.addRequestProperty(r4, r0);	 Catch:{ all -> 0x010b }
    L_0x0056:
        r4 = r13.zzRC;	 Catch:{ all -> 0x010b }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x010b }
        if (r5 != 0) goto L_0x0068;
    L_0x005e:
        r5 = "Sending webview cookie in ad request header.";
        com.google.android.gms.internal.zzpy.zzbc(r5);	 Catch:{ all -> 0x010b }
        r5 = "Cookie";
        r2.addRequestProperty(r5, r4);	 Catch:{ all -> 0x010b }
    L_0x0068:
        if (r18 == 0) goto L_0x0094;
    L_0x006a:
        r4 = r18.zzjk();	 Catch:{ all -> 0x010b }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x010b }
        if (r4 != 0) goto L_0x0094;
    L_0x0074:
        r4 = 1;
        r2.setDoOutput(r4);	 Catch:{ all -> 0x010b }
        r4 = r18.zzjk();	 Catch:{ all -> 0x010b }
        r9 = r4.getBytes();	 Catch:{ all -> 0x010b }
        r4 = r9.length;	 Catch:{ all -> 0x010b }
        r2.setFixedLengthStreamingMode(r4);	 Catch:{ all -> 0x010b }
        r5 = 0;
        r4 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x0105 }
        r12 = r2.getOutputStream();	 Catch:{ all -> 0x0105 }
        r4.<init>(r12);	 Catch:{ all -> 0x0105 }
        r4.write(r9);	 Catch:{ all -> 0x0197 }
        com.google.android.gms.common.util.zzo.zzb(r4);	 Catch:{ all -> 0x010b }
    L_0x0094:
        r9 = r2.getResponseCode();	 Catch:{ all -> 0x010b }
        r12 = r2.getHeaderFields();	 Catch:{ all -> 0x010b }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 < r4) goto L_0x0116;
    L_0x00a0:
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 >= r4) goto L_0x0116;
    L_0x00a4:
        r6 = r7.toString();	 Catch:{ all -> 0x010b }
        r5 = 0;
        r4 = new java.io.InputStreamReader;	 Catch:{ all -> 0x0110 }
        r7 = r2.getInputStream();	 Catch:{ all -> 0x0110 }
        r4.<init>(r7);	 Catch:{ all -> 0x0110 }
        r5 = com.google.android.gms.ads.internal.zzv.zzcJ();	 Catch:{ all -> 0x0194 }
        r5 = r5.zza(r4);	 Catch:{ all -> 0x0194 }
        com.google.android.gms.common.util.zzo.zzb(r4);	 Catch:{ all -> 0x010b }
        zza(r6, r12, r5, r9);	 Catch:{ all -> 0x010b }
        r8.zzb(r6, r12, r5);	 Catch:{ all -> 0x010b }
        if (r19 == 0) goto L_0x00d2;
    L_0x00c5:
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x010b }
        r5 = 0;
        r6 = "ufe";
        r4[r5] = r6;	 Catch:{ all -> 0x010b }
        r0 = r19;
        r0.zza(r3, r4);	 Catch:{ all -> 0x010b }
    L_0x00d2:
        r3 = r8.zzj(r10);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
    L_0x00da:
        return r2;
    L_0x00db:
        r2 = 0;
        r3 = r2;
        goto L_0x0007;
    L_0x00df:
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x00e6 }
        r2.<init>(r4);	 Catch:{ IOException -> 0x00e6 }
        goto L_0x0020;
    L_0x00e6:
        r2 = move-exception;
        r3 = "Error while connecting to ad server: ";
        r2 = r2.getMessage();
        r2 = java.lang.String.valueOf(r2);
        r4 = r2.length();
        if (r4 == 0) goto L_0x018d;
    L_0x00f7:
        r2 = r3.concat(r2);
    L_0x00fb:
        com.google.android.gms.internal.zzpy.zzbe(r2);
        r2 = new com.google.android.gms.internal.zzmk;
        r3 = 2;
        r2.<init>(r3);
        goto L_0x00da;
    L_0x0105:
        r3 = move-exception;
        r4 = r5;
    L_0x0107:
        com.google.android.gms.common.util.zzo.zzb(r4);	 Catch:{ all -> 0x010b }
        throw r3;	 Catch:{ all -> 0x010b }
    L_0x010b:
        r3 = move-exception;
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        throw r3;	 Catch:{ IOException -> 0x00e6 }
    L_0x0110:
        r3 = move-exception;
        r4 = r5;
    L_0x0112:
        com.google.android.gms.common.util.zzo.zzb(r4);	 Catch:{ all -> 0x010b }
        throw r3;	 Catch:{ all -> 0x010b }
    L_0x0116:
        r4 = r7.toString();	 Catch:{ all -> 0x010b }
        r5 = 0;
        zza(r4, r12, r5, r9);	 Catch:{ all -> 0x010b }
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 < r4) goto L_0x015d;
    L_0x0122:
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r9 >= r4) goto L_0x015d;
    L_0x0126:
        r4 = "Location";
        r4 = r2.getHeaderField(r4);	 Catch:{ all -> 0x010b }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x010b }
        if (r5 == 0) goto L_0x0142;
    L_0x0132:
        r3 = "No location header to follow redirect.";
        com.google.android.gms.internal.zzpy.zzbe(r3);	 Catch:{ all -> 0x010b }
        r3 = new com.google.android.gms.internal.zzmk;	 Catch:{ all -> 0x010b }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
        goto L_0x00da;
    L_0x0142:
        r5 = new java.net.URL;	 Catch:{ all -> 0x010b }
        r5.<init>(r4);	 Catch:{ all -> 0x010b }
        r4 = r6 + 1;
        r6 = 5;
        if (r4 <= r6) goto L_0x0181;
    L_0x014c:
        r3 = "Too many redirects.";
        com.google.android.gms.internal.zzpy.zzbe(r3);	 Catch:{ all -> 0x010b }
        r3 = new com.google.android.gms.internal.zzmk;	 Catch:{ all -> 0x010b }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
        goto L_0x00da;
    L_0x015d:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r4 = 46;
        r3.<init>(r4);	 Catch:{ all -> 0x010b }
        r4 = "Received error HTTP response code: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x010b }
        r3 = r3.append(r9);	 Catch:{ all -> 0x010b }
        r3 = r3.toString();	 Catch:{ all -> 0x010b }
        com.google.android.gms.internal.zzpy.zzbe(r3);	 Catch:{ all -> 0x010b }
        r3 = new com.google.android.gms.internal.zzmk;	 Catch:{ all -> 0x010b }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
        goto L_0x00da;
    L_0x0181:
        r8.zzk(r12);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        if (r20 == 0) goto L_0x0189;
    L_0x0189:
        r6 = r4;
        r7 = r5;
        goto L_0x0035;
    L_0x018d:
        r2 = new java.lang.String;
        r2.<init>(r3);
        goto L_0x00fb;
    L_0x0194:
        r3 = move-exception;
        goto L_0x0112;
    L_0x0197:
        r3 = move-exception;
        goto L_0x0107;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzmz.zza(com.google.android.gms.internal.zzmh, android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zzne, com.google.android.gms.internal.zzgf, com.google.android.gms.internal.zzmy):com.google.android.gms.internal.zzmk");
    }

    public static zzmz zza(Context context, zzfq zzfq, zzmy zzmy) {
        zzmz zzmz;
        synchronized (zztU) {
            if (zzSS == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzSS = new zzmz(context, zzfq, zzmy);
            }
            zzmz = zzSS;
        }
        return zzmz;
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzpy.zzai(2)) {
            zzpe.m13v(new StringBuilder(String.valueOf(str).length() + 39).append("Http Response: {\n  URL:\n    ").append(str).append("\n  Headers:").toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    String str32;
                    zzpe.m13v(new StringBuilder(String.valueOf(str32).length() + 5).append("    ").append(str32).append(":").toString());
                    for (String str322 : (List) map.get(str322)) {
                        String str4 = "      ";
                        str322 = String.valueOf(str322);
                        zzpe.m13v(str322.length() != 0 ? str4.concat(str322) : new String(str4));
                    }
                }
            }
            zzpe.m13v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    zzpe.m13v(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                zzpe.m13v("    null");
            }
            zzpe.m13v("  Response Code:\n    " + i + "\n}");
        }
    }

    private static Location zzc(zzqf<Location> zzqf) {
        try {
            return (Location) zzqf.get(((Long) zzfx.zzEl.get()).longValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            zzpy.zzc("Exception caught while getting location", e);
            return null;
        }
    }

    private static Bundle zzd(zzqf<Bundle> zzqf) {
        Bundle bundle = new Bundle();
        try {
            return (Bundle) zzqf.get(((Long) zzfx.zzED.get()).longValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            zzpy.zzc("Exception caught while getting parental controls.", e);
            return bundle;
        }
    }

    public void zza(final zzmh zzmh, final zzmr zzmr) {
        zzv.zzcN().zzc(this.mContext, zzmh.zzvf);
        zzph.zza(new Runnable(this) {
            final /* synthetic */ zzmz zzTf;

            public void run() {
                zzmk zzd;
                try {
                    zzd = this.zzTf.zzd(zzmh);
                } catch (Throwable e) {
                    zzv.zzcN().zza(e, "AdRequestServiceImpl.loadAdAsync");
                    zzpy.zzc("Could not fetch ad response due to an Exception.", e);
                    zzd = null;
                }
                if (zzd == null) {
                    zzd = new zzmk(0);
                }
                try {
                    zzmr.zzb(zzd);
                } catch (Throwable e2) {
                    zzpy.zzc("Fail to forward ad response.", e2);
                }
            }
        });
    }

    public zzmk zzd(zzmh zzmh) {
        return zza(this.mContext, this.zzSV, this.zzSU, this.zzST, zzmh);
    }
}
