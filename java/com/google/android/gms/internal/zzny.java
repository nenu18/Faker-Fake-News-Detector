package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzny implements Creator<zznx> {
    static void zza(zznx zznx, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, zznx.versionCode);
        zzc.zza(parcel, 2, zznx.zzRd, i, false);
        zzc.zza(parcel, 3, zznx.zzvd, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzs(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaa(i);
    }

    public zznx[] zzaa(int i) {
        return new zznx[i];
    }

    public zznx zzs(Parcel parcel) {
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        zzdy zzdy = null;
        while (parcel.dataPosition() < zzaU) {
            zzdy zzdy2;
            int zzg;
            String str2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    String str3 = str;
                    zzdy2 = zzdy;
                    zzg = zzb.zzg(parcel, zzaT);
                    str2 = str3;
                    break;
                case 2:
                    zzg = i;
                    zzdy zzdy3 = (zzdy) zzb.zza(parcel, zzaT, zzdy.CREATOR);
                    str2 = str;
                    zzdy2 = zzdy3;
                    break;
                case 3:
                    str2 = zzb.zzq(parcel, zzaT);
                    zzdy2 = zzdy;
                    zzg = i;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    str2 = str;
                    zzdy2 = zzdy;
                    zzg = i;
                    break;
            }
            i = zzg;
            zzdy = zzdy2;
            str = str2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zznx(i, zzdy, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }
}
