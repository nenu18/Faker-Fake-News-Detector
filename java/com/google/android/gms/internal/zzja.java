package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import java.util.Map;

@zzmb
public class zzja {
    private final Context mContext;
    private final String zzJd;
    private zzpn<zzix> zzJe;
    private zzpn<zzix> zzJf;
    @Nullable
    private zzd zzJg;
    private int zzJh;
    private final Object zzrN;
    private final zzqa zztr;

    static class zza {
        static int zzJs = 60000;
        static int zzJt = 10000;
    }

    public static class zzb<T> implements zzpn<T> {
        public void zzd(T t) {
        }
    }

    public static class zzc extends zzqj<zzjb> {
        private final zzd zzJu;
        private boolean zzJv;
        private final Object zzrN = new Object();

        /* renamed from: com.google.android.gms.internal.zzja$zzc$1 */
        class C07491 implements com.google.android.gms.internal.zzqi.zzc<zzjb> {
            C07491(zzc zzc) {
            }

            public void zzb(zzjb zzjb) {
                zzpe.m13v("Ending javascript session.");
                ((zzjc) zzjb).zzgA();
            }

            public /* synthetic */ void zzd(Object obj) {
                zzb((zzjb) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzja$zzc$2 */
        class C07502 implements com.google.android.gms.internal.zzqi.zzc<zzjb> {
            final /* synthetic */ zzc zzJw;

            C07502(zzc zzc) {
                this.zzJw = zzc;
            }

            public void zzb(zzjb zzjb) {
                zzpe.m13v("Releasing engine reference.");
                this.zzJw.zzJu.zzgx();
            }

            public /* synthetic */ void zzd(Object obj) {
                zzb((zzjb) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzja$zzc$3 */
        class C07513 implements com.google.android.gms.internal.zzqi.zza {
            final /* synthetic */ zzc zzJw;

            C07513(zzc zzc) {
                this.zzJw = zzc;
            }

            public void run() {
                this.zzJw.zzJu.zzgx();
            }
        }

        public zzc(zzd zzd) {
            this.zzJu = zzd;
        }

        public void release() {
            synchronized (this.zzrN) {
                if (this.zzJv) {
                    return;
                }
                this.zzJv = true;
                zza(new C07491(this), new com.google.android.gms.internal.zzqi.zzb());
                zza(new C07502(this), new C07513(this));
            }
        }
    }

    public static class zzd extends zzqj<zzix> {
        private zzpn<zzix> zzJf;
        private boolean zzJx;
        private int zzJy;
        private final Object zzrN = new Object();

        /* renamed from: com.google.android.gms.internal.zzja$zzd$3 */
        class C07543 implements com.google.android.gms.internal.zzqi.zzc<zzix> {
            final /* synthetic */ zzd zzJA;

            C07543(zzd zzd) {
                this.zzJA = zzd;
            }

            public void zza(final zzix zzix) {
                zzv.zzcJ().runOnUiThread(new Runnable(this) {
                    final /* synthetic */ C07543 zzJC;

                    public void run() {
                        this.zzJC.zzJA.zzJf.zzd(zzix);
                        zzix.destroy();
                    }
                });
            }

            public /* synthetic */ void zzd(Object obj) {
                zza((zzix) obj);
            }
        }

        public zzd(zzpn<zzix> zzpn) {
            this.zzJf = zzpn;
            this.zzJx = false;
            this.zzJy = 0;
        }

        public zzc zzgw() {
            final zzc zzc = new zzc(this);
            synchronized (this.zzrN) {
                zza(new com.google.android.gms.internal.zzqi.zzc<zzix>(this) {
                    public void zza(zzix zzix) {
                        zzpe.m13v("Getting a new session for JS Engine.");
                        zzc.zzg(zzix.zzgt());
                    }

                    public /* synthetic */ void zzd(Object obj) {
                        zza((zzix) obj);
                    }
                }, new com.google.android.gms.internal.zzqi.zza(this) {
                    public void run() {
                        zzpe.m13v("Rejecting reference for JS Engine.");
                        zzc.reject();
                    }
                });
                zzac.zzar(this.zzJy >= 0);
                this.zzJy++;
            }
            return zzc;
        }

        protected void zzgx() {
            boolean z = true;
            synchronized (this.zzrN) {
                if (this.zzJy < 1) {
                    z = false;
                }
                zzac.zzar(z);
                zzpe.m13v("Releasing 1 reference for JS Engine");
                this.zzJy--;
                zzgz();
            }
        }

        public void zzgy() {
            boolean z = true;
            synchronized (this.zzrN) {
                if (this.zzJy < 0) {
                    z = false;
                }
                zzac.zzar(z);
                zzpe.m13v("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.zzJx = true;
                zzgz();
            }
        }

        protected void zzgz() {
            synchronized (this.zzrN) {
                zzac.zzar(this.zzJy >= 0);
                if (this.zzJx && this.zzJy == 0) {
                    zzpe.m13v("No reference is left (including root). Cleaning up engine.");
                    zza(new C07543(this), new com.google.android.gms.internal.zzqi.zzb());
                } else {
                    zzpe.m13v("There are still references to the engine. Not destroying.");
                }
            }
        }
    }

    public static class zze extends zzqj<zzjb> {
        private zzc zzJD;

        public zze(zzc zzc) {
            this.zzJD = zzc;
        }

        public void finalize() {
            this.zzJD.release();
            this.zzJD = null;
        }

        public int getStatus() {
            return this.zzJD.getStatus();
        }

        public void reject() {
            this.zzJD.reject();
        }

        public void zza(com.google.android.gms.internal.zzqi.zzc<zzjb> zzc, com.google.android.gms.internal.zzqi.zza zza) {
            this.zzJD.zza(zzc, zza);
        }

        public void zzf(zzjb zzjb) {
            this.zzJD.zzg(zzjb);
        }

        public /* synthetic */ void zzg(Object obj) {
            zzf((zzjb) obj);
        }
    }

    public zzja(Context context, zzqa zzqa, String str) {
        this.zzrN = new Object();
        this.zzJh = 1;
        this.zzJd = str;
        this.mContext = context.getApplicationContext();
        this.zztr = zzqa;
        this.zzJe = new zzb();
        this.zzJf = new zzb();
    }

    public zzja(Context context, zzqa zzqa, String str, zzpn<zzix> zzpn, zzpn<zzix> zzpn2) {
        this(context, zzqa, str);
        this.zzJe = zzpn;
        this.zzJf = zzpn2;
    }

    private zzd zza(@Nullable final zzav zzav) {
        final zzd zzd = new zzd(this.zzJf);
        zzv.zzcJ().runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzja zzJk;

            public void run() {
                final zzix zza = this.zzJk.zza(this.zzJk.mContext, this.zzJk.zztr, zzav);
                zza.zza(new com.google.android.gms.internal.zzix.zza(this) {
                    final /* synthetic */ C03901 zzJm;

                    /* renamed from: com.google.android.gms.internal.zzja$1$1$1 */
                    class C03871 implements Runnable {
                        final /* synthetic */ C07441 zzJn;

                        /* renamed from: com.google.android.gms.internal.zzja$1$1$1$1 */
                        class C03861 implements Runnable {
                            final /* synthetic */ C03871 zzJo;

                            C03861(C03871 c03871) {
                                this.zzJo = c03871;
                            }

                            public void run() {
                                zza.destroy();
                            }
                        }

                        C03871(C07441 c07441) {
                            this.zzJn = c07441;
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                            r3 = this;
                            r0 = r3.zzJn;
                            r0 = r0.zzJm;
                            r0 = r0.zzJk;
                            r1 = r0.zzrN;
                            monitor-enter(r1);
                            r0 = r3.zzJn;	 Catch:{ all -> 0x0043 }
                            r0 = r0.zzJm;	 Catch:{ all -> 0x0043 }
                            r0 = r0;	 Catch:{ all -> 0x0043 }
                            r0 = r0.getStatus();	 Catch:{ all -> 0x0043 }
                            r2 = -1;
                            if (r0 == r2) goto L_0x0025;
                        L_0x0018:
                            r0 = r3.zzJn;	 Catch:{ all -> 0x0043 }
                            r0 = r0.zzJm;	 Catch:{ all -> 0x0043 }
                            r0 = r0;	 Catch:{ all -> 0x0043 }
                            r0 = r0.getStatus();	 Catch:{ all -> 0x0043 }
                            r2 = 1;
                            if (r0 != r2) goto L_0x0027;
                        L_0x0025:
                            monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                        L_0x0026:
                            return;
                        L_0x0027:
                            r0 = r3.zzJn;	 Catch:{ all -> 0x0043 }
                            r0 = r0.zzJm;	 Catch:{ all -> 0x0043 }
                            r0 = r0;	 Catch:{ all -> 0x0043 }
                            r0.reject();	 Catch:{ all -> 0x0043 }
                            r0 = com.google.android.gms.ads.internal.zzv.zzcJ();	 Catch:{ all -> 0x0043 }
                            r2 = new com.google.android.gms.internal.zzja$1$1$1$1;	 Catch:{ all -> 0x0043 }
                            r2.<init>(r3);	 Catch:{ all -> 0x0043 }
                            r0.runOnUiThread(r2);	 Catch:{ all -> 0x0043 }
                            r0 = "Could not receive loaded message in a timely manner. Rejecting.";
                            com.google.android.gms.internal.zzpe.m13v(r0);	 Catch:{ all -> 0x0043 }
                            monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                            goto L_0x0026;
                        L_0x0043:
                            r0 = move-exception;
                            monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                            throw r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzja.1.1.1.run():void");
                        }
                    }

                    public void zzgu() {
                        zzpi.zzWR.postDelayed(new C03871(this), (long) zza.zzJt);
                    }
                });
                zza.zza("/jsLoaded", new zzhx(this) {
                    final /* synthetic */ C03901 zzJm;

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void zza(com.google.android.gms.internal.zzqp r4, java.util.Map<java.lang.String, java.lang.String> r5) {
                        /*
                        r3 = this;
                        r0 = r3.zzJm;
                        r0 = r0.zzJk;
                        r1 = r0.zzrN;
                        monitor-enter(r1);
                        r0 = r3.zzJm;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0051 }
                        r2 = -1;
                        if (r0 == r2) goto L_0x001f;
                    L_0x0014:
                        r0 = r3.zzJm;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0051 }
                        r2 = 1;
                        if (r0 != r2) goto L_0x0021;
                    L_0x001f:
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                    L_0x0020:
                        return;
                    L_0x0021:
                        r0 = r3.zzJm;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzJk;	 Catch:{ all -> 0x0051 }
                        r2 = 0;
                        r0.zzJh = r2;	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzJm;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzJk;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzJe;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzd(r2);	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzJm;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzg(r2);	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzJm;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzJk;	 Catch:{ all -> 0x0051 }
                        r2 = r3.zzJm;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzJg = r2;	 Catch:{ all -> 0x0051 }
                        r0 = "Successfully loaded JS Engine.";
                        com.google.android.gms.internal.zzpe.m13v(r0);	 Catch:{ all -> 0x0051 }
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                        goto L_0x0020;
                    L_0x0051:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzja.1.2.zza(com.google.android.gms.internal.zzqp, java.util.Map):void");
                    }
                });
                final zzpu zzpu = new zzpu();
                zzhx c07463 = new zzhx(this) {
                    final /* synthetic */ C03901 zzJm;

                    public void zza(zzqp zzqp, Map<String, String> map) {
                        synchronized (this.zzJm.zzJk.zzrN) {
                            zzpy.zzbd("JS Engine is requesting an update");
                            if (this.zzJm.zzJk.zzJh == 0) {
                                zzpy.zzbd("Starting reload.");
                                this.zzJm.zzJk.zzJh = 2;
                                this.zzJm.zzJk.zzb(zzav);
                            }
                            zza.zzb("/requestReload", (zzhx) zzpu.get());
                        }
                    }
                };
                zzpu.set(c07463);
                zza.zza("/requestReload", c07463);
                if (this.zzJk.zzJd.endsWith(".js")) {
                    zza.zzal(this.zzJk.zzJd);
                } else if (this.zzJk.zzJd.startsWith("<html>")) {
                    zza.zzan(this.zzJk.zzJd);
                } else {
                    zza.zzam(this.zzJk.zzJd);
                }
                zzpi.zzWR.postDelayed(new Runnable(this) {
                    final /* synthetic */ C03901 zzJm;

                    /* renamed from: com.google.android.gms.internal.zzja$1$4$1 */
                    class C03881 implements Runnable {
                        final /* synthetic */ C03894 zzJq;

                        C03881(C03894 c03894) {
                            this.zzJq = c03894;
                        }

                        public void run() {
                            zza.destroy();
                        }
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                        r3 = this;
                        r0 = r3.zzJm;
                        r0 = r0.zzJk;
                        r1 = r0.zzrN;
                        monitor-enter(r1);
                        r0 = r3.zzJm;	 Catch:{ all -> 0x003b }
                        r0 = r0;	 Catch:{ all -> 0x003b }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x003b }
                        r2 = -1;
                        if (r0 == r2) goto L_0x001f;
                    L_0x0014:
                        r0 = r3.zzJm;	 Catch:{ all -> 0x003b }
                        r0 = r0;	 Catch:{ all -> 0x003b }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x003b }
                        r2 = 1;
                        if (r0 != r2) goto L_0x0021;
                    L_0x001f:
                        monitor-exit(r1);	 Catch:{ all -> 0x003b }
                    L_0x0020:
                        return;
                    L_0x0021:
                        r0 = r3.zzJm;	 Catch:{ all -> 0x003b }
                        r0 = r0;	 Catch:{ all -> 0x003b }
                        r0.reject();	 Catch:{ all -> 0x003b }
                        r0 = com.google.android.gms.ads.internal.zzv.zzcJ();	 Catch:{ all -> 0x003b }
                        r2 = new com.google.android.gms.internal.zzja$1$4$1;	 Catch:{ all -> 0x003b }
                        r2.<init>(r3);	 Catch:{ all -> 0x003b }
                        r0.runOnUiThread(r2);	 Catch:{ all -> 0x003b }
                        r0 = "Could not receive loaded message in a timely manner. Rejecting.";
                        com.google.android.gms.internal.zzpe.m13v(r0);	 Catch:{ all -> 0x003b }
                        monitor-exit(r1);	 Catch:{ all -> 0x003b }
                        goto L_0x0020;
                    L_0x003b:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x003b }
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzja.1.4.run():void");
                    }
                }, (long) zza.zzJs);
            }
        });
        return zzd;
    }

    protected zzix zza(Context context, zzqa zzqa, @Nullable zzav zzav) {
        return new zziz(context, zzqa, zzav, null);
    }

    protected zzd zzb(@Nullable zzav zzav) {
        final zzd zza = zza(zzav);
        zza.zza(new com.google.android.gms.internal.zzqi.zzc<zzix>(this) {
            final /* synthetic */ zzja zzJk;

            public void zza(zzix zzix) {
                synchronized (this.zzJk.zzrN) {
                    this.zzJk.zzJh = 0;
                    if (!(this.zzJk.zzJg == null || zza == this.zzJk.zzJg)) {
                        zzpe.m13v("New JS engine is loaded, marking previous one as destroyable.");
                        this.zzJk.zzJg.zzgy();
                    }
                    this.zzJk.zzJg = zza;
                }
            }

            public /* synthetic */ void zzd(Object obj) {
                zza((zzix) obj);
            }
        }, new com.google.android.gms.internal.zzqi.zza(this) {
            final /* synthetic */ zzja zzJk;

            public void run() {
                synchronized (this.zzJk.zzrN) {
                    this.zzJk.zzJh = 1;
                    zzpe.m13v("Failed loading new engine. Marking new engine destroyable.");
                    zza.zzgy();
                }
            }
        });
        return zza;
    }

    public zzc zzc(@Nullable zzav zzav) {
        zzc zzgw;
        synchronized (this.zzrN) {
            if (this.zzJg == null || this.zzJg.getStatus() == -1) {
                this.zzJh = 2;
                this.zzJg = zzb(zzav);
                zzgw = this.zzJg.zzgw();
            } else if (this.zzJh == 0) {
                zzgw = this.zzJg.zzgw();
            } else if (this.zzJh == 1) {
                this.zzJh = 2;
                zzb(zzav);
                zzgw = this.zzJg.zzgw();
            } else if (this.zzJh == 2) {
                zzgw = this.zzJg.zzgw();
            } else {
                zzgw = this.zzJg.zzgw();
            }
        }
        return zzgw;
    }

    public zzc zzgv() {
        return zzc(null);
    }
}
