package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzv;
import java.util.LinkedList;
import java.util.List;

@zzmb
class zziq {
    private final List<zza> zztf = new LinkedList();

    interface zza {
        void zzb(zzir zzir) throws RemoteException;
    }

    /* renamed from: com.google.android.gms.internal.zziq$1 */
    class C08211 extends com.google.android.gms.internal.zzel.zza {
        final /* synthetic */ zziq zzIl;

        /* renamed from: com.google.android.gms.internal.zziq$1$1 */
        class C07261 implements zza {
            C07261(C08211 c08211) {
            }

            public void zzb(zzir zzir) throws RemoteException {
                if (zzir.zzti != null) {
                    zzir.zzti.onAdClosed();
                }
                zzv.zzcY().zzgj();
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq$1$3 */
        class C07283 implements zza {
            C07283(C08211 c08211) {
            }

            public void zzb(zzir zzir) throws RemoteException {
                if (zzir.zzti != null) {
                    zzir.zzti.onAdLeftApplication();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq$1$4 */
        class C07294 implements zza {
            C07294(C08211 c08211) {
            }

            public void zzb(zzir zzir) throws RemoteException {
                if (zzir.zzti != null) {
                    zzir.zzti.onAdLoaded();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq$1$5 */
        class C07305 implements zza {
            C07305(C08211 c08211) {
            }

            public void zzb(zzir zzir) throws RemoteException {
                if (zzir.zzti != null) {
                    zzir.zzti.onAdOpened();
                }
            }
        }

        C08211(zziq zziq) {
            this.zzIl = zziq;
        }

        public void onAdClosed() throws RemoteException {
            this.zzIl.zztf.add(new C07261(this));
        }

        public void onAdFailedToLoad(final int i) throws RemoteException {
            this.zzIl.zztf.add(new zza(this) {
                public void zzb(zzir zzir) throws RemoteException {
                    if (zzir.zzti != null) {
                        zzir.zzti.onAdFailedToLoad(i);
                    }
                }
            });
            zzpe.m13v("Pooled interstitial failed to load.");
        }

        public void onAdLeftApplication() throws RemoteException {
            this.zzIl.zztf.add(new C07283(this));
        }

        public void onAdLoaded() throws RemoteException {
            this.zzIl.zztf.add(new C07294(this));
            zzpe.m13v("Pooled interstitial loaded.");
        }

        public void onAdOpened() throws RemoteException {
            this.zzIl.zztf.add(new C07305(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq$2 */
    class C08222 extends com.google.android.gms.internal.zzer.zza {
        final /* synthetic */ zziq zzIl;

        C08222(zziq zziq) {
            this.zzIl = zziq;
        }

        public void onAppEvent(final String str, final String str2) throws RemoteException {
            this.zzIl.zztf.add(new zza(this) {
                public void zzb(zzir zzir) throws RemoteException {
                    if (zzir.zzIt != null) {
                        zzir.zzIt.onAppEvent(str, str2);
                    }
                }
            });
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq$3 */
    class C08233 extends com.google.android.gms.internal.zzkz.zza {
        final /* synthetic */ zziq zzIl;

        C08233(zziq zziq) {
            this.zzIl = zziq;
        }

        public void zza(final zzky zzky) throws RemoteException {
            this.zzIl.zztf.add(new zza(this) {
                public void zzb(zzir zzir) throws RemoteException {
                    if (zzir.zzIu != null) {
                        zzir.zzIu.zza(zzky);
                    }
                }
            });
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq$4 */
    class C08244 extends com.google.android.gms.internal.zzgj.zza {
        final /* synthetic */ zziq zzIl;

        C08244(zziq zziq) {
            this.zzIl = zziq;
        }

        public void zza(final zzgi zzgi) throws RemoteException {
            this.zzIl.zztf.add(new zza(this) {
                public void zzb(zzir zzir) throws RemoteException {
                    if (zzir.zzIv != null) {
                        zzir.zzIv.zza(zzgi);
                    }
                }
            });
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq$5 */
    class C08255 extends com.google.android.gms.internal.zzek.zza {
        final /* synthetic */ zziq zzIl;

        /* renamed from: com.google.android.gms.internal.zziq$5$1 */
        class C07341 implements zza {
            C07341(C08255 c08255) {
            }

            public void zzb(zzir zzir) throws RemoteException {
                if (zzir.zzIw != null) {
                    zzir.zzIw.onAdClicked();
                }
            }
        }

        C08255(zziq zziq) {
            this.zzIl = zziq;
        }

        public void onAdClicked() throws RemoteException {
            this.zzIl.zztf.add(new C07341(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zziq$6 */
    class C08266 extends com.google.android.gms.internal.zznt.zza {
        final /* synthetic */ zziq zzIl;

        /* renamed from: com.google.android.gms.internal.zziq$6$1 */
        class C07351 implements zza {
            C07351(C08266 c08266) {
            }

            public void zzb(zzir zzir) throws RemoteException {
                if (zzir.zzIx != null) {
                    zzir.zzIx.onRewardedVideoAdLoaded();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq$6$2 */
        class C07362 implements zza {
            C07362(C08266 c08266) {
            }

            public void zzb(zzir zzir) throws RemoteException {
                if (zzir.zzIx != null) {
                    zzir.zzIx.onRewardedVideoAdOpened();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq$6$3 */
        class C07373 implements zza {
            C07373(C08266 c08266) {
            }

            public void zzb(zzir zzir) throws RemoteException {
                if (zzir.zzIx != null) {
                    zzir.zzIx.onRewardedVideoStarted();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq$6$4 */
        class C07384 implements zza {
            C07384(C08266 c08266) {
            }

            public void zzb(zzir zzir) throws RemoteException {
                if (zzir.zzIx != null) {
                    zzir.zzIx.onRewardedVideoAdClosed();
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zziq$6$6 */
        class C07406 implements zza {
            C07406(C08266 c08266) {
            }

            public void zzb(zzir zzir) throws RemoteException {
                if (zzir.zzIx != null) {
                    zzir.zzIx.onRewardedVideoAdLeftApplication();
                }
            }
        }

        C08266(zziq zziq) {
            this.zzIl = zziq;
        }

        public void onRewardedVideoAdClosed() throws RemoteException {
            this.zzIl.zztf.add(new C07384(this));
        }

        public void onRewardedVideoAdFailedToLoad(final int i) throws RemoteException {
            this.zzIl.zztf.add(new zza(this) {
                public void zzb(zzir zzir) throws RemoteException {
                    if (zzir.zzIx != null) {
                        zzir.zzIx.onRewardedVideoAdFailedToLoad(i);
                    }
                }
            });
        }

        public void onRewardedVideoAdLeftApplication() throws RemoteException {
            this.zzIl.zztf.add(new C07406(this));
        }

        public void onRewardedVideoAdLoaded() throws RemoteException {
            this.zzIl.zztf.add(new C07351(this));
        }

        public void onRewardedVideoAdOpened() throws RemoteException {
            this.zzIl.zztf.add(new C07362(this));
        }

        public void onRewardedVideoStarted() throws RemoteException {
            this.zzIl.zztf.add(new C07373(this));
        }

        public void zza(final zznq zznq) throws RemoteException {
            this.zzIl.zztf.add(new zza(this) {
                public void zzb(zzir zzir) throws RemoteException {
                    if (zzir.zzIx != null) {
                        zzir.zzIx.zza(zznq);
                    }
                }
            });
        }
    }

    zziq() {
    }

    void zza(final zzir zzir) {
        Handler handler = zzpi.zzWR;
        for (final zza zza : this.zztf) {
            handler.post(new Runnable(this) {
                public void run() {
                    try {
                        zza.zzb(zzir);
                    } catch (Throwable e) {
                        zzpy.zzc("Could not propagate interstitial ad event.", e);
                    }
                }
            });
        }
        this.zztf.clear();
    }

    void zzc(zzl zzl) {
        zzl.zza(new C08211(this));
        zzl.zza(new C08222(this));
        zzl.zza(new C08233(this));
        zzl.zza(new C08244(this));
        zzl.zza(new C08255(this));
        zzl.zza(new C08266(this));
    }
}
