package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zzmb
public class zzpp {
    private static zzl zzXw;
    private static final Object zzXx = new Object();
    public static final zza<Void> zzXy = new C07831();

    public interface zza<T> {
        T zzh(InputStream inputStream);

        T zziT();
    }

    /* renamed from: com.google.android.gms.internal.zzpp$1 */
    class C07831 implements zza<Void> {
        C07831() {
        }

        public /* bridge */ /* synthetic */ Object zzh(InputStream inputStream) {
            return null;
        }

        public /* bridge */ /* synthetic */ Object zziT() {
            return null;
        }
    }

    private static class zzb<T> extends zzk<InputStream> {
        private final zza<T> zzXC;
        private final com.google.android.gms.internal.zzm.zzb<T> zzaF;

        /* renamed from: com.google.android.gms.internal.zzpp$zzb$1 */
        class C07851 implements com.google.android.gms.internal.zzm.zza {
            final /* synthetic */ com.google.android.gms.internal.zzm.zzb zzXD;
            final /* synthetic */ zza zzXE;

            C07851(com.google.android.gms.internal.zzm.zzb zzb, zza zza) {
                this.zzXD = zzb;
                this.zzXE = zza;
            }

            public void zze(zzr zzr) {
                this.zzXD.zzb(this.zzXE.zziT());
            }
        }

        public zzb(String str, zza<T> zza, com.google.android.gms.internal.zzm.zzb<T> zzb) {
            super(0, str, new C07851(zzb, zza));
            this.zzXC = zza;
            this.zzaF = zzb;
        }

        protected zzm<InputStream> zza(zzi zzi) {
            return zzm.zza(new ByteArrayInputStream(zzi.data), zzx.zzb(zzi));
        }

        protected /* synthetic */ void zza(Object obj) {
            zzj((InputStream) obj);
        }

        protected void zzj(InputStream inputStream) {
            this.zzaF.zzb(this.zzXC.zzh(inputStream));
        }
    }

    private class zzc<T> extends zzqc<T> implements com.google.android.gms.internal.zzm.zzb<T> {
        private zzc(zzpp zzpp) {
        }

        public void zzb(@Nullable T t) {
            super.zzh(t);
        }
    }

    public zzpp(Context context) {
        zzN(context);
    }

    private static zzl zzN(Context context) {
        zzl zzl;
        synchronized (zzXx) {
            if (zzXw == null) {
                zzXw = zzac.zza(context.getApplicationContext());
            }
            zzl = zzXw;
        }
        return zzl;
    }

    public zzqf<String> zza(int i, final String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        final Object zzc = new zzc();
        final byte[] bArr2 = bArr;
        final Map<String, String> map2 = map;
        zzXw.zze(new zzab(this, i, str, zzc, new com.google.android.gms.internal.zzm.zza(this) {
            public void zze(zzr zzr) {
                String str = str;
                String valueOf = String.valueOf(zzr.toString());
                zzpy.zzbe(new StringBuilder((String.valueOf(str).length() + 21) + String.valueOf(valueOf).length()).append("Failed to load URL: ").append(str).append("\n").append(valueOf).toString());
                zzc.zzb(null);
            }
        }) {
            public Map<String, String> getHeaders() throws zza {
                return map2 == null ? super.getHeaders() : map2;
            }

            public byte[] zzm() throws zza {
                return bArr2 == null ? super.zzm() : bArr2;
            }
        });
        return zzc;
    }

    public <T> zzqf<T> zza(String str, zza<T> zza) {
        Object zzc = new zzc();
        zzXw.zze(new zzb(str, zza, zzc));
        return zzc;
    }

    public zzqf<String> zzc(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }
}
