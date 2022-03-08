package pimienta.julian.popcornfactory

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class SeatSelection : AppCompatActivity() {

    private var selectedSeat = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val title = findViewById<TextView>(R.id.titleSeats)
        var posMovie = -1
        selectedSeat = -1

        val bundle = intent.extras

        if (bundle != null) {
            title.text = bundle.getString("name")
            posMovie = bundle.getInt("id")

        }
        val confirm: Button = findViewById<Button>(R.id.confirm)

        confirm.setOnClickListener {

            if (selectedSeat == -1) {
                Toast.makeText(this, "Please select a seat to continue.", Toast.LENGTH_LONG).show()
            } else {
                val intent: Intent = Intent(this, ConfirmationMovie::class.java)

                intent.putExtra("seatNumber", selectedSeat)
                intent.putExtra("titlemovie",title.text)

                this.startActivityForResult(intent, 1)
            }


        }

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)


        row1.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1) {
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(checkedId)
                selectedSeat = checkedId
            }

        }

        row2.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1) {
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedId)
                selectedSeat = checkedId
            }

        }

        row3.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1) {
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()

                row3.check(checkedId)
                selectedSeat = checkedId
            }

        }

        row4.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1) {
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()

                row4.check(checkedId)
                selectedSeat = checkedId
            }

        }
    }


    override fun onActivityResult(request: Int, result: Int, data: Intent?) {
        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        super.onActivityResult(request, result, data)

        if (request == 1) {

            if (result == Activity.RESULT_OK) {
                if (data != null) {
                    var bundle = data.extras

                    if (bundle != null) {
                        var seat = bundle.getInt("seatReserved")

                        if (seat <= 5) {
                            row1.getChildAt(seat - 1).setBackgroundResource(R.drawable.radio_disabled)
                            row1.getChildAt(seat - 1).isEnabled = false
                        } else if (seat <= 10) {
                            row2.getChildAt(seat - 6).setBackgroundResource(R.drawable.radio_disabled)
                            row2.getChildAt(seat - 6).isEnabled = false
                        } else if (seat <= 15) {
                            row3.getChildAt(seat - 11).setBackgroundResource(R.drawable.radio_disabled)
                            row3.getChildAt(seat - 11).isEnabled = false
                        } else {
                            row4.getChildAt(seat - 16).setBackgroundResource(R.drawable.radio_disabled)
                            row4.getChildAt(seat - 16).isEnabled = false
                        }
                    }
                    row1.clearCheck()
                    row2.clearCheck()
                    row3.clearCheck()
                    row4.clearCheck()
                    selectedSeat = -1
                }
            }
        }
    }

}