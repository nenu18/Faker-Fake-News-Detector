package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf.zzc;

@zzmb
public abstract class zzmf implements com.google.android.gms.internal.zzme.zza, zzpk<Void> {
    private final zzqi<zzmh> zzQV;
    private final com.google.android.gms.internal.zzme.zza zzQW;
    private final Object zzrN = new Object();

    /* renamed from: com.google.android.gms.internal.zzmf$2 */
    class C07712 implements com.google.android.gms.internal.zzqi.zza {
        final /* synthetic */ zzmf zzQY;

        C07712(zzmf zzmf) {
            this.zzQY = zzmf;
        }

        public void run() {
            this.zzQY.zziY();
        }
    }

    @zzmb
    public static final class zza extends zzmf {
        private final Context mContext;

        public zza(Context context, zzqi<zzmh> zzqi, com.google.android.gms.internal.zzme.zza zza) {
            super(zzqi, zza);
            this.mContext = context;
        }

        public void zziY() {
        }

        public zzmq zziZ() {
            return zzmz.zza(this.mContext, new zzfq((String) zzfx.zzAR.get()), zzmy.zzjf());
        }

        public /* synthetic */ Object zziw() {
            return super.zzit();
        }
    }

    @zzmb
    public static class zzb extends zzmf implements com.google.android.gms.common.internal.zzf.zzb, zzc {
        private Context mContext;
        private zzqi<zzmh> zzQV;
        private final com.google.android.gms.internal.zzme.zza zzQW;
        protected zzmg zzQZ;
        private boolean zzRa;
        private final Object zzrN = new Object();
        private zzqa zztr;

        public zzb(Context context, zzqa zzqa, zzqi<zzmh> zzqi, com.google.android.gms.internal.zzme.zza zza) {
            Looper zzkC;
            super(zzqi, zza);
            this.mContext = context;
            this.zztr = zzqa;
            this.zzQV = zzqi;
            this.zzQW = zza;
            if (((Boolean) zzfx.zzBE.get()).booleanValue()) {
                this.zzRa = true;
                zzkC = zzv.zzcZ().zzkC();
            } else {
                zzkC = context.getMainLooper();
            }
            this.zzQZ = new zzmg(context, zzkC, this, this, this.zztr.zzYc);
            connect();
        }

        protected void connect() {
            this.zzQZ.zzwT();
        }

        public void onConnected(Bundle bundle) {
            zziw();
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzpy.zzbc("Cannot connect to remote service, fallback to local instance.");
            zzja().zziw();
            Bundle bundle = new Bundle();
            bundle.putString("action", "gms_connection_failed_fallback_to_local");
            zzv.zzcJ().zzb(this.mContext, this.zztr.zzaZ, "gmob-apps", bundle, true);
        }

        public void onConnectionSuspended(int i) {
            zzpy.zzbc("Disconnected from remote ad request service.");
        }

        public void zziY() {
            synchronized (this.zzrN) {
                if (this.zzQZ.isConnected() || this.zzQZ.isConnecting()) {
                    this.zzQZ.disconnect();
                }
                Binder.flushPendingCommands();
                if (this.zzRa) {
                    zzv.zzcZ().zzkD();
                    this.zzRa = false;
                }
            }
        }

        public zzmq zziZ() {
            zzmq zzjb;
            synchronized (this.zzrN) {
                try {
                    zzjb = this.zzQZ.zzjb();
                } catch (IllegalStateException e) {
                    zzjb = null;
                    return zzjb;
                } catch (DeadObjectException e2) {
                    zzjb = null;
                    return zzjb;
                }
            }
            return zzjb;
        }

        public /* synthetic */ Object zziw() {
            return super.zzit();
        }

        zzpk zzja() {
            return new zza(this.mContext, this.zzQV, this.zzQW);
        }
    }

    public zzmf(zzqi<zzmh> zzqi, com.google.android.gms.internal.zzme.zza zza) {
        this.zzQV = zzqi;
        this.zzQW = zza;
    }

    public void cancel() {
        zziY();
    }

    boolean zza(zzmq zzmq, zzmh zzmh) {
        try {
            zzmq.zza(zzmh, new zzmj(this));
            return true;
        } catch (Throwable e) {
            zzpy.zzc("Could not fetch ad response from ad request service.", e);
            zzv.zzcN().zza(e, "AdRequestClientTask.getAdResponseFromService");
            this.zzQW.zzb(new zzmk(0));
            return false;
        } catch (Throwable e2) {
            zzpy.zzc("Could not fetch ad response from ad request service due to an Exception.", e2);
            zzv.zzcN().zza(e2, "AdRequestClientTask.getAdResponseFromService");
            this.zzQW.zzb(new zzmk(0));
            return false;
        } catch (Throwable e22) {
            zzpy.zzc("Could not fetch ad response from ad request service due to an Exception.", e22);
            zzv.zzcN().zza(e22, "AdRequestClientTask.getAdResponseFromService");
            this.zzQW.zzb(new zzmk(0));
            return false;
        } catch (Throwable e222) {
            zzpy.zzc("Could not fetch ad response from ad request service due to an Exception.", e222);
            zzv.zzcN().zza(e222, "AdRequestClientTask.getAdResponseFromService");
            this.zzQW.zzb(new zzmk(0));
            return false;
        }
    }

    public void zzb(zzmk zzmk) {
        synchronized (this.zzrN) {
            this.zzQW.zzb(zzmk);
            zziY();
        }
    }

    public abstract void zziY();

    public abstract zzmq zziZ();

    public Void zzit() {
        final zzmq zziZ = zziZ();
        if (zziZ == null) {
            this.zzQW.zzb(new zzmk(0));
            zziY();
        } else {
            this.zzQV.zza(new zzqi.zzc<zzmh>(this) {
                final /* synthetic */ zzmf zzQY;

                public void zzc(zzmh zzmh) {
                    if (!this.zzQY.zza(zziZ, zzmh)) {
                        this.zzQY.zziY();
                    }
                }

                public /* synthetic */ void zzd(Object obj) {
                    zzc((zzmh) obj);
                }
            }, new C07712(this));
        }
        return null;
    }

    public /* synthetic */ Object zziw() {
        return zzit();
    }
}
