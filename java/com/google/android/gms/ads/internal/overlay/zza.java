package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpy;

@zzmb
public class zza {
    public boolean zza(Context context, Intent intent, zzq zzq) {
        try {
            String str = "Launching an intent: ";
            String valueOf = String.valueOf(intent.toURI());
            zzpe.m13v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            zzv.zzcJ().zzb(context, intent);
            if (zzq != null) {
                zzq.zzbE();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzpy.zzbe(e.getMessage());
            return false;
        }
    }

    public boolean zza(Context context, zzc zzc, zzq zzq) {
        if (zzc == null) {
            zzpy.zzbe("No intent data for launcher overlay.");
            return false;
        } else if (zzc.intent != null) {
            return zza(context, zzc.intent, zzq);
        } else {
            Intent intent = new Intent();
            if (TextUtils.isEmpty(zzc.url)) {
                zzpy.zzbe("Open GMSG did not contain a URL.");
                return false;
            }
            if (TextUtils.isEmpty(zzc.mimeType)) {
                intent.setData(Uri.parse(zzc.url));
            } else {
                intent.setDataAndType(Uri.parse(zzc.url), zzc.mimeType);
            }
            intent.setAction("android.intent.action.VIEW");
            if (!TextUtils.isEmpty(zzc.packageName)) {
                intent.setPackage(zzc.packageName);
            }
            if (!TextUtils.isEmpty(zzc.zzLZ)) {
                String[] split = zzc.zzLZ.split("/", 2);
                if (split.length < 2) {
                    String str = "Could not parse component name from open GMSG: ";
                    String valueOf = String.valueOf(zzc.zzLZ);
                    zzpy.zzbe(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    return false;
                }
                intent.setClassName(split[0], split[1]);
            }
            Object obj = zzc.zzMa;
            if (!TextUtils.isEmpty(obj)) {
                int parseInt;
                try {
                    parseInt = Integer.parseInt(obj);
                } catch (NumberFormatException e) {
                    zzpy.zzbe("Could not parse intent flags.");
                    parseInt = 0;
                }
                intent.addFlags(parseInt);
            }
            return zza(context, intent, zzq);
        }
    }
}
