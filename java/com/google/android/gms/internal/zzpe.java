package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

@zzmb
public final class zzpe extends zzpy {
    /* renamed from: v */
    public static void m13v(String str) {
        if (zzkh()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static boolean zzkg() {
        return ((Boolean) zzfx.zzCL.get()).booleanValue();
    }

    public static boolean zzkh() {
        return zzpy.zzai(2) && zzkg();
    }
}
