package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzv;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public final class zzhw {
    public static final zzhx zzHd = new C07171();
    public static final zzhx zzHe = new C07259();
    public static final zzhx zzHf = new zzhx() {
        public void zza(zzqp zzqp, Map<String, String> map) {
            PackageManager packageManager = zzqp.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            Object optString2 = jSONObject2.optString("u");
                            Object optString3 = jSONObject2.optString("i");
                            Object optString4 = jSONObject2.optString("m");
                            Object optString5 = jSONObject2.optString("p");
                            Object optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (Throwable e) {
                                zzpy.zzb("Error constructing openable urls response.", e);
                            }
                        } catch (Throwable e2) {
                            zzpy.zzb("Error parsing the intent data.", e2);
                        }
                    }
                    zzqp.zzb("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    zzqp.zzb("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                zzqp.zzb("openableIntents", new JSONObject());
            }
        }
    };
    public static final zzhx zzHg = new zzhx() {
        public void zza(zzqp zzqp, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                zzpy.zzbe("URL missing from click GMSG.");
                return;
            }
            Uri zza;
            Uri parse = Uri.parse(str);
            try {
                zzav zzkX = zzqp.zzkX();
                if (zzkX != null && zzkX.zzc(parse)) {
                    zza = zzkX.zza(parse, zzqp.getContext(), zzqp.getView());
                    new zzps(zzqp.getContext(), zzqp.zzkY().zzaZ, zza.toString()).zziw();
                }
            } catch (zzaw e) {
                String str2 = "Unable to append parameter to URL: ";
                str = String.valueOf(str);
                zzpy.zzbe(str.length() != 0 ? str2.concat(str) : new String(str2));
            }
            zza = parse;
            new zzps(zzqp.getContext(), zzqp.zzkY().zzaZ, zza.toString()).zziw();
        }
    };
    public static final zzhx zzHh = new zzhx() {
        public void zza(zzqp zzqp, Map<String, String> map) {
            zze zzkT = zzqp.zzkT();
            if (zzkT != null) {
                zzkT.close();
                return;
            }
            zzkT = zzqp.zzkU();
            if (zzkT != null) {
                zzkT.close();
            } else {
                zzpy.zzbe("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    };
    public static final zzhx zzHi = new zzhx() {
        private void zzd(zzqp zzqp) {
            zzpy.zzbd("Received support message, responding.");
            zzd zzbz = zzqp.zzbz();
            if (!(zzbz == null || zzbz.zzsO == null)) {
                zzqp.getContext();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "checkSupport");
                jSONObject.put("supports", false);
                zzqp.zzb("appStreaming", jSONObject);
            } catch (Throwable th) {
            }
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            if ("checkSupport".equals(map.get("action"))) {
                zzd(zzqp);
                return;
            }
            zze zzkT = zzqp.zzkT();
            if (zzkT != null) {
                zzkT.zzg(zzqp, map);
            }
        }
    };
    public static final zzhx zzHj = new zzhx() {
        public void zza(zzqp zzqp, Map<String, String> map) {
            zzqp.zzK("1".equals(map.get("custom_close")));
        }
    };
    public static final zzhx zzHk = new zzhx() {
        public void zza(zzqp zzqp, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                zzpy.zzbe("URL missing from httpTrack GMSG.");
            } else {
                new zzps(zzqp.getContext(), zzqp.zzkY().zzaZ, str).zziw();
            }
        }
    };
    public static final zzhx zzHl = new zzhx() {
        public void zza(zzqp zzqp, Map<String, String> map) {
            String str = "Received log message: ";
            String valueOf = String.valueOf((String) map.get("string"));
            zzpy.zzbd(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    };
    public static final zzhx zzHm = new C07182();
    public static final zzhx zzHn = new C07193();
    public static final zzhx zzHo = new C07204();
    public static final zzhx zzHp = new C07215();
    public static final zzhx zzHq = new zzih();
    public static final zzhx zzHr = new zzii();
    public static final zzhx zzHs = new zzim();
    public static final zzhx zzHt = new zzhv();
    public static final zzif zzHu = new zzif();
    public static final zzhx zzHv = new C07226();
    public static final zzhx zzHw = new C07237();
    public static final zzhx zzHx = new C07248();

    /* renamed from: com.google.android.gms.internal.zzhw$1 */
    class C07171 implements zzhx {
        C07171() {
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$2 */
    class C07182 implements zzhx {
        C07182() {
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            zzgs zzll = zzqp.zzll();
            if (zzll != null) {
                zzll.zzfR();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$3 */
    class C07193 implements zzhx {
        C07193() {
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                zzav zzkX = zzqp.zzkX();
                if (zzkX != null) {
                    zzkX.zzW().zza(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                zzpy.zzbe("Could not parse touch parameters from gmsg.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$4 */
    class C07204 implements zzhx {
        C07204() {
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            if (((Boolean) zzfx.zzCX.get()).booleanValue()) {
                zzqp.zzL(!Boolean.parseBoolean((String) map.get("disabled")));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$5 */
    class C07215 implements zzhx {
        C07215() {
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            String str = (String) map.get("action");
            if ("pause".equals(str)) {
                zzqp.zzbV();
            } else if ("resume".equals(str)) {
                zzqp.zzbW();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$6 */
    class C07226 implements zzhx {
        C07226() {
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                zzqp.zzkV().zzlu();
            } else if (map.keySet().contains("stop")) {
                zzqp.zzkV().zzlv();
            } else if (map.keySet().contains("cancel")) {
                zzqp.zzkV().zzlw();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$7 */
    class C07237 implements zzhx {
        C07237() {
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                zzqp.zzM(true);
            }
            if (map.keySet().contains("stop")) {
                zzqp.zzM(false);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$8 */
    class C07248 implements zzhx {
        C07248() {
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            zzqp.zza("locationReady", zzv.zzcJ().zza((View) zzqp, (WindowManager) zzqp.getContext().getSystemService("window")));
            zzpy.zzbe("GET LOCATION COMPILED");
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$9 */
    class C07259 implements zzhx {
        C07259() {
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzpy.zzbe("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = zzqp.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            zzqp.zza("openableURLs", hashMap);
        }
    }
}
