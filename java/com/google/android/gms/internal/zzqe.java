package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@zzmb
public class zzqe {

    /* renamed from: com.google.android.gms.internal.zzqe$1 */
    class C04621 implements Runnable {
        final /* synthetic */ zzqc zzYi;
        final /* synthetic */ zza zzYj;
        final /* synthetic */ zzqf zzYk;

        C04621(zzqc zzqc, zza zza, zzqf zzqf) {
            this.zzYi = zzqc;
            this.zzYj = zza;
            this.zzYk = zzqf;
        }

        public void run() {
            try {
                this.zzYi.zzh(this.zzYj.apply(this.zzYk.get()));
                return;
            } catch (CancellationException e) {
            } catch (InterruptedException e2) {
            } catch (ExecutionException e3) {
            }
            this.zzYi.cancel(true);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqe$2 */
    class C04632 implements Runnable {
        final /* synthetic */ AtomicInteger zzYl;
        final /* synthetic */ int zzYm;
        final /* synthetic */ zzqc zzYn;
        final /* synthetic */ List zzYo;

        C04632(AtomicInteger atomicInteger, int i, zzqc zzqc, List list) {
            this.zzYl = atomicInteger;
            this.zzYm = i;
            this.zzYn = zzqc;
            this.zzYo = list;
        }

        public void run() {
            Throwable e;
            if (this.zzYl.incrementAndGet() >= this.zzYm) {
                try {
                    this.zzYn.zzh(zzqe.zzp(this.zzYo));
                    return;
                } catch (ExecutionException e2) {
                    e = e2;
                } catch (InterruptedException e3) {
                    e = e3;
                }
            } else {
                return;
            }
            zzpy.zzc("Unable to convert list of futures to a future of list", e);
        }
    }

    public interface zza<D, R> {
        R apply(D d);
    }

    public static <A, B> zzqf<B> zza(zzqf<A> zzqf, zza<A, B> zza) {
        zzqf zzqc = new zzqc();
        zzqf.zzc(new C04621(zzqc, zza, zzqf));
        return zzqc;
    }

    public static <V> zzqf<List<V>> zzo(List<zzqf<V>> list) {
        zzqf zzqc = new zzqc();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzqf zzc : list) {
            zzc.zzc(new C04632(atomicInteger, size, zzqc, list));
        }
        return zzqc;
    }

    private static <V> List<V> zzp(List<zzqf<V>> list) throws ExecutionException, InterruptedException {
        List<V> arrayList = new ArrayList();
        for (zzqf zzqf : list) {
            Object obj = zzqf.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
