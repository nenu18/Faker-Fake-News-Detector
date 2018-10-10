package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzf.zzb;
import com.google.android.gms.common.internal.zzf.zzc;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.measurement.AppMeasurement.zzf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class zzatw extends zzats {
    private zzate zzbuA;
    private Boolean zzbuB;
    private final zzasv zzbuC;
    private final zzatz zzbuD;
    private final List<Runnable> zzbuE = new ArrayList();
    private final zzasv zzbuF;
    private final zza zzbuz;

    /* renamed from: com.google.android.gms.internal.zzatw$3 */
    class C03333 implements Runnable {
        final /* synthetic */ zzatw zzbuG;

        C03333(zzatw zzatw) {
            this.zzbuG = zzatw;
        }

        public void run() {
            zzate zzc = this.zzbuG.zzbuA;
            if (zzc == null) {
                this.zzbuG.zzJt().zzLa().log("Failed to send measurementEnabled to service");
                return;
            }
            try {
                zzc.zzb(this.zzbuG.zzJj().zzfH(this.zzbuG.zzJt().zzLh()));
                this.zzbuG.zznN();
            } catch (RemoteException e) {
                this.zzbuG.zzJt().zzLa().zzj("Failed to send measurementEnabled to the service", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzatw$8 */
    class C03388 implements Runnable {
        final /* synthetic */ zzatw zzbuG;

        C03388(zzatw zzatw) {
            this.zzbuG = zzatw;
        }

        public void run() {
            zzate zzc = this.zzbuG.zzbuA;
            if (zzc == null) {
                this.zzbuG.zzJt().zzLa().log("Discarding data. Failed to send app launch");
                return;
            }
            try {
                this.zzbuG.zza(zzc, null);
                zzc.zza(this.zzbuG.zzJj().zzfH(this.zzbuG.zzJt().zzLh()));
                this.zzbuG.zznN();
            } catch (RemoteException e) {
                this.zzbuG.zzJt().zzLa().zzj("Failed to send app launch to the service", e);
            }
        }
    }

    protected class zza implements ServiceConnection, zzb, zzc {
        final /* synthetic */ zzatw zzbuG;
        private volatile boolean zzbuL;
        private volatile zzath zzbuM;

        /* renamed from: com.google.android.gms.internal.zzatw$zza$4 */
        class C03434 implements Runnable {
            final /* synthetic */ zza zzbuO;

            C03434(zza zza) {
                this.zzbuO = zza;
            }

            public void run() {
                zzatw zzatw = this.zzbuO.zzbuG;
                Context context = this.zzbuO.zzbuG.getContext();
                this.zzbuO.zzbuG.zzJv().zzKk();
                zzatw.onServiceDisconnected(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
            }
        }

        protected zza(zzatw zzatw) {
            this.zzbuG = zzatw;
        }

        @MainThread
        public void onConnected(@Nullable Bundle bundle) {
            zzac.zzdn("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                try {
                    final zzate zzate = (zzate) this.zzbuM.zzwW();
                    this.zzbuM = null;
                    this.zzbuG.zzJs().zzm(new Runnable(this) {
                        final /* synthetic */ zza zzbuO;

                        public void run() {
                            synchronized (this.zzbuO) {
                                this.zzbuO.zzbuL = false;
                                if (!this.zzbuO.zzbuG.isConnected()) {
                                    this.zzbuO.zzbuG.zzJt().zzLf().log("Connected to remote service");
                                    this.zzbuO.zzbuG.zza(zzate);
                                }
                            }
                        }
                    });
                } catch (DeadObjectException e) {
                    this.zzbuM = null;
                    this.zzbuL = false;
                } catch (IllegalStateException e2) {
                    this.zzbuM = null;
                    this.zzbuL = false;
                }
            }
        }

        @MainThread
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzac.zzdn("MeasurementServiceConnection.onConnectionFailed");
            zzati zzLu = this.zzbuG.zzbpw.zzLu();
            if (zzLu != null) {
                zzLu.zzLc().zzj("Service connection failed", connectionResult);
            }
            synchronized (this) {
                this.zzbuL = false;
                this.zzbuM = null;
            }
        }

        @MainThread
        public void onConnectionSuspended(int i) {
            zzac.zzdn("MeasurementServiceConnection.onConnectionSuspended");
            this.zzbuG.zzJt().zzLf().log("Service connection suspended");
            this.zzbuG.zzJs().zzm(new C03434(this));
        }

        @MainThread
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzac.zzdn("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                if (iBinder == null) {
                    this.zzbuL = false;
                    this.zzbuG.zzJt().zzLa().log("Service connected with null binder");
                    return;
                }
                zzate zzate = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        zzate = com.google.android.gms.internal.zzate.zza.zzer(iBinder);
                        this.zzbuG.zzJt().zzLg().log("Bound to IMeasurementService interface");
                    } else {
                        this.zzbuG.zzJt().zzLa().zzj("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    this.zzbuG.zzJt().zzLa().log("Service connect failed to get IMeasurementService");
                }
                if (zzate == null) {
                    this.zzbuL = false;
                    try {
                        com.google.android.gms.common.stats.zza.zzyc().zza(this.zzbuG.getContext(), this.zzbuG.zzbuz);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    this.zzbuG.zzJs().zzm(new Runnable(this) {
                        final /* synthetic */ zza zzbuO;

                        public void run() {
                            synchronized (this.zzbuO) {
                                this.zzbuO.zzbuL = false;
                                if (!this.zzbuO.zzbuG.isConnected()) {
                                    this.zzbuO.zzbuG.zzJt().zzLg().log("Connected to service");
                                    this.zzbuO.zzbuG.zza(zzate);
                                }
                            }
                        }
                    });
                }
            }
        }

        @MainThread
        public void onServiceDisconnected(final ComponentName componentName) {
            zzac.zzdn("MeasurementServiceConnection.onServiceDisconnected");
            this.zzbuG.zzJt().zzLf().log("Service disconnected");
            this.zzbuG.zzJs().zzm(new Runnable(this) {
                final /* synthetic */ zza zzbuO;

                public void run() {
                    this.zzbuO.zzbuG.onServiceDisconnected(componentName);
                }
            });
        }

        @WorkerThread
        public void zzC(Intent intent) {
            this.zzbuG.zzmq();
            Context context = this.zzbuG.getContext();
            com.google.android.gms.common.stats.zza zzyc = com.google.android.gms.common.stats.zza.zzyc();
            synchronized (this) {
                if (this.zzbuL) {
                    this.zzbuG.zzJt().zzLg().log("Connection attempt already in progress");
                    return;
                }
                this.zzbuL = true;
                zzyc.zza(context, intent, this.zzbuG.zzbuz, 129);
            }
        }

        @WorkerThread
        public void zzMb() {
            this.zzbuG.zzmq();
            Context context = this.zzbuG.getContext();
            synchronized (this) {
                if (this.zzbuL) {
                    this.zzbuG.zzJt().zzLg().log("Connection attempt already in progress");
                } else if (this.zzbuM != null) {
                    this.zzbuG.zzJt().zzLg().log("Already awaiting connection attempt");
                } else {
                    this.zzbuM = new zzath(context, Looper.getMainLooper(), this, this);
                    this.zzbuG.zzJt().zzLg().log("Connecting to remote service");
                    this.zzbuL = true;
                    this.zzbuM.zzwT();
                }
            }
        }
    }

    protected zzatw(zzatp zzatp) {
        super(zzatp);
        this.zzbuD = new zzatz(zzatp.zznq());
        this.zzbuz = new zza(this);
        this.zzbuC = new zzasv(this, zzatp) {
            final /* synthetic */ zzatw zzbuG;

            public void run() {
                this.zzbuG.zznO();
            }
        };
        this.zzbuF = new zzasv(this, zzatp) {
            final /* synthetic */ zzatw zzbuG;

            public void run() {
                this.zzbuG.zzJt().zzLc().log("Tasks have been queued for a long time");
            }
        };
    }

    @WorkerThread
    private void onServiceDisconnected(ComponentName componentName) {
        zzmq();
        if (this.zzbuA != null) {
            this.zzbuA = null;
            zzJt().zzLg().zzj("Disconnected from device MeasurementService", componentName);
            zzLZ();
        }
    }

    private boolean zzLX() {
        zzJv().zzKk();
        List queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    @WorkerThread
    private void zzLZ() {
        zzmq();
        zzoc();
    }

    @WorkerThread
    private void zzMa() {
        zzmq();
        zzJt().zzLg().zzj("Processing queued up service tasks", Integer.valueOf(this.zzbuE.size()));
        for (Runnable zzm : this.zzbuE) {
            zzJs().zzm(zzm);
        }
        this.zzbuE.clear();
        this.zzbuF.cancel();
    }

    @WorkerThread
    private void zza(zzate zzate) {
        zzmq();
        zzac.zzw(zzate);
        this.zzbuA = zzate;
        zznN();
        zzMa();
    }

    @WorkerThread
    private void zznN() {
        zzmq();
        this.zzbuD.start();
        this.zzbuC.zzx(zzJv().zzoQ());
    }

    @WorkerThread
    private void zznO() {
        zzmq();
        if (isConnected()) {
            zzJt().zzLg().log("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    @WorkerThread
    private void zzo(Runnable runnable) throws IllegalStateException {
        zzmq();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzbuE.size()) >= zzJv().zzKq()) {
            zzJt().zzLa().log("Discarding data. Max runnable queue size reached");
        } else {
            this.zzbuE.add(runnable);
            this.zzbuF.zzx(60000);
            zzoc();
        }
    }

    @WorkerThread
    public void disconnect() {
        zzmq();
        zznA();
        try {
            com.google.android.gms.common.stats.zza.zzyc().zza(getContext(), this.zzbuz);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.zzbuA = null;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public boolean isConnected() {
        zzmq();
        zznA();
        return this.zzbuA != null;
    }

    public /* bridge */ /* synthetic */ void zzJd() {
        super.zzJd();
    }

    public /* bridge */ /* synthetic */ void zzJe() {
        super.zzJe();
    }

    public /* bridge */ /* synthetic */ void zzJf() {
        super.zzJf();
    }

    public /* bridge */ /* synthetic */ zzaso zzJg() {
        return super.zzJg();
    }

    public /* bridge */ /* synthetic */ zzass zzJh() {
        return super.zzJh();
    }

    public /* bridge */ /* synthetic */ zzatu zzJi() {
        return super.zzJi();
    }

    public /* bridge */ /* synthetic */ zzatf zzJj() {
        return super.zzJj();
    }

    public /* bridge */ /* synthetic */ zzasw zzJk() {
        return super.zzJk();
    }

    public /* bridge */ /* synthetic */ zzatw zzJl() {
        return super.zzJl();
    }

    public /* bridge */ /* synthetic */ zzatv zzJm() {
        return super.zzJm();
    }

    public /* bridge */ /* synthetic */ zzatg zzJn() {
        return super.zzJn();
    }

    public /* bridge */ /* synthetic */ zzasu zzJo() {
        return super.zzJo();
    }

    public /* bridge */ /* synthetic */ zzaue zzJp() {
        return super.zzJp();
    }

    public /* bridge */ /* synthetic */ zzatn zzJq() {
        return super.zzJq();
    }

    public /* bridge */ /* synthetic */ zzaty zzJr() {
        return super.zzJr();
    }

    public /* bridge */ /* synthetic */ zzato zzJs() {
        return super.zzJs();
    }

    public /* bridge */ /* synthetic */ zzati zzJt() {
        return super.zzJt();
    }

    public /* bridge */ /* synthetic */ zzatl zzJu() {
        return super.zzJu();
    }

    public /* bridge */ /* synthetic */ zzast zzJv() {
        return super.zzJv();
    }

    @WorkerThread
    protected void zzLR() {
        zzmq();
        zznA();
        zzo(new C03388(this));
    }

    @WorkerThread
    protected void zzLW() {
        zzmq();
        zznA();
        zzo(new C03333(this));
    }

    @WorkerThread
    protected boolean zzLY() {
        zzmq();
        zznA();
        zzJv().zzKk();
        zzJt().zzLg().log("Checking service availability");
        switch (com.google.android.gms.common.zzc.zzuz().isGooglePlayServicesAvailable(getContext())) {
            case 0:
                zzJt().zzLg().log("Service available");
                return true;
            case 1:
                zzJt().zzLg().log("Service missing");
                return false;
            case 2:
                zzJt().zzLf().log("Service container out of date");
                return true;
            case 3:
                zzJt().zzLc().log("Service disabled");
                return false;
            case 9:
                zzJt().zzLc().log("Service invalid");
                return false;
            case 18:
                zzJt().zzLc().log("Service updating");
                return true;
            default:
                return false;
        }
    }

    @WorkerThread
    void zza(zzate zzate, com.google.android.gms.common.internal.safeparcel.zza zza) {
        Object obj;
        zzmq();
        zzJe();
        zznA();
        if (VERSION.SDK_INT >= 11) {
            zzJv().zzKk();
            obj = 1;
        } else {
            obj = null;
        }
        List<com.google.android.gms.common.internal.safeparcel.zza> arrayList = new ArrayList();
        zzJv().zzKt();
        int i = 100;
        for (int i2 = 0; i2 < PointerIconCompat.TYPE_CONTEXT_MENU && r3 == 100; i2++) {
            if (obj != null) {
                Object zzls = zzJn().zzls(100);
                if (zzls != null) {
                    arrayList.addAll(zzls);
                    i = zzls.size();
                    if (zza != null && r3 < 100) {
                        arrayList.add(zza);
                    }
                    for (com.google.android.gms.common.internal.safeparcel.zza zza2 : arrayList) {
                        if (zza2 instanceof zzatb) {
                            try {
                                zzate.zza((zzatb) zza2, zzJj().zzfH(zzJt().zzLh()));
                            } catch (RemoteException e) {
                                zzJt().zzLa().zzj("Failed to send event to the service", e);
                            }
                        } else if (zza2 instanceof zzaub) {
                            zzJt().zzLa().log("Discarding data. Unrecognized parcel type.");
                        } else {
                            try {
                                zzate.zza((zzaub) zza2, zzJj().zzfH(zzJt().zzLh()));
                            } catch (RemoteException e2) {
                                zzJt().zzLa().zzj("Failed to send attribute to the service", e2);
                            }
                        }
                    }
                }
            }
            i = 0;
            arrayList.add(zza);
            for (com.google.android.gms.common.internal.safeparcel.zza zza22 : arrayList) {
                if (zza22 instanceof zzatb) {
                    zzate.zza((zzatb) zza22, zzJj().zzfH(zzJt().zzLh()));
                } else if (zza22 instanceof zzaub) {
                    zzJt().zzLa().log("Discarding data. Unrecognized parcel type.");
                } else {
                    zzate.zza((zzaub) zza22, zzJj().zzfH(zzJt().zzLh()));
                }
            }
        }
    }

    @WorkerThread
    protected void zza(final zzf zzf) {
        zzmq();
        zznA();
        zzo(new Runnable(this) {
            final /* synthetic */ zzatw zzbuG;

            public void run() {
                zzate zzc = this.zzbuG.zzbuA;
                if (zzc == null) {
                    this.zzbuG.zzJt().zzLa().log("Failed to send current screen to service");
                    return;
                }
                try {
                    if (zzf == null) {
                        zzc.zza(0, null, null, this.zzbuG.getContext().getPackageName());
                    } else {
                        zzc.zza(zzf.zzbpB, zzf.zzbpz, zzf.zzbpA, this.zzbuG.getContext().getPackageName());
                    }
                    this.zzbuG.zznN();
                } catch (RemoteException e) {
                    this.zzbuG.zzJt().zzLa().zzj("Failed to send current screen to the service", e);
                }
            }
        });
    }

    @WorkerThread
    public void zza(final AtomicReference<String> atomicReference) {
        zzmq();
        zznA();
        zzo(new Runnable(this) {
            final /* synthetic */ zzatw zzbuG;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r5 = this;
                r1 = r2;
                monitor-enter(r1);
                r0 = r5.zzbuG;	 Catch:{ RemoteException -> 0x0044 }
                r0 = r0.zzbuA;	 Catch:{ RemoteException -> 0x0044 }
                if (r0 != 0) goto L_0x0021;
            L_0x000b:
                r0 = r5.zzbuG;	 Catch:{ RemoteException -> 0x0044 }
                r0 = r0.zzJt();	 Catch:{ RemoteException -> 0x0044 }
                r0 = r0.zzLa();	 Catch:{ RemoteException -> 0x0044 }
                r2 = "Failed to get app instance id";
                r0.log(r2);	 Catch:{ RemoteException -> 0x0044 }
                r0 = r2;	 Catch:{ all -> 0x0041 }
                r0.notify();	 Catch:{ all -> 0x0041 }
                monitor-exit(r1);	 Catch:{ all -> 0x0041 }
            L_0x0020:
                return;
            L_0x0021:
                r2 = r2;	 Catch:{ RemoteException -> 0x0044 }
                r3 = r5.zzbuG;	 Catch:{ RemoteException -> 0x0044 }
                r3 = r3.zzJj();	 Catch:{ RemoteException -> 0x0044 }
                r4 = 0;
                r3 = r3.zzfH(r4);	 Catch:{ RemoteException -> 0x0044 }
                r0 = r0.zzc(r3);	 Catch:{ RemoteException -> 0x0044 }
                r2.set(r0);	 Catch:{ RemoteException -> 0x0044 }
                r0 = r5.zzbuG;	 Catch:{ RemoteException -> 0x0044 }
                r0.zznN();	 Catch:{ RemoteException -> 0x0044 }
                r0 = r2;	 Catch:{ all -> 0x0041 }
                r0.notify();	 Catch:{ all -> 0x0041 }
            L_0x003f:
                monitor-exit(r1);	 Catch:{ all -> 0x0041 }
                goto L_0x0020;
            L_0x0041:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0041 }
                throw r0;
            L_0x0044:
                r0 = move-exception;
                r2 = r5.zzbuG;	 Catch:{ all -> 0x005a }
                r2 = r2.zzJt();	 Catch:{ all -> 0x005a }
                r2 = r2.zzLa();	 Catch:{ all -> 0x005a }
                r3 = "Failed to get app instance id";
                r2.zzj(r3, r0);	 Catch:{ all -> 0x005a }
                r0 = r2;	 Catch:{ all -> 0x0041 }
                r0.notify();	 Catch:{ all -> 0x0041 }
                goto L_0x003f;
            L_0x005a:
                r0 = move-exception;
                r2 = r2;	 Catch:{ all -> 0x0041 }
                r2.notify();	 Catch:{ all -> 0x0041 }
                throw r0;	 Catch:{ all -> 0x0041 }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzatw.7.run():void");
            }
        });
    }

    @WorkerThread
    protected void zza(final AtomicReference<List<zzaub>> atomicReference, final boolean z) {
        zzmq();
        zznA();
        zzo(new Runnable(this) {
            final /* synthetic */ zzatw zzbuG;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r5 = this;
                r1 = r2;
                monitor-enter(r1);
                r0 = r5.zzbuG;	 Catch:{ RemoteException -> 0x0046 }
                r0 = r0.zzbuA;	 Catch:{ RemoteException -> 0x0046 }
                if (r0 != 0) goto L_0x0021;
            L_0x000b:
                r0 = r5.zzbuG;	 Catch:{ RemoteException -> 0x0046 }
                r0 = r0.zzJt();	 Catch:{ RemoteException -> 0x0046 }
                r0 = r0.zzLa();	 Catch:{ RemoteException -> 0x0046 }
                r2 = "Failed to get user properties";
                r0.log(r2);	 Catch:{ RemoteException -> 0x0046 }
                r0 = r2;	 Catch:{ all -> 0x0043 }
                r0.notify();	 Catch:{ all -> 0x0043 }
                monitor-exit(r1);	 Catch:{ all -> 0x0043 }
            L_0x0020:
                return;
            L_0x0021:
                r2 = r2;	 Catch:{ RemoteException -> 0x0046 }
                r3 = r5.zzbuG;	 Catch:{ RemoteException -> 0x0046 }
                r3 = r3.zzJj();	 Catch:{ RemoteException -> 0x0046 }
                r4 = 0;
                r3 = r3.zzfH(r4);	 Catch:{ RemoteException -> 0x0046 }
                r4 = r3;	 Catch:{ RemoteException -> 0x0046 }
                r0 = r0.zza(r3, r4);	 Catch:{ RemoteException -> 0x0046 }
                r2.set(r0);	 Catch:{ RemoteException -> 0x0046 }
                r0 = r5.zzbuG;	 Catch:{ RemoteException -> 0x0046 }
                r0.zznN();	 Catch:{ RemoteException -> 0x0046 }
                r0 = r2;	 Catch:{ all -> 0x0043 }
                r0.notify();	 Catch:{ all -> 0x0043 }
            L_0x0041:
                monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                goto L_0x0020;
            L_0x0043:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                throw r0;
            L_0x0046:
                r0 = move-exception;
                r2 = r5.zzbuG;	 Catch:{ all -> 0x005c }
                r2 = r2.zzJt();	 Catch:{ all -> 0x005c }
                r2 = r2.zzLa();	 Catch:{ all -> 0x005c }
                r3 = "Failed to get user properties";
                r2.zzj(r3, r0);	 Catch:{ all -> 0x005c }
                r0 = r2;	 Catch:{ all -> 0x0043 }
                r0.notify();	 Catch:{ all -> 0x0043 }
                goto L_0x0041;
            L_0x005c:
                r0 = move-exception;
                r2 = r2;	 Catch:{ all -> 0x0043 }
                r2.notify();	 Catch:{ all -> 0x0043 }
                throw r0;	 Catch:{ all -> 0x0043 }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzatw.6.run():void");
            }
        });
    }

    @WorkerThread
    protected void zzb(final zzaub zzaub) {
        boolean z;
        boolean z2 = true;
        zzmq();
        zznA();
        if (VERSION.SDK_INT >= 11) {
            zzJv().zzKk();
            z = true;
        } else {
            z = false;
        }
        if (!(z && zzJn().zza(zzaub))) {
            z2 = false;
        }
        zzo(new Runnable(this) {
            final /* synthetic */ zzatw zzbuG;

            public void run() {
                zzate zzc = this.zzbuG.zzbuA;
                if (zzc == null) {
                    this.zzbuG.zzJt().zzLa().log("Discarding data. Failed to set user attribute");
                    return;
                }
                this.zzbuG.zza(zzc, z2 ? null : zzaub);
                this.zzbuG.zznN();
            }
        });
    }

    @WorkerThread
    protected void zzc(zzatb zzatb, String str) {
        boolean z;
        boolean z2 = true;
        zzac.zzw(zzatb);
        zzmq();
        zznA();
        if (VERSION.SDK_INT >= 11) {
            zzJv().zzKk();
            z = true;
        } else {
            z = false;
        }
        if (!(z && zzJn().zza(zzatb))) {
            z2 = false;
        }
        final zzatb zzatb2 = zzatb;
        final String str2 = str;
        zzo(new Runnable(this) {
            final /* synthetic */ zzatw zzbuG;

            public void run() {
                zzate zzc = this.zzbuG.zzbuA;
                if (zzc == null) {
                    this.zzbuG.zzJt().zzLa().log("Discarding data. Failed to send event to service");
                    return;
                }
                if (z) {
                    this.zzbuG.zza(zzc, z2 ? null : zzatb2);
                } else {
                    try {
                        if (TextUtils.isEmpty(str2)) {
                            zzc.zza(zzatb2, this.zzbuG.zzJj().zzfH(this.zzbuG.zzJt().zzLh()));
                        } else {
                            zzc.zza(zzatb2, str2, this.zzbuG.zzJt().zzLh());
                        }
                    } catch (RemoteException e) {
                        this.zzbuG.zzJt().zzLa().zzj("Failed to send event to the service", e);
                    }
                }
                this.zzbuG.zznN();
            }
        });
    }

    public /* bridge */ /* synthetic */ void zzmq() {
        super.zzmq();
    }

    protected void zzmr() {
    }

    public /* bridge */ /* synthetic */ zze zznq() {
        return super.zznq();
    }

    @WorkerThread
    void zzoc() {
        zzmq();
        zznA();
        if (!isConnected()) {
            if (this.zzbuB == null) {
                this.zzbuB = zzJu().zzLn();
                if (this.zzbuB == null) {
                    zzJt().zzLg().log("State of service unknown");
                    this.zzbuB = Boolean.valueOf(zzLY());
                    zzJu().zzaF(this.zzbuB.booleanValue());
                }
            }
            if (this.zzbuB.booleanValue()) {
                zzJt().zzLg().log("Using measurement service");
                this.zzbuz.zzMb();
            } else if (zzLX()) {
                zzJt().zzLg().log("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                Context context = getContext();
                zzJv().zzKk();
                intent.setComponent(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
                this.zzbuz.zzC(intent);
            } else {
                zzJt().zzLa().log("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }
}
