package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;
import java.util.LinkedList;

@zzmb
class zziu {
    private final LinkedList<zza> zzIC = new LinkedList();
    private zzdy zzID;
    private final int zzIE;
    private boolean zzIF;
    private final String zztq;

    class zza {
        zzl zzIG;
        @Nullable
        zzdy zzIH;
        zziq zzII;
        long zzIJ;
        boolean zzIK;
        boolean zzIL;
        final /* synthetic */ zziu zzIM;

        zza(zziu zziu, zzip zzip) {
            this.zzIM = zziu;
            this.zzIG = zzip.zzah(zziu.zztq);
            this.zzII = new zziq();
            this.zzII.zzc(this.zzIG);
        }

        zza(zziu zziu, zzip zzip, zzdy zzdy) {
            this(zziu, zzip);
            this.zzIH = zzdy;
        }

        void zzgq() {
            if (!this.zzIK) {
                this.zzIL = this.zzIG.zzb(zzis.zzl(this.zzIH != null ? this.zzIH : this.zzIM.zzID));
                this.zzIK = true;
                this.zzIJ = zzv.zzcP().currentTimeMillis();
            }
        }
    }

    zziu(zzdy zzdy, String str, int i) {
        zzac.zzw(zzdy);
        zzac.zzw(str);
        this.zzID = zzdy;
        this.zztq = str;
        this.zzIE = i;
    }

    String getAdUnitId() {
        return this.zztq;
    }

    int getNetworkType() {
        return this.zzIE;
    }

    int size() {
        return this.zzIC.size();
    }

    void zza(zzip zzip, zzdy zzdy) {
        this.zzIC.add(new zza(this, zzip, zzdy));
    }

    void zzb(zzip zzip) {
        zza zza = new zza(this, zzip);
        this.zzIC.add(zza);
        zza.zzgq();
    }

    zzdy zzgl() {
        return this.zzID;
    }

    int zzgm() {
        Iterator it = this.zzIC.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((zza) it.next()).zzIK ? i + 1 : i;
        }
        return i;
    }

    void zzgn() {
        Iterator it = this.zzIC.iterator();
        while (it.hasNext()) {
            ((zza) it.next()).zzgq();
        }
    }

    void zzgo() {
        this.zzIF = true;
    }

    boolean zzgp() {
        return this.zzIF;
    }

    zza zzp(@Nullable zzdy zzdy) {
        if (zzdy != null) {
            this.zzID = zzdy;
        }
        return (zza) this.zzIC.remove();
    }
}
