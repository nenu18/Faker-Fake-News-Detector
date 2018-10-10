package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zzcs implements zzcu {
    private final zzhx zzwA = new C06712(this);
    private final zzhx zzwB = new C06723(this);
    private final zzcq zzwx;
    private final zzjb zzwy;
    private final zzhx zzwz = new C06701(this);

    /* renamed from: com.google.android.gms.internal.zzcs$1 */
    class C06701 implements zzhx {
        final /* synthetic */ zzcs zzwC;

        C06701(zzcs zzcs) {
            this.zzwC = zzcs;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            this.zzwC.zzwx.zzb(zzqp, (Map) map);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcs$2 */
    class C06712 implements zzhx {
        final /* synthetic */ zzcs zzwC;

        C06712(zzcs zzcs) {
            this.zzwC = zzcs;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            this.zzwC.zzwx.zza(this.zzwC, (Map) map);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzcs$3 */
    class C06723 implements zzhx {
        final /* synthetic */ zzcs zzwC;

        C06723(zzcs zzcs) {
            this.zzwC = zzcs;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            this.zzwC.zzwx.zzc(map);
        }
    }

    public zzcs(zzcq zzcq, zzjb zzjb) {
        this.zzwx = zzcq;
        this.zzwy = zzjb;
        zzc(this.zzwy);
        String str = "Custom JS tracking ad unit: ";
        String valueOf = String.valueOf(this.zzwx.zzdN().zzdy());
        zzpy.zzbc(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    void zzc(zzjb zzjb) {
        zzjb.zza("/updateActiveView", this.zzwz);
        zzjb.zza("/untrackActiveViewUnit", this.zzwA);
        zzjb.zza("/visibilityChanged", this.zzwB);
    }

    public void zzc(JSONObject jSONObject, boolean z) {
        if (z) {
            this.zzwx.zzb((zzcu) this);
        } else {
            this.zzwy.zza("AFMA_updateActiveView", jSONObject);
        }
    }

    void zzd(zzjb zzjb) {
        zzjb.zzb("/visibilityChanged", this.zzwB);
        zzjb.zzb("/untrackActiveViewUnit", this.zzwA);
        zzjb.zzb("/updateActiveView", this.zzwz);
    }

    public boolean zzdR() {
        return true;
    }

    public void zzdS() {
        zzd(this.zzwy);
    }
}
