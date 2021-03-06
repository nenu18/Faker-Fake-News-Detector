package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public final class zzzf {
    @Deprecated
    public static final Api<NoOptions> API = new Api("ClearcutLogger.API", zzahd, zzahc);
    public static final zzf<zzzk> zzahc = new zzf();
    public static final com.google.android.gms.common.api.Api.zza<zzzk, NoOptions> zzahd = new C08291();
    private final String zzQL;
    private final int zzawl;
    private String zzawm;
    private int zzawn;
    private String zzawo;
    private String zzawp;
    private final boolean zzawq;
    private int zzawr;
    private final zzzg zzaws;
    private zzd zzawt;
    private final zzb zzawu;
    private final zze zzuI;

    public class zza {
        private boolean zzawA;
        private final com.google.android.gms.internal.zzbuy.zzc zzawB;
        private boolean zzawC;
        final /* synthetic */ zzzf zzawD;
        private String zzawm;
        private int zzawn;
        private String zzawo;
        private String zzawp;
        private int zzawr;
        private final zzc zzawv;
        private ArrayList<Integer> zzaww;
        private ArrayList<String> zzawx;
        private ArrayList<Integer> zzawy;
        private ArrayList<byte[]> zzawz;

        private zza(zzzf zzzf, byte[] bArr) {
            this(zzzf, bArr, null);
        }

        private zza(zzzf zzzf, byte[] bArr, zzc zzc) {
            this.zzawD = zzzf;
            this.zzawn = this.zzawD.zzawn;
            this.zzawm = this.zzawD.zzawm;
            this.zzawo = this.zzawD.zzawo;
            this.zzawp = this.zzawD.zzawp;
            this.zzawr = 0;
            this.zzaww = null;
            this.zzawx = null;
            this.zzawy = null;
            this.zzawz = null;
            this.zzawA = true;
            this.zzawB = new com.google.android.gms.internal.zzbuy.zzc();
            this.zzawC = false;
            this.zzawo = zzzf.zzawo;
            this.zzawp = zzzf.zzawp;
            this.zzawB.zzcsy = zzzf.zzuI.currentTimeMillis();
            this.zzawB.zzcsz = zzzf.zzuI.elapsedRealtime();
            this.zzawB.zzcsJ = zzzf.zzawt.zzG(this.zzawB.zzcsy);
            if (bArr != null) {
                this.zzawB.zzcsF = bArr;
            }
            this.zzawv = zzc;
        }

        public zza zzcn(int i) {
            this.zzawB.zzcsB = i;
            return this;
        }

        public zza zzco(int i) {
            this.zzawB.zzrn = i;
            return this;
        }

        @Deprecated
        public PendingResult<Status> zze(GoogleApiClient googleApiClient) {
            return zzuv();
        }

        public zzzh zzuu() {
            return new zzzh(new zzawe(this.zzawD.zzQL, this.zzawD.zzawl, this.zzawn, this.zzawm, this.zzawo, this.zzawp, this.zzawD.zzawq, this.zzawr), this.zzawB, this.zzawv, null, zzzf.zzb(null), zzzf.zzc(null), zzzf.zzb(null), zzzf.zzd(null), this.zzawA);
        }

        @Deprecated
        public PendingResult<Status> zzuv() {
            if (this.zzawC) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.zzawC = true;
            zzzh zzuu = zzuu();
            zzawe zzawe = zzuu.zzawE;
            return this.zzawD.zzawu.zzh(zzawe.zzbzD, zzawe.zzbzz) ? this.zzawD.zzaws.zza(zzuu) : PendingResults.immediatePendingResult(Status.zzayh);
        }
    }

    public interface zzb {
        boolean zzh(String str, int i);
    }

    public interface zzc {
        byte[] zzuw();
    }

    public static class zzd {
        public long zzG(long j) {
            return (long) (TimeZone.getDefault().getOffset(j) / 1000);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzzf$1 */
    class C08291 extends com.google.android.gms.common.api.Api.zza<zzzk, NoOptions> {
        C08291() {
        }

        public /* synthetic */ Api.zze zza(Context context, Looper looper, zzg zzg, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zze(context, looper, zzg, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzzk zze(Context context, Looper looper, zzg zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzzk(context, looper, zzg, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public zzzf(Context context, int i, String str, String str2, String str3, boolean z, zzzg zzzg, zze zze, zzd zzd, zzb zzb) {
        boolean z2 = false;
        this.zzawn = -1;
        this.zzawr = 0;
        this.zzQL = context.getPackageName();
        this.zzawl = zzah(context);
        this.zzawn = i;
        this.zzawm = str;
        this.zzawo = str2;
        this.zzawp = str3;
        this.zzawq = z;
        this.zzaws = zzzg;
        this.zzuI = zze;
        if (zzd == null) {
            zzd = new zzd();
        }
        this.zzawt = zzd;
        this.zzawr = 0;
        this.zzawu = zzb;
        if (this.zzawq) {
            if (this.zzawo == null) {
                z2 = true;
            }
            zzac.zzb(z2, (Object) "can't be anonymous with an upload account");
        }
    }

    public zzzf(Context context, String str, String str2) {
        this(context, -1, str, str2, null, false, zzzj.zzai(context), zzh.zzyv(), null, new zzzo(context));
    }

    private int zzah(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return i;
        }
    }

    private static int[] zzb(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            iArr[i] = ((Integer) it.next()).intValue();
            i = i2;
        }
        return iArr;
    }

    private static String[] zzc(ArrayList<String> arrayList) {
        return arrayList == null ? null : (String[]) arrayList.toArray(new String[0]);
    }

    private static byte[][] zzd(ArrayList<byte[]> arrayList) {
        return arrayList == null ? null : (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public zza zzm(byte[] bArr) {
        return new zza(bArr);
    }
}
