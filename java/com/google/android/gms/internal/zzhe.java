package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzgz.zza;
import java.util.ArrayList;
import java.util.List;

@zzmb
public class zzhe extends NativeAppInstallAd {
    private final zzhd zzGS;
    private final List<Image> zzGT = new ArrayList();
    private final zzha zzGU;
    private VideoController zzzW = new VideoController();

    public zzhe(zzhd zzhd) {
        zzha zzha;
        this.zzGS = zzhd;
        try {
            List<Object> images = this.zzGS.getImages();
            if (images != null) {
                for (Object zze : images) {
                    zzgz zze2 = zze(zze);
                    if (zze2 != null) {
                        this.zzGT.add(new zzha(zze2));
                    }
                }
            }
        } catch (Throwable e) {
            zzpy.zzb("Failed to get image.", e);
        }
        try {
            zzgz zzfL = this.zzGS.zzfL();
            if (zzfL != null) {
                zzha = new zzha(zzfL);
                this.zzGU = zzha;
            }
        } catch (Throwable e2) {
            zzpy.zzb("Failed to get icon.", e2);
        }
        zzha = null;
        this.zzGU = zzha;
    }

    public void destroy() {
        try {
            this.zzGS.destroy();
        } catch (Throwable e) {
            zzpy.zzb("Failed to destroy", e);
        }
    }

    public CharSequence getBody() {
        try {
            return this.zzGS.getBody();
        } catch (Throwable e) {
            zzpy.zzb("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.zzGS.getCallToAction();
        } catch (Throwable e) {
            zzpy.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.zzGS.getExtras();
        } catch (Throwable e) {
            zzpy.zzb("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.zzGS.getHeadline();
        } catch (Throwable e) {
            zzpy.zzb("Failed to get headline.", e);
            return null;
        }
    }

    public Image getIcon() {
        return this.zzGU;
    }

    public List<Image> getImages() {
        return this.zzGT;
    }

    public CharSequence getPrice() {
        try {
            return this.zzGS.getPrice();
        } catch (Throwable e) {
            zzpy.zzb("Failed to get price.", e);
            return null;
        }
    }

    public Double getStarRating() {
        Double d = null;
        try {
            double starRating = this.zzGS.getStarRating();
            if (starRating != -1.0d) {
                d = Double.valueOf(starRating);
            }
        } catch (Throwable e) {
            zzpy.zzb("Failed to get star rating.", e);
        }
        return d;
    }

    public CharSequence getStore() {
        try {
            return this.zzGS.getStore();
        } catch (Throwable e) {
            zzpy.zzb("Failed to get store", e);
            return null;
        }
    }

    public VideoController getVideoController() {
        try {
            if (this.zzGS.zzbG() != null) {
                this.zzzW.zza(this.zzGS.zzbG());
            }
        } catch (Throwable e) {
            zzpy.zzb("Exception occurred while getting video controller", e);
        }
        return this.zzzW;
    }

    protected /* synthetic */ Object zzbv() {
        return zzfM();
    }

    zzgz zze(Object obj) {
        return obj instanceof IBinder ? zza.zzB((IBinder) obj) : null;
    }

    protected zzd zzfM() {
        try {
            return this.zzGS.zzfM();
        } catch (Throwable e) {
            zzpy.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
