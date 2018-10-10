package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzaf;

public class zzayc implements Creator<zzayb> {
    static void zza(zzayb zzayb, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, zzayb.mVersionCode);
        zzc.zza(parcel, 2, zzayb.zzxA(), i, false);
        zzc.zza(parcel, 3, zzayb.zzOp(), i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmN(i);
    }

    public zzayb zziS(Parcel parcel) {
        zzaf zzaf = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < zzaU) {
            ConnectionResult connectionResult2;
            int zzg;
            zzaf zzaf2;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    zzaf zzaf3 = zzaf;
                    connectionResult2 = connectionResult;
                    zzg = zzb.zzg(parcel, zzaT);
                    zzaf2 = zzaf3;
                    break;
                case 2:
                    zzg = i;
                    ConnectionResult connectionResult3 = (ConnectionResult) zzb.zza(parcel, zzaT, ConnectionResult.CREATOR);
                    zzaf2 = zzaf;
                    connectionResult2 = connectionResult3;
                    break;
                case 3:
                    zzaf2 = (zzaf) zzb.zza(parcel, zzaT, zzaf.CREATOR);
                    connectionResult2 = connectionResult;
                    zzg = i;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    zzaf2 = zzaf;
                    connectionResult2 = connectionResult;
                    zzg = i;
                    break;
            }
            i = zzg;
            connectionResult = connectionResult2;
            zzaf = zzaf2;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzayb(i, connectionResult, zzaf);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzayb[] zzmN(int i) {
        return new zzayb[i];
    }
}
