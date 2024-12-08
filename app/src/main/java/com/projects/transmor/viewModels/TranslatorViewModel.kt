package com.projects.transmor.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class TranslatorViewModel: ViewModel() {

    private val engToMorse = mapOf(
        "A" to ".-",
        "B" to "-...",
        "C" to "-.-.",
        "D" to "-..",
        "E" to ".",
        "F" to "..-.",
        "G" to "--.",
        "H" to "....",
        "I" to "..",
        "J" to ".---",
        "K" to "-.-",
        "L" to ".-..",
        "M" to "--",
        "N" to "-.",
        "O" to "---",
        "P" to ".--.",
        "Q" to "--.-",
        "R" to ".-.",
        "S" to "...",
        "T" to "-",
        "U" to "..-",
        "V" to "...-",
        "W" to ".--",
        "X" to "-..-",
        "Y" to "-.--",
        "Z" to "--..",

        "0" to "-----",
        "1" to ".----",
        "2" to "..---",
        "3" to "...--",
        "4" to "....-",
        "5" to ".....",
        "6" to "-....",
        "7" to "--...",
        "8" to "---..",
        "9" to "----.",

        "." to ".-.-.-",
        "," to "--..--",
        "?" to "..--..",
        ":" to "---...",
        "-" to "-....-",
        "@" to ".--.-.",
        "eror" to "........",
    )

    private val morseToEng = engToMorse.map { (key, value) -> value to key }.toMap()

    private var _textNeededToTranslate = MutableStateFlow<String>("")

    val textNeededToTranslate
        get() = _textNeededToTranslate


    private fun translateToMorse(text: String) {
        val buffer = StringBuilder()
        for (word in text.split(Regex("[ \n]"))) {
            for (c in word.toCharArray()) {
                buffer.append(engToMorse[c.uppercase()] ?: "?? ")
                buffer.append(" ")
            }
            //buffer.append(" / ")
        }

        _textNeededToTranslate.value = buffer.toString()
    }

    private fun translateToEng(text: String) {
        val buffer = StringBuilder()
        for (word in text.split(Regex("[\\s\\n]"))) {
            when {
                word.isEmpty() -> continue
                word == "/" || word == "|" -> buffer.append(" ")
                else ->
                    buffer.append(morseToEng[word]?.lowercase() ?: "?? ")
            }
        }

        _textNeededToTranslate.value = buffer.toString()
    }

    fun identifyInputCode(text: String) {
        if(text.startsWith("-") || text.startsWith(".")) {
            translateToEng(text)
        } else {
            translateToMorse(text)
        }
    }
}
