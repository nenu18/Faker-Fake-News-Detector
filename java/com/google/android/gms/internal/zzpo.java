package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.List;

@zzmb
public class zzpo {
    private final String[] zzXl;
    private final double[] zzXm;
    private final double[] zzXn;
    private final int[] zzXo;
    private int zzXp;

    public static class zza {
        public final int count;
        public final String name;
        public final double zzXq;
        public final double zzXr;
        public final double zzXs;

        public zza(String str, double d, double d2, double d3, int i) {
            this.name = str;
            this.zzXr = d;
            this.zzXq = d2;
            this.zzXs = d3;
            this.count = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return zzaa.equal(this.name, zza.name) && this.zzXq == zza.zzXq && this.zzXr == zza.zzXr && this.count == zza.count && Double.compare(this.zzXs, zza.zzXs) == 0;
        }

        public int hashCode() {
            return zzaa.hashCode(this.name, Double.valueOf(this.zzXq), Double.valueOf(this.zzXr), Double.valueOf(this.zzXs), Integer.valueOf(this.count));
        }

        public String toString() {
            return zzaa.zzv(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzXr)).zzg("maxBound", Double.valueOf(this.zzXq)).zzg("percent", Double.valueOf(this.zzXs)).zzg("count", Integer.valueOf(this.count)).toString();
        }
    }

    public static class zzb {
        private final List<String> zzXt = new ArrayList();
        private final List<Double> zzXu = new ArrayList();
        private final List<Double> zzXv = new ArrayList();

        public zzb zza(String str, double d, double d2) {
            int i = 0;
            while (i < this.zzXt.size()) {
                double doubleValue = ((Double) this.zzXv.get(i)).doubleValue();
                double doubleValue2 = ((Double) this.zzXu.get(i)).doubleValue();
                if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                    break;
                }
                i++;
            }
            this.zzXt.add(i, str);
            this.zzXv.add(i, Double.valueOf(d));
            this.zzXu.add(i, Double.valueOf(d2));
            return this;
        }

        public zzpo zzkB() {
            return new zzpo();
        }
    }

    private zzpo(zzb zzb) {
        int size = zzb.zzXu.size();
        this.zzXl = (String[]) zzb.zzXt.toArray(new String[size]);
        this.zzXm = zzn(zzb.zzXu);
        this.zzXn = zzn(zzb.zzXv);
        this.zzXo = new int[size];
        this.zzXp = 0;
    }

    private double[] zzn(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public List<zza> getBuckets() {
        List<zza> arrayList = new ArrayList(this.zzXl.length);
        for (int i = 0; i < this.zzXl.length; i++) {
            arrayList.add(new zza(this.zzXl[i], this.zzXn[i], this.zzXm[i], ((double) this.zzXo[i]) / ((double) this.zzXp), this.zzXo[i]));
        }
        return arrayList;
    }

    public void zza(double d) {
        this.zzXp++;
        int i = 0;
        while (i < this.zzXn.length) {
            if (this.zzXn[i] <= d && d < this.zzXm[i]) {
                int[] iArr = this.zzXo;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.zzXn[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
