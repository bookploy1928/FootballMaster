package buu.informatics.s59160378.footballmaster

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Question(val text: String,
               val answers: List<String>,
               val textFact: String
) : Parcelable {

}