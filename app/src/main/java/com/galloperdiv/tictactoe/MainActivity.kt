package com.galloperdiv.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view:View) {
        val btnSelected = view as Button
        var cellID = 0

        when (btnSelected.id) {
            R.id.btn1 -> cellID = 1
            R.id.btn2 -> cellID = 2
            R.id.btn3 -> cellID = 3
            R.id.btn4 -> cellID = 4
            R.id.btn5 -> cellID = 5
            R.id.btn6 -> cellID = 6
            R.id.btn7 -> cellID = 7
            R.id.btn8 -> cellID = 8
            R.id.btn9 -> cellID = 9
        }
        //Toast.makeText(this, "ID : " + cellID, Toast.LENGTH_LONG).show()
        playGame(cellID, btnSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var ActivePlayer = 1

    fun playGame(cellID:Int, btnSelected:Button) {
        if (ActivePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            ActivePlayer = 2
        } else {
            btnSelected.text = "O"
            btnSelected.setBackgroundColor(Color.BLUE)
            player2.add(cellID)
            ActivePlayer = 1
        }

        btnSelected.isEnabled=false
        CheckWinner()



    }

    fun CheckWinner() {
        var winner = -1

        // Row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner = 1
        if (player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner = 2

        // Row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner = 1
        if (player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner = 2

        // Row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner = 1
        if (player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner = 2

        // Col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner = 1
        if (player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner = 2

        // Col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner = 1
        if (player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner = 2

        // Col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner = 1
        if (player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner = 2

        // Diagonal 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9))
            winner = 1
        if (player2.contains(1) && player2.contains(5) && player2.contains(9))
            winner = 2

        // Diagonal 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7))
            winner = 1
        if (player2.contains(3) && player2.contains(5) && player2.contains(7))
            winner = 2

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
                winner = -1
            }
            else {
                Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
                winner = -1
            }
        }

    }
}