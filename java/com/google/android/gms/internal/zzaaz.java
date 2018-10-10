package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzac;

public final class zzaaz<L> {
    private volatile L mListener;
    private final zza zzaBy;
    private final zzb<L> zzaBz;

    private final class zza extends Handler {
        final /* synthetic */ zzaaz zzaBA;

        public zza(zzaaz zzaaz, Looper looper) {
            this.zzaBA = zzaaz;
            super(looper);
        }

        public void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            zzac.zzas(z);
            this.zzaBA.zzb((zzc) message.obj);
        }
    }

    public static final class zzb<L> {
        private final L mListener;
        private final String zzaBB;

        zzb(L l, String str) {
            this.mListener = l;
            this.zzaBB = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            return this.mListener == zzb.mListener && this.zzaBB.equals(zzb.zzaBB);
        }

        public int hashCode() {
            return (System.identityHashCode(this.mListener) * 31) + this.zzaBB.hashCode();
        }
    }

    public interface zzc<L> {
        void zzs(L l);

        void zzvy();
    }

    zzaaz(@NonNull Looper looper, @NonNull L l, @NonNull String str) {
        this.zzaBy = new zza(this, looper);
        this.mListener = zzac.zzb((Object) l, (Object) "Listener must not be null");
        this.zzaBz = new zzb(l, zzac.zzdv(str));
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzc<? super L> zzc) {
        zzac.zzb((Object) zzc, (Object) "Notifier must not be null");
        this.zzaBy.sendMessage(this.zzaBy.obtainMessage(1, zzc));
    }

    void zzb(zzc<? super L> zzc) {
        Object obj = this.mListener;
        if (obj == null) {
            zzc.zzvy();
            return;
        }
        try {
            zzc.zzs(obj);
        } catch (RuntimeException e) {
            zzc.zzvy();
            throw e;
        }
    }

    @NonNull
    public zzb<L> zzwp() {
        return this.zzaBz;
    }
}
