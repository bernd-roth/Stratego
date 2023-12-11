package at.co.netconsulting

import android.os.Bundle
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

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val figuresOnBoard = ArrayList<Figure>()
    var gameBoard = Array(10) {Array(10) {0} }

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
        setupGameBoard()
    }

    private fun setupGameBoard() {
        for(figure in figuresOnBoard) {
            //gameBoard.set()
        }
    }

    private fun initalizePieces() {
        //red pieces
        figuresOnBoard.add(Flag(StaticFields.RED, 100, 1))
        figuresOnBoard.add(Bomb(StaticFields.RED, 11, 6))
        figuresOnBoard.add(Marshal(StaticFields.RED, 10, 1))
        figuresOnBoard.add(General(StaticFields.RED, 9, 1))
        figuresOnBoard.add(Colonel(StaticFields.RED, 8, 2))
        figuresOnBoard.add(Major(StaticFields.RED, 7, 3))
        figuresOnBoard.add(Captain(StaticFields.RED, 6, 4))
        figuresOnBoard.add(Lieutenant(StaticFields.RED, 5, 4))
        figuresOnBoard.add(Sergeant(StaticFields.RED, 4, 4))
        figuresOnBoard.add(Minor(StaticFields.RED, 3, 5))
        figuresOnBoard.add(Scout(StaticFields.RED, 2, 8))
        figuresOnBoard.add(Spy(StaticFields.RED, 1, 1))

        //blue pieces
        figuresOnBoard.add(Flag(StaticFields.BLUE, 100, 1))
        figuresOnBoard.add(Bomb(StaticFields.BLUE, 11, 6))
        figuresOnBoard.add(Marshal(StaticFields.BLUE, 10, 1))
        figuresOnBoard.add(General(StaticFields.BLUE, 9, 1))
        figuresOnBoard.add(Colonel(StaticFields.BLUE, 8, 2))
        figuresOnBoard.add(Major(StaticFields.BLUE, 7, 3))
        figuresOnBoard.add(Captain(StaticFields.BLUE, 6, 4))
        figuresOnBoard.add(Lieutenant(StaticFields.BLUE, 5, 4))
        figuresOnBoard.add(Sergeant(StaticFields.BLUE, 4, 4))
        figuresOnBoard.add(Minor(StaticFields.BLUE, 3, 5))
        figuresOnBoard.add(Scout(StaticFields.BLUE, 2, 8))
        figuresOnBoard.add(Spy(StaticFields.BLUE, 1, 1))
    }
}