- **Sistem Registrasi**:
    - Input: Nama, Email, Password, & Konfirmasi Password.
    - Pemilihan: Jenis Kelamin (RadioGroup), Provinsi (Custom Spinner), dan Hobi (Checkbox).
- **Validasi Real-Time**:
    - Peringatan error muncul secara instan saat pengguna mengetik.
    - Validasi format email dan kecocokan password secara langsung.
- **Interaksi Gestur**:
    - **Long Press** pada tombol Register untuk fitur *Clear Form* (hapus semua input).
- **Dialog Interaktif**:
    - AlertDialog konfirmasi sebelum data dikirim.
    - AlertDialog konfirmasi untuk pengosongan form.
-
## 📸 Cuplikan Layar

| Login Page | Register Page | Validation & Dialog |
|---|---|---|
| ![Login](https://via.placeholder.com/200x400?text=Login+Screen) | ![Register](https://via.placeholder.com/200x400?text=Register+Screen) | ![Dialog](https://via.placeholder.com/200x400?text=Dialog+Confirmation) |
*(Ganti URL gambar di atas dengan screenshot asli aplikasi Anda)*

## 🛠️ Teknologi yang Digunakan

- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: Material Design Components (MDC)
- **Layout**: ConstraintLayout & ScrollView
- **Tools**: Android Studio (Ladybug atau versi terbaru)
- **Minimum SDK**: API 24 (Android 7.0)

## 🚀 Cara Menjalankan

1. Clone repositori ini:
2. Buka proyek di **Android Studio**.
3. Tunggu proses **Gradle Sync** selesai.
4. Jalankan aplikasi di Emulator atau perangkat fisik Android.

## 📂 Struktur Proyek Utama

- `MainActivity.kt`: Menangani logika halaman Login dan navigasi.
- `RegisterActivity.kt`: Menangani logika pendaftaran, validasi real-time, dan gestur.
- `res/layout/`: Berisi file XML untuk tampilan UI minimalis.
- `res/values/strings.xml`: Kamus data untuk semua teks dalam aplikasi.

## 🤝 Kontribusi

Kontribusi selalu terbuka! Jika Anda memiliki saran atau ingin menambahkan fitur baru, silakan buat *Pull Request* atau ajukan *Issue*.

---
Dibuat dengan ❤️ oleh Dwi Budi Fitri Adi
