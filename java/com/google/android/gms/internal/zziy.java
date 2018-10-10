package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzd;
import java.util.concurrent.Future;

@zzmb
public class zziy {

    private static class zza<JavascriptEngine> extends zzqc<JavascriptEngine> {
        JavascriptEngine zzIW;

        private zza() {
        }
    }

    private zzix zza(Context context, zzqa zzqa, final zza<zzix> zza, zzav zzav, zzd zzd) {
        zzix zziz = new zziz(context, zzqa, zzav, zzd);
        zza.zzIW = zziz;
        zziz.zza(new com.google.android.gms.internal.zzix.zza(this) {
            public void zzgu() {
                zza.zzh((zzix) zza.zzIW);
            }
        });
        return zziz;
    }

    public Future<zzix> zza(Context context, zzqa zzqa, String str, zzav zzav, zzd zzd) {
        final Future zza = new zza();
        final Context context2 = context;
        final zzqa zzqa2 = zzqa;
        final zzav zzav2 = zzav;
        final zzd zzd2 = zzd;
        final String str2 = str;
        zzpi.zzWR.post(new Runnable(this) {
            final /* synthetic */ zziy zzIV;

            public void run() {
                this.zzIV.zza(context2, zzqa2, zza, zzav2, zzd2).zzam(str2);
            }
        });
        return zza;
    }
}
