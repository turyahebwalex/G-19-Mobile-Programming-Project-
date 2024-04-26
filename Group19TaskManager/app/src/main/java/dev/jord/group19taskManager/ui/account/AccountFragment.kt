package dev.jord.group19taskManager.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import dev.jord.group19taskManager.LoginActivity
import dev.jord.group19taskManager.R
import dev.jord.group19taskManager.databinding.FragmentAccountBinding
import dev.jord.group19taskManager.ui.auth.AuthViewModel

@AndroidEntryPoint
class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!
    val user = Firebase.auth.currentUser
    val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = requireView().findViewById(R.id.nameTextField) as TextView
        textView.text = "Hello, " + user?.email

        binding.logoutButton.setOnClickListener {
            viewModel.logout {
                startActivity(Intent(requireContext(), LoginActivity::class.java))
            }
        }
    }
}