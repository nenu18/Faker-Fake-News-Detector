package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzaf.zza;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class zzat extends zzar {
    private static final String TAG = zzat.class.getSimpleName();
    private static long startTime = 0;
    protected static volatile zzbc zzpC = null;
    protected static final Object zzpV = new Object();
    static boolean zzpW = false;
    protected boolean zzpX = false;
    protected String zzpY;
    protected boolean zzpZ = false;
    protected boolean zzqa = false;

    protected zzat(Context context, String str) {
        super(context);
        this.zzpY = str;
        this.zzpX = false;
    }

    protected zzat(Context context, String str, boolean z) {
        super(context);
        this.zzpY = str;
        this.zzpX = z;
    }

    static zzbd zza(zzbc zzbc, MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zzaz {
        Throwable e;
        Method zzc = zzbc.zzc(zzay.zzaD(), zzay.zzaE());
        if (zzc == null || motionEvent == null) {
            throw new zzaz();
        }
        try {
            return new zzbd((String) zzc.invoke(null, new Object[]{motionEvent, displayMetrics}));
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new zzaz(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new zzaz(e);
        }
    }

    protected static synchronized void zza(Context context, boolean z) {
        synchronized (zzat.class) {
            if (!zzpW) {
                startTime = zzbe.zzbc().longValue() / 1000;
                zzpC = zzb(context, z);
                zzpW = true;
            }
        }
    }

    private static void zza(zzbc zzbc) {
        List singletonList = Collections.singletonList(Context.class);
        zzbc.zza(zzay.zzaj(), zzay.zzak(), singletonList);
        zzbc.zza(zzay.zzat(), zzay.zzau(), singletonList);
        zzbc.zza(zzay.zzar(), zzay.zzas(), singletonList);
        zzbc.zza(zzay.zzad(), zzay.zzae(), singletonList);
        zzbc.zza(zzay.zzan(), zzay.zzao(), singletonList);
        zzbc.zza(zzay.zzZ(), zzay.zzaa(), singletonList);
        zzbc.zza(zzay.zzaF(), zzay.zzaG(), singletonList);
        singletonList = Arrays.asList(new Class[]{MotionEvent.class, DisplayMetrics.class});
        zzbc.zza(zzay.zzaD(), zzay.zzaE(), singletonList);
        zzbc.zza(zzay.zzaB(), zzay.zzaC(), singletonList);
        zzbc.zza(zzay.zzah(), zzay.zzai(), Collections.emptyList());
        zzbc.zza(zzay.zzaz(), zzay.zzaA(), Collections.emptyList());
        zzbc.zza(zzay.zzap(), zzay.zzaq(), Collections.emptyList());
        zzbc.zza(zzay.zzaf(), zzay.zzag(), Collections.emptyList());
        zzbc.zza(zzay.zzal(), zzay.zzam(), Collections.emptyList());
        zzbc.zza(zzay.zzax(), zzay.zzay(), Collections.emptyList());
        zzbc.zza(zzay.zzab(), zzay.zzac(), Arrays.asList(new Class[]{Context.class, Boolean.TYPE, Boolean.TYPE}));
        zzbc.zza(zzay.zzav(), zzay.zzaw(), Arrays.asList(new Class[]{StackTraceElement[].class}));
        zzbc.zza(zzay.zzaH(), zzay.zzaI(), Arrays.asList(new Class[]{View.class}));
    }

    private void zza(zzbc zzbc, zza zza) {
        zzbd zza2;
        zza.zza zza3;
        int i = 0;
        try {
            zza2 = zza(zzbc, this.zzpI, this.zzpT);
            zza.zzbm = zza2.zzqM;
            zza.zzbn = zza2.zzqN;
            zza.zzbo = zza2.zzqO;
            if (this.zzpS) {
                zza.zzbA = zza2.zzce;
                zza.zzbB = zza2.zzcc;
            }
            if (((Boolean) zzfx.zzDq.get()).booleanValue() || ((Boolean) zzfx.zzDl.get()).booleanValue()) {
                zza3 = new zza.zza();
                zzbd zzb = zzb(this.zzpI);
                zza3.zzbm = zzb.zzqM;
                zza3.zzbn = zzb.zzqN;
                zza3.zzch = zzb.zzqO;
                if (this.zzpS) {
                    zza3.zzcc = zzb.zzcc;
                    zza3.zzce = zzb.zzce;
                    zza3.zzcg = Integer.valueOf(zzb.zzqP.longValue() != 0 ? 1 : 0);
                    if (this.zzpL > 0) {
                        zza3.zzcd = this.zzpT != null ? Long.valueOf(Math.round(((double) this.zzpQ) / ((double) this.zzpL))) : null;
                        zza3.zzcf = Long.valueOf(Math.round(((double) this.zzpP) / ((double) this.zzpL)));
                    }
                    zza3.zzcj = zzb.zzcj;
                    zza3.zzci = zzb.zzci;
                    zza3.zzck = Integer.valueOf(zzb.zzqS.longValue() != 0 ? 1 : 0);
                    if (this.zzpO > 0) {
                        zza3.zzcl = Long.valueOf(this.zzpO);
                    }
                }
                zza.zzbR = zza3;
            }
        } catch (zzaz e) {
        }
        if (this.zzpK > 0) {
            zza.zzbF = Long.valueOf(this.zzpK);
        }
        if (this.zzpL > 0) {
            zza.zzbE = Long.valueOf(this.zzpL);
        }
        if (this.zzpM > 0) {
            zza.zzbD = Long.valueOf(this.zzpM);
        }
        if (this.zzpN > 0) {
            zza.zzbG = Long.valueOf(this.zzpN);
        }
        try {
            int size = this.zzpJ.size() - 1;
            if (size > 0) {
                zza.zzbS = new zza.zza[size];
                while (i < size) {
                    zza2 = zza(zzbc, (MotionEvent) this.zzpJ.get(i), this.zzpT);
                    zza3 = new zza.zza();
                    zza3.zzbm = zza2.zzqM;
                    zza3.zzbn = zza2.zzqN;
                    zza.zzbS[i] = zza3;
                    i++;
                }
            }
        } catch (zzaz e2) {
            zza.zzbS = null;
        }
    }

    protected static zzbc zzb(Context context, boolean z) {
        if (zzpC == null) {
            synchronized (zzpV) {
                if (zzpC == null) {
                    zzbc zza = zzbc.zza(context, zzay.getKey(), zzay.zzY(), z);
                    zza(zza);
                    zzpC = zza;
                }
            }
        }
        return zzpC;
    }

    protected long zza(StackTraceElement[] stackTraceElementArr) throws zzaz {
        Throwable e;
        Method zzc = zzpC.zzc(zzay.zzav(), zzay.zzaw());
        if (zzc == null || stackTraceElementArr == null) {
            throw new zzaz();
        }
        try {
            return new zzba((String) zzc.invoke(null, new Object[]{stackTraceElementArr})).zzqm.longValue();
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new zzaz(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new zzaz(e);
        }
    }

    protected zza zza(Context context, View view) {
        zza zza = new zza();
        if (!TextUtils.isEmpty(this.zzpY)) {
            zza.zzaZ = this.zzpY;
        }
        zzbc zzb = zzb(context, this.zzpX);
        zzb.zzba();
        zzb(zzb, zza, view);
        zzb.zzbb();
        return zza;
    }

    protected zza zza(Context context, zzad.zza zza) {
        zza zza2 = new zza();
        if (!TextUtils.isEmpty(this.zzpY)) {
            zza2.zzaZ = this.zzpY;
        }
        zzbc zzb = zzb(context, this.zzpX);
        zzb.zzba();
        zza(zzb, zza2, zza);
        zzb.zzbb();
        return zza2;
    }

    protected List<Callable<Void>> zza(zzbc zzbc, zza zza, View view) {
        ArrayList arrayList = new ArrayList();
        if (zzbc.zzaJ() == null) {
            return arrayList;
        }
        int zzT = zzbc.zzT();
        arrayList.add(new zzbn(zzbc, zza));
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new zzbq(zzbc, zzay.zzap(), zzay.zzaq(), zza, zzT, 1));
        arrayList2 = arrayList;
        arrayList2.add(new zzbl(zzbc, zzay.zzah(), zzay.zzai(), zza, startTime, zzT, 25));
        arrayList2 = arrayList;
        arrayList2.add(new zzbk(zzbc, zzay.zzaf(), zzay.zzag(), zza, zzT, 44));
        arrayList2 = arrayList;
        arrayList2.add(new zzbg(zzbc, zzay.zzZ(), zzay.zzaa(), zza, zzT, 3));
        arrayList2 = arrayList;
        arrayList2.add(new zzbo(zzbc, zzay.zzal(), zzay.zzam(), zza, zzT, 22));
        if (((Boolean) zzfx.zzDw.get()).booleanValue() || ((Boolean) zzfx.zzDl.get()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new zzbj(zzbc, zzay.zzad(), zzay.zzae(), zza, zzT, 5));
        }
        if (((Boolean) zzfx.zzDp.get()).booleanValue() || ((Boolean) zzfx.zzDl.get()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new zzbv(zzbc, zzay.zzaF(), zzay.zzaG(), zza, zzT, 48));
        }
        if (((Boolean) zzfx.zzDu.get()).booleanValue() || ((Boolean) zzfx.zzDl.get()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new zzbt(zzbc, zzay.zzax(), zzay.zzay(), zza, zzT, 51));
        }
        if (((Boolean) zzfx.zzDz.get()).booleanValue() || ((Boolean) zzfx.zzDl.get()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new zzbs(zzbc, zzay.zzav(), zzay.zzaw(), zza, zzT, 45, new Throwable().getStackTrace()));
        }
        if (((Boolean) zzfx.zzDA.get()).booleanValue()) {
            arrayList2 = arrayList;
            arrayList2.add(new zzbw(zzbc, zzay.zzaH(), zzay.zzaI(), zza, zzT, 57, view));
        }
        return arrayList;
    }

    protected void zza(zzbc zzbc, zza zza, zzad.zza zza2) {
        if (zzbc.zzaJ() != null) {
            zza(zzb(zzbc, zza, zza2));
        }
    }

    protected void zza(List<Callable<Void>> list) {
        if (zzpC != null) {
            ExecutorService zzaJ = zzpC.zzaJ();
            if (zzaJ != null && !list.isEmpty()) {
                try {
                    zzaJ.invokeAll(list, ((Long) zzfx.zzDg.get()).longValue(), TimeUnit.MILLISECONDS);
                } catch (Throwable e) {
                    Log.d(TAG, String.format("class methods got exception: %s", new Object[]{zzbe.zza(e)}));
                }
            }
        }
    }

    protected zzbd zzb(MotionEvent motionEvent) throws zzaz {
        Throwable e;
        Method zzc = zzpC.zzc(zzay.zzaB(), zzay.zzaC());
        if (zzc == null || motionEvent == null) {
            throw new zzaz();
        }
        try {
            return new zzbd((String) zzc.invoke(null, new Object[]{motionEvent, this.zzpT}));
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new zzaz(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new zzaz(e);
        }
    }

    protected List<Callable<Void>> zzb(zzbc zzbc, zza zza, zzad.zza zza2) {
        int zzT = zzbc.zzT();
        List arrayList = new ArrayList();
        String zzab = zzay.zzab();
        String zzac = zzay.zzac();
        boolean z = ((Boolean) zzfx.zzDk.get()).booleanValue() || ((Boolean) zzfx.zzDl.get()).booleanValue();
        arrayList.add(new zzbi(zzbc, zzab, zzac, zza, zzT, 27, z, zza2));
        arrayList.add(new zzbl(zzbc, zzay.zzah(), zzay.zzai(), zza, startTime, zzT, 25));
        arrayList.add(new zzbq(zzbc, zzay.zzap(), zzay.zzaq(), zza, zzT, 1));
        arrayList.add(new zzbr(zzbc, zzay.zzar(), zzay.zzas(), zza, zzT, 31));
        arrayList.add(new zzbu(zzbc, zzay.zzaz(), zzay.zzaA(), zza, zzT, 33));
        arrayList.add(new zzbh(zzbc, zzay.zzat(), zzay.zzau(), zza, zzT, 29));
        arrayList.add(new zzbj(zzbc, zzay.zzad(), zzay.zzae(), zza, zzT, 5));
        arrayList.add(new zzbp(zzbc, zzay.zzan(), zzay.zzao(), zza, zzT, 12));
        arrayList.add(new zzbg(zzbc, zzay.zzZ(), zzay.zzaa(), zza, zzT, 3));
        arrayList.add(new zzbk(zzbc, zzay.zzaf(), zzay.zzag(), zza, zzT, 44));
        arrayList.add(new zzbo(zzbc, zzay.zzal(), zzay.zzam(), zza, zzT, 22));
        if (((Boolean) zzfx.zzDn.get()).booleanValue() || ((Boolean) zzfx.zzDl.get()).booleanValue()) {
            arrayList.add(new zzbv(zzbc, zzay.zzaF(), zzay.zzaG(), zza, zzT, 48));
        }
        if (((Boolean) zzfx.zzDs.get()).booleanValue() || ((Boolean) zzfx.zzDl.get()).booleanValue()) {
            arrayList.add(new zzbt(zzbc, zzay.zzax(), zzay.zzay(), zza, zzT, 51));
        }
        return arrayList;
    }

    protected void zzb(zzbc zzbc, zza zza, View view) {
        zza(zzbc, zza);
        zza(zza(zzbc, zza, view));
    }
}
