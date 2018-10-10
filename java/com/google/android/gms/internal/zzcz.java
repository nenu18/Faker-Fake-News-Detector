package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzmb
public class zzcz {
    private final Object zzrN = new Object();
    private int zzxt;
    private List<zzcy> zzxu = new LinkedList();

    public boolean zza(zzcy zzcy) {
        boolean z;
        synchronized (this.zzrN) {
            if (this.zzxu.contains(zzcy)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean zzb(zzcy zzcy) {
        synchronized (this.zzrN) {
            Iterator it = this.zzxu.iterator();
            while (it.hasNext()) {
                zzcy zzcy2 = (zzcy) it.next();
                if (!((Boolean) zzfx.zzBU.get()).booleanValue() || zzv.zzcN().zzjJ()) {
                    if (((Boolean) zzfx.zzBW.get()).booleanValue() && !zzv.zzcN().zzjK() && zzcy != zzcy2 && zzcy2.zzdX().equals(zzcy.zzdX())) {
                        it.remove();
                        return true;
                    }
                } else if (zzcy != zzcy2 && zzcy2.zzdV().equals(zzcy.zzdV())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public void zzc(zzcy zzcy) {
        synchronized (this.zzrN) {
            if (this.zzxu.size() >= 10) {
                zzpy.zzbc("Queue is full, current size = " + this.zzxu.size());
                this.zzxu.remove(0);
            }
            int i = this.zzxt;
            this.zzxt = i + 1;
            zzcy.zzn(i);
            this.zzxu.add(zzcy);
        }
    }

    @Nullable
    public zzcy zzed() {
        zzcy zzcy = null;
        int i = 0;
        synchronized (this.zzrN) {
            if (this.zzxu.size() == 0) {
                zzpy.zzbc("Queue empty");
                return null;
            } else if (this.zzxu.size() >= 2) {
                int i2 = Integer.MIN_VALUE;
                int i3 = 0;
                for (zzcy zzcy2 : this.zzxu) {
                    zzcy zzcy3;
                    int i4;
                    int score = zzcy2.getScore();
                    if (score > i2) {
                        i = score;
                        zzcy3 = zzcy2;
                        i4 = i3;
                    } else {
                        i4 = i;
                        zzcy3 = zzcy;
                        i = i2;
                    }
                    i3++;
                    i2 = i;
                    zzcy = zzcy3;
                    i = i4;
                }
                this.zzxu.remove(i);
                return zzcy;
            } else {
                zzcy2 = (zzcy) this.zzxu.get(0);
                zzcy2.zzdY();
                return zzcy2;
            }
        }
    }
}
