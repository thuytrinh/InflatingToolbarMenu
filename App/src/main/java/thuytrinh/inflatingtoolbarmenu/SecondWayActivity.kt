package thuytrinh.inflatingtoolbarmenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class SecondWayActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (savedInstanceState == null) {
      supportFragmentManager
        .beginTransaction()
        .add(android.R.id.content, SecondWayFragment())
        .commit()
    }
  }
}

class SecondWayFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.main, container, false)
    val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

    toolbar.inflateMenu(R.menu.menu_main)
    toolbar.setOnMenuItemClickListener {
      if (it.itemId == R.id.settings) {
        Toast.makeText(requireActivity(), "Awesome!", Toast.LENGTH_SHORT).show()
      }
      true
    }

    return view
  }
}
