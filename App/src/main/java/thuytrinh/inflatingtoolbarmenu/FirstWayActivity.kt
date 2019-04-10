package thuytrinh.inflatingtoolbarmenu

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class FirstWayActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (savedInstanceState == null) {
      supportFragmentManager
        .beginTransaction()
        .add(android.R.id.content, FirstWayFragment())
        .commit()
    }
  }
}

class FirstWayFragment : Fragment() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setHasOptionsMenu(true)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.main, container, false)
    val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
    (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
    return view
  }

  override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    inflater.inflate(R.menu.menu_main, menu)
    super.onCreateOptionsMenu(menu, inflater)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item.itemId == R.id.settings) {
      Toast.makeText(requireActivity(), "Awesome!", Toast.LENGTH_SHORT).show()
    }
    return super.onOptionsItemSelected(item)
  }
}
