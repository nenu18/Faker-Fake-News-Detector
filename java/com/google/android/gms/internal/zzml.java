package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.List;

public class zzml implements Creator<zzmk> {
    static void zza(zzmk zzmk, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, zzmk.versionCode);
        zzc.zza(parcel, 2, zzmk.zzNb, false);
        zzc.zza(parcel, 3, zzmk.body, false);
        zzc.zzb(parcel, 4, zzmk.zzJY, false);
        zzc.zzc(parcel, 5, zzmk.errorCode);
        zzc.zzb(parcel, 6, zzmk.zzJZ, false);
        zzc.zza(parcel, 7, zzmk.zzRJ);
        zzc.zza(parcel, 8, zzmk.zzRK);
        zzc.zza(parcel, 9, zzmk.zzRL);
        zzc.zzb(parcel, 10, zzmk.zzRM, false);
        zzc.zza(parcel, 11, zzmk.zzKe);
        zzc.zzc(parcel, 12, zzmk.orientation);
        zzc.zza(parcel, 13, zzmk.zzRN, false);
        zzc.zza(parcel, 14, zzmk.zzRO);
        zzc.zza(parcel, 15, zzmk.zzRP, false);
        zzc.zza(parcel, 18, zzmk.zzRQ);
        zzc.zza(parcel, 19, zzmk.zzRR, false);
        zzc.zza(parcel, 21, zzmk.zzRS, false);
        zzc.zza(parcel, 22, zzmk.zzRT);
        zzc.zza(parcel, 23, zzmk.zzzn);
        zzc.zza(parcel, 24, zzmk.zzRl);
        zzc.zza(parcel, 25, zzmk.zzRU);
        zzc.zza(parcel, 26, zzmk.zzRV);
        zzc.zza(parcel, 28, zzmk.zzRW, i, false);
        zzc.zza(parcel, 29, zzmk.zzRX, false);
        zzc.zza(parcel, 30, zzmk.zzRY, false);
        zzc.zza(parcel, 31, zzmk.zzzo);
        zzc.zza(parcel, 32, zzmk.zzzp);
        zzc.zza(parcel, 33, zzmk.zzRZ, i, false);
        zzc.zzb(parcel, 34, zzmk.zzSa, false);
        zzc.zzb(parcel, 35, zzmk.zzSb, false);
        zzc.zza(parcel, 36, zzmk.zzSc);
        zzc.zza(parcel, 37, zzmk.zzSd, i, false);
        zzc.zza(parcel, 38, zzmk.zzRB);
        zzc.zza(parcel, 39, zzmk.zzRC, false);
        zzc.zzb(parcel, 40, zzmk.zzKb, false);
        zzc.zza(parcel, 42, zzmk.zzKc);
        zzc.zza(parcel, 43, zzmk.zzSe, false);
        zzc.zza(parcel, 44, zzmk.zzSf, i, false);
        zzc.zza(parcel, 45, zzmk.zzSg, false);
        zzc.zza(parcel, 46, zzmk.zzSh);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzn(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzU(i);
    }

    public zzmk[] zzU(int i) {
        return new zzmk[i];
    }

    public zzmk zzn(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        zzms zzms = null;
        String str7 = null;
        String str8 = null;
        boolean z8 = false;
        boolean z9 = false;
        zzok zzok = null;
        List list4 = null;
        List list5 = null;
        boolean z10 = false;
        zzmm zzmm = null;
        boolean z11 = false;
        String str9 = null;
        List list6 = null;
        boolean z12 = false;
        String str10 = null;
        zzon zzon = null;
        String str11 = null;
        boolean z13 = false;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 3:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 4:
                    list = zzb.zzE(parcel, zzaT);
                    break;
                case 5:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 6:
                    list2 = zzb.zzE(parcel, zzaT);
                    break;
                case 7:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case 8:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 9:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case 10:
                    list3 = zzb.zzE(parcel, zzaT);
                    break;
                case 11:
                    j3 = zzb.zzi(parcel, zzaT);
                    break;
                case 12:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case 13:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case 14:
                    j4 = zzb.zzi(parcel, zzaT);
                    break;
                case 15:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case 18:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case 19:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case 21:
                    str6 = zzb.zzq(parcel, zzaT);
                    break;
                case 22:
                    z3 = zzb.zzc(parcel, zzaT);
                    break;
                case 23:
                    z4 = zzb.zzc(parcel, zzaT);
                    break;
                case 24:
                    z5 = zzb.zzc(parcel, zzaT);
                    break;
                case 25:
                    z6 = zzb.zzc(parcel, zzaT);
                    break;
                case 26:
                    z7 = zzb.zzc(parcel, zzaT);
                    break;
                case 28:
                    zzms = (zzms) zzb.zza(parcel, zzaT, zzms.CREATOR);
                    break;
                case 29:
                    str7 = zzb.zzq(parcel, zzaT);
                    break;
                case 30:
                    str8 = zzb.zzq(parcel, zzaT);
                    break;
                case 31:
                    z8 = zzb.zzc(parcel, zzaT);
                    break;
                case 32:
                    z9 = zzb.zzc(parcel, zzaT);
                    break;
                case 33:
                    zzok = (zzok) zzb.zza(parcel, zzaT, zzok.CREATOR);
                    break;
                case 34:
                    list4 = zzb.zzE(parcel, zzaT);
                    break;
                case 35:
                    list5 = zzb.zzE(parcel, zzaT);
                    break;
                case 36:
                    z10 = zzb.zzc(parcel, zzaT);
                    break;
                case 37:
                    zzmm = (zzmm) zzb.zza(parcel, zzaT, zzmm.CREATOR);
                    break;
                case 38:
                    z11 = zzb.zzc(parcel, zzaT);
                    break;
                case 39:
                    str9 = zzb.zzq(parcel, zzaT);
                    break;
                case 40:
                    list6 = zzb.zzE(parcel, zzaT);
                    break;
                case 42:
                    z12 = zzb.zzc(parcel, zzaT);
                    break;
                case 43:
                    str10 = zzb.zzq(parcel, zzaT);
                    break;
                case 44:
                    zzon = (zzon) zzb.zza(parcel, zzaT, zzon.CREATOR);
                    break;
                case 45:
                    str11 = zzb.zzq(parcel, zzaT);
                    break;
                case 46:
                    z13 = zzb.zzc(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzmk(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, zzms, str7, str8, z8, z9, zzok, list4, list5, z10, zzmm, z11, str9, list6, z12, str10, zzon, str11, z13);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }
}
