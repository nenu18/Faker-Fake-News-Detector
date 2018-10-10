package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzqq.zza;

@zzmb
public class zzlo extends zzlj implements zza {
    zzlo(Context context, zzov.zza zza, zzqp zzqp, zzln.zza zza2) {
        super(context, zza, zzqp, zza2);
    }

    protected void zziB() {
    }

    protected void zziu() {
        if (this.zzPp.errorCode == -2) {
            this.zzGt.zzkV().zza((zza) this);
            zziB();
            zzpy.zzbc("Loading HTML in WebView.");
            this.zzGt.loadDataWithBaseURL(this.zzPp.zzNb, this.zzPp.body, "text/html", "UTF-8", null);
        }
    }
}
