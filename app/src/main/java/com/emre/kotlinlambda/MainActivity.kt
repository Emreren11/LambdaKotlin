package com.emre.kotlinlambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Lambda Expressions -> Bir fonksiyonu tek satırda yazmak için kullanılabilir


        //Klasik Yöntem

        fun printString(myString: String) {
            println(myString)
        }

        printString("Test String")

        //Lambda Yöntemi
        val testString = {myString: String -> println(myString)}
        testString("Lambda String")

        val multiplyLambda = {a: Int, b:Int -> a * b}
        println(multiplyLambda(4,5))

        val multiplyLambda2: (Int, Int) -> Int = {a, b, -> a * b}
        println(multiplyLambda2(5, 5))

        //asynchronus -> senkronize olmayan işlemler (bi işlem bitmeden başka işlem yapma)
        //Lambda genelde internetten veri çekme işlemlerinde kullanılır

        // İnternetten veri geldiğinde (işlem tamamlandığında) yazılacak fonksiyonlar -> callbak funciyon, listener function, completion function

        fun downloadMusicians(url: String, completion: () -> Unit) {
            // url gidilecek indirilecek
            // data gelmiş olacak
            // en sonunda completion çalışacak
            completion()
        }

        downloadMusicians("metallica.com", {
            // işlem yapıldıktan sonra çalışacak kod bloğu
            println("completed && ready")
        })
    }
}