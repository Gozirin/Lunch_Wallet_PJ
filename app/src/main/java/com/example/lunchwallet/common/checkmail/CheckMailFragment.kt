package com.example.lunchwallet.common.checkmail

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentCheckMailBinding

class CheckMailFragment : Fragment() {

    private var _binding: FragmentCheckMailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCheckMailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.consumerCheckMailButton.setOnClickListener {
            launchEmailApp()
           // findNavController().navigate(R.id.confirmMailFragment)
        }
    }

    private fun launchEmailApp() {
        val intent = Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_EMAIL);
        try {
            this.startActivity(intent);
        }catch (e: ActivityNotFoundException) {
            //do what?
        }
    }
}
