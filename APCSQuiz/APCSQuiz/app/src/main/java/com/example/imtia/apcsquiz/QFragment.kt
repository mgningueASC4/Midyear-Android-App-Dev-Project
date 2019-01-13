package com.example.imtia.apcsquiz

import android.content.Context
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
//import com.bumptech.glide.annotation.GlideModule
//import com.bumptech.glide.module.AppGlideModule


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [QFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [QFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class QFragment : Fragment() {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var i:ImageView? = null
    private var listener: OnFragmentInteractionListener? = null
    private var m: FragmentManager?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //i = view?.findViewById<ImageView>(R.id.imageView)
        //Glide.with(this).load(R.drawable.betternextbtn).asGif().crossFade().into(i)
        //Glide.with(this).load(R.drawable.betternextbtn).asGif().crossFade().into(i)
        return inflater.inflate(R.layout.fragment_q, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    fun clickNextButton(v:View){
        m = getFragmentManager()
        var t:FragmentTransaction? = m?.beginTransaction()
        var fq:QFragment = QFragment()
        var fr:r = (r())
        t?.detach(fq)
        t?.attach(fr)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        fun newInstance() = QFragment()
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QFragment.
         */
        // TODO: Rename and change types and number of parameters
        /*@JvmStatic
        fun newInstance(param1: String, param2: String) =
                QFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }*/
    }
}
