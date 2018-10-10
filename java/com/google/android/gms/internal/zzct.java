package com.google.android.gms.internal;

import com.google.android.gms.internal.zzja.zzc;
import com.google.android.gms.internal.zzqi.zza;
import com.google.android.gms.internal.zzqi.zzb;
import java.util.Map;
import org.json.JSONObject;

@zzmb
public class zzct implements zzcu {
    private final zzhx zzwA = new C06786(this);
    private final zzhx zzwB = new C06797(this);
    private zzc zzwD;
    private boolean zzwE;
    private final zzcq zzwx;
    private final zzhx zzwz = new C06775(this);

    /* renamed from: com.google.android.gms.internal.zzct$1 */
    class C06731 implements zzqi.zzc<zzjb> {
        final /* synthetic */ zzct zzwF;

        C06731(zzct zzct) {
            this.zzwF = zzct;
        }

        public void zzb(zzjb zzjb) {
            this.zzwF.zzwE = true;
            this.zzwF.zzc(zzjb);
        }

        public /* synthetic */ void zzd(Object obj) {
            zzb((zzjb) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct$2 */
    class C06742 implements zza {
        final /* synthetic */ zzct zzwF;

        C06742(zzct zzct) {
            this.zzwF = zzct;
        }

        public void run() {
            this.zzwF.zzwx.zzb(this.zzwF);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct$4 */
    class C06764 implements zzqi.zzc<zzjb> {
        final /* synthetic */ zzct zzwF;

        C06764(zzct zzct) {
            this.zzwF = zzct;
        }

        public void zzb(zzjb zzjb) {
            this.zzwF.zzd(zzjb);
        }

        public /* synthetic */ void zzd(Object obj) {
            zzb((zzjb) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct$5 */
    class C06775 implements zzhx {
        final /* synthetic */ zzct zzwF;

        C06775(zzct zzct) {
            this.zzwF = zzct;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            if (this.zzwF.zzwx.zzb((Map) map)) {
                this.zzwF.zzwx.zzb(zzqp, (Map) map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct$6 */
    class C06786 implements zzhx {
        final /* synthetic */ zzct zzwF;

        C06786(zzct zzct) {
            this.zzwF = zzct;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            if (this.zzwF.zzwx.zzb((Map) map)) {
                this.zzwF.zzwx.zza(this.zzwF, (Map) map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzct$7 */
    class C06797 implements zzhx {
        final /* synthetic */ zzct zzwF;

        C06797(zzct zzct) {
            this.zzwF = zzct;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            if (this.zzwF.zzwx.zzb((Map) map)) {
                this.zzwF.zzwx.zzc(map);
            }
        }
    }

    public zzct(zzcq zzcq, zzja zzja) {
        this.zzwx = zzcq;
        this.zzwD = zzja.zzgv();
        this.zzwD.zza(new C06731(this), new C06742(this));
        String str = "Core JS tracking ad unit: ";
        String valueOf = String.valueOf(this.zzwx.zzdN().zzdy());
        zzpy.zzbc(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    void zzc(zzjb zzjb) {
        zzjb.zza("/updateActiveView", this.zzwz);
        zzjb.zza("/untrackActiveViewUnit", this.zzwA);
        zzjb.zza("/visibilityChanged", this.zzwB);
    }

    public void zzc(final JSONObject jSONObject, boolean z) {
        this.zzwD.zza(new zzqi.zzc<zzjb>(this) {
            public void zzb(zzjb zzjb) {
                zzjb.zza("AFMA_updateActiveView", jSONObject);
            }

            public /* synthetic */ void zzd(Object obj) {
                zzb((zzjb) obj);
            }
        }, new zzb());
    }

    void zzd(zzjb zzjb) {
        zzjb.zzb("/visibilityChanged", this.zzwB);
        zzjb.zzb("/untrackActiveViewUnit", this.zzwA);
        zzjb.zzb("/updateActiveView", this.zzwz);
    }

    public boolean zzdR() {
        return this.zzwE;
    }

    public void zzdS() {
        this.zzwD.zza(new C06764(this), new zzb());
        this.zzwD.release();
    }
}
