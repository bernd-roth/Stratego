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
    }

    private fun setupGameBoard() {
        shufflePieces(redFiguresOnBoard)
        shufflePieces(blueFiguresOnBoard)

        placeFiguresOnGameBoard(StaticFields.RED)
        placeFiguresOnGameBoard(StaticFields.BLUE)

        printGameBoard()
    }

    private fun printGameBoard() {
        var mString:String? = ""

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

        redFiguresOnBoard.add(Bomb(StaticFields.RED, 11, 1))
        redFiguresOnBoard.add(Bomb(StaticFields.RED, 11, 2))
        redFiguresOnBoard.add(Bomb(StaticFields.RED, 11, 3))
        redFiguresOnBoard.add(Bomb(StaticFields.RED, 11, 4))
        redFiguresOnBoard.add(Bomb(StaticFields.RED, 11, 5))
        redFiguresOnBoard.add(Bomb(StaticFields.RED, 11, 6))

        redFiguresOnBoard.add(Marshal(StaticFields.RED, 10, 1))

        redFiguresOnBoard.add(General(StaticFields.RED, 9, 1))

        redFiguresOnBoard.add(Colonel(StaticFields.RED, 8, 1))
        redFiguresOnBoard.add(Colonel(StaticFields.RED, 8, 2))

        redFiguresOnBoard.add(Major(StaticFields.RED, 7, 1))
        redFiguresOnBoard.add(Major(StaticFields.RED, 7, 2))
        redFiguresOnBoard.add(Major(StaticFields.RED, 7, 3))

        redFiguresOnBoard.add(Captain(StaticFields.RED, 6, 1))
        redFiguresOnBoard.add(Captain(StaticFields.RED, 6, 2))
        redFiguresOnBoard.add(Captain(StaticFields.RED, 6, 3))
        redFiguresOnBoard.add(Captain(StaticFields.RED, 6, 4))

        redFiguresOnBoard.add(Lieutenant(StaticFields.RED, 5, 1))
        redFiguresOnBoard.add(Lieutenant(StaticFields.RED, 5, 2))
        redFiguresOnBoard.add(Lieutenant(StaticFields.RED, 5, 3))
        redFiguresOnBoard.add(Lieutenant(StaticFields.RED, 5, 4))

        redFiguresOnBoard.add(Sergeant(StaticFields.RED, 4, 1))
        redFiguresOnBoard.add(Sergeant(StaticFields.RED, 4, 2))
        redFiguresOnBoard.add(Sergeant(StaticFields.RED, 4, 3))
        redFiguresOnBoard.add(Sergeant(StaticFields.RED, 4, 4))

        redFiguresOnBoard.add(Minor(StaticFields.RED, 3, 1))
        redFiguresOnBoard.add(Minor(StaticFields.RED, 3, 2))
        redFiguresOnBoard.add(Minor(StaticFields.RED, 3, 3))
        redFiguresOnBoard.add(Minor(StaticFields.RED, 3, 4))
        redFiguresOnBoard.add(Minor(StaticFields.RED, 3, 5))

        redFiguresOnBoard.add(Scout(StaticFields.RED, 2, 1))
        redFiguresOnBoard.add(Scout(StaticFields.RED, 2, 2))
        redFiguresOnBoard.add(Scout(StaticFields.RED, 2, 3))
        redFiguresOnBoard.add(Scout(StaticFields.RED, 2, 4))
        redFiguresOnBoard.add(Scout(StaticFields.RED, 2, 5))
        redFiguresOnBoard.add(Scout(StaticFields.RED, 2, 6))
        redFiguresOnBoard.add(Scout(StaticFields.RED, 2, 7))
        redFiguresOnBoard.add(Scout(StaticFields.RED, 2, 8))

        redFiguresOnBoard.add(Spy(StaticFields.RED, 1, 1))

        //blue pieces
        blueFiguresOnBoard.add(Flag(StaticFields.BLUE, 100, 1))

        blueFiguresOnBoard.add(Bomb(StaticFields.BLUE, 11, 1))
        blueFiguresOnBoard.add(Bomb(StaticFields.BLUE, 11, 2))
        blueFiguresOnBoard.add(Bomb(StaticFields.BLUE, 11, 3))
        blueFiguresOnBoard.add(Bomb(StaticFields.BLUE, 11, 4))
        blueFiguresOnBoard.add(Bomb(StaticFields.BLUE, 11, 5))
        blueFiguresOnBoard.add(Bomb(StaticFields.BLUE, 11, 6))

        blueFiguresOnBoard.add(Marshal(StaticFields.BLUE, 10, 1))

        blueFiguresOnBoard.add(General(StaticFields.BLUE, 9, 1))

        blueFiguresOnBoard.add(Colonel(StaticFields.BLUE, 8, 1))
        blueFiguresOnBoard.add(Colonel(StaticFields.BLUE, 8, 2))

        blueFiguresOnBoard.add(Major(StaticFields.BLUE, 7, 1))
        blueFiguresOnBoard.add(Major(StaticFields.BLUE, 7, 2))
        blueFiguresOnBoard.add(Major(StaticFields.BLUE, 7, 3))

        blueFiguresOnBoard.add(Captain(StaticFields.BLUE, 6, 1))
        blueFiguresOnBoard.add(Captain(StaticFields.BLUE, 6, 2))
        blueFiguresOnBoard.add(Captain(StaticFields.BLUE, 6, 3))
        blueFiguresOnBoard.add(Captain(StaticFields.BLUE, 6, 4))

        blueFiguresOnBoard.add(Lieutenant(StaticFields.BLUE, 5, 1))
        blueFiguresOnBoard.add(Lieutenant(StaticFields.BLUE, 5, 2))
        blueFiguresOnBoard.add(Lieutenant(StaticFields.BLUE, 5, 3))
        blueFiguresOnBoard.add(Lieutenant(StaticFields.BLUE, 5, 4))

        blueFiguresOnBoard.add(Sergeant(StaticFields.BLUE, 4, 1))
        blueFiguresOnBoard.add(Sergeant(StaticFields.BLUE, 4, 2))
        blueFiguresOnBoard.add(Sergeant(StaticFields.BLUE, 4, 3))
        blueFiguresOnBoard.add(Sergeant(StaticFields.BLUE, 4, 4))

        blueFiguresOnBoard.add(Minor(StaticFields.BLUE, 3, 1))
        blueFiguresOnBoard.add(Minor(StaticFields.BLUE, 3, 2))
        blueFiguresOnBoard.add(Minor(StaticFields.BLUE, 3, 3))
        blueFiguresOnBoard.add(Minor(StaticFields.BLUE, 3, 4))
        blueFiguresOnBoard.add(Minor(StaticFields.BLUE, 3, 5))

        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 2, 1))
        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 2, 2))
        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 2, 3))
        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 2, 4))
        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 2, 5))
        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 2, 6))
        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 2, 7))
        blueFiguresOnBoard.add(Scout(StaticFields.BLUE, 2, 8))

        blueFiguresOnBoard.add(Spy(StaticFields.BLUE, 1, 1))
    }
}