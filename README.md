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
## Screenshot

| Login Page | Register Page | Validation & Dialog |
|---|---|---|
| <img width="200"  alt="image" src="https://github.com/user-attachments/assets/fcda877b-90e4-4cc4-8483-6d113497880a" />
 | <img width="200" alt="image" src="https://github.com/user-attachments/assets/b610f0fb-cf5c-418e-8658-701e00db5992" />
 | <img width="200" alt="image" src="https://github.com/user-attachments/assets/201ae703-dc02-43d1-adcd-2b1ad0f2a4f3" />

## Teknologi yang Digunakan

- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: Material Design Components (MDC)
- **Layout**: ConstraintLayout & ScrollView
- **Tools**: Android Studio (Ladybug atau versi terbaru)
- **Minimum SDK**: API 24 (Android 7.0)


## Struktur Folder

- `MainActivity.kt`: Menangani logika halaman Login dan navigasi.
- `RegisterActivity.kt`: Menangani logika pendaftaran, validasi real-time, dan gestur.
- `res/layout/`: Berisi file XML untuk tampilan.
- `res/values/strings.xml`: Hanya kamus.

---
