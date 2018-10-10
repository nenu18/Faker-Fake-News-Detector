package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgu.zza;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzgv implements zzgu {
    private final Context mContext;
    private final zzr zzGl;
    @Nullable
    private final JSONObject zzGo;
    @Nullable
    private final zzlt zzGp;
    @Nullable
    private final zza zzGq;
    private final zzav zzGr;
    boolean zzGs;
    private zzqp zzGt;
    private String zzGu;
    @Nullable
    private String zzGv;
    private WeakReference<View> zzGw = null;
    private final Object zzrN = new Object();
    @Nullable
    private final zzqa zztr;

    /* renamed from: com.google.android.gms.internal.zzgv$3 */
    class C07153 extends zzlt.zza {
        final /* synthetic */ zzgv zzGy;

        /* renamed from: com.google.android.gms.internal.zzgv$3$2 */
        class C07112 implements zzhx {
            final /* synthetic */ C07153 zzGA;

            C07112(C07153 c07153) {
                this.zzGA = c07153;
            }

            public void zza(zzqp zzqp, Map<String, String> map) {
                this.zzGA.zzGy.zzGt.getView().setVisibility(0);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzgv$3$3 */
        class C07123 implements zzhx {
            final /* synthetic */ C07153 zzGA;

            C07123(C07153 c07153) {
                this.zzGA = c07153;
            }

            public void zza(zzqp zzqp, Map<String, String> map) {
                this.zzGA.zzGy.zzGt.getView().setVisibility(8);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzgv$3$4 */
        class C07134 implements zzhx {
            final /* synthetic */ C07153 zzGA;

            C07134(C07153 c07153) {
                this.zzGA = c07153;
            }

            public void zza(zzqp zzqp, Map<String, String> map) {
                this.zzGA.zzGy.zzGt.getView().setVisibility(8);
            }
        }

        C07153(zzgv zzgv) {
            this.zzGy = zzgv;
        }

        public void zze(final zzjb zzjb) {
            zzjb.zza("/loadHtml", new zzhx(this) {
                final /* synthetic */ C07153 zzGA;

                public void zza(zzqp zzqp, final Map<String, String> map) {
                    this.zzGA.zzGy.zzGt.zzkV().zza(new zzqq.zza(this) {
                        final /* synthetic */ C07101 zzGC;

                        public void zza(zzqp zzqp, boolean z) {
                            this.zzGC.zzGA.zzGy.zzGu = (String) map.get("id");
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("messageType", "htmlLoaded");
                                jSONObject.put("id", this.zzGC.zzGA.zzGy.zzGu);
                                zzjb.zzb("sendMessageToNativeJs", jSONObject);
                            } catch (Throwable e) {
                                zzpy.zzb("Unable to dispatch sendMessageToNativeJs event", e);
                            }
                        }
                    });
                    String str = (String) map.get("overlayHtml");
                    String str2 = (String) map.get("baseUrl");
                    if (TextUtils.isEmpty(str2)) {
                        this.zzGA.zzGy.zzGt.loadData(str, "text/html", "UTF-8");
                    } else {
                        this.zzGA.zzGy.zzGt.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                    }
                }
            });
            zzjb.zza("/showOverlay", new C07112(this));
            zzjb.zza("/hideOverlay", new C07123(this));
            this.zzGy.zzGt.zzkV().zza("/hideOverlay", new C07134(this));
            this.zzGy.zzGt.zzkV().zza("/sendMessageToSdk", new zzhx(this) {
                final /* synthetic */ C07153 zzGA;

                public void zza(zzqp zzqp, Map<String, String> map) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        for (String str : map.keySet()) {
                            jSONObject.put(str, map.get(str));
                        }
                        jSONObject.put("id", this.zzGA.zzGy.zzGu);
                        zzjb.zzb("sendMessageToNativeJs", jSONObject);
                    } catch (Throwable e) {
                        zzpy.zzb("Unable to dispatch sendMessageToNativeJs event", e);
                    }
                }
            });
        }
    }

    public zzgv(Context context, zzr zzr, @Nullable zzlt zzlt, zzav zzav, @Nullable JSONObject jSONObject, @Nullable zza zza, @Nullable zzqa zzqa, @Nullable String str) {
        this.mContext = context;
        this.zzGl = zzr;
        this.zzGp = zzlt;
        this.zzGr = zzav;
        this.zzGo = jSONObject;
        this.zzGq = zza;
        this.zztr = zzqa;
        this.zzGv = str;
    }

    private JSONObject zza(Map<String, WeakReference<View>> map, View view) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || view == null) {
            return jSONObject;
        }
        try {
            int[] zzk = zzk(view);
            for (Entry entry : map.entrySet()) {
                View view2 = (View) ((WeakReference) entry.getValue()).get();
                if (view2 != null) {
                    int[] zzk2 = zzk(view2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("width", zzB(zzl(view2)));
                    jSONObject2.put("height", zzB(zzm(view2)));
                    jSONObject2.put("x", zzB(zzk2[0] - zzk[0]));
                    jSONObject2.put("y", zzB(zzk2[1] - zzk[1]));
                    jSONObject.put((String) entry.getKey(), jSONObject2);
                }
            }
        } catch (JSONException e) {
            zzpy.zzbe("Unable to get all view rectangles");
        }
        return jSONObject;
    }

    private JSONObject zzb(Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("x", zzB(rect.left));
        jSONObject.put("y", zzB(rect.top));
        jSONObject.put("width", zzB(rect.right - rect.left));
        jSONObject.put("height", zzB(rect.bottom - rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private JSONObject zzb(Map<String, WeakReference<View>> map, View view) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || view == null) {
            return jSONObject;
        }
        int[] zzk = zzk(view);
        for (Entry entry : map.entrySet()) {
            View view2 = (View) ((WeakReference) entry.getValue()).get();
            if (view2 != null) {
                int[] zzk2 = zzk(view2);
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    Object zzb;
                    jSONObject3.put("width", zzB(zzl(view2)));
                    jSONObject3.put("height", zzB(zzm(view2)));
                    jSONObject3.put("x", zzB(zzk2[0] - zzk[0]));
                    jSONObject3.put("y", zzB(zzk2[1] - zzk[1]));
                    jSONObject3.put("relative_to", "ad_view");
                    jSONObject2.put("frame", jSONObject3);
                    Rect rect = new Rect();
                    if (view2.getLocalVisibleRect(rect)) {
                        zzb = zzb(rect);
                    } else {
                        zzb = new JSONObject();
                        zzb.put("x", zzB(zzk2[0] - zzk[0]));
                        zzb.put("y", zzB(zzk2[1] - zzk[1]));
                        zzb.put("width", 0);
                        zzb.put("height", 0);
                        zzb.put("relative_to", "ad_view");
                    }
                    jSONObject2.put("visible_bounds", zzb);
                    if (view2 instanceof TextView) {
                        TextView textView = (TextView) view2;
                        jSONObject2.put("text_color", textView.getCurrentTextColor());
                        jSONObject2.put("font_size", (double) textView.getTextSize());
                        jSONObject2.put("text", textView.getText());
                    }
                    jSONObject.put((String) entry.getKey(), jSONObject2);
                } catch (JSONException e) {
                    zzpy.zzbe("Unable to get asset views information");
                }
            }
        }
        return jSONObject;
    }

    private JSONObject zzn(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                jSONObject.put("width", zzB(zzl(view)));
                jSONObject.put("height", zzB(zzm(view)));
            } catch (Exception e) {
                zzpy.zzbe("Unable to get native ad view bounding box");
            }
        }
        return jSONObject;
    }

    private JSONObject zzo(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                Object zzb;
                int[] zzk = zzk(view);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", zzB(zzl(view)));
                jSONObject2.put("height", zzB(zzm(view)));
                jSONObject2.put("x", zzB(zzk[0]));
                jSONObject2.put("y", zzB(zzk[1]));
                jSONObject2.put("relative_to", "window");
                jSONObject.put("frame", jSONObject2);
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    zzb = zzb(rect);
                } else {
                    zzb = new JSONObject();
                    zzb.put("x", zzB(zzk[0]));
                    zzb.put("y", zzB(zzk[1]));
                    zzb.put("width", 0);
                    zzb.put("height", 0);
                    zzb.put("relative_to", "window");
                }
                jSONObject.put("visible_bounds", zzb);
            } catch (Exception e) {
                zzpy.zzbe("Unable to get native ad view bounding box");
            }
        }
        return jSONObject;
    }

    public Context getContext() {
        return this.mContext;
    }

    int zzB(int i) {
        return zzeh.zzeO().zzc(this.mContext, i);
    }

    public zzgn zza(OnClickListener onClickListener) {
        zzgm zzfO = this.zzGq.zzfO();
        if (zzfO == null) {
            return null;
        }
        zzgn zzgn = new zzgn(this.mContext, zzfO);
        zzgn.setLayoutParams(new LayoutParams(-1, -1));
        zzgn.zzfJ().setOnClickListener(onClickListener);
        zzgn.zzfJ().setContentDescription((CharSequence) zzfx.zzEa.get());
        return zzgn;
    }

    public void zza(View view, zzgs zzgs) {
        if (this.zzGq instanceof zzgp) {
            zzgp zzgp = (zzgp) this.zzGq;
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
            if (zzgp.zzfP() != null) {
                ((FrameLayout) view).addView(zzgp.zzfP(), layoutParams);
                this.zzGl.zza(zzgs);
            } else if (zzgp.getImages() != null && zzgp.getImages().size() > 0) {
                zzgz zze = zze(zzgp.getImages().get(0));
                if (zze != null) {
                    try {
                        zzd zzfK = zze.zzfK();
                        if (zzfK != null) {
                            Drawable drawable = (Drawable) zze.zzE(zzfK);
                            View zzfY = zzfY();
                            zzfY.setImageDrawable(drawable);
                            zzfY.setScaleType(ScaleType.CENTER_INSIDE);
                            ((FrameLayout) view).addView(zzfY, layoutParams);
                        }
                    } catch (RemoteException e) {
                        zzpy.zzbe("Could not get drawable from image");
                    }
                }
            }
        }
    }

    public void zza(View view, String str, @Nullable JSONObject jSONObject, Map<String, WeakReference<View>> map, View view2) {
        zzac.zzdn("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("asset", str);
            jSONObject2.put("template", this.zzGq.zzfN());
            final JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ad", this.zzGo);
            jSONObject3.put("click", jSONObject2);
            jSONObject3.put("has_custom_click_handler", this.zzGl.zzz(this.zzGq.getCustomTemplateId()) != null);
            if (((Boolean) zzfx.zzEc.get()).booleanValue()) {
                if (((Boolean) zzfx.zzEd.get()).booleanValue()) {
                    jSONObject3.put("asset_view_signal", zzb((Map) map, view2));
                    jSONObject3.put("ad_view_signal", zzo(view2));
                } else {
                    jSONObject3.put("view_rectangles", zza((Map) map, view2));
                    jSONObject3.put("native_view_rectangle", zzn(view2));
                }
            }
            if (jSONObject != null) {
                jSONObject3.put("click_point", jSONObject);
            }
            try {
                JSONObject optJSONObject = this.zzGo.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                jSONObject2.put("click_signals", this.zzGr.zzW().zza(this.mContext, optJSONObject.optString("click_string"), view));
            } catch (Throwable e) {
                zzpy.zzb("Exception obtaining click signals", e);
            }
            jSONObject3.put("ads_id", this.zzGv);
            this.zzGp.zza(new zzlt.zza(this) {
                public void zze(zzjb zzjb) {
                    zzjb.zza("google.afma.nativeAds.handleClickGmsg", jSONObject3);
                }
            });
        } catch (Throwable e2) {
            zzpy.zzb("Unable to create click JSON.", e2);
        }
    }

    public void zza(View view, Map<String, WeakReference<View>> map, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        if (((Boolean) zzfx.zzDX.get()).booleanValue()) {
            view.setOnTouchListener(onTouchListener);
            view.setClickable(true);
            view.setOnClickListener(onClickListener);
            if (map != null) {
                for (Entry value : map.entrySet()) {
                    View view2 = (View) ((WeakReference) value.getValue()).get();
                    if (view2 != null) {
                        view2.setOnTouchListener(onTouchListener);
                        view2.setClickable(true);
                        view2.setOnClickListener(onClickListener);
                    }
                }
            }
        }
    }

    public void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, View view2) {
        zzac.zzdn("performClick must be called on the main UI thread.");
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                    zza(view, (String) entry.getKey(), jSONObject, map, view2);
                    return;
                }
            }
        }
        if ("2".equals(this.zzGq.zzfN())) {
            zza(view, "2099", jSONObject, map, view2);
        } else if ("1".equals(this.zzGq.zzfN())) {
            zza(view, "1099", jSONObject, map, view2);
        }
    }

    public void zzb(View view, Map<String, WeakReference<View>> map) {
        zzac.zzdn("recordImpression must be called on the main UI thread.");
        zzq(true);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzGo);
            jSONObject.put("ads_id", this.zzGv);
            if (((Boolean) zzfx.zzEc.get()).booleanValue()) {
                if (((Boolean) zzfx.zzEd.get()).booleanValue()) {
                    jSONObject.put("asset_view_signal", zzb((Map) map, view));
                    jSONObject.put("ad_view_signal", zzo(view));
                } else {
                    jSONObject.put("view_rectangles", zza((Map) map, view));
                    jSONObject.put("native_view_rectangle", zzn(view));
                }
            }
            this.zzGp.zza(new zzlt.zza(this) {
                public void zze(zzjb zzjb) {
                    zzjb.zza("google.afma.nativeAds.handleImpressionPing", jSONObject);
                }
            });
        } catch (Throwable e) {
            zzpy.zzb("Unable to create impression JSON.", e);
        }
        this.zzGl.zza((zzgu) this);
    }

    public void zzc(View view, Map<String, WeakReference<View>> map) {
        if (!((Boolean) zzfx.zzDW.get()).booleanValue()) {
            view.setOnTouchListener(null);
            view.setClickable(false);
            view.setOnClickListener(null);
            if (map != null) {
                for (Entry value : map.entrySet()) {
                    View view2 = (View) ((WeakReference) value.getValue()).get();
                    if (view2 != null) {
                        view2.setOnTouchListener(null);
                        view2.setClickable(false);
                        view2.setOnClickListener(null);
                    }
                }
            }
        }
    }

    public void zzd(MotionEvent motionEvent) {
        this.zzGr.zza(motionEvent);
    }

    public void zzd(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.zzrN) {
            if (this.zzGs) {
            } else if (!view.isShown()) {
            } else if (view.getGlobalVisibleRect(new Rect(), null)) {
                zzb(view, (Map) map);
            }
        }
    }

    @Nullable
    zzgz zze(Object obj) {
        return obj instanceof IBinder ? zzgz.zza.zzB((IBinder) obj) : null;
    }

    public zzqp zzfU() {
        this.zzGt = zzfX();
        this.zzGt.getView().setVisibility(8);
        this.zzGp.zza(new C07153(this));
        return this.zzGt;
    }

    public View zzfV() {
        return this.zzGw != null ? (View) this.zzGw.get() : null;
    }

    public void zzfW() {
        if (this.zzGq instanceof zzgp) {
            this.zzGl.zzct();
        }
    }

    zzqp zzfX() {
        return zzv.zzcK().zza(this.mContext, zzec.zzj(this.mContext), false, false, this.zzGr, this.zztr);
    }

    ImageView zzfY() {
        return new ImageView(this.mContext);
    }

    public void zzj(View view) {
        this.zzGw = new WeakReference(view);
    }

    int[] zzk(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    int zzl(View view) {
        return view.getMeasuredWidth();
    }

    int zzm(View view) {
        return view.getMeasuredHeight();
    }

    protected void zzq(boolean z) {
        this.zzGs = z;
    }
}
