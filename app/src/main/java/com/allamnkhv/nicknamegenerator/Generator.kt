package com.allamnkhv.nicknamegenerator

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_generator.*


class Generator : AppCompatActivity() {
    private var nicknameLength: Int = 8
    private var currentnickname: String = "ВАШ NICKNAME"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generator)
        setSupportActionBar(findViewById(R.id.generator_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        updateCount()
        updatenickname()
    }

    fun generate(view: View) {
        if (lowercase_cb.isChecked or
            uppercase_cb.isChecked or
            digit_cb.isChecked or
            symbol_cb.isChecked
        ) {
            currentnickname = generetor(
                lowercase_cb.isChecked,
                uppercase_cb.isChecked,
                digit_cb.isChecked,
                symbol_cb.isChecked
            )
            updatenickname()
        } else {
            Toast.makeText(this, getString(R.string.choose_one_point), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onUpClick(view: View) {
        if (nicknameLength < 20) {
            nicknameLength += 1
            updateCount()
        }
    }

    fun onDownClick(view: View) {
        if (nicknameLength > 4) {
            nicknameLength -= 1
            updateCount()
        }
    }

    private fun updatenickname() {
        nickname_textView.text = currentnickname
    }

    private fun updateCount() {
        popup_menu.text = nicknameLength.toString()
    }

    fun generetor(LCL_flag: Boolean, UCL_flag: Boolean, N_flag: Boolean, SC_flag: Boolean): String {
        val LOWERCASE_LETTERS = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" ")
        val UPPERCASE_LETTERS = "A B C D E F J H I G K L M N O P Q R S T U V W X Y Z".split(" ")
        val NUMBERS = "1 2 3 4 5 6 7 8 9 0".split(" ")
        val SPECIAL_CHARACTERS = "! @".split(" ")

        val SET_FOR_nickname: MutableList<CharSequence> = mutableListOf()

        if (LCL_flag) {
            SET_FOR_nickname.addAll(LOWERCASE_LETTERS)
        }
        if (UCL_flag) {
            SET_FOR_nickname.addAll(UPPERCASE_LETTERS)
        }
        if (N_flag) {
            SET_FOR_nickname.addAll(NUMBERS)
        }
        if (SC_flag) {
            SET_FOR_nickname.addAll(SPECIAL_CHARACTERS)
        }
        val nickname = (SET_FOR_nickname).shuffled().take(nicknameLength)
        return nickname.joinToString("")
    }

}
