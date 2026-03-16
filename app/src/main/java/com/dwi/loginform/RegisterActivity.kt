package com.dwi.loginform

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {

    private lateinit var tilName: TextInputLayout
    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilPassword: TextInputLayout
    private lateinit var tilConfirmPassword: TextInputLayout
    private lateinit var rgGender: RadioGroup
    private lateinit var tvGenderError: TextView
    private lateinit var spProvince: Spinner
    private lateinit var tvProvinceError: TextView
    private lateinit var tvHobbyError: TextView
    private lateinit var checkboxes: List<CheckBox>

    private val provinces = arrayOf("-- Select Province --", "Aceh", "Bali", "Banten", "Bengkulu", "Gorontalo", "Jakarta", "Jambi", "Jawa Barat", "Jawa Tengah", "Jawa Timur", "Kalimantan Barat", "Kalimantan Selatan", "Kalimantan Tengah", "Kalimantan Timur", "Kalimantan Utara", "Kepulauan Bangka Belitung", "Kepulauan Riau", "Lampung", "Maluku", "Maluku Utara", "Nusa Tenggara Barat", "Nusa Tenggara Timur", "Papua", "Papua Barat", "Papua Barat Daya", "Papua Pegunungan", "Papua Selatan", "Papua Tengah", "Riau", "Sulawesi Barat", "Sulawesi Selatan", "Sulawesi Tengah", "Sulawesi Tenggara", "Sulawesi Utara", "Sumatera Barat", "Sumatera Selatan", "Sumatera Utara", "Yogyakarta")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
        setupSpinner()
        setupRealTimeValidation()

        findViewById<Button>(R.id.btnLoginRedirect).setOnClickListener {
            finish()
        }

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        
        // Click action: Submit form
        btnRegister.setOnClickListener {
            if (validateAll()) {
                showConfirmationDialog()
            }
        }

        // Gesture Interaction: Long Press to clear form
        btnRegister.setOnLongClickListener {
            showClearFormConfirmation()
            true // Menandakan event telah dikonsumsi
        }
    }

    private fun initViews() {
        tilName = findViewById(R.id.tilName)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword)
        rgGender = findViewById(R.id.rgGender)
        tvGenderError = findViewById(R.id.tvGenderError)
        spProvince = findViewById(R.id.spProvince)
        tvProvinceError = findViewById(R.id.tvProvinceError)
        tvHobbyError = findViewById(R.id.tvHobbyError)
        
        checkboxes = listOf(
            findViewById(R.id.cbCoding),
            findViewById(R.id.cbReading),
            findViewById(R.id.cbGaming),
            findViewById(R.id.cbMusic),
            findViewById(R.id.cbSports)
        )
    }

    private fun setupSpinner() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, provinces)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spProvince.adapter = adapter

        spProvince.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position > 0) tvProvinceError.visibility = View.GONE
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setupRealTimeValidation() {
        tilName.editText?.addTextChangedListener { validateName() }
        tilEmail.editText?.addTextChangedListener { validateEmail() }
        tilPassword.editText?.addTextChangedListener { validatePassword() }
        tilConfirmPassword.editText?.addTextChangedListener { validateConfirmPassword() }
        
        rgGender.setOnCheckedChangeListener { _, _ -> 
            tvGenderError.visibility = View.GONE
        }
        
        checkboxes.forEach { cb ->
            cb.setOnCheckedChangeListener { _, _ ->
                if (checkboxes.any { it.isChecked }) {
                    tvHobbyError.visibility = View.GONE
                }
            }
        }
    }

    private fun validateName(): Boolean {
        val name = tilName.editText?.text.toString().trim()
        return if (name.isEmpty()) {
            tilName.error = "Name cannot be empty"
            false
        } else {
            tilName.error = null
            true
        }
    }

    private fun validateEmail(): Boolean {
        val email = tilEmail.editText?.text.toString().trim()
        return when {
            email.isEmpty() -> {
                tilEmail.error = "Email cannot be empty"
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                tilEmail.error = "Invalid email format"
                false
            }
            else -> {
                tilEmail.error = null
                true
            }
        }
    }

    private fun validatePassword(): Boolean {
        val pass = tilPassword.editText?.text.toString()
        return if (pass.isEmpty()) {
            tilPassword.error = "Password cannot be empty"
            false
        } else if (pass.length < 6) {
            tilPassword.error = "Password minimum 6 characters"
            false
        } else {
            tilPassword.error = null
            true
        }
    }

    private fun validateConfirmPassword(): Boolean {
        val pass = tilPassword.editText?.text.toString()
        val confirmPass = tilConfirmPassword.editText?.text.toString()
        return if (confirmPass != pass) {
            tilConfirmPassword.error = "Passwords do not match"
            false
        } else {
            tilConfirmPassword.error = null
            true
        }
    }

    private fun validateGender(): Boolean {
        return if (rgGender.checkedRadioButtonId == -1) {
            tvGenderError.text = "Please select gender"
            tvGenderError.visibility = View.VISIBLE
            false
        } else {
            tvGenderError.visibility = View.GONE
            true
        }
    }

    private fun validateProvince(): Boolean {
        return if (spProvince.selectedItemPosition == 0) {
            tvProvinceError.text = "Please select a province"
            tvProvinceError.visibility = View.VISIBLE
            false
        } else {
            tvProvinceError.visibility = View.GONE
            true
        }
    }

    private fun validateHobbies(): Boolean {
        return if (checkboxes.none { it.isChecked }) {
            tvHobbyError.text = "Please select at least one hobby"
            tvHobbyError.visibility = View.VISIBLE
            false
        } else {
            tvHobbyError.visibility = View.GONE
            true
        }
    }

    private fun validateAll(): Boolean {
        val isNameValid = validateName()
        val isEmailValid = validateEmail()
        val isPassValid = validatePassword()
        val isConfirmValid = validateConfirmPassword()
        val isGenderValid = validateGender()
        val isProvinceValid = validateProvince()
        val isHobbyValid = validateHobbies()

        return isNameValid && isEmailValid && isPassValid && isConfirmValid && isGenderValid && isProvinceValid && isHobbyValid
    }

    private fun showConfirmationDialog() {
        val name = tilName.editText?.text.toString()
        val email = tilEmail.editText?.text.toString()
        val province = spProvince.selectedItem.toString()
        
        AlertDialog.Builder(this)
            .setTitle("Confirm Registration")
            .setMessage("Are you sure you want to register with the following details?\n\nName: $name\nEmail: $email\nProvince: $province")
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
                finish()
            }
            .setNegativeButton("No", null)
            .show()
    }

    private fun showClearFormConfirmation() {
        AlertDialog.Builder(this)
            .setTitle("Clear Form")
            .setMessage("Do you want to clear all fields?")
            .setPositiveButton("Clear") { _, _ ->
                clearForm()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun clearForm() {
        tilName.editText?.text?.clear()
        tilEmail.editText?.text?.clear()
        tilPassword.editText?.text?.clear()
        tilConfirmPassword.editText?.text?.clear()
        rgGender.clearCheck()
        spProvince.setSelection(0)
        checkboxes.forEach { it.isChecked = false }
        
        // Reset errors
        tilName.error = null
        tilEmail.error = null
        tilPassword.error = null
        tilConfirmPassword.error = null
        tvGenderError.visibility = View.GONE
        tvProvinceError.visibility = View.GONE
        tvHobbyError = View.GONE.let { tvHobbyError.visibility = it; tvHobbyError } // Small fix for visibility
        
        Toast.makeText(this, "Form cleared", Toast.LENGTH_SHORT).show()
    }
}