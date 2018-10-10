package com.google.android.gms.internal;

import com.google.android.gms.internal.zzja.zzc;
import java.util.Map;
import java.util.concurrent.Future;

@zzmb
public final class zznb {
    private String zzOn;
    private String zzTh;
    private zzqc<zzne> zzTi = new zzqc();
    zzc zzTj;
    public final zzhx zzTk = new C07771(this);
    public final zzhx zzTl = new C07782(this);
    public final zzhx zzTm = new C07793(this);
    private final Object zzrN = new Object();

    /* renamed from: com.google.android.gms.internal.zznb$1 */
    class C07771 implements zzhx {
        final /* synthetic */ zznb zzTn;

        C07771(zznb zznb) {
            this.zzTn = zznb;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            synchronized (this.zzTn.zzrN) {
                if (this.zzTn.zzTi.isDone()) {
                } else if (this.zzTn.zzOn.equals(map.get("request_id"))) {
                    zzne zzne = new zzne(1, map);
                    String valueOf = String.valueOf(zzne.getType());
                    String valueOf2 = String.valueOf(zzne.zzji());
                    zzpy.zzbe(new StringBuilder((String.valueOf(valueOf).length() + 24) + String.valueOf(valueOf2).length()).append("Invalid ").append(valueOf).append(" request error: ").append(valueOf2).toString());
                    this.zzTn.zzTi.zzh(zzne);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zznb$2 */
    class C07782 implements zzhx {
        final /* synthetic */ zznb zzTn;

        C07782(zznb zznb) {
            this.zzTn = zznb;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            synchronized (this.zzTn.zzrN) {
                if (this.zzTn.zzTi.isDone()) {
                    return;
                }
                zzne zzne = new zzne(-2, map);
                if (this.zzTn.zzOn.equals(zzne.getRequestId())) {
                    String url = zzne.getUrl();
                    if (url == null) {
                        zzpy.zzbe("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (url.contains("%40mediation_adapters%40")) {
                        String replaceAll = url.replaceAll("%40mediation_adapters%40", zzpc.zza(zzqp.getContext(), (String) map.get("check_adapters"), this.zzTn.zzTh));
                        zzne.setUrl(replaceAll);
                        url = "Ad request URL modified to ";
                        replaceAll = String.valueOf(replaceAll);
                        zzpe.m13v(replaceAll.length() != 0 ? url.concat(replaceAll) : new String(url));
                    }
                    this.zzTn.zzTi.zzh(zzne);
                    return;
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zznb$3 */
    class C07793 implements zzhx {
        final /* synthetic */ zznb zzTn;

        C07793(zznb zznb) {
            this.zzTn = zznb;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            synchronized (this.zzTn.zzrN) {
                if (this.zzTn.zzTi.isDone()) {
                    return;
                }
                zzne zzne = new zzne(-2, map);
                if (this.zzTn.zzOn.equals(zzne.getRequestId())) {
                    this.zzTn.zzTi.zzh(zzne);
                    return;
                }
            }
        }
    }

    public zznb(String str, String str2) {
        this.zzTh = str2;
        this.zzOn = str;
    }

    public void zzb(zzc zzc) {
        this.zzTj = zzc;
    }

    public zzc zzjg() {
        return this.zzTj;
    }

    public Future<zzne> zzjh() {
        return this.zzTi;
    }
}
