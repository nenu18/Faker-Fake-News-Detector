package com.google.android.gms.ads.internal;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpy;
import java.lang.ref.WeakReference;

@zzmb
public class zzs {
    private final zza zzuf;
    @Nullable
    private zzdy zzug;
    private boolean zzuh;
    private boolean zzui;
    private long zzuj;
    private final Runnable zzv;

    public static class zza {
        private final Handler mHandler;

        public zza(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long j) {
            return this.mHandler.postDelayed(runnable, j);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public zzs(zza zza) {
        this(zza, new zza(zzpi.zzWR));
    }

    zzs(zza zza, zza zza2) {
        this.zzuh = false;
        this.zzui = false;
        this.zzuj = 0;
        this.zzuf = zza2;
        final WeakReference weakReference = new WeakReference(zza);
        this.zzv = new Runnable(this) {
            final /* synthetic */ zzs zzul;

            public void run() {
                this.zzul.zzuh = false;
                zza zza = (zza) weakReference.get();
                if (zza != null) {
                    zza.zzd(this.zzul.zzug);
                }
            }
        };
    }

    public void cancel() {
        this.zzuh = false;
        this.zzuf.removeCallbacks(this.zzv);
    }

    public void pause() {
        this.zzui = true;
        if (this.zzuh) {
            this.zzuf.removeCallbacks(this.zzv);
        }
    }

    public void resume() {
        this.zzui = false;
        if (this.zzuh) {
            this.zzuh = false;
            zza(this.zzug, this.zzuj);
        }
    }

    public void zza(zzdy zzdy, long j) {
        if (this.zzuh) {
            zzpy.zzbe("An ad refresh is already scheduled.");
            return;
        }
        this.zzug = zzdy;
        this.zzuh = true;
        this.zzuj = j;
        if (!this.zzui) {
            zzpy.zzbd("Scheduling ad refresh " + j + " milliseconds from now.");
            this.zzuf.postDelayed(this.zzv, j);
        }
    }

    public boolean zzcv() {
        return this.zzuh;
    }

    public void zzg(zzdy zzdy) {
        this.zzug = zzdy;
    }

    public void zzh(zzdy zzdy) {
        zza(zzdy, 60000);
    }
}
