package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzox;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqi.zzb;
import com.google.android.gms.internal.zzqi.zzc;
import com.google.android.gms.internal.zzqp;
import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zzg {
    private Context mContext;
    private final Object zzrN = new Object();
    public final zzhx zzsX = new C06141(this);

    /* renamed from: com.google.android.gms.ads.internal.zzg$1 */
    class C06141 implements zzhx {
        final /* synthetic */ zzg zzsY;

        C06141(zzg zzg) {
            this.zzsY = zzg;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            zzqp.zzb("/appSettingsFetched", (zzhx) this);
            synchronized (this.zzsY.zzrN) {
                if (map != null) {
                    if ("true".equalsIgnoreCase((String) map.get("isSuccessful"))) {
                        zzv.zzcN().zzd(this.zzsY.mContext, (String) map.get("appSettingsJson"));
                    }
                }
            }
        }
    }

    private static boolean zza(@Nullable zzox zzox) {
        if (zzox == null) {
            return true;
        }
        boolean z = (((zzv.zzcP().currentTimeMillis() - zzox.zzjF()) > ((Long) zzfx.zzEr.get()).longValue() ? 1 : ((zzv.zzcP().currentTimeMillis() - zzox.zzjF()) == ((Long) zzfx.zzEr.get()).longValue() ? 0 : -1)) > 0) || !zzox.zzjG();
        return z;
    }

    public void zza(Context context, zzqa zzqa, boolean z, @Nullable zzox zzox, String str, @Nullable String str2) {
        if (!zza(zzox)) {
            return;
        }
        if (context == null) {
            zzpy.zzbe("Context not provided to fetch application settings");
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            zzpy.zzbe("App settings could not be fetched. Required parameters missing");
        } else {
            this.mContext = context;
            final zzja zzd = zzv.zzcJ().zzd(context, zzqa);
            final String str3 = str;
            final String str4 = str2;
            final boolean z2 = z;
            final Context context2 = context;
            zzpi.zzWR.post(new Runnable(this) {
                final /* synthetic */ zzg zzsY;

                /* renamed from: com.google.android.gms.ads.internal.zzg$2$1 */
                class C06151 implements zzc<zzjb> {
                    final /* synthetic */ C02582 zzte;

                    C06151(C02582 c02582) {
                        this.zzte = c02582;
                    }

                    public void zzb(zzjb zzjb) {
                        zzjb.zza("/appSettingsFetched", this.zzte.zzsY.zzsX);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (!TextUtils.isEmpty(str3)) {
                                jSONObject.put("app_id", str3);
                            } else if (!TextUtils.isEmpty(str4)) {
                                jSONObject.put("ad_unit_id", str4);
                            }
                            jSONObject.put("is_init", z2);
                            jSONObject.put("pn", context2.getPackageName());
                            zzjb.zza("AFMA_fetchAppSettings", jSONObject);
                        } catch (Throwable e) {
                            zzjb.zzb("/appSettingsFetched", this.zzte.zzsY.zzsX);
                            zzpy.zzb("Error requesting application settings", e);
                        }
                    }

                    public /* synthetic */ void zzd(Object obj) {
                        zzb((zzjb) obj);
                    }
                }

                public void run() {
                    zzd.zzgv().zza(new C06151(this), new zzb());
                }
            });
        }
    }
}
