package com.aetoslabs.secondkotlinlecture

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.result_dialouge.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun buClick(view : View){
        var cellId = 0
        val buSelected = view as Button



        when(buSelected.id){
            R.id.bu1 ->
                cellId = 1
            R.id.bu2 ->
                cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }

//        val toast = Toast.makeText(applicationContext, buSelected.id.toString(), Toast.LENGTH_LONG)
//        toast.show()
//        00
        playGame(cellId,buSelected)

    }
    var activeplayer = 1
    var player1= ArrayList<Int>()
    var player2= ArrayList<Int>()
    fun playGame(cellId: Int,buSelected:Button) {


        if(activeplayer == 1){
          buSelected.text= "X"
          buSelected.setBackgroundResource(R.drawable.playeronebox)
            player1.add(cellId)
            activeplayer = 2

        } else
        {
            buSelected.text= "0"
            buSelected.setBackgroundResource(R.drawable.playertwobox)
            player2.add(cellId)
            activeplayer = 1
        }
        buSelected.isEnabled = false
        checkWinner()
    }
    fun checkWinner(){

        var winner= -1

        // row 1 Winner
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){

            winner=1
        }

        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){

            winner=2
        }

        // row 2 Winner
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){

            winner=1
        }

        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){

            winner=2
        }

        // row 3 Winner
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){

            winner=1
        }

        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){

            winner=2
        }

        // col 1 Winner
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){

            winner=1
        }

        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){

            winner=2
        }

        // col 2 Winner
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){

            winner=1
        }

        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){

            winner=2
        }

        // col 3 Winner
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){

            winner=1
        }

        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){

            winner=2
        }
// col & row 123 Winner
//        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
//
//            winner=1
//        }
//
//        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
//
//            winner=2
//        }
//
//        // col & row 321 Winner
//        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
//
//            winner=1
//        }
//
//        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
//
//            winner=2
//        }

        if(winner == 1){
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.result_dialouge)
            dialog.result.text = "Player 1 win the Game"

            dialog.plyBtn.setOnClickListener{

                val intent = Intent(this,MainActivity::class.java)
                finish()
                startActivity(intent)

            }
            dialog.exitBtn.setOnClickListener{
                val intent= Intent(this,StartGameActivity::class.java)
                startActivity(intent)
            }
            dialog.show()

        }else if( winner ==2){
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.result_dialouge)
            dialog.result.text = "Player 2 win the Game"
            dialog.plyBtn.setOnClickListener{
                val intent = Intent(this,MainActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.exitBtn.setOnClickListener{
                val intent= Intent(this,StartGameActivity::class.java)
                startActivity(intent)
            }

            dialog.show()
        }
        //Result Show in Toast
//        if(winner == 1){
//
//            Toast.makeText(this,"Player 1 win the Game", Toast.LENGTH_LONG).show()
//
//        }else if( winner ==2){
//            Toast.makeText(this,"Player 2 win the Game", Toast.LENGTH_LONG).show()
//        }




    }
}