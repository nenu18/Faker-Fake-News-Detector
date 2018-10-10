package com.google.android.gms.internal;

import com.google.android.gms.internal.zzqi.zzc;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzmb
public class zzqj<T> implements zzqi<T> {
    protected int zzJh = 0;
    protected final BlockingQueue<zza> zzYt = new LinkedBlockingQueue();
    protected T zzYu;
    private final Object zzrN = new Object();

    class zza {
        public final zzc<T> zzYv;
        public final com.google.android.gms.internal.zzqi.zza zzYw;

        public zza(zzqj zzqj, zzc<T> zzc, com.google.android.gms.internal.zzqi.zza zza) {
            this.zzYv = zzc;
            this.zzYw = zza;
        }
    }

    public int getStatus() {
        return this.zzJh;
    }

    public void reject() {
        synchronized (this.zzrN) {
            if (this.zzJh != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzJh = -1;
            for (zza zza : this.zzYt) {
                zza.zzYw.run();
            }
            this.zzYt.clear();
        }
    }

    public void zza(zzc<T> zzc, com.google.android.gms.internal.zzqi.zza zza) {
        synchronized (this.zzrN) {
            if (this.zzJh == 1) {
                zzc.zzd(this.zzYu);
            } else if (this.zzJh == -1) {
                zza.run();
            } else if (this.zzJh == 0) {
                this.zzYt.add(new zza(this, zzc, zza));
            }
        }
    }

    public void zzg(T t) {
        synchronized (this.zzrN) {
            if (this.zzJh != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzYu = t;
            this.zzJh = 1;
            for (zza zza : this.zzYt) {
                zza.zzYv.zzd(t);
            }
            this.zzYt.clear();
        }
    }
}
