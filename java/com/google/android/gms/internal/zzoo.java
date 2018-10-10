package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.List;

public class zzoo implements Creator<zzon> {
    static void zza(zzon zzon, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, zzon.versionCode);
        zzc.zza(parcel, 2, zzon.zzVk, false);
        zzc.zza(parcel, 3, zzon.zzVl, false);
        zzc.zza(parcel, 4, zzon.zzVm);
        zzc.zza(parcel, 5, zzon.zzVn);
        zzc.zzb(parcel, 6, zzon.zzVo, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzu(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzae(i);
    }

    public zzon[] zzae(int i) {
        return new zzon[i];
    }

    public zzon zzu(Parcel parcel) {
        List list = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        boolean z2 = false;
        String str = null;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 3:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 4:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case 5:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 6:
                    list = zzb.zzE(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzon(i, str2, str, z2, z, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }
}
