package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgp;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zzgz;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjw;
import com.google.android.gms.internal.zzjx;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqq.zza;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzo {

    /* renamed from: com.google.android.gms.ads.internal.zzo$1 */
    class C06171 implements zza {
        final /* synthetic */ zzgp zztN;
        final /* synthetic */ String zztO;
        final /* synthetic */ zzqp zztP;

        C06171(zzgp zzgp, String str, zzqp zzqp) {
            this.zztN = zzgp;
            this.zztO = str;
            this.zztP = zzqp;
        }

        public void zza(zzqp zzqp, boolean z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("headline", this.zztN.getHeadline());
                jSONObject.put("body", this.zztN.getBody());
                jSONObject.put("call_to_action", this.zztN.getCallToAction());
                jSONObject.put(Param.PRICE, this.zztN.getPrice());
                jSONObject.put("star_rating", String.valueOf(this.zztN.getStarRating()));
                jSONObject.put("store", this.zztN.getStore());
                jSONObject.put("icon", zzo.zza(this.zztN.zzfL()));
                JSONArray jSONArray = new JSONArray();
                List<Object> images = this.zztN.getImages();
                if (images != null) {
                    for (Object zzf : images) {
                        jSONArray.put(zzo.zza(zzo.zze(zzf)));
                    }
                }
                jSONObject.put("images", jSONArray);
                jSONObject.put("extras", zzo.zza(this.zztN.getExtras(), this.zztO));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("assets", jSONObject);
                jSONObject2.put("template_id", "2");
                this.zztP.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
            } catch (Throwable e) {
                zzpy.zzc("Exception occurred when loading assets", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzo$2 */
    class C06182 implements zza {
        final /* synthetic */ String zztO;
        final /* synthetic */ zzqp zztP;
        final /* synthetic */ zzgq zztQ;

        C06182(zzgq zzgq, String str, zzqp zzqp) {
            this.zztQ = zzgq;
            this.zztO = str;
            this.zztP = zzqp;
        }

        public void zza(zzqp zzqp, boolean z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("headline", this.zztQ.getHeadline());
                jSONObject.put("body", this.zztQ.getBody());
                jSONObject.put("call_to_action", this.zztQ.getCallToAction());
                jSONObject.put("advertiser", this.zztQ.getAdvertiser());
                jSONObject.put("logo", zzo.zza(this.zztQ.zzfQ()));
                JSONArray jSONArray = new JSONArray();
                List<Object> images = this.zztQ.getImages();
                if (images != null) {
                    for (Object zzf : images) {
                        jSONArray.put(zzo.zza(zzo.zze(zzf)));
                    }
                }
                jSONObject.put("images", jSONArray);
                jSONObject.put("extras", zzo.zza(this.zztQ.getExtras(), this.zztO));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("assets", jSONObject);
                jSONObject2.put("template_id", "1");
                this.zztP.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
            } catch (Throwable e) {
                zzpy.zzc("Exception occurred when loading assets", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzo$3 */
    class C06193 implements zzhx {
        final /* synthetic */ CountDownLatch zzsA;

        C06193(CountDownLatch countDownLatch) {
            this.zzsA = countDownLatch;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            this.zzsA.countDown();
            zzqp.getView().setVisibility(0);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzo$4 */
    class C06204 implements zzhx {
        final /* synthetic */ CountDownLatch zzsA;

        C06204(CountDownLatch countDownLatch) {
            this.zzsA = countDownLatch;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            zzpy.zzbe("Adapter returned an ad, but assets substitution failed");
            this.zzsA.countDown();
            zzqp.destroy();
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.zzo$5 */
    class C06215 implements zzhx {
        final /* synthetic */ zzjw zztR;
        final /* synthetic */ zzf.zza zztS;
        final /* synthetic */ zzjx zztT;

        C06215(zzjw zzjw, zzf.zza zza, zzjx zzjx) {
            this.zztR = zzjw;
            this.zztS = zza;
            this.zztT = zzjx;
        }

        public void zza(zzqp zzqp, Map<String, String> map) {
            View view = zzqp.getView();
            if (view != null) {
                try {
                    if (this.zztR != null) {
                        if (this.zztR.getOverrideClickHandling()) {
                            zzo.zza(zzqp);
                            return;
                        }
                        this.zztR.zzk(zze.zzA(view));
                        this.zztS.onClick();
                    } else if (this.zztT == null) {
                    } else {
                        if (this.zztT.getOverrideClickHandling()) {
                            zzo.zza(zzqp);
                            return;
                        }
                        this.zztT.zzk(zze.zzA(view));
                        this.zztS.onClick();
                    }
                } catch (Throwable e) {
                    zzpy.zzc("Unable to call handleClick on mapper", e);
                }
            }
        }
    }

    private static zzgp zza(zzjw zzjw) throws RemoteException {
        return new zzgp(zzjw.getHeadline(), zzjw.getImages(), zzjw.getBody(), zzjw.zzfL(), zzjw.getCallToAction(), zzjw.getStarRating(), zzjw.getStore(), zzjw.getPrice(), null, zzjw.getExtras(), null, null);
    }

    private static zzgq zza(zzjx zzjx) throws RemoteException {
        return new zzgq(zzjx.getHeadline(), zzjx.getImages(), zzjx.getBody(), zzjx.zzfQ(), zzjx.getCallToAction(), zzjx.getAdvertiser(), null, zzjx.getExtras());
    }

    static zzhx zza(@Nullable zzjw zzjw, @Nullable zzjx zzjx, zzf.zza zza) {
        return new C06215(zzjw, zza, zzjx);
    }

    static zzhx zza(CountDownLatch countDownLatch) {
        return new C06193(countDownLatch);
    }

    private static String zza(@Nullable Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            zzpy.zzbe("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String valueOf = String.valueOf("data:image/png;base64,");
        encodeToString = String.valueOf(encodeToString);
        return encodeToString.length() != 0 ? valueOf.concat(encodeToString) : new String(valueOf);
    }

    static String zza(@Nullable zzgz zzgz) {
        if (zzgz == null) {
            zzpy.zzbe("Image is null. Returning empty string");
            return "";
        }
        try {
            Uri uri = zzgz.getUri();
            if (uri != null) {
                return uri.toString();
            }
        } catch (RemoteException e) {
            zzpy.zzbe("Unable to get image uri. Trying data uri next");
        }
        return zzb(zzgz);
    }

    private static JSONObject zza(@Nullable Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            if (bundle.containsKey(str2)) {
                if ("image".equals(jSONObject2.getString(str2))) {
                    Object obj = bundle.get(str2);
                    if (obj instanceof Bitmap) {
                        jSONObject.put(str2, zza((Bitmap) obj));
                    } else {
                        zzpy.zzbe("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle.get(str2) instanceof Bitmap) {
                    zzpy.zzbe("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    jSONObject.put(str2, String.valueOf(bundle.get(str2)));
                }
            }
        }
        return jSONObject;
    }

    public static void zza(@Nullable zzov zzov, zzf.zza zza) {
        zzjx zzjx = null;
        if (zzov != null && zzh(zzov)) {
            zzqp zzqp = zzov.zzMZ;
            Object view = zzqp != null ? zzqp.getView() : null;
            if (view == null) {
                zzpy.zzbe("AdWebView is null");
                return;
            }
            try {
                List list = zzov.zzKA != null ? zzov.zzKA.zzJU : null;
                if (list == null || list.isEmpty()) {
                    zzpy.zzbe("No template ids present in mediation response");
                    return;
                }
                zzjw zzgJ = zzov.zzKB != null ? zzov.zzKB.zzgJ() : null;
                if (zzov.zzKB != null) {
                    zzjx = zzov.zzKB.zzgK();
                }
                if (list.contains("2") && zzgJ != null) {
                    zzgJ.zzl(zze.zzA(view));
                    if (!zzgJ.getOverrideImpressionRecording()) {
                        zzgJ.recordImpression();
                    }
                    zzqp.zzkV().zza("/nativeExpressViewClicked", zza(zzgJ, null, zza));
                } else if (!list.contains("1") || zzjx == null) {
                    zzpy.zzbe("No matching template id and mapper");
                } else {
                    zzjx.zzl(zze.zzA(view));
                    if (!zzjx.getOverrideImpressionRecording()) {
                        zzjx.recordImpression();
                    }
                    zzqp.zzkV().zza("/nativeExpressViewClicked", zza(null, zzjx, zza));
                }
            } catch (Throwable e) {
                zzpy.zzc("Error occurred while recording impression and registering for clicks", e);
            }
        }
    }

    private static void zza(zzqp zzqp) {
        OnClickListener zzlk = zzqp.zzlk();
        if (zzlk != null) {
            zzlk.onClick(zzqp.getView());
        }
    }

    private static void zza(zzqp zzqp, zzgp zzgp, String str) {
        zzqp.zzkV().zza(new C06171(zzgp, str, zzqp));
    }

    private static void zza(zzqp zzqp, zzgq zzgq, String str) {
        zzqp.zzkV().zza(new C06182(zzgq, str, zzqp));
    }

    private static void zza(zzqp zzqp, CountDownLatch countDownLatch) {
        zzqp.zzkV().zza("/nativeExpressAssetsLoaded", zza(countDownLatch));
        zzqp.zzkV().zza("/nativeExpressAssetsLoadingFailed", zzb(countDownLatch));
    }

    public static boolean zza(zzqp zzqp, zzjn zzjn, CountDownLatch countDownLatch) {
        boolean z = false;
        try {
            z = zzb(zzqp, zzjn, countDownLatch);
        } catch (Throwable e) {
            zzpy.zzc("Unable to invoke load assets", e);
        } catch (RuntimeException e2) {
            countDownLatch.countDown();
            throw e2;
        }
        if (!z) {
            countDownLatch.countDown();
        }
        return z;
    }

    static zzhx zzb(CountDownLatch countDownLatch) {
        return new C06204(countDownLatch);
    }

    private static String zzb(zzgz zzgz) {
        try {
            zzd zzfK = zzgz.zzfK();
            if (zzfK == null) {
                zzpy.zzbe("Drawable is null. Returning empty string");
                return "";
            }
            Drawable drawable = (Drawable) zze.zzE(zzfK);
            if (drawable instanceof BitmapDrawable) {
                return zza(((BitmapDrawable) drawable).getBitmap());
            }
            zzpy.zzbe("Drawable is not an instance of BitmapDrawable. Returning empty string");
            return "";
        } catch (RemoteException e) {
            zzpy.zzbe("Unable to get drawable. Returning empty string");
            return "";
        }
    }

    private static boolean zzb(zzqp zzqp, zzjn zzjn, CountDownLatch countDownLatch) throws RemoteException {
        View view = zzqp.getView();
        if (view == null) {
            zzpy.zzbe("AdWebView is null");
            return false;
        }
        view.setVisibility(4);
        List list = zzjn.zzKA.zzJU;
        if (list == null || list.isEmpty()) {
            zzpy.zzbe("No template ids present in mediation response");
            return false;
        }
        zza(zzqp, countDownLatch);
        zzjw zzgJ = zzjn.zzKB.zzgJ();
        zzjx zzgK = zzjn.zzKB.zzgK();
        if (list.contains("2") && zzgJ != null) {
            zza(zzqp, zza(zzgJ), zzjn.zzKA.zzJT);
        } else if (!list.contains("1") || zzgK == null) {
            zzpy.zzbe("No matching template id and mapper");
            return false;
        } else {
            zza(zzqp, zza(zzgK), zzjn.zzKA.zzJT);
        }
        String str = zzjn.zzKA.zzJR;
        String str2 = zzjn.zzKA.zzJS;
        if (str2 != null) {
            zzqp.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        } else {
            zzqp.loadData(str, "text/html", "UTF-8");
        }
        return true;
    }

    @Nullable
    private static zzgz zze(Object obj) {
        return obj instanceof IBinder ? zzgz.zza.zzB((IBinder) obj) : null;
    }

    @Nullable
    public static View zzg(@Nullable zzov zzov) {
        if (zzov == null) {
            zzpy.m9e("AdState is null");
            return null;
        } else if (zzh(zzov) && zzov.zzMZ != null) {
            return zzov.zzMZ.getView();
        } else {
            try {
                zzd view = zzov.zzKB != null ? zzov.zzKB.getView() : null;
                if (view != null) {
                    return (View) zze.zzE(view);
                }
                zzpy.zzbe("View in mediation adapter is null.");
                return null;
            } catch (Throwable e) {
                zzpy.zzc("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    public static boolean zzh(@Nullable zzov zzov) {
        return (zzov == null || !zzov.zzRK || zzov.zzKA == null || zzov.zzKA.zzJR == null) ? false : true;
    }
}
