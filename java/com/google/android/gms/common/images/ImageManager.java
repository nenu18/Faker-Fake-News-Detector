package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzabv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object zzaCG = new Object();
    private static HashSet<Uri> zzaCH = new HashSet();
    private static ImageManager zzaCI;
    private static ImageManager zzaCJ;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzaCK = Executors.newFixedThreadPool(4);
    private final zzb zzaCL;
    private final zzabv zzaCM;
    private final Map<zza, ImageReceiver> zzaCN;
    private final Map<Uri, ImageReceiver> zzaCO;
    private final Map<Uri, Long> zzaCP;

    @KeepName
    private final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<zza> zzaCQ = new ArrayList();
        final /* synthetic */ ImageManager zzaCR;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.zzaCR = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public void onReceiveResult(int i, Bundle bundle) {
            this.zzaCR.zzaCK.execute(new zzc(this.zzaCR, this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzb(zza zza) {
            com.google.android.gms.common.internal.zzc.zzdn("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzaCQ.add(zza);
        }

        public void zzc(zza zza) {
            com.google.android.gms.common.internal.zzc.zzdn("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzaCQ.remove(zza);
        }

        public void zzwL() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.zzaCR.mContext.sendBroadcast(intent);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    @TargetApi(11)
    private static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private final class zzc implements Runnable {
        private final Uri mUri;
        final /* synthetic */ ImageManager zzaCR;
        private final ParcelFileDescriptor zzaCS;

        public zzc(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzaCR = imageManager;
            this.mUri = uri;
            this.zzaCS = parcelFileDescriptor;
        }

        public void run() {
            com.google.android.gms.common.internal.zzc.zzdo("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.zzaCS != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.zzaCS.getFileDescriptor());
                } catch (Throwable e) {
                    String valueOf = String.valueOf(this.mUri);
                    Log.e("ImageManager", new StringBuilder(String.valueOf(valueOf).length() + 34).append("OOM while loading bitmap for uri: ").append(valueOf).toString(), e);
                    z = true;
                }
                try {
                    this.zzaCS.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.zzaCR.mHandler.post(new zzf(this.zzaCR, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                String valueOf2 = String.valueOf(this.mUri);
                Log.w("ImageManager", new StringBuilder(String.valueOf(valueOf2).length() + 32).append("Latch interrupted while posting ").append(valueOf2).toString());
            }
        }
    }

    private final class zzd implements Runnable {
        final /* synthetic */ ImageManager zzaCR;
        private final zza zzaCT;

        public zzd(ImageManager imageManager, zza zza) {
            this.zzaCR = imageManager;
            this.zzaCT = zza;
        }

        public void run() {
            com.google.android.gms.common.internal.zzc.zzdn("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.zzaCR.zzaCN.get(this.zzaCT);
            if (imageReceiver != null) {
                this.zzaCR.zzaCN.remove(this.zzaCT);
                imageReceiver.zzc(this.zzaCT);
            }
            zza zza = this.zzaCT.zzaCV;
            if (zza.uri == null) {
                this.zzaCT.zza(this.zzaCR.mContext, this.zzaCR.zzaCM, true);
                return;
            }
            Bitmap zza2 = this.zzaCR.zza(zza);
            if (zza2 != null) {
                this.zzaCT.zza(this.zzaCR.mContext, zza2, true);
                return;
            }
            Long l = (Long) this.zzaCR.zzaCP.get(zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzaCT.zza(this.zzaCR.mContext, this.zzaCR.zzaCM, true);
                    return;
                }
                this.zzaCR.zzaCP.remove(zza.uri);
            }
            this.zzaCT.zza(this.zzaCR.mContext, this.zzaCR.zzaCM);
            imageReceiver = (ImageReceiver) this.zzaCR.zzaCO.get(zza.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.zzaCR, zza.uri);
                this.zzaCR.zzaCO.put(zza.uri, imageReceiver);
            }
            imageReceiver.zzb(this.zzaCT);
            if (!(this.zzaCT instanceof com.google.android.gms.common.images.zza.zzc)) {
                this.zzaCR.zzaCN.put(this.zzaCT, imageReceiver);
            }
            synchronized (ImageManager.zzaCG) {
                if (!ImageManager.zzaCH.contains(zza.uri)) {
                    ImageManager.zzaCH.add(zza.uri);
                    imageReceiver.zzwL();
                }
            }
        }
    }

    @TargetApi(14)
    private static final class zze implements ComponentCallbacks2 {
        private final zzb zzaCL;

        public zze(zzb zzb) {
            this.zzaCL = zzb;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
            this.zzaCL.evictAll();
        }

        public void onTrimMemory(int i) {
            if (i >= 60) {
                this.zzaCL.evictAll();
            } else if (i >= 20) {
                this.zzaCL.trimToSize(this.zzaCL.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        final /* synthetic */ ImageManager zzaCR;
        private boolean zzaCU;
        private final CountDownLatch zzth;

        public zzf(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.zzaCR = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzaCU = z;
            this.zzth = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList zza = imageReceiver.zzaCQ;
            int size = zza.size();
            for (int i = 0; i < size; i++) {
                zza zza2 = (zza) zza.get(i);
                if (z) {
                    zza2.zza(this.zzaCR.mContext, this.mBitmap, false);
                } else {
                    this.zzaCR.zzaCP.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zza2.zza(this.zzaCR.mContext, this.zzaCR.zzaCM, false);
                }
                if (!(zza2 instanceof com.google.android.gms.common.images.zza.zzc)) {
                    this.zzaCR.zzaCN.remove(zza2);
                }
            }
        }

        public void run() {
            com.google.android.gms.common.internal.zzc.zzdn("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.zzaCR.zzaCL != null) {
                if (this.zzaCU) {
                    this.zzaCR.zzaCL.evictAll();
                    System.gc();
                    this.zzaCU = false;
                    this.zzaCR.mHandler.post(this);
                    return;
                } else if (z) {
                    this.zzaCR.zzaCL.put(new zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.zzaCR.zzaCO.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzth.countDown();
            synchronized (ImageManager.zzaCG) {
                ImageManager.zzaCH.remove(this.mUri);
            }
        }
    }

    private static final class zzb extends LruCache<zza, Bitmap> {
        public zzb(Context context) {
            super(zzaz(context));
        }

        @TargetApi(11)
        private static int zzaz(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & 1048576) != 0 ? 1 : null) == null || !zzs.zzyx()) ? activityManager.getMemoryClass() : zza.zza(activityManager);
            return (int) (((float) (memoryClass * 1048576)) * 0.33f);
        }

        protected /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            zza(z, (zza) obj, (Bitmap) obj2, (Bitmap) obj3);
        }

        protected /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return zza((zza) obj, (Bitmap) obj2);
        }

        protected int zza(zza zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void zza(boolean z, zza zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, zza, bitmap, bitmap2);
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        if (z) {
            this.zzaCL = new zzb(this.mContext);
            if (zzs.zzyA()) {
                zzwJ();
            }
        } else {
            this.zzaCL = null;
        }
        this.zzaCM = new zzabv();
        this.zzaCN = new HashMap();
        this.zzaCO = new HashMap();
        this.zzaCP = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzg(context, false);
    }

    private Bitmap zza(zza zza) {
        return this.zzaCL == null ? null : (Bitmap) this.zzaCL.get(zza);
    }

    public static ImageManager zzg(Context context, boolean z) {
        if (z) {
            if (zzaCJ == null) {
                zzaCJ = new ImageManager(context, true);
            }
            return zzaCJ;
        }
        if (zzaCI == null) {
            zzaCI = new ImageManager(context, false);
        }
        return zzaCI;
    }

    @TargetApi(14)
    private void zzwJ() {
        this.mContext.registerComponentCallbacks(new zze(this.zzaCL));
    }

    public void loadImage(ImageView imageView, int i) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, i));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        zza zzb = new com.google.android.gms.common.images.zza.zzb(imageView, uri);
        zzb.zzcI(i);
        zza(zzb);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzc(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza zzc = new com.google.android.gms.common.images.zza.zzc(onImageLoadedListener, uri);
        zzc.zzcI(i);
        zza(zzc);
    }

    public void zza(zza zza) {
        com.google.android.gms.common.internal.zzc.zzdn("ImageManager.loadImage() must be called in the main thread");
        new zzd(this, zza).run();
    }
}
