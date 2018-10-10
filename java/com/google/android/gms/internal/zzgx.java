package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzgx implements Creator<zzgw> {
    static void zza(zzgw zzgw, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, zzgw.versionCode);
        zzc.zza(parcel, 2, zzgw.zzGD);
        zzc.zzc(parcel, 3, zzgw.zzGE);
        zzc.zza(parcel, 4, zzgw.zzGF);
        zzc.zzc(parcel, 5, zzgw.zzGG);
        zzc.zza(parcel, 6, zzgw.zzGH, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzi(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzC(i);
    }

    public zzgw[] zzC(int i) {
        return new zzgw[i];
    }

    public zzgw zzi(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        zzfn zzfn = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case 3:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 4:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 5:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 6:
                    zzfn = (zzfn) zzb.zza(parcel, zzaT, zzfn.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzgw(i3, z2, i2, z, i, zzfn);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }
}
