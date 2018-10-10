package com.google.android.gms.internal;

import android.support.annotation.Nullable;

@zzmb
public class zzgb {
    @Nullable
    public static zzgd zza(@Nullable zzgf zzgf, long j) {
        return zzgf == null ? null : zzgf.zzc(j);
    }

    public static boolean zza(@Nullable zzgf zzgf, @Nullable zzgd zzgd, long j, String... strArr) {
        return (zzgf == null || zzgd == null) ? false : zzgf.zza(zzgd, j, strArr);
    }

    public static boolean zza(@Nullable zzgf zzgf, @Nullable zzgd zzgd, String... strArr) {
        return (zzgf == null || zzgd == null) ? false : zzgf.zza(zzgd, strArr);
    }

    @Nullable
    public static zzgd zzb(@Nullable zzgf zzgf) {
        return zzgf == null ? null : zzgf.zzfw();
    }
}
