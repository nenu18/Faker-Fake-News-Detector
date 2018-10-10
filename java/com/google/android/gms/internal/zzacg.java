package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzacg implements Creator<zzacf> {
    static void zza(zzacf zzacf, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, zzacf.mVersionCode);
        zzc.zza(parcel, 2, zzacf.zzxH(), i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaX(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcZ(i);
    }

    public zzacf zzaX(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zzach zzach = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    zzach = (zzach) zzb.zza(parcel, zzaT, zzach.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzacf(i, zzach);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzacf[] zzcZ(int i) {
        return new zzacf[i];
    }
}
