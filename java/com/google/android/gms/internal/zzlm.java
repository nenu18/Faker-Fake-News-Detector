package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;

@zzmb
public abstract class zzlm extends zzpd {
    protected final Context mContext;
    protected final com.google.android.gms.internal.zzln.zza zzPn;
    protected final com.google.android.gms.internal.zzov.zza zzPo;
    protected zzmk zzPp;
    protected final Object zzPr = new Object();
    protected final Object zzrN = new Object();

    /* renamed from: com.google.android.gms.internal.zzlm$1 */
    class C04171 implements Runnable {
        final /* synthetic */ zzlm zzPE;

        C04171(zzlm zzlm) {
            this.zzPE = zzlm;
        }

        public void run() {
            this.zzPE.onStop();
        }
    }

    protected static final class zza extends Exception {
        private final int zzPF;

        public zza(String str, int i) {
            super(str);
            this.zzPF = i;
        }

        public int getErrorCode() {
            return this.zzPF;
        }
    }

    protected zzlm(Context context, com.google.android.gms.internal.zzov.zza zza, com.google.android.gms.internal.zzln.zza zza2) {
        super(true);
        this.mContext = context;
        this.zzPo = zza;
        this.zzPp = zza.zzVB;
        this.zzPn = zza2;
    }

    public void onStop() {
    }

    protected abstract zzov zzP(int i);

    public void zzcm() {
        int errorCode;
        synchronized (this.zzrN) {
            zzpy.zzbc("AdRendererBackgroundTask started.");
            int i = this.zzPo.errorCode;
            try {
                zzh(SystemClock.elapsedRealtime());
            } catch (zza e) {
                errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzpy.zzbd(e.getMessage());
                } else {
                    zzpy.zzbe(e.getMessage());
                }
                if (this.zzPp == null) {
                    this.zzPp = new zzmk(errorCode);
                } else {
                    this.zzPp = new zzmk(errorCode, this.zzPp.zzKe);
                }
                zzpi.zzWR.post(new C04171(this));
                i = errorCode;
            }
            final zzov zzP = zzP(i);
            zzpi.zzWR.post(new Runnable(this) {
                final /* synthetic */ zzlm zzPE;

                public void run() {
                    synchronized (this.zzPE.zzrN) {
                        this.zzPE.zzn(zzP);
                    }
                }
            });
        }
    }

    protected abstract void zzh(long j) throws zza;

    protected void zzn(zzov zzov) {
        this.zzPn.zzb(zzov);
    }
}
