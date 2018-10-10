package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzal;
import com.google.android.gms.internal.zzzv.zza;

public class zzaai implements zzaam {
    private final zzaan zzazK;
    private boolean zzazL = false;

    public zzaai(zzaan zzaan) {
        this.zzazK = zzaan;
    }

    private <A extends zzb> void zzd(zza<? extends Result, A> zza) throws DeadObjectException {
        this.zzazK.zzazd.zzaAx.zzb(zza);
        zzb zzb = this.zzazK.zzazd.zzb(zza.zzuH());
        if (zzb.isConnected() || !this.zzazK.zzaAG.containsKey(zza.zzuH())) {
            if (zzb instanceof zzal) {
                zzb = ((zzal) zzb).zzxG();
            }
            zza.zzb(zzb);
            return;
        }
        zza.zzA(new Status(17));
    }

    public void begin() {
    }

    public void connect() {
        if (this.zzazL) {
            this.zzazL = false;
            this.zzazK.zza(new zza(this, this) {
                final /* synthetic */ zzaai zzazM;

                public void zzvA() {
                    this.zzazM.zzazK.zzaAK.zzo(null);
                }
            });
        }
    }

    public boolean disconnect() {
        if (this.zzazL) {
            return false;
        }
        if (this.zzazK.zzazd.zzvM()) {
            this.zzazL = true;
            for (zzabp zzwu : this.zzazK.zzazd.zzaAw) {
                zzwu.zzwu();
            }
            return false;
        }
        this.zzazK.zzh(null);
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
        this.zzazK.zzh(null);
        this.zzazK.zzaAK.zzc(i, this.zzazL);
    }

    public <A extends zzb, R extends Result, T extends zza<R, A>> T zza(T t) {
        return zzb(t);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zzb(T t) {
        try {
            zzd(t);
        } catch (DeadObjectException e) {
            this.zzazK.zza(new zza(this, this) {
                final /* synthetic */ zzaai zzazM;

                public void zzvA() {
                    this.zzazM.onConnectionSuspended(1);
                }
            });
        }
        return t;
    }

    void zzvz() {
        if (this.zzazL) {
            this.zzazL = false;
            this.zzazK.zzazd.zzaAx.release();
            disconnect();
        }
    }
}
