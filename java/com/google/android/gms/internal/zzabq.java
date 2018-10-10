package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzf;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class zzabq {
    public static final Status zzaBV = new Status(8, "The connection to Google Play services was lost");
    private static final zzzx<?>[] zzaBW = new zzzx[0];
    private final Map<zzc<?>, zze> zzaAr;
    final Set<zzzx<?>> zzaBX = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zzb zzaBY = new C06571(this);

    interface zzb {
        void zzc(zzzx<?> zzzx);
    }

    /* renamed from: com.google.android.gms.internal.zzabq$1 */
    class C06571 implements zzb {
        final /* synthetic */ zzabq zzaBZ;

        C06571(zzabq zzabq) {
            this.zzaBZ = zzabq;
        }

        public void zzc(zzzx<?> zzzx) {
            this.zzaBZ.zzaBX.remove(zzzx);
            if (zzzx.zzuR() != null) {
                null;
            }
        }
    }

    private static class zza implements DeathRecipient, zzb {
        private final WeakReference<zzzx<?>> zzaCa;
        private final WeakReference<zzf> zzaCb;
        private final WeakReference<IBinder> zzaCc;

        private zza(zzzx<?> zzzx, zzf zzf, IBinder iBinder) {
            this.zzaCb = new WeakReference(zzf);
            this.zzaCa = new WeakReference(zzzx);
            this.zzaCc = new WeakReference(iBinder);
        }

        private void zzwx() {
            zzzx zzzx = (zzzx) this.zzaCa.get();
            zzf zzf = (zzf) this.zzaCb.get();
            if (!(zzf == null || zzzx == null)) {
                zzf.remove(zzzx.zzuR().intValue());
            }
            IBinder iBinder = (IBinder) this.zzaCc.get();
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void binderDied() {
            zzwx();
        }

        public void zzc(zzzx<?> zzzx) {
            zzwx();
        }
    }

    public zzabq(Map<zzc<?>, zze> map) {
        this.zzaAr = map;
    }

    private static void zza(zzzx<?> zzzx, zzf zzf, IBinder iBinder) {
        if (zzzx.isReady()) {
            zzzx.zza(new zza(zzzx, zzf, iBinder));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            zzzx.zza(null);
            zzzx.cancel();
            zzf.remove(zzzx.zzuR().intValue());
        } else {
            zzb zza = new zza(zzzx, zzf, iBinder);
            zzzx.zza(zza);
            try {
                iBinder.linkToDeath(zza, 0);
            } catch (RemoteException e) {
                zzzx.cancel();
                zzf.remove(zzzx.zzuR().intValue());
            }
        }
    }

    public void dump(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zzaBX.size());
    }

    public void release() {
        for (zzzx zzzx : (zzzx[]) this.zzaBX.toArray(zzaBW)) {
            zzzx.zza(null);
            if (zzzx.zzuR() != null) {
                zzzx.zzve();
                zza(zzzx, null, ((zze) this.zzaAr.get(((com.google.android.gms.internal.zzzv.zza) zzzx).zzuH())).zzuJ());
                this.zzaBX.remove(zzzx);
            } else if (zzzx.zzvc()) {
                this.zzaBX.remove(zzzx);
            }
        }
    }

    void zzb(zzzx<? extends Result> zzzx) {
        this.zzaBX.add(zzzx);
        zzzx.zza(this.zzaBY);
    }

    public void zzww() {
        for (zzzx zzB : (zzzx[]) this.zzaBX.toArray(zzaBW)) {
            zzB.zzB(zzaBV);
        }
    }
}
