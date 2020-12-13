package com.ekadsoft.pharmae4.Utilities

import java.util.regex.Pattern

object Validations {
    /**
     * This method is used to validate mobile.
     * called when handle validation of user mobile.
     *
     * @param name of mobile user
     */
    fun isValidName(name: String): Boolean {
        return name.length > 2
    }

    /**
     * This method is used to validate mobile.
     * called when handle validation of user mobile.
     *
     * @param mobile of mobile user
     */
    fun isValidMobile(mobile: String): Boolean {
        var isValid = false
        val expression = "[0-9\\+]+"
        val inputStr: CharSequence = mobile
        val pattern =
            Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(inputStr)
        if (matcher.matches()) {
            isValid = true
        }
        return mobile.length >= 9 && isValid
    }

    fun isValiNumber(num: String): Boolean {
        var isValid = false
        val expression = "[0-9\\+]+"
        val inputStr: CharSequence = num
        val pattern =
            Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(inputStr)
        if (matcher.matches()) {
            isValid = true
        }
        return num.length >= 0 && isValid
    }

    fun isValidCode(code: String): Boolean {
        return code.length == 0
    }

    /**
     * This method is used to validate password.
     * called when handle validation of user password.
     *
     * @param password of password user
     */
    fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }

    fun isMatchPassword(password: String, confPassword: String): Boolean {
        return confPassword == password
    }

    fun isValidSpinnerItem(pos: Int): Boolean {
        return pos != 0
    }

    fun isValidGender(gender: String): Boolean {
        return gender.toLowerCase() != "Gender".toLowerCase()
    }

    fun isValidDate(date: String): Boolean {
        return date.length > 0
    }

    fun isValidStr(str: String): Boolean {
        return str.length > 0
    }

    /**
     * This method is used to validate email.
     * called when handle validation of user email.
     *
     * @param email of email user
     */
    fun isValidEmail(email: String): Boolean {
        var isValid = false
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val inputStr: CharSequence = email
        val pattern =
            Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(inputStr)
        if (matcher.matches()) {
            isValid = true
        }
        return isValid
    }
}