package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzmb
public class zzov {
    public final int errorCode;
    public final int orientation;
    public final List<String> zzJY;
    public final List<String> zzJZ;
    @Nullable
    public final zzji zzKA;
    @Nullable
    public final zzjt zzKB;
    @Nullable
    public final String zzKC;
    @Nullable
    public final zzjl zzKD;
    @Nullable
    public final List<String> zzKb;
    public final long zzKe;
    @Nullable
    public final zzqp zzMZ;
    public final long zzRJ;
    public final boolean zzRK;
    public final long zzRL;
    public final List<String> zzRM;
    public final String zzRP;
    @Nullable
    public final zzok zzRZ;
    public final zzdy zzRd;
    public final String zzRg;
    @Nullable
    public final List<String> zzSb;
    public final boolean zzSc;
    public final zzmm zzSd;
    public final String zzSg;
    public boolean zzVA;
    public final JSONObject zzVp;
    public boolean zzVq;
    public final zzjj zzVr;
    @Nullable
    public final String zzVs;
    public final zzec zzVt;
    @Nullable
    public final List<String> zzVu;
    public final long zzVv;
    public final long zzVw;
    @Nullable
    public final com.google.android.gms.internal.zzgu.zza zzVx;
    public boolean zzVy;
    public boolean zzVz;

    @zzmb
    public static final class zza {
        public final int errorCode;
        public final zzmh zzSF;
        public final zzmk zzVB;
        @Nullable
        public final JSONObject zzVp;
        public final zzjj zzVr;
        public final long zzVv;
        public final long zzVw;
        @Nullable
        public final zzec zzvj;

        public zza(zzmh zzmh, zzmk zzmk, zzjj zzjj, zzec zzec, int i, long j, long j2, JSONObject jSONObject) {
            this.zzSF = zzmh;
            this.zzVB = zzmk;
            this.zzVr = zzjj;
            this.zzvj = zzec;
            this.errorCode = i;
            this.zzVv = j;
            this.zzVw = j2;
            this.zzVp = jSONObject;
        }
    }

    public zzov(zzdy zzdy, @Nullable zzqp zzqp, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, @Nullable zzji zzji, @Nullable zzjt zzjt, @Nullable String str2, zzjj zzjj, @Nullable zzjl zzjl, long j2, zzec zzec, long j3, long j4, long j5, String str3, JSONObject jSONObject, @Nullable com.google.android.gms.internal.zzgu.zza zza, zzok zzok, List<String> list4, List<String> list5, boolean z2, zzmm zzmm, @Nullable String str4, List<String> list6, String str5) {
        this.zzVy = false;
        this.zzVz = false;
        this.zzVA = false;
        this.zzRd = zzdy;
        this.zzMZ = zzqp;
        this.zzJY = zzm(list);
        this.errorCode = i;
        this.zzJZ = zzm(list2);
        this.zzRM = zzm(list3);
        this.orientation = i2;
        this.zzKe = j;
        this.zzRg = str;
        this.zzRK = z;
        this.zzKA = zzji;
        this.zzKB = zzjt;
        this.zzKC = str2;
        this.zzVr = zzjj;
        this.zzKD = zzjl;
        this.zzRL = j2;
        this.zzVt = zzec;
        this.zzRJ = j3;
        this.zzVv = j4;
        this.zzVw = j5;
        this.zzRP = str3;
        this.zzVp = jSONObject;
        this.zzVx = zza;
        this.zzRZ = zzok;
        this.zzVu = zzm(list4);
        this.zzSb = zzm(list5);
        this.zzSc = z2;
        this.zzSd = zzmm;
        this.zzVs = str4;
        this.zzKb = zzm(list6);
        this.zzSg = str5;
    }

    public zzov(zza zza, @Nullable zzqp zzqp, @Nullable zzji zzji, @Nullable zzjt zzjt, @Nullable String str, @Nullable zzjl zzjl, @Nullable com.google.android.gms.internal.zzgu.zza zza2, @Nullable String str2) {
        this(zza.zzSF.zzRd, zzqp, zza.zzVB.zzJY, zza.errorCode, zza.zzVB.zzJZ, zza.zzVB.zzRM, zza.zzVB.orientation, zza.zzVB.zzKe, zza.zzSF.zzRg, zza.zzVB.zzRK, zzji, zzjt, str, zza.zzVr, zzjl, zza.zzVB.zzRL, zza.zzvj, zza.zzVB.zzRJ, zza.zzVv, zza.zzVw, zza.zzVB.zzRP, zza.zzVp, zza2, zza.zzVB.zzRZ, zza.zzVB.zzSa, zza.zzVB.zzSa, zza.zzVB.zzSc, zza.zzVB.zzSd, str2, zza.zzVB.zzKb, zza.zzVB.zzSg);
    }

    @Nullable
    private static <T> List<T> zzm(@Nullable List<T> list) {
        return list == null ? null : Collections.unmodifiableList(list);
    }

    public boolean zzdz() {
        return (this.zzMZ == null || this.zzMZ.zzkV() == null) ? false : this.zzMZ.zzkV().zzdz();
    }
}
