package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzabc;
import com.google.android.gms.internal.zzabl;
import com.google.android.gms.internal.zzzx;

public final class PendingResults {

    private static final class zza<R extends Result> extends zzzx<R> {
        private final R zzayc;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.zzayc = r;
        }

        protected R zzc(Status status) {
            if (status.getStatusCode() == this.zzayc.getStatus().getStatusCode()) {
                return this.zzayc;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private static final class zzb<R extends Result> extends zzzx<R> {
        private final R zzayd;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.zzayd = r;
        }

        protected R zzc(Status status) {
            return this.zzayd;
        }
    }

    private static final class zzc<R extends Result> extends zzzx<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected R zzc(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        PendingResult zzabl = new zzabl(Looper.getMainLooper());
        zzabl.cancel();
        return zzabl;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        zzac.zzb((Object) r, (Object) "Result must not be null");
        zzac.zzb(r.getStatus().getStatusCode() == 16, (Object) "Status code must be CommonStatusCodes.CANCELED");
        PendingResult zza = new zza(r);
        zza.cancel();
        return zza;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        zzac.zzb((Object) r, (Object) "Result must not be null");
        PendingResult zzc = new zzc(null);
        zzc.zzb(r);
        return new zzabc(zzc);
    }

    public static PendingResult<Status> immediatePendingResult(Status status) {
        zzac.zzb((Object) status, (Object) "Result must not be null");
        PendingResult zzabl = new zzabl(Looper.getMainLooper());
        zzabl.zzb(status);
        return zzabl;
    }

    public static <R extends Result> PendingResult<R> zza(R r, GoogleApiClient googleApiClient) {
        zzac.zzb((Object) r, (Object) "Result must not be null");
        zzac.zzb(!r.getStatus().isSuccess(), (Object) "Status code must not be SUCCESS");
        PendingResult zzb = new zzb(googleApiClient, r);
        zzb.zzb(r);
        return zzb;
    }

    public static PendingResult<Status> zza(Status status, GoogleApiClient googleApiClient) {
        zzac.zzb((Object) status, (Object) "Result must not be null");
        PendingResult zzabl = new zzabl(googleApiClient);
        zzabl.zzb(status);
        return zzabl;
    }

    public static <R extends Result> OptionalPendingResult<R> zzb(R r, GoogleApiClient googleApiClient) {
        zzac.zzb((Object) r, (Object) "Result must not be null");
        PendingResult zzc = new zzc(googleApiClient);
        zzc.zzb(r);
        return new zzabc(zzc);
    }
}
