package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@zzmb
public final class zzph {
    private static final ThreadPoolExecutor zzWJ = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzaU("Default"));
    private static final ThreadPoolExecutor zzWK = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzaU("Loader"));

    /* renamed from: com.google.android.gms.internal.zzph$1 */
    class C04461 implements Callable<Void> {
        final /* synthetic */ Runnable zzWL;

        C04461(Runnable runnable) {
            this.zzWL = runnable;
        }

        public /* synthetic */ Object call() throws Exception {
            return zzbl();
        }

        public Void zzbl() {
            this.zzWL.run();
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzph$2 */
    class C04472 implements Callable<Void> {
        final /* synthetic */ Runnable zzWL;

        C04472(Runnable runnable) {
            this.zzWL = runnable;
        }

        public /* synthetic */ Object call() throws Exception {
            return zzbl();
        }

        public Void zzbl() {
            this.zzWL.run();
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzph$3 */
    class C04483 implements Runnable {
        final /* synthetic */ zzqc zzWM;
        final /* synthetic */ Callable zzWN;

        C04483(zzqc zzqc, Callable callable) {
            this.zzWM = zzqc;
            this.zzWN = callable;
        }

        public void run() {
            try {
                Process.setThreadPriority(10);
                this.zzWM.zzh(this.zzWN.call());
            } catch (Throwable e) {
                zzv.zzcN().zza(e, "AdThreadPool.submit");
                this.zzWM.zze(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzph$4 */
    class C04494 implements Runnable {
        final /* synthetic */ zzqc zzWM;
        final /* synthetic */ Future zzWO;

        C04494(zzqc zzqc, Future future) {
            this.zzWM = zzqc;
            this.zzWO = future;
        }

        public void run() {
            if (this.zzWM.isCancelled()) {
                this.zzWO.cancel(true);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzph$5 */
    class C04505 implements ThreadFactory {
        private final AtomicInteger zzWP = new AtomicInteger(1);
        final /* synthetic */ String zzWQ;

        C04505(String str) {
            this.zzWQ = str;
        }

        public Thread newThread(Runnable runnable) {
            String str = this.zzWQ;
            return new Thread(runnable, new StringBuilder(String.valueOf(str).length() + 23).append("AdWorker(").append(str).append(") #").append(this.zzWP.getAndIncrement()).toString());
        }
    }

    static {
        zzWJ.allowCoreThreadTimeOut(true);
        zzWK.allowCoreThreadTimeOut(true);
    }

    public static zzqf<Void> zza(int i, Runnable runnable) {
        return i == 1 ? zza(zzWK, new C04461(runnable)) : zza(zzWJ, new C04472(runnable));
    }

    public static zzqf<Void> zza(Runnable runnable) {
        return zza(0, runnable);
    }

    public static <T> zzqf<T> zza(Callable<T> callable) {
        return zza(zzWJ, (Callable) callable);
    }

    public static <T> zzqf<T> zza(ExecutorService executorService, Callable<T> callable) {
        Object zzqc = new zzqc();
        try {
            zzqc.zzd(new C04494(zzqc, executorService.submit(new C04483(zzqc, callable))));
        } catch (Throwable e) {
            zzpy.zzc("Thread execution is rejected.", e);
            zzqc.cancel(true);
        }
        return zzqc;
    }

    private static ThreadFactory zzaU(String str) {
        return new C04505(str);
    }
}
