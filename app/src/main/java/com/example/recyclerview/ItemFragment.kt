package com.example.recyclerview

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.recyclerview.dummy.DummyContent
import com.example.recyclerview.dummy.DummyContent.DummyItem
import com.example.recycleview.MyItemRecyclerViewAdapter

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ItemFragment.OnListFragmentInteractionListener] interface.
 */
class ItemFragment : Fragment() {

    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        val names = listOf("Superman","Spiderman","Wonderwoman","Thor","Batman")
        val powers = listOf(100,90,89,92,70)
        val genders = listOf("M","M","F","M","M")

        val image = intArrayOf(R.drawable.superman ,R.drawable.spiderman, R.drawable.wonderwoman ,R.drawable.thor ,R.drawable.batman)
        val superheroes = ArrayList<HashMap<String, Any>>()

        for(i in 0..names.size-1) {

            val heroHashMap:HashMap<String, Any> = HashMap<String, Any>()

            heroHashMap.put("name", names[i])
            heroHashMap.put("power", powers[i])
            heroHashMap.put("gender", genders[i])
            heroHashMap.put("image", image[i])

            superheroes.add(heroHashMap)
        }
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = MyItemRecyclerViewAdapter(activity as MainActivity, superheroes)
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
