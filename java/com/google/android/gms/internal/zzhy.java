package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzhy implements zzhx {
    private final Context mContext;
    private final zzqa zztr;

    @zzmb
    static class zza {
        private final String mValue;
        private final String zzAH;

        public zza(String str, String str2) {
            this.zzAH = str;
            this.mValue = str2;
        }

        public String getKey() {
            return this.zzAH;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    @zzmb
    static class zzb {
        private final String zzHC;
        private final URL zzHD;
        private final ArrayList<zza> zzHE;
        private final String zzHF;

        public zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.zzHC = str;
            this.zzHD = url;
            if (arrayList == null) {
                this.zzHE = new ArrayList();
            } else {
                this.zzHE = arrayList;
            }
            this.zzHF = str2;
        }

        public String zzfZ() {
            return this.zzHC;
        }

        public URL zzga() {
            return this.zzHD;
        }

        public ArrayList<zza> zzgb() {
            return this.zzHE;
        }

        public String zzgc() {
            return this.zzHF;
        }
    }

    @zzmb
    class zzc {
        private final zzd zzHG;
        private final boolean zzHH;
        private final String zzHI;

        public zzc(zzhy zzhy, boolean z, zzd zzd, String str) {
            this.zzHH = z;
            this.zzHG = zzd;
            this.zzHI = str;
        }

        public String getReason() {
            return this.zzHI;
        }

        public boolean isSuccess() {
            return this.zzHH;
        }

        public zzd zzgd() {
            return this.zzHG;
        }
    }

    @zzmb
    static class zzd {
        private final String zzFU;
        private final String zzHC;
        private final int zzHJ;
        private final List<zza> zzHK;

        public zzd(String str, int i, List<zza> list, String str2) {
            this.zzHC = str;
            this.zzHJ = i;
            if (list == null) {
                this.zzHK = new ArrayList();
            } else {
                this.zzHK = list;
            }
            this.zzFU = str2;
        }

        public String getBody() {
            return this.zzFU;
        }

        public int getResponseCode() {
            return this.zzHJ;
        }

        public String zzfZ() {
            return this.zzHC;
        }

        public Iterable<zza> zzge() {
            return this.zzHK;
        }
    }

    public zzhy(Context context, zzqa zzqa) {
        this.mContext = context;
        this.zztr = zzqa;
    }

    protected zzc zza(zzb zzb) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) zzb.zzga().openConnection();
            zzv.zzcJ().zza(this.mContext, this.zztr.zzaZ, false, httpURLConnection);
            Iterator it = zzb.zzgb().iterator();
            while (it.hasNext()) {
                zza zza = (zza) it.next();
                httpURLConnection.addRequestProperty(zza.getKey(), zza.getValue());
            }
            if (!TextUtils.isEmpty(zzb.zzgc())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = zzb.zzgc().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            List arrayList = new ArrayList();
            if (httpURLConnection.getHeaderFields() != null) {
                for (Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
                    for (String zza2 : (List) entry.getValue()) {
                        arrayList.add(new zza((String) entry.getKey(), zza2));
                    }
                }
            }
            return new zzc(this, true, new zzd(zzb.zzfZ(), httpURLConnection.getResponseCode(), arrayList, zzv.zzcJ().zza(new InputStreamReader(httpURLConnection.getInputStream()))), null);
        } catch (Exception e) {
            return new zzc(this, false, null, e.toString());
        }
    }

    protected JSONObject zza(zzd zzd) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", zzd.zzfZ());
            if (zzd.getBody() != null) {
                jSONObject.put("body", zzd.getBody());
            }
            JSONArray jSONArray = new JSONArray();
            for (zza zza : zzd.zzge()) {
                jSONArray.put(new JSONObject().put("key", zza.getKey()).put(Param.VALUE, zza.getValue()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", zzd.getResponseCode());
        } catch (Throwable e) {
            zzpy.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    public void zza(final zzqp zzqp, final Map<String, String> map) {
        zzph.zza(new Runnable(this) {
            final /* synthetic */ zzhy zzHz;

            public void run() {
                zzpy.zzbc("Received Http request.");
                final JSONObject zzaa = this.zzHz.zzaa((String) map.get("http_request"));
                if (zzaa == null) {
                    zzpy.m9e("Response should not be null.");
                } else {
                    zzpi.zzWR.post(new Runnable(this) {
                        final /* synthetic */ C03741 zzHB;

                        public void run() {
                            zzqp.zzb("fetchHttpRequestCompleted", zzaa);
                            zzpy.zzbc("Dispatched http response.");
                        }
                    });
                }
            }
        });
    }

    public JSONObject zzaa(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            Object obj = "";
            try {
                obj = jSONObject.optString("http_request_id");
                zzc zza = zza(zzb(jSONObject));
                if (zza.isSuccess()) {
                    jSONObject2.put("response", zza(zza.zzgd()));
                    jSONObject2.put("success", true);
                    return jSONObject2;
                }
                jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", zza.getReason());
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            zzpy.m9e("The request is not a valid JSON.");
            try {
                return new JSONObject().put("success", false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    protected zzb zzb(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (Throwable e) {
            zzpy.zzb("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new zza(optJSONObject.optString("key"), optJSONObject.optString(Param.VALUE)));
            }
        }
        return new zzb(optString, url, arrayList, optString3);
    }
}
