package com.google.android.gms.internal;

import android.os.SystemClock;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class zzv implements zzb {
    private final Map<String, zza> zzav;
    private long zzaw;
    private final File zzax;
    private final int zzay;

    static class zza {
        public String zza;
        public String zzaA;
        public long zzaz;
        public long zzb;
        public long zzc;
        public long zzd;
        public long zze;
        public Map<String, String> zzf;

        private zza() {
        }

        public zza(String str, com.google.android.gms.internal.zzb.zza zza) {
            this.zzaA = str;
            this.zzaz = (long) zza.data.length;
            this.zza = zza.zza;
            this.zzb = zza.zzb;
            this.zzc = zza.zzc;
            this.zzd = zza.zzd;
            this.zze = zza.zze;
            this.zzf = zza.zzf;
        }

        public static zza zzf(InputStream inputStream) throws IOException {
            zza zza = new zza();
            if (zzv.zzb(inputStream) != 538247942) {
                throw new IOException();
            }
            zza.zzaA = zzv.zzd(inputStream);
            zza.zza = zzv.zzd(inputStream);
            if (zza.zza.equals("")) {
                zza.zza = null;
            }
            zza.zzb = zzv.zzc(inputStream);
            zza.zzc = zzv.zzc(inputStream);
            zza.zzd = zzv.zzc(inputStream);
            zza.zze = zzv.zzc(inputStream);
            zza.zzf = zzv.zze(inputStream);
            return zza;
        }

        public boolean zza(OutputStream outputStream) {
            try {
                zzv.zza(outputStream, 538247942);
                zzv.zza(outputStream, this.zzaA);
                zzv.zza(outputStream, this.zza == null ? "" : this.zza);
                zzv.zza(outputStream, this.zzb);
                zzv.zza(outputStream, this.zzc);
                zzv.zza(outputStream, this.zzd);
                zzv.zza(outputStream, this.zze);
                zzv.zza(this.zzf, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                zzs.zzb("%s", e.toString());
                return false;
            }
        }

        public com.google.android.gms.internal.zzb.zza zzb(byte[] bArr) {
            com.google.android.gms.internal.zzb.zza zza = new com.google.android.gms.internal.zzb.zza();
            zza.data = bArr;
            zza.zza = this.zza;
            zza.zzb = this.zzb;
            zza.zzc = this.zzc;
            zza.zzd = this.zzd;
            zza.zze = this.zze;
            zza.zzf = this.zzf;
            return zza;
        }
    }

    private static class zzb extends FilterInputStream {
        private int zzaB;

        private zzb(InputStream inputStream) {
            super(inputStream);
            this.zzaB = 0;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.zzaB++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.zzaB += read;
            }
            return read;
        }
    }

    public zzv(File file) {
        this(file, 5242880);
    }

    public zzv(File file, int i) {
        this.zzav = new LinkedHashMap(16, 0.75f, true);
        this.zzaw = 0;
        this.zzax = file;
        this.zzay = i;
    }

    private void removeEntry(String str) {
        zza zza = (zza) this.zzav.get(str);
        if (zza != null) {
            this.zzaw -= zza.zzaz;
            this.zzav.remove(str);
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> null)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void zza(String str, zza zza) {
        if (this.zzav.containsKey(str)) {
            zza zza2 = (zza) this.zzav.get(str);
            this.zzaw = (zza.zzaz - zza2.zzaz) + this.zzaw;
        } else {
            this.zzaw += zza.zzaz;
        }
        this.zzav.put(str, zza);
    }

    static void zza(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            zza(outputStream, map.size());
            for (Entry entry : map.entrySet()) {
                zza(outputStream, (String) entry.getKey());
                zza(outputStream, (String) entry.getValue());
            }
            return;
        }
        zza(outputStream, 0);
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static int zzb(InputStream inputStream) throws IOException {
        return ((((zza(inputStream) << 0) | 0) | (zza(inputStream) << 8)) | (zza(inputStream) << 16)) | (zza(inputStream) << 24);
    }

    static long zzc(InputStream inputStream) throws IOException {
        return (((((((0 | ((((long) zza(inputStream)) & 255) << null)) | ((((long) zza(inputStream)) & 255) << 8)) | ((((long) zza(inputStream)) & 255) << 16)) | ((((long) zza(inputStream)) & 255) << 24)) | ((((long) zza(inputStream)) & 255) << 32)) | ((((long) zza(inputStream)) & 255) << 40)) | ((((long) zza(inputStream)) & 255) << 48)) | ((((long) zza(inputStream)) & 255) << 56);
    }

    private void zzc(int i) {
        if (this.zzaw + ((long) i) >= ((long) this.zzay)) {
            int i2;
            if (zzs.DEBUG) {
                zzs.zza("Pruning old cache entries.", new Object[0]);
            }
            long j = this.zzaw;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.zzav.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                zza zza = (zza) ((Entry) it.next()).getValue();
                if (zzf(zza.zzaA).delete()) {
                    this.zzaw -= zza.zzaz;
                } else {
                    zzs.zzb("Could not delete cache entry for key=%s, filename=%s", zza.zzaA, zze(zza.zzaA));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.zzaw + ((long) i))) < ((float) this.zzay) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            i2 = i3;
            if (zzs.DEBUG) {
                zzs.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzaw - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static String zzd(InputStream inputStream) throws IOException {
        return new String(zza(inputStream, (int) zzc(inputStream)), "UTF-8");
    }

    private String zze(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static Map<String, String> zze(InputStream inputStream) throws IOException {
        int zzb = zzb(inputStream);
        Map<String, String> emptyMap = zzb == 0 ? Collections.emptyMap() : new HashMap(zzb);
        for (int i = 0; i < zzb; i++) {
            emptyMap.put(zzd(inputStream).intern(), zzd(inputStream).intern());
        }
        return emptyMap;
    }

    public synchronized void initialize() {
        Throwable th;
        if (this.zzax.exists()) {
            File[] listFiles = this.zzax.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    BufferedInputStream bufferedInputStream = null;
                    BufferedInputStream bufferedInputStream2;
                    try {
                        bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                        try {
                            zza zzf = zza.zzf(bufferedInputStream2);
                            zzf.zzaz = file.length();
                            zza(zzf.zzaA, zzf);
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e) {
                            }
                        } catch (IOException e2) {
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    bufferedInputStream = bufferedInputStream2;
                                    th = th3;
                                }
                            }
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e3) {
                                }
                            }
                        }
                    } catch (IOException e4) {
                        bufferedInputStream2 = null;
                        if (file != null) {
                            file.delete();
                        }
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            }
        } else if (!this.zzax.mkdirs()) {
            zzs.zzc("Unable to create cache dir %s", this.zzax.getAbsolutePath());
        }
        return;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e5) {
            }
        }
        throw th;
        throw th;
    }

    public synchronized void remove(String str) {
        boolean delete = zzf(str).delete();
        removeEntry(str);
        if (!delete) {
            zzs.zzb("Could not delete cache entry for key=%s, filename=%s", str, zze(str));
        }
    }

    public synchronized com.google.android.gms.internal.zzb.zza zza(String str) {
        com.google.android.gms.internal.zzb.zza zza;
        zzb zzb;
        IOException e;
        Throwable th;
        zza zza2 = (zza) this.zzav.get(str);
        if (zza2 == null) {
            zza = null;
        } else {
            File zzf = zzf(str);
            try {
                zzb = new zzb(new FileInputStream(zzf));
                try {
                    zza.zzf(zzb);
                    zza = zza2.zzb(zza((InputStream) zzb, (int) (zzf.length() - ((long) zzb.zzaB))));
                    try {
                        zzb.close();
                    } catch (IOException e2) {
                        zza = null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        zzs.zzb("%s: %s", zzf.getAbsolutePath(), e.toString());
                        remove(str);
                        if (zzb != null) {
                            try {
                                zzb.close();
                            } catch (IOException e4) {
                                zza = null;
                            }
                        }
                        zza = null;
                        return zza;
                    } catch (Throwable th2) {
                        th = th2;
                        if (zzb != null) {
                            try {
                                zzb.close();
                            } catch (IOException e5) {
                                zza = null;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                zzb = null;
                zzs.zzb("%s: %s", zzf.getAbsolutePath(), e.toString());
                remove(str);
                if (zzb != null) {
                    zzb.close();
                }
                zza = null;
                return zza;
            } catch (Throwable th3) {
                th = th3;
                zzb = null;
                if (zzb != null) {
                    zzb.close();
                }
                throw th;
            }
        }
        return zza;
    }

    public synchronized void zza(String str, com.google.android.gms.internal.zzb.zza zza) {
        zzc(zza.data.length);
        File zzf = zzf(str);
        try {
            OutputStream fileOutputStream = new FileOutputStream(zzf);
            zza zza2 = new zza(str, zza);
            if (zza2.zza(fileOutputStream)) {
                fileOutputStream.write(zza.data);
                fileOutputStream.close();
                zza(str, zza2);
            } else {
                fileOutputStream.close();
                zzs.zzb("Failed to write header for %s", zzf.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException e) {
            if (!zzf.delete()) {
                zzs.zzb("Could not clean up file %s", zzf.getAbsolutePath());
            }
        }
    }

    public File zzf(String str) {
        return new File(this.zzax, zze(str));
    }
}
