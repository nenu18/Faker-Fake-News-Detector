package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzabs<T> {
    private static String READ_PERMISSION = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private static zza zzaCd = null;
    private static int zzaCe = 0;
    private static final Object zztU = new Object();
    protected final String zzAH;
    protected final T zzAI;
    private T zzaCf = null;

    private interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    /* renamed from: com.google.android.gms.internal.zzabs$1 */
    class C06581 extends zzabs<Boolean> {
        C06581(String str, Boolean bool) {
            super(str, bool);
        }

        protected /* synthetic */ Object zzdd(String str) {
            return zzde(str);
        }

        protected Boolean zzde(String str) {
            zza zza = null;
            return zza.zza(this.zzAH, (Boolean) this.zzAI);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzabs$2 */
    class C06592 extends zzabs<Long> {
        C06592(String str, Long l) {
            super(str, l);
        }

        protected /* synthetic */ Object zzdd(String str) {
            return zzdf(str);
        }

        protected Long zzdf(String str) {
            zza zza = null;
            return zza.getLong(this.zzAH, (Long) this.zzAI);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzabs$3 */
    class C06603 extends zzabs<Integer> {
        C06603(String str, Integer num) {
            super(str, num);
        }

        protected /* synthetic */ Object zzdd(String str) {
            return zzdg(str);
        }

        protected Integer zzdg(String str) {
            zza zza = null;
            return zza.zzb(this.zzAH, (Integer) this.zzAI);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzabs$4 */
    class C06614 extends zzabs<Float> {
        C06614(String str, Float f) {
            super(str, f);
        }

        protected /* synthetic */ Object zzdd(String str) {
            return zzdh(str);
        }

        protected Float zzdh(String str) {
            zza zza = null;
            return zza.zzb(this.zzAH, (Float) this.zzAI);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzabs$5 */
    class C06625 extends zzabs<String> {
        C06625(String str, String str2) {
            super(str, str2);
        }

        protected /* synthetic */ Object zzdd(String str) {
            return zzdi(str);
        }

        protected String zzdi(String str) {
            zza zza = null;
            return zza.getString(this.zzAH, (String) this.zzAI);
        }
    }

    protected zzabs(String str, T t) {
        this.zzAH = str;
        this.zzAI = t;
    }

    public static zzabs<String> zzA(String str, String str2) {
        return new C06625(str, str2);
    }

    public static zzabs<Float> zza(String str, Float f) {
        return new C06614(str, f);
    }

    public static zzabs<Integer> zza(String str, Integer num) {
        return new C06603(str, num);
    }

    public static zzabs<Long> zza(String str, Long l) {
        return new C06592(str, l);
    }

    public static zzabs<Boolean> zzj(String str, boolean z) {
        return new C06581(str, Boolean.valueOf(z));
    }

    public final T get() {
        T zzdd;
        long clearCallingIdentity;
        try {
            zzdd = zzdd(this.zzAH);
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            zzdd = zzdd(this.zzAH);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return zzdd;
    }

    protected abstract T zzdd(String str);
}
