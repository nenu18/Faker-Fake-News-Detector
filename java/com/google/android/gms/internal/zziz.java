package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.zzix.zza;
import org.json.JSONObject;

@zzmb
public class zziz implements zzix {
    private final zzqp zzGt;

    public zziz(Context context, zzqa zzqa, @Nullable zzav zzav, zzd zzd) {
        this.zzGt = zzv.zzcK().zza(context, new zzec(), false, false, zzav, zzqa, null, null, zzd);
        this.zzGt.getWebView().setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable) {
        if (zzeh.zzeO().zzkJ()) {
            runnable.run();
        } else {
            zzpi.zzWR.post(runnable);
        }
    }

    public void destroy() {
        this.zzGt.destroy();
    }

    public void zza(zzdt zzdt, zzh zzh, zzht zzht, zzq zzq, boolean z, zzhz zzhz, zzib zzib, zze zze, zzkp zzkp) {
        this.zzGt.zzkV().zza(zzdt, zzh, zzht, zzq, z, zzhz, zzib, new zze(this.zzGt.getContext(), false), zzkp, null);
    }

    public void zza(final zza zza) {
        this.zzGt.zzkV().zza(new zzqq.zza(this) {
            public void zza(zzqp zzqp, boolean z) {
                zza.zzgu();
            }
        });
    }

    public void zza(String str, zzhx zzhx) {
        this.zzGt.zzkV().zza(str, zzhx);
    }

    public void zza(final String str, final JSONObject jSONObject) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zziz zzIZ;

            public void run() {
                this.zzIZ.zzGt.zza(str, jSONObject);
            }
        });
    }

    public void zzal(String str) {
        final String format = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str});
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zziz zzIZ;

            public void run() {
                this.zzIZ.zzGt.loadData(format, "text/html", "UTF-8");
            }
        });
    }

    public void zzam(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zziz zzIZ;

            public void run() {
                this.zzIZ.zzGt.loadUrl(str);
            }
        });
    }

    public void zzan(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zziz zzIZ;

            public void run() {
                this.zzIZ.zzGt.loadData(str, "text/html", "UTF-8");
            }
        });
    }

    public void zzb(String str, zzhx zzhx) {
        this.zzGt.zzkV().zzb(str, zzhx);
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.zzGt.zzb(str, jSONObject);
    }

    public zzjc zzgt() {
        return new zzjd(this);
    }

    public void zzi(final String str, final String str2) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zziz zzIZ;

            public void run() {
                this.zzIZ.zzGt.zzi(str, str2);
            }
        });
    }
}
