package at.co.netconsulting

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import at.co.netconsulting.databinding.ActivityMainBinding
import at.co.netconsulting.figures.Bomb
import at.co.netconsulting.figures.Captain
import at.co.netconsulting.figures.Colonel
import at.co.netconsulting.figures.Figure
import at.co.netconsulting.figures.Flag
import at.co.netconsulting.figures.General
import at.co.netconsulting.figures.Lieutenant
import at.co.netconsulting.figures.Major
import at.co.netconsulting.figures.Marshal
import at.co.netconsulting.figures.Minor
import at.co.netconsulting.figures.Scout
import at.co.netconsulting.figures.Sergeant
import at.co.netconsulting.figures.Spy
import at.co.netconsulting.general.StaticFields
import java.util.Collections

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var redFiguresOnBoard: ArrayList<Figure> = arrayListOf()
    private var blueFiguresOnBoard: ArrayList<Figure> = arrayListOf()
    private var gameBoard = Array(10) {Array(10) {0} }
    private var isGamePlayable: Boolean = true
    private var isRedTurn: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //generate figures
        initalizePieces()
        //setup game board with figures randomly placed
        setupGameBoard()
        //print gameboard to Log.d
        printGameBoard()

        while(isGamePlayable) {
            generateMove(isRedTurn)
        }
    }

    private fun generateMove(isRedTurn: Boolean) {
        this.isRedTurn = !isRedTurn
    }

    private fun setupGameBoard() {
        shufflePieces(redFiguresOnBoard)
        shufflePieces(blueFiguresOnBoard)

        placeFiguresOnGameBoard(StaticFields.RED)
        placeFiguresOnGameBoard(StaticFields.BLUE)
    }

    private fun printGameBoard() {
        var mString:String? = ""

        gameBoard[4][2] = 999
        gameBoard[4][3] = 999
        gameBoard[4][6] = 999
        gameBoard[4][7] = 999

        gameBoard[5][2] = 999
        gameBoard[5][3] = 999
        gameBoard[5][6] = 999
        gameBoard[5][7] = 999

        for(i in 0..9) {
            for(j in 0..9) {
                mString += " | " + gameBoard[i][j].toString()
                if(j==9) {
                    mString += " |\n"
                    Log.d("GameBoard: ", mString.toString())
                }
            }
        }
    }

    private fun placeFiguresOnGameBoard(color: Int) {
        if(color == 0) {
            for (i in 0..3) {
                for (j in 0..9) {
                    var item: Figure = redFiguresOnBoard.first()
                    redFiguresOnBoard.removeAt(0)
                    gameBoard[i][j] = item.value
                }
            }
        } else {
            for (i in 6..9) {
                for (j in 0..9) {
                    var item: Figure = blueFiguresOnBoard.first()
                    blueFiguresOnBoard.removeAt(0)
                    gameBoard[i][j] = item.value
                }
            }
        }
    }

    private fun shufflePieces(figuresOnBoard: ArrayList<Figure>) {
        Collections.shuffle(figuresOnBoard);
    }
    private fun initalizePieces() {
        //red pieces
        redFiguresOnBoard.add(Flag(StaticFields.RED, 100, 1))

        redFiguresOnBoard.add(Bomb(StaticFields.RED, 111, 1))
        redFiguresOnBoard.add(Bomb(StaticFields.RED, 111, 2))
        redFiguresOnBoard.add(Bomb(StaticFields.RED, 111, 3))
        redFiguresOnBoard.add(Bomb(StaticFields.RED, 111, 4))
        redFiguresOnBoard.add(Bomb(StaticFields.RED, 111, 5))
        redFiguresOnBoard.add(Bomb(StaticFields.RED, 111, 6))

        redFiguresOnBoard.add(Marshal(StaticFields.RED, 101, 1))

        redFiguresOnBoard.add(General(StaticFields.RED, 91, 1))

        redFiguresOnBoard.add(Colonel(StaticFields.RED, 81, 1))
        redFiguresOnBoard.add(Colonel(StaticFields.RED, 81, 2))

        redFiguresOnBoard.add(Major(StaticFields.RED, 71, 1))
        redFiguresOnBoard.add(Major(StaticFields.RED, 71, 2))
        redFiguresOnBoard.add(Major(StaticFields.RED, 71, 3))

        redFiguresOnBoard.add(Captain(StaticFields.RED, 61, 1))
        redFiguresOnBoard.add(Captain(StaticFields.RED, 61, 2))
        redFiguresOnBoard.add(Captain(StaticFields.RED, 61, 3))
        redFiguresOnBoard.add(Captain(StaticFields.RED, 61, 4))

        redFiguresOnBoard.add(Lieutenant(StaticFields.RED, 51, 1))
        redFiguresOnBoard.add(Lieutenant(StaticFields.RED, 51, 2))
        redFiguresOnBoard.add(Lieutenant(StaticFields.RED, 51, 3))
        redFiguresOnBoard.add(Lieutenant(StaticFields.RED, 51, 4))

        redFiguresOnBoard.add(Sergeant(StaticFields.RED, 41, 1))
        redFiguresOnBoard.add(Sergeant(StaticFields.RED, 41, 2))
        redFiguresOnBoard.add(Sergeant(StaticFields.RED, 41, 3))
        redFiguresOnBoard.add(Sergeant(StaticFields.RED, 41, 4))

        redFiguresOnBoard.add(Minor(StaticFields.RED, 31, 1))
        redFiguresOnBoard.add(Minor(StaticFields.RED, 31, 2))
        redFiguresOnBoard.add(Minor(StaticFields.RED, 31, 3))
        redFiguresOnBoard.add(Minor(StaticFields.RED, 31, 4))
        redFiguresOnBoard.add(Minor(StaticFields.RED, 31, 5))

        redFiguresOnBoard.add(Scout(StaticFields.RED, 21, 1))
        redFiguresOnBoard.add(Scout(StaticFields.RED, 21, 2))
        redFiguresOnBoard.add(Scout(StaticFields.RED, 21, 3))
        redFiguresOnBoard.add(Scout(StaticFields.RED, 21, 4))
        redFiguresOnBoard.add(Scout(StaticFields.RED, 21, 5))
        redFiguresOnBoard.add(Scout(StaticFields.RED, 21, 6))
        redFiguresOnBoard.add(Scout(StaticFields.RED, 21, 7))
        redFiguresOnBoard.add(Scout(StaticFields.RED, 21, 8))

        redFiguresOnBoard.add(Spy(StaticFields.RED, 11, 1))

        //blue pieces
        blueFiguresOnBoard.add(Flag(StaticFields.BLUE, 1000, 1))

        blueFiguresOnBoard.add(Bomb(StaticFields.BLUE, 110, 1))
        blueFiguresOnBoard.add(Bomb(StaticFields.BLUE, 110, 2))
        blueFiguresOnBoard.add(Bomb(StaticFields.BLUE, 110, 3))
        blueFiguresOnBoard.add(Bomb(StaticFields.BLUE, 110, 4))
        blueFiguresOnBoard.add(Bomb(StaticFields.BLUE, 110, 5))
        blueFiguresOnBoard.add(Bomb(StaticFields.BLUE, 110, 6))

        blueFiguresOnBoard.add(Marshal(StaticFields.BLUE, 100, 1))

        blueFiguresOnBoard.add(General(StaticFields.BLUE, 90, 1))

        blueFiguresOnBoard.add(Colonel(StaticFields.BLUE, 80, 1))
        blueFiguresOnBoard.add(Colonel(StaticFields.BLUE, 80, 2))

        blueFiguresOnBoard.add(Major(StaticFields.BLUE, 70, 1))
        blueFiguresOnBoard.add(Major(StaticFields.BLUE, 70, 2))
        blueFiguresOnBoard.add(Major(StaticFields.BLUE, 70, 3))

        blueFiguresOnBoard.add(Captain(StaticFields.BLUE, 60, 1))
        blueFiguresOnBoard.add(Captain(StaticFields.BLUE, 60, 2))
        blueFiguresOnBoard.add(Captain(StaticFields.BLUE, 60, 3))
        blueFiguresOnBoard.add(Captain(StaticFields.BLUE, 60, 4))

        blueFiguresOnBoard.add(Lieutenant(StaticFields.BLUE, 50, 1))
        blueFiguresOnBoard.add(Lieutenant(StaticFields.BLUE, 50, 2))
        blueFiguresOnBoard.add(Lieutenant(StaticFields.BLUE, 50, 3))
        blueFiguresOnBoard.add(Lieutenant(StaticFields.BLUE, 50, 4))

        blueFiguresOnBoard.add(Sergeant(StaticFields.BLUE, 40, 1))
        blueFiguresOnBoard.add(Sergeant(StaticFields.BLUE, 40, 2))
        blueFiguresOnBoard.add(Sergeant(StaticFields.BLUE, 40, 3))
        blueFiguresOnBoard.add(Sergeant(StaticFields.BLUE, 40, 4))

        blueFiguresOnBoard.add(Minor(StaticFields.BLUE, 30, 1))
        blueFiguresOnBoard.add(Minor(StaticFields.BLUE, 30, 2))
        blueFiguresOnBoard.add(Minor(StaticFields.BLUE, 30, 3))
        blueFiguresOnBoard.add(Minor(StaticFields.BLUE, 30, 4))
        blueFiguresOnBoard.add(Minor(StaticFields.BLUE, 30, 5))

        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 20, 1))
        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 20, 2))
        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 20, 3))
        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 20, 4))
        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 20, 5))
        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 20, 6))
        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 20, 7))
        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 20, 8))

        blueFiguresOnBoard.add(Spy(StaticFields.BLUE, 10, 1))
    }
}