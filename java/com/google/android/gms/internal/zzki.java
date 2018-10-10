package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.C0225R;
import com.google.android.gms.ads.internal.zzv;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.Map;

@zzmb
public class zzki extends zzko {
    private final Context mContext;
    private final Map<String, String> zzFs;
    private String zzLk;
    private long zzLl;
    private long zzLm;
    private String zzLn;
    private String zzLo;

    /* renamed from: com.google.android.gms.internal.zzki$1 */
    class C04081 implements OnClickListener {
        final /* synthetic */ zzki zzLp;

        C04081(zzki zzki) {
            this.zzLp = zzki;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            zzv.zzcJ().zzb(this.zzLp.mContext, this.zzLp.createIntent());
        }
    }

    /* renamed from: com.google.android.gms.internal.zzki$2 */
    class C04092 implements OnClickListener {
        final /* synthetic */ zzki zzLp;

        C04092(zzki zzki) {
            this.zzLp = zzki;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzLp.zzay("Operation denied by user.");
        }
    }

    public zzki(zzqp zzqp, Map<String, String> map) {
        super(zzqp, "createCalendarEvent");
        this.zzFs = map;
        this.mContext = zzqp.zzkR();
        zzgO();
    }

    private String zzav(String str) {
        return TextUtils.isEmpty((CharSequence) this.zzFs.get(str)) ? "" : (String) this.zzFs.get(str);
    }

    private long zzaw(String str) {
        String str2 = (String) this.zzFs.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void zzgO() {
        this.zzLk = zzav("description");
        this.zzLn = zzav("summary");
        this.zzLl = zzaw("start_ticks");
        this.zzLm = zzaw("end_ticks");
        this.zzLo = zzav(Param.LOCATION);
    }

    @TargetApi(14)
    Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra("title", this.zzLk);
        data.putExtra("eventLocation", this.zzLo);
        data.putExtra("description", this.zzLn);
        if (this.zzLl > -1) {
            data.putExtra("beginTime", this.zzLl);
        }
        if (this.zzLm > -1) {
            data.putExtra("endTime", this.zzLm);
        }
        data.setFlags(268435456);
        return data;
    }

    public void execute() {
        if (this.mContext == null) {
            zzay("Activity context is not available.");
        } else if (zzv.zzcJ().zzC(this.mContext).zzfk()) {
            Builder zzB = zzv.zzcJ().zzB(this.mContext);
            Resources resources = zzv.zzcN().getResources();
            zzB.setTitle(resources != null ? resources.getString(C0225R.string.create_calendar_title) : "Create calendar event");
            zzB.setMessage(resources != null ? resources.getString(C0225R.string.create_calendar_message) : "Allow Ad to create a calendar event?");
            zzB.setPositiveButton(resources != null ? resources.getString(C0225R.string.accept) : "Accept", new C04081(this));
            zzB.setNegativeButton(resources != null ? resources.getString(C0225R.string.decline) : "Decline", new C04092(this));
            zzB.create().show();
        } else {
            zzay("This feature is not available on the device.");
        }
    }
}
