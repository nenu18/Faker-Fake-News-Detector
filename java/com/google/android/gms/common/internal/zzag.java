package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzag implements Creator<zzaf> {
    static void zza(zzaf zzaf, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, zzaf.mVersionCode);
        zzc.zza(parcel, 2, zzaf.zzaDx, false);
        zzc.zza(parcel, 3, zzaf.zzxA(), i, false);
        zzc.zza(parcel, 4, zzaf.zzxB());
        zzc.zza(parcel, 5, zzaf.zzxC());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcT(i);
    }

    public zzaf zzaQ(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case 3:
                    connectionResult = (ConnectionResult) zzb.zza(parcel, zzaT, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case 5:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzaf(i, iBinder, connectionResult, z2, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzaf[] zzcT(int i) {
        return new zzaf[i];
    }
}
