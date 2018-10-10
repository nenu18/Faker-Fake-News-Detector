package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzmb
public final class zzey {
    public static final String DEVICE_ID_EMULATOR = zzeh.zzeO().zzbb("emulator");
    private final Date zzcQ;
    private final Set<String> zzcS;
    private final Location zzcU;
    private final boolean zzsS;
    private final int zzyW;
    private final int zzyZ;
    private final Bundle zzzL;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzzM;
    private final SearchAdRequest zzzN;
    private final Set<String> zzzO;
    private final Set<String> zzzP;
    private final String zzza;
    private final String zzzc;
    private final Bundle zzze;
    private final String zzzg;
    private final boolean zzzi;

    public static final class zza {
        private Date zzcQ;
        private Location zzcU;
        private boolean zzsS = false;
        private int zzyW = -1;
        private int zzyZ = -1;
        private final Bundle zzzL = new Bundle();
        private final HashSet<String> zzzQ = new HashSet();
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzzR = new HashMap();
        private final HashSet<String> zzzS = new HashSet();
        private final HashSet<String> zzzT = new HashSet();
        private String zzza;
        private String zzzc;
        private final Bundle zzze = new Bundle();
        private String zzzg;
        private boolean zzzi;

        public void setManualImpressionsEnabled(boolean z) {
            this.zzsS = z;
        }

        public void zzL(String str) {
            this.zzzQ.add(str);
        }

        public void zzM(String str) {
            this.zzzS.add(str);
        }

        public void zzN(String str) {
            this.zzzS.remove(str);
        }

        public void zzO(String str) {
            this.zzzc = str;
        }

        public void zzP(String str) {
            this.zzza = str;
        }

        public void zzQ(String str) {
            this.zzzg = str;
        }

        public void zzR(String str) {
            this.zzzT.add(str);
        }

        @Deprecated
        public void zza(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.zzzR.put(networkExtras.getClass(), networkExtras);
            }
        }

        public void zza(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zzzL.putBundle(cls.getName(), bundle);
        }

        public void zza(Date date) {
            this.zzcQ = date;
        }

        public void zzb(Location location) {
            this.zzcU = location;
        }

        public void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
            if (this.zzzL.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.zzzL.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.zzzL.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        public void zze(String str, String str2) {
            this.zzze.putString(str, str2);
        }

        public void zzo(boolean z) {
            this.zzyZ = z ? 1 : 0;
        }

        public void zzp(boolean z) {
            this.zzzi = z;
        }

        public void zzx(int i) {
            this.zzyW = i;
        }
    }

    public zzey(zza zza) {
        this(zza, null);
    }

    public zzey(zza zza, SearchAdRequest searchAdRequest) {
        this.zzcQ = zza.zzcQ;
        this.zzzc = zza.zzzc;
        this.zzyW = zza.zzyW;
        this.zzcS = Collections.unmodifiableSet(zza.zzzQ);
        this.zzcU = zza.zzcU;
        this.zzsS = zza.zzsS;
        this.zzzL = zza.zzzL;
        this.zzzM = Collections.unmodifiableMap(zza.zzzR);
        this.zzza = zza.zzza;
        this.zzzg = zza.zzzg;
        this.zzzN = searchAdRequest;
        this.zzyZ = zza.zzyZ;
        this.zzzO = Collections.unmodifiableSet(zza.zzzS);
        this.zzze = zza.zzze;
        this.zzzP = Collections.unmodifiableSet(zza.zzzT);
        this.zzzi = zza.zzzi;
    }

    public Date getBirthday() {
        return this.zzcQ;
    }

    public String getContentUrl() {
        return this.zzzc;
    }

    public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzzL.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        return bundle != null ? bundle.getBundle(cls.getName()) : null;
    }

    public Bundle getCustomTargeting() {
        return this.zzze;
    }

    public int getGender() {
        return this.zzyW;
    }

    public Set<String> getKeywords() {
        return this.zzcS;
    }

    public Location getLocation() {
        return this.zzcU;
    }

    public boolean getManualImpressionsEnabled() {
        return this.zzsS;
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (NetworkExtras) this.zzzM.get(cls);
    }

    public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> cls) {
        return this.zzzL.getBundle(cls.getName());
    }

    public String getPublisherProvidedId() {
        return this.zzza;
    }

    public boolean isDesignedForFamilies() {
        return this.zzzi;
    }

    public boolean isTestDevice(Context context) {
        return this.zzzO.contains(zzeh.zzeO().zzO(context));
    }

    public String zzeW() {
        return this.zzzg;
    }

    public SearchAdRequest zzeX() {
        return this.zzzN;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> zzeY() {
        return this.zzzM;
    }

    public Bundle zzeZ() {
        return this.zzzL;
    }

    public int zzfa() {
        return this.zzyZ;
    }

    public Set<String> zzfb() {
        return this.zzzP;
    }
}
